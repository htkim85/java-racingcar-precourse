package com.htkim.blackjack;

import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards(Card ... cards ) {
        this.cards = List.of(cards);
    }

    public boolean addCard(Card card) {
        return this.cards.add(card);
    }

    public int blackJackNumber() {
        return cards.stream().mapToInt(Card::getNumber).sum();
    }
}
