package com.htkim.blackjack.stdin;

import com.htkim.blackjack.Card;
import com.htkim.blackjack.Player;

import java.util.stream.Collectors;

public class OutputPlayerState implements OutputToStdOut<Player> {
    @Override
    public void print(Player player) {
        String cardNames = player.getCards().stream().map(Card::getCardName).collect(Collectors.joining(", "));
        int sum = player.getCards().stream().mapToInt(Card::getNumber).sum();
        System.out.println(player.getName() + " 카드: " + cardNames + " - 결과: " + sum);
    }
}
