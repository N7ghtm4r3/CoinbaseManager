package com.tecknobit.coinbasemanager.Managers.Conversions.Records;

public class CurrencyConversion {

    private final String id;
    private final double amount;
    private final String fromAccountId;
    private final String toAccountId;
    private final String from;
    private final String to;

    public CurrencyConversion(String id, double amount, String fromAccountId, String toAccountId, String from, String to) {
        this.id = id;
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.from = from;
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

}
