package com.tecknobit.coinbasemanager.Managers.ExchangePro.Conversions.Records;

/**
 * The {@code CurrencyConversion} class is useful to format CurrencyConversion object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CurrencyConversion {

    private final String id;
    private final double amount;
    private final String fromAccountId;
    private final String toAccountId;
    private final String from;
    private final String to;

    public CurrencyConversion(String id, double amount, String fromAccountId, String toAccountId, String from, String to) {
        this.id = id;
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.from = from;
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

}
