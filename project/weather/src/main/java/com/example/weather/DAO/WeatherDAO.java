package com.example.weather.DAO;

import com.example.weather.model.WeatherModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WeatherDAO {
    private static final String db = "com.mysql.cj.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://10.156.147.210:3306/project_data_db?user=root&password=Pass&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private final String dbID = "root";
    private final String dbPw = "8015";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String query;

    public ResultSet weather(WeatherModel wm) {
        try {
            Class.forName(db);
            conn = DriverManager.getConnection(dbUrl, dbID, dbPw);
            stmt = conn.createStatement();

            query = String.format("select * from data where x = '%d' and y = '%d'", wm.getX(), wm.getY());
            rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}