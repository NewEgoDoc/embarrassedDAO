package spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://172.30.1.45:5432/postgres";
        String username = "postgres";
        String password = "postgres";

        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
