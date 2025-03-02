package com.example.pms.service.impl;

import com.example.pms.dto.PlayerDto;
import com.example.pms.entity.Player;
import com.example.pms.exception.ResourceNotFoundException;
import com.example.pms.mapper.PlayerMapper;
import com.example.pms.repository.PlayerRepo;
import com.example.pms.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepo playerRepo;
    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {

        Player player = PlayerMapper.mapToPlayer(playerDto);
        Player savedPlayer = playerRepo.save(player);
        return PlayerMapper.mapToPlayerDto(savedPlayer);
    }

    @Override
    public PlayerDto getPlayerById(Long playerId) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Player not found with given id: " + playerId));
        return PlayerMapper.mapToPlayerDto(player);
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepo.findAll();
        return players.stream().map((player) -> PlayerMapper.mapToPlayerDto(player))
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDto updatePlayer(Long playerId, PlayerDto updatePlayer) {

        Player player = playerRepo.findById(playerId).orElseThrow(
                () -> new ResourceNotFoundException("Player is not exists with given id: " + playerId)
        );

        player.setFirstName(updatePlayer.getFirstName());
        player.setLastName(updatePlayer.getLastName());
        player.setEmail(updatePlayer.getEmail());

        Player updatedPlayerObj = playerRepo.save(player);
        return PlayerMapper.mapToPlayerDto(updatedPlayerObj);
    }

    @Override
    public void deletePlayer(Long playerId) {

        Player player = playerRepo.findById(playerId).orElseThrow(
                () -> new ResourceNotFoundException("Player is not exists with given id: " + playerId)
        );

        playerRepo.deleteById(playerId);

    }
}
