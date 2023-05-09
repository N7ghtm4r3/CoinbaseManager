package com.tecknobit.coinbasemanager.exchangepro.wrappedassets.records;

import com.tecknobit.apimanager.formatters.TimeFormatter;
import com.tecknobit.coinbasemanager.exchangepro.orders.records.Order.Status;
import com.tecknobit.coinbasemanager.exchangepro.records.CoinbaseItem;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code StakeWrap} class is useful to format a {@code Coinbase}'s stake wrap
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getallwrappedassetstakewraps">
 *             Get all stake-wraps</a>
 *     </li>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwrappedassetstakewrap">
 *             Create a new stake-wrap</a>
 *     </li>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetstakewrap">
 *             Get a single stake-wrap</a>
 *     </li>
 * </ul>
 * @see CoinbaseItem
 */
public class StakeWrap extends CoinbaseItem {

    /**
     * {@code id} of the stake wrap
     **/
    private final String id;

    /**
     * {@code fromAmount} from amount of the stake wrap
     **/
    private final double fromAmount;

    /**
     * {@code toAmount} to amount of the stake wrap
     **/
    private final double toAmount;

    /**
     * {@code fromAccountId} from account id of the stake wrap
     **/
    private final String fromAccountId;

    /**
     * {@code toAccountId} to account id of the stake wrap
     **/
    private final String toAccountId;

    /**
     * {@code fromCurrency} from currency of the stake wrap
     **/
    private final String fromCurrency;

    /**
     * {@code toCurrency} to currency of the stake wrap
     **/
    private final String toCurrency;

    /**
     * {@code status} of the stake wrap
     **/
    private final Status status;

    /**
     * {@code conversionRate} conversion rate of the stake wrap
     **/
    private final double conversionRate;

    /**
     * {@code createdAt} creation time of the stake wrap
     **/
    private final String createdAt;

    /**
     * {@code completedAt} completion time of the stake wrap
     **/
    private final String completedAt;

    /**
     * {@code canceledAt} cancellation time of the stake wrap
     **/
    private final String canceledAt;

    /**
     * Constructor to init a {@link StakeWrap} object
     *
     * @param id:             id of the stake wrap
     * @param fromAmount:     from amount of the stake wrap
     * @param toAmount:       to amount of the stake wrap
     * @param fromAccountId:  from account id of the stake wrap
     * @param toAccountId:    to account id of the stake wrap
     * @param fromCurrency:   from currency of the stake wrap
     * @param toCurrency:     to currency of the stake wrap
     * @param status:         status of the stake wrap
     * @param conversionRate: conversionRate of the stake wrap
     * @param createdAt:      creation time of the stake wrap
     * @param completedAt:    completion time of the stake wrap
     * @param canceledAt:     cancellation time of the stake wrap
     */
    public StakeWrap(String id, double fromAmount, double toAmount, String fromAccountId, String toAccountId,
                     String fromCurrency, String toCurrency, Status status, double conversionRate, String createdAt,
                     String completedAt, String canceledAt) {
        super(null);
        this.id = id;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.status = status;
        this.conversionRate = conversionRate;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.canceledAt = canceledAt;
    }

    /**
     * Constructor to init a {@link StakeWrap} object
     *
     * @param jStakeWrap: stake wrap details as {@link JSONObject}
     *                    *
     */
    public StakeWrap(JSONObject jStakeWrap) {
        super(jStakeWrap);
        id = hItem.getString("id");
        fromAmount = hItem.getDouble("from_amount", 0);
        toAmount = hItem.getDouble("to_amount", 0);
        fromAccountId = hItem.getString("from_account_id");
        toAccountId = hItem.getString("to_account_id");
        fromCurrency = hItem.getString("from_currency");
        toCurrency = hItem.getString("to_currency");
        status = Status.valueOf(hItem.getString("status"));
        conversionRate = hItem.getDouble("conversion_rate", 0);
        createdAt = hItem.getString("created_at");
        completedAt = hItem.getString("completed_at");
        canceledAt = hItem.getString("canceled_at");
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #fromAmount} instance <br>
     * No-any params required
     *
     * @return {@link #fromAmount} instance as double
     **/
    public double getFromAmount() {
        return fromAmount;
    }

    /**
     * Method to get {@link #fromAmount} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #fromAmount} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getFromAmount(int decimals) {
        return roundValue(fromAmount, decimals);
    }

    /**
     * Method to get {@link #toAmount} instance <br>
     * No-any params required
     *
     * @return {@link #toAmount} instance as double
     **/
    public double getToAmount() {
        return toAmount;
    }

    /**
     * Method to get {@link #toAmount} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #toAmount} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getToAmount(int decimals) {
        return roundValue(toAmount, decimals);
    }

    /**
     * Method to get {@link #fromAccountId} instance <br>
     * No-any params required
     *
     * @return {@link #fromAccountId} instance as {@link String}
     **/
    public String getFromAccountId() {
        return fromAccountId;
    }

    /**
     * Method to get {@link #toAccountId} instance <br>
     * No-any params required
     *
     * @return {@link #toAccountId} instance as {@link String}
     **/
    public String getToAccountId() {
        return toAccountId;
    }

    /**
     * Method to get {@link #fromCurrency} instance <br>
     * No-any params required
     *
     * @return {@link #fromCurrency} instance as {@link String}
     **/
    public String getFromCurrency() {
        return fromCurrency;
    }

    /**
     * Method to get {@link #toCurrency} instance <br>
     * No-any params required
     *
     * @return {@link #toCurrency} instance as {@link String}
     **/
    public String getToCurrency() {
        return toCurrency;
    }

    /**
     * Method to get {@link #status} instance <br>
     * No-any params required
     *
     * @return {@link #status} instance as {@link Status}
     **/
    public Status getStatus() {
        return status;
    }

    /**
     * Method to get {@link #conversionRate} instance <br>
     * No-any params required
     *
     * @return {@link #conversionRate} instance as double
     **/
    public double getConversionRate() {
        return conversionRate;
    }

    /**
     * Method to get {@link #conversionRate} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #conversionRate} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getConversionRate(int decimals) {
        return roundValue(conversionRate, decimals);
    }

    /**
     * Method to get {@link #createdAt} instance <br>
     * No-any params required
     *
     * @return {@link #createdAt} instance as {@link String}
     **/
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to get {@link #createdAt} timestamp <br>
     * No-any params required
     *
     * @return {@link #createdAt} timestamp as long
     **/
    public long getCreatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(createdAt);
    }

    /**
     * Method to get {@link #completedAt} instance <br>
     * No-any params required
     *
     * @return {@link #completedAt} instance as {@link String}
     **/
    public String getCompletedAt() {
        return completedAt;
    }

    /**
     * Method to get {@link #completedAt} timestamp <br>
     * No-any params required
     *
     * @return {@link #completedAt} timestamp as long
     **/
    public long getCompletedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(completedAt);
    }

    /**
     * Method to get {@link #canceledAt} instance <br>
     * No-any params required
     *
     * @return {@link #canceledAt} instance as {@link String}
     **/
    public String getCanceledAt() {
        return canceledAt;
    }

    /**
     * Method to get {@link #canceledAt} timestamp <br>
     * No-any params required
     *
     * @return {@link #canceledAt} timestamp as long
     **/
    public long getCanceledAtTimestamp() {
        return TimeFormatter.getDateTimestamp(canceledAt);
    }

}
