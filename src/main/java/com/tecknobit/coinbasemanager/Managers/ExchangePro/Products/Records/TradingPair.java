package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code TradingPair} class is useful to format TradingPair object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

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
     * {@code baseMinSize} is instance that memorizes base minimum size value
     * @deprecated This instance and correlated usages will be removed in the next update
     * **/
    @Deprecated
    private final double baseMinSize;

    /**
     * {@code baseMaxSize} is instance that memorizes base maximum size value
     * @deprecated This instance and correlated usages will be removed in the next update
     * **/
    @Deprecated
    private final double baseMaxSize;

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
     * {@code maxMarketFunds} is instance that memorizes maximum market founds value
     * @deprecated This instance and correlated usages will be removed in the next update
     * **/
    @Deprecated
    private final double maxMarketFunds;

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

    /** Constructor to init a {@link TradingPair} object
     * @param id: identifier value
     * @param baseCurrency: base currency value
     * @param quoteCurrency: quote currency value
     * @param baseMinSize: base minimum size value
     * @param baseMaxSize: base maximum size value
     * @param quoteIncrement: quote increment value
     * @param baseIncrement: base increment value
     * @param displayName: display name value
     * @param minMarketFunds: minimum market founds value
     * @param maxMarketFunds: maximum market founds value
     * @param marginEnabled: flag that checks if margin is enabled
     * @param postOnly: flag that checks if is only post
     * @param limitOnly: flag that checks if is only limit
     * @param cancelOnly: flag that checks if is only cancel
     * @param status: status value
     * @param statusMessage: status message value
     * @param auctionMode: flag that checks if is auction mode
     * @param tradingDisabled: indicates whether trading is currently restricted on this product, this includes whether both new orders and order cancelations are restricted
     * @param fxStablecoin: indicates whether the currency pair is a Stable Pair
     * @param maxSlippagePercentage: maximum slippage percentage
     * @deprecated following instances will be removed in the next update: {@link #baseMinSize}, {@link #baseMaxSize} and {@link #maxMarketFunds}
     * **/
    @Deprecated
    public TradingPair(String id, String baseCurrency, String quoteCurrency, double baseMinSize, double baseMaxSize,
                       double quoteIncrement, double baseIncrement, String displayName, double minMarketFunds,
                       double maxMarketFunds, boolean marginEnabled, boolean postOnly, boolean limitOnly, boolean cancelOnly,
                       String status, String statusMessage, boolean auctionMode, boolean tradingDisabled, boolean fxStablecoin,
                       double maxSlippagePercentage) {
        this.id = id;
        this.baseCurrency = baseCurrency;
        this.quoteCurrency = quoteCurrency;
        this.baseMinSize = baseMinSize;
        this.baseMaxSize = baseMaxSize;
        this.quoteIncrement = quoteIncrement;
        this.baseIncrement = baseIncrement;
        this.displayName = displayName;
        this.minMarketFunds = minMarketFunds;
        this.maxMarketFunds = maxMarketFunds;
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

    /** Constructor to init a {@link TradingPair} object
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
     * @param tradingDisabled: indicates whether trading is currently restricted on this product, this includes whether both new orders and order cancelations are restricted
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
        baseMinSize = -1;
        baseMaxSize = -1;
        maxMarketFunds = -1;
    }

    /** Constructor to init a {@link TradingPair} object
     * @param pair: trading pair details as {@link JSONObject}
     * **/
    public TradingPair(JSONObject pair) {
        id = pair.getString("id");
        baseCurrency = pair.getString("base_currency");
        quoteCurrency = pair.getString("quote_currency");
        quoteIncrement = pair.getDouble("quote_increment");
        baseIncrement = pair.getDouble("base_increment");
        displayName = pair.getString("display_name");
        minMarketFunds = pair.getDouble("min_market_funds");
        marginEnabled = pair.getBoolean("margin_enabled");
        postOnly = pair.getBoolean("post_only");
        limitOnly = pair.getBoolean("limit_only");
        cancelOnly = pair.getBoolean("cancel_only");
        status = pair.getString("status");
        statusMessage = pair.getString("status_message");
        auctionMode = pair.getBoolean("auction_mode");
        tradingDisabled = pair.getBoolean("trading_disabled");
        fxStablecoin = pair.getBoolean("fx_stablecoin");
        maxSlippagePercentage = pair.getDouble("max_slippage_percentage");
        baseMinSize = -1;
        baseMaxSize = -1;
        maxMarketFunds = -1;
    }

    public String getId() {
        return id;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    /**@deprecated This method and correlated instance {@link #baseMinSize} will be removed in the next update**/
    @Deprecated
    public double getBaseMinSize() {
        return baseMinSize;
    }

    /**@deprecated This method and correlated instance {@link #baseMaxSize} will be removed in the next update**/
    @Deprecated
    public double getBaseMaxSize() {
        return baseMaxSize;
    }

    public double getQuoteIncrement() {
        return quoteIncrement;
    }

    public double getBaseIncrement() {
        return baseIncrement;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getMinMarketFunds() {
        return minMarketFunds;
    }

    /**@deprecated This method and correlated instance {@link #maxMarketFunds} will be removed in the next update**/
    @Deprecated
    public double getMaxMarketFunds() {
        return maxMarketFunds;
    }

    public boolean isMarginEnabled() {
        return marginEnabled;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public boolean isLimitOnly() {
        return limitOnly;
    }

    public boolean isCancelOnly() {
        return cancelOnly;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public boolean isAuctionMode() {
        return auctionMode;
    }

    public boolean isTradingDisabled() {
        return tradingDisabled;
    }

    public boolean isFxStablecoin() {
        return fxStablecoin;
    }

    public double getMaxSlippagePercentage() {
        return maxSlippagePercentage;
    }

    /** Method to get {@link #maxSlippagePercentage} instance
     * @param decimals: number of digits to round final value
     * @return {@link #maxSlippagePercentage} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getMaxSlippagePercentage(int decimals) {
        return roundValue(maxSlippagePercentage, decimals);
    }

    @Override
    public String toString() {
        return "TradingPair{" +
                "id='" + id + '\'' +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", quoteCurrency='" + quoteCurrency + '\'' +
                ", baseMinSize=" + baseMinSize +
                ", baseMaxSize=" + baseMaxSize +
                ", quoteIncrement=" + quoteIncrement +
                ", baseIncrement=" + baseIncrement +
                ", displayName='" + displayName + '\'' +
                ", minMarketFunds=" + minMarketFunds +
                ", maxMarketFunds=" + maxMarketFunds +
                ", marginEnabled=" + marginEnabled +
                ", postOnly=" + postOnly +
                ", limitOnly=" + limitOnly +
                ", cancelOnly=" + cancelOnly +
                ", status='" + status + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", auctionMode=" + auctionMode +
                ", tradingDisabled=" + tradingDisabled +
                ", fxStablecoin=" + fxStablecoin +
                ", maxSlippagePercentage=" + maxSlippagePercentage +
                '}';
    }

}
