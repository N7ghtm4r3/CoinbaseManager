package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code Ticker} class is useful to format Ticker object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1</a>
 **/

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

    /** Constructor to init a {@link Ticker} object
     * @param ticker: ticker details as {@link JSONObject}
     * **/
    public Ticker(String productId, double priceChangePercent, JSONObject ticker) {
        super(ticker);
        this.productId = productId;
        baseAsset = ticker.getString("baseAsset");
        quoteAsset = ticker.getString("quoteAsset");
        bid = ticker.getDouble("bid");
        ask = ticker.getDouble("ask");
        volume = ticker.getDouble("volume");
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

    /** Method to get {@link #bid} instance
     * @param decimals: number of digits to round final value
     * @return {@link #bid} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getBid(int decimals) {
        return roundValue(bid, decimals);
    }

    public double getAsk() {
        return ask;
    }

    /** Method to get {@link #ask} instance
     * @param decimals: number of digits to round final value
     * @return {@link #ask} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getAsk(int decimals) {
        return roundValue(ask, decimals);
    }

    public double getVolume() {
        return volume;
    }

    /** Method to get {@link #volume} instance
     * @param decimals: number of digits to round final value
     * @return {@link #volume} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getVolume(int decimals) {
        return roundValue(volume, decimals);
    }

    public double getPriceChangePercent() {
        return priceChangePercent;
    }

    /** Method to get {@link #priceChangePercent} instance
     * @param decimals: number of digits to round final value
     * @return {@link #priceChangePercent} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getPriceChangePercent(int decimals) {
        return roundValue(priceChangePercent, decimals);
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
