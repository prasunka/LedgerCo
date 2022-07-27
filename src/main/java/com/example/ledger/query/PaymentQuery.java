package com.example.ledger.query;

import com.example.ledger.account.AccountManager;

public class PaymentQuery implements Query {
    private String bank;
    private String borrower;
    private int lumpSum;
    private int emiNumber;

    public PaymentQuery(String bank, String borrower, int lumpSum, int emiNumber) {
        this.bank = bank;
        this.borrower = borrower;
        this.lumpSum = lumpSum;
        this.emiNumber = emiNumber;
    }

    public void execute() {
        AccountManager.addNewPayment(bank, borrower, lumpSum, emiNumber);
    }
}
