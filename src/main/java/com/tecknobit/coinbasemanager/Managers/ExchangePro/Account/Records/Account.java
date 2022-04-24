package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records;

/**
 * The {@code Account} class is useful to format Account object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Account {

    private final String id;
    private final String currency;
    private final double balance;
    private final double available;
    private final double hold;
    private final String profileId;
    private final boolean tradingEnable;

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

    public double getBalance() {
        return balance;
    }

    public double getAvailable() {
        return available;
    }

    public double getHold() {
        return hold;
    }

    public String getProfileId() {
        return profileId;
    }

    public boolean isTradingEnable() {
        return tradingEnable;
    }

}
