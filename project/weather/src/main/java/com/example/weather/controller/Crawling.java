package com.example.weather.controller;

import com.example.weather.DAO.WeatherDAO;
import com.example.weather.model.WeatherModel;
import com.example.weather.domain.request.WeatherRequest;
import com.example.weather.domain.response.WeatherResponse;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class Crawling {

    @ResponseBody
    @CrossOrigin(origins="*")
    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public WeatherResponse Control(@RequestBody WeatherRequest weatherRequest) throws SQLException {
        WeatherModel weatherModel = new WeatherModel();
        WeatherDAO weatherDAO = new WeatherDAO();
        if(weatherRequest.getArea() == 5) {
            weatherModel.setX(67);
            weatherModel.setY(99);
        } else if(weatherRequest.getArea() == 2) {
            weatherModel.setX(66);
            weatherModel.setY(99);
        } else if(weatherRequest.getArea() == 3) {
            weatherModel.setX(68);
            weatherModel.setY(100);
        } else if(weatherRequest.getArea() == 1) {
            weatherModel.setX(67);
            weatherModel.setY(101);
        } else if(weatherRequest.getArea() == 4) {
            weatherModel.setX(68);
            weatherModel.setY(101);
        }

        ResultSet rs = weatherDAO.weather(weatherModel);
        return new WeatherResponse(rs.getInt("update_time"), rs.getInt("time_ahead"),
                rs.getInt("hour"), rs.getInt("temp "), rs.getInt("day_high_temp"),
                rs.getInt("day_low_temp"), rs.getInt("sky_state"), rs.getInt("weather_state"),
                rs.getInt("weather_korean"), rs.getInt("rain_persent"), rs.getFloat("expect_rain_6h"),
                rs.getFloat("expect_rain_12h"), rs.getFloat("expect_snow_6h"), rs.getFloat("expect_snow_12h"),
                rs.getFloat("wind_speed"), rs.getInt("wind_way"), rs.getString("wind_text"),
                rs.getInt("humi"), rs.getString("big_PM "), rs.getString("small_PM"));
    }
}
