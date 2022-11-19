package com.tecknobit.coinbasemanager.managers.exchangepro.orders;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.orders.records.Fill;
import com.tecknobit.coinbasemanager.managers.exchangepro.orders.records.Order;
import com.tecknobit.coinbasemanager.managers.exchangepro.orders.records.OrderDetails.Side;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static com.tecknobit.apimanager.apis.APIRequest.*;
import static com.tecknobit.apimanager.formatters.ScientificNotationParser.sNotationParse;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.GET_ALL_FILLS_ENDPOINT;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.ORDERS_ENDPOINT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.orders.records.Order.*;
import static com.tecknobit.coinbasemanager.managers.exchangepro.orders.records.Order.OrderType.*;
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
     * @param order: order from get fill details
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public ArrayList<Fill> getAllFillsByOrderId(Order order) throws Exception {
        return getAllFillsByOrderId(order.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to get all filled orders
     *
     * @param order:  order from get fill details
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all filled orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public <T> T getAllFillsByOrderId(Order order, ReturnFormat format) throws Exception {
        return getAllFillsByOrderId(order.getId(), format);
    }

    /**
     * Request to get all filled orders
     *
     * @param orderId: identifier of order from get fill details
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public ArrayList<Fill> getAllFillsByOrderId(String orderId) throws Exception {
        return getAllFillsByOrderId(orderId, LIBRARY_OBJECT);
    }

    /**
     * Request to get all filled orders
     *
     * @param orderId: identifier of order from get fill details
     * @param format:  return type formatter -> {@link ReturnFormat}
     * @return all filled orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public <T> T getAllFillsByOrderId(String orderId, ReturnFormat format) throws Exception {
        return returnFillsList(sendAPIRequest(GET_ALL_FILLS_ENDPOINT + "?order_id=" + orderId, GET_METHOD),
                format);
    }

    /**
     * Request to get all filled orders
     *
     * @param order:       order from get fill details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> get results for a specific profile - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "market_type"} -> market type which the order was filled in - [string, default spot]
     *                          </li>
     *                     </ul>
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public ArrayList<Fill> getAllFillsByOrderId(Order order, Params queryParams) throws Exception {
        return getAllFillsByOrderId(order.getId(), queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get all filled orders
     *
     * @param order:       order from get fill details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> get results for a specific profile - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "market_type"} -> market type which the order was filled in - [string, default spot]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all filled orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public <T> T getAllFillsByOrderId(Order order, Params queryParams, ReturnFormat format) throws Exception {
        return getAllFillsByOrderId(order.getId(), queryParams, format);
    }

    /**
     * Request to get all filled orders
     *
     * @param orderId:     identifier of order from get fill details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> get results for a specific profile - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "market_type"} -> market type which the order was filled in - [string, default spot]
     *                          </li>
     *                     </ul>
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public ArrayList<Fill> getAllFillsByOrderId(String orderId, Params queryParams) throws Exception {
        return getAllFillsByOrderId(orderId, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get all filled orders
     *
     * @param orderId:     identifier of order from get fill details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> get results for a specific profile - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "market_type"} -> market type which the order was filled in - [string, default spot]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all filled orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public <T> T getAllFillsByOrderId(String orderId, Params queryParams, ReturnFormat format) throws Exception {
        queryParams.addParam("order_id", orderId);
        return returnFillsList(sendAPIRequest(GET_ALL_FILLS_ENDPOINT + queryParams.createQueryString(), GET_METHOD),
                format);
    }

    /**
     * Request to get all filled orders
     *
     * @param productId: identifier of product to get details
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public ArrayList<Fill> getAllFillsByProductId(String productId) throws Exception {
        return getAllFillsByProductId(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to get all filled orders
     *
     * @param productId: identifier of product to get details
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return all filled orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public <T> T getAllFillsByProductId(String productId, ReturnFormat format) throws Exception {
        return returnFillsList(sendAPIRequest(GET_ALL_FILLS_ENDPOINT + "?product_id=" + productId, GET_METHOD),
                format);
    }

    /**
     * Request to get all filled orders
     *
     * @param productId:   identifier of product to get details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> get results for a specific profile - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "market_type"} -> market type which the order was filled in - [string, default spot]
     *                          </li>
     *                     </ul>
     * @return all filled orders list as {@link ArrayList} of {@link Fill}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public ArrayList<Fill> getAllFillsByProductId(String productId, Params queryParams) throws Exception {
        return getAllFillsByProductId(productId, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get all filled orders
     *
     * @param productId:   identifier of product to get details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> get results for a specific profile - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "market_type"} -> market type which the order was filled in - [string, default spot]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all filled orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
     * Get all fills</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/fills")
    public <T> T getAllFillsByProductId(String productId, Params queryParams, ReturnFormat format) throws Exception {
        queryParams.addParam("product_id", productId);
        return returnFillsList(sendAPIRequest(GET_ALL_FILLS_ENDPOINT + queryParams.createQueryString(), GET_METHOD),
                format);
    }

    /**
     * MethodId to assemble a fills list
     *
     * @param fillsResponse: fills list response to format
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return fills list response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnFillsList(String fillsResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(fillsResponse);
            case LIBRARY_OBJECT:
                ArrayList<Fill> fills = new ArrayList<>();
                JSONArray jFills = new JSONArray(fillsResponse);
                for (int j = 0; j < jFills.length(); j++)
                    fills.add(new Fill(jFills.getJSONObject(j)));
                return (T) fills;
            default:
                return (T) fillsResponse;
        }
    }

    /**
     * Request to get all open orders
     *
     * @param limit:    number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:  ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status[]}
     * @return all orders list as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting,
                                         Status[] statuses) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.stream(statuses).toList(), LIBRARY_OBJECT);
    }

    /**
     * Request to get all open orders
     *
     * @param limit:    number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:  ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status[]}
     * @param format:   return type formatter -> {@link ReturnFormat}
     * @return all orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status[] statuses,
                              ReturnFormat format) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.stream(statuses).toList(), format);
    }

    /**
     * Request to get all open orders
     *
     * @param limit:    number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:  ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Collection}
     * @return all orders list as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting,
                                         Collection<Status> statuses) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, statuses, LIBRARY_OBJECT);
    }

    /**
     * Request to get all open orders
     *
     * @param limit:    number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:  ascending or descending order criteria (asc or desc)
     * @param statuses: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Collection}
     * @param format:   return type formatter -> {@link ReturnFormat}
     * @return all orders list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Collection<Status> statuses,
                              ReturnFormat format) throws Exception {
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&", "status", new ArrayList<>(statuses));
        return returnOrdersList(sendAPIRequest(ORDERS_ENDPOINT + params, GET_METHOD), format);
    }

    /**
     * Request to get all open orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param statuses:    orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status} array
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                     </ul>
     * @return all orders as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status[] statuses,
                                         Params queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.stream(statuses).toList(), queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get all open orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param statuses:    orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status} array
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @implSpec (keys accepted are profile_id, before, after, start_date, end_date, product_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status[] statuses,
                              Params queryParams, ReturnFormat format) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.stream(statuses).toList(), queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get all open orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param statuses:    orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Collection}
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                     </ul>
     * @return all orders as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Collection<Status> statuses,
                                         Params queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, statuses, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get all open orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param statuses:    orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Collection}
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Collection<Status> statuses,
                              Params queryParams, ReturnFormat format) throws Exception {
        String params = assembleQueryParams("?limit=" + limit, assembleSortCriteria(sortedBy, sorting));
        params += apiRequest.concatenateParamsList("&", "status", new ArrayList<>(statuses));
        return returnOrdersList(sendAPIRequest(ORDERS_ENDPOINT + assembleQueryParams(params, queryParams),
                GET_METHOD), format);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:    number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:  ascending or descending order criteria (asc or desc)
     * @param status:   orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @return all orders as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status status) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.asList(status), LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:    number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:  ascending or descending order criteria (asc or desc)
     * @param status:   orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status}
     * @param format:   return type formatter -> {@link ReturnFormat}
     * @return all orders as as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status status,
                              ReturnFormat format) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.asList(status), format);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param status:      orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status}
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                     </ul>
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status status,
                                         Params queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.asList(status), queryParams, LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param status:      orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status}
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status status,
                              Params queryParams, ReturnFormat format) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, Arrays.asList(status), queryParams, format);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:     number of returns
     * @param sortedBy:  sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:   ascending or descending order criteria (asc or desc)
     * @param statuses:  orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @return all orders as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Collection<Status> statuses,
                                         String productId) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, statuses, productId, LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:     number of returns
     * @param sortedBy:  sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:   ascending or descending order criteria (asc or desc)
     * @param statuses:  orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Collection<Status> statuses,
                              String productId, ReturnFormat format) throws Exception {
        Params productIdPayload = new Params();
        productIdPayload.addParam("product_id", productId);
        return getAllOrders(limit, sortedBy, sorting, statuses, productIdPayload, format);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param statuses:    orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId:   identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                     </ul>
     * @return all orders as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Collection<Status> statuses,
                                         String productId, Params queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, statuses, productId, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param statuses:    orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId:   identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Collection<Status> statuses,
                              String productId, Params queryParams, ReturnFormat format) throws Exception {
        Params productIdPayload = new Params();
        productIdPayload.addParam("product_id", productId);
        queryParams.mergeParams(productIdPayload);
        return getAllOrders(limit, sortedBy, sorting, statuses, queryParams, format);
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     Get all orders</a>
     * @return all orders as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrder(int limit, Sorter sortedBy, SortingOrder sorting, Status status,
                                        String productId) throws Exception {
        return getAllOrder(limit, sortedBy, sorting, status, productId, LIBRARY_OBJECT);
    }

    /** Custom request to get all orders
     * @param limit: number of returns
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting: ascending or descending order criteria (asc or desc)
     * @param status: orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link String}
     * @param productId: identifier of product from fetch details es. BTC-ETH
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     *     Get all orders</a>
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrder(int limit, Sorter sortedBy, SortingOrder sorting, Status status,
                             String productId, ReturnFormat format) throws Exception {
        Params productIdPayload = new Params();
        productIdPayload.addParam("product_id", productId);
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(status)), productIdPayload, format);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param status:      orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status}
     * @param productId:   identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                     </ul>
     * @return all orders as {@link ArrayList} of {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<Order> getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status status, String productId,
                                         Params queryParams) throws Exception {
        return getAllOrders(limit, sortedBy, sorting, status, productId, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all orders
     *
     * @param limit:       number of returns
     * @param sortedBy:    sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:     ascending or descending order criteria (asc or desc)
     * @param status:      orders status to fetch (open, pending, rejected, done, active, received, or all) as {@link Status}
     * @param productId:   identifier of product from fetch details es. BTC-ETH
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
     * Get all orders</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T getAllOrders(int limit, Sorter sortedBy, SortingOrder sorting, Status status, String productId,
                              Params queryParams, ReturnFormat format) throws Exception {
        Params payload = new Params();
        payload.addParam("product_id", productId);
        queryParams.mergeParams(payload);
        return getAllOrders(limit, sortedBy, sorting, new ArrayList<>(asList(status)), queryParams, format);
    }

    /**
     * MethodId to assemble map of sorting criteria
     *
     * @param sortedBy: sort criteria for results (created_at, price, size, order_id, side or type)
     * @param sorting:  ascending or descending order criteria (asc or desc)
     * @return map of sorting criteria params as {@link Params}
     **/
    private Params assembleSortCriteria(Sorter sortedBy, SortingOrder sorting) {
        Params criteria = new Params();
        criteria.addParam("sortedBy", sortedBy);
        criteria.addParam("sorting", sorting);
        return criteria;
    }

    /**
     * MethodId to assemble an orders list
     *
     * @param ordersResponse: orders list response to format
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @return orders list response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnOrdersList(String ordersResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(ordersResponse);
            case LIBRARY_OBJECT:
                ArrayList<Order> orders = new ArrayList<>();
                JSONArray jOrders = new JSONArray(ordersResponse);
                for (int j = 0; j < jOrders.length(); j++)
                    orders.add(new Order(jOrders.getJSONObject(j)));
                return (T) orders;
            default:
                return (T) ordersResponse;
        }
    }

    /**
     * Request to cancel all orders <br>
     * Any params required
     *
     * @return result list of cancelled id orders as {@link ArrayList} of {@link String}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     * Cancel all orders</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<String> cancelAllOpenOrders() throws Exception {
        return returnCanceledOrdersList(sendAPIRequest(ORDERS_ENDPOINT, DELETE_METHOD), LIBRARY_OBJECT);
    }

    /** Request to cancel all orders
     *
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     Cancel all orders</a>
     * @return result list of cancelled id orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T cancelAllOpenOrders(ReturnFormat format) throws Exception {
        return returnCanceledOrdersList(sendAPIRequest(ORDERS_ENDPOINT, DELETE_METHOD), format);
    }

    /** Request to cancel all orders
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                     </ul>
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     Cancel all orders</a>
     * @return result list of cancelled id orders as {@link ArrayList} of {@link String}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public ArrayList<String> cancelAllOpenOrders(Params queryParams) throws Exception {
        return returnCanceledOrdersList(sendAPIRequest(ORDERS_ENDPOINT + queryParams.createQueryString(),
                DELETE_METHOD), LIBRARY_OBJECT);
    }

    /** Request to cancel all orders
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "product_id"} -> product identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                     </ul>
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
     *     Cancel all orders</a>
     * @return result list of cancelled id orders as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T cancelAllOpenOrders(Params queryParams, ReturnFormat format) throws Exception {
        return returnCanceledOrdersList(sendAPIRequest(ORDERS_ENDPOINT + queryParams.createQueryString(),
                DELETE_METHOD), format);
    }

    /**
     * MethodId to assemble a canceled orders list
     *
     * @param ordersResponse: canceled orders list response to format
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @return canceled orders list response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnCanceledOrdersList(String ordersResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(ordersResponse);
            case LIBRARY_OBJECT:
                ArrayList<String> ordersId = new ArrayList<>();
                JSONArray jOrders = new JSONArray(ordersResponse);
                for (int j = 0; j < jOrders.length(); j++)
                    ordersId.add(jOrders.getString(j));
                return (T) ordersId;
            default:
                return (T) ordersResponse;
        }
    }

    /**
     * Request to create new limit order
     *
     * @param side:      side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price:     price per unit of product es. price for one unit of BTC in USD base
     * @param size:      amount of base currency used in the order
     * @return result of creation a new limit order as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     * Create a new order</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createNewLimitOrder(Side side, String productId, double price, double size) throws Exception {
        return createNewLimitOrder(side, productId, price, size, LIBRARY_OBJECT);
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new limit order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createNewLimitOrder(Side side, String productId, double price, double size,
                                     ReturnFormat format) throws Exception {
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, createOrderPayload(side, productId,
                price, size, OrderType.limit)), format);
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new limit order as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createNewLimitOrder(Side side, String productId, double price, double size,
                                     Params extraParams) throws Exception {
        return createNewLimitOrder(side, productId, price, size, extraParams, LIBRARY_OBJECT);
    }

    /** Request to create new limit order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new limit order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createNewLimitOrder(Side side, String productId, double price, double size,
                                     Params extraParams, ReturnFormat format) throws Exception {
        Params payload = createOrderPayload(side, productId, price, size, limit);
        payload.mergeParams(extraParams);
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, payload), format);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createMarketOrderSize(Side side, String productId, double size) throws Exception {
        return createMarketOrderSize(side, productId, size, LIBRARY_OBJECT);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createMarketOrderSize(Side side, String productId, double size, ReturnFormat format) throws Exception {
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, createMarketOrderPayload(side,
                productId, "size", size)), format);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@link Order}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createMarketOrderSize(Side side, String productId, double size, Params extraParams) throws Exception {
        return createMarketOrderSize(side, productId, size, extraParams, LIBRARY_OBJECT);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param size: amount of base currency used in the order
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createMarketOrderSize(Side side, String productId, double size, Params extraParams,
                                       ReturnFormat format) throws Exception {
        Params payload = createMarketOrderPayload(side, productId, "size", size);
        payload.mergeParams(extraParams);
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, payload), format);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createMarketOrderFounds(Side side, String productId, double founds) throws Exception {
        return createMarketOrderFounds(side, productId, founds, LIBRARY_OBJECT);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createMarketOrderFounds(Side side, String productId, double founds, ReturnFormat format) throws Exception {
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, createMarketOrderPayload(side, productId,
                "founds", founds)), format);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createMarketOrderFounds(Side side, String productId, double founds, Params extraParams) throws Exception {
        return createMarketOrderFounds(side, productId, founds, extraParams, LIBRARY_OBJECT);
    }

    /** Request to create new market order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param founds: amount of quote currency used in the order
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new market order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createMarketOrderFounds(Side side, String productId, double founds, Params extraParams,
                                         ReturnFormat format) throws Exception {
        Params payload = createMarketOrderPayload(side, productId, "founds", founds);
        payload.mergeParams(extraParams);
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, payload), format);
    }

    /**
     * MethodId to assemble a payload for market order
     *
     * @param side:      side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param key:       size of funds parameter
     * @param keyValue:  value of key
     * @return payload for a new market order as {@link Params}
     **/
    private Params createMarketOrderPayload(Side side, String productId, String key, double keyValue) {
        Params payload = new Params();
        payload.addParam("side", side);
        payload.addParam("product_id", productId);
        payload.addParam(key, sNotationParse(8, keyValue));
        payload.addParam("type", market);
        return payload;
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new limit order as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createStopOrder(Side side, String productId, double price, double size, double stopPrice) throws Exception {
        return createStopOrder(side, productId, price, size, stopPrice, LIBRARY_OBJECT);
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new limit order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createStopOrder(Side side, String productId, double price, double size, double stopPrice,
                                 ReturnFormat format) throws Exception {
        Params payload = createOrderPayload(side, productId, price, size, stop);
        payload.addParam("stop_price", stopPrice);
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, payload), format);
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new limit order as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public Order createStopOrder(Side side, String productId, double price, double size, double stopPrice,
                                 Params extraParams) throws Exception {
        return createStopOrder(side, productId, price, size, stopPrice, extraParams, LIBRARY_OBJECT);
    }

    /** Request to create new stop order
     * @param side: side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price: price per unit of product es. price for one unit of BTC in USD base
     * @param size: amount of base currency used in the order
     * @param stopPrice: price when stop order will be placed on the book
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "time_in_force"} -> time in force, constant available: {@link TimeInForce} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "cancel_after"} -> cancel after, constant available: {@link CancelAfter} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stp"} -> stp, constant available: {@link STP} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "stop"} -> stop, constant available: {@link StopType} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "post_only"} -> if {@code "true"}, order will only execute as a
     *                              {@code "maker"} order - [boolean, default false]
     *                          </li>
     *                          <li>
     *                              {@code "client_oid"} -> optional Order ID selected by the user or the frontend
     *                              client to identify their order - [string]
     *                          </li>
     *                     </ul>
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
     *     Create a new order</a>
     * @return result of creation a new limit order as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders")
    public <T> T createStopOrder(Side side, String productId, double price, double size, double stopPrice,
                                 Params extraParams, ReturnFormat format) throws Exception {
        Params payload = createOrderPayload(side, productId, price, size, stop);
        payload.addParam("stop_price", stopPrice);
        payload.mergeParams(extraParams);
        return returnOrder(sendPayloadedRequest(ORDERS_ENDPOINT, POST_METHOD, payload), format);
    }

    /**
     * MethodId to assemble a payload for limit and stop order
     *
     * @param side:      side of the order (buy or sell)
     * @param productId: identifier of product to buy or sell es. BTC-USD
     * @param price:     price per unit of product es. price for one unit of BTC in USD base
     * @param size:      amount of base currency used in the order
     * @param type:      type of the order (limit or stop)
     * @return payload for a new order as {@link Params}
     **/
    private Params createOrderPayload(Side side, String productId, double price, double size, OrderType type) {
        Params payload = new Params();
        payload.addParam("side", side);
        payload.addParam("product_id", productId);
        payload.addParam("price", price);
        payload.addParam("size", sNotationParse(8, size));
        payload.addParam("type", type);
        return payload;
    }

    /** Request to get single order information
     * @param orderId: identifier of order from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1">
     *     Get single order</a>
     * @return result of single order information as {@link Order} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders/{order_id}")
    public Order getSingleOrder(String orderId) throws Exception {
        return getSingleOrder(orderId, LIBRARY_OBJECT);
    }

    /** Request to get single order information
     * @param orderId: identifier of order from fetch details
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1">
     *     Get single order</a>
     * @return result of single order information as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders/{order_id}")
    public <T> T getSingleOrder(String orderId, ReturnFormat format) throws Exception {
        return returnOrder(sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId, GET_METHOD), format);
    }

    /**
     * MethodId to assemble an order object
     *
     * @param orderResponse: order response to format
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return order response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnOrder(String orderResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONObject(orderResponse);
            case LIBRARY_OBJECT:
                return (T) new Order(new JSONObject(orderResponse));
            default:
                return (T) orderResponse;
        }
    }

    /**
     * Request to cancel an order
     *
     * @param orderId: identifier of order to cancel
     * @return result of order cancellation as {@link String}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1">
     * Cancel an order</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders/{order_id}")
    public String cancelOrder(String orderId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId, DELETE_METHOD);
    }

    /**
     * Request to get an order
     *
     * @param orderId:   identifier of order to cancel
     * @param profileId: identifier of account where delete an order
     * @return result of order cancellation as {@link String}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1">
     * Cancel an order</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders/{order_id}")
    public String cancelOrderByProfile(String orderId, String profileId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId + "?profile_id=" + profileId, DELETE_METHOD);
    }

    /**
     * Request to get an order
     *
     * @param orderId:   identifier of order to cancel
     * @param productId: identifier of product from delete an order
     * @return result of order cancellation as {@link String}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1">
     * Cancel an order</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders/{order_id}")
    public String cancelOrderByProduct(String orderId, String productId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId + "?product_id=" + productId, DELETE_METHOD);
    }

    /**
     * Request to cancel an order
     *
     * @param orderId:   identifier of order to cancel
     * @param profileId: identifier of account where delete an order
     * @param productId: identifier of product from delete an order
     * @return result of order cancellation as {@link String}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorder-1">
     * Cancel an order</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/orders/{order_id}")
    public String cancelOrder(String orderId, String profileId, String productId) throws Exception {
        return sendAPIRequest(ORDERS_ENDPOINT + "/order_id=" + orderId + "?profile_id=" + profileId +
                "&product_id=" + productId, DELETE_METHOD);
    }

}
