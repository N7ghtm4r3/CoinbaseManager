package com.tecknobit.coinbasemanager.managers.exchangepro;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.apis.APIRequest;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import com.tecknobit.apimanager.trading.TradingTools;

import java.util.Properties;

import static com.tecknobit.apimanager.apis.APIRequest.*;
import static com.tecknobit.apimanager.trading.TradingTools.computeAssetPercent;
import static com.tecknobit.apimanager.trading.TradingTools.textualizeAssetPercent;

/**
 * The {@code CoinbaseManager} class is useful to manage all {@code "Coinbase"} endpoints giving basics methods for others {@code "Coinbase"} managers
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/docs-1">Welcome</a>
 **/
public class CoinbaseManager {

    /**
     * {@code CB_ACCESS_TIMESTAMP} is constant for CB_ACCESS_TIMESTAMP's header
     **/
    protected static final String CB_ACCESS_TIMESTAMP = "cb-access-timestamp";

    /**
     * {@code BASE_ENDPOINT} is constant for base endpoint for url api requests
     **/
    public static final String BASE_ENDPOINT = "https://api.exchange.coinbase.com";

    /**
     * {@code CB_ACCESS_KEY} is constant for CB_ACCESS_KEY's header
     **/
    protected static final String CB_ACCESS_KEY = "cb-access-key";

    /**
     * {@code CB_ACCESS_SIGN} is constant for CB_ACCESS_SIGN's header
     **/
    protected static final String CB_ACCESS_SIGN = "cb-access-sign";
    /**
     * {@code CB_ACCESS_PASSPHRASE} is constant for CB_ACCESS_PASSPHRASE's header
     **/
    protected static final String CB_ACCESS_PASSPHRASE = "cb-access-passphrase";
    /**
     * {@code properties} is a local instance used to instantiate a new {@link CoinbaseManager}'s manager without
     * re-insert credentials
     **/
    protected static final Properties properties = new Properties();
    /**
     * {@code headers} is instance that memorizes headers values
     **/
    protected static final Headers headers = new Headers();

    static {
        TimeFormatter.changeDefaultPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    /**
     * {@code apiRequest} is instance to use to make API requests
     **/
    protected final APIRequest apiRequest;

    /**
     * {@code apiSecret} is instance that memorizes api secret user value
     **/
    protected final String apiSecret;

    /**
     * {@code passphrase} is instance that memorizes pass phrase user value
     * **/
    protected final String passphrase;

    /**
     * {@code apiKey} is instance that memorizes api key user value
     **/
    protected final String apiKey;

    /**
     * Constructor to init a {@link CoinbaseManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        apiRequest = new APIRequest(defaultErrorMessage, timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        storeProperties(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a {@link CoinbaseManager}
     * @param apiKey: your {@code "Coinbase"} api key
     * @param apiSecret: your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        apiRequest = new APIRequest(timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        storeProperties(apiKey, apiSecret, passphrase, null, timeout);
    }

    /** Constructor to init a {@link CoinbaseManager}
     * @param apiKey: your {@code "Coinbase"} api key
     * @param apiSecret: your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        apiRequest = new APIRequest(defaultErrorMessage);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        storeProperties(apiKey, apiSecret, passphrase, defaultErrorMessage, -1);
    }

    /**
     * Constructor to init a {@link CoinbaseManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase) {
        apiRequest = new APIRequest();
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        storeProperties(apiKey, apiSecret, passphrase, null, -1);
    }

    /**
     * Constructor to init a {@link CoinbaseManager} <br>
     * Any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link CoinbaseManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        CoinbaseManager firstManager = new CoinbaseManager("apiKey", "apiSecret", "passphrase");
     *        //You don't need to insert all credentials to make manager work
     *        CoinbaseManager secondManager = new CoinbaseManager(); //same credentials used
     *     }
     * </pre>
     **/
    public CoinbaseManager() {
        apiKey = properties.getProperty("apiKey");
        if (apiKey == null)
            throw new IllegalArgumentException("You need to call a parameterized constructor first");
        apiSecret = properties.getProperty("apiSecret");
        passphrase = properties.getProperty("passphrase");
        String defaultErrorMessage = properties.getProperty("defaultErrorMessage");
        int timeout;
        try {
            timeout = Integer.parseInt(properties.getProperty("timeout"));
        } catch (NumberFormatException e) {
            timeout = -1;
        }
        if (defaultErrorMessage != null && timeout != -1)
            apiRequest = new APIRequest(defaultErrorMessage, timeout);
        else if (defaultErrorMessage != null)
            apiRequest = new APIRequest(defaultErrorMessage);
        else if (timeout != -1)
            apiRequest = new APIRequest(timeout);
        else
            apiRequest = new APIRequest();
    }

    /**
     * Method to store some properties
     *
     * @param apiKey:              {@code "Coinbase"} api key
     * @param apiSecret:           {@code "Coinbase"} api secret
     * @param passphrase:          {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    private void storeProperties(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage,
                                 int timeout) {
        properties.clear();
        properties.setProperty("apiKey", apiKey);
        properties.setProperty("apiSecret", apiSecret);
        properties.setProperty("passphrase", passphrase);
        if (defaultErrorMessage != null)
            properties.setProperty("defaultErrorMessage", defaultErrorMessage);
        if (timeout != -1)
            properties.setProperty("timeout", String.valueOf(timeout));
    }

    /**
     * Method to execute and get response of a request
     *
     * @param endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param method:   method HTTP for the request
     * @return response as {@link String}
     **/
    public String sendAPIRequest(String endpoint, String method) throws Exception {
        setRequestHeaders(method, endpoint, null);
        apiRequest.sendAPIRequest(BASE_ENDPOINT + endpoint, method, headers);
        return apiRequest.getResponse();
    }

    /** Method to set {@code "Coinbase"} request headers
     * @param endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param method: method HTTP for the request
     * @param body: only if request has a body params (generally POST request)
     * any return
     * **/
    private void setRequestHeaders(String method, String endpoint, String body) throws Exception {
        String timestamp = "" + System.currentTimeMillis() / 1000;
        String stringToSign = timestamp + method + endpoint;
        if (body != null)
            stringToSign += body;
        if (headers.getAllHeaders().size() == 0) {
            headers.addHeader("Accept", "application/json");
            headers.addHeader(CB_ACCESS_KEY, apiKey);
            headers.addHeader(CB_ACCESS_PASSPHRASE, passphrase);
        }
        headers.addHeader(CB_ACCESS_SIGN, getBase64Signature(apiSecret, stringToSign, HMAC_SHA256_ALGORITHM));
        headers.addHeader(CB_ACCESS_TIMESTAMP, timestamp);
    }

    /**
     * Method to execute and get response of a POST http request
     *
     * @param endpoint:   endpoint for the request and its query params es endpoint?param=paramValue
     * @param bodyParams: params to insert in the http body post request
     * @return response as {@link String}
     **/
    public String sendBodyParamsAPIRequest(String endpoint, String method, Params bodyParams) throws Exception {
        if (method.equals(POST_METHOD) || method.equals(APIRequest.PUT_METHOD)) {
            setRequestHeaders(method, endpoint, apiRequest.encodeBodyParams(bodyParams));
            apiRequest.sendPayloadedAPIRequest(BASE_ENDPOINT + endpoint, POST_METHOD, headers, bodyParams);
            return apiRequest.getResponse();
        } else
            throw new IllegalArgumentException("Methods allowed for this request are POST and PUT method");
    }

    /**
     * Method to assemble query params for a {@code "Coinbase"} request
     *
     * @param queryParams: value and key of query params to assemble
     * @return query params as {@link String} es. ?param=paramValue&param2=param2Value
     **/
    protected String assembleQueryParams(String defParams, Params queryParams) {
        return apiRequest.encodeAdditionalParams(defParams, queryParams);
    }

    /**
     * Method to get percent between two values and textualize it
     *
     * @param startValue:    first value to make compare
     * @param finalValue:    last value to compare and get percent by first value
     * @param decimalDigits: number of digits to round final percent value
     * @return percent value es. +8% or -8% as {@link String}
     **/
    public String getTextTrendPercent(double startValue, double finalValue, int decimalDigits) {
        return textualizeAssetPercent(startValue, finalValue, decimalDigits);
    }

    /**
     * Method to get error response of request <br>
     * Any params required
     *
     * @return error of the response as {@link String}
     **/
    public String getErrorResponse() {
        return apiRequest.getErrorResponse();
    }

    /** Method to print error response of request <br>
     * Any params required
     * **/
    public void printErrorResponse(){
        apiRequest.printErrorResponse();
    }

    /** Method to get status code of request response <br>
     * Any params required
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
        return TradingTools.roundValue(value, decimalDigits);
    }

    /** Method to get percent between two values
     * @param startValue: first value to make compare
     * @param finalValue: last value to compare and get percent by first value
     * @return percent value as double es. 8 or -8
     * @throws IllegalArgumentException if startValue or lastValue are negative
     * **/
    public double getTrendPercent(double startValue, double finalValue){
        return computeAssetPercent(startValue, finalValue);
    }

    /** Method to get percent between two values and round it
     * @param startValue: first value to make compare
     * @param finalValue: last value to compare and get percent by first value
     * @param decimalDigits: number of digits to round final percent value
     * @return percent value as double es. 8 or -8
     * @throws IllegalArgumentException if startValue or lastValue are negative
     * **/
    public double getTrendPercent(double startValue, double finalValue, int decimalDigits){
        return computeAssetPercent(startValue, finalValue, decimalDigits);
    }

    /** Method to format percent between two values and textualize it
     * @param percent: value to format
     * @return percent value formatted es. +8% or -8% as {@link String}
     * **/
    public String getTextTrendPercent(double percent){
        return textualizeAssetPercent(percent);
    }

    /** Method to get percent between two values and textualize it
     * @param startValue: first value to make compare
     * @param finalValue: last value to compare and get percent by first value
     * @return percent value es. +8% or -8% as {@link String}
     * **/
    public String getTextTrendPercent(double startValue, double finalValue){
        return textualizeAssetPercent(startValue, finalValue);
    }

    /** Method to get {@code "Coinbase"} api key
     * any params required
     * @return api key as {@link String}
     * **/
    public String getApiKey() {
        return apiKey;
    }

    /** Method to get {@code "Coinbase"} api secret
     * any params required
     * @return api secret as {@link String}
     * **/
    public String getApiSecret() {
        return apiSecret;
    }

    /**
     * Method to get {@code "Coinbase"} api passphrase
     * any params required
     *
     * @return api passphrase as {@link String}
     **/
    public String getPassphrase() {
        return passphrase;
    }

    /**
     * {@code ReturnFormat} is the instance to pass in {@link Returner} methods to format as you want the response by
     * {@code "Coinbase"}
     *
     * @apiNote you can choose between:
     * <ul>
     * <li>
     * {@link Returner.ReturnFormat#STRING} -> returns the response formatted as {@link String}
     * </li>
     * <li>
     * {@link Returner.ReturnFormat#JSON} -> returns the response formatted as {@code "JSON"}
     * </li>
     * <li>
     * {@link Returner.ReturnFormat#LIBRARY_OBJECT} -> returns the response formatted as custom object offered by library that uses this list
     * </li>
     * </ul>
     **/
    public enum ReturnFormat {

        STRING,
        JSON,
        LIBRARY_OBJECT

    }

    /**
     * The {@code Params} class is useful to assemble params values for the request
     *
     * @implNote this class can be used to assemble body payload or query request params
     * @implSpec look this library <a href="https://github.com/N7ghtm4r3/APIManager-1">here-1</a>
     * @see APIRequest.Params
     **/
    public static class Params extends APIRequest.Params {}

}
