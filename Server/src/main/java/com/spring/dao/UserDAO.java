package com.spring.dao;

import com.spring.model.UserSignIn;

import java.sql.*;

public class UserDAO {

    private static final String path = "com.mysql.cj.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost:3306/server?useSSL=false&serverTimezone=UTC";
    private final String dbId = "root";
    private final String dbPw = "hanif1293@";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String query;

    //파라미터는 어떤 값을 받아올건지 써줌
    public Boolean join(String userID, String userPw, String userName, String userEmail) {
        try {
            Class.forName(path);
            connection = DriverManager.getConnection(dbUrl, dbId, dbPw); //연결 수단
            statement = connection.createStatement(); //매개체(기차)
            query = String.format("insert into server.users value('%s' '%s' '%s' '%s')",
                    userID, userPw, userName, userEmail);
            statement.executeUpdate(query);

            return true;
        }catch (Exception ignored) {
            ignored.printStackTrace();
        }finally {
            try{
                if(connection != null|| statement != null || resultSet != null) {
                    connection.close();
                    statement.close();
                    resultSet.close();
                }
            }catch (Exception e){
                //e
            }
        }
        return false;
    }

    public UserSignIn login(String userID, String userPw) {
        try {
            Class.forName(path);
            connection = DriverManager.getConnection(dbUrl, dbId, dbPw); //연결 수단
            statement = connection.createStatement(); //매개체(기차)

            query = String.format("select * from server.users where id = '%s' and pw = '%s'",
                    userID, userPw);

            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                String id = resultSet.getString(userID);
                String pw = resultSet.getString(userPw);

                return new UserSignIn(id, pw);
            }
        }catch (Exception ignored) {
            ignored.printStackTrace();
        }finally {
            try{
                if(connection != null|| statement != null || resultSet != null) {
                    connection.close();
                    statement.close();
                    resultSet.close();
                }
            }catch (Exception e){
                //e
            }
        }
        return null;
    }
}
