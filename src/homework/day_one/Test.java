package homework.day_one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {



        public static Connection getInstance() throws SQLException {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
        }


    public static void main(String[] args) {
        try {

            System.out.println(getInstance());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
