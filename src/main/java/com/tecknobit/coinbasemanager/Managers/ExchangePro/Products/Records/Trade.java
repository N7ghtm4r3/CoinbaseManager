package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Trade} class is useful to format Trade object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades
 * @author N7ghtm4r3 - Tecknobit
 * **/

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
