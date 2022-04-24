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
import static com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records.Order.*;

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
        if(areValidStatuses(statuses)){
            if(isValidSorter(sortedBy)) {
                if(isValidSortingOrder(sorting)){
                    String statusesParams = apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
                    return sendAPIRequest(ORDERS_ENDPOINT +"?limit="+limit+statusesParams, GET_METHOD);
                }
                throw new IllegalArgumentException("sorting can be desc or asc");
            }
            throw new IllegalArgumentException("sorted_by can be created_at,price,size,order_id,side or type");
        }
        throw new IllegalArgumentException("Status can be open,received,rejected,done,active,pending or all");
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
        if(areValidStatuses(statuses)){
            if(isValidSorter(sortedBy)) {
                if(isValidSortingOrder(sorting)){
                    String params = "?limit="+limit+apiRequest.concatenateParamsList("&","status",
                            new ArrayList<>(statuses));
                    return sendAPIRequest(ORDERS_ENDPOINT +assembleQueryParams(params,queryParams), GET_METHOD);
                }
                throw new IllegalArgumentException("sorting can be desc or asc");
            }
            throw new IllegalArgumentException("sorted_by can be created_at,price,size,order_id,side or type");
        }
        throw new IllegalArgumentException("Status can be open,received,rejected,done,active,pending or all");
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

    private boolean areValidStatuses(ArrayList<String> statuses){
        for (String status : statuses) {
            if(!status.equals(STATUS_OPEN) && !status.equals(STATUS_RECEIVED) && !status.equals(STATUS_REJECTED)
                    && !status.equals(STATUS_DONE) && !status.equals(STATUS_ACTIVE) && !status.equals(STATUS_PENDING)
                    && !status.equals(STATUS_ALL)){
                return false;
            }
        }
        return true;
    }

    private boolean isValidSorter(String sortedBy) {
        return sortedBy.equals(SIDE_SORTER) || sortedBy.equals(SIZE_SORTER) || sortedBy.equals(TYPE_SORTER)
                || sortedBy.equals(PRICE_SORTER) || sortedBy.equals(CREATED_AT_SORTER) || sortedBy.equals(ORDER_ID_SORTER);
    }

    private boolean isValidSortingOrder(String sorting) {
        return sorting.equals(ASC_SORTING_ORDER) || sorting.equals(DESC_SORTING_ORDER);
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

}
