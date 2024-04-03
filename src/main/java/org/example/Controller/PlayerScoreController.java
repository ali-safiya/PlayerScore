package org.example.Controller;

import org.example.Entity.PlayerScore;
import org.example.Service.PlayerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class PlayerScoreController {
    @Autowired
    private PlayerScoreService playerScoreService;

    @PostMapping("/add")
    public ResponseEntity<String> addScore(@RequestBody PlayerScore playerScore) {
        playerScoreService.addScore(playerScore);
        return ResponseEntity.ok("Score added successfully.");
    }

    @GetMapping("/top")
    public ResponseEntity<List<PlayerScore>> getTopScores() {
        List<PlayerScore> topScores = playerScoreService.getTop5Scores();
        return ResponseEntity.ok(topScores);
    }
}

