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
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
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
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
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

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses) throws Exception {
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT + params, GET_METHOD);
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting,
                                      ArrayList<String> statuses) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders list as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting,
                                             ArrayList<String> statuses) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses)));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(Arrays.asList(statuses)));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders list as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses)));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,before,after,start_date,end_date,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                               HashMap<String, Object> queryParams) throws Exception {
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT + assembleQueryParams(params, queryParams), GET_METHOD);
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,before,after,start_date,end_date,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                      HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,before,after,start_date,end_date,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                             HashMap<String, Object> queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams)));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,before,after,start_date,end_date,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String[] statuses,
                               HashMap<String, Object> queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(Arrays.asList(statuses)), queryParams);
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,before,after,start_date,end_date,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String[] statuses,
                                      HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams));
    }

    /** Request to get all orders
     * @param #limit: number of returns
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @param #statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,before,after,start_date,end_date,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String[] statuses,
                                             HashMap<String, Object> queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams)));
    }

    /** Method to assemble an orders list
     * @param #jsonOrders: jsonArray obtained by response request
     * @return orders list as {@link ArrayList} of {@link Order}
     * **/
    private ArrayList<Order> assembleOrdersList(JSONArray jsonOrders){
        ArrayList<Order> orders = new ArrayList<>();
        for (int j = 0; j < jsonOrders.length(); j++)
            orders.add(assembleOrderObject(jsonOrders.getJSONObject(j)));
        return orders;
    }

    /** Method to assemble map of sorting criteria
     * @param #sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param #sorting: ascending or descending order criteria (asc or desc)
     * @return map of sorting criteria params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private HashMap<String, Object> assembleSortCriteria(String sortedBy, String sorting){
        HashMap<String, Object> criteria = new HashMap<>();
        criteria.put("sortedBy", sortedBy);
        criteria.put("sorting", sorting);
        return criteria;
    }

    /** Method to assemble an Order object
     * @param #jsonOrder: jsonObject obtained by response request
     * @return order as {@link Order} object
     * **/
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

    /** Request to cancel all orders
     * any params required
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders
     * @return result list of cancelled id orders as {@link String}
     * **/
    public String cancelAllOpenOrders() throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT, DELETE_METHOD);
    }

    /** Request to cancel all orders
     * any params required
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders
     * @return result list of cancelled id orders as {@link JSONArray}
     * **/
    public JSONArray cancelAllOpenOrdersJSON() throws Exception {
        return new JSONArray(cancelAllOpenOrders());
    }

    /** Request to cancel all orders
     * any params required
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders
     * @return result list of cancelled id orders as {@link ArrayList} of {@link String}
     * **/
    public ArrayList<String> cancelAllOpenOrdersList() throws Exception {
        return assembleCancelOrdersList(new JSONArray(cancelAllOpenOrders()));
    }

    /** Request to cancel all orders
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders
     * @return result list of cancelled id orders as {@link String}
     * **/
    public String cancelAllOpenOrders(HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+assembleQueryParams("",queryParams), DELETE_METHOD);
    }

    /** Request to cancel all orders
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders
     * @return result list of cancelled id orders as {@link JSONArray}
     * **/
    public JSONArray cancelAllOpenOrdersJSON(HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(cancelAllOpenOrders(queryParams));
    }

    /** Request to cancel all orders
     * @param #queryParams: query params of request
     * @implSpec (keys accepted are profile_id,product_id)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders
     * @return result list of cancelled id orders as {@link ArrayList} of {@link String}
     * **/
    public ArrayList<String> cancelAllOpenOrdersList(HashMap<String, Object> queryParams) throws Exception {
        return assembleCancelOrdersList(new JSONArray(cancelAllOpenOrders(queryParams)));
    }

    /** Method to assemble a cancelled id orders list
     * @param #jsonOrders: jsonArray obtained by response request
     * @return cancelled id orders list as {@link ArrayList} of {@link String}
     * **/
    private ArrayList<String> assembleCancelOrdersList(JSONArray jsonOrders){
        ArrayList<String> ordersId = new ArrayList<>();
        for (int j = 0; j < jsonOrders.length(); j++)
            ordersId.add(jsonOrders.getString(j));
        return ordersId;
    }

    /** Request to create new limit order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createLimitOrder(String side, String productId, double price, double size) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleOrderPayload(side, productId, price,
                size, Order.LIMIT_TYPE));
    }

    /** Request to create new limit order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createNewLimitOrderJSON(String side, String productId, double price, double size) throws Exception {
        return new JSONObject(createLimitOrder(side, productId, price, size));
    }

    /** Request to create new limit order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createNewLimitOrderObject(String side, String productId, double price, double size) throws Exception {
        return assembleOrderObject(new JSONObject(createLimitOrder(side, productId, price, size)));
    }

    /** Request to create new limit order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createLimitOrder(String side, String productId, double price, double size,
                                   HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleOrderPayload(side, productId, price, size, Order.LIMIT_TYPE);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new limit order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createNewLimitOrderJSON(String side, String productId, double price, double size,
                                              HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createLimitOrder(side, productId, price, size, extraBodyParams));
    }

    /** Request to create new limit order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createNewLimitOrderObject(String side, String productId, double price, double size,
                                           HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createLimitOrder(side, productId, price, size, extraBodyParams)));
    }

    /** Method to assemble a payload for limit and stop order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #type: type of the order (limit or stop)
     * @return payload for a new order as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
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

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #size: amount of base currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderSize(String side, String productId, double size) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleMarketOrderPayload(side, productId,
                "size", size));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #size: amount of base currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderSizeJSON(String side, String productId, double size) throws Exception {
        return new JSONObject(createMarketOrderSize(side, productId, size));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #size: amount of base currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link Order} object
     * **/
    public Order createMarketOrderSizeObject(String side, String productId, double size) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderSize(side, productId, size)));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #size: amount of base currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid,funds)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderSize(String side, String productId, double size,
                                        HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleMarketOrderPayload(side, productId, "size", size);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #size: amount of base currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid,funds)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderSizeJSON(String side, String productId, double size,
                                                HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createMarketOrderSize(side, productId, size, extraBodyParams));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #size: amount of base currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid,funds)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link Order}
     * **/
    public Order createMarketOrderSizeObject(String side, String productId, double size,
                                             HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderSize(side, productId, size, extraBodyParams)));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #founds: amount of quote currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderFounds(String side, String productId, double founds) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleMarketOrderPayload(side, productId,
                "founds", founds));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #founds: amount of quote currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderFoundsJSON(String side, String productId, double founds) throws Exception {
        return new JSONObject(createMarketOrderFounds(side, productId, founds));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #founds: amount of quote currency used in the order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link Order} object
     * **/
    public Order createMarketOrderFoundsObject(String side, String productId, double founds) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderFounds(side, productId, founds)));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #founds: amount of quote currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid,size)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderFounds(String side, String productId, double founds,
                                          HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleMarketOrderPayload(side, productId, "founds", founds);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #founds: amount of quote currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid,size)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderFoundsJSON(String side, String productId, double founds,
                                               HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createMarketOrderFounds(side, productId, founds, extraBodyParams));
    }

    /** Request to create new market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #founds: amount of quote currency used in the order
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,post_only,client_oid,size)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new market order as {@link Order} object
     * **/
    public Order createMarketOrderFoundsObject(String side, String productId, double founds,
                                            HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createMarketOrderFounds(side, productId, founds, extraBodyParams)));
    }

    /** Method to assemble a payload for market order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #key: size of funds parameter
     * @param #keyValue: value of key
     * @return payload for a new market order as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private HashMap<String, Object> assembleMarketOrderPayload(String side, String productId, String key, double keyValue){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("side", side);
        bodyParams.put("product_id", productId);
        bodyParams.put(key, keyValue);
        bodyParams.put("type", Order.MARKET_TYPE);
        return bodyParams;
    }

    /** Request to create new stop order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #stopPrice: price when stop order will be placed on the book
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createStopOrder(String side, String productId, double price, double size,
                                  double stopPrice) throws Exception {
        HashMap<String, Object> bodyParams = assembleOrderPayload(side, productId, price, size, Order.STOP_TYPE);
        bodyParams.put("stop_price", stopPrice);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new stop order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #stopPrice: price when stop order will be placed on the book
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createStopOrderJSON(String side, String productId, double price, double size,
                                          double stopPrice) throws Exception {
        return new JSONObject(createStopOrder(side, productId, price, size, stopPrice));
    }

    /** Request to create new stop order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #stopPrice: price when stop order will be placed on the book
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createStopOrderObject(String side, String productId, double price, double size,
                                       double stopPrice) throws Exception {
        return assembleOrderObject(new JSONObject(createStopOrder(side, productId, price, size, stopPrice)));
    }

    /** Request to create new stop order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #stopPrice: price when stop order will be placed on the book
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,client_oid)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createStopOrder(String side, String productId, double price, double size, double stopPrice,
                                  HashMap<String ,Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleOrderPayload(side, productId, price, size, Order.STOP_TYPE);
        bodyParams.put("stop_price", stopPrice);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new stop order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #stopPrice: price when stop order will be placed on the book
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,client_oid)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createStopOrderJSON(String side, String productId, double price, double size, double stopPrice,
                                          HashMap<String ,Object> extraBodyParams) throws Exception {
        return new JSONObject(createStopOrder(side, productId, price, size, stopPrice, extraBodyParams));
    }

    /** Request to create new stop order
     * @param #side: side of the order (buy or sell)
     * @param #productId: identifier of product to buy or sell es. BTC-USD
     * @param #price: price per unit of product es. price for one unit of BTC in USD base
     * @param #size: amount of base currency used in the order
     * @param #stopPrice: price when stop order will be placed on the book
     * @param #extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id,time_in_force,cancel_after,stp,stop,client_oid)
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createStopOrderObject(String side, String productId, double price, double size, double stopPrice,
                                       HashMap<String ,Object> extraBodyParams) throws Exception {
        return assembleOrderObject(new JSONObject(createStopOrder(side, productId, price, size, stopPrice, extraBodyParams)));
    }

    /** Request to get single order information
     * @param #orderId: identifier of order from fetch details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of single order information as {@link String}
     * **/
    public String getSingleOrder(String orderId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+"/order_id="+orderId, GET_METHOD);
    }

    /** Request to get single order information
     * @param #orderId: identifier of order from fetch details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of single order information as {@link JSONObject}
     * **/
    public JSONObject getSingleOrderJSON(String orderId) throws Exception {
        return new JSONObject(getSingleOrder(orderId));
    }

    /** Request to get single order information
     * @param #orderId: identifier of order from fetch details
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of single order information as {@link Order} object
     * **/
    public Order getSingleOrderObject(String orderId) throws Exception {
        return assembleOrderObject(new JSONObject(getSingleOrder(orderId)));
    }

    /** Request to cancel an order
     * @param #orderId: identifier of order to cancel
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of order cancellation as {@link String}
     * **/
    public String cancelOrder(String orderId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+"/order_id="+orderId, DELETE_METHOD);
    }

    /** Request to get an order
     * @param #orderId: identifier of order to cancel
     * @param #profileId: identifier of account where delete an order
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
     * @return result of order cancellation as {@link String}
     * **/
    public String cancelOrder(String orderId, String profileId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT+"/order_id="+orderId+"?profile_id="+profileId, DELETE_METHOD);
    }

}
