package com.tecknobit.coinbasemanager.managers.exchangepro.products.records;

import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code StatDetails} class is useful to format general StatDetails object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
 * Get product ticker</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
 * Get product trades</a>
 * </li>
 * </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/
public class StatDetails {

    /**
     * {@code tradeId} is instance that memorizes trade identifier value
     * **/
    protected final long tradeId;

    /**
     * {@code price} is instance that memorizes price value
     * **/
    protected final double price;

    /**
     * {@code size} is instance that memorizes size value
     **/
    protected final double size;

    /**
     * {@code time} is instance that memorizes time value
     **/
    protected final String time;

    /**
     * Constructor to init a {@link StatDetails} custom object
     *
     * @param tradeId: trade identifier value
     * @param price:   price value
     * @param size:    size value
     * @param time:    time value
     **/
    public StatDetails(long tradeId, double price, double size, String time) {
        this.tradeId = tradeId;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    /**
     * Constructor to init a {@link StatDetails} custom object
     *
     * @param stat: stat details as {@link JSONObject}
     **/
    public StatDetails(JSONObject stat) {
        this(stat.getLong("trade_id"), stat.getDouble("price"), stat.getDouble("size"),
                stat.getString("time"));
    }

    /**
     * Method to get {@link #tradeId} instance <br>
     * No-any params required
     *
     * @return {@link #tradeId} instance as long
     **/
    public long getTradeId() {
        return tradeId;
    }

    /**
     * Method to get {@link #price} instance <br>
     * No-any params required
     *
     * @return {@link #price} instance as double
     **/
    public double getPrice() {
        return price;
    }

    /**
     * Method to get {@link #price} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #price} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getPrice(int decimals) {
        return roundValue(price, decimals);
    }

    /**
     * Method to get {@link #size} instance <br>
     * No-any params required
     *
     * @return {@link #size} instance as double
     **/
    public double getSize() {
        return size;
    }

    /**
     * Method to get {@link #size} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #size} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getSize(int decimals) {
        return roundValue(size, decimals);
    }

    /**
     * Method to get {@link #time} instance <br>
     * No-any params required
     *
     * @return {@link #time} instance as {@link String}
     **/
    public String getTime() {
        return time;
    }

    /**
     * Method to get {@link #time} timestamp <br>
     * No-any params required
     *
     * @return {@link #time} timestamp as long
     **/
    public long getTimestamp() {
        return TimeFormatter.getDateTimestamp(time);
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
