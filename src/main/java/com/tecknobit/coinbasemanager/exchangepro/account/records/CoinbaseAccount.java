package com.tecknobit.coinbasemanager.exchangepro.account.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONObject;

import static com.tecknobit.apimanager.formatters.JsonHelper.getJSONObject;
import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code CoinbaseAccount} class is useful to format CoinbaseAccount object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">
 * Get all {@code "Coinbase"} wallets</a>
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
     * {@code primary} is flag that checks if the account is the primary
     **/
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

    /**
     * Constructor to init a {@link CoinbaseAccount} custom object
     *
     * @param balance:             balance value
     * @param availableOnConsumer: is flag that checks available on consumer
     * @param name:                name value
     * @param active:              flag that checks if the account is active
     * @param currency:            currency value
     * @param id:                  identifier value
     * @param primary:             flag that checks if the account is the primary
     * @param holdBalance:         hold balance value
     * @param holdCurrency:        hold currency value
     * @param depositInformation:  deposit information
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public CoinbaseAccount(double balance, boolean availableOnConsumer, String name, boolean active, String currency,
                           String id, String type, boolean primary, double holdBalance, String holdCurrency,
                           DepositInformation depositInformation) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        else
            this.balance = balance;
        this.availableOnConsumer = availableOnConsumer;
        this.name = name;
        this.active = active;
        if (currency == null || currency.isEmpty())
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
        this.depositInformation = depositInformation;
    }

    /**
     * Constructor to init a {@link CoinbaseAccount} custom object
     *
     * @param coinbaseAccount: {@code "Coinbase"}'s coinbaseAccount details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public CoinbaseAccount(JSONObject coinbaseAccount) {
        this(coinbaseAccount.getDouble("balance"), coinbaseAccount.getBoolean("available_on_consumer"),
                coinbaseAccount.getString("name"), coinbaseAccount.getBoolean("active"),
                coinbaseAccount.getString("currency"), coinbaseAccount.getString("id"),
                coinbaseAccount.getString("type"), coinbaseAccount.getBoolean("primary"),
                coinbaseAccount.getDouble("hold_balance"), coinbaseAccount.getString("hold_currency"),
                new DepositInformation(getJSONObject(coinbaseAccount, "sepa_deposit_information", new JSONObject())));
    }

    /**
     * Method to get {@link #balance} instance <br>
     * No-any params required
     *
     * @return {@link #balance} instance as double
     **/
    public double getBalance() {
        return balance;
    }

    /**
     * Method to set {@link #balance}
     *
     * @param balance: balance value
     * @throws IllegalArgumentException when balance value is less than 0
     **/
    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance value cannot be less than 0");
        this.balance = balance;
    }

    /**
     * Method to get {@link #availableOnConsumer} instance <br>
     * No-any params required
     *
     * @return {@link #availableOnConsumer} instance as boolean
     **/
    public boolean isAvailableOnConsumer() {
        return availableOnConsumer;
    }

    /**
     * Method to set {@link #active}
     *
     * @param availableOnConsumer: flag that checks available on consumer
     **/
    public void setAvailableOnConsumer(boolean availableOnConsumer) {
        this.availableOnConsumer = availableOnConsumer;
    }

    /**
     * Method to get {@link #name} instance <br>
     * No-any params required
     *
     * @return {@link #name} instance as {@link String}
     **/
    public String getName() {
        return name;
    }

    /**
     * Method to get {@link #active} instance <br>
     * No-any params required
     *
     * @return {@link #active} instance as boolean
     **/
    public boolean isActive() {
        return active;
    }

    /**
     * Method to set {@link #active}
     *
     * @param active: flag that checks if the account is active
     **/
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method to get {@link #currency} instance <br>
     * No-any params required
     *
     * @return {@link #currency} instance as {@link String}
     **/
    public String getCurrency() {
        return currency;
    }

    /**
     * Method to set {@link #currency}
     *
     * @param currency: currency value
     * @throws IllegalArgumentException when currency value is null or empty
     **/
    public void setCurrency(String currency) {
        if (currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency value cannot be empty or null");
        this.currency = currency;
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link String}
     **/
    public String getType() {
        return type;
    }

    /**
     * Method to set {@link #type}
     *
     * @param type: type value
     * @throws IllegalArgumentException when type value is null or empty
     **/
    public void setType(String type) {
        if (type == null || type.isEmpty())
            throw new IllegalArgumentException("Type value cannot be empty or null");
        this.type = type;
    }

    /**
     * Method to get {@link #primary} instance <br>
     * No-any params required
     *
     * @return {@link #primary} instance as boolean
     **/
    public boolean isPrimary() {
        return primary;
    }

    /**
     * Method to set {@link #primary}
     *
     * @param primary: flag that checks if the account is the primary
     **/
    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    /**
     * Method to get {@link #holdBalance} instance <br>
     * No-any params required
     *
     * @return {@link #holdBalance} instance as double
     **/
    public double getHoldBalance() {
        return holdBalance;
    }

    /**
     * Method to set {@link #holdBalance}
     *
     * @param holdBalance: hold balance value
     * @throws IllegalArgumentException when hold balance value is less than 0
     **/
    public void setHoldBalance(double holdBalance) {
        if (holdBalance < 0)
            throw new IllegalArgumentException("Hold balance value cannot be less than 0");
        this.holdBalance = holdBalance;
    }

    /**
     * Method to get {@link #holdBalance} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #holdBalance} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getHoldBalance(int decimals) {
        return roundValue(holdBalance, decimals);
    }

    /**
     * Method to get {@link #holdCurrency} instance <br>
     * No-any params required
     *
     * @return {@link #holdCurrency} instance as {@link String}
     **/
    public String getHoldCurrency() {
        return holdCurrency;
    }

    /**
     * Method to set {@link #holdCurrency}
     *
     * @param holdCurrency: hold currency value
     * @throws IllegalArgumentException when hold currency value is null or empty
     **/
    public void setHoldCurrency(String holdCurrency) {
        if (holdCurrency == null || holdCurrency.isEmpty())
            throw new IllegalArgumentException("Hold currency value cannot be empty or null");
        this.holdCurrency = holdCurrency;
    }

    /**
     * Method to get {@link #depositInformation} instance <br>
     * No-any params required
     *
     * @return {@link #depositInformation} instance as {@link DepositInformation}
     **/
    public DepositInformation getDepositInformation() {
        return depositInformation;
    }

    /**
     * Method to set {@link #depositInformation}
     *
     * @param depositInformation: deposit information value
     **/
    public void setDepositInformation(DepositInformation depositInformation) {
        this.depositInformation = depositInformation;
    }

    /**
     * Returns a string representation of the object <br>
     * No-any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
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

        /** Constructor to init a {@link DepositInformation} custom object
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
            if (bankCountryCode == null || bankCountryCode.isEmpty())
                throw new IllegalArgumentException("Bank country code value cannot be empty or null");
            else
                this.bankCountryCode = bankCountryCode;
            if (bankCountryName == null || bankCountryName.isEmpty())
                throw new IllegalArgumentException("Bank country name value cannot be empty or null");
            else
                this.bankCountryName = bankCountryName;
        }

        /**
         * Constructor to init a {@link DepositInformation} custom object
         *
         * @param depositInformation: deposit information as {@link JSONObject}
         **/
        public DepositInformation(JSONObject depositInformation) {
            JsonHelper hDepositInformation = new JsonHelper(depositInformation);
            this.reference = hDepositInformation.getString("reference");
            this.iban = hDepositInformation.getString("iban");
            this.accountName = hDepositInformation.getString("account_name");
            this.bankName = hDepositInformation.getString("bank_name");
            this.bankAddress = hDepositInformation.getString("bank_address");
            this.accountAddress = hDepositInformation.getString("account_address");
            this.swift = hDepositInformation.getString("swift");
            this.bankCountryCode = hDepositInformation.getString("code");
            this.bankCountryName = hDepositInformation.getString("name");
        }

        /**
         * Method to get {@link #reference} instance <br>
         * No-any params required
         *
         * @return {@link #reference} instance as {@link String}
         **/
        public String getReference() {
            return reference;
        }

        /**
         * Method to set {@link #reference}
         *
         * @param reference: reference value
         * @throws IllegalArgumentException when reference value is null or empty
         **/
        public void setReference(String reference) {
            if (reference == null || reference.isEmpty())
                throw new IllegalArgumentException("Reference value cannot be empty or null");
            this.reference = reference;
        }

        /**
         * Method to get {@link #iban} instance <br>
         * No-any params required
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
         * Method to get {@link #accountName} instance <br>
         * No-any params required
         *
         * @return {@link #accountName} instance as {@link String}
         **/
        public String getAccountName() {
            return accountName;
        }

        /**
         * Method to set {@link #accountName}
         *
         * @param accountName: account name value
         * @throws IllegalArgumentException when account name value is null or empty
         **/
        public void setAccountName(String accountName) {
            if (accountName == null || accountName.isEmpty())
                throw new IllegalArgumentException("Account name value cannot be empty or null");
            this.accountName = accountName;
        }

        /**
         * Method to get {@link #bankName} instance <br>
         * No-any params required
         *
         * @return {@link #bankName} instance as {@link String}
         **/
        public String getBankName() {
            return bankName;
        }

        /**
         * Method to set {@link #bankName}
         *
         * @param bankName: bank name value
         * @throws IllegalArgumentException when bank name value is null or empty
         **/
        public void setBankName(String bankName) {
            if (bankName == null || bankName.isEmpty())
                throw new IllegalArgumentException("Bank name value cannot be empty or null");
            this.bankName = bankName;
        }

        /**
         * Method to get {@link #bankAddress} instance <br>
         * No-any params required
         *
         * @return {@link #bankAddress} instance as {@link String}
         **/
        public String getBankAddress() {
            return bankAddress;
        }

        /**
         * Method to set {@link #bankAddress}
         *
         * @param bankAddress: bank address value
         * @throws IllegalArgumentException when bank address value is null or empty
         **/
        public void setBankAddress(String bankAddress) {
            if (bankAddress == null || bankAddress.isEmpty())
                throw new IllegalArgumentException("Bank address value cannot be empty or null");
            this.bankAddress = bankAddress;
        }

        /**
         * Method to get {@link #accountAddress} instance <br>
         * No-any params required
         *
         * @return {@link #accountAddress} instance as {@link String}
         **/
        public String getAccountAddress() {
            return accountAddress;
        }

        /**
         * Method to set {@link #accountAddress}
         *
         * @param accountAddress: account address value
         * @throws IllegalArgumentException when account address value is null or empty
         **/
        public void setAccountAddress(String accountAddress) {
            if (accountAddress == null || accountAddress.isEmpty())
                throw new IllegalArgumentException("Account address value cannot be empty or null");
            this.accountAddress = accountAddress;
        }

        /**
         * Method to get {@link #swift} instance <br>
         * No-any params required
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

        /**
         * Method to get {@link #bankCountryCode} instance <br>
         * No-any params required
         *
         * @return {@link #bankCountryCode} instance as {@link String}
         **/
        public String getBankCountryCode() {
            return bankCountryCode;
        }

        /**
         * Method to set {@link #bankCountryCode}
         *
         * @param bankCountryCode: bank country code value
         * @throws IllegalArgumentException when bank country code value is null or empty
         **/
        public void setBankCountryCode(String bankCountryCode) {
            if (bankCountryCode == null || bankCountryCode.isEmpty())
                throw new IllegalArgumentException("Bank country code value cannot be empty or null");
            this.bankCountryCode = bankCountryCode;
        }

        /**
         * Method to get {@link #bankCountryName} instance <br>
         * No-any params required
         *
         * @return {@link #bankCountryName} instance as {@link String}
         **/
        public String getBankCountryName() {
            return bankCountryName;
        }

        /**
         * Method to set {@link #bankCountryName}
         *
         * @param bankCountryName: bank country name value
         * @throws IllegalArgumentException when bank country name value is null or empty
         **/
        public void setBankCountryName(String bankCountryName) {
            if (bankCountryName == null || bankCountryName.isEmpty())
                throw new IllegalArgumentException("Bank country name value cannot be empty or null");
            this.bankCountryName = bankCountryName;
        }

        /**
         * Returns a string representation of the object <br>
         * No-any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

}
