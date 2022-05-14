package com.tecknobit.coinbasemanager.Managers.ExchangePro.Transfers.Records.PaymentMethods;

/**
 * The {@code BankMethod} class is useful to format BankMethod object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class BankMethod extends PayMethod{

    public BankMethod(String name, String type) {
        super(name, type);
    }

    /**
     * The {@code BankPickerData} class is useful to obtain and format BankPickerData object for BankMethod
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods</a>
     * **/
    public static class BankPickerData extends PickerData{

        private String iban;
        private String institutionName;
        private String swift;

        public BankPickerData(String symbol, String iban, String institutionName, String swift) {
            super(symbol);
            this.iban = iban;
            this.institutionName = institutionName;
            this.swift = swift;
        }

        public String getIban() {
            return iban;
        }

        public void setIban(String iban) {
            if(iban == null || iban.isBlank())
                throw new IllegalArgumentException("Iban value cannot be empty or null");
            this.iban = iban;
        }

        public String getInstitutionName() {
            return institutionName;
        }

        public void setInstitutionName(String institutionName) {
            if(institutionName == null || institutionName.isBlank())
                throw new IllegalArgumentException("Institution name value cannot be empty or null");
            this.institutionName = institutionName;
        }

        public String getSwift() {
            return swift;
        }

        public void setSwift(String swift) {
            if(swift == null || swift.isBlank())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            int swiftLength = swift.length();
            if(swiftLength < 8 || swiftLength > 11)
                throw new IllegalArgumentException("Insert a valid swift value (8 or 11 characters)");
            this.swift = swift;
        }

    }

}
