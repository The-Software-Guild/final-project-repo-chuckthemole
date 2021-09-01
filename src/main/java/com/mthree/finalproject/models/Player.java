/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.models;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Chuck
 */
public class Player {
    Map<String, Object> details;
    private int id;
    private String firstName;
    private String lastName;
    private int heightFeet;
    private int heightInches;
    private String position;
    private Team team;
    private int weightPounds;
    
    public Player() {}
    
    public Player(
            int id, String first_name, String last_name, int height_feet, 
            int height_inches, String position, Team team, int weight_pounds) {
        details = new LinkedHashMap<>();
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.heightFeet = height_feet;
        this.heightInches = height_inches;
        this.position = position;
        this.team = team; 
        this.weightPounds = weight_pounds;       
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirst_name() {
        return this.firstName;
    }
    
    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }
    
    
    public String getLast_name() {
        return this.lastName;
    }
    
    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }
    
    public int getHeight_feet() {
        return this.heightFeet;
    }
    
    public void setHeight_feet(int heightFeet) {
        this.heightFeet = heightFeet;
    }
    
    public int getHeight_inches() {
        return this.heightInches;
    }
    
    public void setHeight_inches(int heightInches) {
        this.heightInches = heightInches;
    }
    
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public Team getTeam() {
        return this.team;
    }
    
    public void setTeam(Team team) {
        this.team = team;
    }
    
    public int getWeight_pounds() {
        return this.weightPounds;
    }
    
    public void setWeight_pounds(int weightPounds) {
        this.weightPounds = weightPounds;
    }
    
        @Override 
    public String toString() {
        return this.firstName + " " + this.lastName + "\n";
    }
}
