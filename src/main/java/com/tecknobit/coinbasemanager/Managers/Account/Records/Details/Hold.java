package com.tecknobit.coinbasemanager.Managers.Account.Records.Details;

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
