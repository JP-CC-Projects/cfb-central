package com.jpcc.CFBProject.controller;

import com.jpcc.CFBProject.domain.boxscore.BoxScore;
import com.jpcc.CFBProject.services.BoxScoreService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
public class BoxScoreController {

    private final BoxScoreService boxScoreService;

    public BoxScoreController(BoxScoreService boxScoreService) {
        this.boxScoreService = boxScoreService;
    }

    @GetMapping("/box-score/{gameId}")
    public ResponseEntity<BoxScore> getBoxScoreByGameId(
            @PathVariable(required = true) Long gameId) throws Exception {
        BoxScore boxScore = boxScoreService.fetechSaveAndReturnBoxScore(gameId);
        return ResponseEntity.ok(boxScore);
    }
}
