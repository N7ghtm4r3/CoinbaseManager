package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records;

import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods.PaymentMethod.Amount;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code TransferAction} class is useful to format general TransferAction object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount">
 * Deposit from {@co account</ a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod">
 * Deposit from payment method</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount">
 * Withdraw to {@code "Coinbase"} account</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto">
 * Withdraw to crypto address</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod">
 * Withdraw to payment method</a>
 * </li>
 * </ul>
 * @author N7ghtm4r3 - Tecknobit
 * @see Amount
 * **/
public class TransferAction extends Amount {

    /**
     * {@code id} is instance that memorizes identifier value
     **/
    private final String id;

    /**
     * {@code payoutAt} is instance that memorizes payout at value
     **/
    private final String payoutAt;

    /**
     * {@code fee} is instance that memorizes fee value
     **/
    private final double fee;

    /**
     * {@code subTotal} is instance that memorizes subtotal value
     **/
    private final double subTotal;

    /**
     * Constructor to init a {@link TransferAction} custom object
     *
     * @param id:       identifier value
     * @param amount:   amount value
     * @param currency: currency value
     * @param payoutAt: payout at value
     * @param fee:      fee value
     * @param subTotal: subtotal value
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public TransferAction(String id, double amount, String currency, String payoutAt, double fee, double subTotal) {
        super(amount, currency);
        this.id = id;
        this.payoutAt = payoutAt;
        this.fee = fee;
        this.subTotal = subTotal;
    }

    /** Constructor to init a {@link TransferAction} custom object
     * @param transfer: transfer details as {@link JSONArray}
     * **/
    public TransferAction(JSONObject transfer) {
        super(transfer);
        id = transfer.getString("id");
        payoutAt = transfer.getString("payout_at");
        fee = transfer.getDouble("fee");
        subTotal = transfer.getDouble("subtotal");
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #payoutAt} instance <br>
     * No-any params required
     *
     * @return {@link #payoutAt} instance as {@link String}
     **/
    public String getPayoutAt() {
        return payoutAt;
    }

    /**
     * Method to get {@link #fee} instance <br>
     * No-any params required
     *
     * @return {@link #fee} instance as double
     **/
    public double getFee() {
        return fee;
    }

    /**
     * Method to get {@link #fee} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #amount} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getFee(int decimals) {
        return roundValue(fee, decimals);
    }

    /**
     * Method to get {@link #subTotal} instance <br>
     * No-any params required
     *
     * @return {@link #subTotal} instance as double
     **/
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * Method to get {@link #subTotal} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #subTotal} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getSubTotal(int decimals) {
        return roundValue(subTotal, decimals);
    }

}
