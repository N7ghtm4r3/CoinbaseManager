package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code TradingPair} class is useful to format TradingPair object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class TradingPair {

    private final String id;
    private final String baseCurrency;
    private final String quoteCurrency;
    private final double baseMinSize;
    private final double baseMaxSize;
    private final double quoteIncrement;
    private final double baseIncrement;
    private final String displayName;
    private final double minMarketFunds;
    private final double maxMarketFunds;
    private final boolean marginEnabled;
    private final boolean postOnly;
    private final boolean limitOnly;
    private final boolean cancelOnly;
    private final String status;
    private final String statusMessage;
    private final boolean auctionMode;

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

}
