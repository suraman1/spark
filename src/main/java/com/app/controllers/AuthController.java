package com.app.controllers;
import com.app.exceptions.InvalidException;
import com.app.models.User;
import com.app.services.AuthService;
import com.google.gson.Gson;
import com.app.utils.ApiResponse;
import spark.Request;
import spark.Response;

public class AuthController {
    private static final AuthService authService = new AuthService();
    private static final Gson gson = new Gson();
    public Object signup(Request req, Response res, User userData){
        try {
            res.type("application/json");
            if (userData.getName() == null || userData.getEmail() == null || userData.getPassword() == null) {
                throw new InvalidException(400, "Missing Fields");
            }
            Object result = authService.signup(userData);
            return gson.toJson(new ApiResponse("success", "User Created", result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Object login(Request req, Response res, User userData) {
        try {
            if (userData.getEmail() == null || userData.getPassword() == null) {
                throw new InvalidException(400, "Missing Fields");
            }
            Object result = authService.login(userData);
            String message = result == null ? "User Logged in" : "User not found";
            return gson.toJson(new ApiResponse("success", message, result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
