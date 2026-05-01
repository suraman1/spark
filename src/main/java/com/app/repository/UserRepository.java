package com.app.repository;
import com.app.config.Database;
import com.app.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private Connection con;
    public void signup(String name, String email, String password) {
        try {
            con = Database.connect();
            final String query = "insert into users (name, email, password) values (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public ResultSet getUser(String email) {
        try {
            con = Database.connect();
            final String query = "select * from users where email = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            return stmt.executeQuery();
        }catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
