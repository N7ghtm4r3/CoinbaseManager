package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records.Details;

import org.json.JSONObject;

/**
 * The {@code Hold} class is useful to format Hold object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Hold extends AccountDetails {

    /**
     * {@code ref} is instance that memorizes ref value
     * **/
    private final String ref;

    /** Constructor to init a {@link Hold} object
     * @param createdAt: created at value
     * @param id: identifier value
     * @param amount: amount value
     * @param type: type value
     * @param ref: ref value
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Hold(String createdAt, String id, double amount, String type, String ref) {
        super(createdAt, id, amount, type);
        this.ref = ref;
    }

    /** Constructor to init a {@link Hold} object
     * @param hold: hold details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Hold(JSONObject hold) {
        super(hold);
        this.ref = hold.getString("ref");
    }

    public String getRef() {
        return ref;
    }

    @Override
    public String toString() {
        return "Hold{" +
                "ref='" + ref + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }

}
