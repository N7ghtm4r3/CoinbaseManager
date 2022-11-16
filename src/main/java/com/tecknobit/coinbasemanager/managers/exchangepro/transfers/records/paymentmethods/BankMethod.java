package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods;

import org.json.JSONObject;

/**
 * The {@code BankMethod} class is useful to format BankMethod object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
 **/

public class BankMethod extends PayMethod{

    /** Constructor to init a {@link BankMethod} object
     * @param name: pay method name
     * @param type: pay method type
     * **/
    public BankMethod(String name, String type) {
        super(name, type);
    }

    /**
     * The {@code BankPickerData} class is useful to obtain and format BankPickerData object for BankMethod
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
     * **/
    public static class BankPickerData extends PickerData{

        /**
         * {@code iban} is instance that memorizes iban value
         * **/
        private String iban;

        /**
         * {@code institutionName} is instance that memorizes institution name value
         * **/
        private String institutionName;

        /**
         * {@code swift} is instance that memorizes swift name value
         * **/
        private String swift;

        /** Constructor to init {@link BankPickerData} object
         * @param symbol: symbol value
         * @param iban: iban value
         * @param institutionName: institution name value
         * @param swift: swift value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public BankPickerData(String symbol, String iban, String institutionName, String swift) {
            super(symbol);
            if(iban == null || iban.isEmpty())
                throw new IllegalArgumentException("Iban value cannot be empty or null");
            else
                this.iban = iban;
            if(institutionName == null || institutionName.isEmpty())
                throw new IllegalArgumentException("Institution name value cannot be empty or null");
            else
                this.institutionName = institutionName;
            if(swift == null || swift.isEmpty())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            int swiftLength = swift.length();
            if(swiftLength < 8 || swiftLength > 11)
                throw new IllegalArgumentException("Insert a valid swift value (8 or 11 characters)");
            this.swift = swift;
        }

        /** Constructor to init {@link BankPickerData} object
         * @param symbol: symbol value
         * @param bankPicker: bank picker details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public BankPickerData(String symbol, JSONObject bankPicker) {
            super(symbol);
            iban = bankPicker.getString("iban");
            if(iban == null || iban.isEmpty())
                throw new IllegalArgumentException("Iban value cannot be empty or null");
            institutionName = bankPicker.getString("institution_name");
            if(institutionName == null || institutionName.isEmpty())
                throw new IllegalArgumentException("Institution name value cannot be empty or null");
            swift = bankPicker.getString("swift");
            if(swift == null || swift.isEmpty())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            int swiftLength = swift.length();
            if(swiftLength < 8 || swiftLength > 11)
                throw new IllegalArgumentException("Insert a valid swift value (8 or 11 characters)");
        }

        public String getIban() {
            return iban;
        }

        /** Method to set {@link #iban}
         * @param iban: iban value
         * @throws IllegalArgumentException when iban value is null or empty
         * **/
        public void setIban(String iban) {
            if(iban == null || iban.isEmpty())
                throw new IllegalArgumentException("Iban value cannot be empty or null");
            this.iban = iban;
        }

        public String getInstitutionName() {
            return institutionName;
        }

        /** Method to set {@link #institutionName}
         * @param institutionName: institution name value
         * @throws IllegalArgumentException when institution name value is null or empty
         * **/
        public void setInstitutionName(String institutionName) {
            if(institutionName == null || institutionName.isEmpty())
                throw new IllegalArgumentException("Institution name value cannot be empty or null");
            this.institutionName = institutionName;
        }

        public String getSwift() {
            return swift;
        }

        /** Method to set {@link #swift}
         * @param swift: swift value
         * @throws IllegalArgumentException when swift is null, empty or invalid value
         * **/
        public void setSwift(String swift) {
            if(swift == null || swift.isEmpty())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            int swiftLength = swift.length();
            if(swiftLength < 8 || swiftLength > 11)
                throw new IllegalArgumentException("Insert a valid swift value (8 or 11 characters)");
            this.swift = swift;
        }

        @Override
        public String toString() {
            return "BankPickerData{" +
                    "iban='" + iban + '\'' +
                    ", institutionName='" + institutionName + '\'' +
                    ", swift='" + swift + '\'' +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }

    }

}
