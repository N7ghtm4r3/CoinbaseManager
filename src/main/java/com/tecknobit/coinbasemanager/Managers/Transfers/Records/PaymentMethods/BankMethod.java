package com.tecknobit.coinbasemanager.Managers.Transfers.Records.PaymentMethods;

public class BankMethod extends PayMethod{

    public BankMethod(String name, String type) {
        super(name, type);
    }

    public static class BankPickerData extends PickerData{

        private final String iban;
        private final String institutionName;
        private final String swift;

        public BankPickerData(String symbol, String iban, String institutionName, String swift) {
            super(symbol);
            this.iban = iban;
            this.institutionName = institutionName;
            this.swift = swift;
        }

        public String getIban() {
            return iban;
        }

        public String getInstitutionName() {
            return institutionName;
        }

        public String getSwift() {
            return swift;
        }

    }

}
