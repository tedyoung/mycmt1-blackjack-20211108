package com.jitterted.ebp.blackjack;

public class Wallet {
    private int balance;

    public Wallet() {
        balance = 0;
    }

    public boolean isEmpty() {
        return balance == 0;
    }

    public void addMoney(int amount) {
        requireGreaterThanZero(amount);
        balance += amount;
    }

    public int balance() {
        return balance;
    }

    // boolean canBet(int betAmount)
    // balance >= betAmount <-- maybe? plus a little credit

    public void bet(int betAmount) {
        requireZeroOrMore(betAmount);
        requireSufficientBalanceToBet(betAmount);
        balance -= betAmount;
    }

    private void requireZeroOrMore(int betAmount) {
        if (betAmount < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void requireSufficientBalanceToBet(int betAmount) {
        if (balance < betAmount) {
            throw new IllegalStateException();
        }
    }

    private void requireGreaterThanZero(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
