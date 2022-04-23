package com.tecknobit.coinbasemanager.Constants;

public class EndpointsList {

    /**Account endpoints**/
    public static final String ACCOUNT_ENDPOINT = "/accounts";
    public static final String COINBASE_ACCOUNT_ENDPOINT = "/coinbase-accounts";

    /**Conversions endpoints**/
    public static final String CONVERSIONS_ENDPOINT = "/conversions";

    /**Currencies endpoints**/
    public static final String CURRENCIES_ENDPOINT = "/currencies";

    /**Transfer endpoints**/
    public static final String DEPOSIT_FROM_COINBASE_ENDPOINT = "/deposits" + COINBASE_ACCOUNT_ENDPOINT;
    public static final String DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT = "/deposits/payment-method";
    public static final String PAYMENTS_METHOD_ENDPOINT = "/payment-methods";
    public static final String TRANSFERS_ENDPOINT = "/transfers";
    public static final String WITHDRAW_TO_COINBASE_ENDPOINT = "/withdrawals" + COINBASE_ACCOUNT_ENDPOINT;
    public static final String WITHDRAW_TO_CRYPTO_ENDPOINT = "/withdrawals/crypto";
    public static final String WITHDRAW_TO_PAYMENT_METHOD_ENDPOINT = "/withdrawals/payment-method";

}
