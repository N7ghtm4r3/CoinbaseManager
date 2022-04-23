package com.tecknobit.coinbasemanager.Managers.Account.Records.Details;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Transfer} class is useful to format Transfer object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer
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

    /** Method to assemble a transfer list
     * @param #jsonTransfers: jsonArray obtained by response request
     * @return transfer list as {@link ArrayList} of {@link Transfer}
     * **/
    public static ArrayList<Transfer> assembleTransfersList(JSONArray jsonTransfers){
        ArrayList<Transfer> transfers = new ArrayList<>();
        for (int j=0; j < jsonTransfers.length(); j++)
            transfers.add(assembleTransferObject(jsonTransfers.getJSONObject(j)));
        return transfers;
    }

    /** Method to assemble a transfer object
     * @param #jsonTransfer: jsonObject obtained by response request
     * @return transfer as {@link Transfer} object
     * **/
    public static Transfer assembleTransferObject(JSONObject jsonTransfer){
        return new Transfer(jsonTransfer.getString("created_at"),
                jsonTransfer.getString("id"),
                jsonTransfer.getDouble("amount"),
                jsonTransfer.getString("type"),
                jsonTransfer.getString("completed_at"),
                jsonTransfer
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
