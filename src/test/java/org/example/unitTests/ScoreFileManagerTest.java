package org.example.unitTests;

import org.example.Entity.PlayerScore;
import org.example.Service.ScoreFileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreFileManagerTest {
    private ScoreFileManager scoreFileManager;

    @BeforeEach
    public void setUp() {
        scoreFileManager = new ScoreFileManager();
    }

    @Test
    public void testAddScore() {
        PlayerScore playerScore = new PlayerScore();
        playerScore.setPlayerId("12345");
        playerScore.setPlayerName("John Doe");
        playerScore.setScore(100);

        try {
            scoreFileManager.addScore(playerScore);
        }
        catch (Exception e){
            fail("Exception :" , e);
        }

    }

    @Test
    public void testLoadScoresFromDisk() {

        PlayerScore playerScore1 = new PlayerScore();
        playerScore1.setPlayerId("111");
        playerScore1.setPlayerName("Alice");
        playerScore1.setScore(200);

        PlayerScore playerScore2 = new PlayerScore();
        playerScore2.setPlayerId("222");
        playerScore2.setPlayerName("Bob");
        playerScore2.setScore(150);

        scoreFileManager.addScore(playerScore1);
        scoreFileManager.addScore(playerScore2);

        try {
            scoreFileManager.loadScoresFromDisk();
        }
        catch (Exception e){
            fail("Exception :",e);
        }
    }

    @Test
    public void testGetTopScores() {
        PlayerScore playerScore1 = new PlayerScore();
        playerScore1.setPlayerId("111");
        playerScore1.setPlayerName("Alice");
        playerScore1.setScore(200);

        PlayerScore playerScore2 = new PlayerScore();
        playerScore2.setPlayerId("222");
        playerScore2.setPlayerName("Bob");
        playerScore2.setScore(150);

        scoreFileManager.addScore(playerScore1);
        scoreFileManager.addScore(playerScore2);

        var topScores = scoreFileManager.getTopScores();

        // Assert that topScores contains the correct number of elements (at most 5)
        assertTrue(topScores.size() <= 5);

        // Assert that the top scores are sorted in descending order
        for (int i = 0; i < topScores.size() - 1; i++) {
            assertTrue(topScores.get(i).getScore() >= topScores.get(i + 1).getScore());
        }
    }
}
