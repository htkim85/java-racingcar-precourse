package com.htkim.blackjack;

public class WinnerCheck {

    public enum Result {
        PLAYER_WIN("승"),
        DEALER_WIN("패"),
        DRAW("무");

        private String koName;
        public String getKoName() {
            return koName;
        }

        Result(String result) {
            this.koName = result;
        }
    }

    public Result checkWinner(int dealerScore, int playerScore) {
        if( playerScore > 21 ) {
            return Result.DEALER_WIN;
        }

        if( dealerScore > 21 ) {
            return Result.PLAYER_WIN;
        }

        int differenceDealer = 21 - dealerScore;
        int differencePlayer = 21 - playerScore;

        if( differenceDealer > differencePlayer ) {
            return Result.PLAYER_WIN;
        }

        if( differenceDealer < differencePlayer ) {
            return Result.DEALER_WIN;
        }

        return Result.DRAW;
    }


    public WinnerCheckResult checkWinner(int dealerScore, Player player) {
        int playerSum = player.getCards().blackJackNumber();
        return new WinnerCheckResult(player,  this.checkWinner(dealerScore, playerSum));
    }
}
