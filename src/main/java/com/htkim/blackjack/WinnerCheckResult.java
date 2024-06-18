package com.htkim.blackjack;

public class WinnerCheckResult {
    private final Player player;
    private final WinnerCheck.Result result;

    public Player getPlayer() {
        return player;
    }

    public WinnerCheck.Result getResult() {
        return result;
    }

    public WinnerCheckResult(Player player, WinnerCheck.Result result) {
        this.player = player;
        this.result = result;
    }
}
