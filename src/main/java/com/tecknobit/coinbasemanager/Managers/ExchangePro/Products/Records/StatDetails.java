package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code StatDetails} class is useful to format general StatDetails object
 * @apiNote see the official documentation at:
<ul>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1</a>
</li>
</ul>
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
     * **/
    protected final double size;

    /**
     * {@code time} is instance that memorizes time value
     * **/
    protected final String time;

    /** Constructor to init a {@link StatDetails} object
     * @param tradeId: trade identifier value
     * @param price: price value
     * @param size: size value
     * @param time: time value
     * **/
    public StatDetails(long tradeId, double price, double size, String time) {
        this.tradeId = tradeId;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    /** Constructor to init a {@link StatDetails} object
     * @param stat: stat details as {@link JSONObject}
     * **/
    public StatDetails(JSONObject stat) {
        tradeId = stat.getLong("trade_id");
        price = stat.getDouble("price");
        size = stat.getDouble("size");
        time = stat.getString("time");
    }

    public long getTradeId() {
        return tradeId;
    }

    public double getPrice() {
        return price;
    }

    /** Method to get {@link #price} instance
     * @param decimals: number of digits to round final value
     * @return {@link #price} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getPrice(int decimals) {
        return roundValue(price, decimals);
    }

    public double getSize() {
        return size;
    }

    /** Method to get {@link #size} instance
     * @param decimals: number of digits to round final value
     * @return {@link #size} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getSize(int decimals) {
        return roundValue(size, decimals);
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "StatDetails{" +
                "tradeId=" + tradeId +
                ", price=" + price +
                ", size=" + size +
                ", time='" + time + '\'' +
                '}';
    }

}
