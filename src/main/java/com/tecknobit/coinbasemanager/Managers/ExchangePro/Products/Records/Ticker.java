package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code Ticker} class is useful to format Ticker object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Ticker extends StatDetails {

    /**
     * {@code productId} is instance that memorizes product identifier value
     * **/
    private final String productId;

    /**
     * {@code baseAsset} is instance that memorizes base asset value
     * **/
    private final String baseAsset;

    /**
     * {@code quoteAsset} is instance that memorizes quote asset value
     * **/
    private final String quoteAsset;

    /**
     * {@code bid} is instance that memorizes bid value
     * **/
    private final double bid;

    /**
     * {@code ask} is instance that memorizes ask value
     * **/
    private final double ask;

    /**
     * {@code volume} is instance that memorizes volume value
     * **/
    private final double volume;

    /**
     * {@code priceChangePercent} is instance that memorizes price change percent value in 24 hours
     * **/
    private final double priceChangePercent;

    /**
     * Constructor to init a {@link Ticker} object
     * @param tradeId: ticker identifier value
     * @param price: price value
     * @param size: size value
     * @param time: time value
     * @param productId: product identifier value
     * @param baseAsset: base asset value
     * @param quoteAsset: quote asset value
     * @param bid: bid value
     * @param ask: ask value
     * @param volume: volume value
     * @param priceChangePercent: price change percent value in 24 hours
     **/
    public Ticker(long tradeId, double price, double size, String time, String productId, String baseAsset, String quoteAsset,
                  double bid, double ask, double volume, double priceChangePercent) {
        super(tradeId, price, size, time);
        this.productId = productId;
        this.baseAsset = baseAsset;
        this.quoteAsset = quoteAsset;
        this.bid = bid;
        this.ask = ask;
        this.volume = volume;
        this.priceChangePercent = priceChangePercent;
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

    public double getPriceChangePercent() {
        return priceChangePercent;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "productId='" + productId + '\'' +
                ", baseAsset='" + baseAsset + '\'' +
                ", quoteAsset='" + quoteAsset + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", volume=" + volume +
                ", priceChangePercent=" + priceChangePercent +
                '}';
    }

}
