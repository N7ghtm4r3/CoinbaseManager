package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

public class Candle extends Product {

    public static final int GRANULARITY_1m = 60;
    public static final int GRANULARITY_5m = 300;
    public static final int GRANULARITY_15m = 900;
    public static final int GRANULARITY_1h = 3600;
    public static final int GRANULARITY_6h = 21600;
    public static final int GRANULARITY_1d = 86400;

    private final long time;
    private final double close;

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
