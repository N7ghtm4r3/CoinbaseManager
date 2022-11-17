package com.tecknobit.coinbasemanager.managers.exchangepro.account.records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Account} class is useful to format Account object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1">
 *     Get all accounts for a profile</a>
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
     **/
    private final String profileId;

    /**
     * {@code tradingEnable} is flag that checks if trading is enabled
     **/
    private boolean tradingEnable;

    /**
     * Constructor to init a {@link Account} custom object
     *
     * @param id:            identifier value
     * @param currency:      currency value
     * @param balance:       balance value
     * @param available:     available value
     * @param hold:          hold value
     * @param profileId:     profile identifier value
     * @param tradingEnable: flag that checks if trading is enabled
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Account(String id, String currency, double balance, double available, double hold, String profileId,
                   boolean tradingEnable) {
        this.id = id;
        if (currency == null || currency.isEmpty())
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
        if (hold < 0)
            throw new IllegalArgumentException("Hold value cannot be less than 0");
        else
            this.hold = hold;
        this.profileId = profileId;
        this.tradingEnable = tradingEnable;
    }

    /**
     * Constructor to init a {@link Account} custom object
     *
     * @param account: account details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Account(JSONObject account) {
        this(account.getString("id"), account.getString("currency"), account.getDouble("balance"),
                account.getDouble("available"), account.getDouble("hold"), account.getString("profile_id"),
                account.getBoolean("trading_enabled"));
    }

    /**
     * Method to get {@link #id} instance <br>
     * Any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #currency} instance <br>
     * Any params required
     *
     * @return {@link #currency} instance as {@link String}
     **/
    public String getCurrency() {
        return currency;
    }

    /**
     * Method to set {@link #currency}
     *
     * @param currency: currency value
     * @throws IllegalArgumentException when currency value is null or empty
     **/
    public void setCurrency(String currency) {
        if (currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        this.currency = currency;
    }

    /**
     * Method to get {@link #balance} instance <br>
     * Any params required
     *
     * @return {@link #balance} instance as double
     **/
    public double getBalance() {
        return balance;
    }

    /**
     * Method to set {@link #balance}
     *
     * @param balance: balance value
     * @throws IllegalArgumentException when balance value is less than 0
     **/
    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        this.balance = balance;
    }

    /**
     * Method to get {@link #balance} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #balance} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getBalance(int decimals) {
        return roundValue(balance, decimals);
    }

    /**
     * Method to get {@link #available} instance <br>
     * Any params required
     *
     * @return {@link #available} instance as double
     **/
    public double getAvailable() {
        return available;
    }

    /**
     * Method to set {@link #available}
     *
     * @param available: available value
     * @throws IllegalArgumentException when available value is less than 0
     **/
    public void setAvailable(double available) {
        if (available < 0)
            throw new IllegalArgumentException("Available value cannot be less than 0");
        this.available = available;
    }

    /**
     * Method to get {@link #available} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #available} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getAvailable(int decimals) {
        return roundValue(available, decimals);
    }

    /**
     * Method to get {@link #hold} instance <br>
     * Any params required
     *
     * @return {@link #hold} instance as double
     **/
    public double getHold() {
        return hold;
    }

    /**
     * Method to get {@link #hold} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #hold} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getHold(int decimals) {
        return roundValue(hold, decimals);
    }

    /**
     * Method to set {@link #hold}
     *
     * @param hold: hold value
     * @throws IllegalArgumentException when hold value is less than 0
     **/
    public void setHold(double hold) {
        if (hold < 0)
            throw new IllegalArgumentException("Hold value cannot be less than 0");
        this.hold = hold;
    }

    /**
     * Method to get {@link #profileId} instance <br>
     * Any params required
     *
     * @return {@link #profileId} instance as {@link String}
     **/
    public String getProfileId() {
        return profileId;
    }

    /**
     * Method to get {@link #tradingEnable} instance <br>
     * Any params required
     *
     * @return {@link #tradingEnable} instance as boolean
     **/
    public boolean isTradingEnable() {
        return tradingEnable;
    }

    /**
     * Method to set {@link #tradingEnable} instance
     *
     * @param tradingEnable: is flag that checks if trading is enabled
     **/
    public void setTradingEnable(boolean tradingEnable) {
        this.tradingEnable = tradingEnable;
    }

    /**
     * Method to set {@link #tradingEnable} instance on {@code "true"} <br>
     * Any params required
     **/
    public void enableTrading() {
        tradingEnable = true;
    }

    /**
     * Method to set {@link #tradingEnable} instance on {@code "false"} <br>
     * Any params required
     **/
    public void disableTrading() {
        tradingEnable = false;
    }

    /**
     * Returns a string representation of the object <br>
     * Any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
