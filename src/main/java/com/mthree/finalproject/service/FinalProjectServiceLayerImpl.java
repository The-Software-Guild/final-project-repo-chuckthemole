/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.service;

import com.mthree.finalproject.data.FinalProjectDao;
import com.mthree.finalproject.models.Player;
import com.mthree.finalproject.models.Stats;
import java.util.List;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author chuck
 */

@Configuration
public class FinalProjectServiceLayerImpl implements FinalProjectServiceLayer {
    FinalProjectDao dao;

    public FinalProjectServiceLayerImpl(FinalProjectDao dao) {
        this.dao = dao;
    }

    @Override
    public Player getPlayer(int id) {
        return dao.getPlayer(id);
    }

    @Override
    public List<Player> getPlayers() {
        return dao.getPlayers();
    }

    @Override
    public List<Player> getPlayersByName(String firstName) {
        return dao.getPlayersByName(firstName);
    }

    @Override
    public List<Stats> getPlayerStats(int id) {
        return dao.getPlayerStats(id);
    }

    @Override
    public List<Stats> getPlayerStatsForSeason(int playerId, int season) {
        return dao.getPlayerStatsForSeason(playerId, season);
    }

}
