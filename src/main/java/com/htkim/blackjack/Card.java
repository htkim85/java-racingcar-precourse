package com.htkim.blackjack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Card {

    private final Type type;
    // 1 - 13
    private final int number;

    public Type getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    public String getCardName() {

        String expressName = "";
        if( number == 1 ) {
            expressName = "A";
        }

        if( number == 11 ) {
            expressName = "J";
        }
        if( number == 12) {
            expressName = "Q";
        }
        if( number == 13 ) {
            expressName = "K";
        }

        if( number > 1 && number <=10) {
            expressName = String.valueOf(number);
        }

        return  expressName + this.type.koName;
    }

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

    private static final Map<Type, List<Card>> cacheMap = new HashMap<>();

    private Card(Type type, int num) {
        this.number = num;
        this.type = type;
    }

    static {
        cacheMap.put(Type.DIAMOND, genNumber(Type.DIAMOND));
        cacheMap.put(Type.CLOVER, genNumber(Type.CLOVER));
        cacheMap.put(Type.SPADE, genNumber(Type.SPADE));
        cacheMap.put(Type.HEART, genNumber(Type.HEART));
    }


    private static List<Card> genNumber(Type type) {
        return IntStream.rangeClosed(1, 13)
                .mapToObj(cardNum -> new Card(type, cardNum))
                .collect(Collectors.toList());
    }

    public static Card from(Type type, int num) {
        validate(num);
        return cacheMap.get(type).get(num - 1);
    }

    private static void validate(int num) throws IllegalArgumentException {
        if( num < 1 || num > 13 ) throw new IllegalArgumentException("카드 유효범위에 맞지 않습니다. 1 - 13");
    }
}
