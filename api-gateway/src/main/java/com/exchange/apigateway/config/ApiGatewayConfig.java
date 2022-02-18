package com.exchange.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/sell/**")
                        .uri("lb://conversion"))
                .route(r -> r.path("/rate/**")
                        .filters(f -> f.rewritePath("/rate/(?<segment>.*)", "/${segment}"))
                        .uri("lb://exchange"))
                .build();
    }
}
