package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Stat} class is useful to format Stat object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Stat extends Product {

    private final double last;
    private final double volume30Day;

    public Stat(double open, double high, double low, double volume, double last, double volume30Day) {
        super(open, high, low, volume);
        this.last = last;
        this.volume30Day = volume30Day;
    }

    public double getLast() {
        return last;
    }

    public double getVolume30Day() {
        return volume30Day;
    }

}
