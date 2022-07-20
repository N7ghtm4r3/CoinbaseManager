package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

/**
 * The {@code PayMethod} class is useful to format general PayMethod object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PayMethod {

    /**
     * {@code PAYPAL_TYPE} is constant for PayPal's pay method type
     * **/
    public static final String PAYPAL_TYPE = "paypal";

    /**
     * {@code BANK_TYPE} is constant for bank's pay method type
     * **/
    public static final String BANK_TYPE = "bank";

    /**
     * {@code FIAT_ACCOUNT_TYPE} is constant for fiat account's pay method type
     * **/
    public static final String FIAT_ACCOUNT_TYPE = "fiat_account";

    /**
     * {@code name} is instance that memorizes name value
     * **/
    protected String name;

    /**
     * {@code type} is instance that memorizes type value
     * **/
    protected String type;

    /** Constructor to init a {@link PayMethod} object
     * @param name: pay method name
     * @param type: pay method type
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public PayMethod(String name, String type) {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        else
            this.name = name;
        if(!isTypeValid(type))
            throw new IllegalArgumentException("Type value cannot be null and must be fiat_account, bank or paypal type");
        else
            this.type = type;
    }

    public String getName() {
        return name;
    }

    /** Method to set {@link #name}
     * @param name: name value
     * @throws IllegalArgumentException when name value is null or empty
     * **/
    public void setName(String name) {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        this.name = name;
    }

    public String getType() {
        return type;
    }

    /** Method to set {@link #type}
     * @param type: type value
     * @throws IllegalArgumentException when type value is null or empty
     * **/
    public void setType(String type) {
        if(!isTypeValid(type))
            throw new IllegalArgumentException("Type value cannot be null and must be fiat_account, bank or paypal type");
        this.type = type;
    }

    /** Method to check validity of {@link #type}
     * @param type: type value
     * @return validity of type as boolean
     * **/
    private boolean isTypeValid(String type){
        return type != null && (type.equals(FIAT_ACCOUNT_TYPE) || type.equals(PAYPAL_TYPE) || type.equals(BANK_TYPE));
    }

    /**
     * The {@code PickerData} class is useful to obtain and format PickerData
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class PickerData{

        /**
         * {@code symbol} is instance that memorizes symbol value
         * **/
        protected final String symbol;

        /** Constructor to init {@link PickerData} object
         * @param symbol: symbol value
         * **/
        public PickerData(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

}
