package com.tecknobit.coinbasemanager.managers.exchangepro.currencies.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Currency} class is useful to format Currency object
 * @apiNote see the official documentation at:
<ul>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1</a>
</li>
</ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Currency {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code name} is instance that memorizes name value
     * **/
    private final String name;

    /**
     * {@code status} is instance that memorizes status value
     * **/
    private final String status;

    /**
     * {@code minSize} is instance that memorizes minimum size value
     * **/
    private final double minSize;

    /**
     * {@code maxPrecision} is instance that memorizes maximum precision value
     * **/
    private final double maxPrecision;

    /**
     * {@code message} is instance that memorizes message value
     * **/
    private final String message;

    /**
     * {@code convertibleToCurrenciesList} is instance that memorizes list of convertible currencies
     * **/
    private final ArrayList<String> convertibleToCurrenciesList;

    /**
     * {@code currencyDetails} is instance that memorizes currency details
     * **/
    private final CurrencyDetails currencyDetails;

    /** Constructor to init a {@link Currency} object
     * @param id: identifier value
     * @param name: name value
     * @param status: status value
     * @param minSize: minimum size value
     * @param maxPrecision: maximum precision value
     * @param message: message value
     * @param currency: currency detail in JSON format
     * **/
    public Currency(String id, String name, String status, double minSize, double maxPrecision, String message,
                    JSONObject currency) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.minSize = minSize;
        this.maxPrecision = maxPrecision;
        this.message = message;
        convertibleToCurrenciesList = loadDetailsList(JsonHelper.getJSONArray(currency, "convertible_to"));
        JsonHelper currencyDetails = new JsonHelper(currency.getJSONObject("details"));
        this.currencyDetails = new CurrencyDetails(currencyDetails.getString("symbol"),
                currencyDetails.getDouble("min_withdrawal_amount"),
                currencyDetails.getInt("network_confirmations"),
                currencyDetails.getDouble("max_withdrawal_amount"),
                currencyDetails.getString("crypto_address_link"),
                currencyDetails.getString("type"),
                currencyDetails.getInt("sort_order"),
                currencyDetails.getString("crypto_transaction_link"),
                currencyDetails.getString("display_name"),
                currencyDetails.getString("processing_time_seconds"),
                loadDetailsList(currencyDetails.getJSONArray("push_payment_methods")),
                loadDetailsList(currencyDetails.getJSONArray("group_types"))
        );
    }

    /** Constructor to init a {@link Currency} object
     * @param currency: currency details as {@link JSONObject}
     * **/
    public Currency(JSONObject currency) {
        id = currency.getString("id");
        name = currency.getString("name");
        status = currency.getString("status");
        minSize = currency.getDouble("min_size");
        maxPrecision = currency.getDouble("max_precision");
        message = currency.getString("message");
        convertibleToCurrenciesList = loadDetailsList(JsonHelper.getJSONArray(currency, "convertible_to"));
        currencyDetails = new CurrencyDetails(currency.getJSONObject("details"));
    }

    /** Method to assemble a string value list
     * @param jsonDetails: jsonObject obtained by response request
     * @return string values list as {@link ArrayList} of {@link String}
     * **/
    private static ArrayList<String> loadDetailsList(JSONArray jsonDetails){
        ArrayList<String> details = new ArrayList<>();
        if(jsonDetails != null)
            for (int j=0; j < jsonDetails.length(); j++)
                details.add(jsonDetails.getString(j));
        return details;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public double getMinSize() {
        return minSize;
    }

    public double getMaxPrecision() {
        return maxPrecision;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<String> getConvertibleToCurrenciesList() {
        return convertibleToCurrenciesList;
    }

    public String getConvertibleCurrency(int index){
        return convertibleToCurrenciesList.get(index);
    }

    public CurrencyDetails getCurrencyDetails() {
        return currencyDetails;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", minSize=" + minSize +
                ", maxPrecision=" + maxPrecision +
                ", message='" + message + '\'' +
                ", convertibleToCurrenciesList=" + convertibleToCurrenciesList +
                ", currencyDetails=" + currencyDetails.toString() +
                '}';
    }

    /**
     * The {@code CurrencyDetails} class is useful to obtain and format CurrencyDetails object for Currency
     * @author N7ghtm4r3 - Tecknobit
     * * **/
    public static class CurrencyDetails{

        /**
         * {@code symbol} is instance that memorizes symbol value
         * **/
        private final String symbol;

        /**
         * {@code minWithdrawalAmount} is instance that memorizes minimum withdrawal amount value
         * **/
        private final double minWithdrawalAmount;

        /**
         * {@code networksConfirmations} is instance that memorizes networks confirmations value
         * **/
        private final int networksConfirmations;

        /**
         * {@code maxWithdrawalAmount} is instance that memorizes maximum withdrawal amount value
         * **/
        private final double maxWithdrawalAmount;

        /**
         * {@code cryptoAddressLink} is instance that memorizes crypto address link value
         * **/
        private final String cryptoAddressLink;

        /**
         * {@code type} is instance that memorizes type value
         * **/
        private final String type;

        /**
         * {@code sortOrder} is instance that memorizes sort order value
         * **/
        private final int sortOrder;

        /**
         * {@code cryptoTransactionLink} is instance that memorizes crypto transaction link value
         * **/
        private final String cryptoTransactionLink;

        /**
         * {@code displayName} is instance that memorizes display name value
         * **/
        private final String displayName;

        /**
         * {@code processingTimeSeconds} is instance that memorizes processing time seconds value
         * **/
        private final String processingTimeSeconds;

        /**
         * {@code pushPaymentMethodsList} is instance that memorizes list of push payment methods
         * **/
        private final ArrayList<String> pushPaymentMethodsList;

        /**
         * {@code groupTypesList} is instance that memorizes list of group types
         * **/
        private final ArrayList<String> groupTypesList;

        /** Constructor to init a {@link CurrencyDetails} object
         * @param symbol: symbol value
         * @param minWithdrawalAmount: minimum withdrawal amount value
         * @param networksConfirmations: networks confirmations value
         * @param maxWithdrawalAmount: maximum withdrawal amount value
         * @param cryptoAddressLink: crypto address link value
         * @param type: type value
         * @param sortOrder: sort order value
         * @param cryptoTransactionLink: crypto transaction link value
         * @param displayName: display name value
         * @param processingTimeSeconds: processing time seconds value
         * @param pushPaymentMethodsList: list of push payment methods
         * @param groupTypesList: list of group types
         * **/
        public CurrencyDetails(String symbol, double minWithdrawalAmount, int networksConfirmations,
                               double maxWithdrawalAmount, String cryptoAddressLink, String type, int sortOrder,
                               String cryptoTransactionLink, String displayName, String processingTimeSeconds,
                               ArrayList<String> pushPaymentMethodsList, ArrayList<String> groupTypesList) {
            this.symbol = symbol;
            this.minWithdrawalAmount = minWithdrawalAmount;
            this.networksConfirmations = networksConfirmations;
            this.maxWithdrawalAmount = maxWithdrawalAmount;
            this.cryptoAddressLink = cryptoAddressLink;
            this.type = type;
            this.sortOrder = sortOrder;
            this.cryptoTransactionLink = cryptoTransactionLink;
            this.displayName = displayName;
            this.processingTimeSeconds = processingTimeSeconds;
            this.pushPaymentMethodsList = pushPaymentMethodsList;
            this.groupTypesList = groupTypesList;
        }

        /** Constructor to init a {@link Currency} object
         * @param currencyDetails: currency details as {@link JSONObject}
         * **/
        public CurrencyDetails(JSONObject currencyDetails) {
            JsonHelper currency = new JsonHelper(currencyDetails.getJSONObject("details"));
            symbol = currency.getString("symbol");
            minWithdrawalAmount = currency.getDouble("min_withdrawal_amount");
            networksConfirmations = currency.getInt("network_confirmations");
            maxWithdrawalAmount = currency.getDouble("max_withdrawal_amount");
            cryptoAddressLink = currency.getString("crypto_address_link");
            type = currency.getString("type");
            sortOrder = currency.getInt("sort_order");
            cryptoTransactionLink = currency.getString("crypto_transaction_link");
            displayName = currency.getString("display_name");
            processingTimeSeconds = currency.getString("processing_time_seconds");
            pushPaymentMethodsList = loadDetailsList(currency.getJSONArray("push_payment_methods"));
            groupTypesList = loadDetailsList(currency.getJSONArray("group_types"));
        }

        public String getSymbol() {
            return symbol;
        }

        public double getMinWithdrawalAmount() {
            return minWithdrawalAmount;
        }

        public int getNetworksConfirmations() {
            return networksConfirmations;
        }

        public double getMaxWithdrawalAmount() {
            return maxWithdrawalAmount;
        }

        public String getCryptoAddressLink() {
            return cryptoAddressLink;
        }

        public String getType() {
            return type;
        }

        public int getSortOrder() {
            return sortOrder;
        }

        public String getCryptoTransactionLink() {
            return cryptoTransactionLink;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getProcessingTimeSeconds() {
            return processingTimeSeconds;
        }

        public ArrayList<String> getPushPaymentMethodsList() {
            return pushPaymentMethodsList;
        }

        public String getPushPaymentMethod(int index){
            return pushPaymentMethodsList.get(index);
        }

        public ArrayList<String> getGroupTypesList() {
            return groupTypesList;
        }

        public String getGroupType(int index){
            return groupTypesList.get(index);
        }

        @Override
        public String toString() {
            return "CurrencyDetails{" +
                    "symbol='" + symbol + '\'' +
                    ", minWithdrawalAmount=" + minWithdrawalAmount +
                    ", networksConfirmations=" + networksConfirmations +
                    ", maxWithdrawalAmount=" + maxWithdrawalAmount +
                    ", cryptoAddressLink='" + cryptoAddressLink + '\'' +
                    ", type='" + type + '\'' +
                    ", sortOrder=" + sortOrder +
                    ", cryptoTransactionLink='" + cryptoTransactionLink + '\'' +
                    ", displayName='" + displayName + '\'' +
                    ", processingTimeSeconds='" + processingTimeSeconds + '\'' +
                    ", pushPaymentMethodsList=" + pushPaymentMethodsList +
                    ", groupTypesList=" + groupTypesList +
                    '}';
        }

    }

}
