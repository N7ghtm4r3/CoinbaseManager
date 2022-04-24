package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records.Fill;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records.Order;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.DELETE_METHOD;
import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.GET_ALL_FILLS_ENDPOINT;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.ORDERS_ENDPOINT;

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
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+assembleQueryParams("?order_id="+orderId,
                        queryParams), GET_METHOD);
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
                    fill.getString("product_id"),
                    fill.getString("profile_id"),
                    fill.getDouble("price"),
                    fill.getDouble("size"),
                    fill.getString("side"),
                    fill.getBoolean("settled"),
                    fill.getLong("trade_id"),
                    fill.getString("order_id"),
                    fill.getString("user_id"),
                    fill.getString("liquidity"),
                    fill.getDouble("fee"),
                    fill.getDouble("usd_volume")
            ));
        }

        return fills;
    }

    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses) throws Exception {
        String statusesParams = apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT +"?limit="+limit+statusesParams, GET_METHOD);
    }

    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting,
                                      ArrayList<String> statuses) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses));
    }

    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting,
                                             ArrayList<String> statuses) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses)));
    }

    public String getAllOrders(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(Arrays.asList(statuses)));
    }

    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses));
    }

    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses)));
    }

    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                               HashMap<String, Object> queryParams) throws Exception {
        String params = "?limit="+limit+apiRequest.concatenateParamsList("&","status",
                new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT +assembleQueryParams(params,queryParams), GET_METHOD);
    }

    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                      HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams));
    }

    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                             HashMap<String, Object> queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams)));
    }

    public String getAllOrders(int limit, String sortedBy, String sorting, String[] statuses,
                               HashMap<String, Object> queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(Arrays.asList(statuses)), queryParams);
    }

    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String[] statuses,
                                      HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams));
    }

    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String[] statuses,
                                             HashMap<String, Object> queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams)));
    }

    private ArrayList<Order> assembleOrdersList(JSONArray jsonOrders){
        ArrayList<Order> orders = new ArrayList<>();
        for (int j = 0; j < jsonOrders.length(); j++)
            orders.add(assembleOrder(jsonOrders.getJSONObject(j)));
        return orders;
    }

    private Order assembleOrder(JSONObject jsonOrder){
        return new Order(jsonOrder.getString("created_at"),
                jsonOrder.getString("product_id"),
                jsonOrder.getString("profile_id"),
                jsonOrder.getDouble("price"),
                jsonOrder.getDouble("size"),
                jsonOrder.getString("side"),
                jsonOrder.getBoolean("settled"),
                jsonOrder.getString("id"),
                jsonOrder.getString("type"),
                jsonOrder.getString("time_in_force"),
                jsonOrder.getBoolean("post_only"),
                jsonOrder.getDouble("fill_fees"),
                jsonOrder.getDouble("filled_size"),
                jsonOrder.getDouble("executed_value"),
                jsonOrder.getString("status")
        );
    }

    public String cancelAllOpenOrders() throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT, DELETE_METHOD);
    }

    public JSONArray cancelAllOpenOrdersJSON() throws Exception {
        return new JSONArray(cancelAllOpenOrders());
    }

    public ArrayList<String> cancelAllOpenOrdersList() throws Exception {
        return assembleCancelOrdersLis(new JSONArray(cancelAllOpenOrders()));
    }

    public String cancelAllOpenOrders(HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+assembleQueryParams("",queryParams), DELETE_METHOD);
    }

    public JSONArray cancelAllOpenOrdersJSON(HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(cancelAllOpenOrders(queryParams));
    }

    public ArrayList<String> cancelAllOpenOrdersList(HashMap<String, Object> queryParams) throws Exception {
        return assembleCancelOrdersLis(new JSONArray(cancelAllOpenOrders(queryParams)));
    }

    private ArrayList<String> assembleCancelOrdersLis(JSONArray jsonOrders){
        ArrayList<String> ordersId = new ArrayList<>();
        for (int j = 0; j < jsonOrders.length(); j++)
            ordersId.add(jsonOrders.getString(j));
        return ordersId;
    }

    public String sendNewOrder(String type, String side, String productId, String stp, String stop,
                               String timeInForce, String cancelAfter, boolean postOnly){
        return null;
    }

}
