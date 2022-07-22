package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import org.json.JSONObject;

/**
 * The {@code PayPalMethod} class is useful to format PaymentMethod object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PaymentMethod extends PayMethod{

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code currency} is instance that memorizes currency value
     * **/
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
     * {@code jsonHelper} is instance useful to help to format JSON responses API
     * **/
    private final JsonHelper jsonHelper;

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
     * @param jsonPayment: payment details in JSON format
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public PaymentMethod(String id, String type, String name, String currency, boolean primaryBuy, boolean primarySell,
                         boolean instantBuy, boolean instantSell, String createdAt, String updatedAt, String resource,
                         String resourcePath, boolean allowBuy, boolean allowSell, boolean allowDeposit, boolean allowWithdraw,
                         boolean verified, JSONObject jsonPayment) {
        super(name, type);
        jsonHelper = new JsonHelper(jsonPayment);
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
        this.holdBusinessDays = jsonHelper.getInt("hold_business_days");
        this.holdDays = jsonHelper.getInt("hold_days");
        minimumPurchaseAmount = new Amount(jsonHelper.getJSONObject("minimum_purchase_amount"));
    }

    public String getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isPrimaryBuy() {
        return primaryBuy;
    }

    public boolean isPrimarySell() {
        return primarySell;
    }

    public boolean isInstantBuy() {
        return instantBuy;
    }

    public boolean isInstantSell() {
        return instantSell;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getResource() {
        return resource;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public boolean isAllowBuy() {
        return allowBuy;
    }

    public boolean isAllowSell() {
        return allowSell;
    }

    public boolean isAllowDeposit() {
        return allowDeposit;
    }

    public boolean isAllowWithdraw() {
        return allowWithdraw;
    }

    public boolean isVerified() {
        return verified;
    }

    public int getHoldBusinessDays() {
        return holdBusinessDays;
    }

    public int getHoldDays() {
        return holdDays;
    }

    public Amount getMinimumPurchaseAmount() {
        return minimumPurchaseAmount;
    }

    /** Method to get PayPal limits details
     * any params required
     * @return PayPal limits details as {@link PayPalMethod} object, if is not a PayPal method will return null value
     * **/
    public PayPalMethod getPayPalLimits(){
        if(payPalLimits == null)
            payPalLimits = jsonHelper.getJSONObject("limits");
        if(payPalLimits != null) {
            String type = payPalLimits.getString("type");
            if(type.equals(PAYPAL_TYPE))
                return new PayPalMethod(payPalLimits.getString("name"), type, payPalLimits);
            return null;
        }
        return null;
    }

    /** Method to get PayPal picker data details
     * any params required
     * @return PayPal picker data details as {@link PayPalMethod.PayPalPickerData} object, if is not a PayPal method will return null value
     * **/
    public PayPalMethod.PayPalPickerData getPayPalPickerData(){
        if(payPalPickerData == null)
            payPalPickerData = jsonHelper.getJSONObject("picker_data");
        if(payPalPickerData != null){
            String symbol = payPalPickerData.getString("symbol");
            if(symbol.equals(PAYPAL_TYPE)){
                return new PayPalMethod.PayPalPickerData(symbol,
                        payPalPickerData.getBoolean("payout_only"),
                        payPalPickerData.getString("paypal_email"),
                        payPalPickerData.getString("paypal_owner"),
                        payPalPickerData.getBoolean("reauth")
                );
            }
            return null;
        }
        return null;
    }

    /** Method to get Bank limits details
     * any params required
     * @return Bank limits details as {@link BankMethod} object, if is not a Bank method will return null value
     * **/
    public BankMethod getBankLimits(){
        if(bankLimits == null)
            bankLimits = jsonHelper.getJSONObject("limits");
        if(bankLimits != null){
            String type = bankLimits.getString("type");
            if(type.equals(BANK_TYPE))
                return new BankMethod(bankLimits.getString("name"), type);
            return null;
        }
        return null;
    }

    /** Method to get Bank picker data details
     * any params required
     * @return Bank picker data details as {@link BankMethod.BankPickerData} object, if is not a Bank method will return null value
     * **/
    public BankMethod.BankPickerData getBankPickerData(){
        if(bankPickerData == null)
            bankPickerData = jsonHelper.getJSONObject("picker_data");
        if(bankPickerData != null){
            String symbol = bankPickerData.getString("symbol");
            if(symbol.equals(BANK_TYPE)){
                return new BankMethod.BankPickerData(symbol,
                        bankPickerData.getString("iban"),
                        bankPickerData.getString("institution_name"),
                        bankPickerData.getString("swift")
                );
            }
            return null;
        }
        return null;
    }

    /** Method to get Fiat Account details
     * any params required
     * @return PayPal picker data details as {@link FiatAccountMethod.FiatAccountDetails} object,
     * if is not a Fiat Account method will return null value
     * **/
    public FiatAccountMethod.FiatAccountDetails getFiatAccountDetails(){
        if(fiatAccountDetails == null)
            fiatAccountDetails = jsonHelper.getJSONObject(FIAT_ACCOUNT_TYPE);
        if(fiatAccountDetails != null){
            return new FiatAccountMethod.FiatAccountDetails(fiatAccountDetails.getString("id"),
                    fiatAccountDetails.getString("resource"),
                    fiatAccountDetails.getString("resource_path")
            );
        }
        return null;
    }

    /** Method to get Fiat Account limits details
     * any params required
     * @return Fiat Account limits details as {@link FiatAccountMethod} object,
     * if is not a Fiat Account method will return null value
     * **/
    public FiatAccountMethod getFiatAccountLimit(){
        if(fiatAccountLimit == null)
            fiatAccountLimit = jsonHelper.getJSONObject("limits");
        if(fiatAccountLimit != null){
            String type = fiatAccountLimit.getString("type");
            if(type.equals(FIAT_ACCOUNT_TYPE))
                return new FiatAccountMethod(fiatAccountLimit.getString("name"), type);
            return null;
        }
        return null;
    }

    /** Method to get Fiat Account picker data details
     * any params required
     * @return  Fiat Account data details as {@link FiatAccountMethod.FiatAccountPickerData} object,
     * if is not a Fiat Account will return null value
     * **/
    public FiatAccountMethod.FiatAccountPickerData getFiatAccountPickerData(){
        if(fiatAccountPickerData == null)
            fiatAccountPickerData = jsonHelper.getJSONObject("picker_data");
        if(fiatAccountPickerData != null){
            String symbol = fiatAccountPickerData.getString("type");
            if(symbol.equals(FIAT_ACCOUNT_TYPE)){
                return new FiatAccountMethod.FiatAccountPickerData(symbol,
                        fiatAccountPickerData.getDouble("minimumPurchaseAmount"),
                        fiatAccountDetails.getString("currency")
                );
            }
            return null;
        }
        return null;
    }

    /** Method to get custom snippet of payment method details
     * @param key: key to get snippet of details
     * @return snippet of details as {@link JSONObject}
     * **/
    public JSONObject getSnippetDetail(String key){
        return jsonHelper.getJSONObject(key);
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", primaryBuy=" + primaryBuy +
                ", primarySell=" + primarySell +
                ", instantBuy=" + instantBuy +
                ", instantSell=" + instantSell +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", resource='" + resource + '\'' +
                ", resourcePath='" + resourcePath + '\'' +
                ", allowBuy=" + allowBuy +
                ", allowSell=" + allowSell +
                ", allowDeposit=" + allowDeposit +
                ", allowWithdraw=" + allowWithdraw +
                ", verified=" + verified +
                ", holdBusinessDays=" + holdBusinessDays +
                ", holdDays=" + holdDays +
                ", jsonHelper=" + jsonHelper +
                ", minimumPurchaseAmount=" + minimumPurchaseAmount.toString() +
                ", payPalLimits=" + payPalLimits +
                ", bankLimits=" + bankLimits +
                ", payPalPickerData=" + payPalPickerData +
                ", bankPickerData=" + bankPickerData +
                ", fiatAccountLimit=" + fiatAccountLimit +
                ", fiatAccountDetails=" + fiatAccountDetails +
                ", fiatAccountPickerData=" + fiatAccountPickerData +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * The {@code Amount} class is useful to obtain and format Amount object for PaymentMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
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
            if(amount < 0)
                throw new IllegalArgumentException("Amount value cannot be less than 0");
            else
                this.amount = amount;
            if(currency == null || currency.isEmpty())
                throw new IllegalArgumentException("Currency value cannot be empty or null");
            else
                this.currency = currency;
        }

        /** Constructor to init a {@link Amount} object
         * @param jsonDetails: amount details in JSON format
         * **/
        public Amount(JSONObject jsonDetails){
            if(jsonDetails != null){
                amount = jsonDetails.getDouble("minimumPurchaseAmount");
                currency = jsonDetails.getString("currency");
            }else{
                amount = -1;
                currency = null;
            }
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
            return "Amount{" +
                    "amount=" + amount +
                    ", currency='" + currency + '\'' +
                    '}';
        }

    }

}
