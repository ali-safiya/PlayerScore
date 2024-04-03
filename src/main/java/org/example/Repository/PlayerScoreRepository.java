package org.example.Repository;

import org.example.Entity.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {
    List<PlayerScore> findTop5ByOrderByScoreDesc();
}

