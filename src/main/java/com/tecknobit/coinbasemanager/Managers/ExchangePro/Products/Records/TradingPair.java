package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

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
     * **/
    private final double baseMinSize;

    /**
     * {@code baseMaxSize} is instance that memorizes base maximum size value
     * **/
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
     * **/
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
     * **/
    public TradingPair(String id, String baseCurrency, String quoteCurrency, double baseMinSize, double baseMaxSize,
                       double quoteIncrement, double baseIncrement, String displayName, double minMarketFunds,
                       double maxMarketFunds, boolean marginEnabled, boolean postOnly, boolean limitOnly, boolean cancelOnly,
                       String status, String statusMessage, boolean auctionMode) {
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

    public double getBaseMinSize() {
        return baseMinSize;
    }

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
                '}';
    }

}
