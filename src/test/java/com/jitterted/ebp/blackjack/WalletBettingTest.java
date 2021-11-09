package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletBettingTest {

    @Test
    public void walletWithBalance12WhenBet8ThenBalanceIs4() throws Exception {
        Wallet wallet = createWalletWith(12);

        wallet.bet(8);

        assertThat(wallet.balance())
                .isEqualTo(12 - 8);
    }

    @Test
    public void walletWith27Bet7AndBet9ThenBalanceIs11() throws Exception {
        Wallet wallet = createWalletWith(27);

        wallet.bet(7);
        wallet.bet(9);

        assertThat(wallet.balance())
                .isEqualTo(27 - 7 - 9);
    }
    
    @Test
    public void betFullBalanceThenWalletIsEmpty() throws Exception {
        Wallet wallet = createWalletWith(73);

        wallet.bet(73);

        assertThat(wallet.isEmpty())
                .isTrue();
    }

    @Test
    public void betMoreThanBalanceThrowsException() throws Exception {
        Wallet wallet = createWalletWith(59);

        assertThatThrownBy(() -> {
            wallet.bet(60);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void betNegativeAmountThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.bet(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void betZeroIsAllowedDoesNotChangeBalance() throws Exception {
        Wallet wallet = new Wallet();

        wallet.bet(0);

        assertThat(wallet.balance())
                .isZero();
    }

    private Wallet createWalletWith(int initialBalance) {
        Wallet wallet = new Wallet();
        wallet.addMoney(initialBalance);
        return wallet;
    }
}
