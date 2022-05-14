package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records;

import org.json.JSONObject;

/**
 * The {@code CoinbaseAccount} class is useful to format CoinbaseAccount object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseAccount {

    private final double balance;
    private final boolean availableOnConsumer;
    private final String name;
    private final boolean active;
    private final String currency;
    private final String id;
    private final String type;
    private final boolean primary;
    private final double holdBalance;
    private final String holdCurrency;
    private final DepositInformation depositInformation;

    public CoinbaseAccount(double balance, boolean availableOnConsumer, String name, boolean active, String currency,
                           String id, String type, boolean primary, double holdBalance, String holdCurrency,
                           JSONObject jsonDepositInformation) {
        this.balance = balance;
        this.availableOnConsumer = availableOnConsumer;
        this.name = name;
        this.active = active;
        this.currency = currency;
        this.id = id;
        this.type = type;
        this.primary = primary;
        this.holdBalance = holdBalance;
        this.holdCurrency = holdCurrency;
        if(jsonDepositInformation != null)
            depositInformation = new DepositInformation(jsonDepositInformation);
        else
            depositInformation = null;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isAvailableOnConsumer() {
        return availableOnConsumer;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public String getCurrency() {
        return currency;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isPrimary() {
        return primary;
    }

    public double getHoldBalance() {
        return holdBalance;
    }

    public String getHoldCurrency() {
        return holdCurrency;
    }

    public DepositInformation getDepositInformation() {
        return depositInformation;
    }

    /**
     * The {@code DepositInformation} class is useful to obtain and format DepositInformation object for CoinbaseAccount
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts</a>
     * **/
    public static class DepositInformation{

        private final String reference;
        private final String iban;
        private final String accountName;
        private final String bankName;
        private final String bankAddress;
        private final String accountAddress;
        private final String swift;
        private final String bankCountryCode;
        private final String bankCountryName;

        public DepositInformation(String reference, String iban, String accountName, String bankName, String bankAddress,
                                  String accountAddress, String swift, String bankCountryCode, String bankCountryName) {
            this.reference = reference;
            this.iban = iban;
            this.accountName = accountName;
            this.bankName = bankName;
            this.bankAddress = bankAddress;
            this.accountAddress = accountAddress;
            this.swift = swift;
            this.bankCountryCode = bankCountryCode;
            this.bankCountryName = bankCountryName;
        }

        public DepositInformation(JSONObject depositInformation) {
            this.reference = depositInformation.getString("reference");
            this.iban = depositInformation.getString("iban");
            this.accountName = depositInformation.getString("account_name");
            this.bankName = depositInformation.getString("bank_name");
            this.bankAddress = depositInformation.getString("bank_address");
            this.accountAddress = depositInformation.getString("account_address");
            this.swift = depositInformation.getString("swift");
            JSONObject bankCountry = depositInformation.getJSONObject("bank_country");
            this.bankCountryCode = bankCountry.getString("code");
            this.bankCountryName = bankCountry.getString("name");
        }

        public String getReference() {
            return reference;
        }

        public String getIban() {
            return iban;
        }

        public String getAccountName() {
            return accountName;
        }

        public String getBankName() {
            return bankName;
        }

        public String getBankAddress() {
            return bankAddress;
        }

        public String getAccountAddress() {
            return accountAddress;
        }

        public String getSwift() {
            return swift;
        }

        public String getBankCountryCode() {
            return bankCountryCode;
        }

        public String getBankCountryName() {
            return bankCountryName;
        }

    }

}
