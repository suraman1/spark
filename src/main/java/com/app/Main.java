package com.app;
import com.app.config.Routes;
import com.app.utils.ApiResponse;
import com.google.gson.Gson;

import static spark.Spark.*;
public class Main
{   private static Gson gson = new Gson();
    public static void main( String[] args )
    {
        port(3500);
        exception(Exception.class, (error, req, res) -> {
             res.type("application/json");
             res.status(500);
             res.body(gson.toJson(new ApiResponse("Error", error.getMessage(), null)));
        });
        get("/", (req, res) -> {
            res.type("application/json");
            res.status(200);
            return "Hello Bob";
        });
        post("/api/signup", Routes::signup);
        post("/api/login", Routes::login);
    }
}
