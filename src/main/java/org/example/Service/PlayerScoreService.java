package org.example.Service;

import org.example.Entity.PlayerScore;
import org.example.Repository.PlayerScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerScoreService {
    @Autowired
    private PlayerScoreRepository playerScoreRepository;

    private final ScoreFileManager scoreFileManager;

    public PlayerScoreService(ScoreFileManager scoreFileManager) {
        this.scoreFileManager = scoreFileManager;
    }
    public List<PlayerScore> getTop5Scores() {

        return scoreFileManager.getTopScores();
//        return playerScoreRepository.findTop5ByOrderByScoreDesc();
    }

    public void addScore(PlayerScore playerScore) {

        scoreFileManager.addScore(playerScore);

        //saving the record in db
//        playerScoreRepository.save(playerScore);
    }
}

