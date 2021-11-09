package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    // Arrange, Act, Assert
    // Setup, Execute, Verify
    // Given, When, Then

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Hand hand = HandFactory.createHand("A", "5");

        assertThat(hand.value())
                .isEqualTo(11 + 5);
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Hand hand = HandFactory.createHand("A", "8", "3");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 3);
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo12IsValuedAt1() throws Exception {
        Hand hand = HandFactory.createHand("A", "8", "4");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 4);
    }

    @Test
    public void handWithOneAceAndTenValueCardAceIsValuedAt11() throws Exception {
        Hand hand = HandFactory.createHand("A", "10");

        assertThat(hand.value())
                .isEqualTo(11 + 10); // EVIDENT DATA
    }

}
