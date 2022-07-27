package com.example.ledger.payment;

public class Payment {
    private int lumpSum;
    private int emiNumber;

    public int getLumpSum() {
        return lumpSum;
    }

    public int getEmiNumber() {
        return emiNumber;
    }

    public Payment(int lumpSum, int emiNumber) {
        this.lumpSum = lumpSum;
        this.emiNumber = emiNumber;
    }
}
