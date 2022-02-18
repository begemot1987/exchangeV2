package com.exchange.conversionservice.dto;

import java.math.BigDecimal;

public class ExchangeResponseDto {
    private String from;
    private String to;
    private BigDecimal rate;

    public ExchangeResponseDto() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
