/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.controller;

import com.mthree.finalproject.service.FinalProjectServiceLayer;
import com.mthree.finalproject.ui.FinalProjectView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "index";
    }
    
    @GetMapping("/getPlayers")
    public String getPlayers() {
        return "";
    }
}
