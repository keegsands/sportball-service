package org.keegsands.sportball.controller;

import org.keegsands.sportball.model.Game;
import org.keegsands.sportball.model.Season;
import org.keegsands.sportball.service.GameService;
import org.keegsands.sportball.service.SeasonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.list();
        return ResponseEntity.ok(games);
    }
}
