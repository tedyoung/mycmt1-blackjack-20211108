package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

    @Test
    public void newWalletIsEmpty() throws Exception {
        Wallet wallet = new Wallet();

        assertThat(wallet.isEmpty())
                .isTrue();
    }

    @Test
    public void walletAddMoneyThenIsNotEmpty() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(1);

        assertThat(wallet.isEmpty())
                .isFalse();
    }

    @Test
    public void newWalletThenBalanceIsZero() throws Exception {
        Wallet wallet = new Wallet();

        assertThat(wallet.balance())
                .isZero();
    }

    @Test
    public void newWalletAddMoney7ThenBalanceIs7() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(7);

        assertThat(wallet.balance())
                .isEqualTo(7);
    }

    @Test
    public void newWalletAddMoney9AndAdd12ThenBalanceIs21() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(9);
        wallet.addMoney(12);

        assertThat(wallet.balance())
                .isEqualTo(9 + 12);
    }

    @Test
    public void walletAddNegativeMoneyThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void walletAddZeroMoneyThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
