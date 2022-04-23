package com.tecknobit.coinbasemanager.Managers.Transfers.Records.PaymentMethods;

public class PayMethod {

    private final String name;
    private final String type;

    public PayMethod(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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
