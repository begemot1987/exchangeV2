package com.exchange.conversionservice.dto;

import java.math.BigDecimal;

public class ExchangeRateDto {
    private Integer r030;
    private String name;
    private BigDecimal rate;

    public ExchangeRateDto() {
    }

    public Integer getR030() {
        return r030;
    }

    public void setR030(Integer r030) {
        this.r030 = r030;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
