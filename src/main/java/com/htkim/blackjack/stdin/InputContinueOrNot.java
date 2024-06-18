package com.htkim.blackjack.stdin;

import java.util.Scanner;

public class InputContinueOrNot implements InputFromStdIn<String> {
    @Override
    public String read(Scanner scanner) {
        try {
            String answer = scanner.nextLine();
            validate(answer);
            return answer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.read(scanner);
        }
    }

    private void validate(String yesOrNo) {
        if (!yesOrNo.equals("y") && !yesOrNo.equals("n")) {
            throw new IllegalArgumentException("입력값은 소문자 y or n 입니다.");
        }
    }
}
