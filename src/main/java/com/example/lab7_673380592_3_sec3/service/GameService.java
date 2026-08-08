package com.example.lab7_673380592_3_sec3.service;

import com.example.lab7_673380592_3_sec3.model.Game;
import com.example.lab7_673380592_3_sec3.repository.GameRepository;

import com.example.lab7_673380592_3_sec3.strategy.DiscountContext;
import com.example.lab7_673380592_3_sec3.strategy.NoDiscountStrategy;
import com.example.lab7_673380592_3_sec3.strategy.StudentDiscountStrategy;
import com.example.lab7_673380592_3_sec3.strategy.SeasonalSaleStrategy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {

        List<Game> games = gameRepository.findAll();

        // คำนวณราคาสุทธิของแต่ละเกม
        for (Game game : games) {
            game.setFinalPrice(calculateFinalPrice(game));
        }

        return games;
    }

    public Game getGameById(Long id) {

        Game game = gameRepository.findById(id).orElse(null);

        if (game != null) {
            game.setFinalPrice(calculateFinalPrice(game));
        }

        return game;
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public double calculateFinalPrice(Game game) {

        DiscountContext context = new DiscountContext();

        String discountType = game.getDiscountType();

        if ("STUDENT".equalsIgnoreCase(discountType)) {

            context.setStrategy(
                    new StudentDiscountStrategy()
            );

        } else if ("SEASONAL".equalsIgnoreCase(discountType)) {

            context.setStrategy(
                    new SeasonalSaleStrategy()
            );

        } else {

            context.setStrategy(
                    new NoDiscountStrategy()
            );
        }

        return context.executeStrategy(game.getPrice());
    }
}