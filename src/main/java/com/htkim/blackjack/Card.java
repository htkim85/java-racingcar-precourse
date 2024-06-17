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

    public enum Type {
        DIAMOND,
        CLOVER,
        SPADE,
        HEART
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
