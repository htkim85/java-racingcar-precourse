package com.htkim.blackjack.stdin;

import com.htkim.blackjack.Card;
import com.htkim.blackjack.Player;
import com.htkim.blackjack.Players;

import java.util.stream.Collectors;

public class OutputPlayerInitState implements OutputToStdOut<Players> {
    @Override
    public void print(Players players) {
        String names = players.stream()
                .filter(player -> player.getType() == Player.Type.GAMER)
                .map(Player::getName)
                .collect(Collectors.joining(", "));
        System.out.println();
        System.out.printf("딜러와 %s에게 2장의 카드를 나누었습니다.%n", names);
        printDealerState(players);
        printGamerState(players);
    }

    private void printDealerState(Players dealer) {
        dealer.stream().filter(p -> p.getType() == Player.Type.DEALER)
                .forEach(p -> {
                    Card card = p.getCards().stream().findAny().orElseThrow();
                    String str = "%s: %s".formatted(p.getName(), card.getCardName());
                    System.out.println(str);
                });
    }
    private void printGamerState(Players gamer) {
        gamer.stream().filter(p -> p.getType() == Player.Type.GAMER)
                .forEach(p -> {
                    String cards = p.getCards().stream().map(Card::getCardName)
                            .collect(Collectors.joining(", "));
                    String str = "%s: %s".formatted(p.getName(), cards);
                    System.out.println(str);
                });
    }
}
