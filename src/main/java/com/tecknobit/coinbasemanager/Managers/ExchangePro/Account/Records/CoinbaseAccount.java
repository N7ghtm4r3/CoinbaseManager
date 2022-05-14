package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records;

import org.json.JSONObject;

/**
 * The {@code CoinbaseAccount} class is useful to format CoinbaseAccount object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseAccount {

    private double balance;
    private boolean availableOnConsumer;
    private final String name;
    private boolean active;
    private String currency;
    private final String id;
    private String type;
    private boolean primary;
    private double holdBalance;
    private String holdCurrency;
    private DepositInformation depositInformation;

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

    public void setBalance(double balance) {
        if(balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        this.balance = balance;
    }

    public boolean isAvailableOnConsumer() {
        return availableOnConsumer;
    }

    public void setAvailableOnConsumer(boolean availableOnConsumer) {
        this.availableOnConsumer = availableOnConsumer;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if(currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        this.type = type;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public double getHoldBalance() {
        return holdBalance;
    }

    public void setHoldBalance(double holdBalance) {
        if(holdBalance < 0)
            throw new IllegalArgumentException("Hold balance value cannot be less than 0");
        this.holdBalance = holdBalance;
    }

    public String getHoldCurrency() {
        return holdCurrency;
    }

    public void setHoldCurrency(String holdCurrency) {
        if(holdCurrency == null || holdCurrency.isEmpty())
            throw new IllegalArgumentException("Hold currency value cannot be empty or null");
        this.holdCurrency = holdCurrency;
    }

    public DepositInformation getDepositInformation() {
        return depositInformation;
    }

    public void setDepositInformation(DepositInformation depositInformation) {
        this.depositInformation = depositInformation;
    }

    /**
     * The {@code DepositInformation} class is useful to obtain and format DepositInformation object for CoinbaseAccount
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts</a>
     * **/
    public static class DepositInformation{

        private String reference;
        private String iban;
        private String accountName;
        private String bankName;
        private String bankAddress;
        private String accountAddress;
        private String swift;
        private String bankCountryCode;
        private String bankCountryName;

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

        public void setReference(String reference) {
            if(reference == null || reference.isEmpty())
                throw new IllegalArgumentException("Reference value cannot be empty or null");
            this.reference = reference;
        }

        public String getIban() {
            return iban;
        }

        public void setIban(String iban) {
            this.iban = iban;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            if(accountName == null || accountName.isEmpty())
                throw new IllegalArgumentException("Account name value cannot be empty or null");
            this.accountName = accountName;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            if(bankName == null || bankName.isEmpty())
                throw new IllegalArgumentException("Bank name value cannot be empty or null");
            this.bankName = bankName;
        }

        public String getBankAddress() {
            return bankAddress;
        }

        public void setBankAddress(String bankAddress) {
            if(bankAddress == null || bankAddress.isEmpty())
                throw new IllegalArgumentException("Bank address value cannot be empty or null");
            this.bankAddress = bankAddress;
        }

        public String getAccountAddress() {
            return accountAddress;
        }

        public void setAccountAddress(String accountAddress) {
            if(accountAddress == null || accountAddress.isEmpty())
                throw new IllegalArgumentException("Account address value cannot be empty or null");
            this.accountAddress = accountAddress;
        }

        public String getSwift() {
            return swift;
        }

        public void setSwift(String swift) {
            if(swift == null || swift.isEmpty())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            this.swift = swift;
        }

        public String getBankCountryCode() {
            return bankCountryCode;
        }

        public void setBankCountryCode(String bankCountryCode) {
            if(bankCountryCode == null || bankCountryCode.isEmpty())
                throw new IllegalArgumentException("Bank country code value cannot be empty or null");
            this.bankCountryCode = bankCountryCode;
        }

        public String getBankCountryName() {
            return bankCountryName;
        }

        public void setBankCountryName(String bankCountryName) {
            if(bankCountryName == null || bankCountryName.isEmpty())
                throw new IllegalArgumentException("Bank country name value cannot be empty or null");
            this.bankCountryName = bankCountryName;
        }

    }

}
