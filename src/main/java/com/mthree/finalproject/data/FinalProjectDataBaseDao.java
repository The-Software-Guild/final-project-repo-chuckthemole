/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.data;

import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chuck
 */

@Repository
@Profile("database")
public class FinalProjectDatabaseDao implements FinalProjectDao {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public FinalProjectDatabaseDao(JdbcTemplate jdbcTemplate) {
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
    
    
}
