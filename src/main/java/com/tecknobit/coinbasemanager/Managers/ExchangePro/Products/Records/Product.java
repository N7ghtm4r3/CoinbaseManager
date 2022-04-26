package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

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
