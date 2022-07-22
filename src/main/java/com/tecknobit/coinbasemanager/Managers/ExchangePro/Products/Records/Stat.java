package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

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

    /**
     * Constructor to init a {@link Stat} object
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

    public String getProductId() {
        return productId;
    }

    public double getLast() {
        return last;
    }

    public double getVolume30Day() {
        return volume30Day;
    }

}
