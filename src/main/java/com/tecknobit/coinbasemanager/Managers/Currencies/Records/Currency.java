package com.tecknobit.coinbasemanager.Managers.Currencies.Records;

import com.tecknobit.coinbasemanager.Helpers.JSONParserHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Currency} class is useful to format Currency object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Currency {

    private final String id;
    private final String name;
    private final String status;
    private final double minSize;
    private final double maxPrecision;
    private final String message;
    private final ArrayList<String> convertibleToCurrencies;
    private final CurrencyDetails currencyDetails;

    public Currency(String id, String name, String status, double minSize, double maxPrecision, String message,
                    JSONObject jsonCurrencyDetails) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.minSize = minSize;
        this.maxPrecision = maxPrecision;
        this.message = message;
        JSONParserHelper jsonParserHelper = new JSONParserHelper(jsonCurrencyDetails.getJSONObject("details"));
        convertibleToCurrencies = loadDetailsList(jsonCurrencyDetails.getJSONArray("convertible_to"));
        currencyDetails = new CurrencyDetails(jsonParserHelper.getStringDetailValue("symbol"),
                jsonParserHelper.getNumberDetailValue("min_withdrawal_amount"),
                (int) jsonParserHelper.getNumberDetailValue("network_confirmations"),
                jsonParserHelper.getNumberDetailValue("max_withdrawal_amount"),
                jsonParserHelper.getStringDetailValue("crypto_address_link"),
                jsonParserHelper.getStringDetailValue("type"),
                (int) jsonParserHelper.getNumberDetailValue("sort_order"),
                jsonParserHelper.getStringDetailValue("crypto_transaction_link"),
                jsonParserHelper.getStringDetailValue("display_name"),
                jsonParserHelper.getStringDetailValue("processing_time_seconds"),
                loadDetailsList(jsonParserHelper.getJSONArrayList("push_payment_methods")),
                loadDetailsList(jsonParserHelper.getJSONArrayList("group_types"))
        );
    }

    /** Method to assemble a string value list
     * @param #jsonDetails: jsonObject obtained by response request
     * @return string values list as {@link ArrayList} of {@link String}
     * **/
    private ArrayList<String> loadDetailsList(JSONArray jsonDetails){
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

    public ArrayList<String> getConvertibleToCurrencies() {
        return convertibleToCurrencies;
    }

    public CurrencyDetails getCurrencyDetails() {
        return currencyDetails;
    }

    /**
     * The {@code CurrencyDetails} class is useful to obtain and format CurrencyDetails object for Currency
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency
     * **/
    public static class CurrencyDetails{

        private final String symbol;
        private final double minWithdrawalAmount;
        private final int networksConfirmations;
        private final double maxWithdrawalAmount;
        private final String cryptoAddressLink;
        private final String type;
        private final int sortOrder;
        private final String cryptoTransactionLink;
        private final String displayName;
        private final String processingTimeSeconds;
        private final ArrayList<String> pushPaymentMethods;
        private final ArrayList<String> groupTypes;

        public CurrencyDetails(String symbol, double minWithdrawalAmount, int networksConfirmations,
                               double maxWithdrawalAmount, String cryptoAddressLink, String type, int sortOrder,
                               String cryptoTransactionLink, String displayName, String processingTimeSeconds,
                               ArrayList<String> pushPaymentMethods, ArrayList<String> groupTypes) {
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
            this.pushPaymentMethods = pushPaymentMethods;
            this.groupTypes = groupTypes;
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

        public ArrayList<String> getPushPaymentMethods() {
            return pushPaymentMethods;
        }

        public ArrayList<String> getGroupTypes() {
            return groupTypes;
        }

    }

}
