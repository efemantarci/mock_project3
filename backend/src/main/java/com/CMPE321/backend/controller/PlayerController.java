package com.CMPE321.backend.controller;

import com.CMPE321.backend.Player;
import com.CMPE321.backend.Match;
import com.CMPE321.backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/{username}")
    public ResponseEntity<Player> getPlayer(@PathVariable String username) {
        Player player = playerRepository.findByUsername(username);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    @GetMapping("/{username}/matches")
    public ResponseEntity<List<Match>> getPlayerMatches(@PathVariable String username) {
        List<Match> matches = playerRepository.findMatchesByPlayer(username);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/{username}/stats")
    public ResponseEntity<Map<String, Object>> getPlayerStats(@PathVariable String username) {
        List<Match> matches = playerRepository.findMatchesByPlayer(username);

        int totalMatches = matches.size();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (Match match : matches) {
            String result = match.getResult();
            if (result != null) {
                if ("Draw".equals(result)) {
                    draws++;
                } else if ((match.getWhitePlayer().equals(username) && "White".equals(result)) ||
                          (match.getBlackPlayer().equals(username) && "Black".equals(result))) {
                    wins++;
                } else {
                    losses++;
                }
            }
        }

        double winRate = totalMatches > 0 ? (double) wins / totalMatches * 100 : 0.0;

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalMatches", totalMatches);
        stats.put("wins", wins);
        stats.put("losses", losses);
        stats.put("draws", draws);
        stats.put("winRate", Math.round(winRate * 100.0) / 100.0);

        return ResponseEntity.ok(stats);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerRepository.findAllPlayers();
        return ResponseEntity.ok(players);
    }
}