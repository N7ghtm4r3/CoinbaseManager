package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Candle} class is useful to format Candle object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

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
     * **/
    private final long time;

    /**
     * {@code close} is instance that memorizes close value
     * **/
    private final double close;

    /** Constructor to init a {@link Candle} object
     * @param open: open value
     * @param high: high value
     * @param low: low value
     * @param volume: volume value
     * @param time: time value
     * @param close: close value
     * **/
    public Candle(double open, double high, double low, double volume, long time, double close) {
        super(open, high, low, volume);
        this.time = time;
        this.close = close;
    }

    public long getTime() {
        return time;
    }

    public double getClose() {
        return close;
    }

}
