package com.app.config;
import com.app.exceptions.DatabaseException;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public static Connection connect() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/spark";
        Connection con = null;
        try {
            Dotenv dotenv = Dotenv.load();
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            con = DriverManager.getConnection(url,user, password);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        return con;
    }
}
