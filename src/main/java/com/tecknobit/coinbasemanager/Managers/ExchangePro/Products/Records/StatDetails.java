package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code StatDetails} class is useful to format general StatDetails object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

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
