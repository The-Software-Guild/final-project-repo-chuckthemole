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
import com.mthree.finalproject.models.Stats;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kong.unirest.GetRequest;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/**
 *
 * @author chuck
 */

@Repository
@Profile("database")
public class FinalProjectDatabaseDao implements FinalProjectDao {
    private final JdbcTemplate jdbcTemplate;
    private ObjectMapper objectMapper;
    private List<List<Stats>> recentStats;
    private Map<Integer, String> recentPlayerIds;
    
    @Autowired
    public FinalProjectDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.objectMapper = new ObjectMapper();
        this.jdbcTemplate = jdbcTemplate;
        
        recentStats = new ArrayList<>();
        recentPlayerIds = new HashMap<>();
        loadRecentPlayers();
    }
    
    private void loadRecentPlayers() {
        final String sql = 
                "SELECT id, playerYear FROM player;";
        //recentPlayerIds = jdbcTemplate.queryForList(sql, Map<Integer, String>);
        List<Map<Integer, String>> list = jdbcTemplate.query(sql, new RecentPlayerMapper());
        list.forEach(item -> {
            recentPlayerIds.putAll(item);
        });
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
    public Stats getStats(int id) {
        kong.unirest.HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/stats?id=" + id)
            .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
            .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
            .asString();
        
        Stats stats = new Stats();
        try {
            System.out.println("*****" + response.getBody());
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            stats = objectMapper.readValue(response.getBody(), Stats.class);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FinalProjectDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stats;
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
        kong.unirest.HttpResponse<String> response = 
                    Unirest.get("https://free-nba.p.rapidapi.com/players?per_page=20")
                    .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                    .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                    .asString();  
        String total_pages = (new JSONObject(response.getBody())).getJSONObject("meta").getString("total_pages");
        int pages = Integer.parseInt(total_pages);
        String total_count = (new JSONObject(response.getBody())).getJSONObject("meta").getString("total_count");
        int count = Integer.parseInt(total_count);
        // System.out.println("********************" + pages);
        
        List<Player> players = new ArrayList<>();
        for (int j = 0; j < pages; j++) {
            try {
                response = 
                        Unirest.get("https://free-nba.p.rapidapi.com/players?per_page=20&page=" + j)
                        .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                        .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                        .asString();  
                JSONObject obj = new JSONObject(response.getBody());
                JSONArray arr = obj.getJSONArray("data");

                for (int i = 0; i < 20; i++) {
                    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    Player player;
                    try {
                        player = objectMapper.readValue(arr.getJSONObject(i).toString(), Player.class);
                        players.add(player);
                    } catch (JsonProcessingException ex) {
                        System.out.println("!!!!!!!!!!!!!!" + ex + "!!!!!!!!!!!!!!");
                    }
                }
            } catch (kong.unirest.json.JSONException e) {
                System.out.println("*************" + e + "****************");
            }
        }
        
        return players;
    }
    
    @Override
    public List<Stats> getPlayerStats(int id) {
        kong.unirest.HttpResponse<String> response = 
                Unirest.get("https://free-nba.p.rapidapi.com/stats?player_ids[]=" + id + "&per_page=20")
                .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                .asString(); 
        String total_pages = (new JSONObject(response.getBody())).getJSONObject("meta").getString("total_pages");
        int pages = Integer.parseInt(total_pages);
        String total_count = (new JSONObject(response.getBody())).getJSONObject("meta").getString("total_count");
        int count = Integer.parseInt(total_count);
        
        List<Stats> statsList = new ArrayList<>();
        for (int j = 0; j < pages; j++) {
            try {
                response = 
                    Unirest.get("https://free-nba.p.rapidapi.com/stats?player_ids[]=" + id + "&per_page=20&page=" + j)
                    .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                    .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                    .asString();

                JSONObject obj = new JSONObject(response.getBody());
                JSONArray arr = obj.getJSONArray("data");

                for (int i = 0; i < arr.length(); i++) {
                    Stats stats = new Stats();
                    try {
                        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                        stats = objectMapper.readValue(arr.get(i).toString(), Stats.class);
                        statsList.add(stats);
                    } catch (JsonProcessingException ex) {
                        Logger.getLogger(FinalProjectDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (kong.unirest.json.JSONException e) {
                System.out.println("**************" + e);
            }
        }
        
        return statsList;
    }
    
    @Override
    public Stats addStats(Stats stats) {
        final String sql = "INSERT INTO stats(id, statsPlayer, statsDate) VALUES(?, ?, ?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                sql, 
                Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, stats.getId());
            statement.setInt(2, stats.getPlayer().getId());
            statement.setDate(1, Date.valueOf(stats.getGame().getDate()));
            return statement;

        }, keyHolder);

        return stats;
    }
    
    @Override
    public Player addPlayer(Player player) {
        final String sql = "INSERT INTO player(id) VALUES(?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                sql, 
                Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, player.getId());
            return statement;

        }, keyHolder);

        return player;
    }

    @Override
    public List<Stats> getPlayerStatsForSeason(int playerId, int season) {
        kong.unirest.HttpResponse<String> response = 
                Unirest.get("https://free-nba.p.rapidapi.com/stats?seasons[]=" + 
                        season + "&player_ids[]=" + playerId + "&per_page=20")
                        .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                        .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                        .asString(); 
        String total_pages = (new JSONObject(response.getBody())).getJSONObject("meta").getString("total_pages");
        int pages = Integer.parseInt(total_pages);
        String total_count = (new JSONObject(response.getBody())).getJSONObject("meta").getString("total_count");
        int count = Integer.parseInt(total_count);
        
        List<Stats> statsList = new ArrayList<>();
        for (int j = 0; j < pages; j++) {
            try {
                response = 
                    Unirest.get("https://free-nba.p.rapidapi.com/stats?seasons[]=" + 
                            season + "&player_ids[]=" + playerId + "&per_page=20&page=" + j)
                            .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                            .header("x-rapidapi-key", "14a972693bmsh3de8a04a00dca35p17a88bjsnca52ffc0b0fb")
                            .asString();

                JSONObject obj = new JSONObject(response.getBody());
                JSONArray arr = obj.getJSONArray("data");

                for (int i = 0; i < arr.length(); i++) {
                    Stats stats = new Stats();
                    try {
                        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                        stats = objectMapper.readValue(arr.get(i).toString(), Stats.class);
                        statsList.add(stats);
                    } catch (JsonProcessingException ex) {
                        Logger.getLogger(FinalProjectDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (kong.unirest.json.JSONException e) {
                System.out.println("**************" + e);
            } catch (java.lang.NullPointerException ex) {
                System.out.println("!!!!!!!!!!!!!!" + ex);
            }
        }
        
        recentStats.add(statsList);
        addPlayer(statsList.get(0).getPlayer());
        
        return statsList;    
    }
    
    private static final class RecentPlayerMapper 
            implements RowMapper<Map<Integer, String>> {
        @Override
        public Map<Integer, String> mapRow(ResultSet rs, int i) throws SQLException {
            Map<Integer, String> map = new HashMap<>();
            map.put(rs.getInt("id"), rs.getString("playerYear"));
            return map;
        }
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
