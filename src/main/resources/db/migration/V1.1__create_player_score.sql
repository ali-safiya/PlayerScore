CREATE DATABASE gaming_service;

CREATE TABLE player_scores (
    player_id SERIAL PRIMARY KEY,
    player_name VARCHAR(255) NOT NULL,
    score INT NOT NULL
);
