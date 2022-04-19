package com.tecknobit.coinbasemanager.Managers;

import com.tecknobit.apimanager.Manager.APIRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;

public class CoinbaseManager {

    //https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts

    public static final String BASE_ENDPOINT = "https://api.exchange.coinbase.com";
    protected static final String CB_ACCESS_KEY = "cb-access-key";
    protected static final String CB_ACCESS_SIGN = "cb-access-sign";
    protected static final String CB_ACCESS_TIMESTAMP = "cb-access-timestamp";
    protected static final String CB_ACCESS_PASSPHRASE = "cb-access-passphrase";
    protected JSONArray jsonArray;
    protected JSONObject jsonObject;
    protected final HashMap<String, String> headers;
    protected final APIRequest apiRequest;
    private final byte[] signatureKey;
    private final String passphrase;
    private final String apiSecret;
    private final String apiKey;
    private boolean keysInserted;

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        apiRequest = new APIRequest(defaultErrorMessage, timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
        signatureKey = Base64.getDecoder().decode(apiSecret);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        apiRequest = new APIRequest(timeout);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
        signatureKey = Base64.getDecoder().decode(apiSecret);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        apiRequest = new APIRequest(defaultErrorMessage);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.passphrase = passphrase;
        headers = new HashMap<>();
        keysInserted = false;
        signatureKey = Base64.getDecoder().decode(apiSecret);
    }

    public CoinbaseManager(String apiKey, String apiSecret, String passphrase) {
        apiRequest = new APIRequest();
        this.apiKey = apiKey;
        this.passphrase = passphrase;
        this.apiSecret = apiSecret;
        headers = new HashMap<>();
        keysInserted = false;
        signatureKey = Base64.getDecoder().decode(apiSecret);
    }

    public String sendAPIRequest(String endpoint, String method) throws Exception {
        setRequestHeaders(method, endpoint, null);
        apiRequest.sendAPIRequest(BASE_ENDPOINT+endpoint, method, headers);
        return apiRequest.getResponse();
    }

    public String sendPostAPIRequest(String endpoint, String method, String bodyParams) throws Exception {
        setRequestHeaders(method, endpoint, bodyParams);
        apiRequest.sendAPIRequest(BASE_ENDPOINT+endpoint, method, headers);
        return apiRequest.getResponse();
    }

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
        headers.put(CB_ACCESS_SIGN, getCoinbaseSign(stringToSign));
        headers.put(CB_ACCESS_TIMESTAMP, timestamp);
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

    private String getCoinbaseSign(String data) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(signatureKey, "HmacSHA256"));
        return Base64.getEncoder().encodeToString(mac.doFinal(data.getBytes()));
    }

    protected String assembleQueryParams(HashMap<String, Object> extraParams){
        return apiRequest.assembleAdditionalParams("?", extraParams).replaceFirst("&","");
    }

}
