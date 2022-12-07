package com.tecknobit.coinbasemanager.constants;

/**
 * The {@code EndpointsList} class is a container class for all {@code "Coinbase"}'s endpoints of the service API
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference">
 * https://docs.cloud.coinbase.com/exchange/reference</a>
 **/

public class EndpointsList {

    /**
     * {@code ACCOUNT_ENDPOINT} is constant for ACCOUNT_ENDPOINT's endpoint
     **/
    public static final String ACCOUNT_ENDPOINT = "/accounts";

    /**
     * {@code COINBASE_ACCOUNT_ENDPOINT} is constant for COINBASE_ACCOUNT_ENDPOINT's endpoint
     **/
    public static final String COINBASE_ACCOUNT_ENDPOINT = "/coinbase-accounts";

    /**
     * {@code CONVERSIONS_ENDPOINT} is constant for CONVERSIONS_ENDPOINT's endpoint
     * **/
    public static final String CONVERSIONS_ENDPOINT = "/conversions";

    /**
     * {@code CURRENCIES_ENDPOINT} is constant for CURRENCIES_ENDPOINT's endpoint
     * **/
    public static final String CURRENCIES_ENDPOINT = "/currencies";

    /**
     * {@code DEPOSIT_FROM_COINBASE_ENDPOINT} is constant for DEPOSIT_FROM_COINBASE_ENDPOINT's endpoint
     * **/
    public static final String DEPOSIT_FROM_COINBASE_ENDPOINT = "/deposits" + COINBASE_ACCOUNT_ENDPOINT;

    /**
     * {@code DEPOSIT_FROM_PAYMENT_ENDPOINT} is constant for DEPOSIT_FROM_PAYMENT_ENDPOINT's endpoint
     **/
    public static final String DEPOSIT_FROM_PAYMENT_ENDPOINT = "/deposits/payment-method";

    /**
     * {@code PAYMENTS_ENDPOINT} is constant for PAYMENTS_ENDPOINT's endpoint
     * **/
    public static final String PAYMENTS_ENDPOINT = "/payment-methods";

    /**
     * {@code TRANSFERS_ENDPOINT} is constant for TRANSFERS_ENDPOINT's endpoint
     * **/
    public static final String TRANSFERS_ENDPOINT = "/transfers";

    /**
     * {@code WITHDRAW_TO_COINBASE_ENDPOINT} is constant for WITHDRAW_TO_COINBASE_ENDPOINT's endpoint
     * **/
    public static final String WITHDRAW_TO_COINBASE_ENDPOINT = "/withdrawals" + COINBASE_ACCOUNT_ENDPOINT;

    /**
     * {@code WITHDRAW_TO_CRYPTO_ENDPOINT} is constant for WITHDRAW_TO_CRYPTO_ENDPOINT's endpoint
     * **/
    public static final String WITHDRAW_TO_CRYPTO_ENDPOINT = "/withdrawals/crypto";

    /**
     * {@code FEE_WITHDRAW_TO_CRYPTO_ENDPOINT} is constant for FEE_WITHDRAW_TO_CRYPTO_ENDPOINT's endpoint
     * **/
    public static final String FEE_WITHDRAW_TO_CRYPTO_ENDPOINT = "/withdrawals/fee-estimate";

    /**
     * {@code WITHDRAW_TO_PAYMENT_ENDPOINT} is constant for WITHDRAW_TO_PAYMENT_ENDPOINT's endpoint
     * **/
    public static final String WITHDRAW_TO_PAYMENT_ENDPOINT = "/withdrawals/payment-method";

    /**
     * {@code FEES_ENDPOINT} is constant for FEES_ENDPOINT's endpoint
     * **/
    public static final String FEES_ENDPOINT = "/fees";

    /**
     * {@code GET_ALL_FILLS_ENDPOINT} is constant for GET_ALL_FILLS_ENDPOINT's endpoint
     * **/
    public static final String GET_ALL_FILLS_ENDPOINT = "/fills";

    /**
     * {@code ORDERS_ENDPOINT} is constant for ORDERS_ENDPOINT's endpoint
     * **/
    public static final String ORDERS_ENDPOINT = "/orders";

    /**
     * {@code PRICE_ORACLE_ENDPOINT} is constant for PRICE_ORACLE_ENDPOINT's endpoint
     * **/
    public static final String PRICE_ORACLE_ENDPOINT = "/oracle";

    /**
     * {@code PRODUCTS_ENDPOINT} is constant for PRODUCTS_ENDPOINT's endpoint
     * **/
    public static final String PRODUCTS_ENDPOINT = "/products";

    /**
     * {@code GET_PRODUCT_BOOK_ENDPOINT} is constant for GET_PRODUCT_BOOK_ENDPOINT's endpoint
     * **/
    public static final String GET_PRODUCT_BOOK_ENDPOINT = "/book";

    /**
     * {@code GET_PRODUCT_CANDLE_ENDPOINT} is constant for GET_PRODUCT_CANDLE_ENDPOINT's endpoint
     * **/
    public static final String GET_PRODUCT_CANDLE_ENDPOINT = "/candles";

    /**
     * {@code GET_PRODUCT_STAT_ENDPOINT} is constant for GET_PRODUCT_STAT_ENDPOINT's endpoint
     * **/
    public static final String GET_PRODUCT_STAT_ENDPOINT = "/stats";

    /**
     * {@code GET_PRODUCT_TICKER_ENDPOINT} is constant for GET_PRODUCT_TICKER_ENDPOINT's endpoint
     * **/
    public static final String GET_PRODUCT_TICKER_ENDPOINT = "/ticker";

    /**
     * {@code GET_PRODUCT_TRADE_ENDPOINT} is constant for GET_PRODUCT_TRADE_ENDPOINT's endpoint
     * **/
    public static final String GET_PRODUCT_TRADE_ENDPOINT = "/trades";

    /**
     * {@code PROFILES_ENDPOINT} is constant for PROFILES_ENDPOINT's endpoint
     * **/
    public static final String PROFILES_ENDPOINT = "/profiles";

    /**
     * {@code TRANSFER_BETWEEN_PROFILES_ENDPOINT} is constant for TRANSFER_BETWEEN_PROFILES_ENDPOINT's endpoint
     * **/
    public static final String TRANSFER_BETWEEN_PROFILES_ENDPOINT = "/transfer";

    /**
     * {@code DELETE_PROFILE_ENDPOINT} is constant for DELETE_PROFILE_ENDPOINT's endpoint
     * **/
    public static final String DELETE_PROFILE_ENDPOINT = "/deactivate";

    /**
     * {@code REPORTS_ENDPOINT} is constant for REPORTS_ENDPOINT's endpoint
     * **/
    public static final String REPORTS_ENDPOINT = "/reports";

    /**
     * {@code USERS_ENDPOINT} is constant for USERS_ENDPOINT's endpoint
     **/
    public static final String USERS_ENDPOINT = "/users";

    /**
     * {@code EXCHANGE_LIMITS_ENDPOINT} is constant for EXCHANGE_LIMITS_ENDPOINT's endpoint
     **/
    public static final String EXCHANGE_LIMITS_ENDPOINT = "/exchange-limits";

    /**
     * {@code WRAPPED_ASSETS_ENDPOINT} is constant for WRAPPED_ASSETS_ENDPOINT's endpoint
     **/
    public static final String WRAPPED_ASSETS_ENDPOINT = "/wrapped-assets";

    /**
     * {@code CONVERSION_RATE_ENDPOINT} is constant for CONVERSION_RATE_ENDPOINT's endpoint
     **/
    public static final String CONVERSION_RATE_ENDPOINT = "/conversion-rate";

    /**
     * Constructor to avoid instantiation
     **/
    private EndpointsList() {
    }

}
