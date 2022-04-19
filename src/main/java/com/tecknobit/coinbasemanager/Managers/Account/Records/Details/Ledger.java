package com.tecknobit.coinbasemanager.Managers.Account.Records.Details;

import org.json.JSONObject;

public class Ledger extends AccountDetails{

    private final double balance;
    private final Details details;

    public Ledger(String createdAt, String id, double amount, String type, double balance, JSONObject details) {
        super(createdAt, id, amount, type);
        this.balance = balance;
        this.details = new Details(details.getString("to"),
                details.getString("from"),
                details.getString("profile_transfer_id"));
    }

    public double getBalance() {
        return balance;
    }

    public Details getDetails() {
        return details;
    }

    public static class Details{

        private final String to;
        private final String from;
        private final String profileTransferId;

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
