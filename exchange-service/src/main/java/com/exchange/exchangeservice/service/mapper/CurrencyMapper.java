package com.exchange.exchangeservice.service.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.exchange.exchangeservice.dto.NbuResponseDto;
import com.exchange.exchangeservice.dto.RateResponseDto;
import com.exchange.exchangeservice.entity.Currency;
import org.springframework.stereotype.Service;

@Service
public class CurrencyMapper {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

    public Currency rateResponseBeenToCurrency(NbuResponseDto nbuResponseDto) {
        Currency currency = new Currency();
        currency.setId((long) nbuResponseDto.getR030());
        currency.setName(nbuResponseDto.getTxt());
        currency.setRate(nbuResponseDto.getRate());
        currency.setCc(nbuResponseDto.getCc());
        currency.setExchangeDate(LocalDate.parse(nbuResponseDto.getExchangedate(), formatter));
        return currency;
    }

    public RateResponseDto currencyToRateResponseDto(Currency currency) {
        RateResponseDto response = new RateResponseDto();
        response.setR030(currency.getId().intValue());
        response.setName(currency.getName());
        response.setRate(currency.getRate());
        return response;
    }
}
