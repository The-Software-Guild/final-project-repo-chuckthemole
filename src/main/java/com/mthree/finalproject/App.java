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
        //kong.unirest.HttpResponse<String> response = Unirest.get("http://data.nba.net/10s/prod/v1/2016/players.json").asString();
        /*Map<String, String> headers = new HashMap<>();
        headers.put("x-rapidapi-host", "free-nba.p.rapidapi.com");
        headers.put("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb");

        Map<String, Object> fields = new HashMap<>();
        //fields.put("last_name", "James");
        fields.put("id", "1");
        int id = 1;
        kong.unirest.HttpResponse<JsonNode> response = Unirest.put("https://free-nba.p.rapidapi.com/players/" + id)
                .headers(headers).fields(fields)
                .asJson();
        
        kong.unirest.HttpResponse<JsonNode> response = Unirest.get("https://free-nba.p.rapidapi.com/players/%7Bid%7D")
                .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                .asJson();
        kong.unirest.HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/players/")
            .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
            .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
            .asString();
        System.out.println("*****Response: " + response.getBody().toString());*/
    }
}
