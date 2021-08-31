/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.controller;

import com.mthree.finalproject.models.Player;
import com.mthree.finalproject.service.FinalProjectServiceLayer;
import com.mthree.finalproject.ui.FinalProjectView;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chuck
 */

@RestController
@RequestMapping("/api/basketball")
public class FinalProjectRestController {
    private FinalProjectView view;
    private FinalProjectServiceLayer service;

    public FinalProjectRestController(FinalProjectServiceLayer service, FinalProjectView view) {
        this.service = service;
        this.view = view;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/getPlayers")
    public String getPlayers() {
        return "";
    }
    
    @GetMapping("/getPlayer")
    public List<Player> getPlayer() {
        List<Player> players = new ArrayList<>();
        players.add(service.getPlayer(1));
        return players;
    }
}
