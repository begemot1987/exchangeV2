package com.exchange.exchangeservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import com.exchange.exchangeservice.entity.Currency;
import com.exchange.exchangeservice.exception.CurrencyNotFoundException;
import com.exchange.exchangeservice.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public Currency save(Currency currency) {
        return repository.save(currency);
    }

    public List<Currency> saveAll(List<Currency> currencies) {
        return repository.saveAll(currencies);
    }

    public List<Currency> getAll() {
        return repository.findAll();
    }

    public Currency findByCurrencyCode(String currencyCode) {
        return repository.findByCurrencyCode(currencyCode).orElseThrow(
                () -> new CurrencyNotFoundException("Cant find currency with code " + currencyCode));
    }

    public BigDecimal exchange(String from, String to) {
        Currency fromCurrency = repository.findByCurrencyCode(from).orElseThrow(
                () -> new CurrencyNotFoundException("Can't find currency with code " + from));
        Currency toCurrency = repository.findByCurrencyCode(to).orElseThrow(
                () -> new CurrencyNotFoundException("Can't find currency with code " + to));
        return fromCurrency.getRate().divide(toCurrency.getRate(), 10, RoundingMode.HALF_UP);
    }
}
