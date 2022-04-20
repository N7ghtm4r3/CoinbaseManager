package com.tecknobit.coinbasemanager.Managers.Conversions;

import com.tecknobit.coinbasemanager.Managers.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.Conversions.Records.CurrencyConversion;
import org.json.JSONObject;

import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.CONVERSIONS_ENDPOINT;

public class CoinbaseConversionsManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseConversions manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseConversions manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseConversions manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseConversions manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String convertCurrency(String from, String to, double amount) throws Exception {
        return sendPostAPIRequest(CONVERSIONS_ENDPOINT, assembleConversionBodyParams(from, to, amount));
    }

    public JSONObject convertCurrencyJSON(String from, String to, double amount) throws Exception {
        return new JSONObject(convertCurrency(from, to, amount));
    }

    public CurrencyConversion convertCurrencyObject(String from, String to, double amount) throws Exception {
        return assembleCurrencyConversion(new JSONObject(convertCurrency(from, to, amount)));
    }

    public String convertCurrency(String from, String to, double amount,
                                  HashMap<String,Object> extraParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleConversionBodyParams(from, to, amount);
        for (String key : extraParams.keySet())
            bodyParams.put(key, extraParams.get(key));
        return sendPostAPIRequest(CONVERSIONS_ENDPOINT, bodyParams);
    }

    public JSONObject convertCurrencyJSON(String from, String to, double amount,
                                  HashMap<String,Object> extraParams) throws Exception {
        return new JSONObject(convertCurrency(from, to, amount, extraParams));
    }

    public CurrencyConversion convertCurrencyObject(String from, String to, double amount,
                                                    HashMap<String,Object> extraParams) throws Exception {
        return assembleCurrencyConversion(new JSONObject(convertCurrency(from, to, amount, extraParams)));
    }

    private HashMap<String, Object> assembleConversionBodyParams(String from, String to, double amount){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("from",from);
        bodyParams.put("to",to);
        bodyParams.put("amount",amount);
        return bodyParams;
    }

    private CurrencyConversion assembleCurrencyConversion(JSONObject jsonCurrencyConversion){
        return new CurrencyConversion(jsonCurrencyConversion.getString("id"),
                jsonCurrencyConversion.getDouble("amount"),
                jsonCurrencyConversion.getString("from_account_id"),
                jsonCurrencyConversion.getString("to_account_id"),
                jsonCurrencyConversion.getString("from"),
                jsonCurrencyConversion.getString("to")
        );
    }

    public String getCurrencyConversion(String conversionId) throws Exception {
        return sendAPIRequest(CONVERSIONS_ENDPOINT+"/"+conversionId, GET_METHOD);
    }

    public JSONObject getCurrencyConversionJSON(String conversionId) throws Exception {
        return new JSONObject(getCurrencyConversion(conversionId));
    }

    public CurrencyConversion getCurrencyConversionObject(String conversionId) throws Exception {
        return assembleCurrencyConversion(new JSONObject(getCurrencyConversion(conversionId)));
    }

    public String getCurrencyConversion(String conversionId, String profileId) throws Exception {
        return sendAPIRequest(CONVERSIONS_ENDPOINT+"/"+conversionId+"?profile_id="+profileId, GET_METHOD);
    }

    public JSONObject getCurrencyConversionJSON(String conversionId, String profileId) throws Exception {
        return new JSONObject(getCurrencyConversion(conversionId, profileId));
    }

    public CurrencyConversion getCurrencyConversionObject(String conversionId, String profileId) throws Exception {
        return assembleCurrencyConversion(new JSONObject(getCurrencyConversion(conversionId, profileId)));
    }

}
