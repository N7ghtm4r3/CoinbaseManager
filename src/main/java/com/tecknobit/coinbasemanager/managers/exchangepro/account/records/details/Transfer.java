package com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Transfer} class is useful to format Transfer object
 * @apiNote see the official documentation at:
 * <ul>
 *       <li>
 *           <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1">
 *               Get a single account's transfers</a>
 *       </li>
 *       <li>
 *           <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1">
 *               Get all transfers</a>
 *       </li>
 * </ul>
 * @author N7ghtm4r3 - Tecknobit
 * @see AccountDetails
 * **/
public class Transfer extends AccountDetails {

    /**
     * {@code completedAt} is instance that memorizes completed at value
     **/
    private final String completedAt;

    /**
     * {@code transferDetails} is instance that memorizes transfer details value
     **/
    private final TransferDetails transferDetails;

    /**
     * Constructor to init a {@link Transfer} custom object
     *
     * @param createdAt:   created at value
     * @param id:          identifier value
     * @param amount:      amount value
     * @param type:        type value
     * @param completedAt: completed at value
     * @param details:     transfer details value in JSON format
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Transfer(String createdAt, String id, double amount, String type, String completedAt, JSONObject details) {
        super(createdAt, id, amount, type);
        this.completedAt = completedAt;
        transferDetails = new TransferDetails(details.getString("coinbase_account_id"),
                details.getString("coinbase_transaction_id"),
                details.getString("coinbase_payment_id")
        );
    }

    /**
     * Constructor to init a {@link Transfer} custom object
     *
     * @param transfer: transfer details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Transfer(JSONObject transfer) {
        super(transfer);
        completedAt = transfer.getString("created_at");
        transferDetails = new TransferDetails(transfer);
    }

    /**
     * Method to assemble a transfers list
     *
     * @param transfersResponse : transfers list response to format
     * @param format            :                 return type formatter -> {@link ReturnFormat}
     * @return transfers list response as {@code "format"} defines
     **/
    @Returner
    public static <T> T returnTransfersList(String transfersResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(transfersResponse);
            case LIBRARY_OBJECT:
                ArrayList<Transfer> transfers = new ArrayList<>();
                JSONArray jTransfers = new JSONArray(transfersResponse);
                for (int j = 0; j < jTransfers.length(); j++)
                    transfers.add(new Transfer(jTransfers.getJSONObject(j)));
                return (T) transfers;
            default:
                return (T) transfersResponse;
        }
    }

    /**
     * Method to get {@link #completedAt} instance <br>
     * Any params required
     *
     * @return {@link #completedAt} instance as {@link String}
     **/
    public String getCompletedAt() {
        return completedAt;
    }

    /**
     * Method to get {@link #completedAt} timestamp <br>
     * Any params required
     *
     * @return {@link #completedAt} timestamp as long
     **/
    public long getCompletedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(completedAt);
    }

    /**
     * Method to get {@link #transferDetails} instance <br>
     * Any params required
     *
     * @return {@link #transferDetails} instance as {@link TransferDetails}
     **/
    public TransferDetails getTransferDetails() {
        return transferDetails;
    }

    /**
     * {@code TransferType} list of transfer type available
     **/
    public enum TransferType {

        /**
         * {@code "deposit"} transfer type
         **/
        deposit,

        /**
         * {@code "withdraw"} transfer type
         **/
        withdraw,

    }

    /**
     * The {@code TransferDetails} class is useful to obtain and format TransferDetails object for Transfer
     *
     * @author N7ghtm4r3 - Tecknobit
     **/
    public static class TransferDetails {

        /**
         * {@code coinbaseAccountId} is instance that memorizes {@code "Coinbase"}'s account identifier value
         * **/
        private final String coinbaseAccountId;

        /**
         * {@code coinbaseTransactionId} is instance that memorizes {@code "Coinbase"}'s transaction identifier value
         * **/
        private final String coinbaseTransactionId;

        /**
         * {@code coinbasePaymentMethodId} is instance that memorizes {@code "Coinbase"}'s payment method identifier value
         * **/
        private final String coinbasePaymentMethodId;

        /**
         * Constructor to init a {@link Transfer} custom object
         *
         * @param coinbaseAccountId:       {@code "Coinbase"}'s account identifier value
         * @param coinbaseTransactionId:   {@code "Coinbase"}'s transaction identifier value
         * @param coinbasePaymentMethodId: {@code "Coinbase"}'s payment method identifier value
         **/
        public TransferDetails(String coinbaseAccountId, String coinbaseTransactionId, String coinbasePaymentMethodId) {
            this.coinbaseAccountId = coinbaseAccountId;
            this.coinbaseTransactionId = coinbaseTransactionId;
            this.coinbasePaymentMethodId = coinbasePaymentMethodId;
        }

        /**
         * Constructor to init a {@link TransferDetails} custom object
         *
         * @param transferDetails: transfer details as {@link JSONObject}
         **/
        public TransferDetails(JSONObject transferDetails) {
            this(transferDetails.getString("coinbase_account_id"), transferDetails.getString("coinbase_transaction_id"),
                    transferDetails.getString("coinbase_payment_id"));
        }

        /**
         * Method to get {@link #coinbaseAccountId} instance <br>
         * Any params required
         *
         * @return {@link #coinbaseAccountId} instance as {@link String}
         **/
        public String getCoinbaseAccountId() {
            return coinbaseAccountId;
        }

        /**
         * Method to get {@link #coinbaseTransactionId} instance <br>
         * Any params required
         *
         * @return {@link #coinbaseTransactionId} instance as {@link String}
         **/
        public String getCoinbaseTransactionId() {
            return coinbaseTransactionId;
        }

        /**
         * Method to get {@link #coinbasePaymentMethodId} instance <br>
         * Any params required
         *
         * @return {@link #coinbasePaymentMethodId} instance as {@link String}
         **/
        public String getCoinbasePaymentMethodId() {
            return coinbasePaymentMethodId;
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

}
