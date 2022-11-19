package com.tecknobit.coinbasemanager.managers.exchangepro.products.records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code TradingPair} class is useful to format TradingPair object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
 * Get all known trading pairs</a>
 **/
public class TradingPair {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code baseCurrency} is instance that memorizes base currency value
     * **/
    private final String baseCurrency;

    /**
     * {@code quoteCurrency} is instance that memorizes quote currency value
     * **/
    private final String quoteCurrency;

    /**
     * {@code quoteIncrement} is instance that memorizes quote increment value
     * **/
    private final double quoteIncrement;

    /**
     * {@code baseIncrement} is instance that memorizes base increment value
     * **/
    private final double baseIncrement;

    /**
     * {@code displayName} is instance that memorizes display name value
     * **/
    private final String displayName;

    /**
     * {@code minMarketFunds} is instance that memorizes minimum market founds value
     * **/
    private final double minMarketFunds;

    /**
     * {@code maxMarketFunds} is flag that checks if margin is enabled
     * **/
    private final boolean marginEnabled;

    /**
     * {@code postOnly} is flag that checks if is only post
     * **/
    private final boolean postOnly;

    /**
     * {@code limitOnly} is flag that checks if is only limit
     * **/
    private final boolean limitOnly;

    /**
     * {@code cancelOnly} is flag that checks if is only cancel
     * **/
    private final boolean cancelOnly;

    /**
     * {@code status} is instance that memorizes status value
     * **/
    private final String status;

    /**
     * {@code statusMessage} is instance that memorizes status message value
     * **/
    private final String statusMessage;

    /**
     * {@code auctionMode} is flag that checks if is auction mode
     * **/
    private final boolean auctionMode;

    /**
     * {@code auctionMode} is flag that indicates whether trading is currently restricted on this product, this includes whether both new orders and order cancelations are restricted
     * **/
    private final boolean tradingDisabled;

    /**
     * {@code auctionMode} is flag that indicates whether the currency pair is a Stable Pair
     * **/
    private final boolean fxStablecoin;

    /**
     * {@code maxSlippagePercentage} is instance that memorizes maximum slippage percentage
     * **/
    private final double maxSlippagePercentage;

    /** Constructor to init a {@link TradingPair} custom object
     * @param id: identifier value
     * @param baseCurrency: base currency value
     * @param quoteCurrency: quote currency value
     * @param quoteIncrement: quote increment value
     * @param baseIncrement: base increment value
     * @param displayName: display name value
     * @param minMarketFunds: minimum market founds value
     * @param marginEnabled: flag that checks if margin is enabled
     * @param postOnly: flag that checks if is only post
     * @param limitOnly: flag that checks if is only limit
     * @param cancelOnly: flag that checks if is only cancel
     * @param status: status value
     * @param statusMessage: status message value
     * @param auctionMode: flag that checks if is auction mode
     * @param tradingDisabled: indicates whether trading is currently restricted on this product, this includes whether
     *                      both new orders and order cancellations are restricted
     * @param fxStablecoin: indicates whether the currency pair is a Stable Pair
     * @param maxSlippagePercentage: maximum slippage percentage
     * **/
    public TradingPair(String id, String baseCurrency, String quoteCurrency, double quoteIncrement, double baseIncrement,
                       String displayName, double minMarketFunds, boolean marginEnabled, boolean postOnly, boolean limitOnly,
                       boolean cancelOnly, String status, String statusMessage, boolean auctionMode, boolean tradingDisabled,
                       boolean fxStablecoin, double maxSlippagePercentage) {
        this.id = id;
        this.baseCurrency = baseCurrency;
        this.quoteCurrency = quoteCurrency;
        this.quoteIncrement = quoteIncrement;
        this.baseIncrement = baseIncrement;
        this.displayName = displayName;
        this.minMarketFunds = minMarketFunds;
        this.marginEnabled = marginEnabled;
        this.postOnly = postOnly;
        this.limitOnly = limitOnly;
        this.cancelOnly = cancelOnly;
        this.status = status;
        this.statusMessage = statusMessage;
        this.auctionMode = auctionMode;
        this.tradingDisabled = tradingDisabled;
        this.fxStablecoin = fxStablecoin;
        this.maxSlippagePercentage = maxSlippagePercentage;
    }

    /**
     * Constructor to init a {@link TradingPair} custom object
     *
     * @param pair: trading pair details as {@link JSONObject}
     **/
    public TradingPair(JSONObject pair) {
        this(pair.getString("id"), pair.getString("base_currency"), pair.getString("quote_currency"),
                pair.getDouble("quote_increment"), pair.getDouble("base_increment"),
                pair.getString("display_name"), pair.getDouble("min_market_funds"),
                pair.getBoolean("margin_enabled"), pair.getBoolean("post_only"),
                pair.getBoolean("limit_only"), pair.getBoolean("cancel_only"), pair.getString("status"),
                pair.getString("status_message"), pair.getBoolean("auction_mode"),
                pair.getBoolean("trading_disabled"), pair.getBoolean("fx_stablecoin"),
                pair.getDouble("max_slippage_percentage"));
    }

    /**
     * MethodId to get {@link #id} timestamp <br>
     * Any params required
     *
     * @return {@link #id} timestamp as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * MethodId to get {@link #baseCurrency} timestamp <br>
     * Any params required
     *
     * @return {@link #baseCurrency} timestamp as {@link String}
     **/
    public String getBaseCurrency() {
        return baseCurrency;
    }

    /**
     * MethodId to get {@link #quoteCurrency} timestamp <br>
     * Any params required
     *
     * @return {@link #quoteCurrency} timestamp as {@link String}
     **/
    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    /**
     * MethodId to get {@link #quoteIncrement} timestamp <br>
     * Any params required
     *
     * @return {@link #quoteIncrement} timestamp as double
     **/
    public double getQuoteIncrement() {
        return quoteIncrement;
    }

    /**
     * MethodId to get {@link #quoteIncrement} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #quoteIncrement} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getQuoteIncrement(int decimals) {
        return roundValue(quoteIncrement, decimals);
    }

    /**
     * MethodId to get {@link #baseIncrement} timestamp <br>
     * Any params required
     *
     * @return {@link #baseIncrement} timestamp as double
     **/
    public double getBaseIncrement() {
        return baseIncrement;
    }

    /**
     * MethodId to get {@link #baseIncrement} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #baseIncrement} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getBaseIncrement(int decimals) {
        return roundValue(baseIncrement, decimals);
    }

    /**
     * MethodId to get {@link #displayName} timestamp <br>
     * Any params required
     *
     * @return {@link #displayName} timestamp as {@link String}
     **/
    public String getDisplayName() {
        return displayName;
    }

    /**
     * MethodId to get {@link #minMarketFunds} timestamp <br>
     * Any params required
     *
     * @return {@link #minMarketFunds} timestamp as double
     **/
    public double getMinMarketFunds() {
        return minMarketFunds;
    }

    /**
     * MethodId to get {@link #minMarketFunds} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #minMarketFunds} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getMinMarketFunds(int decimals) {
        return roundValue(minMarketFunds, decimals);
    }

    /**
     * MethodId to get {@link #marginEnabled} timestamp <br>
     * Any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isMarginEnabled() {
        return marginEnabled;
    }

    /**
     * MethodId to get {@link #marginEnabled} timestamp <br>
     * Any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isPostOnly() {
        return postOnly;
    }

    /**
     * MethodId to get {@link #marginEnabled} timestamp <br>
     * Any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isLimitOnly() {
        return limitOnly;
    }

    /**
     * MethodId to get {@link #marginEnabled} timestamp <br>
     * Any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isCancelOnly() {
        return cancelOnly;
    }

    /**
     * MethodId to get {@link #status} timestamp <br>
     * Any params required
     *
     * @return {@link #status} timestamp as {@link String}
     **/
    public String getStatus() {
        return status;
    }

    /**
     * MethodId to get {@link #statusMessage} timestamp <br>
     * Any params required
     *
     * @return {@link #statusMessage} timestamp as {@link String}
     **/
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * MethodId to get {@link #auctionMode} timestamp <br>
     * Any params required
     *
     * @return {@link #auctionMode} timestamp as boolean
     **/
    public boolean isAuctionMode() {
        return auctionMode;
    }

    /**
     * MethodId to get {@link #tradingDisabled} timestamp <br>
     * Any params required
     *
     * @return {@link #tradingDisabled} timestamp as boolean
     **/
    public boolean isTradingDisabled() {
        return tradingDisabled;
    }

    /**
     * MethodId to get {@link #fxStablecoin} timestamp <br>
     * Any params required
     *
     * @return {@link #fxStablecoin} timestamp as boolean
     **/
    public boolean isFxStablecoin() {
        return fxStablecoin;
    }

    /**
     * MethodId to get {@link #maxSlippagePercentage} timestamp <br>
     * Any params required
     *
     * @return {@link #maxSlippagePercentage} timestamp as double
     **/
    public double getMaxSlippagePercentage() {
        return maxSlippagePercentage;
    }

    /**
     * MethodId to get {@link #maxSlippagePercentage} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #maxSlippagePercentage} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getMaxSlippagePercentage(int decimals) {
        return roundValue(maxSlippagePercentage, decimals);
    }

    /**
     * Returns a string representation of the object <br>
     * Any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
