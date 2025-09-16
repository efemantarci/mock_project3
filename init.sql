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
  elo_rating INT,
  title_id INT,
  PRIMARY KEY (username),
  FOREIGN KEY (username) REFERENCES User(username),
  FOREIGN KEY (title_id) REFERENCES Title(title_id),
  CONSTRAINT "Experienced_Player" CHECK (elo_rating > 1000)
);

