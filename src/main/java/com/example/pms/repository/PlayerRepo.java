package com.example.pms.repository;

import com.example.pms.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {
}
