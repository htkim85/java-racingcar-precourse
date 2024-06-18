package com.htkim.blackjack;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UI ui = new UI(scanner);
        ui.inputPlayerNames();
        ui.initBlackJackGame();
        ui.startBlackJackGame();
        ui.gameResult();
        ui.winnerResult();
    }
}
