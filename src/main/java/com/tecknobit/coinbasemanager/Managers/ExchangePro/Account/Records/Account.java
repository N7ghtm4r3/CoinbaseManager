package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records;

/**
 * The {@code Account} class is useful to format Account object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Account {

    private final String id;
    private String currency;
    private double balance;
    private double available;
    private double hold;
    private final String profileId;
    private boolean tradingEnable;

    public Account(String id, String currency, double balance, double available, double hold, String profileId,
                   boolean tradingEnable) {
        this.id = id;
        this.currency = currency;
        this.balance = balance;
        this.available = available;
        this.hold = hold;
        this.profileId = profileId;
        this.tradingEnable = tradingEnable;
    }

    public String getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if(currency == null || currency.isBlank())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        this.balance = balance;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        if(available < 0)
            throw new IllegalArgumentException("Available value cannot be less than 0");
        this.available = available;
    }

    public double getHold() {
        return hold;
    }

    public void setHold(double hold) {
        if(hold < 0)
            throw new IllegalArgumentException("Hold value cannot be less than 0");
        this.hold = hold;
    }

    public String getProfileId() {
        return profileId;
    }

    public boolean isTradingEnable() {
        return tradingEnable;
    }

    public void setTradingEnable(boolean tradingEnable) {
        this.tradingEnable = tradingEnable;
    }

}
