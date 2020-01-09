package com.example.weather.domain.response;

import lombok.Getter;

@Getter
public class WeatherResponse {
    private Integer hour;
    private Integer temp;
    private Integer day_high_temp;
    private Integer day_low_temp;
    private String weather_eng;
    private String big_PM;
    private String small_PM;

    public WeatherResponse(Integer hour, Integer temp, Integer day_high_temp, Integer day_low_temp, String weather_eng, String big_PM, String small_PM) {
        this.hour = hour;
        this.temp = temp;
        this.day_high_temp = day_high_temp;
        this.day_low_temp = day_low_temp;
        this.weather_eng = weather_eng;
        this.big_PM = big_PM;
        this.small_PM = small_PM;
    }
}
