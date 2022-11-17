package com.tecknobit.coinbasemanager.managers.exchangepro.currencies.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.formatters.JsonHelper.getJSONArray;

/**
 * The {@code Currency} class is useful to format Currency object
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *        <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1">
 *            Get all known currencies</a>
 *     </li>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1">
 *            Get a currency</a>
 *     </li>
 * </ul>
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
     **/
    private final ArrayList<String> convertibleToCurrenciesList;

    /**
     * {@code currencyDetails} is instance that memorizes currency details
     **/
    private final CurrencyDetails currencyDetails;

    /**
     * Constructor to init a {@link Currency} object
     *
     * @param id:                          identifier value
     * @param name:                        name value
     * @param status:                      status value
     * @param minSize:                     minimum size value
     * @param maxPrecision:                maximum precision value
     * @param message:                     message value
     * @param convertibleToCurrenciesList: list of convertible currencies
     * @param currencyDetails:             currency details
     **/
    public Currency(String id, String name, String status, double minSize, double maxPrecision, String message,
                    ArrayList<String> convertibleToCurrenciesList, CurrencyDetails currencyDetails) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.minSize = minSize;
        this.maxPrecision = maxPrecision;
        this.message = message;
        this.convertibleToCurrenciesList = convertibleToCurrenciesList;
        this.currencyDetails = currencyDetails;
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
        convertibleToCurrenciesList = loadDetailsList(getJSONArray(currency, "convertible_to", new JSONArray()));
        currencyDetails = new CurrencyDetails(currency.getJSONObject("details"));
    }

    /**
     * Method to assemble a string value list
     *
     * @param jsonDetails: jsonObject obtained by response request
     * @return string values list as {@link ArrayList} of {@link String}
     **/
    @Returner
    private static ArrayList<String> loadDetailsList(JSONArray jsonDetails) {
        ArrayList<String> details = new ArrayList<>();
        for (int j = 0; j < jsonDetails.length(); j++)
            details.add(jsonDetails.getString(j));
        return details;
    }

    /**
     * Method to get {@link #id} instance <br>
     * Any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #name} instance <br>
     * Any params required
     *
     * @return {@link #name} instance as {@link String}
     **/
    public String getName() {
        return name;
    }

    /**
     * Method to get {@link #status} instance <br>
     * Any params required
     *
     * @return {@link #status} instance as {@link String}
     **/
    public String getStatus() {
        return status;
    }

    /**
     * Method to get {@link #minSize} instance <br>
     * Any params required
     *
     * @return {@link #minSize} instance as double
     **/
    public double getMinSize() {
        return minSize;
    }

    /**
     * Method to get {@link #maxPrecision} instance <br>
     * Any params required
     *
     * @return {@link #maxPrecision} instance as double
     **/
    public double getMaxPrecision() {
        return maxPrecision;
    }

    /**
     * Method to get {@link #message} instance <br>
     * Any params required
     *
     * @return {@link #message} instance as {@link String}
     **/
    public String getMessage() {
        return message;
    }

    /**
     * Method to get {@link #convertibleToCurrenciesList} instance <br>
     * Any params required
     *
     * @return {@link #convertibleToCurrenciesList} instance as {@link ArrayList} of {@link String}
     **/
    public ArrayList<String> getConvertibleToCurrenciesList() {
        return convertibleToCurrenciesList;
    }

    /**
     * Method to get a convertible currency from {@link #convertibleToCurrenciesList}
     *
     * @param index: index of the convertible currency to get
     * @return convertible currency as {@link String}
     **/
    public String getConvertibleCurrency(int index) {
        return convertibleToCurrenciesList.get(index);
    }

    /**
     * Method to get {@link #currencyDetails} instance <br>
     * Any params required
     *
     * @return {@link #currencyDetails} instance as {@link CurrencyDetails}
     **/
    public CurrencyDetails getCurrencyDetails() {
        return currencyDetails;
    }

    /**
     * Returns a string representation of the object <br>
     * Any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

    /**
     * The {@code CurrencyDetails} class is useful to obtain and format CurrencyDetails object for Currency
     *
     * @author N7ghtm4r3 - Tecknobit
     * *
     **/
    public static class CurrencyDetails {

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
            JsonHelper hCurrency = new JsonHelper(currencyDetails.getJSONObject("details"));
            symbol = hCurrency.getString("symbol");
            minWithdrawalAmount = hCurrency.getDouble("min_withdrawal_amount");
            networksConfirmations = hCurrency.getInt("network_confirmations");
            maxWithdrawalAmount = hCurrency.getDouble("max_withdrawal_amount");
            cryptoAddressLink = hCurrency.getString("crypto_address_link");
            type = hCurrency.getString("type");
            sortOrder = hCurrency.getInt("sort_order");
            cryptoTransactionLink = hCurrency.getString("crypto_transaction_link");
            displayName = hCurrency.getString("display_name");
            processingTimeSeconds = hCurrency.getString("processing_time_seconds");
            pushPaymentMethodsList = loadDetailsList(hCurrency.getJSONArray("push_payment_methods", new JSONArray()));
            groupTypesList = loadDetailsList(hCurrency.getJSONArray("group_types", new JSONArray()));
        }

        /**
         * Method to get {@link #symbol} instance <br>
         * Any params required
         *
         * @return {@link #symbol} instance as {@link String}
         **/
        public String getSymbol() {
            return symbol;
        }

        /**
         * Method to get {@link #minWithdrawalAmount} instance <br>
         * Any params required
         *
         * @return {@link #minWithdrawalAmount} instance as double
         **/
        public double getMinWithdrawalAmount() {
            return minWithdrawalAmount;
        }

        /**
         * Method to get {@link #networksConfirmations} instance <br>
         * Any params required
         *
         * @return {@link #networksConfirmations} instance as int
         **/
        public int getNetworksConfirmations() {
            return networksConfirmations;
        }

        /**
         * Method to get {@link #maxWithdrawalAmount} instance <br>
         * Any params required
         *
         * @return {@link #maxWithdrawalAmount} instance as double
         **/
        public double getMaxWithdrawalAmount() {
            return maxWithdrawalAmount;
        }

        /**
         * Method to get {@link #cryptoAddressLink} instance <br>
         * Any params required
         *
         * @return {@link #cryptoAddressLink} instance as {@link String}
         **/
        public String getCryptoAddressLink() {
            return cryptoAddressLink;
        }

        /**
         * Method to get {@link #type} instance <br>
         * Any params required
         *
         * @return {@link #type} instance as {@link String}
         **/
        public String getType() {
            return type;
        }

        /**
         * Method to get {@link #sortOrder} instance <br>
         * Any params required
         *
         * @return {@link #sortOrder} instance as int
         **/
        public int getSortOrder() {
            return sortOrder;
        }

        /**
         * Method to get {@link #cryptoTransactionLink} instance <br>
         * Any params required
         *
         * @return {@link #cryptoTransactionLink} instance as {@link String}
         **/
        public String getCryptoTransactionLink() {
            return cryptoTransactionLink;
        }

        /**
         * Method to get {@link #displayName} instance <br>
         * Any params required
         *
         * @return {@link #displayName} instance as {@link String}
         **/
        public String getDisplayName() {
            return displayName;
        }

        /**
         * Method to get {@link #processingTimeSeconds} instance <br>
         * Any params required
         *
         * @return {@link #processingTimeSeconds} instance as {@link String}
         **/
        public String getProcessingTimeSeconds() {
            return processingTimeSeconds;
        }

        /**
         * Method to get {@link #pushPaymentMethodsList} instance <br>
         * Any params required
         *
         * @return {@link #pushPaymentMethodsList} instance as {@link ArrayList} of {@link String}
         **/
        public ArrayList<String> getPushPaymentMethodsList() {
            return pushPaymentMethodsList;
        }

        /**
         * Method to get a push payment method from {@link #pushPaymentMethodsList}
         *
         * @param index: index of the push payment method to get
         * @return push payment method as {@link String}
         **/
        public String getPushPaymentMethod(int index) {
            return pushPaymentMethodsList.get(index);
        }

        /**
         * Method to get {@link #groupTypesList} instance <br>
         * Any params required
         *
         * @return {@link #groupTypesList} instance as {@link ArrayList} of {@link String}
         **/
        public ArrayList<String> getGroupTypesList() {
            return groupTypesList;
        }

        /**
         * Method to get a group type from {@link #groupTypesList}
         *
         * @param index: index of the group type to get
         * @return group type as {@link String}
         **/
        public String getGroupType(int index) {
            return groupTypesList.get(index);
        }

        /**
         * Returns a string representation of the object <br>
         * Any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

}
