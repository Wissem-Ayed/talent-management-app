package com.mytalent.testapp.controllers;

import com.mytalent.testapp.dtos.CreatePlayerRequest;
import com.mytalent.testapp.entities.Player;
import com.mytalent.testapp.repositories.PlayerRepository;
import com.mytalent.testapp.services.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody CreatePlayerRequest dto) {
        Player saved = playerService.createPlayer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}