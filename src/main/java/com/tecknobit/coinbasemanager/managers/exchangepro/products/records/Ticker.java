package com.tecknobit.coinbasemanager.managers.exchangepro.products.records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Ticker} class is useful to format Ticker object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
 * Get product ticker</a>
 * @see StatDetails
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
     * Constructor to init a {@link Ticker} custom object
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

    /**
     * Constructor to init a {@link Ticker} custom object
     *
     * @param ticker: ticker details as {@link JSONObject}
     **/
    public Ticker(JSONObject ticker) {
        super(ticker);
        productId = ticker.getString("productId");
        baseAsset = ticker.getString("baseAsset");
        quoteAsset = ticker.getString("quoteAsset");
        bid = ticker.getDouble("bid");
        ask = ticker.getDouble("ask");
        volume = ticker.getDouble("volume");
        priceChangePercent = ticker.getDouble("priceChangePercent");
    }

    /**
     * MethodId to get {@link #productId} instance <br>
     * Any params required
     *
     * @return {@link #productId} instance as {@link String}
     **/
    public String getProductId() {
        return productId;
    }

    /**
     * MethodId to get {@link #baseAsset} instance <br>
     * Any params required
     *
     * @return {@link #baseAsset} instance as {@link String}
     **/
    public String getBaseAsset() {
        return baseAsset;
    }

    /**
     * MethodId to get {@link #quoteAsset} instance <br>
     * Any params required
     *
     * @return {@link #quoteAsset} instance as {@link String}
     **/
    public String getQuoteAsset() {
        return quoteAsset;
    }

    /**
     * MethodId to get {@link #bid} instance <br>
     * Any params required
     *
     * @return {@link #bid} instance as double
     **/
    public double getBid() {
        return bid;
    }

    /**
     * MethodId to get {@link #bid} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #bid} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getBid(int decimals) {
        return roundValue(bid, decimals);
    }

    /**
     * MethodId to get {@link #ask} instance <br>
     * Any params required
     *
     * @return {@link #ask} instance as double
     **/
    public double getAsk() {
        return ask;
    }

    /**
     * MethodId to get {@link #ask} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #ask} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getAsk(int decimals) {
        return roundValue(ask, decimals);
    }

    /**
     * MethodId to get {@link #volume} instance <br>
     * Any params required
     *
     * @return {@link #volume} instance as double
     **/
    public double getVolume() {
        return volume;
    }

    /**
     * MethodId to get {@link #volume} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #volume} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getVolume(int decimals) {
        return roundValue(volume, decimals);
    }

    /**
     * MethodId to get {@link #priceChangePercent} instance <br>
     * Any params required
     *
     * @return {@link #priceChangePercent} instance as double
     **/
    public double getPriceChangePercent() {
        return priceChangePercent;
    }

    /**
     * MethodId to get {@link #priceChangePercent} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #priceChangePercent} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getPriceChangePercent(int decimals) {
        return roundValue(priceChangePercent, decimals);
    }

}
