package com.tecknobit.coinbasemanager.Managers.ExchangePro;

import com.tecknobit.apimanager.Manager.APIRequest;
import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 *  The {@code CoinbaseManager} class is useful to manage all Coinbase endpoints giving basics methods for others Coinbase managers
 *  @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/docs
 *  @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseManager {

    /**Useful for workflow of library**/
    public static final String BASE_ENDPOINT = "https://api.exchange.coinbase.com";
    protected static final String CB_ACCESS_KEY = "cb-access-key";
    protected static final String CB_ACCESS_SIGN = "cb-access-sign";
    protected static final String CB_ACCESS_TIMESTAMP = "cb-access-timestamp";
    protected static final String CB_ACCESS_PASSPHRASE = "cb-access-passphrase";
    protected final HashMap<String, String> headers;
    protected final APIRequest apiRequest;
    private final String apiSecret;
    private final String passphrase;
    private final String apiKey;
    protected JSONObject jsonObject;
    protected JSONArray jsonArray;
    protected JsonHelper jsonHelper;
    private boolean keysInserted;

    /** Constructor to init a Coinbase manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        apiRequest = new APIRequest(defaultErrorMessage, timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Constructor to init a Coinbase manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        apiRequest = new APIRequest(timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Constructor to init a Coinbase manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        apiRequest = new APIRequest(defaultErrorMessage);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Constructor to init a Coinbase manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseManager(String apiKey, String apiSecret, String passphrase) {
        apiRequest = new APIRequest();
        this.apiKey = apiKey;
        this.passphrase = passphrase;
        this.apiSecret = apiSecret;
        headers = new HashMap<>();
        keysInserted = false;
    }

    /** Method to execute and get response of a request
     * @param #endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param #method: method HTTP for the request
     * @return response as {@link String}
     * **/
    public String sendAPIRequest(String endpoint, String method) throws Exception {
        setRequestHeaders(method, endpoint, null);
        apiRequest.sendAPIRequest(BASE_ENDPOINT+endpoint, method, headers);
        return apiRequest.getResponse();
    }

    /** Method to execute and get response of a POST http request
     * @param #endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param #bodyParams: params to insert in the http body post request
     * @return response as {@link String}
     * **/
    public String sendBodyParamsAPIRequest(String endpoint, String method, HashMap<String, Object> bodyParams) throws Exception {
        if(method.equals(APIRequest.POST_METHOD) || method.equals(APIRequest.PUT_METHOD)){
            setRequestHeaders(method, endpoint, apiRequest.assembleBodyParams(bodyParams));
            apiRequest.sendPostAPIRequest(BASE_ENDPOINT+endpoint,bodyParams);
            return apiRequest.getResponse();
        }else
            throw new IllegalArgumentException("Methods allowed for this request are POST and PUT method");
    }

    /** Method to set Coinbase request headers
     * @param #endpoint: endpoint for the request and its query params es endpoint?param=paramValue
     * @param #method: method HTTP for the request
     * @param #body: only if request has a body params (generally POST request)
     * any return
     * **/
    private void setRequestHeaders(String method, String endpoint, String body) throws Exception {
        String timestamp = "" + System.currentTimeMillis()/1000;
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
     * @param #queryParams: value and key of query params to assemble
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

}
