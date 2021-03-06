package com.exchange.conversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.exchange.conversionservice")
public class ConversionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConversionServiceApplication.class, args);
    }

}
