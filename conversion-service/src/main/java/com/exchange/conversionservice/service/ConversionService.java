package com.exchange.conversionservice.service;

import java.math.BigDecimal;
import com.exchange.conversionservice.dto.ConversionResponseDto;
import com.exchange.conversionservice.dto.ExchangeResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    public ConversionResponseDto getConvertedValue(ExchangeResponseDto exchangeDto, BigDecimal value) {
        ConversionResponseDto conversionDto = new ConversionResponseDto();
        conversionDto.setFrom(exchangeDto.getFrom());
        conversionDto.setTo(exchangeDto.getTo());
        conversionDto.setRate(exchangeDto.getRate());
        conversionDto.setQuantity(value);
        conversionDto.setTotalAmount(conversionDto.getRate().multiply(value));
        return conversionDto;
    }
}
