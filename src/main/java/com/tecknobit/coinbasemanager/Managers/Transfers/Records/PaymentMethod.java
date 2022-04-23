package com.tecknobit.coinbasemanager.Managers.Transfers.Records;

import com.tecknobit.coinbasemanager.Helpers.JSONParserHelper;
import org.json.JSONObject;

public class PaymentMethod {

    private final String id;
    private final String type;
    private final String name;
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

    public PaymentMethod(String id, String type, String name, String currency, boolean primaryBuy, boolean primarySell,
                         boolean instantBuy, boolean instantSell, String createdAt, String updatedAt, String resource,
                         String resourcePath, boolean allowBuy, boolean allowSell, boolean allowDeposit, boolean allowWithdraw,
                         boolean verified, JSONObject jsonPayment) {
        this.id = id;
        this.type = type;
        this.name = name;
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
        jsonParserHelper = new JSONParserHelper(jsonPayment);
        this.holdBusinessDays = (int) jsonParserHelper.getNumberDetailValue("hold_business_days");
        this.holdDays = (int) jsonParserHelper.getNumberDetailValue("hold_days");
        minimumPurchaseAmount = new MinimumPurchaseAmount(jsonParserHelper.getJSONObject("minimum_purchase_amount"));
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
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

    public JSONObject getLimits(){
        return jsonParserHelper.getJSONObject("limits");
    }

    public JSONObject getFiatAccount(){
        return jsonParserHelper.getJSONObject("fiat_account");
    }

    public JSONObject getPickerData(){
        return jsonParserHelper.getJSONObject("picker_data");
    }

    public JSONObject getSnippetDetail(String key){
        return jsonParserHelper.getJSONObject(key);
    }

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
