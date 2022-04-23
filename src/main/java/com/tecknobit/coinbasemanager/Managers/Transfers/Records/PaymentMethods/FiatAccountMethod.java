package com.tecknobit.coinbasemanager.Managers.Transfers.Records.PaymentMethods;

public class FiatAccountMethod extends PayMethod{

    public FiatAccountMethod(String name, String type) {
        super(name, type);
    }

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
