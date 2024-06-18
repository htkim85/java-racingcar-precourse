package com.htkim.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cards {
    private List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean addCard(Card card) {
        return this.cards.add(card);
    }

    public int blackJackNumber() {
        return cards.stream().mapToInt(Card::getScore).sum();
    }

    public Stream<Card> stream() {
        return cards.stream();
    }
}
