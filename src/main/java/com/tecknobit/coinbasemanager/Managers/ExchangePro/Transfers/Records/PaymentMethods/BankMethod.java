package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

/**
 * The {@code BankMethod} class is useful to format BankMethod object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class BankMethod extends PayMethod{

    public BankMethod(String name, String type) {
        super(name, type);
    }

    /**
     * The {@code BankPickerData} class is useful to obtain and format BankPickerData object for BankMethod
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods
     * **/
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
