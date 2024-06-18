package com.htkim.blackjack;

import java.util.List;
import java.util.stream.Stream;

public class Players {

    private List<Player> players;

    public Players(Player ... players) {
        this.players = List.of(players);
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }

    public boolean add(Player player) {
        return players.add(player);
    }

    public Stream<Player> stream() {
        return this.players.stream();
    }

    public int size() {
        return this.players.size();
    }
}
