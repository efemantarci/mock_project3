CREATE DATABASE CHESS_DB;
USE CHESS_DB; 
 
CREATE TABLE `User` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `surname` varchar(75) DEFAULT NULL,
  `nationality` varchar(100) NOT NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE `DatabaseManager` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE `Coach` (
  username VARCHAR(255),
  PRIMARY KEY (username),
  FOREIGN KEY (username) REFERENCES User(username)
);

CREATE TABLE `CoachCertification` (
  username VARCHAR(255),
  certification_name VARCHAR(255),
  PRIMARY KEY (username,certification_name),
  FOREIGN KEY (username) REFERENCES coach(username)
);

CREATE TABLE `Arbiter` (
  username VARCHAR(255),
  experience_level VARCHAR(255),
  PRIMARY KEY (username),
  FOREIGN KEY (username) REFERENCES User(username),
  CONSTRAINT "Valid_Arbiter_Experience" CHECK (experience_level IN ("beginner","intermediate","expert"))
);

CREATE TABLE `ArbiterCertification` (
  username VARCHAR(255),
  certification_name VARCHAR(255),
  PRIMARY KEY (username,certification_name),
  FOREIGN KEY (username) REFERENCES arbiter(username)
);

CREATE TABLE `Title` (
  title_id INT,
  title_name VARCHAR(255),
  PRIMARY KEY (title_id)
);

CREATE TABLE `Player` (
  username VARCHAR(255),
  date_of_birth DATE,
  fide_id VARCHAR(70),
  elo_rating INT NOT NULL,
  title_id INT,
  PRIMARY KEY (username),
  FOREIGN KEY (username) REFERENCES User(username),
  FOREIGN KEY (title_id) REFERENCES Title(title_id),
  CONSTRAINT "Experienced_Player" CHECK (elo_rating > 1000)
);


CREATE TABLE `Team` (
  team_id INT,
  team_name VARCHAR(255),
  coach_username VARCHAR(255) NOT NULL,
  contract_start date,
  contract_finish date,
  PRIMARY KEY (team_id),
  FOREIGN KEY (coach_username) REFERENCES Coach(username)
);

CREATE TABLE `PlayerTeam` (
  username VARCHAR(255),
  team_id INT,
  PRIMARY KEY (username, team_id),
  FOREIGN KEY (username) REFERENCES Player(username),
  FOREIGN KEY (team_id) REFERENCES Team(team_id)
)

 CREATE TABLE `Hall` (
  hall_id INT,
  hall_name VARCHAR(255),
  hall_country VARCHAR(255),
  hall_capacity INT,
  PRIMARY KEY (hall_id)
)

 CREATE TABLE `Table` (
  table_id INT,
  hall_id INT,
  PRIMARY KEY (hall_id,table_id),
  FOREIGN KEY (hall_id) REFERENCES Hall(hall_id)
)