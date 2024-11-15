package com.bookshop.orderservice.config;

import java.net.URI;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shop")
public record ClientProperties(

        @NotNull
        URI catalogServiceUri
){}
