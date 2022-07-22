package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Trade} class is useful to format Trade object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Trade extends StatDetails {

    /**
     * {@code side} is instance that memorizes side value (buy or sell)
     * **/
    private final String side;

    /** Constructor to init a {@link Trade} object
     * @param tradeId: trade identifier value
     * @param price: price value
     * @param size: size value
     * @param time: time value
     * @param side: side value (buy or sell)
     * **/
    public Trade(long tradeId, double price, double size, String time, String side) {
        super(tradeId, price, size, time);
        this.side = side;
    }

    public String getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "side='" + side + '\'' +
                ", tradeId=" + tradeId +
                ", price=" + price +
                ", size=" + size +
                ", time='" + time + '\'' +
                '}';
    }

}
