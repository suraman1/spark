package com.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public static Connection connect() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/spark";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "root" ,"");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
