/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.data;

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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        kong.unirest.HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/players/1")
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
    
    private static final class PlayerMapper 
            implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet rs, int i) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt(""));
            player.setFirstName(rs.getString(""));
            player.setLastName(rs.getString(""));
            player.setHeightFeet(rs.getInt(""));
            player.setHeightInches(rs.getInt(""));
            player.setPosition(rs.getString(""));
            player.setWeightPounds(rs.getInt(""));
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
            team.setFullName(rs.getString(""));
            team.setName(rs.getString(""));
            return team;
        }
    }
}
