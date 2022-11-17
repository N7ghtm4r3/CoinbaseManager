package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code FiatAccountMethod} class is useful to format a fiat account method
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
 * Get all payment methods</a>
 * @see PayMethod
 **/
public class FiatAccountMethod extends PayMethod {

    /**
     * Constructor to init a {@link FiatAccountMethod} object
     *
     * @param name: pay method name
     **/
    public FiatAccountMethod(String name) {
        super(name, FIAT_ACCOUNT_TYPE);
    }

    /**
     * The {@code FiatAccountDetails} class is useful to obtain and format the fiat account details for {@link FiatAccountMethod}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     **/
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

        /**
         * Constructor to init {@link FiatAccountDetails} object
         *
         * @param fiatAccount: fiat account details as {@link JSONObject}
         **/
        public FiatAccountDetails(JSONObject fiatAccount) {
            this(fiatAccount.getString("id"), fiatAccount.getString("resource"),
                    fiatAccount.getString("resource_path"));
        }

        /**
         * Method to get {@link #id} instance <br>
         * Any params required
         *
         * @return {@link #id} instance as {@link String}
         **/
        public String getId() {
            return id;
        }

        /**
         * Method to get {@link #resource} instance <br>
         * Any params required
         *
         * @return {@link #resource} instance as {@link String}
         **/
        public String getResource() {
            return resource;
        }

        /**
         * Method to get {@link #resourcePath} instance <br>
         * Any params required
         *
         * @return {@link #resourcePath} instance as {@link String}
         **/
        public String getResourcePath() {
            return resourcePath;
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

    /**
     * The {@code FiatAccountPickerData} class is useful to obtain and format FiatAccountPickerData object for FiatAccountMethod
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     **/
    public static class FiatAccountPickerData extends PickerData {

        /**
         * {@code amount} is instance that memorizes amount value
         **/
        private double amount;

        /**
         * {@code currency} is instance that memorizes currency value
         **/
        private String currency;

        /** Constructor to init {@link BankMethod.BankPickerData} object
         * @param symbol: symbol value
         * @param amount: amount value
         * @param currency: currency name value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public FiatAccountPickerData(String symbol, double amount, String currency) {
            super(symbol);
            if (amount < 0)
                throw new IllegalArgumentException("Amount value cannot be less than 0");
            else
                this.amount = amount;
            if (currency == null || currency.isEmpty())
                throw new IllegalArgumentException("Currency value cannot be empty or null");
            else
                this.currency = currency;
        }

        /**
         * Constructor to init {@link FiatAccountPickerData} object
         *
         * @param fiatPickerData: fiat picker details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public FiatAccountPickerData(JSONObject fiatPickerData) {
            this(fiatPickerData.getString("symbol"), fiatPickerData.getDouble("minimumPurchaseAmount"),
                    fiatPickerData.getString("currency"));
        }

        /**
         * Method to get {@link #amount} instance <br>
         * Any params required
         *
         * @return {@link #amount} instance as double
         **/
        public double getAmount() {
            return amount;
        }

        /**
         * Method to set {@link #amount}
         *
         * @param amount: amount value
         * @throws IllegalArgumentException when amount value is less than 0
         **/
        public void setAmount(double amount) {
            if (amount < 0)
                throw new IllegalArgumentException("Amount value cannot be less than 0");
            this.amount = amount;
        }

        /**
         * Method to get {@link #amount} instance
         *
         * @param decimals: number of digits to round final value
         * @return {@link #amount} instance rounded with decimal digits inserted
         * @throws IllegalArgumentException if decimalDigits is negative
         **/
        public double getAmount(int decimals) {
            return roundValue(amount, decimals);
        }

        /**
         * Method to get {@link #currency} instance <br>
         * Any params required
         *
         * @return {@link #currency} instance as {@link String}
         **/
        public String getCurrency() {
            return currency;
        }

        /**
         * Method to set {@link #currency}
         *
         * @param currency: currency value
         * @throws IllegalArgumentException when currency value is null or empty
         **/
        public void setCurrency(String currency) {
            if (currency == null || currency.isEmpty())
                throw new IllegalArgumentException("Currency value cannot be empty or null");
            this.currency = currency;
        }

    }

}
