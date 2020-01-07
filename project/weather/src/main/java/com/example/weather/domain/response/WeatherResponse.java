package com.example.weather.domain.response;

import lombok.Getter;

@Getter
public class WeatherResponse {
    private Integer update_time;
    private Integer time_ahead;
    private Integer hour;
    private Integer temp;
    private Integer day_high_temp;
    private Integer day_low_temp;
    private Integer sky_state;
    private Integer weather_state;
    private Integer weather_korean;
    private Integer rain_persent;
    private Float expect_rain_6h;
    private Float expect_rain_12h;
    private Float expect_snow_6h;
    private Float expect_snow_12h;
    private Float wind_speed;
    private Integer wind_way;
    private String wind_text;
    private Integer humi;
    private String big_PM;
    private String small_PM;

    public WeatherResponse(Integer update_time, Integer time_ahead, Integer hour, Integer temp, Integer day_high_temp, Integer day_low_temp, Integer sky_state, Integer weather_stat, Integer weather_korean, Integer rain_persent, Float expect_rain_6h, Float expect_rain_12h, Float expect_snow_6h, Float expect_snow_12h, Float wind_speed, Integer wind_way, String wind_text, Integer humi, String big_PM, String small_PM) {
        this.update_time = update_time;
        this.time_ahead = time_ahead;
        this.hour = hour;
        this.temp = temp;
        this.day_high_temp = day_high_temp;
        this.day_low_temp = day_low_temp;
        this.sky_state = sky_state;
        this.weather_state = weather_stat;
        this.weather_korean = weather_korean;
        this.rain_persent = rain_persent;
        this.expect_rain_6h = expect_rain_6h;
        this.expect_rain_12h = expect_rain_12h;
        this.expect_snow_6h = expect_snow_6h;
        this.expect_snow_12h = expect_snow_12h;
        this.wind_speed = wind_speed;
        this.wind_way = wind_way;
        this.wind_text = wind_text;
        this.humi = humi;
        this.big_PM = big_PM;
        this.small_PM = small_PM;
    }
}
