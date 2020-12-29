package messenger.client.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionServiseBD {

    public ConnectionServiseBD() {
    }

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
    }


}
