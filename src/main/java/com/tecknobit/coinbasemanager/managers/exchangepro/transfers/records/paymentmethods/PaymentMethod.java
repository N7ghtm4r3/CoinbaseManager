package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods;

import com.tecknobit.apimanager.formatters.JsonHelper;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code PayPalMethod} class is useful to format a payment method
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
 * Get all payment methods</a>
 * @see PayMethod
 **/
public class PaymentMethod extends PayMethod {

    /**
     * {@code id} is instance that memorizes identifier value
     **/
    private final String id;

    /**
     * {@code currency} is instance that memorizes currency value
     **/
    private final String currency;

    /**
     * {@code primaryBuy} is flag that checks if this is primary buy
     * **/
    private final boolean primaryBuy;

    /**
     * {@code primarySell} is flag that checks if this is primary sell
     * **/
    private final boolean primarySell;

    /**
     * {@code instantBuy} is flag that checks if this is instant buy
     * **/
    private final boolean instantBuy;

    /**
     * {@code instantSell} is flag that checks if this is instant sell
     * **/
    private final boolean instantSell;

    /**
     * {@code createdAt} is instance that memorizes created at value
     * **/
    private final String createdAt;

    /**
     * {@code updatedAt} is instance that memorizes updated at value
     * **/
    private final String updatedAt;

    /**
     * {@code resource} is instance that memorizes resource value
     * **/
    private final String resource;

    /**
     * {@code resourcePath} is instance that memorizes resource path value
     * **/
    private final String resourcePath;

    /**
     * {@code allowBuy} is flag that checks if buy is allowed
     * **/
    private final boolean allowBuy;

    /**
     * {@code allowSell} is flag that checks if sell is allowed
     * **/
    private final boolean allowSell;

    /**
     * {@code allowDeposit} is flag that checks if deposit is allowed
     * **/
    private final boolean allowDeposit;

    /**
     * {@code allowWithdraw} is flag that checks if withdraw is allowed
     * **/
    private final boolean allowWithdraw;

    /**
     * {@code verified} is flag that checks if this method is verified
     * **/
    private final boolean verified;

    /**
     * {@code holdBusinessDays} is instance that memorizes hold business days value
     * **/
    private final int holdBusinessDays;

    /**
     * {@code holdBusinessDays} is instance that memorizes hold days value
     * **/
    private final int holdDays;

    /**
     * {@code hPayment} is instance useful to help to format JSON responses API
     **/
    private final JsonHelper hPayment;

    /**
     * {@code minimumPurchaseAmount} is instance that memorizes minimum purchase amount value
     * **/
    private final Amount minimumPurchaseAmount;

    /**
     * {@code payPalLimits} is instance that memorizes PayPal's limits in JSON format
     * **/
    private JSONObject payPalLimits;

    /**
     * {@code bankLimits} is instance that memorizes bank's limits in JSON format
     * **/
    private JSONObject bankLimits;

    /**
     * {@code payPalPickerData} is instance that memorizes PayPal's picker data in JSON format
     * **/
    private JSONObject payPalPickerData;

    /**
     * {@code bankPickerData} is instance that memorizes bank's picker data in JSON format
     * **/
    private JSONObject bankPickerData;

    /**
     * {@code fiatAccountLimit} is instance that memorizes fiat account's limits in JSON format
     * **/
    private JSONObject fiatAccountLimit;

    /**
     * {@code fiatAccountDetails} is instance that memorizes fiat account's details in JSON format
     * **/
    private JSONObject fiatAccountDetails;

    /**
     * {@code fiatAccountDetails} is instance that memorizes fiat account's picker data in JSON format
     * **/
    private JSONObject fiatAccountPickerData;

    /** Constructor to init a {@link PaymentMethod} object
     * @param name: pay method name
     * @param type: pay method type
     * @param id: identifier value
     * @param currency: currency value
     * @param primaryBuy: flag that checks if this is primary buy
     * @param primarySell: flag that checks if this is primary sell
     * @param instantBuy: flag that checks if this is instant buy
     * @param instantSell: flag that checks if this is instant sell
     * @param createdAt: created at value
     * @param updatedAt: updated at value
     * @param resource: resource value
     * @param resourcePath: resource path value
     * @param allowBuy: flag that checks if buy is allowed
     * @param allowSell: flag that checks if sell is allowed
     * @param allowDeposit: flag that checks if deposit is allowed
     * @param allowWithdraw: flag that checks if withdraw is allowed
     * @param verified: flag that checks if this method is verified
     * @param holdBusinessDays: hold business days value
     * @param holdDays: hold days values
     * @param minimumPurchaseAmount: minimum purchase amount value
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public PaymentMethod(String id, String type, String name, String currency, boolean primaryBuy, boolean primarySell,
                         boolean instantBuy, boolean instantSell, String createdAt, String updatedAt, String resource,
                         String resourcePath, boolean allowBuy, boolean allowSell, boolean allowDeposit, boolean allowWithdraw,
                         boolean verified, int holdBusinessDays, int holdDays, Amount minimumPurchaseAmount) {
        super(name, type);
        this.id = id;
        this.currency = currency;
        this.primaryBuy = primaryBuy;
        this.primarySell = primarySell;
        this.instantBuy = instantBuy;
        this.instantSell = instantSell;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.resource = resource;
        this.resourcePath = resourcePath;
        this.allowBuy = allowBuy;
        this.allowSell = allowSell;
        this.allowDeposit = allowDeposit;
        this.allowWithdraw = allowWithdraw;
        this.verified = verified;
        this.holdBusinessDays = holdBusinessDays;
        this.holdDays = holdDays;
        this.minimumPurchaseAmount = minimumPurchaseAmount;
        hPayment = null;
    }

    /** Constructor to init a {@link PaymentMethod} object
     * @param payment: payment details as {@link JSONArray}
     * **/
    public PaymentMethod(JSONObject payment) {
        super(payment);
        hPayment = new JsonHelper(payment);
        id = payment.getString("id");
        currency = payment.getString("currency");
        primaryBuy = payment.getBoolean("primary_buy");
        primarySell = payment.getBoolean("primary_sell");
        instantBuy = payment.getBoolean("instant_buy");
        instantSell = payment.getBoolean("instant_sell");
        createdAt = payment.getString("created_at");
        updatedAt = payment.getString("updated_at");
        resource = payment.getString("resource");
        resourcePath = payment.getString("resource_path");
        allowBuy = payment.getBoolean("allow_buy");
        allowSell = payment.getBoolean("allow_sell");
        allowDeposit = payment.getBoolean("allow_deposit");
        allowWithdraw = payment.getBoolean("allow_withdraw");
        verified = payment.getBoolean("verified");
        holdBusinessDays = hPayment.getInt("hold_business_days");
        holdDays = hPayment.getInt("hold_days");
        minimumPurchaseAmount = new Amount(hPayment.getJSONObject("minimum_purchase_amount"));
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
     * Method to get {@link #currency} instance <br>
     * Any params required
     *
     * @return {@link #currency} instance as {@link String}
     **/
    public String getCurrency() {
        return currency;
    }

    /**
     * Method to get {@link #primaryBuy} instance <br>
     * Any params required
     *
     * @return {@link #primaryBuy} instance as boolean
     **/
    public boolean isPrimaryBuy() {
        return primaryBuy;
    }

    /**
     * Method to get {@link #primarySell} instance <br>
     * Any params required
     *
     * @return {@link #primarySell} instance as boolean
     **/
    public boolean isPrimarySell() {
        return primarySell;
    }

    /**
     * Method to get {@link #instantBuy} instance <br>
     * Any params required
     *
     * @return {@link #instantBuy} instance as boolean
     **/
    public boolean isInstantBuy() {
        return instantBuy;
    }

    /**
     * Method to get {@link #instantSell} instance <br>
     * Any params required
     *
     * @return {@link #instantSell} instance as boolean
     **/
    public boolean isInstantSell() {
        return instantSell;
    }

    /**
     * Method to get {@link #createdAt} instance <br>
     * Any params required
     *
     * @return {@link #createdAt} instance as {@link String}
     **/
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to get {@link #createdAt} timestamp <br>
     * Any params required
     *
     * @return {@link #createdAt} timestamp as long
     **/
    public long getCreatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(createdAt);
    }

    /**
     * Method to get {@link #updatedAt} instance <br>
     * Any params required
     *
     * @return {@link #updatedAt} instance as {@link String}
     **/
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Method to get {@link #updatedAt} timestamp <br>
     * Any params required
     *
     * @return {@link #updatedAt} timestamp as long
     **/
    public long getUpdatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(updatedAt);
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
     * Method to get {@link #allowBuy} instance <br>
     * Any params required
     *
     * @return {@link #allowBuy} instance as boolean
     **/
    public boolean isAllowedBuy() {
        return allowBuy;
    }

    /**
     * Method to get {@link #allowSell} instance <br>
     * Any params required
     *
     * @return {@link #allowSell} instance as boolean
     **/
    public boolean isAllowedSell() {
        return allowSell;
    }

    /**
     * Method to get {@link #allowDeposit} instance <br>
     * Any params required
     *
     * @return {@link #allowDeposit} instance as boolean
     **/
    public boolean isAllowedDeposit() {
        return allowDeposit;
    }

    /**
     * Method to get {@link #allowWithdraw} instance <br>
     * Any params required
     *
     * @return {@link #allowWithdraw} instance as boolean
     **/
    public boolean isAllowedWithdraw() {
        return allowWithdraw;
    }

    /**
     * Method to get {@link #verified} instance <br>
     * Any params required
     *
     * @return {@link #verified} instance as boolean
     **/
    public boolean isVerified() {
        return verified;
    }

    /**
     * Method to get {@link #holdBusinessDays} instance <br>
     * Any params required
     *
     * @return {@link #holdBusinessDays} instance as int
     **/
    public int getHoldBusinessDays() {
        return holdBusinessDays;
    }

    /**
     * Method to get {@link #holdDays} instance <br>
     * Any params required
     *
     * @return {@link #holdDays} instance as int
     **/
    public int getHoldDays() {
        return holdDays;
    }

    /**
     * Method to get {@link #minimumPurchaseAmount} instance <br>
     * Any params required
     *
     * @return {@link #minimumPurchaseAmount} instance as {@link Amount}
     **/
    public Amount getMinimumPurchaseAmount() {
        return minimumPurchaseAmount;
    }

    /**
     * Method to get PayPal limits details <br>
     * Any params required
     *
     * @return PayPal limits details as {@link PayPalMethod} object, if is not a PayPal method will return null value
     **/
    public PayPalMethod getPayPalLimits() {
        if (payPalLimits == null)
            payPalLimits = hPayment.getJSONObject("limits");
        if (payPalLimits != null && payPalLimits.getString("type").equals(PAYPAL_TYPE))
            return new PayPalMethod(payPalLimits);
        return null;
    }

    /** Method to get PayPal picker data details <br>
     * Any params required
     * @return PayPal picker data details as {@link PayPalMethod.PayPalPickerData} object, if is not a PayPal method will return null value
     * **/
    public PayPalMethod.PayPalPickerData getPayPalPickerData(){
        if(payPalPickerData == null)
            payPalPickerData = hPayment.getJSONObject("picker_data");
        if(payPalPickerData != null){
            String symbol = payPalPickerData.getString("symbol");
            if(symbol.equals(PAYPAL_TYPE))
                return new PayPalMethod.PayPalPickerData(payPalPickerData.put("symbol", symbol));
            return null;
        }
        return null;
    }

    /** Method to get Bank limits details <br>
     * Any params required
     * @return Bank limits details as {@link BankMethod} object, if is not a Bank method will return null value
     * **/
    public BankMethod getBankLimits() {
        if (bankLimits == null)
            bankLimits = hPayment.getJSONObject("limits");
        if (bankLimits != null && bankLimits.getString("type").equals(BANK_TYPE))
            return new BankMethod(bankLimits.getString("name"));
        return null;
    }

    /** Method to get Bank picker data details <br>
     * Any params required
     * @return Bank picker data details as {@link BankMethod.BankPickerData} object, if is not a Bank method will return null value
     * **/
    public BankMethod.BankPickerData getBankPickerData(){
        if(bankPickerData == null)
            bankPickerData = hPayment.getJSONObject("picker_data");
        if(bankPickerData != null){
            String symbol = bankPickerData.getString("symbol");
            if(symbol.equals(BANK_TYPE))
                return new BankMethod.BankPickerData(bankPickerData.put("symbol", symbol));
            return null;
        }
        return null;
    }

    /** Method to get Fiat Account details <br>
     * Any params required
     * @return PayPal picker data details as {@link FiatAccountMethod.FiatAccountDetails} object,
     * if is not a Fiat Account method will return null value
     * **/
    public FiatAccountMethod.FiatAccountDetails getFiatAccountDetails(){
        if(fiatAccountDetails == null)
            fiatAccountDetails = hPayment.getJSONObject(FIAT_ACCOUNT_TYPE);
        if(fiatAccountDetails != null)
            return new FiatAccountMethod.FiatAccountDetails(fiatAccountDetails);
        return null;
    }

    /** Method to get Fiat Account limits details <br>
     * Any params required
     * @return Fiat Account limits details as {@link FiatAccountMethod} object,
     * if is not a Fiat Account method will return null value
     * **/
    public FiatAccountMethod getFiatAccountLimit() {
        if (fiatAccountLimit == null)
            fiatAccountLimit = hPayment.getJSONObject("limits");
        if (fiatAccountLimit != null && fiatAccountLimit.getString("type").equals(FIAT_ACCOUNT_TYPE))
            return new FiatAccountMethod(fiatAccountLimit.getString("name"));
        return null;
    }

    /** Method to get Fiat Account picker data details <br>
     * Any params required
     * @return  Fiat Account data details as {@link FiatAccountMethod.FiatAccountPickerData} object,
     * if is not a Fiat Account will return null value
     * **/
    public FiatAccountMethod.FiatAccountPickerData getFiatAccountPickerData(){
        if(fiatAccountPickerData == null)
            fiatAccountPickerData = hPayment.getJSONObject("picker_data");
        if(fiatAccountPickerData != null){
            String symbol = fiatAccountPickerData.getString("type");
            if(symbol.equals(FIAT_ACCOUNT_TYPE))
                return new FiatAccountMethod.FiatAccountPickerData(fiatAccountPickerData.put("symbol", symbol));
            return null;
        }
        return null;
    }

    /** Method to get custom snippet of payment method details
     * @param key: key to get snippet of details
     * @return snippet of details as {@link JSONObject}
     * **/
    public JSONObject getSnippetDetail(String key){
        return hPayment.getJSONObject(key);
    }

    /**
     * The {@code Amount} class is useful to obtain and format an amount for a {@link PaymentMethod}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     * **/
    public static class Amount {

        /**
         * {@code amount} is instance that memorizes amount value
         * **/
        protected double amount;

        /**
         * {@code currency} is instance that memorizes currency value
         * **/
        protected String currency;

        /** Constructor to init a {@link Amount} object
         * @param amount: amount value
         * @param currency: currency value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public Amount(double amount, String currency) {
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
         * Constructor to init a {@link Amount} object
         *
         * @param jAmount: amount details as {@link JSONObject}
         **/
        public Amount(JSONObject jAmount) {
            if (jAmount != null) {
                amount = jAmount.getDouble("minimumPurchaseAmount");
                currency = jAmount.getString("currency");
            } else {
                amount = -1;
                currency = null;
            }
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
