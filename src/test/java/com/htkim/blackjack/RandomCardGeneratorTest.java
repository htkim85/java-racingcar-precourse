package com.htkim.blackjack;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomCardGeneratorTest {

    @RepeatedTest(100)
    void generate() {
        RandomCardGenerator randomCardGenerator = new RandomCardGenerator(new Random());
        Card card = randomCardGenerator.generate();
        assertThat(card).isNotNull();
    }

    @Test
    void randomTest() {
        RandomCardGenerator randomCardGenerator = new RandomCardGenerator(new TestRandom());
        Card card = randomCardGenerator.generate();
        assertThat(card.getType()).isEqualTo(Card.Type.values()[1]);
        assertThat(card.getNumber()).isEqualTo(1);
    }

    class TestRandom extends Random {
        @Override
        public int nextInt(int bound) {
            return 1;
        }

        @Override
        public int nextInt(int origin, int bound) {
            return 1;
        }
    }
}