package com.mthree.finalproject;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);      
    }
}
