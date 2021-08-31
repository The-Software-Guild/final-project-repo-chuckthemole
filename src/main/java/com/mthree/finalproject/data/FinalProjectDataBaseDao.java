/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.data;

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
        
        return false;
    }
    
    
}
