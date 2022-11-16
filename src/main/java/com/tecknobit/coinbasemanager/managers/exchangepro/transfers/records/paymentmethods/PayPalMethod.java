package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods;

import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods.PaymentMethod.Amount;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static org.apache.commons.validator.routines.EmailValidator.getInstance;

/**
 * The {@code PayPalMethod} class is useful to format PayPalMethod object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
 **/

public class PayPalMethod extends PayMethod {

    /**
     * {@code payPalBuysList} is instance that memorizes list of {@link PayPalDetails} for buys
     * **/
    private ArrayList<PayPalDetails> payPalBuysList;

    /**
     * {@code payPalDepositsList} is instance that memorizes list of {@link PayPalDetails} for deposits
     * **/
    private ArrayList<PayPalDetails> payPalDepositsList;

    /** Constructor to init a {@link PayPalMethod} object
     * @param name: pay method name
     * @param type: pay method type
     * @param jsonPaypal: paypal details in JSON format
     * **/
    public PayPalMethod(String name, String type, JSONObject jsonPaypal) {
        super(name, type);
        payPalBuysList = assemblePayPalDetailsList(jsonPaypal.getJSONArray("buy"));
        payPalDepositsList = assemblePayPalDetailsList(jsonPaypal.getJSONArray("deposit"));
    }

    /** Method to assemble a PayPalDetails list
     * @param jsonPaypal: jsonObject obtained by response request
     * @return PayPalDetails list as {@link ArrayList} of {@link PayPalDetails}
     * **/
    private ArrayList<PayPalDetails> assemblePayPalDetailsList(JSONArray jsonPaypal) {
        ArrayList<PayPalDetails> payPalDetails = new ArrayList<>();
        for (int j = 0; j < jsonPaypal.length(); j++)
            payPalDetails.add(new PayPalDetails(jsonPaypal.getJSONObject(j)));
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

    @Override
    public String toString() {
        return "PayPalMethod{" +
                "payPalBuysList=" + payPalBuysList +
                ", payPalDepositsList=" + payPalDepositsList +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * The {@code PayPalDetails} class is useful to obtain and format PayPalDetails object for PayPalMethod
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
     * **/
    public static class PayPalDetails {

        /**
         * {@code periodInDays} is instance that memorizes periodic in days value
         * **/
        private int periodInDays;

        /**
         * {@code description} is instance that memorizes description value
         * **/
        private String description;

        /**
         * {@code label} is instance that memorizes label value
         * **/
        private String label;

        /**
         * {@code total} is instance that memorizes total value
         * **/
        private Amount total;

        /**
         * {@code remaining} is instance that remaining total value
         * **/
        private Amount remaining;

        /** Constructor to init a {@link PayPalDetails} object
         * @param periodInDays: period in days value
         * @param description: description value
         * @param label: value
         * @param jsonPaypal: paypal details in JSON format
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public PayPalDetails(int periodInDays, String description, String label, JSONObject jsonPaypal) {
            if(periodInDays < 0)
                throw new IllegalArgumentException("Period in days value cannot be less than 0");
            else
                this.periodInDays = periodInDays;
            this.description = description;
            if(label == null || label.isEmpty())
                throw new IllegalArgumentException("Label value cannot be empty or null");
            else
                this.label = label;
            JSONObject total = jsonPaypal.getJSONObject("total");
            this.total = new Amount(total.getDouble("amount"), total.getString("currency"));
            JSONObject remaining = jsonPaypal.getJSONObject("remaining");
            this.remaining = new Amount(remaining.getDouble("amount"), remaining.getString("currency"));
        }

        /** Constructor to init a {@link PayPalDetails} object
         * @param payPalDetails: PayPal's details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public PayPalDetails(JSONObject payPalDetails) {
            periodInDays = payPalDetails.getInt("period_in_days");
            if(periodInDays < 0)
                throw new IllegalArgumentException("Period in days value cannot be less than 0");
            this.description = payPalDetails.getString("description");
            this.label = payPalDetails.getString("label");
            if(label == null || label.isEmpty())
                throw new IllegalArgumentException("Label value cannot be empty or null");
            JSONObject total = payPalDetails.getJSONObject("total");
            this.total = new Amount(total.getDouble("amount"), total.getString("currency"));
            JSONObject remaining = payPalDetails.getJSONObject("remaining");
            this.remaining = new Amount(remaining.getDouble("amount"), remaining.getString("currency"));
        }

        public int getPeriodInDays() {
            return periodInDays;
        }

        /** Method to set {@link #periodInDays}
         * @param periodInDays: period in days value
         * @throws IllegalArgumentException when period in days value is less than 0
         * **/
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

        /** Method to set {@link #label}
         * @param label: label value
         * @throws IllegalArgumentException when label value is null or empty
         * **/
        public void setLabel(String label) {
            if(label == null || label.isEmpty())
                throw new IllegalArgumentException("Label value cannot be empty or null");
            this.label = label;
        }

        public Amount getTotal() {
            return total;
        }

        public void setTotal(Amount total) {
            this.total = total;
        }

        public Amount getRemaining() {
            return remaining;
        }

        public void setRemaining(Amount remaining) {
            this.remaining = remaining;
        }

        @Override
        public String toString() {
            return "PayPalDetails{" +
                    "periodInDays=" + periodInDays +
                    ", description='" + description + '\'' +
                    ", label='" + label + '\'' +
                    ", total=" + total +
                    ", remaining=" + remaining +
                    '}';
        }

    }

    /**
     * The {@code PayPalPickerData} class is useful to obtain and format PayPalPickerData object for PayPalMethod
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
     * **/
    public static class PayPalPickerData extends PickerData{

        /**
         * {@code payoutOnly} is instance is flag for check out payout only
         * **/
        private boolean payoutOnly;

        /**
         * {@code payPalEmail} is instance is PayPal's email value
         * **/
        private String payPalEmail;

        /**
         * {@code payPalOwner} is instance is PayPal's owner value
         * **/
        private String payPalOwner;

        /**
         * {@code reauth} is instance is flag for reauth
         * **/
        private boolean reauth;

        /** Constructor to init a {@link PayPalPickerData} object
         * @param symbol: symbol value
         * @param payoutOnly: flag for check out payout only
         * @param payPalEmail: PayPal's email value
         * @param payPalOwner: PayPal's owner value
         * @param reauth: flag for reauth
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public PayPalPickerData(String symbol, boolean payoutOnly, String payPalEmail, String payPalOwner, boolean reauth) {
            super(symbol);
            this.payoutOnly = payoutOnly;
            this.payPalEmail = payPalEmail;
            this.payPalOwner = payPalOwner;
            this.reauth = reauth;
        }

        /** Constructor to init a {@link PayPalPickerData} object
         * @param symbol: symbol value
         * @param paypalPicker: PayPal's picker details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public PayPalPickerData(String symbol, JSONObject paypalPicker) {
            super(symbol);
            payoutOnly = paypalPicker.getBoolean("payout_only");
            payPalEmail = paypalPicker.getString("paypal_email");
            payPalOwner = paypalPicker.getString("paypal_owner");
            reauth = paypalPicker.getBoolean("reauth");
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

        /** Method to set {@link #payPalEmail}
         * @param payPalEmail: PayPal's email value
         * @throws IllegalArgumentException when PayPal's email value is null, empty or non a valid email
         * **/
        public void setPayPalEmail(String payPalEmail) {
            if(payPalEmail == null || payPalEmail.isEmpty())
                throw new IllegalArgumentException("PayPal's email value cannot be empty or null");
            if(!getInstance().isValid(payPalEmail))
                throw new IllegalArgumentException("PayPal's email inserted is not a valid email, check it out");
            this.payPalEmail = payPalEmail;
        }

        public String getPayPalOwner() {
            return payPalOwner;
        }

        /** Method to set {@link #payPalOwner}
         * @param payPalOwner: PayPal's owner value
         * @throws IllegalArgumentException when PayPal's owner value is null or empty
         * **/
        public void setPayPalOwner(String payPalOwner) {
            if(payPalOwner == null || payPalOwner.isEmpty())
                throw new IllegalArgumentException("PayPal's owner value cannot be empty or null");
            this.payPalOwner = payPalOwner;
        }

        public boolean isReauth() {
            return reauth;
        }

        public void setReauth(boolean reauth) {
            this.reauth = reauth;
        }

        @Override
        public String toString() {
            return "PayPalPickerData{" +
                    "payoutOnly=" + payoutOnly +
                    ", payPalEmail='" + payPalEmail + '\'' +
                    ", payPalOwner='" + payPalOwner + '\'' +
                    ", reauth=" + reauth +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }

    }

}
