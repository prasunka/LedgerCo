package com.example.ledger.query;

import com.example.ledger.account.AccountManager;

public class BalanceQuery implements Query {
    private String bank;
    private String borrower;
    private int emiNumber;

    public BalanceQuery(String bank, String borrower, int emiNumber) {
        this.bank = bank;
        this.borrower = borrower;
        this.emiNumber = emiNumber;
    }

    public void execute() {
        AccountManager.printBalance(bank, borrower, emiNumber);
    }
}
