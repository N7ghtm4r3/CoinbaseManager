package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records.Fill;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.GET_ALL_FILLS_ENDPOINT;

public class CoinbaseOrdersManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseOrders manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseOrders manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseOrders manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseOrders manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String getAllFillsByOrderId(String orderId) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+"?order_id="+orderId, GET_METHOD);
    }

    public JSONArray getAllFillsByOrderIdJSON(String orderId) throws Exception {
        return new JSONArray(getAllFillsByOrderId(orderId));
    }

    public ArrayList<Fill> getAllFillsListByOrderId(String orderId) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByOrderId(orderId)));
    }

    public String getAllFillsByOrderId(String orderId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+assembleQueryParams("?order_id="+orderId,queryParams),
                GET_METHOD);
    }

    public JSONArray getAllFillsByOrderIdJSON(String orderId, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllFillsByOrderId(orderId, queryParams));
    }

    public ArrayList<Fill> getAllFillsListByOrderId(String orderId, HashMap<String, Object> queryParams) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByOrderId(orderId, queryParams)));
    }

    public String getAllFillsByProductId(String productId) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+"?product_id="+productId, GET_METHOD);
    }

    public JSONArray getAllFillsByProductIdJSON(String productId) throws Exception {
        return new JSONArray(getAllFillsByProductId(productId));
    }

    public ArrayList<Fill> getAllFillsListByProductId(String productId) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByProductId(productId)));
    }

    public String getAllFillsByProductId(String productId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+assembleQueryParams("?product_id="+productId,
                        queryParams), GET_METHOD);
    }

    public JSONArray getAllFillsByProductIdJSON(String productId, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllFillsByProductId(productId, queryParams));
    }

    public ArrayList<Fill> getAllFillsListByProductId(String productId, HashMap<String, Object> queryParams) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByProductId(productId, queryParams)));
    }

    private ArrayList<Fill> assembleFillsList(JSONArray jsonFills){
        ArrayList<Fill> fills = new ArrayList<>();
        for (int j = 0; j < jsonFills.length(); j++){
            JSONObject fill = jsonFills.getJSONObject(j);
            fills.add(new Fill(fill.getString("created_at"),
                    fill.getLong("trade_id"),
                    fill.getString("product_id"),
                    fill.getString("order_id"),
                    fill.getString("user_id"),
                    fill.getString("profile_id"),
                    fill.getString("liquidity"),
                    fill.getDouble("price"),
                    fill.getDouble("size"),
                    fill.getDouble("fee"),
                    fill.getString("side"),
                    fill.getBoolean("settled"),
                    fill.getDouble("usd_volume")
            ));
        }
        return fills;
    }

}
