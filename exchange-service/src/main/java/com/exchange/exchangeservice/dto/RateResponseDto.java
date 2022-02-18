package com.exchange.exchangeservice.dto;

import java.math.BigDecimal;

public class RateResponseDto {
    private int r030;
    private String name;
    private BigDecimal rate;

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
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
