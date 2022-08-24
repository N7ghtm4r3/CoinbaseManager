package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records.Details;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Transfer} class is useful to format Transfer object
 * @apiNote see official documentation at:
 <ul>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers</a>
     </li>
 </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Transfer extends AccountDetails {

    /**
     * {@code completedAt} is instance that memorizes completed at value
     * **/
    private final String completedAt;

    /**
     * {@code transferDetails} is instance that memorizes transfer details value
     * **/
    private final TransferDetails transferDetails;

    /** Constructor to init a {@link Transfer} object
     * @param createdAt: created at value
     * @param id: identifier value
     * @param amount: amount value
     * @param type: type value
     * @param completedAt: completed at value
     * @param details: transfer details value in JSON format
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Transfer(String createdAt, String id, double amount, String type, String completedAt, JSONObject details) {
        super(createdAt, id, amount, type);
        this.completedAt = completedAt;
        transferDetails = new TransferDetails(details.getString("coinbase_account_id"),
                details.getString("coinbase_transaction_id"),
                details.getString("coinbase_payment_method_id")
        );
    }

    /** Constructor to init a {@link Transfer} object
     * @param transfer: transfer details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Transfer(JSONObject transfer) {
        super(transfer);
        completedAt = transfer.getString("created_at");
        transferDetails = new TransferDetails(transfer);
    }

    /** Method to assemble a transfer list
     * @param jsonTransfers: jsonArray obtained by response request
     * @return transfer list as {@link ArrayList} of {@link Transfer}
     * **/
    public static ArrayList<Transfer> assembleTransfersList(JSONArray jsonTransfers){
        ArrayList<Transfer> transfers = new ArrayList<>();
        for (int j = 0; j < jsonTransfers.length(); j++)
            transfers.add(new Transfer(jsonTransfers.getJSONObject(j)));
        return transfers;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public TransferDetails getTransferDetails() {
        return transferDetails;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "completedAt='" + completedAt + '\'' +
                ", transferDetails=" + transferDetails.toString() +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * The {@code TransferDetails} class is useful to obtain and format TransferDetails object for Transfer
     * @author N7ghtm4r3 - Tecknobit
     * **/
    public static class TransferDetails {

        /**
         * {@code coinbaseAccountId} is instance that memorizes Coinbase's account identifier value
         * **/
        private final String coinbaseAccountId;

        /**
         * {@code coinbaseTransactionId} is instance that memorizes Coinbase's transaction identifier value
         * **/
        private final String coinbaseTransactionId;

        /**
         * {@code coinbasePaymentMethodId} is instance that memorizes Coinbase's payment method identifier value
         * **/
        private final String coinbasePaymentMethodId;

        /** Constructor to init a {@link Transfer} object
         * @param coinbaseAccountId: Coinbase's account identifier value
         * @param coinbaseTransactionId: Coinbase's transaction identifier value
         * @param coinbasePaymentMethodId: Coinbase's payment method identifier value
         * **/
        public TransferDetails(String coinbaseAccountId, String coinbaseTransactionId, String coinbasePaymentMethodId) {
            this.coinbaseAccountId = coinbaseAccountId;
            this.coinbaseTransactionId = coinbaseTransactionId;
            this.coinbasePaymentMethodId = coinbasePaymentMethodId;
        }

        /** Constructor to init a {@link TransferDetails} object
         * @param transferDetails: transfer details as {@link JSONObject}
         * **/
        public TransferDetails(JSONObject transferDetails) {
            coinbaseAccountId = transferDetails.getString("coinbase_account_id");
            coinbaseTransactionId = transferDetails.getString("coinbase_transaction_id");
            coinbasePaymentMethodId = transferDetails.getString("coinbase_payment_method_id");
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

        @Override
        public String toString() {
            return "TransferDetails{" +
                    "coinbaseAccountId='" + coinbaseAccountId + '\'' +
                    ", coinbaseTransactionId='" + coinbaseTransactionId + '\'' +
                    ", coinbasePaymentMethodId='" + coinbasePaymentMethodId + '\'' +
                    '}';
        }

    }

}
