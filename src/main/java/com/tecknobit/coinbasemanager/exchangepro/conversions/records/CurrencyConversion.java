package com.tecknobit.coinbasemanager.exchangepro.conversions.records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code CurrencyConversion} class is useful to format CurrencyConversion object
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
 *             Convert currency</a>
 *      </li>
 *      <li>
 *          <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
 *             Get a conversion</a>
 *     </li>
 * </ul>
 * @author N7ghtm4r3 - Tecknobit
 * */
public class CurrencyConversion {

    /**
     * {@code id} is instance that memorizes identifier value
     */
    private final String id;

    /**
     * {@code amount} is instance that memorizes amount value
     */
    private final double amount;

    /**
     * {@code fromAccountId} is instance that memorizes from account identifier value
     */
    private final String fromAccountId;

    /**
     * {@code toAccountId} is instance that memorizes to account identifier value
     * */
    private final String toAccountId;

    /**
     * {@code from} is instance that memorizes from value
     */
    private final String from;

    /**
     * {@code to} is instance that memorizes to value
     */
    private final String to;

    /**
     * Constructor to init a {@link CurrencyConversion} custom object
     *
     * @param id:            identifier value
     * @param amount:        amount value
     * @param fromAccountId: from account identifier value
     * @param toAccountId:   to account identifier value
     * @param from:          from value
     * @param to:            to value
     */
    public CurrencyConversion(String id, double amount, String fromAccountId, String toAccountId, String from, String to) {
        this.id = id;
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructor to init a {@link CurrencyConversion} custom object
     *
     * @param currencyConversion: currency conversion details as {@link JSONObject}
     */
    public CurrencyConversion(JSONObject currencyConversion) {
        this(currencyConversion.getString("id"), currencyConversion.getDouble("amount"),
                currencyConversion.getString("from_account_id"), currencyConversion.getString("to_account_id"),
                currencyConversion.getString("from"), currencyConversion.getString("to"));
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #amount} instance <br>
     * No-any params required
     *
     * @return {@link #amount} instance as double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Method to get {@link #amount} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #amount} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getAmount(int decimals) {
        return roundValue(amount, decimals);
    }

    /**
     * Method to get {@link #fromAccountId} instance <br>
     * No-any params required
     *
     * @return {@link #fromAccountId} instance as {@link String}
     */
    public String getFromAccountId() {
        return fromAccountId;
    }

    /**
     * Method to get {@link #toAccountId} instance <br>
     * No-any params required
     *
     * @return {@link #toAccountId} instance as {@link String}
     */
    public String getToAccountId() {
        return toAccountId;
    }

    /**
     * Method to get {@link #from} instance <br>
     * No-any params required
     *
     * @return {@link #from} instance as {@link String}
     */
    public String getFrom() {
        return from;
    }

    /**
     * Method to get {@link #to} instance <br>
     * No-any params required
     *
     * @return {@link #to} instance as {@link String}
     */
    public String getTo() {
        return to;
    }

    /**
     * Returns a string representation of the object <br>
     * No-any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
