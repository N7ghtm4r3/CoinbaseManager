package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

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

        public double getAmount() {
            return amount;
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
