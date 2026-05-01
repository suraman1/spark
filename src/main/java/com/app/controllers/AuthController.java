package com.app.controllers;
import com.app.exceptions.ValidationException;
import com.app.exceptions.NotFoundExcpetion;
import com.app.models.User;
import com.app.services.AuthService;
import com.google.gson.Gson;
import com.app.utils.ApiResponse;
import spark.Response;

public class AuthController {
    private final AuthService authService = new AuthService();
    private final Gson gson = new Gson();
    public Object signup(Response res, User userData){
        try {
            if (userData.getName() == null) {
                throw new ValidationException("Name can't be empty.");
            }
            if (userData.getEmail() == null) {
                throw new ValidationException("Email can't be empty");
            }
            if (userData.getPassword() == null) {
                throw new ValidationException("Password can't be empty.");
            }
            String emailReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            String passwordReg = "^[A-Za-z0-9_.]{8,}$";
            if (!userData.getEmail().matches(emailReg)) {
                throw new ValidationException("Invalid email format.");
            }
            if (!userData.getPassword().matches(passwordReg)) {
                throw new ValidationException("Password must be at least 8 characters. can be alphabets, digits, underscore and dot");
            }
            Object result = authService.signup(userData);
            res.type("application/json");
            return gson.toJson(new ApiResponse("success", "User Created", result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Object login(Response res, User userData) {
        try {
            if (userData.getEmail() == null) {
                throw new ValidationException("Email can't be empty");
            }
            if (userData.getPassword() == null) {
                throw new ValidationException("Password can't be empty.");
            }
            String emailReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            String passwordReg = "^[A-Za-z0-9_.]{8,}$";
            if (!userData.getEmail().matches(emailReg)) {
                throw new ValidationException("Invalid email format.");
            }
            if (!userData.getPassword().matches(passwordReg)) {
                throw new ValidationException("Password must be at least 8 characters. can be alphabets, digits, underscore and dot");
            }
            Object result = authService.login(userData);
            String message = result instanceof String ? (String)result : "User Logged in";
            if (result instanceof String) {
                throw new NotFoundExcpetion(message);
            } else {
                res.type("application/json");
                return gson.toJson(new ApiResponse("success", message, result));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
