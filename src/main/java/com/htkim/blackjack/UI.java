package com.htkim.blackjack;

import com.htkim.blackjack.stdin.*;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    private Scanner scanner;

    private Players players;

    private Player dealer;

    private RandomCardGenerator randomCardGenerator;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputPlayerNames() {
        new OutputSimplePrint().print("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        this.players = new InputPlayers().read(scanner);
        this.dealer = new Player(Player.Type.DEALER, "딜러");
    }

    public void initBlackJackGame() {
        this.randomCardGenerator = new RandomCardGenerator(new Random());
        this.players.stream().forEach(player -> {
            player.addCard(randomCardGenerator.generate());
            player.addCard(randomCardGenerator.generate());
        });

        this.dealer.addCard(randomCardGenerator.generate());
        this.dealer.addCard(randomCardGenerator.generate());

        new OutputPlayerInitState().print(this.players);
        new OutputDealerInitState().print(this.dealer);
    }

    public void startBlackJackGame() {
        startPlayersGame();
        startDealerGame();
    }

    private void startPlayersGame() {
        InputContinueOrNot stdIn = new InputContinueOrNot();
        OutputToStdOut outputContinueOrNot = new OutputContinueOrNot();
        OutputToStdOut outputPlayerCardState = new OutputPlayerCardState();

        players.stream().forEach(player -> {

            while (true) {
                outputContinueOrNot.print(player.getName());
                String result = stdIn.read(scanner);
                if (result.equals("n")) {
                    break;
                }
                if (result.equals("y")) {
                    // card
                    player.addCard(randomCardGenerator.generate());
                }
                outputPlayerCardState.print(player);
            }
        });
    }

    private void startDealerGame() {
        while (true) {
            int sum = dealer.getCards().blackJackNumber();
            if (sum > 17) {
                break;
            }
            new OutputSimplePrint().print(dealer.getName() + "는 16이하라 한장의 카드를 더 받았습니다.");
            dealer.addCard(randomCardGenerator.generate());
        }
    }

    public void gameResult() {
        OutputToStdOut outputPlayerState = new OutputPlayerState();
        outputPlayerState.print(dealer);
        this.players.stream().forEach(player -> outputPlayerState.print(player));
    }

    public void winnerResult() {
        OutputSimplePrint simplePrint = new OutputSimplePrint();
        int dealerScore = dealer.getCards().blackJackNumber();
        WinnerCheck winnerCheck = new WinnerCheck();

        List<WinnerCheckResult> result = players.stream()
                .map(player -> winnerCheck.checkWinner(dealerScore, player)).toList();

        Map<WinnerCheck.Result, List<WinnerCheckResult>> grouped = result.stream().collect(Collectors.groupingBy(WinnerCheckResult::getResult));
        simplePrint.print(dealer.getName() + ": " + getSize(grouped.get(WinnerCheck.Result.DEALER_WIN))+"승 " +
                getSize(grouped.get(WinnerCheck.Result.PLAYER_WIN))+"패 " + getSize(grouped.get(WinnerCheck.Result.DRAW)) + "무");
        result.forEach(wc -> {
            simplePrint.print(wc.getPlayer().getName() + ": " + wc.getResult().getKoName());
        });
    }

    private int getSize(List<WinnerCheckResult> list ) {
        if( list == null ) return 0;
        return list.size();
    }
}
