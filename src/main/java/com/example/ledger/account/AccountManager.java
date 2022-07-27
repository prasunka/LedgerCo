package com.example.ledger.account;

import com.example.ledger.loan.Loan;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static Map<String, Map<String, Loan>> loanDetails = new HashMap<>();

    public static void registerNewLoan(String bank, String borrower, int principal, int years, int rateOfInterest){
        Loan loan = new Loan(principal, years, rateOfInterest);
        if(loanDetails.containsKey(borrower)){
            loanDetails.get(borrower).put(bank, loan);
        } else {
            Map<String, Loan> entry = new HashMap<>();
            entry.put(bank, loan);
            loanDetails.put(borrower, entry);
        }
    }

    public static void addNewPayment(String bank, String borrower, int lumpSum, int emiNumber){
        if(loanDetails.containsKey(borrower)){
            Map<String, Loan> entry = loanDetails.get(borrower);
            if(entry.containsKey(bank)){
                Loan loan = entry.get(bank);
                loan.addNewPayment(lumpSum, emiNumber);
            }
        }
    }

    public static void printBalance(String bank, String borrower, int emiNumber){
        if(loanDetails.containsKey(borrower)){
            Map<String, Loan> entry = loanDetails.get(borrower);
            if(entry.containsKey(bank)){
                Loan loan = entry.get(bank);
                int totalAmountPaid = loan.getTotalAmountPaid(emiNumber);
                int remainingEmis = loan.getRemainingNumberOfEmis(emiNumber);

                System.out.println(bank + " " + borrower + " " + totalAmountPaid + " " + remainingEmis);
            }
        }
    }
}
