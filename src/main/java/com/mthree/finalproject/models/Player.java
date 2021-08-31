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
public class Player {
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
            int id, String firstName, String lastName, int heightFeet, 
            int heightInches, String position, Team team, int weightPounds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.position = position;
        this.team = team; 
        this.weightPounds = weightPounds;       
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName() {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName() {
        this.lastName = lastName;
    }
    
    public int getHeightFeet() {
        return this.heightFeet;
    }
    
    public void setHeightFeet(int heightFeet) {
        this.heightFeet = heightFeet;
    }
    
    public int getHeightInches() {
        return this.heightInches;
    }
    
    public void setHeightInches(int heightInches) {
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
    
    public int getWeightPounds() {
        return this.weightPounds;
    }
    
    public void setWeightPounds(int weightPounds) {
        this.weightPounds = weightPounds;
    }
    
    public class Team {
        private int id;
        private String abbreviation;
        private String city;
        private String conference;
        private String division;
        private String fullName;
        private String name;
        
        public Team() {}
        
        public Team( 
                int id, String abbreviation, String city,
                String conference, String division, String fullName,
                String name) {
            this.id = id;
            this.abbreviation = abbreviation;
            this.city = city;
            this.conference = conference;
            this.division = division;
            this.fullName = fullName;
            this.name = name;            
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
        
        public String getFullName() {
            return this.fullName;
        }
        
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
        
        public String getName() {
            return this.name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
    }
}
