package com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods;

import org.json.JSONObject;

/**
 * The {@code BankMethod} class is useful to format a bank method
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
 * Get all payment methods</a>
 * @see PayMethod
 **/
public class BankMethod extends PayMethod {

    /**
     * Constructor to init a {@link BankMethod} object
     *
     * @param name: pay method name
     **/
    public BankMethod(String name) {
        super(name, BANK_TYPE);
    }

    /**
     * The {@code BankPickerData} class is useful to obtain and format a picker data for {@link BankMethod}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     **/
    public static class BankPickerData extends PickerData {

        /**
         * {@code iban} is instance that memorizes iban value
         **/
        private String iban;

        /**
         * {@code institutionName} is instance that memorizes institution name value
         **/
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
            if (swift == null || swift.isEmpty())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            int swiftLength = swift.length();
            if (swiftLength < 8 || swiftLength > 11)
                throw new IllegalArgumentException("Insert a valid swift value (8 or 11 characters)");
            this.swift = swift;
        }

        /**
         * Constructor to init {@link BankPickerData} object
         *
         * @param bankPicker: bank picker details as {@link JSONObject}
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public BankPickerData(JSONObject bankPicker) {
            this(bankPicker.getString("symbol"), bankPicker.getString("iban"),
                    bankPicker.getString("institution_name"), bankPicker.getString("swift"));
        }

        /**
         * Method to get {@link #iban} instance <br>
         * Any params required
         *
         * @return {@link #iban} instance as {@link String}
         **/
        public String getIban() {
            return iban;
        }

        /**
         * Method to set {@link #iban}
         *
         * @param iban: iban value
         * @throws IllegalArgumentException when iban value is null or empty
         **/
        public void setIban(String iban) {
            if (iban == null || iban.isEmpty())
                throw new IllegalArgumentException("Iban value cannot be empty or null");
            this.iban = iban;
        }

        /**
         * Method to get {@link #institutionName} instance <br>
         * Any params required
         *
         * @return {@link #institutionName} instance as {@link String}
         **/
        public String getInstitutionName() {
            return institutionName;
        }

        /**
         * Method to set {@link #institutionName}
         *
         * @param institutionName: institution name value
         * @throws IllegalArgumentException when institution name value is null or empty
         **/
        public void setInstitutionName(String institutionName) {
            if (institutionName == null || institutionName.isEmpty())
                throw new IllegalArgumentException("Institution name value cannot be empty or null");
            this.institutionName = institutionName;
        }

        /**
         * Method to get {@link #swift} instance <br>
         * Any params required
         *
         * @return {@link #swift} instance as {@link String}
         **/
        public String getSwift() {
            return swift;
        }

        /**
         * Method to set {@link #swift}
         *
         * @param swift: swift value
         * @throws IllegalArgumentException when swift is null, empty or invalid value
         **/
        public void setSwift(String swift) {
            if (swift == null || swift.isEmpty())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            int swiftLength = swift.length();
            if (swiftLength < 8 || swiftLength > 11)
                throw new IllegalArgumentException("Insert a valid swift value (8 or 11 characters)");
            this.swift = swift;
        }

    }

}
