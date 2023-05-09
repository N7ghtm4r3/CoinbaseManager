package com.tecknobit.coinbasemanager.exchangepro.products.records;

import org.json.JSONObject;

/**
 * The {@code Trade} class is useful to format Trade object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
 * Get product trades</a>
 * @see StatDetails
 **/
public class Trade extends StatDetails {

    /**
     * {@code side} is instance that memorizes side value (buy or sell)
     **/
    private final String side;

    /**
     * Constructor to init a {@link Trade} custom object
     *
     * @param tradeId: trade identifier value
     * @param price:   price value
     * @param size:    size value
     * @param time:    time value
     * @param side:    side value (buy or sell)
     **/
    public Trade(long tradeId, double price, double size, String time, String side) {
        super(tradeId, price, size, time);
        this.side = side;
    }

    /**
     * Constructor to init a {@link Trade} custom object
     *
     * @param trade: trade details as {@link JSONObject}
     **/
    public Trade(JSONObject trade) {
        super(trade);
        side = trade.getString("side");
    }

    /**
     * Method to get {@link #side} instance <br>
     * No-any params required
     *
     * @return {@link #side} instance as {@link String}
     **/
    public String getSide() {
        return side;
    }

}
