package com.arjun.appdirect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arjun.appdirect.handler.AppDirectHandler;


@Configuration
public class AppDirectConfig {

    @Value("${APPDIRECT_CONSUMER_KEY}")
    private String consumerKey;

    @Value("${APPDIRECT_SECRET}")
    private String secret;

    @Bean
    public AppDirectHandler appDirectClient() {
        return new AppDirectHandler(consumerKey, secret);
    }
}
