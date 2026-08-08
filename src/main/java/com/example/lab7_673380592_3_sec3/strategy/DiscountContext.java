package com.example.lab7_673380592_3_sec3.strategy;

public class DiscountContext {

    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double price) {
        return strategy.calculateDiscount(price);
    }
}