package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

public class Ticker extends StatDetails{

    private final double bid;
    private final double ask;
    private final double volume;

    public Ticker(long tradeId, double price, double size, String time, double bid, double ask, double volume) {
        super(tradeId, price, size, time);
        this.bid = bid;
        this.ask = ask;
        this.volume = volume;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public double getVolume() {
        return volume;
    }

}
