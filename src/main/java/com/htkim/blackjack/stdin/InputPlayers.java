package com.htkim.blackjack.stdin;

import com.htkim.blackjack.Player;
import com.htkim.blackjack.Players;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputPlayers implements InputFromStdIn<Players> {

    @Override
    public Players read(Scanner scanner) {
        String playerNames = scanner.nextLine();
        return new Players(
                Arrays.stream(playerNames.split(","))
                        .map(String::trim)
                        .map(name -> new Player(Player.Type.GAMER, name))
                        .collect(Collectors.toList()));
    }
}
