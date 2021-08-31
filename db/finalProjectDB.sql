DROP DATABASE IF EXISTS finalProjectDB;
CREATE DATABASE finalProjectDB;

USE finalProjectDB;

CREATE TABLE team (
	team_id INT AUTO_INCREMENT,
    CONSTRAINT pk_team
		PRIMARY KEY (team_id),
	
    id INT NOT NULL,
    abbreviation VARCHAR(45) NOT NULL,
    city VARCHAR(45) NOT NULL,
    conference VARCHAR(45) NOT NULL,
    division VARCHAR(45) NOT NULL,
    fullName VARCHAR(45) NOT NULL,
    teamName VARCHAR(45) NOT NULL
);

CREATE TABLE player (
	player_id INT AUTO_INCREMENT,
    CONSTRAINT pk_player
		PRIMARY KEY (player_id),
	
    id INT NOT NULL,
    firstName VARCHAR(45) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    heightFeet INT NOT NULL,
    heightInches INT NOT NULL,
    position VARCHAR(45) NOT NULL,
    weightPounds INT NOT NULL,
    
    team_id INT NOT NULL,
    CONSTRAINT fk_team
    	FOREIGN KEY (team_id)
    	REFERENCES team(team_id)
);