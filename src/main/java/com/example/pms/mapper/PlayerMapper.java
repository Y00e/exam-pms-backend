package com.example.pms.mapper;

import com.example.pms.dto.PlayerDto;
import com.example.pms.entity.Player;

public class PlayerMapper {

    public static PlayerDto mapToPlayerDto(Player player) {
        return new PlayerDto(
                player.getId(),
                player.getFirstName(),
                player.getLastName(),
                player.getEmail(),
                player.getBirthday(),
                player.getPhoneNumber()
        );
    }

    public static Player mapToPlayer(PlayerDto playerDto) {
        return new Player(
                playerDto.getId(),
                playerDto.getFirstName(),
                playerDto.getLastName(),
                playerDto.getEmail(),
                playerDto.getBirthday(),
                playerDto.getPhoneNumber()
        );
    }
}