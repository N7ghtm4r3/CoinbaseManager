package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records.Details;

/**
 * The {@code AccountDetails} class is useful to format all base data of Coinbase account objects
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class AccountDetails {

    private final String createdAt;
    private final String id;
    private final double amount;
    private final String type;

    public AccountDetails(String createdAt, String id, double amount, String type) {
        this.createdAt = createdAt;
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

}
