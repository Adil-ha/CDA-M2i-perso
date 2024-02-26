package com.example.weather_news_reactive_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsData {
    private String title;
    private String description;
    private String source;
}
