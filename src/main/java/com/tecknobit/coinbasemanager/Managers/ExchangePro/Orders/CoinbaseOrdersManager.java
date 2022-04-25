package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records.Fill;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records.Order;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.*;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.GET_ALL_FILLS_ENDPOINT;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.ORDERS_ENDPOINT;

/**
 *  The {@code CoinbaseOrdersManager} class is useful to manage all Coinbase orders endpoints
 *  @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
 *  @author N7ghtm4r3 - Tecknobit
 * **/

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

    /** Request to get all filled orders
     * @param #orderId: identifier of order from get fill details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link String}
     * **/
    public String getAllFillsByOrderId(String orderId) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+"?order_id="+orderId, GET_METHOD);
    }

    /** Request to get all filled orders
     * @param #orderId: identifier of order from get fill details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByOrderIdJSON(String orderId) throws Exception {
        return new JSONArray(getAllFillsByOrderId(orderId));
    }

    /** Request to get all filled orders
     * @param #orderId: identifier of order from get fill details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByOrderId(String orderId) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByOrderId(orderId)));
    }

    /** Request to get all filled orders
     * @param #orderId: identifier of order from get fill details
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are product_id,profile_id,before,after,limit)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link String}
     * **/
    public String getAllFillsByOrderId(String orderId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+assembleQueryParams("?order_id="+orderId,
                        queryParams), GET_METHOD);
    }

    /** Request to get all filled orders
     * @param #orderId: identifier of order from get fill details
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are product_id,profile_id,before,after,limit)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByOrderIdJSON(String orderId, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllFillsByOrderId(orderId, queryParams));
    }

    /** Request to get all filled orders
     * @param #orderId: identifier of order from get fill details
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are product_id,profile_id,before,after,limit)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByOrderId(String orderId, HashMap<String, Object> queryParams) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByOrderId(orderId, queryParams)));
    }

    /** Request to get all filled orders
     * @param #productId: identifier of product to get details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link String}
     * **/
    public String getAllFillsByProductId(String productId) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+"?product_id="+productId, GET_METHOD);
    }

    /** Request to get all filled orders
     * @param #productId: identifier of product to get details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByProductIdJSON(String productId) throws Exception {
        return new JSONArray(getAllFillsByProductId(productId));
    }

    /** Request to get all filled orders
     * @param #productId: identifier of product to get details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByProductId(String productId) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByProductId(productId)));
    }

    /** Request to get all filled orders
     * @param #productId: identifier of product to get details
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are order_id,profile_id,before,after,limit)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link String}
     * **/
    public String getAllFillsByProductId(String productId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT+assembleQueryParams("?product_id="+productId,
                        queryParams), GET_METHOD);
    }

    /** Request to get all filled orders
     * @param #productId: identifier of product to get details
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are order_id,profile_id,before,after,limit)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByProductIdJSON(String productId, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllFillsByProductId(productId, queryParams));
    }

    /** Request to get all filled orders
     * @param #productId: identifier of product to get details
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are order_id,profile_id,before,after,limit)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
     * @return all filled orders as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByProductId(String productId, HashMap<String, Object> queryParams) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByProductId(productId, queryParams)));
    }

    /** Method to assemble a fills list
     * @param #jsonFills: jsonArray obtained by response request
     * @return fills list as {@link ArrayList} of {@link Fill}
     * **/
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
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT + params, GET_METHOD);
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
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT + assembleQueryParams(params, queryParams), GET_METHOD);
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
            orders.add(assembleOrderObject(jsonOrders.getJSONObject(j)));
        return orders;
    }

    private HashMap<String, Object> assembleSortCriteria(String sortedBy, String sorting){
        HashMap<String, Object> criteria = new HashMap<>();
        criteria.put("sortedBy", sortedBy);
        criteria.put("sorting", sorting);
        return criteria;
    }

    private Order assembleOrderObject(JSONObject jsonOrder){
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

    public String createLimitOrder(String side, String productId, double price, double size) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleOrderPayload(side, productId, price,
                size, Order.LIMIT_TYPE));
    }

    public JSONObject createNewLimitOrderJSON(String side, String productId, double price, double size) throws Exception {
        return new JSONObject(createLimitOrder(side, productId, price, size));
    }

    public Order createNewLimitOrderObject(String side, String productId, double price, double size) throws Exception {
        return assembleOrderObject(new JSONObject(createLimitOrder(side, productId, price, size)));
    }

    public String createLimitOrder(String side, String productId, double price, double size,
                                   HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleOrderPayload(side, productId, price, size, Order.LIMIT_TYPE);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createNewLimitOrderJSON(String side, String productId, double price, double size,
                                              HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createLimitOrder(side, productId, price, size, extraBodyParams));
    }

    public Order createNewLimitOrderObject(String side, String productId, double price, double size,
                                           HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createLimitOrder(side, productId, price, size, extraBodyParams)));
    }

    private HashMap<String, Object> assembleOrderPayload(String side, String productId, double price, double size,
                                                         String type){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("side", side);
        bodyParams.put("product_id", productId);
        bodyParams.put("price", price);
        bodyParams.put("size", size);
        bodyParams.put("type", type);
        return bodyParams;
    }

    public String createMarketOrderSize(String side, String productId, double size) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleMarketOrderPayload(side, productId,
                "size", size));
    }

    public JSONObject createMarketOrderSizeJSON(String side, String productId, double size) throws Exception {
        return new JSONObject(createMarketOrderSize(side, productId, size));
    }

    public Order createMarketOrderSizeObject(String side, String productId, double size) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderSize(side, productId, size)));
    }

    public String createMarketOrderSize(String side, String productId, double size,
                                        HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleMarketOrderPayload(side, productId, "size", size);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createMarketOrderSizeJSON(String side, String productId, double size,
                                                HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createMarketOrderSize(side, productId, size, extraBodyParams));
    }

    public Order createMarketOrderSizeObject(String side, String productId, double size,
                                             HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderSize(side, productId, size, extraBodyParams)));
    }

    public String createMarketOrderFounds(String side, String productId, double founds) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleMarketOrderPayload(side, productId,
                "founds", founds));
    }

    public JSONObject createMarketOrderFoundsJSON(String side, String productId, double founds) throws Exception {
        return new JSONObject(createMarketOrderFounds(side, productId, founds));
    }

    public Order createMarketOrderFoundsObject(String side, String productId, double founds) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderFounds(side, productId, founds)));
    }

    public String createMarketOrderFounds(String side, String productId, double founds,
                                          HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleMarketOrderPayload(side, productId, "founds", founds);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createMarketOrderFoundsJSON(String side, String productId, double founds,
                                               HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createMarketOrderFounds(side, productId, founds, extraBodyParams));
    }

    public Order createMarketOrderFoundsObject(String side, String productId, double founds,
                                            HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderFounds(side, productId, founds, extraBodyParams)));
    }

    private HashMap<String, Object> assembleMarketOrderPayload(String side, String productId, String key, double keyValue){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("side", side);
        bodyParams.put("product_id", productId);
        bodyParams.put(key, keyValue);
        bodyParams.put("type", Order.MARKET_TYPE);
        return bodyParams;
    }

    public String createStopOrder(String side, String productId, double price, double size,
                                  double stopPrice) throws Exception {
        HashMap<String, Object> bodyParams = assembleOrderPayload(side, productId, price, size, Order.STOP_TYPE);
        bodyParams.put("stop_price", stopPrice);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createStopOrderJSON(String side, String productId, double price, double size,
                                          double stopPrice) throws Exception {
        return new JSONObject(createStopOrder(side, productId, price, size, stopPrice));
    }

    public Order createStopOrderObject(String side, String productId, double price, double size,
                                       double stopPrice) throws Exception {
        return assembleOrderObject(new JSONObject(createStopOrder(side, productId, price, size, stopPrice)));
    }

    public String createStopOrder(String side, String productId, double price, double size, double stopPrice,
                                  HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleOrderPayload(side, productId, price, size, Order.STOP_TYPE);
        bodyParams.put("stop_price", stopPrice);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createStopOrderJSON(String side, String productId, double price, double size, double stopPrice,
                                          HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createStopOrder(side, productId, price, size, stopPrice, extraBodyParams));
    }

    public Order createStopOrderObject(String side, String productId, double price, double size, double stopPrice,
                                       HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createStopOrder(side, productId, price, size, stopPrice, extraBodyParams)));
    }

    public String getSingleOrder(String orderId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+"/order_id="+orderId, GET_METHOD);
    }

    public JSONObject getSingleOrderJSON(String orderId) throws Exception {
        return new JSONObject(getSingleOrder(orderId));
    }

    public Order getSingleOrderObject(String orderId) throws Exception {
        return assembleOrderObject(new JSONObject(getSingleOrder(orderId)));
    }

    public String cancelOrder(String orderId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+"/order_id="+orderId, DELETE_METHOD);
    }

    public String cancelOrder(String orderId, String profileId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+"/order_id="+orderId+"?profile_id="+profileId, DELETE_METHOD);
    }

}
