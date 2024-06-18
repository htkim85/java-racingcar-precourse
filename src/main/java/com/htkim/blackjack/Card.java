package com.htkim.blackjack;

import java.util.*;

public class Card {

    private final Type type;
    // 1 - 13
    private final int number;

    private final int score;

    private final String expressName;

    private static final Map<Type, List<Card>> cacheMap = new HashMap<>();

    private static final Map<Integer, String> cardNames = new HashMap<>();
    public enum Type {
        DIAMOND("다이아몬드"),
        CLOVER("클로버"),
        SPADE("스페이드"),
        HEART("하트");

        public String getKoName() {
            return koName;
        }

        private String koName;
        Type(String ko) {
            this.koName = ko;
        }
    }
    private Card(Type type, int num, int score, String expressName) {
        this.number = num;
        this.type = type;
        this.score = score;
        this.expressName = expressName;
    }

    static {
        cacheMap.put(Type.DIAMOND, genNumber(Type.DIAMOND));
        cacheMap.put(Type.CLOVER, genNumber(Type.CLOVER));
        cacheMap.put(Type.SPADE, genNumber(Type.SPADE));
        cacheMap.put(Type.HEART, genNumber(Type.HEART));
    }


    private static List<Card> genNumber(Type type) {
        return List.of(
                new Card(type, 1, 1, "A"),
                new Card(type, 1, 11, "A"),
                new Card(type, 2, 2, "2"),
                new Card(type, 3, 3, "3"),
                new Card(type, 4, 4, "4"),
                new Card(type, 5, 5, "5"),
                new Card(type, 6, 6, "6"),
                new Card(type, 7, 7, "7"),
                new Card(type, 8, 8, "8"),
                new Card(type, 9, 9, "9"),
                new Card(type, 10, 10, "10"),
                new Card(type, 11, 10, "J"),
                new Card(type, 12, 10, "Q"),
                new Card(type, 13, 10, "K")
        );
    }

    public static Card from(Type type, int num) {
        validate(num);
        return cacheMap.get(type).get(num - 1);
    }

    private static void validate(int num) throws IllegalArgumentException {
        if( num < 1 || num > 13 ) throw new IllegalArgumentException("카드 유효범위에 맞지 않습니다. 1 - 13");
    }

    public Type getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    public int getScore() {
        return this.score;
    }

    public String getCardName() {
//        String expressName = cardNames.getOrDefault(number, String.valueOf(number));
        return this.expressName + this.type.koName + "(" + score + ")";
    }
}
