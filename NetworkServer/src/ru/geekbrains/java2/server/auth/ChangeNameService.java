package ru.geekbrains.java2.server.auth;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.geekbrains.java2.server.db.ConnectionDBServise.getConnection;

public class ChangeNameService {

    private static final String UPDATE_NAME = "Update users set username = ? where username = ?";

    public static int changeName(String newName, String nickname){

        try (PreparedStatement prepareStatement = getConnection().prepareStatement(UPDATE_NAME)){
            prepareStatement.setString(1,newName);
            prepareStatement.setString(2,nickname);
           return prepareStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return 0;
    }
}
