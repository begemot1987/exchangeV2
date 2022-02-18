package com.exchange.exchangeservice.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.exchange.exchangeservice.dto.NbuResponseDto;
import com.exchange.exchangeservice.repository.CurrencyRepository;
import com.exchange.exchangeservice.service.mapper.CurrencyMapper;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableScheduling
public class RateUpdater {
    private final CurrencyMapper mapper;
    private final CurrencyRepository repository;
    private final Environment environment;

    public RateUpdater(CurrencyRepository repository,
                       Environment environment, CurrencyMapper mapper) {
        this.repository = repository;
        this.environment = environment;
        this.mapper = mapper;
    }

    @Scheduled(cron = "0 * * * * * ", zone = "Europe/Kiev")
    private void updateRate() {
        List<NbuResponseDto> currentRates = List.of(Objects.requireNonNull(new RestTemplate()
                .getForObject(Objects.requireNonNull(environment.getProperty("user.exchange.rate.path")),
                        NbuResponseDto[].class)));
        repository.saveAll(currentRates
                .stream()
                .map(mapper::rateResponseBeenToCurrency)
                .collect(Collectors.toList()));
    }
}
