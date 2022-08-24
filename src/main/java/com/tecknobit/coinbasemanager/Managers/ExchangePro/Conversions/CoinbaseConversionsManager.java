package com.tecknobit.coinbasemanager.Managers.ExchangePro.Conversions;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Conversions.Records.CurrencyConversion;
import org.json.JSONObject;

import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.Manager.APIRequest.POST_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.CONVERSIONS_ENDPOINT;

/**
 *  The {@code CoinbaseConversionsManager} class is useful to manage all Coinbase conversion endpoints
 *  @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
 *      https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
 *  @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseConversionsManager extends CoinbaseManager {

    /** Constructor to init a {@link CoinbaseConversionsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a {@link CoinbaseConversionsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a {@link CoinbaseConversionsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a {@link CoinbaseConversionsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to convert one currency into another one
     * @param from: currency to convert
     * @param to: final currency to convert
     * @param amount: amount value to convert
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
     * @return result of conversion as {@link String}
     * **/
    public String convertCurrency(String from, String to, double amount) throws Exception {
        return sendBodyParamsAPIRequest(CONVERSIONS_ENDPOINT, POST_METHOD, assembleConversionPayload(from, to, amount));
    }
    
    /** Request to convert one currency into another one
     * @param from: currency to convert
     * @param to: final currency to convert
     * @param amount: amount value to convert
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
     * @return result of conversion as {@link JSONObject}
     * **/
    public JSONObject convertCurrencyJSON(String from, String to, double amount) throws Exception {
        return new JSONObject(convertCurrency(from, to, amount));
    }

    /** Request to convert one currency into another one
     * @param from: currency to convert
     * @param to: final currency to convert
     * @param amount: amount value to convert
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
     * @return result of conversion as {@link CurrencyConversion} object
     * **/
    public CurrencyConversion convertCurrencyObject(String from, String to, double amount) throws Exception {
        return new CurrencyConversion(new JSONObject(convertCurrency(from, to, amount)));
    }

    /** Request to convert one currency into another one
     * @param from: currency to convert
     * @param to: final currency to convert
     * @param amount: amount value to convert
     * @param extraParams: extra body params of request
     * @implSpec (keys accepted are profile_id,nonce)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
     * @return result of conversion as {@link String}
     * **/
    public String convertCurrency(String from, String to, double amount, Params extraParams) throws Exception {
        Params bodyParams = assembleConversionPayload(from, to, amount);
        for (String key : extraParams.getParamsKeys())
            bodyParams.addParam(key, extraParams.getParam(key));
        return sendBodyParamsAPIRequest(CONVERSIONS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to convert one currency into another one
     * @param from: currency to convert
     * @param to: final currency to convert
     * @param amount: amount value to convert
     * @param extraParams: extra body params of request
     * @implSpec (keys accepted are profile_id,nonce)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
     * @return result of conversion as {@link JSONObject}
     * **/
    public JSONObject convertCurrencyJSON(String from, String to, double amount, Params extraParams) throws Exception {
        return new JSONObject(convertCurrency(from, to, amount, extraParams));
    }

    /** Request to convert one currency into another one
     * @param from: currency to convert
     * @param to: final currency to convert
     * @param amount: amount value to convert
     * @param extraParams: extra body params of request
     * @implSpec (keys accepted are profile_id,nonce)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion</a>
     * @return result of conversion as {@link CurrencyConversion} object
     * **/
    public CurrencyConversion convertCurrencyObject(String from, String to, double amount, Params extraParams) throws Exception {
        return new CurrencyConversion(new JSONObject(convertCurrency(from, to, amount, extraParams)));
    }

    /** Method to assemble map of body params
     * @param from: currency to convert
     * @param to: final currency to convert
     * @param amount: amount value to convert
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assembleConversionPayload(String from, String to, double amount){
        Params bodyParams = new Params();
        bodyParams.addParam("from", from);
        bodyParams.addParam("to", to);
        bodyParams.addParam("amount", amount);
        return bodyParams;
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion</a>
     * @return information about one conversion as {@link String}
     * **/
    public String getCurrencyConversion(String conversionId) throws Exception {
        return sendAPIRequest(CONVERSIONS_ENDPOINT + "/" + conversionId, GET_METHOD);
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion</a>
     * @return information about one conversion as {@link JSONObject}
     * **/
    public JSONObject getCurrencyConversionJSON(String conversionId) throws Exception {
        return new JSONObject(getCurrencyConversion(conversionId));
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion</a>
     * @return information about one conversion as {@link CurrencyConversion} object
     * **/
    public CurrencyConversion getCurrencyConversionObject(String conversionId) throws Exception {
        return new CurrencyConversion(new JSONObject(getCurrencyConversion(conversionId)));
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @param profileId: identifier of account to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion</a>
     * @return information about one conversion as {@link String}
     * **/
    public String getCurrencyConversion(String conversionId, String profileId) throws Exception {
        return sendAPIRequest(CONVERSIONS_ENDPOINT + "/" + conversionId + "?profile_id=" + profileId, GET_METHOD);
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @param profileId: identifier of account to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion</a>
     * @return information about one conversion as {@link JSONObject}
     * **/
    public JSONObject getCurrencyConversionJSON(String conversionId, String profileId) throws Exception {
        return new JSONObject(getCurrencyConversion(conversionId, profileId));
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @param profileId: identifier of account to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion</a>
     * @return information about one conversion as {@link CurrencyConversion} object
     * **/
    public CurrencyConversion getCurrencyConversionObject(String conversionId, String profileId) throws Exception {
        return new CurrencyConversion(new JSONObject(getCurrencyConversion(conversionId, profileId)));
    }

}
