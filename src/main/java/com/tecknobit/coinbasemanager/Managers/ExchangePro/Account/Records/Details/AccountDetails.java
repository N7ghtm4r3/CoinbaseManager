package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records.Details;

/**
 * The {@code AccountDetails} class is useful to format all base data of Coinbase account objects
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class AccountDetails {

    private final String createdAt;
    private final String id;
    private double amount;
    private String type;

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

    public void setAmount(double amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Amount value cannot be less than 0");
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type == null || type.isBlank())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        this.type = type;
    }

}
