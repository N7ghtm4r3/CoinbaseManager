package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

public class Trade extends StatDetails{

    private final String side;

    public Trade(long tradeId, double price, double size, String time, String side) {
        super(tradeId, price, size, time);
        this.side = side;
    }

    public String getSide() {
        return side;
    }

}
