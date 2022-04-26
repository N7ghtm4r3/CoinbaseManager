package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

public class StatDetails {

    private final long tradeId;
    private final double price;
    private final double size;
    private final String time;

    public StatDetails(long tradeId, double price, double size, String time) {
        this.tradeId = tradeId;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    public long getTradeId() {
        return tradeId;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public String getTime() {
        return time;
    }

}
