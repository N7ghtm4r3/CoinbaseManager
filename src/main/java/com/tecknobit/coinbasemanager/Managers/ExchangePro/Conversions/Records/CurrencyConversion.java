package com.tecknobit.coinbasemanager.Managers.ExchangePro.Conversions.Records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code CurrencyConversion} class is useful to format CurrencyConversion object
 * @apiNote see official documentation at:
 <ul>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion</a>
     </li>
 </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CurrencyConversion {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code amount} is instance that memorizes amount value
     * **/
    private final double amount;

    /**
     * {@code fromAccountId} is instance that memorizes from account identifier value
     * **/
    private final String fromAccountId;

    /**
     * {@code toAccountId} is instance that memorizes to account identifier value
     * **/
    private final String toAccountId;

    /**
     * {@code from} is instance that memorizes from value
     * **/
    private final String from;

    /**
     * {@code to} is instance that memorizes to value
     * **/
    private final String to;

    /** Constructor to init a {@link CurrencyConversion} object
     * @param id: identifier value
     * @param amount: amount value
     * @param fromAccountId: from account identifier value
     * @param toAccountId: to account identifier value
     * @param from: from value
     * @param to: to value
     * **/
    public CurrencyConversion(String id, double amount, String fromAccountId, String toAccountId, String from, String to) {
        this.id = id;
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.from = from;
        this.to = to;
    }

    /** Constructor to init a {@link CurrencyConversion} object
     * @param currencyConversion: currency conversion details as {@link JSONObject}
     * **/
    public CurrencyConversion(JSONObject currencyConversion) {
        this.id = currencyConversion.getString("id");
        this.amount = currencyConversion.getDouble("amount");
        this.fromAccountId = currencyConversion.getString("from_account_id");
        this.toAccountId = currencyConversion.getString("to_account_id");
        this.from = currencyConversion.getString("from");
        this.to = currencyConversion.getString("to");
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    /** Method to get {@link #amount} instance
     * @param decimals: number of digits to round final value
     * @return {@link #amount} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getAmount(int decimals) {
        return roundValue(amount, decimals);
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

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", fromAccountId='" + fromAccountId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}
