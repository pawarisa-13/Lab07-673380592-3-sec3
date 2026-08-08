package com.example.lab7_673380592_3_sec3.repository;

import com.example.lab7_673380592_3_sec3.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}