package com.exchange.conversionservice.service;

import com.exchange.conversionservice.dto.ExchangeRateDto;
import com.exchange.conversionservice.dto.ExchangeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "exchange")
public interface ExchangeServiceProxy {
    @GetMapping("from/{from}/to/{to}")
    ExchangeResponseDto exchange(@PathVariable("from") String from, @PathVariable("to") String to);

    @GetMapping("{code}")
    ExchangeRateDto getRate(@PathVariable("code") String code);
}
