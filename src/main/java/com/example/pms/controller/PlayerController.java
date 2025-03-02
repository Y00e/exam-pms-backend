package com.example.pms.controller;

import com.example.pms.dto.PlayerDto;
import com.example.pms.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private PlayerService playerService;

    // Build Add Player REST API
    @PostMapping
    public ResponseEntity<PlayerDto> create(@RequestBody PlayerDto playerDto){
        PlayerDto savedPlayer = playerService.createPlayer(playerDto);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    // Build Get Player REST API
    @GetMapping("{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable("id") Long playerId){
        PlayerDto playerDto = playerService.getPlayerById(playerId);
        return ResponseEntity.ok(playerDto);
    }

    // Build Get All Players REST API
    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers(){
        List<PlayerDto> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    // Build Update Player REST API
    @PutMapping("{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable("id") Long playerId,
                                                  @RequestBody PlayerDto updatedPlayer){
        PlayerDto playerDto = playerService.updatePlayer(playerId, updatedPlayer);
        return ResponseEntity.ok(playerDto);

    }


    // Build Delete Player REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable("id") Long playerId){
        playerService.deletePlayer(playerId);
        return ResponseEntity.ok("Player deleted successfully!.");
    }
}
