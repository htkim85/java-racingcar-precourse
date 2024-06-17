package com.htkim.blackjack;

public class Player {

    private final Type playerType;

    private final String name;

    private List<Card> cards;

    public Player(Type type, String name) {
        this.playerType = type;
        this.name = name;
    }

    public Type getType() {
        return playerType;
    }

    public String getName() {
        return name;
    }


    public enum Type {
        DEALER,
        GAMER
    }
}
