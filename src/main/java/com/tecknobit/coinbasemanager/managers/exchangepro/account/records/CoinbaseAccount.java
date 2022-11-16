package com.tecknobit.coinbasemanager.managers.exchangepro.account.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code CoinbaseAccount} class is useful to format CoinbaseAccount object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1</a>
 **/

public class CoinbaseAccount {

    /**
     * {@code balance} is instance that memorizes balance value
     * **/
    private double balance;

    /**
     * {@code availableOnConsumer} is flag that checks available on consumer
     * **/
    private boolean availableOnConsumer;

    /**
     * {@code name} is instance that memorizes name value
     * **/
    private final String name;

    /**
     * {@code active} is flag that checks if the account is active
     * **/
    private boolean active;

    /**
     * {@code currency} is instance that memorizes currency value
     * **/
    private String currency;

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code type} is instance that memorizes type value
     * **/
    private String type;

    /**
     * {@code primary} is flag that checks if the account is primary
     * **/
    private boolean primary;

    /**
     * {@code holdBalance} is instance that memorizes hold balance value
     * **/
    private double holdBalance;

    /**
     * {@code holdCurrency} is instance that memorizes hold currency value
     * **/
    private String holdCurrency;

    /**
     * {@code depositInformation} is instance that memorizes deposit information value
     * **/
    private DepositInformation depositInformation;

    /** Constructor to init a {@link CoinbaseAccount} object
     * @param balance: balance value
     * @param availableOnConsumer: is flag that checks available on consumer
     * @param name: name value
     * @param active: flag that checks if the account is active
     * @param currency: currency value
     * @param id: identifier value
     * @param primary: flag that checks if the account is primary
     * @param holdBalance: hold balance value
     * @param holdCurrency: hold currency value
     * @param jsonDepositInformation: deposit information in JSON format
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public CoinbaseAccount(double balance, boolean availableOnConsumer, String name, boolean active, String currency,
                           String id, String type, boolean primary, double holdBalance, String holdCurrency,
                           JSONObject jsonDepositInformation) {
        if(balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        else
            this.balance = balance;
        this.availableOnConsumer = availableOnConsumer;
        this.name = name;
        this.active = active;
        if(currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        else
            this.currency = currency;
        this.id = id;
        if(type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        else
            this.type = type;
        this.primary = primary;
        if(holdBalance < 0)
            throw new IllegalArgumentException("Hold balance value cannot be less than 0");
        else
            this.holdBalance = holdBalance;
        if(holdCurrency == null || holdCurrency.isEmpty())
            throw new IllegalArgumentException("Hold currency value cannot be empty or null");
        else
            this.holdCurrency = holdCurrency;
        if(jsonDepositInformation != null)
            depositInformation = new DepositInformation(jsonDepositInformation);
        else
            depositInformation = null;
    }

    /** Constructor to init a {@link CoinbaseAccount} object
     * @param coinbaseAccount: Coinbase's coinbaseAccount details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public CoinbaseAccount(JSONObject coinbaseAccount){
        balance = coinbaseAccount.getDouble("balance");
        if(balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        availableOnConsumer = coinbaseAccount.getBoolean("available_on_consumer");
        name = coinbaseAccount.getString("name");
        active = coinbaseAccount.getBoolean("active");
        currency = coinbaseAccount.getString("currency");
        if(currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        id = coinbaseAccount.getString("id");
        type = coinbaseAccount.getString("type");
        if(type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        primary = coinbaseAccount.getBoolean("primary");
        holdBalance = coinbaseAccount.getDouble("hold_balance");
        if(holdBalance < 0)
            throw new IllegalArgumentException("Hold balance value cannot be less than 0");
        holdCurrency = coinbaseAccount.getString("hold_currency");
        if(holdCurrency == null || holdCurrency.isEmpty())
            throw new IllegalArgumentException("Hold currency value cannot be empty or null");
        JSONObject depositInfo = JsonHelper.getJSONObject(coinbaseAccount, "sepa_deposit_information");
        if(depositInfo != null)
            depositInformation = new DepositInformation(depositInfo);
        else
            depositInformation = null;
    }

    public double getBalance() {
        return balance;
    }

    /** Method to set {@link #balance}
     * @param balance: balance value
     * @throws IllegalArgumentException when balance value is less than 0
     * **/
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

    /** Method to set {@link #currency}
     * @param currency: currency value
     * @throws IllegalArgumentException when currency value is null or empty
     * **/
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

    /** Method to set {@link #type}
     * @param type: type value
     * @throws IllegalArgumentException when type value is null or empty
     * **/
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

    /** Method to get {@link #holdBalance} instance
     * @param decimals: number of digits to round final value
     * @return {@link #holdBalance} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getHoldBalance(int decimals) {
        return roundValue(holdBalance, decimals);
    }

    /** Method to set {@link #holdBalance}
     * @param holdBalance: hold balance value
     * @throws IllegalArgumentException when hold balance value is less than 0
     * **/
    public void setHoldBalance(double holdBalance) {
        if(holdBalance < 0)
            throw new IllegalArgumentException("Hold balance value cannot be less than 0");
        this.holdBalance = holdBalance;
    }

    public String getHoldCurrency() {
        return holdCurrency;
    }

    /** Method to set {@link #holdCurrency}
     * @param holdCurrency: hold currency value
     * @throws IllegalArgumentException when hold currency value is null or empty
     * **/
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

    @Override
    public String toString() {
        return "CoinbaseAccount{" +
                "balance=" + balance +
                ", availableOnConsumer=" + availableOnConsumer +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", currency='" + currency + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", primary=" + primary +
                ", holdBalance=" + holdBalance +
                ", holdCurrency='" + holdCurrency + '\'' +
                ", depositInformation=" + depositInformation.toString() +
                '}';
    }

    /**
     * The {@code DepositInformation} class is useful to obtain and format DepositInformation object for CoinbaseAccount
     * @author N7ghtm4r3 - Tecknobit
     * **/
    public static class DepositInformation {

        /**
         * {@code reference} is instance that memorizes reference value
         * **/
        private String reference;

        /**
         * {@code iban} is instance that memorizes iban value
         * **/
        private String iban;

        /**
         * {@code accountName} is instance that memorizes account name value
         * **/
        private String accountName;

        /**
         * {@code bankName} is instance that memorizes bank name value
         * **/
        private String bankName;

        /**
         * {@code bankAddress} is instance that memorizes bank address value
         * **/
        private String bankAddress;

        /**
         * {@code accountAddress} is instance that memorizes account address value
         * **/
        private String accountAddress;

        /**
         * {@code swift} is instance that memorizes swift value
         * **/
        private String swift;

        /**
         * {@code bankCountryCode} is instance that memorizes bank country code value
         * **/
        private String bankCountryCode;

        /**
         * {@code bankCountryName} is instance that memorizes bank country name value
         * **/
        private String bankCountryName;

        /** Constructor to init a {@link DepositInformation} object
         * @param reference: reference value
         * @param iban: iban value
         * @param accountName: account value
         * @param bankName: bank name value
         * @param bankAddress: bank address value
         * @param accountAddress: account address value
         * @param swift: swift value
         * @param bankCountryCode: bank country code value
         * @param bankCountryName: bank country name value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public DepositInformation(String reference, String iban, String accountName, String bankName, String bankAddress,
                                  String accountAddress, String swift, String bankCountryCode, String bankCountryName) {
            if(reference == null || reference.isEmpty())
                throw new IllegalArgumentException("Reference value cannot be empty or null");
            else
                this.reference = reference;
            if(iban == null || iban.isEmpty())
                throw new IllegalArgumentException("Iban value cannot be empty or null");
            else
                this.iban = iban;
            if(accountName == null || accountName.isEmpty())
                throw new IllegalArgumentException("Account name value cannot be empty or null");
            else
                this.accountName = accountName;
            if(bankName == null || bankName.isEmpty())
                throw new IllegalArgumentException("Bank name value cannot be empty or null");
            else
                this.bankName = bankName;
            if(bankAddress == null || bankAddress.isEmpty())
                throw new IllegalArgumentException("Bank address value cannot be empty or null");
            else
                this.bankAddress = bankAddress;
            if(accountAddress == null || accountAddress.isEmpty())
                throw new IllegalArgumentException("Account address value cannot be empty or null");
            else
                this.accountAddress = accountAddress;
            if(swift == null || swift.isEmpty())
                throw new IllegalArgumentException("Swift value cannot be empty or null");
            int swiftLength = swift.length();
            if(swiftLength < 8 || swiftLength > 11)
                throw new IllegalArgumentException("Insert a valid swift value (8 or 11 characters)");
            this.swift = swift;
            if(bankCountryCode == null || bankCountryCode.isEmpty())
                throw new IllegalArgumentException("Bank country code value cannot be empty or null");
            else
                this.bankCountryCode = bankCountryCode;
            if(bankCountryName == null || bankCountryName.isEmpty())
                throw new IllegalArgumentException("Bank country name value cannot be empty or null");
            else
                this.bankCountryName = bankCountryName;
        }

        /** Constructor to init a {@link DepositInformation} object
         * @param depositInformation: deposit information as {@link JSONObject}
         * **/
        public DepositInformation(JSONObject depositInformation) {
            if(depositInformation != null) {
                JsonHelper depositHInformation = new JsonHelper(depositInformation);
                this.reference = depositHInformation.getString("reference");
                this.iban = depositHInformation.getString("iban");
                this.accountName = depositHInformation.getString("account_name");
                this.bankName = depositHInformation.getString("bank_name");
                this.bankAddress = depositHInformation.getString("bank_address");
                this.accountAddress = depositHInformation.getString("account_address");
                this.swift = depositHInformation.getString("swift");
                JSONObject bankCountry = depositHInformation.getJSONObject("bank_country");
                this.bankCountryCode = bankCountry.getString("code");
                this.bankCountryName = bankCountry.getString("name");
            }
        }

        public String getReference() {
            return reference;
        }

        /** Method to set {@link #reference}
         * @param reference: reference value
         * @throws IllegalArgumentException when reference value is null or empty
         * **/
        public void setReference(String reference) {
            if(reference == null || reference.isEmpty())
                throw new IllegalArgumentException("Reference value cannot be empty or null");
            this.reference = reference;
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

        public String getAccountName() {
            return accountName;
        }

        /** Method to set {@link #accountName}
         * @param accountName: account name value
         * @throws IllegalArgumentException when account name value is null or empty
         * **/
        public void setAccountName(String accountName) {
            if(accountName == null || accountName.isEmpty())
                throw new IllegalArgumentException("Account name value cannot be empty or null");
            this.accountName = accountName;
        }

        public String getBankName() {
            return bankName;
        }

        /** Method to set {@link #bankName}
         * @param bankName: bank name value
         * @throws IllegalArgumentException when bank name value is null or empty
         * **/
        public void setBankName(String bankName) {
            if(bankName == null || bankName.isEmpty())
                throw new IllegalArgumentException("Bank name value cannot be empty or null");
            this.bankName = bankName;
        }

        public String getBankAddress() {
            return bankAddress;
        }

        /** Method to set {@link #bankAddress}
         * @param bankAddress: bank address value
         * @throws IllegalArgumentException when bank address value is null or empty
         * **/
        public void setBankAddress(String bankAddress) {
            if(bankAddress == null || bankAddress.isEmpty())
                throw new IllegalArgumentException("Bank address value cannot be empty or null");
            this.bankAddress = bankAddress;
        }

        public String getAccountAddress() {
            return accountAddress;
        }

        /** Method to set {@link #accountAddress}
         * @param accountAddress: account address value
         * @throws IllegalArgumentException when account address value is null or empty
         * **/
        public void setAccountAddress(String accountAddress) {
            if(accountAddress == null || accountAddress.isEmpty())
                throw new IllegalArgumentException("Account address value cannot be empty or null");
            this.accountAddress = accountAddress;
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

        public String getBankCountryCode() {
            return bankCountryCode;
        }

        /** Method to set {@link #bankCountryCode}
         * @param bankCountryCode: bank country code value
         * @throws IllegalArgumentException when bank country code value is null or empty
         * **/
        public void setBankCountryCode(String bankCountryCode) {
            if(bankCountryCode == null || bankCountryCode.isEmpty())
                throw new IllegalArgumentException("Bank country code value cannot be empty or null");
            this.bankCountryCode = bankCountryCode;
        }

        public String getBankCountryName() {
            return bankCountryName;
        }

        /** Method to set {@link #bankCountryName}
         * @param bankCountryName: bank country name value
         * @throws IllegalArgumentException when bank country name value is null or empty
         * **/
        public void setBankCountryName(String bankCountryName) {
            if(bankCountryName == null || bankCountryName.isEmpty())
                throw new IllegalArgumentException("Bank country name value cannot be empty or null");
            this.bankCountryName = bankCountryName;
        }

        @Override
        public String toString() {
            return "DepositInformation{" +
                    "reference='" + reference + '\'' +
                    ", iban='" + iban + '\'' +
                    ", accountName='" + accountName + '\'' +
                    ", bankName='" + bankName + '\'' +
                    ", bankAddress='" + bankAddress + '\'' +
                    ", accountAddress='" + accountAddress + '\'' +
                    ", swift='" + swift + '\'' +
                    ", bankCountryCode='" + bankCountryCode + '\'' +
                    ", bankCountryName='" + bankCountryName + '\'' +
                    '}';
        }

    }

}
