package org.iryna97.lesson2.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@Configuration
@ComponentScan(basePackages = "package org.iryna97.lesson2")
public class AppConfig {
    static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=~~&json";

    @Bean
    HttpClient httpClient(){
        return HttpClient
                .newBuilder()
                .build();
    }

    @Bean
    HttpRequest requestUSD(){
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.replace("~~", "USD")))
                .build();
    }
    @Bean
    HttpRequest requestEUR(){
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.replace("~~", "EUR")))
                .build();
    }
    @Bean
    HttpRequest requestPLN(){
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.replace("~~", "PLN")))
                .build();
    }
}
