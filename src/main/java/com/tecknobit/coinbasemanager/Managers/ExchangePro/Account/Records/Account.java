package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code Account} class is useful to format Account object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1</a>
 **/

public class Account {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code currency} is instance that memorizes currency value
     * **/
    private String currency;

    /**
     * {@code balance} is instance that memorizes balance value
     * **/
    private double balance;

    /**
     * {@code available} is instance that memorizes available value
     * **/
    private double available;

    /**
     * {@code hold} is instance that memorizes hold value
     * **/
    private double hold;

    /**
     * {@code profileId} is instance that memorizes profile identifier value
     * **/
    private final String profileId;

    /**
     * {@code tradingEnable} is flag that checks if trading is enabled
     * **/
    private boolean tradingEnable;

    /** Constructor to init a {@link Account} object
     * @param id: identifier value
     * @param currency: currency value
     * @param balance: balance value
     * @param available: available value
     * @param hold: hold value
     * @param profileId: profile identifier value
     * @param tradingEnable: flag that checks if trading is enabled
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Account(String id, String currency, double balance, double available, double hold, String profileId,
                   boolean tradingEnable) {
        this.id = id;
        if(currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        else
            this.currency = currency;
        if(balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        else
            this.balance = balance;
        if(available < 0)
            throw new IllegalArgumentException("Available value cannot be less than 0");
        else
            this.available = available;
        if(hold < 0)
            throw new IllegalArgumentException("Hold value cannot be less than 0");
        else
            this.hold = hold;
        this.profileId = profileId;
        this.tradingEnable = tradingEnable;
    }

    /** Constructor to init a {@link Account} object
     * @param account: account details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Account(JSONObject account){
        id = account.getString("id");
        currency = account.getString("currency");
        if(currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        balance = account.getDouble("balance");
        if(balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        available = account.getDouble("available");
        if(available < 0)
            throw new IllegalArgumentException("Available value cannot be less than 0");
        hold = account.getDouble("hold");
        if(hold < 0)
            throw new IllegalArgumentException("Hold value cannot be less than 0");
        profileId = account.getString("profile_id");
        tradingEnable = account.getBoolean("trading_enabled");
    }

    public String getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    /** Method to set {@link #currency}
     * @param currency: currency value
     * @throws IllegalArgumentException when currency value is null or empty
     * **/
    public void setCurrency(String currency) {
        if(currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    /** Method to get {@link #balance} instance
     * @param decimals: number of digits to round final value
     * @return {@link #balance} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getBalance(int decimals) {
        return roundValue(balance, decimals);
    }

    /** Method to set {@link #balance}
     * @param balance: balance value
     * @throws IllegalArgumentException when balance value is less than 0
     * **/
    public void setBalance(double balance) {
        if(balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        this.balance = balance;
    }

    public double getAvailable() {
        return available;
    }

    /** Method to get {@link #available} instance
     * @param decimals: number of digits to round final value
     * @return {@link #available} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getAvailable(int decimals) {
        return roundValue(available, decimals);
    }

    /** Method to set {@link #available}
     * @param available: available value
     * @throws IllegalArgumentException when available value is less than 0
     * **/
    public void setAvailable(double available) {
        if(available < 0)
            throw new IllegalArgumentException("Available value cannot be less than 0");
        this.available = available;
    }

    public double getHold() {
        return hold;
    }

    /** Method to get {@link #hold} instance
     * @param decimals: number of digits to round final value
     * @return {@link #hold} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getHold(int decimals) {
        return roundValue(hold, decimals);
    }

    /** Method to set {@link #hold}
     * @param hold: hold value
     * @throws IllegalArgumentException when hold value is less than 0
     * **/
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

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                ", available=" + available +
                ", hold=" + hold +
                ", profileId='" + profileId + '\'' +
                ", tradingEnable=" + tradingEnable +
                '}';
    }

}
