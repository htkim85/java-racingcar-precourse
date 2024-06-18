package com.htkim.blackjack.stdin;

import com.htkim.blackjack.Player;

public class OutputGameResult implements OutputToStdOut<Player> {
    @Override
    public void print(Player player) {
        System.out.println("##최종 승패");

    }

}
