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