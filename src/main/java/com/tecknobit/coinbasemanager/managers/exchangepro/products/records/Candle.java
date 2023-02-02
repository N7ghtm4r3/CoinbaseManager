package com.tecknobit.coinbasemanager.managers.exchangepro.products.records;

import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONArray;

import java.util.Date;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Candle} class is useful to format Candle object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
 * Get product candles</a>
 * @see Product
 **/
public class Candle extends Product {

    /**
     * {@code time} is instance that memorizes time value in <b>seconds</b> format
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
     * @param time:   time value in <b>seconds</b> format
     * @param close:  close value
     **/
    public Candle(double open, double high, double low, double volume, long time, double close) {
        super(open, high, low, volume);
        this.time = time;
        this.close = close;
    }

    /**
     * Method to get {@link #time} <b>seconds</b> format <br>
     * No-any params required
     *
     * @return {@link #time} instance as long
     **/
    public long getTime() {
        return time;
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
     * No-any params required
     *
     * @return {@link #time} instance as {@link Date} with {@link #time} in <b>milliseconds</b> format
     **/
    public Date getDateTime() {
        return TimeFormatter.getDate(time * 1000);
    }

    /**
     * Method to get {@link #close} instance <br>
     * No-any params required
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

    /**
     * {@code Granularity} list of available granularities for a candle
     **/
    public enum Granularity {

        /**
         * {@code "_1m"} one minute granularity
         **/
        _1m(60),

        /**
         * {@code "_5m"} five minutes granularity
         **/
        _5m(300),

        /**
         * {@code "_15m"} fifteen minutes granularity
         **/
        _15m(900),

        /**
         * {@code "_1h"} one hour granularity
         **/
        _1h(3600),

        /**
         * {@code "_6h"} six hours granularity
         **/
        _6h(21600),

        /**
         * {@code "_1d"} one day granularity
         **/
        _1d(86400);

        /**
         * {@code "granularity"} value
         **/
        private final int granularity;

        /**
         * Constructor to init a {@link Granularity}
         *
         * @param granularity: granularity value
         **/
        Granularity(int granularity) {
            this.granularity = granularity;
        }

        /**
         * Method to get {@link #granularity} instance <br>
         * No-any params required
         *
         * @return {@link #granularity} instance as int
         **/
        @Override
        public String toString() {
            return String.valueOf(granularity);
        }

    }

}
