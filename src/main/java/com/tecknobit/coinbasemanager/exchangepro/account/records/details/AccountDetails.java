package com.tecknobit.coinbasemanager.exchangepro.account.records.details;

import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code AccountDetails} class is useful to format all base data of {@code "Coinbase"} account objects
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *        <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds">
 *            Get a single account's holds</a>
 *     </li>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger">
 *             Get a single account's ledger</a>
 *     </li>
 *      <li>
 *          <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers">
 *              Get a single account's transfers</a>
 *     </li>
 *      <li>
 *           <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer">
 *               Get all transfers</a>
 *       </li>
 * </ul>
 */
public class AccountDetails {

    /**
     * {@code createdAt} is instance that memorizes created at value
     */
    protected final String createdAt;

    /**
     * {@code id} is instance that memorizes identifier value
     */
    protected final String id;

    /**
     * {@code amount} is instance that memorizes amount value
     */
    protected double amount;

    /**
     * {@code type} is instance that memorizes type value
     */
    protected String type;

    /**
     * Constructor to init a {@link AccountDetails} custom object
     *
     * @param createdAt: created at value
     * @param id:        identifier value
     * @param amount:    amount value
     * @param type:      type value
     * @throws IllegalArgumentException if parameters range is not respected
     */
    public AccountDetails(String createdAt, String id, double amount, String type) {
        this.createdAt = createdAt;
        this.id = id;
        if (amount < 0)
            throw new IllegalArgumentException("Amount value cannot be less than 0");
        else
            this.amount = amount;
        if (type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        else
            this.type = type;
    }

    /**
     * Constructor to init a {@link AccountDetails} custom object
     *
     * @param accountDetails: account details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     */
    public AccountDetails(JSONObject accountDetails) {
        this(accountDetails.getString("created_at"), accountDetails.getString("id"),
                accountDetails.getDouble("amount"), accountDetails.getString("type"));
    }

    /**
     * Method to get {@link #createdAt} instance <br>
     * No-any params required
     *
     * @return {@link #createdAt} instance as {@link String}
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to get {@link #createdAt} timestamp <br>
     * No-any params required
     *
     * @return {@link #createdAt} timestamp as long
     */
    public long getCreatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(createdAt);
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
     * @return {@link #amount} instance as long
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Method to set {@link #amount}
     *
     * @param amount: amount value
     * @throws IllegalArgumentException when amount value is less than 0
     */
    public void setAmount(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount value cannot be less than 0");
        this.amount = amount;
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
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link String}
     */
    public String getType() {
        return type;
    }

    /**
     * Method to set {@link #type}
     *
     * @param type: type value
     * @throws IllegalArgumentException when type value null or is empty
     */
    public void setType(String type) {
        if (type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        this.type = type;
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
