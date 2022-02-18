package com.exchange.conversionservice.dto;

import java.math.BigDecimal;

public class TransactionResponseDto {
    private Integer r030;
    private String name;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal resultAmount;

    public TransactionResponseDto() {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(BigDecimal resultAmount) {
        this.resultAmount = resultAmount;
    }
}
