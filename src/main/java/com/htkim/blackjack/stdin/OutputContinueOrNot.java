package com.htkim.blackjack.stdin;

public class OutputContinueOrNot implements OutputToStdOut<String> {
    @Override
    public void print(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }
}
