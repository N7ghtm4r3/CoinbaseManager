package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

/**
 * The {@code PayMethod} class is useful to format general PayMethod object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PayMethod {

    public static final String PAYPAL_TYPE = "paypal";
    public static final String BANK_TYPE = "bank";
    public static final String FIAT_ACCOUNT_TYPE = "fiat_account";

    private String name;
    private String type;

    public PayMethod(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type == null || (!type.equals(FIAT_ACCOUNT_TYPE) && !type.equals(PAYPAL_TYPE) && !type.equals(BANK_TYPE)))
            throw new IllegalArgumentException("Type value cannot be null and must be fiat_account, bank or paypal type");
        this.type = type;
    }

    public static class PickerData{

        private final String symbol;

        public PickerData(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

}
