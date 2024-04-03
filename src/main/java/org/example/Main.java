package org.example;

import java.util.List;
import org.example.Entity.PlayerScore;
import org.example.Service.PlayerScoreService;
import org.example.Service.ScoreFileManager;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {



    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        PlayerScore playerScore = new PlayerScore();
        playerScore.setPlayerId("playerId8");
        playerScore.setPlayerName("Aayat");
        playerScore.setScore(900);
        ScoreFileManager scoreFileManager = new ScoreFileManager();
        PlayerScoreService playerScoreService = new PlayerScoreService(scoreFileManager);

        playerScoreService.addScore(playerScore);

        List<PlayerScore> topFivePlayers = playerScoreService.getTop5Scores();

        for(PlayerScore player : topFivePlayers){

            System.out.println("PlayerId : "+player.getPlayerId() +" PlayerName : "+ player.getPlayerName()
            +" PlayerScore : " + player.getScore());
        }
    }
}