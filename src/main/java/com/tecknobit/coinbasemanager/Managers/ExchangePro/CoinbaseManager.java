package com.tecknobit.coinbasemanager.Managers.ExchangePro;

import com.tecknobit.apimanager.Manager.APIRequest;
import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import com.tecknobit.apimanager.Tools.Trading.TradingTools;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * The {@code CoinbaseManager} class is useful to manage all Coinbase endpoints giving basics methods for others Coinbase managers
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/docs">https://docs.cloud.coinbase.com/exchange/docs</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseManager {

    /**
     * {@code BASE_ENDPOINT} is constant for base endpoint for url api requests
     * **/
    public static final String BASE_ENDPOINT = "https://api.exchange.coinbase.com";

    /**
     * {@code CB_ACCESS_KEY} is constant for CB_ACCESS_KEY's header
     * **/
    protected static final String CB_ACCESS_KEY = "cb-access-key";

    /**
     * {@code CB_ACCESS_SIGN} is constant for CB_ACCESS_SIGN's header
     * **/
    protected static final String CB_ACCESS_SIGN = "cb-access-sign";

    /**
     * {@code CB_ACCESS_TIMESTAMP} is constant for CB_ACCESS_TIMESTAMP's header
     * **/
    protected static final String CB_ACCESS_TIMESTAMP = "cb-access-timestamp";

    /**
     * {@code CB_ACCESS_PASSPHRASE} is constant for CB_ACCESS_PASSPHRASE's header
     * **/
    protected static final String CB_ACCESS_PASSPHRASE = "cb-access-passphrase";

    /**
     * {@code headers} is instance that memorizes headers values
     * **/
    protected final HashMap<String, String> headers;

    /**
     * {@code apiRequest} is instance to use to make API requests
     * **/
    protected final APIRequest apiRequest;

    /**
     * {@code tradingTools} is instance to use for trading tool workflow
     * **/
    protected final TradingTools tradingTools;

    /**
     * {@code apiSecret} is instance that memorizes api secret user value
     * **/
    protected final String apiSecret;

    /**
     * {@code passphrase} is instance that memorizes pass phrase user value
     * **/
    protected final String passphrase;

    /**
     * {@code apiKey} is instance that memorizes api key user value
     * **/
    protected final String apiKey;

    /**
     * {@code jsonObject} is instance useful to format {@link JSONObject}' s responses API
     * **/
    protected JSONObject jsonObject;

    /**
     * {@code jsonArray} is instance useful to format {@link JSONArray}' s responses API
     * **/
    protected JSONArray jsonArray;

    /**
     * {@code jsonHelper} is instance useful to help to format JSON responses API
     * **/
    protected JsonHelper jsonHelper;

    /**
     * {@code keysInserted} is control flag
     * **/
    private boolean keysInserted;

    /** Constructor to init a {@link CoinbaseManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        apiRequest = new APIRequest(defaultErrorMessage, timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        tradingTools = new TradingTools();
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Constructor to init a {@link CoinbaseManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        apiRequest = new APIRequest(timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        tradingTools = new TradingTools();
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Constructor to init a {@link CoinbaseManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        apiRequest = new APIRequest(defaultErrorMessage);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        tradingTools = new TradingTools();
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Constructor to init a {@link CoinbaseManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase) {
        apiRequest = new APIRequest();
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        tradingTools = new TradingTools();
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Method to execute and get response of a request
     * @param endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param method: method HTTP for the request
     * @return response as {@link String}
     * **/
    public String sendAPIRequest(String endpoint, String method) throws Exception {
        setRequestHeaders(method, endpoint, null);
        apiRequest.sendAPIRequest(BASE_ENDPOINT + endpoint, method, headers);
        return apiRequest.getResponse();
    }

    /** Method to execute and get response of a POST http request
     * @param endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param bodyParams: params to insert in the http body post request
     * @return response as {@link String}
     * **/
    public String sendBodyParamsAPIRequest(String endpoint, String method, HashMap<String, Object> bodyParams) throws Exception {
        if(method.equals(APIRequest.POST_METHOD) || method.equals(APIRequest.PUT_METHOD)){
            setRequestHeaders(method, endpoint, apiRequest.assembleBodyParams(bodyParams));
            apiRequest.sendPostAPIRequest(BASE_ENDPOINT + endpoint, bodyParams);
            return apiRequest.getResponse();
        }else
            throw new IllegalArgumentException("Methods allowed for this request are POST and PUT method");
    }

    /** Method to set Coinbase request headers
     * @param endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param method: method HTTP for the request
     * @param body: only if request has a body params (generally POST request)
     * any return
     * **/
    private void setRequestHeaders(String method, String endpoint, String body) throws Exception {
        String timestamp = "" + System.currentTimeMillis() / 1000;
        String stringToSign = timestamp + method + endpoint;
        if(body != null)
            stringToSign += body;
        if(!keysInserted){
            headers.put("Accept","application/json");
            headers.put(CB_ACCESS_KEY, apiKey);
            headers.put(CB_ACCESS_PASSPHRASE, passphrase);
            keysInserted = true;
        }
        headers.put(CB_ACCESS_SIGN, apiRequest.getBase64Signature(apiSecret, stringToSign));
        headers.put(CB_ACCESS_TIMESTAMP, timestamp);
    }

    /** Method to assemble query params for a Coinbase request
     * @param queryParams: value and key of query params to assemble
     * @return query params as {@link String} es. ?param=paramValue&param2=param2Value
     * **/
    protected String assembleQueryParams(String defParams, HashMap<String, Object> queryParams){
        return apiRequest.assembleAdditionalParams(defParams, queryParams);
    }

    /** Method to get error response of request
     * any params required
     * @return error of the response as {@link String}
     * **/
    public String getErrorResponse(){
        return apiRequest.getErrorResponse();
    }

    /** Method to get status code of request response
     * any params required
     * @return status code of request response
     * **/
    public int getStatusResponse(){
        return apiRequest.getResponseStatusCode();
    }

    /** Method to round a value
     * @param value: value to round
     * @param decimalDigits: number of digits to round final value
     * @return value rounded with decimalDigits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double roundValue(double value, int decimalDigits){
        return tradingTools.roundValue(value, decimalDigits);
    }

    /** Method to get percent between two values
     * @param startValue: first value to make compare
     * @param finalValue: last value to compare and get percent by first value
     * @return percent value as double es. 8 or -8
     * @throws IllegalArgumentException if startValue or lastValue are negative
     * **/
    public double getTrendPercent(double startValue, double finalValue){
        return tradingTools.computeAssetPercent(startValue, finalValue);
    }

    /** Method to get percent between two values and round it
     * @param startValue: first value to make compare
     * @param finalValue: last value to compare and get percent by first value
     * @param decimalDigits: number of digits to round final percent value
     * @return percent value as double es. 8 or -8
     * @throws IllegalArgumentException if startValue or lastValue are negative
     * **/
    public double getTrendPercent(double startValue, double finalValue, int decimalDigits){
        return tradingTools.computeAssetPercent(startValue, finalValue, decimalDigits);
    }

    /** Method to format percent between two values and textualize it
     * @param percent: value to format
     * @return percent value formatted es. +8% or -8% as {@link String}
     * **/
    public String getTextTrendPercent(double percent){
        return tradingTools.textualizeAssetPercent(percent);
    }

    /** Method to get percent between two values and textualize it
     * @param startValue: first value to make compare
     * @param finalValue: last value to compare and get percent by first value
     * @return percent value es. +8% or -8% as {@link String}
     * **/
    public String getTextTrendPercent(double startValue, double finalValue){
        return tradingTools.textualizeAssetPercent(startValue, finalValue);
    }

    /** Method to get percent between two values and textualize it
     * @param startValue: first value to make compare
     * @param finalValue: last value to compare and get percent by first value
     * @param decimalDigits: number of digits to round final percent value
     * @return percent value es. +8% or -8% as {@link String}
     * **/
    public String getTextTrendPercent(double startValue, double finalValue, int decimalDigits){
        return tradingTools.textualizeAssetPercent(startValue, finalValue, decimalDigits);
    }

    /** Method to get Coinbase api key
     * any params required
     * @return api key as {@link String}
     * **/
    public String getApiKey() {
        return apiKey;
    }

    /** Method to get Coinbase api secret
     * any params required
     * @return api secret as {@link String}
     * **/
    public String getApiSecret() {
        return apiSecret;
    }

    /** Method to get Coinbase api passphrase
     * any params required
     * @return api passphrase as {@link String}
     * **/
    public String getPassphrase() {
        return passphrase;
    }

    /** Method to get TradingTools object
     * any params required
     * @return tradingTools as {@link TradingTools}
     * **/
    public TradingTools getTradingTools() {
        return tradingTools;
    }

}
