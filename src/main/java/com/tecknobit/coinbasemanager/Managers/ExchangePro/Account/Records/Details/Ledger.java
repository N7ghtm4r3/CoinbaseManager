package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records.Details;

import org.json.JSONObject;

/**
 * The {@code Ledger} class is useful to format Ledger object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Ledger extends AccountDetails {

    /**
     * {@code balance} is instance that memorizes balance value
     * **/
    private final double balance;

    /**
     * {@code details} is instance that memorizes details value
     * **/
    private final Details details;

    /** Constructor to init a {@link Ledger} object
     * @param createdAt: created at value
     * @param id: identifier value
     * @param amount: amount value
     * @param type: type value
     * @param balance: ref value
     * @param details: ledger details in JSO format
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Ledger(String createdAt, String id, double amount, String type, double balance, JSONObject details) {
        super(createdAt, id, amount, type);
        this.balance = balance;
        this.details = new Details(details.getString("to"),
                details.getString("from"),
                details.getString("profile_transfer_id")
        );
    }

    public double getBalance() {
        return balance;
    }

    public Details getDetails() {
        return details;
    }

    /**
     * The {@code Details} class is useful to obtain and format Details object for ledger
     * @author N7ghtm4r3 - Tecknobit
     * **/
    public static class Details {

        /**
         * {@code to} is instance that memorizes to value
         * **/
        private final String to;

        /**
         * {@code from} is instance that memorizes from value
         * **/
        private final String from;

        /**
         * {@code profileTransferId} is instance that memorizes profile transfer identifier value
         * **/
        private final String profileTransferId;

        /** Constructor to init a {@link Details} object
         * @param to: to at value
         * @param from: from value
         * @param profileTransferId: profile transfer identifier value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public Details(String to, String from, String profileTransferId) {
            this.to = to;
            this.from = from;
            this.profileTransferId = profileTransferId;
        }

        public String getTo() {
            return to;
        }

        public String getFrom() {
            return from;
        }

        public String getProfileTransferId() {
            return profileTransferId;
        }

    }

}
