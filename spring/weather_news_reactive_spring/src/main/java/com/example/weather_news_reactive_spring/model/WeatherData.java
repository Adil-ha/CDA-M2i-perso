package com.example.weather_news_reactive_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private String weatherDescription;
}
