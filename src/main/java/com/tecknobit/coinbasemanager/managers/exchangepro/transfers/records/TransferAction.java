package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records;

import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods.PaymentMethod;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code TransferAction} class is useful to format general TransferAction object
 * @apiNote see the official documentation at:
<ul>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1</a>
</li>
</ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class TransferAction extends PaymentMethod.Amount {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code payoutAt} is instance that memorizes payout at value
     * **/
    private final String payoutAt;

    /**
     * {@code fee} is instance that memorizes fee value
     * **/
    private final double fee;

    /**
     * {@code subTotal} is instance that memorizes subtotal value
     * **/
    private final double subTotal;

    /** Constructor to init a {@link TransferAction} object
     * @param id: identifier value
     * @param amount: amount value
     * @param currency: currency value
     * @param payoutAt: payout at value
     * @param fee: fee value
     * @param subTotal: subtotal value
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public TransferAction(String id, double amount, String currency, String payoutAt, double fee, double subTotal) {
        super(amount, currency);
        this.id = id;
        this.payoutAt = payoutAt;
        this.fee = fee;
        this.subTotal = subTotal;
    }

    /** Constructor to init a {@link TransferAction} object
     * @param transfer: transfer details as {@link JSONArray}
     * **/
    public TransferAction(JSONObject transfer) {
        super(transfer);
        id = transfer.getString("id");
        payoutAt = transfer.getString("payout_at");
        fee = transfer.getDouble("fee");
        subTotal = transfer.getDouble("subtotal");
    }

    public String getId() {
        return id;
    }

    public String getPayoutAt() {
        return payoutAt;
    }

    public double getFee() {
        return fee;
    }

    /** Method to get {@link #fee} instance
     * @param decimals: number of digits to round final value
     * @return {@link #amount} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getFee(int decimals) {
        return roundValue(fee, decimals);
    }

    public double getSubTotal() {
        return subTotal;
    }

    /** Method to get {@link #subTotal} instance
     * @param decimals: number of digits to round final value
     * @return {@link #subTotal} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getSubTotal(int decimals) {
        return roundValue(subTotal, decimals);
    }

    @Override
    public String toString() {
        return "TransferAction{" +
                "id='" + id + '\'' +
                ", payoutAt='" + payoutAt + '\'' +
                ", fee=" + fee +
                ", subTotal=" + subTotal +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

}
