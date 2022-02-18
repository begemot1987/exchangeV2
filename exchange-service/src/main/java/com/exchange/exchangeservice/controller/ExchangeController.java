package com.exchange.exchangeservice.controller;

import com.exchange.exchangeservice.dto.ExchangeResponseDto;
import com.exchange.exchangeservice.dto.RateResponseDto;
import com.exchange.exchangeservice.service.CurrencyService;
import com.exchange.exchangeservice.service.mapper.CurrencyMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private final CurrencyMapper mapper;
    private final CurrencyService currencyService;

    public ExchangeController(CurrencyMapper mapper, CurrencyService currencyService) {
        this.mapper = mapper;
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String test() {
        return "You are here";
    }

    @GetMapping("/{code}")
    public RateResponseDto getByCurrencyCode(@PathVariable String code) {
        return mapper.currencyToRateResponseDto(currencyService.findByCurrencyCode(code));
    }

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeResponseDto exchange(@PathVariable String from, @PathVariable String to) {
        ExchangeResponseDto response = new ExchangeResponseDto();
        response.setFrom(from);
        response.setTo(to);
        response.setRate(currencyService.exchange(from, to));
        return response;
    }
}
