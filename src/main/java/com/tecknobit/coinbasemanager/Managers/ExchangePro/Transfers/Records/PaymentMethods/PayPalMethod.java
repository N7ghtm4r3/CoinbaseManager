package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code PayPalMethod} class is useful to format PayPalMethod object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PayPalMethod extends PayMethod{

    private ArrayList<PayPalDetails> payPalBuysList;
    private ArrayList<PayPalDetails> payPalDepositsList;

    public PayPalMethod(String name, String type, JSONObject jsonPaypal) {
        super(name, type);
        payPalBuysList = assemblePayPalDetailsList(jsonPaypal.getJSONArray("buy"));
        payPalDepositsList = assemblePayPalDetailsList(jsonPaypal.getJSONArray("deposit"));
    }

    /** Method to assemble a PayPalDetails list
     * @param #jsonPaypal: jsonObject obtained by response request
     * @return PayPalDetails list as {@link ArrayList} of {@link PayPalDetails}
     * **/
    private ArrayList<PayPalDetails> assemblePayPalDetailsList(JSONArray jsonPaypal) {
        ArrayList<PayPalDetails> payPalDetails = new ArrayList<>();
        for (int j=0; j < jsonPaypal.length(); j++) {
            JSONObject payPalDetail = jsonPaypal.getJSONObject(j);
            payPalDetails.add(new PayPalDetails(payPalDetail.getInt("period_in_days"),
                    payPalDetail.getString("description"),
                    payPalDetail.getString("label"),
                    payPalDetail
            ));
        }
        return payPalDetails;
    }

    public ArrayList<PayPalDetails> getPayPalBuys() {
        return payPalBuysList;
    }

    public void setPayPalBuysList(ArrayList<PayPalDetails> payPalBuysList) {
        this.payPalBuysList = payPalBuysList;
    }

    public void insertPayPalBuy(PayPalDetails payPalBuy){
        if(!payPalBuysList.contains(payPalBuy))
            payPalBuysList.add(payPalBuy);
    }

    public boolean removePayPalBuy(PayPalDetails payPalBuy){
        return payPalBuysList.remove(payPalBuy);
    }

    public PayPalDetails getPayPalBuy(int index){
        return payPalBuysList.get(index);
    }

    public ArrayList<PayPalDetails> getPayPalDepositsList() {
        return payPalDepositsList;
    }

    public void setPayPalDepositsList(ArrayList<PayPalDetails> payPalDepositsList) {
        this.payPalDepositsList = payPalDepositsList;
    }

    public void insertPayPalDeposit(PayPalDetails payPalDeposit){
        if(!payPalDepositsList.contains(payPalDeposit))
            payPalDepositsList.add(payPalDeposit);
    }

    public boolean removePayPalDeposit(PayPalDetails payPalDeposit){
        return payPalDepositsList.remove(payPalDeposit);
    }

    public PayPalDetails getPayPalDeposit(int index){
        return payPalDepositsList.get(index);
    }

    /**
     * The {@code PayPalDetails} class is useful to obtain and format PayPalDetails object for PayPalMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class PayPalDetails {

        private int periodInDays;
        private String description;
        private String label;
        private PayPalStatusAmount total;
        private PayPalStatusAmount remaining;

        public PayPalDetails(int periodInDays, String description, String label, JSONObject jsonPaypal) {
            this.periodInDays = periodInDays;
            this.description = description;
            this.label = label;
            JSONObject total = jsonPaypal.getJSONObject("total");
            JSONObject remaining = jsonPaypal.getJSONObject("remaining");
            this.total = new PayPalStatusAmount(total.getDouble("amount"), total.getString("currency"));
            this.remaining = new PayPalStatusAmount(remaining.getDouble("amount"), remaining.getString("currency"));
        }

        public int getPeriodInDays() {
            return periodInDays;
        }

        public void setPeriodInDays(int periodInDays) {
            if(periodInDays < 0)
                throw new IllegalArgumentException("Period in days value cannot be less than 0");
            this.periodInDays = periodInDays;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            if(label == null || label.isBlank())
                throw new IllegalArgumentException("Label value cannot be empty or null");
            this.label = label;
        }

        public PayPalStatusAmount getTotal() {
            return total;
        }

        public void setTotal(PayPalStatusAmount total) {
            this.total = total;
        }

        public PayPalStatusAmount getRemaining() {
            return remaining;
        }

        public void setRemaining(PayPalStatusAmount remaining) {
            this.remaining = remaining;
        }

        /**
         * The {@code PayPalStatusAmount} class is useful to obtain and format PayPalStatusAmount object for PayPalDetails
         * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
         * **/
        public static class PayPalStatusAmount {

            private double amount;
            private String currency;

            public PayPalStatusAmount(double amount, String currency) {
                this.amount = amount;
                this.currency = currency;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                if(amount < 0)
                    throw new IllegalArgumentException("Amount value cannot be less than 0");
                this.amount = amount;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                if(currency == null || currency.isBlank())
                    throw new IllegalArgumentException("Currency value cannot be empty or null");
                this.currency = currency;
            }

        }

    }

    /**
     * The {@code PayPalPickerData} class is useful to obtain and format PayPalPickerData object for PayPalMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class PayPalPickerData extends PickerData{

        private boolean payoutOnly;
        private String payPalEmail;
        private String payPalOwner;
        private boolean reauth;

        public PayPalPickerData(String symbol, boolean payoutOnly, String payPalEmail, String payPalOwner, boolean reauth) {
            super(symbol);
            this.payoutOnly = payoutOnly;
            this.payPalEmail = payPalEmail;
            this.payPalOwner = payPalOwner;
            this.reauth = reauth;
        }

        public boolean isPayoutOnly() {
            return payoutOnly;
        }

        public void setPayoutOnly(boolean payoutOnly) {
            this.payoutOnly = payoutOnly;
        }

        public String getPayPalEmail() {
            return payPalEmail;
        }

        public void setPayPalEmail(String payPalEmail) {
            if(payPalEmail == null || payPalEmail.isBlank())
                throw new IllegalArgumentException("PayPal email value cannot be empty or null");
            if(!payPalEmail.contains("@"))
                throw new IllegalArgumentException("PayPal email inserted is not a valid email, check it out");
            this.payPalEmail = payPalEmail;
        }

        public String getPayPalOwner() {
            return payPalOwner;
        }

        public void setPayPalOwner(String payPalOwner) {
            if(payPalOwner == null || payPalOwner.isBlank())
                throw new IllegalArgumentException("PayPal owner value cannot be empty or null");
            this.payPalOwner = payPalOwner;
        }

        public boolean isReauth() {
            return reauth;
        }

        public void setReauth(boolean reauth) {
            this.reauth = reauth;
        }

    }

}
