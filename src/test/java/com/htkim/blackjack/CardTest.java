package com.htkim.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class CardTest {

    @Test
    void create() {
        Card card = Card.from(Card.Type.DIAMOND, 1);
        Assertions.assertThat(card.getType()).isEqualTo(Card.Type.DIAMOND);
        Assertions.assertThat(card.getNumber()).isEqualTo(1);
    }

    @Test
    void 유효범위체크() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Card.from(Card.Type.DIAMOND, 0));
    }
}