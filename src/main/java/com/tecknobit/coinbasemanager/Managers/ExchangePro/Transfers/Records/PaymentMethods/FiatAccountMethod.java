package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code FiatAccountMethod} class is useful to format FiatAccountMethod object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class FiatAccountMethod extends PayMethod{

    /** Constructor to init a {@link FiatAccountMethod} object
     * @param name: pay method name
     * @param type: pay method type
     * **/
    public FiatAccountMethod(String name, String type) {
        super(name, type);
    }

    /**
     * The {@code FiatAccountDetails} class is useful to obtain and format FiatAccountDetails object for FiatAccountMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class FiatAccountDetails {

        /**
         * {@code id} is instance that memorizes identifier value
         * **/
        private final String id;

        /**
         * {@code resource} is instance that memorizes resource value
         * **/
        private final String resource;

        /**
         * {@code resourcePath} is instance that memorizes resource path value
         * **/
        private final String resourcePath;

        /** Constructor to init {@link FiatAccountDetails} object
         * @param id: identifier value
         * @param resource: resource value
         * @param resourcePath: resource path value
         * **/
        public FiatAccountDetails(String id, String resource, String resourcePath) {
            this.id = id;
            this.resource = resource;
            this.resourcePath = resourcePath;
        }

        /** Constructor to init {@link FiatAccountDetails} object
         * @param fiatAccount: fiat account details as {@link JSONObject}
         * **/
        public FiatAccountDetails(JSONObject fiatAccount) {
            id = fiatAccount.getString("id");
            resource = fiatAccount.getString("resource");
            resourcePath = fiatAccount.getString("resource_path");
        }

        public String getId() {
            return id;
        }

        public String getResource() {
            return resource;
        }

        public String getResourcePath() {
            return resourcePath;
        }

        @Override
        public String toString() {
            return "FiatAccountDetails{" +
                    "id='" + id + '\'' +
                    ", resource='" + resource + '\'' +
                    ", resourcePath='" + resourcePath + '\'' +
                    '}';
        }

    }

    /**
     * The {@code FiatAccountPickerData} class is useful to obtain and format FiatAccountPickerData object for FiatAccountMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class FiatAccountPickerData extends PickerData{

        /**
         * {@code amount} is instance that memorizes amount value
         * **/
        private double amount;

        /**
         * {@code currency} is instance that memorizes currency value
         * **/
        private String currency;

        /** Constructor to init {@link BankMethod.BankPickerData} object
         * @param symbol: symbol value
         * @param amount: amount value
         * @param currency: currency name value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public FiatAccountPickerData(String symbol, double amount, String currency) {
            super(symbol);
            if(amount < 0)
                throw new IllegalArgumentException("Amount value cannot be less than 0");
            else
                this.amount = amount;
            if(currency == null || currency.isEmpty())
                throw new IllegalArgumentException("Currency value cannot be empty or null");
            else
                this.currency = currency;
        }

        /** Constructor to init {@link FiatAccountPickerData} object
         * @param symbol: symbol value
         * @param fiatPickerData: fiat picker details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public FiatAccountPickerData(String symbol, JSONObject fiatPickerData) {
            super(symbol);
            amount = fiatPickerData.getDouble("minimumPurchaseAmount");
            if(amount < 0)
                throw new IllegalArgumentException("Amount value cannot be less than 0");
            currency = fiatPickerData.getString("currency");
            if(currency == null || currency.isEmpty())
                throw new IllegalArgumentException("Currency value cannot be empty or null");
        }

        public double getAmount() {
            return amount;
        }

        /** Method to get {@link #amount} instance
         * @param decimals: number of digits to round final value
         * @return {@link #amount} instance rounded with decimal digits inserted
         * @throws IllegalArgumentException if decimalDigits is negative
         * **/
        public double getAmount(int decimals) {
            return roundValue(amount, decimals);
        }

        /** Method to set {@link #amount}
         * @param amount: amount value
         * @throws IllegalArgumentException when amount value is less than 0
         * **/
        public void setAmount(double amount) {
            if(amount < 0)
                throw new IllegalArgumentException("Amount value cannot be less than 0");
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        /** Method to set {@link #currency}
         * @param currency: currency value
         * @throws IllegalArgumentException when currency value is null or empty
         * **/
        public void setCurrency(String currency) {
            if(currency == null || currency.isEmpty())
                throw new IllegalArgumentException("Currency value cannot be empty or null");
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "FiatAccountPickerData{" +
                    "amount=" + amount +
                    ", currency='" + currency + '\'' +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }

    }

}
