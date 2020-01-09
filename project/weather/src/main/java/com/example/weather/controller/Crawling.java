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
            weatherModel.setMh(6);
            weatherModel.setAh(12);
            weatherModel.setEh(18);
        } else if(weatherRequest.getArea() == 2) {
            weatherModel.setX(66);
            weatherModel.setY(99);
            weatherModel.setMh(6);
            weatherModel.setAh(12);
            weatherModel.setEh(18);
        } else if(weatherRequest.getArea() == 3) {
            weatherModel.setX(68);
            weatherModel.setY(100);
            weatherModel.setMh(6);
            weatherModel.setAh(12);
            weatherModel.setEh(18);
        } else if(weatherRequest.getArea() == 1) {
            weatherModel.setX(67);
            weatherModel.setY(101);
            weatherModel.setMh(6);
            weatherModel.setAh(12);
            weatherModel.setEh(18);
        } else if(weatherRequest.getArea() == 4) {
            weatherModel.setX(68);
            weatherModel.setY(101);
            weatherModel.setMh(6);
            weatherModel.setAh(12);
            weatherModel.setEh(18);
        }

        ResultSet rs = weatherDAO.weather(weatherModel);
        return new WeatherResponse(rs.getInt("hour"), rs.getInt("temp"), rs.getInt("day_high_temp"),
                rs.getInt("day_low_temp"), rs.getString("weather_eng"), rs.getString("big_PM"),
                rs.getString("small_PM"));
    }
}
