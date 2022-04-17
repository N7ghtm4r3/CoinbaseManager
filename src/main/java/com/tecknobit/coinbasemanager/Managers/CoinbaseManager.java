package com.tecknobit.coinbasemanager.Managers;

import com.tecknobit.apimanager.Manager.APIRequest;

import java.time.LocalDate;
import java.util.HashMap;

public class CoinbaseManager {

    //https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts

    public static final String BASE_ENDPOINT = "https://api.exchange.coinbase.com";
    protected static final String CB_ACCESS_KEY = "CB-ACCESS-KEY";
    protected static final String CB_ACCESS_SIGN = "CB-ACCESS-SIGN";
    protected static final String CB_ACCESS_TIMESTAMP = "CB-ACCESS-TIMESTAMP";
    protected static final String CB_ACCESS_PASSPHRASE = "CB-ACCESS-PASSPHRASE";
    protected static final String CB_VERSION = "CB-VERSION";
    protected final HashMap<String, String> headers;
    protected final APIRequest apiRequest;
    private final String passphrase;
    private final String apiSecret;
    private final String apiKey;
    private boolean keysInserted;

    public CoinbaseManager(String apiKey, String apiSecret,  String passphrase, String defaultErrorMessage, int timeout) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
        apiRequest = new APIRequest(defaultErrorMessage, timeout);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
        apiRequest = new APIRequest(timeout);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
        apiRequest = new APIRequest(defaultErrorMessage);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase) {
        this.apiKey = apiKey;
        this.passphrase = passphrase;
        this.apiSecret = apiSecret;
        headers = new HashMap<>();
        keysInserted = false;
        apiRequest = new APIRequest();
    }

    public String sendAPIRequest(String endpoint, String params, String method) throws Exception {
        setRequestHeaders(method, endpoint, params);
        apiRequest.sendAPIRequest(BASE_ENDPOINT+endpoint+params, method, headers);
        return apiRequest.getResponse();
    }

    private void setRequestHeaders(String method, String endpoint, String params) throws Exception {
        String timestamp = "" + System.currentTimeMillis()/1000;
        if(!keysInserted){
            headers.put("Content-Type","application/json");
            headers.put(CB_ACCESS_KEY, apiKey);
            headers.put(CB_ACCESS_PASSPHRASE, passphrase);
            keysInserted = true;
        }
        headers.put(CB_ACCESS_SIGN, apiRequest.getSignature(apiSecret, timestamp + method + endpoint + params));
        headers.put(CB_ACCESS_TIMESTAMP, timestamp);
        headers.put(CB_VERSION, LocalDate.now().toString());
    }

    public String getErrorResponse(){
        return apiRequest.getErrorResponse();
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

}
