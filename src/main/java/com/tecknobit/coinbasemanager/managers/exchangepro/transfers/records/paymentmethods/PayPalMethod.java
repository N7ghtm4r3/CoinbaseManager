package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods.PaymentMethod.Amount;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static org.apache.commons.validator.routines.EmailValidator.getInstance;

/**
 * The {@code PayPalMethod} class is useful to format a {@code "PayPal"} method
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
 * Get all payment methods</a>
 * @see PayMethod
 **/
public class PayPalMethod extends PayMethod {

    /**
     * {@code payPalBuysList} is instance that memorizes list of {@link PayPalDetails} for buys
     **/
    private ArrayList<PayPalDetails> payPalBuysList;

    /**
     * {@code payPalDepositsList} is instance that memorizes list of {@link PayPalDetails} for deposits
     **/
    private ArrayList<PayPalDetails> payPalDepositsList;

    /**
     * Constructor to init a {@link PayMethod} custom object
     *
     * @param name                : pay method name
     * @param payPalBuysList:     list of {@link PayPalDetails} for buys
     * @param payPalDepositsList: list of {@link PayPalDetails} for deposits
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public PayPalMethod(String name, ArrayList<PayPalDetails> payPalBuysList, ArrayList<PayPalDetails> payPalDepositsList) {
        super(name, PAYPAL_TYPE);
        this.payPalBuysList = payPalBuysList;
        this.payPalDepositsList = payPalDepositsList;
    }

    /**
     * Constructor to init a {@link PayPalMethod} custom object
     *
     * @param payment : payment details as {@link JSONObject}
     **/
    public PayPalMethod(JSONObject payment) {
        super(payment);
        payPalBuysList = assemblePayPalDetailsList(payment.getJSONArray("buy"));
        payPalDepositsList = assemblePayPalDetailsList(payment.getJSONArray("deposit"));
    }

    /**
     * Method to assemble a PayPalDetails list
     *
     * @param jsonPaypal: jsonObject obtained by response request
     * @return PayPalDetails list as {@link ArrayList} of {@link PayPalDetails}
     **/
    @Returner
    private ArrayList<PayPalDetails> assemblePayPalDetailsList(JSONArray jsonPaypal) {
        ArrayList<PayPalDetails> payPalDetails = new ArrayList<>();
        for (int j = 0; j < jsonPaypal.length(); j++)
            payPalDetails.add(new PayPalDetails(jsonPaypal.getJSONObject(j)));
        return payPalDetails;
    }

    /**
     * Method to get {@link #payPalBuysList} instance <br>
     * Any params required
     *
     * @return {@link #payPalBuysList} instance as {@link ArrayList} of {@link PayPalDetails}
     **/
    public ArrayList<PayPalDetails> getPayPalBuys() {
        return payPalBuysList;
    }

    /**
     * Method to set {@link #payPalBuysList} instance <br>
     *
     * @param payPalBuysList: buys list to set
     **/
    public void setPayPalBuysList(ArrayList<PayPalDetails> payPalBuysList) {
        this.payPalBuysList = payPalBuysList;
    }

    /**
     * Method to add buy warning to {@link #payPalBuysList}
     *
     * @param payPalBuy: buy to insert
     * @apiNote the {@code "payPalBuy"} will be inserted only if is not already presents in the list
     **/
    public void insertPayPalBuy(PayPalDetails payPalBuy) {
        if (!payPalBuysList.contains(payPalBuy))
            payPalBuysList.add(payPalBuy);
    }

    /**
     * Method to remove a buy from {@link #payPalBuysList}
     *
     * @param payPalBuy: buy to remove
     * @return whether the {@code "payPalBuy"} has been removed
     **/
    public boolean removePayPalBuy(PayPalDetails payPalBuy) {
        return payPalBuysList.remove(payPalBuy);
    }

    /**
     * Method to get an buy from {@link #payPalBuysList}
     *
     * @param index: index of the buy to get
     * @return buy as {@link PayPalDetails}
     **/
    public PayPalDetails getPayPalBuy(int index) {
        return payPalBuysList.get(index);
    }

    /**
     * Method to get {@link #payPalDepositsList} instance <br>
     * Any params required
     *
     * @return {@link #payPalDepositsList} instance as {@link ArrayList} of {@link PayPalDetails}
     **/
    public ArrayList<PayPalDetails> getPayPalDepositsList() {
        return payPalDepositsList;
    }

    /**
     * Method to set {@link #payPalDepositsList} instance <br>
     *
     * @param payPalDepositsList: deposits list to set
     **/
    public void setPayPalDepositsList(ArrayList<PayPalDetails> payPalDepositsList) {
        this.payPalDepositsList = payPalDepositsList;
    }

    /**
     * Method to add buy deposit to {@link #payPalDepositsList}
     *
     * @param payPalDeposit: deposit insert
     * @apiNote the {@code "deposit"} will be inserted only if is not already presents in the list
     **/
    public void insertPayPalDeposit(PayPalDetails payPalDeposit) {
        if (!payPalDepositsList.contains(payPalDeposit))
            payPalDepositsList.add(payPalDeposit);
    }

    /**
     * Method to remove a deposit from {@link #payPalDepositsList}
     *
     * @param payPalDeposit: deposit to remove
     * @return whether the {@code "deposit"} has been removed
     **/
    public boolean removePayPalDeposit(PayPalDetails payPalDeposit) {
        return payPalDepositsList.remove(payPalDeposit);
    }

    /**
     * Method to get a deposit from {@link #payPalDepositsList}
     *
     * @param index: index of the deposit to get
     * @return deposit as {@link PayPalDetails}
     **/
    public PayPalDetails getPayPalDeposit(int index) {
        return payPalDepositsList.get(index);
    }


    /**
     * The {@code PayPalDetails} class is useful to obtain and format the {@code "PayPal"} details for the
     * {@link PayPalMethod} method
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     **/
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
         **/
        private Amount total;

        /**
         * {@code remaining} is instance that remaining total value
         **/
        private Amount remaining;

        /**
         * Constructor to init a {@link PayPalDetails} custom object
         *
         * @param periodInDays: period in days value
         * @param description:  description value
         * @param label:        value
         * @param total:        total value
         * @param remaining:    remaining total value
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public PayPalDetails(int periodInDays, String description, String label, Amount total, Amount remaining) {
            if (periodInDays < 0)
                throw new IllegalArgumentException("Period in days value cannot be less than 0");
            else
                this.periodInDays = periodInDays;
            this.description = description;
            if (label == null || label.isEmpty())
                throw new IllegalArgumentException("Label value cannot be empty or null");
            else
                this.label = label;
            this.total = total;
            this.remaining = remaining;
        }

        /**
         * Constructor to init a {@link PayPalDetails} custom object
         *
         * @param payPalDetails: PayPal's details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public PayPalDetails(JSONObject payPalDetails) {
            periodInDays = payPalDetails.getInt("period_in_days");
            if (periodInDays < 0)
                throw new IllegalArgumentException("Period in days value cannot be less than 0");
            this.description = payPalDetails.getString("description");
            this.label = payPalDetails.getString("label");
            if (label == null || label.isEmpty())
                throw new IllegalArgumentException("Label value cannot be empty or null");
            JSONObject total = payPalDetails.getJSONObject("total");
            this.total = new Amount(total.getDouble("amount"), total.getString("currency"));
            JSONObject remaining = payPalDetails.getJSONObject("remaining");
            this.remaining = new Amount(remaining.getDouble("amount"), remaining.getString("currency"));
        }

        /**
         * Method to get {@link #periodInDays} instance <br>
         * Any params required
         *
         * @return {@link #periodInDays} instance as int
         **/
        public int getPeriodInDays() {
            return periodInDays;
        }

        /**
         * Method to set {@link #periodInDays}
         *
         * @param periodInDays: period in days value
         * @throws IllegalArgumentException when period in days value is less than 0
         **/
        public void setPeriodInDays(int periodInDays) {
            if (periodInDays < 0)
                throw new IllegalArgumentException("Period in days value cannot be less than 0");
            this.periodInDays = periodInDays;
        }

        /**
         * Method to get {@link #description} instance <br>
         * Any params required
         *
         * @return {@link #description} instance as {@link String}
         **/
        public String getDescription() {
            return description;
        }

        /**
         * Method to set {@link #description}
         *
         * @param description: description value
         **/
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Method to get {@link #label} instance <br>
         * Any params required
         *
         * @return {@link #label} instance as {@link String}
         **/
        public String getLabel() {
            return label;
        }

        /**
         * Method to set {@link #label}
         *
         * @param label: label value
         * @throws IllegalArgumentException when label value is null or empty
         **/
        public void setLabel(String label) {
            if (label == null || label.isEmpty())
                throw new IllegalArgumentException("Label value cannot be empty or null");
            this.label = label;
        }

        /**
         * Method to get {@link #total} instance <br>
         * Any params required
         *
         * @return {@link #total} instance as {@link Amount}
         **/
        public Amount getTotal() {
            return total;
        }

        /**
         * Method to set {@link #total}
         *
         * @param total: total value
         **/
        public void setTotal(Amount total) {
            this.total = total;
        }

        /**
         * Method to get {@link #remaining} instance <br>
         * Any params required
         *
         * @return {@link #remaining} instance as {@link Amount}
         **/
        public Amount getRemaining() {
            return remaining;
        }

        /**
         * Method to set {@link #remaining}
         *
         * @param remaining: remaining value
         **/
        public void setRemaining(Amount remaining) {
            this.remaining = remaining;
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
     * The {@code PayPalPickerData} class is useful to obtain and format a picker data for a {@link PayPalMethod}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     **/
    public static class PayPalPickerData extends PickerData {

        /**
         * {@code payoutOnly} is instance is flag for check out payout only
         **/
        private boolean payoutOnly;

        /**
         * {@code payPalEmail} is instance is PayPal's email value
         **/
        private String payPalEmail;

        /**
         * {@code payPalOwner} is instance is PayPal's owner value
         * **/
        private String payPalOwner;

        /**
         * {@code reauth} is instance is flag for reauth
         * **/
        private boolean reauth;

        /**
         * Constructor to init a {@link PayPalPickerData} custom object
         *
         * @param symbol:      symbol value
         * @param payoutOnly:  flag for check out payout only
         * @param payPalEmail: PayPal's email value
         * @param payPalOwner: PayPal's owner value
         * @param reauth:      flag for reauth
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public PayPalPickerData(String symbol, boolean payoutOnly, String payPalEmail, String payPalOwner, boolean reauth) {
            super(symbol);
            this.payoutOnly = payoutOnly;
            this.payPalEmail = payPalEmail;
            this.payPalOwner = payPalOwner;
            this.reauth = reauth;
        }

        /**
         * Constructor to init a {@link PayPalPickerData} custom object
         *
         * @param paypalPicker: PayPal's picker details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public PayPalPickerData(JSONObject paypalPicker) {
            this(paypalPicker.getString("symbol"), paypalPicker.getBoolean("payout_only"),
                    paypalPicker.getString("paypal_email"), paypalPicker.getString("paypal_owner"),
                    paypalPicker.getBoolean("reauth"));
        }

        /**
         * Method to get {@link #payoutOnly} instance <br>
         * Any params required
         *
         * @return {@link #payoutOnly} instance as boolean
         **/
        public boolean isPayoutOnly() {
            return payoutOnly;
        }

        /**
         * Method to set {@link #payoutOnly}
         *
         * @param payoutOnly: payout only value
         **/
        public void setPayoutOnly(boolean payoutOnly) {
            this.payoutOnly = payoutOnly;
        }

        /**
         * Method to get {@link #payPalEmail} instance <br>
         * Any params required
         *
         * @return {@link #payPalEmail} instance as {@link String}
         **/
        public String getPayPalEmail() {
            return payPalEmail;
        }

        /**
         * Method to set {@link #payPalEmail}
         *
         * @param payPalEmail: PayPal's email value
         * @throws IllegalArgumentException when PayPal's email value is null, empty or non a valid email
         **/
        public void setPayPalEmail(String payPalEmail) {
            if (payPalEmail == null || payPalEmail.isEmpty())
                throw new IllegalArgumentException("PayPal's email value cannot be empty or null");
            if (!getInstance().isValid(payPalEmail))
                throw new IllegalArgumentException("PayPal's email inserted is not a valid email, check it out");
            this.payPalEmail = payPalEmail;
        }

        /**
         * Method to get {@link #payPalOwner} instance <br>
         * Any params required
         *
         * @return {@link #payPalOwner} instance as {@link String}
         **/
        public String getPayPalOwner() {
            return payPalOwner;
        }

        /**
         * Method to set {@link #payPalOwner}
         *
         * @param payPalOwner: PayPal's owner value
         * @throws IllegalArgumentException when PayPal's owner value is null or empty
         **/
        public void setPayPalOwner(String payPalOwner) {
            if (payPalOwner == null || payPalOwner.isEmpty())
                throw new IllegalArgumentException("PayPal's owner value cannot be empty or null");
            this.payPalOwner = payPalOwner;
        }

        /**
         * Method to get {@link #reauth} instance <br>
         * Any params required
         *
         * @return {@link #reauth} instance as boolean
         **/
        public boolean isReauth() {
            return reauth;
        }

        /**
         * Method to set {@link #reauth}
         *
         * @param reauth: reauth value
         **/
        public void setReauth(boolean reauth) {
            this.reauth = reauth;
        }

    }

}
