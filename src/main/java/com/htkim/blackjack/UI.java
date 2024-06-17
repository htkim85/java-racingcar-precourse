package com.htkim.blackjack;

import com.htkim.blackjack.stdin.InputPlayers;
import com.htkim.blackjack.stdin.OutputPlayerInitState;
import com.htkim.blackjack.stdin.OutputSimplePrint;

import java.util.Random;
import java.util.Scanner;

public class UI {

    private Scanner scanner;

    private Players players;

    private RandomCardGenerator randomCardGenerator;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputPlayerNames() {
        new OutputSimplePrint().print("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        this.players = new InputPlayers().read(scanner);
        this.players.add(new Player(Player.Type.DEALER, "딜러"));
    }

    public void initBlackJackGame() {
        this.randomCardGenerator = new RandomCardGenerator(new Random());
        this.players.stream().forEach(player -> {
            player.addCard(randomCardGenerator.generate());
            player.addCard(randomCardGenerator.generate());
        });
        new OutputPlayerInitState().print(this.players);
    }
}
