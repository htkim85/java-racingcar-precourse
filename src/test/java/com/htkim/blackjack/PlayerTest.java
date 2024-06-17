package com.htkim.blackjack;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void 객체생성() {
        Player dealer = new Player(Player.Type.DEALER, "jin");
        Assertions.assertThat(dealer.getType()).isEqualTo(Player.Type.DEALER);
        Assertions.assertThat(dealer.getName()).isEqualTo("jin");
    }
}