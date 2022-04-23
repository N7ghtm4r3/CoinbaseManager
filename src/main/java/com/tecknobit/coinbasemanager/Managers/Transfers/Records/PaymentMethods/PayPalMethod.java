package com.tecknobit.coinbasemanager.Managers.Transfers.Records.PaymentMethods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code PayPalMethod} class is useful to format PayPalMethod object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PayPalMethod extends PayMethod{

    private final ArrayList<PayPalDetails> payPalBuys;
    private final ArrayList<PayPalDetails> payPalDeposits;

    public PayPalMethod(String name, String type, JSONObject jsonPaypal) {
        super(name, type);
        payPalBuys = assemblePayPalDetailsList(jsonPaypal.getJSONArray("buy"));
        payPalDeposits = assemblePayPalDetailsList(jsonPaypal.getJSONArray("deposit"));
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
        return payPalBuys;
    }

    public ArrayList<PayPalDetails> getPayPalDeposits() {
        return payPalDeposits;
    }

    /**
     * The {@code PayPalDetails} class is useful to obtain and format PayPalDetails object for PayPalMethod
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
     * **/
    public static class PayPalDetails {

        private final int periodInDays;
        private final String description;
        private final String label;
        private final PayPalStatusAmount total;
        private final PayPalStatusAmount remaining;

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

        public String getDescription() {
            return description;
        }

        public String getLabel() {
            return label;
        }

        public PayPalStatusAmount getTotal() {
            return total;
        }

        public PayPalStatusAmount getRemaining() {
            return remaining;
        }

        /**
         * The {@code PayPalStatusAmount} class is useful to obtain and format PayPalStatusAmount object for PayPalDetails
         * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
         * **/
        public static class PayPalStatusAmount {

            private final double amount;
            private final String currency;

            public PayPalStatusAmount(double amount, String currency) {
                this.amount = amount;
                this.currency = currency;
            }

            public double getAmount() {
                return amount;
            }

            public String getCurrency() {
                return currency;
            }

        }

    }

    /**
     * The {@code PayPalPickerData} class is useful to obtain and format PayPalPickerData object for PayPalMethod
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
     * **/
    public static class PayPalPickerData extends PickerData{

        private final boolean payoutOnly;
        private final String payPalEmail;
        private final String payPalOwner;
        private final boolean reauth;

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

        public String getPayPalEmail() {
            return payPalEmail;
        }

        public String getPayPalOwner() {
            return payPalOwner;
        }

        public boolean isReauth() {
            return reauth;
        }

    }

}
