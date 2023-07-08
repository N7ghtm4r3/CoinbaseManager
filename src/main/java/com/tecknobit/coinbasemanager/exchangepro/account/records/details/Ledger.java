package com.tecknobit.coinbasemanager.exchangepro.account.records.details;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Ledger} class is useful to format Ledger object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger">
 * Get a single account's ledger</a>
 * @see AccountDetails
 */
public class Ledger extends AccountDetails {

    /**
     * {@code balance} is instance that memorizes balance value
     */
    private final double balance;

    /**
     * {@code details} is instance that memorizes details value
     */
    private final Details details;

    /**
     * Constructor to init a {@link Ledger} custom object
     *
     * @param createdAt: created at value
     * @param id:        identifier value
     * @param amount:    amount value
     * @param type:      type value
     * @param balance:   ref value
     * @param details:   ledger details in JSO format
     * @throws IllegalArgumentException if parameters range is not respected
     */
    public Ledger(String createdAt, String id, double amount, String type, double balance, JSONObject details) {
        super(createdAt, id, amount, type);
        this.balance = balance;
        this.details = new Details(details.getString("to"),
                details.getString("from"),
                details.getString("profile_transfer_id")
        );
    }

    /**
     * Constructor to init a {@link Ledger} custom object
     *
     * @param ledger: ledger details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     */
    public Ledger(JSONObject ledger) {
        super(ledger);
        balance = ledger.getDouble("balance");
        details = new Details(ledger);
    }

    /**
     * Method to get {@link #balance} instance <br>
     * No-any params required
     *
     * @return {@link #balance} instance as double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Method to get {@link #balance} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #balance} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getBalance(int decimals) {
        return roundValue(balance, decimals);
    }

    /**
     * Method to get {@link #details} instance <br>
     * No-any params required
     *
     * @return {@link #details} instance as {@link Details}
     */
    public Details getDetails() {
        return details;
    }

    /**
     * The {@code Details} class is useful to obtain and format Details object for ledger
     *
     * @author N7ghtm4r3 - Tecknobit
     */
    public static class Details {

        /**
         * {@code to} is instance that memorizes to value
         */
        private final String to;

        /**
         * {@code from} is instance that memorizes from value
         */
        private final String from;

        /**
         * {@code profileTransferId} is instance that memorizes profile transfer identifier value
         */
        private final String profileTransferId;

        /** Constructor to init a {@link Details} custom object
         * @param to: to at value
         * @param from: from value
         * @param profileTransferId: profile transfer identifier value
         * @throws IllegalArgumentException if parameters range is not respected
         * */
        public Details(String to, String from, String profileTransferId) {
            this.to = to;
            this.from = from;
            this.profileTransferId = profileTransferId;
        }

        /**
         * Constructor to init a {@link Details} custom object
         *
         * @param details: details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         */
        public Details(JSONObject details) {
            this(details.getString("to"), details.getString("from"),
                    details.getString("profile_transfer_id"));
        }

        /**
         * Method to get {@link #to} instance <br>
         * No-any params required
         *
         * @return {@link #to} instance as {@link String}
         */
        public String getTo() {
            return to;
        }

        /**
         * Method to get {@link #from} instance <br>
         * No-any params required
         *
         * @return {@link #from} instance as {@link String}
         */
        public String getFrom() {
            return from;
        }

        /**
         * Method to get {@link #profileTransferId} instance <br>
         * No-any params required
         *
         * @return {@link #profileTransferId} instance as {@link String}
         */
        public String getProfileTransferId() {
            return profileTransferId;
        }

        /**
         * Returns a string representation of the object <br>
         * No-any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

}
