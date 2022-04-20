package com.tecknobit.coinbasemanager.Managers.Account.Records.Details;

import org.json.JSONObject;

/**
 * The {@code Transfer} class is useful to format Transfer object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Transfer extends AccountDetails{

    private final String completedAt;
    private final TransferDetails transferDetails;

    public Transfer(String createdAt, String id, double amount, String type, String completedAt, JSONObject details) {
        super(createdAt, id, amount, type);
        this.completedAt = completedAt;
        transferDetails = new TransferDetails(details.getString("coinbase_account_id"),
                details.getString("coinbase_transaction_id"),
                details.getString("coinbase_payment_method_id")
        );
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public TransferDetails getTransferDetails() {
        return transferDetails;
    }

    /**
     * The {@code TransferDetails} class is useful to obtain and format TransferDetails object for Transfer
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers
     * **/
    public static class TransferDetails{

        private final String coinbaseAccountId;
        private final String coinbaseTransactionId;
        private final String coinbasePaymentMethodId;

        public TransferDetails(String coinbaseAccountId, String coinbaseTransactionId, String coinbasePaymentMethodId) {
            this.coinbaseAccountId = coinbaseAccountId;
            this.coinbaseTransactionId = coinbaseTransactionId;
            this.coinbasePaymentMethodId = coinbasePaymentMethodId;
        }

        public String getCoinbaseAccountId() {
            return coinbaseAccountId;
        }

        public String getCoinbaseTransactionId() {
            return coinbaseTransactionId;
        }

        public String getCoinbasePaymentMethodId() {
            return coinbasePaymentMethodId;
        }

    }

}
