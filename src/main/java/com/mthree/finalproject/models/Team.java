/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.finalproject.models;

/**
 *
 * @author Chuck
 */
public class Team {
    private int id;
    private String abbreviation;
    private String city;
    private String conference;
    private String division;
    private String fullName;
    private String teamName;

    public Team() {}

    public Team( 
            int id, String abbreviation, String city,
            String conference, String division, String fullName,
            String teamName) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.city = city;
        this.conference = conference;
        this.division = division;
        this.fullName = fullName;
        this.teamName = teamName;            
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConference() {
        return this.conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return this.division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getFull_name() {
        return this.fullName;
    }

    public void setFull_name(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return this.teamName;
    }

    public void setName(String teamName) {
        this.teamName = teamName;
    }

    @Override 
    public String toString() {
        return this.teamName + "\n";
    }
}
