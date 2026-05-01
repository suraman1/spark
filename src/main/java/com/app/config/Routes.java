package com.app.config;

import com.app.controllers.AuthController;
import com.app.models.User;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class Routes {
    private final static AuthController authController = new AuthController();
    private final static Gson gson = new Gson();

    public static Object signup(Request req, Response res) {
        User userData = gson.fromJson(req.body(), User.class);
        return authController.signup(res, userData);
    }
    public static Object login(Request req, Response res) {
        User userData = gson.fromJson(req.body(), User.class);
        return authController.login(res, userData);
    }
}
