package com.example.lab7_673380592_3_sec3.strategy;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price;
    }
}