package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

/**
 * The {@code FiatAccountMethod} class is useful to format FiatAccountMethod object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class FiatAccountMethod extends PayMethod{

    public FiatAccountMethod(String name, String type) {
        super(name, type);
    }

    /**
     * The {@code FiatAccountDetails} class is useful to obtain and format FiatAccountDetails object for FiatAccountMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class FiatAccountDetails {

        private final String id;
        private final String resource;
        private final String resourcePath;

        public FiatAccountDetails(String id, String resource, String resourcePath) {
            this.id = id;
            this.resource = resource;
            this.resourcePath = resourcePath;
        }

        public String getId() {
            return id;
        }

        public String getResource() {
            return resource;
        }

        public String getResourcePath() {
            return resourcePath;
        }

    }

    /**
     * The {@code FiatAccountPickerData} class is useful to obtain and format FiatAccountPickerData object for FiatAccountMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class FiatAccountPickerData extends PickerData{

        private final double amount;
        private final String currency;

        public FiatAccountPickerData(String symbol, double amount, String currency) {
            super(symbol);
            this.amount = amount;
            this.currency = currency;
        }

        public double getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

    }

}
