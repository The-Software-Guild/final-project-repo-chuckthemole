/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.service;

import com.mthree.finalproject.data.FinalProjectDao;
import com.mthree.finalproject.models.Player;
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

}
