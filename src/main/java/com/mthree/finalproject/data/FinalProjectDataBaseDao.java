/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.mthree.finalproject.models.Player;
import com.mthree.finalproject.models.Team;
import java.sql.ResultSet;
import java.sql.SQLException;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kong.unirest.GetRequest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

/**
 *
 * @author chuck
 */

@Repository
@Profile("database")
public class FinalProjectDatabaseDao implements FinalProjectDao {
    private final JdbcTemplate jdbcTemplate;
    private ObjectMapper objectMapper;
    
    @Autowired
    public FinalProjectDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.objectMapper = new ObjectMapper();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean loadPlayersApiCall() {
        kong.unirest.HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/players/")
            .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
            .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
            .asString();
        return false;
    }

    @Override
    public Player getPlayer(int id) {
        kong.unirest.HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/players/" + id)
            .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
            .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
            .asString();
        
        Player player = new Player();
        System.out.println("*********************" + response.getBody());
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            player = objectMapper.readValue(response.getBody(), Player.class);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FinalProjectDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return player;
    }
    
    @Override 
    public List<Player> getPlayersByName(String playerName) {
        List<Player> players = new ArrayList<>();
        
        kong.unirest.HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/players?search=" + playerName)
                .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                .asString();
        
        JSONObject obj = new JSONObject(response.getBody());
        JSONArray arr = obj.getJSONArray("data");
        
        for (int i = 0; i < arr.length(); i++) {
            String name = arr.getJSONObject(i).getString("first_name");
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Player player;
            try {
                player = objectMapper.readValue(arr.getJSONObject(i).toString(), Player.class);
                players.add(player);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(FinalProjectDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(arr.length());
        
        return players;
    }
    
    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        
        kong.unirest.HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/players")
                .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                .asString();
        
        JSONObject obj = new JSONObject(response.getBody());
        System.out.println("**********************" + obj.toString());
        JSONArray arr = obj.getJSONArray("data");
        
        for (int i = 0; i < arr.length(); i++) {
            String name = arr.getJSONObject(i).getString("first_name");  
            System.out.println(name);
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Player player;
            try {
                player = objectMapper.readValue(arr.getJSONObject(i).toString(), Player.class);
                players.add(player);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(FinalProjectDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(arr.length());
        
        /*
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Player player = objectMapper.readValue(response.getBody(), Player.class);
           // objectMapper.readValues(response.getBody(), Player.class);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FinalProjectDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //for (int i = 1; i < 10; i++) {
        //    players.add(getPlayer(i));
        //}*/
        return players;
    }
    
    private static final class PlayerMapper 
            implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet rs, int i) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt(""));
            player.setFirst_name(rs.getString(""));
            player.setLast_name(rs.getString(""));
            player.setHeight_feet(rs.getInt(""));
            player.setHeight_inches(rs.getInt(""));
            player.setPosition(rs.getString(""));
            player.setWeight_pounds(rs.getInt(""));
            return player;
        }
    }
    
    private static final class TeamMapper 
            implements RowMapper<Team> {
        @Override
        public Team mapRow(ResultSet rs, int i) throws SQLException {
            Team team = new Team();
            team.setId(rs.getInt(""));
            team.setAbbreviation(rs.getString(""));
            team.setCity(rs.getString(""));
            team.setConference(rs.getString(""));
            team.setDivision(rs.getString(""));
            team.setFull_name(rs.getString(""));
            team.setName(rs.getString(""));
            return team;
        }
    }
}
