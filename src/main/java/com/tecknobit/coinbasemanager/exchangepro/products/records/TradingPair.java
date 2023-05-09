package com.tecknobit.coinbasemanager.exchangepro.products.records;

import com.tecknobit.coinbasemanager.exchangepro.records.CoinbaseItem;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code TradingPair} class is useful to format TradingPair object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
 * Get all known trading pairs</a>
 * @see CoinbaseItem
 **/
public class TradingPair extends CoinbaseItem {

    /**
     * {@code TradingPairStatus} list of available trading pair statuses
     **/
    public enum TradingPairStatus {

        /**
         * {@code online} trading pair status
         **/
        online,

        /**
         * {@code offline} trading pair status
         **/
        offline,

        /**
         * {@code internal} trading pair status
         **/
        internal,

        /**
         * {@code delisted} trading pair status
         **/
        delisted

    }

    /**
     * {@code id} is instance that memorizes identifier value
     **/
    private final String id;

    /**
     * {@code baseCurrency} is instance that memorizes base currency value
     **/
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
    private final TradingPairStatus status;

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
     **/
    private final double maxSlippagePercentage;

    /**
     * {@code highBidLimitPercentage} percentage to calculate highest price for limit buy order (Stable coin trading pair only)
     **/
    private final double highBidLimitPercentage;

    /**
     * Constructor to init a {@link TradingPair} custom object
     *
     * @param id                      : identifier value
     * @param baseCurrency            : base currency value
     * @param quoteCurrency           : quote currency value
     * @param quoteIncrement          : quote increment value
     * @param baseIncrement           : base increment value
     * @param displayName             : display name value
     * @param minMarketFunds          : minimum market founds value
     * @param marginEnabled           : flag that checks if margin is enabled
     * @param postOnly                : flag that checks if is only post
     * @param limitOnly               : flag that checks if is only limit
     * @param cancelOnly              : flag that checks if is only cancel
     * @param status                  : status value
     * @param statusMessage           : status message value
     * @param auctionMode             : flag that checks if is auction mode
     * @param tradingDisabled         : indicates whether trading is currently restricted on this product, this includes whether
     *                                both new orders and order cancellations are restricted
     * @param fxStablecoin            : indicates whether the currency pair is a Stable Pair
     * @param maxSlippagePercentage   : maximum slippage percentage
     * @param highBidLimitPercentage: percentage to calculate highest price for limit buy order (Stable coin trading pair only)
     **/
    public TradingPair(String id, String baseCurrency, String quoteCurrency, double quoteIncrement, double baseIncrement,
                       String displayName, double minMarketFunds, boolean marginEnabled, boolean postOnly, boolean limitOnly,
                       boolean cancelOnly, TradingPairStatus status, String statusMessage, boolean auctionMode,
                       boolean tradingDisabled, boolean fxStablecoin, double maxSlippagePercentage,
                       double highBidLimitPercentage) {
        super(null);
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
        this.highBidLimitPercentage = highBidLimitPercentage;
    }

    /**
     * Constructor to init a {@link TradingPair} custom object
     *
     * @param pair: trading pair details as {@link JSONObject}
     **/
    public TradingPair(JSONObject pair) {
        super(pair);
        id = hItem.getString("id");
        baseCurrency = hItem.getString("base_currency");
        quoteCurrency = hItem.getString("quote_currency");
        quoteIncrement = hItem.getDouble("quote_increment", 0);
        baseIncrement = hItem.getDouble("base_increment", 0);
        displayName = hItem.getString("display_name");
        minMarketFunds = hItem.getDouble("min_market_funds", 0);
        marginEnabled = hItem.getBoolean("margin_enabled");
        postOnly = hItem.getBoolean("post_only");
        limitOnly = hItem.getBoolean("limit_only");
        cancelOnly = hItem.getBoolean("cancel_only");
        status = TradingPairStatus.valueOf(hItem.getString("status"));
        statusMessage = hItem.getString("status_message");
        auctionMode = hItem.getBoolean("auction_mode");
        tradingDisabled = hItem.getBoolean("trading_disabled");
        fxStablecoin = hItem.getBoolean("fx_stablecoin");
        maxSlippagePercentage = hItem.getDouble("max_slippage_percentage", 0);
        String sHBL = hItem.getString("high_bid_limit_percentage", "0");
        if (sHBL.isEmpty())
            sHBL = "0";
        highBidLimitPercentage = Double.parseDouble(sHBL);
    }

    /**
     * Method to get {@link #id} timestamp <br>
     * No-any params required
     *
     * @return {@link #id} timestamp as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #baseCurrency} timestamp <br>
     * No-any params required
     *
     * @return {@link #baseCurrency} timestamp as {@link String}
     **/
    public String getBaseCurrency() {
        return baseCurrency;
    }

    /**
     * Method to get {@link #quoteCurrency} timestamp <br>
     * No-any params required
     *
     * @return {@link #quoteCurrency} timestamp as {@link String}
     **/
    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    /**
     * Method to get {@link #quoteIncrement} timestamp <br>
     * No-any params required
     *
     * @return {@link #quoteIncrement} timestamp as double
     **/
    public double getQuoteIncrement() {
        return quoteIncrement;
    }

    /**
     * Method to get {@link #quoteIncrement} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #quoteIncrement} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getQuoteIncrement(int decimals) {
        return roundValue(quoteIncrement, decimals);
    }

    /**
     * Method to get {@link #baseIncrement} timestamp <br>
     * No-any params required
     *
     * @return {@link #baseIncrement} timestamp as double
     **/
    public double getBaseIncrement() {
        return baseIncrement;
    }

    /**
     * Method to get {@link #baseIncrement} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #baseIncrement} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getBaseIncrement(int decimals) {
        return roundValue(baseIncrement, decimals);
    }

    /**
     * Method to get {@link #displayName} timestamp <br>
     * No-any params required
     *
     * @return {@link #displayName} timestamp as {@link String}
     **/
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Method to get {@link #minMarketFunds} timestamp <br>
     * No-any params required
     *
     * @return {@link #minMarketFunds} timestamp as double
     **/
    public double getMinMarketFunds() {
        return minMarketFunds;
    }

    /**
     * Method to get {@link #minMarketFunds} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #minMarketFunds} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getMinMarketFunds(int decimals) {
        return roundValue(minMarketFunds, decimals);
    }

    /**
     * Method to get {@link #marginEnabled} timestamp <br>
     * No-any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isMarginEnabled() {
        return marginEnabled;
    }

    /**
     * Method to get {@link #marginEnabled} timestamp <br>
     * No-any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isPostOnly() {
        return postOnly;
    }

    /**
     * Method to get {@link #marginEnabled} timestamp <br>
     * No-any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isLimitOnly() {
        return limitOnly;
    }

    /**
     * Method to get {@link #marginEnabled} timestamp <br>
     * No-any params required
     *
     * @return {@link #marginEnabled} timestamp as boolean
     **/
    public boolean isCancelOnly() {
        return cancelOnly;
    }

    /**
     * Method to get {@link #status} timestamp <br>
     * No-any params required
     *
     * @return {@link #status} timestamp as {@link String}
     **/
    public TradingPairStatus getStatus() {
        return status;
    }

    /**
     * Method to get {@link #statusMessage} timestamp <br>
     * No-any params required
     *
     * @return {@link #statusMessage} timestamp as {@link String}
     **/
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Method to get {@link #auctionMode} timestamp <br>
     * No-any params required
     *
     * @return {@link #auctionMode} timestamp as boolean
     **/
    public boolean isAuctionMode() {
        return auctionMode;
    }

    /**
     * Method to get {@link #tradingDisabled} timestamp <br>
     * No-any params required
     *
     * @return {@link #tradingDisabled} timestamp as boolean
     **/
    public boolean isTradingDisabled() {
        return tradingDisabled;
    }

    /**
     * Method to get {@link #fxStablecoin} timestamp <br>
     * No-any params required
     *
     * @return {@link #fxStablecoin} timestamp as boolean
     **/
    public boolean isFxStablecoin() {
        return fxStablecoin;
    }

    /**
     * Method to get {@link #maxSlippagePercentage} timestamp <br>
     * No-any params required
     *
     * @return {@link #maxSlippagePercentage} timestamp as double
     **/
    public double getMaxSlippagePercentage() {
        return maxSlippagePercentage;
    }

    /**
     * Method to get {@link #maxSlippagePercentage} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #maxSlippagePercentage} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getMaxSlippagePercentage(int decimals) {
        return roundValue(maxSlippagePercentage, decimals);
    }

    /**
     * Method to get {@link #highBidLimitPercentage} timestamp <br>
     * No-any params required
     *
     * @return {@link #highBidLimitPercentage} timestamp as double
     **/
    public double getHighBidLimitPercentage() {
        return highBidLimitPercentage;
    }

    /**
     * Method to get {@link #highBidLimitPercentage} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #highBidLimitPercentage} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getHighBidLimitPercentage(int decimals) {
        return roundValue(highBidLimitPercentage, decimals);
    }


}
