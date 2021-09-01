/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.controller;

import com.mthree.finalproject.models.Game;
import com.mthree.finalproject.models.Player;
import com.mthree.finalproject.models.Stats;
import com.mthree.finalproject.service.FinalProjectServiceLayer;
import com.mthree.finalproject.ui.FinalProjectView;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chuck
 */

@Controller
@RequestMapping("/basketball")
public class FinalProjectController {
    private FinalProjectView view;
    private FinalProjectServiceLayer service;

    public FinalProjectController(FinalProjectServiceLayer service, FinalProjectView view) {
        this.service = service;
        this.view = view;
    }
    
    @GetMapping("/")
    public String index() {
        return "getPlayer";
    }
    
    @GetMapping("/getPlayers")
    public String getPlayers() {
        return "";
    }
    
    @GetMapping("/player")
    public String getPlayerRequestForm(Model model) {
        model.addAttribute("player", new Player());
        return "getPlayer";
    }
    
    @GetMapping("/pointsForSeason")
    public String pointsForSeason() {
        return "/pointsForSeason";
    }
    
    @PostMapping("/createPlayer") 
    public String createPlayer(@ModelAttribute("player") Player player, Model model) {
        List<Player> players = service.getPlayersByName(player.getLast_name());
        
        for (Player p : players) {
            if (p.getFirst_name().equalsIgnoreCase(player.getFirst_name())) {
                if (p.getLast_name().equalsIgnoreCase(player.getLast_name())) {
                    Player foundPlayer = p;
                    model.addAttribute("player", foundPlayer);
                    model.addAttribute("game", new Game());
                    return "findPlayerSuccess";
                }
            }
        }
  
        return "/findPlayerError";
    }
    
    @PostMapping("/findStatsForYear/{id}")
    public String findStatsForYear(
            @PathVariable int id,
            @ModelAttribute("game") Game game,
            Model model) {
        List<Stats> stats = 
                service.getPlayerStatsForSeason(id, Integer.parseInt(game.getDate()));
        model.addAttribute("player", service.getPlayer(id));
        model.addAttribute("date", game.getDate());
        
        return "showPointsForYear";
    }
}
