package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

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
