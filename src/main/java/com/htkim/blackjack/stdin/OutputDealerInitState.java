package com.htkim.blackjack.stdin;

import com.htkim.blackjack.Card;
import com.htkim.blackjack.Player;
import com.htkim.blackjack.Players;

public class OutputDealerInitState implements OutputToStdOut<Player> {
    @Override
    public void print(Player dealer) {
        printDealerState(dealer);
    }

    private void printDealerState(Player dealer) {
        Card card = dealer.getCards().stream().findAny().orElseThrow();
        String str = "%s: %s".formatted(dealer.getName(), card.getCardName());
        System.out.println(str);
    }
}
