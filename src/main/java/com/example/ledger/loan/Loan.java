package com.example.ledger.loan;

import com.example.ledger.payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    private int principal;
    private int years;
    private int rateOfInterest;
    private int totalAmount;
    private int emiAmount;

    private List<Payment> paymentList = new ArrayList<Payment>();

    public Loan(int principal, int years, int rateOfInterest) {
        this.principal = principal;
        this.years = years;
        this.rateOfInterest = rateOfInterest;
        this.totalAmount = principal + (int) Math.ceil((principal * rateOfInterest * years) / 100.0);
        this.emiAmount = (int) Math.ceil(totalAmount / (years * 12.0));
    }

    public int getTotalAmountPaid(int emiNumber){
        int emiPaid = emiAmount * emiNumber;
        if (emiPaid > totalAmount){
            emiPaid = totalAmount;
        }
        int lumpSumPaid = 0;
        for(Payment payment: paymentList){
            if(payment.getEmiNumber() > emiNumber) break;
            lumpSumPaid += payment.getLumpSum();
        }
        return emiPaid + lumpSumPaid;
    }

    public int getRemainingNumberOfEmis(int emiNumber){
        int totalAmountPaid = getTotalAmountPaid(emiNumber);
        return (int) Math.ceil((totalAmount - totalAmountPaid) / (double) emiAmount);
    }

    public void addNewPayment(int lumpSum, int emiNumber){
        Payment payment = new Payment(lumpSum, emiNumber);
        if(paymentList.isEmpty() || paymentList.get(paymentList.size() - 1).getEmiNumber() < emiNumber) {
            paymentList.add(payment);
        }
        else {
            for(int i = 0; i < paymentList.size(); ++i){
                if(paymentList.get(i).getEmiNumber() > emiNumber){
                    paymentList.add(i, payment);
                    break;
                }
            }
        }
    }
}
