package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandTest {

    @Test
    public void handWithQand9and3IsValuedAs22() throws Exception {
        Hand hand = HandFactory.createHand("Q", "9", "3");

        assertThat(hand.value())
                .isEqualTo(22);
    }

    @Test
    public void handValuedAt22IsBusted() throws Exception {
        Hand hand = HandFactory.createHand("Q", "9", "3");

        assertThat(hand.isBusted())
                .isTrue();
    }

    @Test
    public void handValuedAt21IsNotBusted() throws Exception {
        Hand hand = HandFactory.createHand("Q", "9", "2");

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handValuedAt20IsNotBusted() throws Exception {
        Hand hand = HandFactory.createHand("Q", "J");

        assertThat(hand.isBusted())
                .isFalse();
    }


}
