package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Product} class is useful to format general Product object
 * @apiNote see official documentation at:
 <ul>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
     </li>
 </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Product {

    /**
     * {@code open} is instance that memorizes open value
     * **/
    protected final double open;

    /**
     * {@code high} is instance that memorizes high value
     * **/
    protected final double high;

    /**
     * {@code low} is instance that memorizes low value
     * **/
    protected final double low;

    /**
     * {@code volume} is instance that memorizes volume value
     * **/
    protected final double volume;

    /** Constructor to init a {@link Product} object
     * @param open: open value
     * @param high: high value
     * @param low: low value
     * @param volume: volume value
     * **/
    public Product(double open, double high, double low, double volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Product{" +
                "open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                '}';
    }

}
