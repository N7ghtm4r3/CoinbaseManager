package com.tecknobit.coinbasemanager.managers.exchangepro.products.records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Product} class is useful to format general Product object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
 * Get product candles</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
 * Get product stats</a>
 * </li>
 * </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/
public abstract class Product {

    /**
     * {@code open} is instance that memorizes open value
     **/
    protected final double open;

    /**
     * {@code high} is instance that memorizes high value
     **/
    protected final double high;

    /**
     * {@code low} is instance that memorizes low value
     **/
    protected final double low;

    /**
     * {@code volume} is instance that memorizes volume value
     **/
    protected final double volume;

    /**
     * Constructor to init a {@link Product} custom object
     *
     * @param open:   open value
     * @param high:   high value
     * @param low:    low value
     * @param volume: volume value
     **/
    public Product(double open, double high, double low, double volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    /**
     * Constructor to init a {@link Product} custom object
     *
     * @param product: product details as {@link JSONObject}
     **/
    public Product(JSONObject product) {
        this(product.getDouble("open"), product.getDouble("high"), product.getDouble("low"),
                product.getDouble("volume"));
    }

    /**
     * Method to get {@link #open} instance <br>
     * No-any params required
     *
     * @return {@link #open} instance as double
     **/
    public double getOpen() {
        return open;
    }

    /**
     * Method to get {@link #open} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #open} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getOpen(int decimals) {
        return roundValue(open, decimals);
    }

    /**
     * Method to get {@link #high} instance <br>
     * No-any params required
     *
     * @return {@link #high} instance as double
     **/
    public double getHigh() {
        return high;
    }

    /**
     * Method to get {@link #high} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #high} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getHigh(int decimals) {
        return roundValue(high, decimals);
    }

    /**
     * Method to get {@link #low} instance <br>
     * No-any params required
     *
     * @return {@link #low} instance as double
     **/
    public double getLow() {
        return low;
    }

    /**
     * Method to get {@link #low} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #low} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getLow(int decimals) {
        return roundValue(low, decimals);
    }

    /**
     * Method to get {@link #volume} instance <br>
     * No-any params required
     *
     * @return {@link #volume} instance as double
     **/
    public double getVolume() {
        return volume;
    }

    /**
     * Method to get {@link #volume} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #volume} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getVolume(int decimals) {
        return roundValue(volume, decimals);
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
