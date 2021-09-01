/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.controller;

import com.mthree.finalproject.models.Player;
import com.mthree.finalproject.models.Stats;
import com.mthree.finalproject.service.FinalProjectServiceLayer;
import com.mthree.finalproject.ui.FinalProjectView;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/getPlayer/{id}")
    public Player getPlayer(@PathVariable int id) {
        return service.getPlayer(id);
    }
    
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return service.getPlayers();
    }
    
    @GetMapping("/player/{name}")
    public List<Player> getPlayerByFirstName(@PathVariable String name) {
        return service.getPlayersByName(name);
    }
    
    @GetMapping("/stats/{id}")
    public List<Stats> getPlayerStats(@PathVariable int id) {
        return service.getPlayerStats(id);
    }
}
