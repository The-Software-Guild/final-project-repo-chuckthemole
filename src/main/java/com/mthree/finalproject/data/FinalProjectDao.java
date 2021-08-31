/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.data;

import com.mthree.finalproject.models.Player;
import java.util.List;

/**
 *
 * @author chuck
 */
public interface FinalProjectDao {
    boolean loadPlayersApiCall();
    Player getPlayer(int id);
    public List<Player> getPlayers();
    List<Player> getPlayersByName(String name);
}
