package com.tecknobit.coinbasemanager.exchangepro.account.records.details;

import org.json.JSONObject;

/**
 * The {@code Hold} class is useful to format Hold object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds">
 * Get a single account's holds</a>
 * @see AccountDetails
 **/
public class Hold extends AccountDetails {

    /**
     * {@code ref} is instance that memorizes ref value
     **/
    private final String ref;

    /**
     * Constructor to init a {@link Hold} custom object
     *
     * @param createdAt: created at value
     * @param id:        identifier value
     * @param amount:    amount value
     * @param type:      type value
     * @param ref:       ref value
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Hold(String createdAt, String id, double amount, String type, String ref) {
        super(createdAt, id, amount, type);
        this.ref = ref;
    }

    /**
     * Constructor to init a {@link Hold} custom object
     *
     * @param hold: hold details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Hold(JSONObject hold) {
        super(hold);
        this.ref = hold.getString("ref");
    }

    /**
     * Method to get {@link #ref} instance <br>
     * No-any params required
     *
     * @return {@link #ref} instance as {@link String}
     **/
    public String getRef() {
        return ref;
    }

}
