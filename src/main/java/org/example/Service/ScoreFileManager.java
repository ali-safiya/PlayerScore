package org.example.Service;

import org.example.Entity.PlayerScore;

import java.util.*;
import java.io.*;

public class ScoreFileManager {
    private static final String FILE_PATH = "H:\\playersData.txt";
    private PriorityQueue<PlayerScore> scoreQueue;

    public ScoreFileManager() {
        scoreQueue = new PriorityQueue<>(Comparator.comparingInt(PlayerScore::getScore).reversed());
        loadScoresFromDisk();
    }

    public void loadScoresFromDisk() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    PlayerScore playerScore = new PlayerScore();
                    playerScore.setPlayerId(parts[0]);
                    playerScore.setPlayerName(parts[1]);
                    playerScore.setScore(Integer.parseInt(parts[2]));
                    scoreQueue.offer(playerScore);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void addScore(PlayerScore playerScore) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(playerScore.getPlayerId() + "," + playerScore.getPlayerName() + ","+  playerScore.getScore());
            writer.newLine();
            scoreQueue.offer(playerScore); // Update priority queue
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PlayerScore> getTopScores() {
        List<PlayerScore> topScores = new ArrayList<>();
        int count = 5; // Get top 5 scores
        while (count-- > 0 && !scoreQueue.isEmpty()) {
            topScores.add(scoreQueue.poll());
        }
        return topScores;
    }
}

