package com.htkim.blackjack;


import java.util.ArrayList;

public class Player {

    private final Type playerType;

    private final String name;

    private Cards cards;

    public Player(Type type, String name) {
        this.playerType = type;
        this.name = name;
        cards = new Cards(new ArrayList<>());
    }

    public Type getType() {
        return playerType;
    }

    public String getName() {
        return name;
    }

    public boolean addCard(Card card) {
        return cards.addCard(card);
    }

    public Cards getCards() {
        return this.cards;
    }


    public enum Type {
        DEALER,
        GAMER
    }
}
