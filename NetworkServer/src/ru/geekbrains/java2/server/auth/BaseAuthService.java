package ru.geekbrains.java2.server.auth;

import homework.day_one.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static ru.geekbrains.java2.server.db.ConnectionDBServise.getConnection;

public class BaseAuthService implements AuthService {

    private static final String SELECT_USERNAME =  "SELECT username from users where login = ? and password = ?";

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        return selectUserData(login,password);
    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации оставлен");
    }



    private String selectUserData(String login, String password){

        try (PreparedStatement prepareStatement = getConnection().prepareStatement(SELECT_USERNAME)){
            prepareStatement.setString(1,login);
            prepareStatement.setString(2,password);
            ResultSet resultSet = prepareStatement.executeQuery();
            String username = null;
            while(resultSet.next()){
                username = resultSet.getString("username");
            }
            return username;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
