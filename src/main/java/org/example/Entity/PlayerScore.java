package org.example.Entity;

import javax.persistence.*;

@Entity
@Table(name = "player_scores")
public class PlayerScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String playerId;

    @Column(name = "player_name")
    private String playerName;

    private int score;

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}

