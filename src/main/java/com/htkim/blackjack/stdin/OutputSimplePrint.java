package com.htkim.blackjack.stdin;

public class OutputSimplePrint implements OutputToStdOut<String> {
    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
