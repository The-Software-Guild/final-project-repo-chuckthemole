/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.models;

/**
 *
 * @author chuck
 */
public class Game {
    private int id;
    private String date;
    private int home_team_score;
    private int period;
    private boolean postseason;
    private int season;
    private String status;
    private String time;
    private int visitor_team_score;
    
    private Team home_team;
    private Team visitor_team;
    
    public Game() {}

    public Game(
            int id, String date, 
            int home_team_score, 
            int period, boolean postseason, 
            int season, String status, 
            String time, int visitor_team_score, 
            Team home_team, Team visitor_team) {
        this.id = id;
        this.date = date;
        this.home_team_score = home_team_score;
        this.period = period;
        this.postseason = postseason;
        this.season = season;
        this.status = status;
        this.time = time;
        this.visitor_team_score = visitor_team_score;
        this.home_team = home_team;
        this.visitor_team = visitor_team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHome_team_score() {
        return home_team_score;
    }

    public void setHome_team_score(int home_team_score) {
        this.home_team_score = home_team_score;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public boolean isPostseason() {
        return postseason;
    }

    public void setPostseason(boolean postseason) {
        this.postseason = postseason;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getVisitor_team_score() {
        return visitor_team_score;
    }

    public void setVisitor_team_score(int visitor_team_score) {
        this.visitor_team_score = visitor_team_score;
    }

    public Team getHome_team() {
        return home_team;
    }

    public void setHome_team(Team home_team) {
        this.home_team = home_team;
    }

    public Team getVisitor_team() {
        return visitor_team;
    }

    public void setVisitor_team(Team visitor_team) {
        this.visitor_team = visitor_team;
    }
    
    @Override 
    public String toString() {
        return this.date + "\n";
    }
}
