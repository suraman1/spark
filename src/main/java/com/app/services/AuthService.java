package com.app.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.app.models.User;
import com.app.repository.UserRepository;

import java.sql.ResultSet;

public class AuthService {
    private UserRepository userRepo;
    public AuthService() {
        userRepo  = new UserRepository();
    }
    public Object signup(User userData) {
        try {
            ResultSet result = userRepo.getUser(userData.getEmail());
            if (result.next()) {
                throw new Exception("User already Exists");
            }
            String password = BCrypt.withDefaults().hashToString(10, userData.getPassword().toCharArray());
            userRepo.signup(userData.getName(), userData.getEmail(), password);
            return userData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Object login(User userData) {
        try {
            ResultSet result = userRepo.getUser(userData.getEmail());
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                BCrypt.Result pass = BCrypt.verifyer().verify(userData.getPassword().toCharArray(), password);
                if (userData.getEmail().equals(email) && pass.verified) {
                    return result.getObject("email");
                }
            }
            return "User Not found";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
