package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records.Details;

/**
 * The {@code Hold} class is useful to format Hold object
 * @implNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Hold extends AccountDetails{

    private final String ref;

    public Hold(String createdAt, String id, double amount, String type, String ref) {
        super(createdAt, id, amount, type);
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

}
