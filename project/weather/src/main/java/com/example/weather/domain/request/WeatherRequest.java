package com.example.weather.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherRequest {
    private int area;

    public WeatherRequest() {}
}