package com.example.weather_news_reactive_spring.controller;

import com.example.weather_news_reactive_spring.model.AggregatedData;
import com.example.weather_news_reactive_spring.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AggregationController {

    private final AggregationService aggregationService;

    @Autowired
    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/aggregated-data")
    public Mono<ResponseEntity<AggregatedData>> getAggregatedData() {
        return aggregationService.getAggregatedData()
                .map(aggregatedData -> ResponseEntity.ok().body(aggregatedData))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
