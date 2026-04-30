package com.app.config;

import com.app.controllers.AuthController;
import com.app.models.User;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class Routes {
    private static AuthController authController = new AuthController();
    private static Gson gson = new Gson();

    public static Object signup(Request req, Response res) {
        User userData = gson.fromJson(req.body(), User.class);
        return authController.signup(req, res, userData);
    }
    public static Object login(Request req, Response res) {
        User userData = gson.fromJson(req.body(), User.class);
        return authController.login(req, res, userData);
    }
}
