package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods;

import org.json.JSONObject;

/**
 * The {@code PayMethod} class is useful to format general PayMethod object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
 * Deposit from {@code "Coinbase"} account</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
 * Deposit from payment method</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
 * Withdraw to {@code "Coinbase"} account</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
 * Withdraw to crypto address</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
 * Withdraw to payment method</a>
 * </li>
 * </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/
public class PayMethod {

    /**
     * {@code type} is instance that memorizes type value
     **/
    protected PayMethodType type;

    /**
     * {@code name} is instance that memorizes name value
     **/
    protected String name;

    /**
     * Constructor to init a {@link PayMethod} custom object
     *
     * @param name: pay method name
     * @param type: pay method type
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public PayMethod(String name, PayMethodType type) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        else
            this.name = name;
        this.type = type;
    }

    /**
     * Constructor to init a {@link PayMethod} custom object
     *
     * @param payment: payment details as {@link JSONObject}
     **/
    public PayMethod(JSONObject payment) {
        this(payment.getString("name"), PayMethodType.valueOf(payment.getString("type")));
    }

    /**
     * Method to get {@link #name} instance <br>
     * Any params required
     *
     * @return {@link #name} instance as {@link String}
     **/
    public String getName() {
        return name;
    }

    /**
     * Method to set {@link #name}
     *
     * @param name: name value
     * @throws IllegalArgumentException when name value is null or empty
     **/
    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        this.name = name;
    }

    /**
     * Method to get {@link #type} instance <br>
     * Any params required
     *
     * @return {@link #type} instance as {@link String}
     **/
    public PayMethodType getType() {
        return type;
    }

    /**
     * Method to set {@link #type}
     *
     * @param type: type value
     * @throws IllegalArgumentException when type value is null or empty
     **/
    public void setType(PayMethodType type) {
        this.type = type;
    }

    /**
     * {@code PayMethodType} list of available pay methods types
     **/
    public enum PayMethodType {

        /**
         * {@code "paypal"} pay methods type
         **/
        paypal,

        /**
         * {@code "bank"} pay methods type
         **/
        bank,

        /**
         * {@code "fiat_account"} pay methods type
         **/
        fiat_account

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

    /**
     * The {@code PickerData} class is useful to obtain and format a picker data
     *
     * @author N7ghtm4r3 - Tecknobit
     **/
    public static class PickerData {

        /**
         * {@code symbol} is instance that memorizes symbol value
         **/
        protected final String symbol;

        /**
         * Constructor to init {@link PickerData} custom object
         *
         * @param symbol: symbol value
         **/
        public PickerData(String symbol) {
            this.symbol = symbol;
        }

        /**
         * Method to get {@link #symbol} instance <br>
         * Any params required
         *
         * @return {@link #symbol} instance as {@link String}
         **/
        public String getSymbol() {
            return symbol;
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

}
