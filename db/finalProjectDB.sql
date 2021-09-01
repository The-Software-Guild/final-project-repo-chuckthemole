DROP DATABASE IF EXISTS finalProjectDB;
CREATE DATABASE finalProjectDB;

USE finalProjectDB;

CREATE TABLE team (
	team_id INT AUTO_INCREMENT,
    CONSTRAINT pk_team
		PRIMARY KEY (team_id),
	
    id INT NOT NULL,
    abbreviation VARCHAR(45),
    city VARCHAR(45),
    conference VARCHAR(45),
    division VARCHAR(45),
    fullName VARCHAR(45),
    teamName VARCHAR(45)
);

CREATE TABLE player (
	player_id INT AUTO_INCREMENT,
    CONSTRAINT pk_player
		PRIMARY KEY (player_id),
	
    id INT NOT NULL,
    playerYear VARCHAR(45),
    firstName VARCHAR(45),
    lastName VARCHAR(45),
    heightFeet INT,
    heightInches INT,
    position VARCHAR(45),
    weightPounds INT,
    
    team_id INT,
    CONSTRAINT fk_team
    	FOREIGN KEY (team_id)
    	REFERENCES team(team_id)
);

CREATE TABLE stats (
	stats_id INT AUTO_INCREMENT,
    CONSTRAINT pk_stats
		PRIMARY KEY (stats_id),
	
    id INT NOT NULL,
    statsPlayer VARCHAR(45) NOT NULL,
    statsDate DATE NOT NULL
);