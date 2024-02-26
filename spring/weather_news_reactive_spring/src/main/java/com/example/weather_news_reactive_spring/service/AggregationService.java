package com.example.weather_news_reactive_spring.service;

import com.example.weather_news_reactive_spring.model.AggregatedData;
import com.example.weather_news_reactive_spring.model.NewsData;
import com.example.weather_news_reactive_spring.model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AggregationService {

    private final WebClient weatherWebClient;
    private final WebClient newsWebClient;

    @Autowired
    public AggregationService(WebClient.Builder webClientBuilder) {
        this.weatherWebClient = webClientBuilder.baseUrl("http://weatherapi.com").build();
        this.newsWebClient = webClientBuilder.baseUrl("http://newsapi.com").build();
    }

    public Mono<AggregatedData> getAggregatedData() {
        Mono<WeatherData> weatherMono = weatherWebClient.get()
                .uri("/weatherEndpoint")
                .retrieve()
                .bodyToMono(WeatherData.class);

        Mono<NewsData> newsMono = newsWebClient.get()
                .uri("/newsEndpoint")
                .retrieve()
                .bodyToMono(NewsData.class);

        return Mono.zip(weatherMono, newsMono)
                .map(tuple -> new AggregatedData(tuple.getT1(), tuple.getT2()));
    }
}
