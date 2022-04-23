package com.tecknobit.coinbasemanager.Managers.Transfers.Records;

public class Deposit {

    private final String id;
    private final double amount;
    private final String currency;
    private final String payoutAt;
    private final double fee;
    private final double subTotal;

    public Deposit(String id, double amount, String currency, String payoutAt, double fee, double subTotal) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.payoutAt = payoutAt;
        this.fee = fee;
        this.subTotal = subTotal;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPayoutAt() {
        return payoutAt;
    }

    public double getFee() {
        return fee;
    }

    public double getSubTotal() {
        return subTotal;
    }

}
