package com.tecknobit.coinbasemanager.managers.exchangepro.orders;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.orders.records.Fill;
import com.tecknobit.coinbasemanager.managers.exchangepro.orders.records.Order;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.apis.APIRequest.*;
import static com.tecknobit.apimanager.formatters.ScientificNotationParser.sNotationParse;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.GET_ALL_FILLS_ENDPOINT;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.ORDERS_ENDPOINT;
import static java.util.Arrays.asList;

/**
 * The {@code CoinbaseOrdersManager} class is useful to manage all {@code "Coinbase"} orders endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
 * Orders manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseOrdersManager extends CoinbaseManager {

    /**
     * Constructor to init a CoinbaseOrders manager
     *
     * @param apiKey              your {@code "Coinbase"} api key
     * @param apiSecret           your {@code "Coinbase"} api secret
     * @param passphrase          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage custom error to show when is not a request error
     * @param timeout             custom timeout for request
     **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a CoinbaseOrders manager
     *
     * @param apiKey     your {@code "Coinbase"} api key
     * @param apiSecret  your {@code "Coinbase"} api secret
     * @param passphrase your {@code "Coinbase"} api passphrase
     * @param timeout    custom timeout for request
     **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a CoinbaseOrders manager
     *
     * @param apiKey              your {@code "Coinbase"} api key
     * @param apiSecret           your {@code "Coinbase"} api secret
     * @param passphrase          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage custom error to show when is not a request error
     **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a CoinbaseOrders manager
     *
     * @param apiKey     your {@code "Coinbase"} api key
     * @param apiSecret  your {@code "Coinbase"} api secret
     * @param passphrase your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseOrdersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseOrdersManager} <br>
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
    public CoinbaseOrdersManager() {
        super();
    }

    /**
     * Request to get all filled orders
     *
     * @param orderId: identifier of order from get fill details
     * @return all filled orders as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     **/
    public String getAllFillsByOrderId(String orderId) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT + "?order_id=" + orderId, GET_METHOD);
    }

    /** Request to get all filled orders
     * @param orderId: identifier of order from get fill details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByOrderIdJSON(String orderId) throws Exception {
        return new JSONArray(getAllFillsByOrderId(orderId));
    }

    /** Request to get all filled orders
     * @param orderId: identifier of order from get fill details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByOrderId(String orderId) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByOrderId(orderId)));
    }

    /** Request to get all filled orders
     * @param orderId: identifier of order from get fill details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are product_id, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders as {@link String}
     * **/
    public String getAllFillsByOrderId(String orderId, Params queryParams) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT + assembleQueryParams("?order_id=" + orderId,
                        queryParams), GET_METHOD);
    }

    /** Request to get all filled orders
     * @param orderId: identifier of order from get fill details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are product_id, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByOrderIdJSON(String orderId, Params queryParams) throws Exception {
        return new JSONArray(getAllFillsByOrderId(orderId, queryParams));
    }

    /** Request to get all filled orders
     * @param orderId: identifier of order from get fill details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are product_id, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByOrderId(String orderId, Params queryParams) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByOrderId(orderId, queryParams)));
    }

    /** Request to get all filled orders
     * @param productId: identifier of product to get details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders as {@link String}
     * **/
    public String getAllFillsByProductId(String productId) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT + "?product_id=" + productId, GET_METHOD);
    }

    /** Request to get all filled orders
     * @param productId: identifier of product to get details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByProductIdJSON(String productId) throws Exception {
        return new JSONArray(getAllFillsByProductId(productId));
    }

    /** Request to get all filled orders
     * @param productId: identifier of product to get details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByProductId(String productId) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByProductId(productId)));
    }

    /** Request to get all filled orders
     * @param productId: identifier of product to get details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are order_id, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders as {@link String}
     * **/
    public String getAllFillsByProductId(String productId, Params queryParams) throws Exception {
        return sendAPIRequest(GET_ALL_FILLS_ENDPOINT + assembleQueryParams("?product_id=" + productId,
                        queryParams), GET_METHOD);
    }

    /** Request to get all filled orders
     * @param productId: identifier of product to get details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are order_id, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders as {@link JSONArray}
     * **/
    public JSONArray getAllFillsByProductIdJSON(String productId, Params queryParams) throws Exception {
        return new JSONArray(getAllFillsByProductId(productId, queryParams));
    }

    /** Request to get all filled orders
     * @param productId: identifier of product to get details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are order_id, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * **/
    public ArrayList<Fill> getAllFillsListByProductId(String productId, Params queryParams) throws Exception {
        return assembleFillsList(new JSONArray(getAllFillsByProductId(productId, queryParams)));
    }

    /** Method to assemble a fills list
     * @param jsonFills: jsonArray obtained by response request
     * @return fills list as {@link ArrayList} of {@link Fill}
     * **/
    private ArrayList<Fill> assembleFillsList(JSONArray jsonFills){
        ArrayList<Fill> fills = new ArrayList<>();
        for (int j = 0; j < jsonFills.length(); j++)
            fills.add(new Fill(jsonFills.getJSONObject(j)));
        return fills;
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses) throws Exception {
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT + params, GET_METHOD);
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, ArrayList<String> statuses) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders list as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, ArrayList<String> statuses) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses)));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(statuses)));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String[]}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders list as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String[] statuses) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses)));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                               Params queryParams) throws Exception {
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&","status", new ArrayList<>(statuses));
        return sendAPIRequest(ORDERS_ENDPOINT + assembleQueryParams(params, queryParams), GET_METHOD);
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                      Params queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link ArrayList}
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                             Params queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams)));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String} array
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String[] statuses,
                               Params queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(statuses)), queryParams);
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String} array
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String[] statuses,
                                      Params queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams));
    }

    /** Request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String} array
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String[] statuses,
                                             Params queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, queryParams)));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String status) throws Exception {
        return getAllOrdersJSON(limit, sortedBy, sorting, status).toString();
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String status) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(status))));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String status) throws Exception {
        return assembleOrdersList(getAllOrdersJSON(limit, sortedBy, sorting, status));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String status,
                               Params queryParams) throws Exception {
        return getAllOrdersJSON(limit, sortedBy, sorting, status, queryParams).toString();
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String status,
                                      Params queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(status)), queryParams));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String status,
                                             Params queryParams) throws Exception {
        return assembleOrdersList(getAllOrdersJSON(limit, sortedBy, sorting, status, queryParams));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                               String productId) throws Exception {
        Params productIdPayload = new Params();
        productIdPayload.addParam("product_id", productId);
        return getAllOrders(limit, sortedBy, sorting, statuses, productIdPayload);
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                      String productId) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, productId));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                             String productId) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, productId)));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                               String productId, Params queryParams) throws Exception {
        Params productIdPayload = new Params();
        productIdPayload.addParam("product_id", productId);
        queryParams.mergeParams(productIdPayload);
        return getAllOrders(limit, sortedBy, sorting, statuses, queryParams);
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                      String productId, Params queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, productId, queryParams));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, ArrayList<String> statuses,
                                             String productId, Params queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, statuses, productId, queryParams)));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String status, String productId) throws Exception {
        Params productIdPayload = new Params();
        productIdPayload.addParam("product_id", productId);
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(status)), productIdPayload);
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String status, String productId) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, status, productId));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String status, String productId) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, status, productId)));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link String}
     * **/
    public String getAllOrders(int limit, String sortedBy, String sorting, String status, String productId,
                               Params queryParams) throws Exception {
        Params productIdPayload = new Params();
        productIdPayload.addParam("product_id", productId);
        queryParams.mergeParams(productIdPayload);
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(status)), queryParams);
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link JSONArray}
     * **/
    public JSONArray getAllOrdersJSON(int limit, String sortedBy, String sorting, String status, String productId,
                                      Params queryParams) throws Exception {
        return new JSONArray(getAllOrders(limit, sortedBy, sorting, status, productId, queryParams));
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * **/
    public ArrayList<Order> getAllOrdersList(int limit, String sortedBy, String sorting, String status, String productId,
                                             Params queryParams) throws Exception {
        return assembleOrdersList(new JSONArray(getAllOrders(limit, sortedBy, sorting, status, productId, queryParams)));
    }

    /** Method to assemble an orders list
     * @param jsonOrders: jsonArray obtained by response request
     * @return orders list as {@link ArrayList} of {@link Order}
     * **/
    private ArrayList<Order> assembleOrdersList(JSONArray jsonOrders){
        ArrayList<Order> orders = new ArrayList<>();
        for (int j = 0; j < jsonOrders.length(); j++)
            orders.add(new Order(jsonOrders.getJSONObject(j)));
        return orders;
    }

    /** Method to assemble map of sorting criteria
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @return map of sorting criteria params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assembleSortCriteria(String sortedBy, String sorting){
        Params criteria = new Params();
        criteria.addParam("sortedBy", sortedBy);
        criteria.addParam("sorting", sorting);
        return criteria;
    }

    /** Request to cancel all orders
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1</a>
     * @return result list of cancelled id orders as {@link String}
     * **/
    public String cancelAllOpenOrders() throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT, DELETE_METHOD);
    }

    /** Request to cancel all orders
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1</a>
     * @return result list of cancelled id orders as {@link JSONArray}
     * **/
    public JSONArray cancelAllOpenOrdersJSON() throws Exception {
        return new JSONArray(cancelAllOpenOrders());
    }

    /** Request to cancel all orders
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1</a>
     * @return result list of cancelled id orders as {@link ArrayList} of {@link String}
     * **/
    public ArrayList<String> cancelAllOpenOrdersList() throws Exception {
        return assembleCancelOrdersList(new JSONArray(cancelAllOpenOrders()));
    }

    /** Request to cancel all orders
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1</a>
     * @return result list of cancelled id orders as {@link String}
     * **/
    public String cancelAllOpenOrders(Params queryParams) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + queryParams.createQueryString(), DELETE_METHOD);
    }

    /** Request to cancel all orders
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1</a>
     * @return result list of cancelled id orders as {@link JSONArray}
     * **/
    public JSONArray cancelAllOpenOrdersJSON(Params queryParams) throws Exception {
        return new JSONArray(cancelAllOpenOrders(queryParams));
    }

    /** Request to cancel all orders
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1</a>
     * @return result list of cancelled id orders as {@link ArrayList} of {@link String}
     * **/
    public ArrayList<String> cancelAllOpenOrdersList(Params queryParams) throws Exception {
        return assembleCancelOrdersList(new JSONArray(cancelAllOpenOrders(queryParams)));
    }

    /** Method to assemble a cancelled id orders list
     * @param jsonOrders: jsonArray obtained by response request
     * @return cancelled id orders list as {@link ArrayList} of {@link String}
     * **/
    private ArrayList<String> assembleCancelOrdersList(JSONArray jsonOrders){
        ArrayList<String> ordersId = new ArrayList<>();
        for (int j = 0; j < jsonOrders.length(); j++)
            ordersId.add(jsonOrders.getString(j));
        return ordersId;
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createLimitOrder(String side, String productId, double price, double size) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleOrderPayload(side, productId, price,
                size, Order.LIMIT_TYPE));
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createNewLimitOrderJSON(String side, String productId, double price, double size) throws Exception {
        return new JSONObject(createLimitOrder(side, productId, price, size));
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createNewLimitOrderObject(String side, String productId, double price, double size) throws Exception {
        return new Order(new JSONObject(createLimitOrder(side, productId, price, size)));
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createLimitOrder(String side, String productId, double price, double size,
                                   Params extraBodyParams) throws Exception {
        Params bodyParams = assembleOrderPayload(side, productId, price, size, Order.LIMIT_TYPE);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createNewLimitOrderJSON(String side, String productId, double price, double size,
                                              Params extraBodyParams) throws Exception {
        return new JSONObject(createLimitOrder(side, productId, price, size, extraBodyParams));
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createNewLimitOrderObject(String side, String productId, double price, double size,
                                           Params extraBodyParams) throws Exception {
        return new Order(new JSONObject(createLimitOrder(side, productId, price, size, extraBodyParams)));
    }

    /** Method to assemble a payload for limit and stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param type: type of the order (limit or stop)
     * @return payload for a new order as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assembleOrderPayload(String side, String productId, double price, double size,
                                                         String type){
        Params bodyParams = new Params();
        bodyParams.addParam("side", side);
        bodyParams.addParam("product_id", productId);
        bodyParams.addParam("price", price);
        bodyParams.addParam("size", sNotationParse(8, size));
        bodyParams.addParam("type", type);
        return bodyParams;
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderSize(String side, String productId, double size) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleMarketOrderPayload(side, productId,
                "size", size));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderSizeJSON(String side, String productId, double size) throws Exception {
        return new JSONObject(createMarketOrderSize(side, productId, size));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link Order} object
     * **/
    public Order createMarketOrderSizeObject(String side, String productId, double size) throws Exception {
        return new Order(new JSONObject(createMarketOrderSize(side, productId, size)));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid, funds)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderSize(String side, String productId, double size,
                                        Params extraBodyParams) throws Exception {
        Params bodyParams = assembleMarketOrderPayload(side, productId, "size", size);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid, funds)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderSizeJSON(String side, String productId, double size,
                                                Params extraBodyParams) throws Exception {
        return new JSONObject(createMarketOrderSize(side, productId, size, extraBodyParams));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid, funds)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link Order}
     * **/
    public Order createMarketOrderSizeObject(String side, String productId, double size,
                                             Params extraBodyParams) throws Exception {
        return new Order(new JSONObject(createMarketOrderSize(side, productId, size, extraBodyParams)));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderFounds(String side, String productId, double founds) throws Exception {
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, assembleMarketOrderPayload(side, productId,
                "founds", founds));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderFoundsJSON(String side, String productId, double founds) throws Exception {
        return new JSONObject(createMarketOrderFounds(side, productId, founds));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link Order} object
     * **/
    public Order createMarketOrderFoundsObject(String side, String productId, double founds) throws Exception {
        return new Order(new JSONObject(createMarketOrderFounds(side, productId, founds)));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid, size)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link String}
     * **/
    public String createMarketOrderFounds(String side, String productId, double founds, Params extraBodyParams) throws Exception {
        Params bodyParams = assembleMarketOrderPayload(side, productId, "founds", founds);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid, size)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link JSONObject}
     * **/
    public JSONObject createMarketOrderFoundsJSON(String side, String productId, double founds, Params extraBodyParams) throws Exception {
        return new JSONObject(createMarketOrderFounds(side, productId, founds, extraBodyParams));
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, post_only, client_oid, size)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new market order as {@link Order} object
     * **/
    public Order createMarketOrderFoundsObject(String side, String productId, double founds, Params extraBodyParams) throws Exception {
        return new Order(new JSONObject(createMarketOrderFounds(side, productId, founds, extraBodyParams)));
    }

    /** Method to assemble a payload for market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param key: size of funds parameter
     * @param keyValue: value of key
     * @return payload for a new market order as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assembleMarketOrderPayload(String side, String productId, String key, double keyValue){
        Params bodyParams = new Params();
        bodyParams.addParam("side", side);
        bodyParams.addParam("product_id", productId);
        bodyParams.addParam(key, sNotationParse(8, keyValue));
        bodyParams.addParam("type", Order.MARKET_TYPE);
        return bodyParams;
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createStopOrder(String side, String productId, double price, double size,
                                  double stopPrice) throws Exception {
        Params bodyParams = assembleOrderPayload(side, productId, price, size, Order.STOP_TYPE);
        bodyParams.addParam("stop_price", stopPrice);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createStopOrderJSON(String side, String productId, double price, double size,
                                          double stopPrice) throws Exception {
        return new JSONObject(createStopOrder(side, productId, price, size, stopPrice));
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createStopOrderObject(String side, String productId, double price, double size,
                                       double stopPrice) throws Exception {
        return new Order(new JSONObject(createStopOrder(side, productId, price, size, stopPrice)));
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, client_oid)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link String}
     * **/
    public String createStopOrder(String side, String productId, double price, double size, double stopPrice,
                                  Params extraBodyParams) throws Exception {
        Params bodyParams = assembleOrderPayload(side, productId, price, size, Order.STOP_TYPE);
        bodyParams.addParam("stop_price", stopPrice);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(ORDERS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, client_oid)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link JSONObject}
     * **/
    public JSONObject createStopOrderJSON(String side, String productId, double price, double size, double stopPrice,
                                          Params extraBodyParams) throws Exception {
        return new JSONObject(createStopOrder(side, productId, price, size, stopPrice, extraBodyParams));
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, time_in_force, cancel_after, stp, stop, client_oid)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
     * @return result of creation a new limit order as {@link Order} object
     * **/
    public Order createStopOrderObject(String side, String productId, double price, double size, double stopPrice,
                                       Params extraBodyParams) throws Exception {
        return new Order(new JSONObject(createStopOrder(side, productId, price, size, stopPrice, extraBodyParams)));
    }

    /** Request to get single order information
     * @param orderId: identifier of order from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1</a>
     * @return result of single order information as {@link String}
     * **/
    public String getSingleOrder(String orderId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId, GET_METHOD);
    }

    /** Request to get single order information
     * @param orderId: identifier of order from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1</a>
     * @return result of single order information as {@link JSONObject}
     * **/
    public JSONObject getSingleOrderJSON(String orderId) throws Exception {
        return new JSONObject(getSingleOrder(orderId));
    }

    /** Request to get single order information
     * @param orderId: identifier of order from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1</a>
     * @return result of single order information as {@link Order} object
     * **/
    public Order getSingleOrderObject(String orderId) throws Exception {
        return new Order(new JSONObject(getSingleOrder(orderId)));
    }

    /** Request to cancel an order
     * @param orderId: identifier of order to cancel
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1</a>
     * @return result of order cancellation as {@link String}
     * **/
    public String cancelOrder(String orderId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId, DELETE_METHOD);
    }

    /** Request to get an order
     * @param orderId: identifier of order to cancel
     * @param profileId: identifier of account where delete an order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1</a>
     * @return result of order cancellation as {@link String}
     * **/
    public String cancelOrder(String orderId, String profileId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId + "?profile_id=" + profileId, DELETE_METHOD);
    }

}
