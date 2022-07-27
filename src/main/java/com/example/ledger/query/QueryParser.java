package com.example.ledger.query;

import static java.lang.Integer.parseInt;

public class QueryParser {
    public static final String LOAN_QUERY = "LOAN";
    public static final String PAYMENT_QUERY = "PAYMENT";
    public static final String BALANCE_QUERY = "BALANCE";

    public static void executeQuery(String query){
        Query q = QueryParser.parse(query);
        if(q!=null) q.execute();
    }

    public static Query parse(String query){
        String[] result = query.split(" ");
        switch (result[0]){
            case LOAN_QUERY:
                return new LoanQuery(result[1], result[2], parseInt(result[3]), parseInt(result[4]), parseInt(result[5]));
            case PAYMENT_QUERY:
                return new PaymentQuery(result[1], result[2], parseInt(result[3]), parseInt(result[4]));
            case BALANCE_QUERY:
                return new BalanceQuery(result[1], result[2], parseInt(result[3]));

            default:
                System.out.println("Invalid Query!!");
        }

        return null;
    }
}
