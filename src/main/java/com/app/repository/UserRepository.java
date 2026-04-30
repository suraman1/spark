package com.app.repository;
import com.app.config.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {
    private Connection con;
    public int signup(String name, String email, String password) {
        try {
            con = Database.connect();
            final String query = "insert into users (name, email, password) values (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            return stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public ResultSet getUser(String email) {
        try {
            con = Database.connect();
            final String query = "select * from users where email = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            return stmt.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
