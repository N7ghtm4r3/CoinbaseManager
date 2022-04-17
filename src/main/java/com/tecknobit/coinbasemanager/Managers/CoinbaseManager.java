package com.tecknobit.coinbasemanager.Managers;

import com.tecknobit.apimanager.Manager.APIRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Base64.getEncoder;

public class CoinbaseManager {

    //https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts

    public static final String BASE_ENDPOINT = "https://api.exchange.coinbase.com";
    protected static final String CB_ACCESS_KEY = "CB-ACCESS-KEY";
    protected static final String CB_ACCESS_SIGN = "CB-ACCESS-SIGN";
    protected static final String CB_ACCESS_TIMESTAMP = "CB-ACCESS-TIMESTAMP";
    protected static final String CB_ACCESS_PASSPHRASE = "CB-ACCESS-PASSPHRASE";
    protected final HashMap<String, String> headers;
    protected final APIRequest apiRequest;
    private final String passphrase;
    private final String apiSecret;
    private final String base64apiSecret;
    private final String apiKey;
    private boolean keysInserted;

    public CoinbaseManager(String apiKey, String apiSecret,  String passphrase, String defaultErrorMessage, int timeout) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        base64apiSecret = new String(Base64.getDecoder().decode(apiSecret.getBytes()));
        headers = new HashMap<>();
        keysInserted = false;
        apiRequest = new APIRequest(defaultErrorMessage, timeout);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        base64apiSecret = new String(Base64.getDecoder().decode(apiSecret.getBytes()));
        headers = new HashMap<>();
        keysInserted = false;
        apiRequest = new APIRequest(timeout);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        base64apiSecret = new String(Base64.getDecoder().decode(apiSecret.getBytes()));
        headers = new HashMap<>();
        keysInserted = false;
        apiRequest = new APIRequest(defaultErrorMessage);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase) {
        this.apiKey = apiKey;
        this.passphrase = passphrase;
        this.apiSecret = apiSecret;
        base64apiSecret = new String(Base64.getDecoder().decode(apiSecret.getBytes()));
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
        headers.put(CB_ACCESS_SIGN, getBase64Signature(timestamp + method + endpoint + params));
        headers.put(CB_ACCESS_TIMESTAMP, timestamp);
    }

    private String getBase64Signature(String data) throws Exception {
        Mac sha256 = Mac.getInstance("HmacSHA256");
        sha256.init(new SecretKeySpec(base64apiSecret.getBytes(), "HmacSHA256"));
        return getEncoder().encodeToString(sha256.doFinal(data.replace("?","").getBytes(UTF_8)));
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
