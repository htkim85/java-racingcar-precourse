package com.htkim.blackjack.stdin;

import java.util.Scanner;

public interface InputFromStdIn<StdIn> {
    StdIn read(Scanner scanner);
}