package com.htkim.blackjack;

import java.util.Random;

public class RandomCardGenerator implements CardGenerator {

    private final Random random = new Random();

    @Override
    public Card generate() {
        return Card.from(this.generateRandomType(), this.generateRandomNumber());
    }

    private Card.Type generateRandomType() {
        return Card.Type.values()[this.random.nextInt(Card.Type.values().length)];
    }

    private int generateRandomNumber() {
        return this.random.nextInt(1, 14);
    }
}
