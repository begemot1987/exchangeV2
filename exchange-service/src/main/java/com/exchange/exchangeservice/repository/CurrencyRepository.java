package com.exchange.exchangeservice.repository;

import java.util.Optional;
import com.exchange.exchangeservice.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("from Currency where cc = :currencyCode")
    Optional<Currency> findByCurrencyCode(String currencyCode);
}
