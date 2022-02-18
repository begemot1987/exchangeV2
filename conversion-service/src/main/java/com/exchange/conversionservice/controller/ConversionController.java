package com.exchange.conversionservice.controller;

import java.math.BigDecimal;
import com.exchange.conversionservice.dto.ConversionResponseDto;
import com.exchange.conversionservice.dto.ExchangeRateDto;
import com.exchange.conversionservice.dto.ExchangeResponseDto;
import com.exchange.conversionservice.dto.TransactionResponseDto;
import com.exchange.conversionservice.service.ConversionService;
import com.exchange.conversionservice.service.ExchangeServiceProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {
    private final ExchangeServiceProxy exchangeProxy;
    private final ConversionService conversionService;

    public ConversionController(ExchangeServiceProxy exchangeProxy, ConversionService conversionService) {
        this.exchangeProxy = exchangeProxy;
        this.conversionService = conversionService;
    }

    @GetMapping("/convert/from{from}/to/{to}/{quantity}/")
    public ConversionResponseDto convert(@PathVariable String from,
                                         @PathVariable String to,
                                         @PathVariable BigDecimal quantity) {
        ExchangeResponseDto exchangeResponseDto = exchangeProxy.exchange(from, to);
        ConversionResponseDto response = conversionService.getConvertedValue(exchangeResponseDto, quantity);
        return response;
    }

    @GetMapping("sell/{currency}/amount/{amount}")
    public TransactionResponseDto sellCurrency(@PathVariable String currency, @PathVariable BigDecimal amount) {
        ExchangeRateDto rateDto = exchangeProxy.getRate(currency);
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setR030(rateDto.getR030());
        transactionResponseDto.setName(rateDto.getName());
        transactionResponseDto.setRate(rateDto.getRate());
        transactionResponseDto.setAmount(amount);
        transactionResponseDto.setResultAmount(amount.multiply(rateDto.getRate()));
        return transactionResponseDto;
    }
}
