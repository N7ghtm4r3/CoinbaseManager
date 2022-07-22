package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records.Details;

/**
 * The {@code AccountDetails} class is useful to format all base data of Coinbase account objects
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class AccountDetails {

    /**
     * {@code createdAt} is instance that memorizes created at value
     * **/
    protected final String createdAt;

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    protected final String id;

    /**
     * {@code amount} is instance that memorizes amount value
     * **/
    protected double amount;

    /**
     * {@code type} is instance that memorizes type value
     * **/
    protected String type;

    /** Constructor to init a {@link AccountDetails} object
     * @param createdAt: created at value
     * @param id: identifier value
     * @param amount: amount value
     * @param type: type value
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public AccountDetails(String createdAt, String id, double amount, String type) {
        this.createdAt = createdAt;
        this.id = id;
        if(amount < 0)
            throw new IllegalArgumentException("Amount value cannot be less than 0");
        else
            this.amount = amount;
        if(type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        else
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

    /** Method to set {@link #amount}
     * @param amount: amount value
     * @throws IllegalArgumentException when amount value is less than 0
     * **/
    public void setAmount(double amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Amount value cannot be less than 0");
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    /** Method to set {@link #type}
     * @param type: type value
     * @throws IllegalArgumentException when type value null or is empty
     * **/
    public void setType(String type) {
        if(type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }

}
