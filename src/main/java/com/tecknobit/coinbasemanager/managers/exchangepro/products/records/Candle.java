package com.tecknobit.coinbasemanager.managers.exchangepro.products.records;

import org.json.JSONArray;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Candle} class is useful to format Candle object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
 * Get product candles</a>
 * @see Product
 **/
public class Candle extends Product {

    /**
     * {@code GRANULARITY_1m} is constant for one minute granularity
     * **/
    public static final int GRANULARITY_1m = 60;

    /**
     * {@code GRANULARITY_5m} is constant for five minutes granularity
     * **/
    public static final int GRANULARITY_5m = 300;

    /**
     * {@code GRANULARITY_15m} is constant for fifteen minutes granularity
     * **/
    public static final int GRANULARITY_15m = 900;

    /**
     * {@code GRANULARITY_1h} is constant for one hour granularity
     * **/
    public static final int GRANULARITY_1h = 3600;

    /**
     * {@code GRANULARITY_6h} is constant for six hours granularity
     * **/
    public static final int GRANULARITY_6h = 21600;

    /**
     * {@code GRANULARITY_1d} is constant for one day granularity
     * **/
    public static final int GRANULARITY_1d = 86400;

    /**
     * {@code time} is instance that memorizes time value
     **/
    private final long time;

    /**
     * {@code close} is instance that memorizes close value
     **/
    private final double close;

    /**
     * Constructor to init a {@link Candle} custom object
     *
     * @param open:   open value
     * @param high:   high value
     * @param low:    low value
     * @param volume: volume value
     * @param time:   time value
     * @param close:  close value
     **/
    public Candle(double open, double high, double low, double volume, long time, double close) {
        super(open, high, low, volume);
        this.time = time;
        this.close = close;
    }

    /**
     * Constructor to init a {@link Candle} custom object
     *
     * @param candle: candle details as {@link JSONArray}
     **/
    public Candle(JSONArray candle) {
        super(candle.getLong(3), candle.getDouble(2), candle.getDouble(1), candle.getDouble(5));
        time = candle.getLong(0);
        close = candle.getDouble(4);
    }

    /**
     * Method to get {@link #time} instance <br>
     * Any params required
     *
     * @return {@link #time} instance as long
     **/
    public long getTime() {
        return time;
    }

    /**
     * Method to get {@link #close} instance <br>
     * Any params required
     *
     * @return {@link #close} instance as double
     **/
    public double getClose() {
        return close;
    }

    /**
     * Method to get {@link #close} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #close} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getClose(int decimals) {
        return roundValue(close, decimals);
    }

}
