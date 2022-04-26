package com.tecknobit.coinbasemanager.Constants;

public class EndpointsList {

    /**ExchangePro: Account endpoints**/
    public static final String ACCOUNT_ENDPOINT = "/accounts";
    public static final String COINBASE_ACCOUNT_ENDPOINT = "/coinbase-accounts";

    /**ExchangePro: Conversions endpoints**/
    public static final String CONVERSIONS_ENDPOINT = "/conversions";

    /**ExchangePro: Currencies endpoints**/
    public static final String CURRENCIES_ENDPOINT = "/currencies";

    /**ExchangePro: Transfer endpoints**/
    public static final String DEPOSIT_FROM_COINBASE_ENDPOINT = "/deposits" + COINBASE_ACCOUNT_ENDPOINT;
    public static final String DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT = "/deposits/payment-method";
    public static final String PAYMENTS_METHOD_ENDPOINT = "/payment-methods";
    public static final String TRANSFERS_ENDPOINT = "/transfers";
    public static final String WITHDRAW_TO_COINBASE_ENDPOINT = "/withdrawals" + COINBASE_ACCOUNT_ENDPOINT;
    public static final String WITHDRAW_TO_CRYPTO_ENDPOINT = "/withdrawals/crypto";
    public static final String FEE_WITHDRAW_TO_CRYPTO_ENDPOINT = "/withdrawals/fee-estimate";
    public static final String WITHDRAW_TO_PAYMENT_METHOD_ENDPOINT = "/withdrawals/payment-method";

    /**ExchangePro: Fees endpoints**/
    public static final String FEES_ENDPOINT = "/fees";

    /**ExchangePro: Orders endpoints**/
    public static final String GET_ALL_FILLS_ENDPOINT = "/fills";
    public static final String ORDERS_ENDPOINT = "/orders";

    /**ExchangePro: PriceOracle endpoints**/
    public static final String PRICE_ORACLE_ENDPOINT = "/oracle";

    /**ExchangePro: Products endpoints**/
    public static final String PRODUCTS_ENDPOINT = "/products";
    public static final String GET_PRODUCT_BOOK_ENDPOINT = "/book";
    public static final String GET_PRODUCT_CANDLE_ENDPOINT = "/candles";
    public static final String GET_PRODUCT_STAT_ENDPOINT = "/stats";
    public static final String GET_PRODUCT_TICKER_ENDPOINT = "/ticker";
    public static final String GET_PRODUCT_TRADE_ENDPOINT = "/trades";

}
