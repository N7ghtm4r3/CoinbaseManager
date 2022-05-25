package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Ticker} class is useful to format Ticker object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Ticker extends StatDetails{

    private final String productId;
    private final String baseAsset;
    private final String quoteAsset;
    private final double bid;
    private final double ask;
    private final double volume;

    public Ticker(long tradeId, double price, double size, String time, String productId, String baseAsset, String quoteAsset,
                  double bid, double ask, double volume) {
        super(tradeId, price, size, time);
        this.productId = productId;
        this.baseAsset = baseAsset;
        this.quoteAsset = quoteAsset;
        this.bid = bid;
        this.ask = ask;
        this.volume = volume;
    }

    public String getProductId() {
        return productId;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
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
