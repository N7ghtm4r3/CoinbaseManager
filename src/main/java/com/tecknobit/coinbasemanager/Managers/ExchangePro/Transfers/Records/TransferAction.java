package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records;

/**
 * The {@code TransferAction} class is useful to format general TransferAction object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class TransferAction {

    private final String id;
    private final double amount;
    private final String currency;
    private final String payoutAt;
    private final double fee;
    private final double subTotal;

    public TransferAction(String id, double amount, String currency, String payoutAt, double fee, double subTotal) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.payoutAt = payoutAt;
        this.fee = fee;
        this.subTotal = subTotal;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPayoutAt() {
        return payoutAt;
    }

    public double getFee() {
        return fee;
    }

    public double getSubTotal() {
        return subTotal;
    }

}
