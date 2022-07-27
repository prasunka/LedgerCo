package com.example.ledger.query;

import com.example.ledger.account.AccountManager;

public class LoanQuery implements Query {
    private String bank;
    private String borrower;
    private int principal;
    private int years;
    private int rateOfInterest;

    public LoanQuery(String bank, String borrower, int principal, int years, int rateOfInterest) {
        this.bank = bank;
        this.borrower = borrower;
        this.principal = principal;
        this.years = years;
        this.rateOfInterest = rateOfInterest;
    }

    public void execute() {
        AccountManager.registerNewLoan(bank, borrower, principal, years, rateOfInterest);
    }
}
