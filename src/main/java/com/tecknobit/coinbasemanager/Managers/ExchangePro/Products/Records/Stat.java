package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code Stat} class is useful to format Stat object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Stat extends Product {

    /**
     * {@code productId} is instance that memorizes product identifier value
     * **/
    private final String productId;

    /**
     * {@code last} is instance that memorizes last value
     * **/
    private final double last;

    /**
     * {@code volume30Day} is instance that memorizes thirty days volume value
     * **/
    private final double volume30Day;

    /** Constructor to init a {@link Stat} object
     * @param productId: Stat identifier value
     * @param open: open value
     * @param high: high value
     * @param low: low value
     * @param volume: volume value
     * @param last: last value
     * @param volume30Day: thirty days volume value
     **/
    public Stat(String productId, double open, double high, double low, double volume, double last, double volume30Day) {
        super(open, high, low, volume);
        this.productId = productId;
        this.last = last;
        this.volume30Day = volume30Day;
    }

    /** Constructor to init a {@link Stat} object
     * @param stat: stat details as {@link JSONObject}
     **/
    public Stat(String productId, JSONObject stat) {
        super(stat);
        this.productId = productId;
        this.last = stat.getDouble("last");
        this.volume30Day = stat.getDouble("volume_30day");
    }

    public String getProductId() {
        return productId;
    }

    public double getLast() {
        return last;
    }

    /** Method to get {@link #last} instance
     * @param decimals: number of digits to round final value
     * @return {@link #last} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getLast(int decimals) {
        return roundValue(last, decimals);
    }

    public double getVolume30Day() {
        return volume30Day;
    }

    /** Method to get {@link #volume30Day} instance
     * @param decimals: number of digits to round final value
     * @return {@link #volume30Day} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getVolume30Day(int decimals) {
        return roundValue(volume30Day, decimals);
    }

    @Override
    public String toString() {
        return "Stat{" +
                "productId='" + productId + '\'' +
                ", last=" + last +
                ", volume30Day=" + volume30Day +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                '}';
    }

}
