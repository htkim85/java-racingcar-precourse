package com.htkim.blackjack;

public class WinnerCheck {

    public enum Result {
        PLAYER_WIN,
        DEALER_WIN,
        DRAW
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
}
