package com.example.pms.service;

import com.example.pms.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    PlayerDto createPlayer(PlayerDto playerDto);

    PlayerDto getPlayerById(Long playerId);

    List<PlayerDto> getAllPlayers();

    PlayerDto updatePlayer(Long playerId, PlayerDto updatePlayer);

    void deletePlayer(Long playerId);

}
