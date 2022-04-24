package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

import com.tecknobit.coinbasemanager.Helpers.JSONParserHelper;
import org.json.JSONObject;

/**
 * The {@code PayPalMethod} class is useful to format PaymentMethod object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PaymentMethod extends PayMethod{

    public static final String PAYPAL_TYPE = "paypal";
    public static final String BANK_TYPE = "bank";
    public static final String FIAT_ACCOUNT_TYPE = "fiat_account";
    private final String id;
    private final String currency;
    private final boolean primaryBuy;
    private final boolean primarySell;
    private final boolean instantBuy;
    private final boolean instantSell;
    private final String createdAt;
    private final String updatedAt;
    private final String resource;
    private final String resourcePath;
    private final boolean allowBuy;
    private final boolean allowSell;
    private final boolean allowDeposit;
    private final boolean allowWithdraw;
    private final boolean verified;
    private final int holdBusinessDays;
    private final int holdDays;
    private final JSONParserHelper jsonParserHelper;
    private final MinimumPurchaseAmount minimumPurchaseAmount;
    private JSONObject payPalLimits;
    private JSONObject bankLimits;
    private JSONObject payPalPickerData;
    private JSONObject bankPickerData;
    private JSONObject fiatAccountLimit;
    private JSONObject fiatAccountDetails;
    private JSONObject fiatAccountPickerData;

    public PaymentMethod(String id, String type, String name, String currency, boolean primaryBuy, boolean primarySell,
                         boolean instantBuy, boolean instantSell, String createdAt, String updatedAt, String resource,
                         String resourcePath, boolean allowBuy, boolean allowSell, boolean allowDeposit, boolean allowWithdraw,
                         boolean verified, JSONObject jsonPayment) {
        super(name, type);
        jsonParserHelper = new JSONParserHelper(jsonPayment);
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
        this.holdBusinessDays = (int) jsonParserHelper.getNumberDetailValue("hold_business_days");
        this.holdDays = (int) jsonParserHelper.getNumberDetailValue("hold_days");
        minimumPurchaseAmount = new MinimumPurchaseAmount(jsonParserHelper.getJSONObject("minimum_purchase_amount"));
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

    public MinimumPurchaseAmount getMinimumPurchaseAmount() {
        return minimumPurchaseAmount;
    }

    /** Method to get PayPal limits details
     * any params required
     * @return PayPal limits details as {@link PayPalMethod} object, if is not a PayPal method will return null value
     * **/
    public PayPalMethod getPayPalLimits(){
        if(payPalLimits == null)
            payPalLimits = jsonParserHelper.getJSONObject("limits");
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
            payPalPickerData = jsonParserHelper.getJSONObject("picker_data");
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
            bankLimits = jsonParserHelper.getJSONObject("limits");
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
            bankPickerData = jsonParserHelper.getJSONObject("picker_data");
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
            fiatAccountDetails = jsonParserHelper.getJSONObject(FIAT_ACCOUNT_TYPE);
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
            fiatAccountLimit = jsonParserHelper.getJSONObject("limits");
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
            fiatAccountPickerData = jsonParserHelper.getJSONObject("picker_data");
        if(fiatAccountPickerData != null){
            String symbol = fiatAccountPickerData.getString("type");
            if(symbol.equals(FIAT_ACCOUNT_TYPE)){
                return new FiatAccountMethod.FiatAccountPickerData(symbol,
                        fiatAccountPickerData.getDouble("amount"),
                        fiatAccountDetails.getString("currency")
                );
            }
            return null;
        }
        return null;
    }

    /** Method to get custom snippet of payment method details
     * @param #key: key to get snippet of details
     * @return snippet of details as {@link JSONObject}
     * **/
    public JSONObject getSnippetDetail(String key){
        return jsonParserHelper.getJSONObject(key);
    }

    /**
     * The {@code MinimumPurchaseAmount} class is useful to obtain and format MinimumPurchaseAmount object for PaymentMethod
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
     * **/
    public static class MinimumPurchaseAmount{

        private final double amount;
        private final String currency;

        public MinimumPurchaseAmount(double amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public MinimumPurchaseAmount(JSONObject jsonDetails){
            if(jsonDetails != null){
                amount = jsonDetails.getDouble("amount");
                currency = jsonDetails.getString("currency");
            }else{
                amount = -1;
                currency = null;
            }
        }

        public double getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

    }

}
