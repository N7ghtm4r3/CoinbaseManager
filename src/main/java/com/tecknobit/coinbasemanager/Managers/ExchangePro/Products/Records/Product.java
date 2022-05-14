package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Product} class is useful to format general Product object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Product {

    private final double open;
    private final double high;
    private final double low;
    private final double volume;

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

}
