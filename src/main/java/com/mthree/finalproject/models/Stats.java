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
public class Stats {
    private int id;
    private int ast;
    private int blk;
    private int dreb;
    private double fg3_pct;
    private int fg3a;
    private int fg3m;
    private double fg_pct;
    private int fga;
    private int fgm;
    private int ft_pct;
    private int fta;
    private int ftm;
    private String min;
    private int oreb;
    private int pf;
    private int pts;
    private int reb;
    private int stl;
    private int turnover;
    
    private Team team;
    private Game game;
    private Player player;
    
    public Stats() {}

    public Stats(int id, int ast, int blk, int dreb, double fg3_pct, int fg3a, 
            int fg3m, double fg_pct, int fga, int fgm, int ft_pct, int fta, 
            int ftm, String min, int oreb, int pf, int pts, int reb, int stl, 
            int turnover, Team team, Game game, Player player) {
        this.id = id;
        this.ast = ast;
        this.blk = blk;
        this.dreb = dreb;
        this.fg3_pct = fg3_pct;
        this.fg3a = fg3a;
        this.fg3m = fg3m;
        this.fg_pct = fg_pct;
        this.fga = fga;
        this.fgm = fgm;
        this.ft_pct = ft_pct;
        this.fta = fta;
        this.ftm = ftm;
        this.min = min;
        this.oreb = oreb;
        this.pf = pf;
        this.pts = pts;
        this.reb = reb;
        this.stl = stl;
        this.turnover = turnover;
        this.team = team;
        this.game = game;
        this.player = player;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public int getDreb() {
        return dreb;
    }

    public void setDreb(int dreb) {
        this.dreb = dreb;
    }

    public double getFg3_pct() {
        return fg3_pct;
    }

    public void setFg3_pct(double fg3_pct) {
        this.fg3_pct = fg3_pct;
    }

    public int getFg3a() {
        return fg3a;
    }

    public void setFg3a(int fg3a) {
        this.fg3a = fg3a;
    }

    public int getFg3m() {
        return fg3m;
    }

    public void setFg3m(int fg3m) {
        this.fg3m = fg3m;
    }

    public double getFg_pct() {
        return fg_pct;
    }

    public void setFg_pct(double fg_pct) {
        this.fg_pct = fg_pct;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public int getFt_pct() {
        return ft_pct;
    }

    public void setFt_pct(int ft_pct) {
        this.ft_pct = ft_pct;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public int getOreb() {
        return oreb;
    }

    public void setOreb(int oreb) {
        this.oreb = oreb;
    }

    public int getPf() {
        return pf;
    }

    public void setPf(int pf) {
        this.pf = pf;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
