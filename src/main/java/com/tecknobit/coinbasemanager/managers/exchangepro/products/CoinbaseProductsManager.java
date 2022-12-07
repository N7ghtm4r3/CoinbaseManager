package com.tecknobit.coinbasemanager.managers.exchangepro.products;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.products.records.*;
import com.tecknobit.coinbasemanager.managers.exchangepro.products.records.Candle.Granularity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.trading.TradingTools.computeTPTOPIndex;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.*;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.JSON;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseProductsManager} class is useful to manage all {@code "Coinbase"} products endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
 * Products manager</a>
 **/
public class CoinbaseProductsManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseProductsManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseProductsManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseProductsManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseProductsManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseProductsManager} <br>
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
    public CoinbaseProductsManager() {
        super();
    }

    /**
     * Request to get all trading pairs <br>
     * Any params required
     *
     * @return all trading pairs list as {@link ArrayList} of {@link TradingPair}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     * Get all known trading pairs</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products")
    public ArrayList<TradingPair> getAllTradingPairs() throws Exception {
        return getAllTradingPairs(LIBRARY_OBJECT);
    }

    /**
     * Request to get all trading pairs
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all trading pairs list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     * Get all known trading pairs</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products")
    public <T> T getAllTradingPairs(ReturnFormat format) throws Exception {
        return returnTradingPairsList(sendAPIRequest(PRODUCTS_ENDPOINT, GET), format);
    }

    /**
     * Request to get all trading pairs
     *
     * @param type: type of trading pairs to fetch details
     * @return all trading pairs as {@link ArrayList} of {@link TradingPair}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products")
    public ArrayList<TradingPair> getAllTradingPairs(String type) throws Exception {
        return getAllTradingPairs(type, LIBRARY_OBJECT);
    }

    /**
     * Request to get all trading pairs
     *
     * @param type:   type of trading pairs to fetch details
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all trading pairs as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products")
    public <T> T getAllTradingPairs(String type, ReturnFormat format) throws Exception {
        return returnTradingPairsList(sendAPIRequest(PRODUCTS_ENDPOINT + "?type=" + type, GET), format);
    }

    /**
     * Method to assemble a trading pairs list
     *
     * @param tradingPairsResponse: trading pairs list response to format
     * @param format:               return type formatter -> {@link ReturnFormat}
     * @return trading pairs response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnTradingPairsList(String tradingPairsResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(tradingPairsResponse);
            case LIBRARY_OBJECT:
                ArrayList<TradingPair> tradingPairs = new ArrayList<>();
                JSONArray jTradings = new JSONArray(tradingPairsResponse);
                for (int j = 0; j < jTradings.length(); j++)
                    tradingPairs.add(new TradingPair(jTradings.getJSONObject(j)));
                return (T) tradingPairs;
            default:
                return (T) tradingPairsResponse;
        }
    }

    /**
     * Request to get single trading pair
     *
     * @param productId: identifier of trading pair es. BTC-USD
     * @return single trading pair as {@link TradingPair} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct-1">
     * Get single product</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}")
    public TradingPair getSingleTradingPair(String productId) throws Exception {
        return getSingleTradingPair(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to get single trading pair
     *
     * @param productId: identifier of trading pair es. BTC-USD
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return single trading pair as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct-1">
     * Get single product</a>
     **/
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}")
    public <T> T getSingleTradingPair(String productId, ReturnFormat format) throws Exception {
        String tradingPairResponse = sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId, GET);
        switch (format) {
            case JSON:
                return (T) new JSONObject(tradingPairResponse);
            case LIBRARY_OBJECT:
                return (T) new TradingPair(new JSONObject(tradingPairResponse));
            default:
                return (T) tradingPairResponse;
        }
    }

    /**
     * Request to get book details
     *
     * @param productId: identifier of book es. BTC-USD
     * @return book details as {@link Book} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/book")
    public Book getProductBook(String productId) throws Exception {
        return getProductBook(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to get book details
     *
     * @param productId: identifier of book es. BTC-USD
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return book details as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/book")
    public <T> T getProductBook(String productId, ReturnFormat format) throws Exception {
        return returnBook(productId, sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT,
                GET), format);
    }

    /**
     * Request to get book details
     *
     * @param productId: identifier of book es. BTC-USD
     * @param level:     type of format for result
     * @return book details as {@link Book} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/book")
    public Book getProductBook(String productId, int level) throws Exception {
        return getProductBook(productId, level, LIBRARY_OBJECT);
    }

    /**
     * Request to get book details
     *
     * @param productId: identifier of book es. BTC-USD
     * @param level:     type of format for result
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return book details as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/book")
    public <T> T getProductBook(String productId, int level, ReturnFormat format) throws Exception {
        return returnBook(productId, sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT
                + "?level=" + level, GET), format);
    }

    /**
     * Method to assemble a book object
     *
     * @param productId:    identifier of book es. BTC-USD
     * @param bookResponse: book response to format
     * @param format:       return type formatter -> {@link ReturnFormat}
     * @return book response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnBook(String productId, String bookResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(bookResponse);
            case LIBRARY_OBJECT:
                return (T) new Book(new JSONObject(bookResponse).put("productId", productId));
            default:
                return (T) bookResponse;
        }
    }

    /**
     * Custom request to get all products book details <br>
     * Any params required
     *
     * @return all products book details as {@link ArrayList} of {@link Book}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @WrappedRequest
    public ArrayList<Book> getAllProductsBooks() throws Exception {
        return returnAllBooks(-1, LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all products book details
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all products book details as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @WrappedRequest
    public <T> T getAllProductsBooks(ReturnFormat format) throws Exception {
        return returnAllBooks(-1, format);
    }

    /**
     * Custom request to get all products book details <br>
     *
     * @param level: type of format for result
     * @return all products book details as {@link ArrayList} of {@link Book}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @WrappedRequest
    public ArrayList<Book> getAllProductsBooks(int level) throws Exception {
        return returnAllBooks(level, LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all products book details <br>
     *
     * @param level:  type of format for result
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all products book details as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     * Get product book</a>
     **/
    @WrappedRequest
    public <T> T getAllProductsBooks(int level, ReturnFormat format) throws Exception {
        return returnAllBooks(level, format);
    }

    /**
     * Method to assemble a books list
     *
     * @param level:  type of format for result
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return books list response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnAllBooks(int level, ReturnFormat format) throws Exception {
        JSONArray tradingPairs = getAllTradingPairs(JSON);
        JSONArray jBooks = new JSONArray();
        boolean insertLevel = level != -1;
        for (int j = 0; j < tradingPairs.length(); j++) {
            String productId = tradingPairs.getJSONObject(j).getString("id");
            try {
                if (insertLevel)
                    jBooks.put(getProductBook(productId, level));
                else
                    jBooks.put(getProductBook(productId));
            } catch (IOException ignore) {
            }
        }
        switch (format) {
            case JSON:
                return (T) jBooks;
            case LIBRARY_OBJECT:
                ArrayList<Book> books = new ArrayList<>();
                for (int j = 0; j < jBooks.length(); j++)
                    books.add(new Book(jBooks.getJSONObject(j)));
                return (T) books;
            default:
                return (T) jBooks.toString();
        }
    }

    /**
     * Request to get candles list
     *
     * @param productId: identifier of candle es. BTC-USD
     * @return candles list as {@link ArrayList} of {@link Candle}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     * Get product candles</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/candles")
    public ArrayList<Candle> getProductCandles(String productId) throws Exception {
        return getProductCandles(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to get candles list
     *
     * @param productId: identifier of candle es. BTC-USD
     * @return candles list as {@link ArrayList} of {@link Candle}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     * Get product candles</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/candles")
    public <T> T getProductCandles(String productId, ReturnFormat format) throws Exception {
        return returnCandlesList(sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT,
                GET), format);
    }

    /**
     * Request to get candles list
     *
     * @param productId:   identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "granularity"} -> granularity value, constant available: {@link Granularity} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "start"} -> timestamp for starting range of aggregations - [long]
     *                          </li>
     *                          <li>
     *                              {@code "end"} -> timestamp for ending range of aggregations - [long]
     *                          </li>
     *                     </ul>
     * @return candles list as {@link ArrayList} of {@link Candle}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     * Get product candles</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/candles")
    public ArrayList<Candle> getProductCandles(String productId, Params queryParams) throws Exception {
        return getProductCandles(productId, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get candles list
     *
     * @param productId:   identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "granularity"} -> granularity value, constant available: {@link Granularity} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "start"} -> timestamp for starting range of aggregations - [long]
     *                          </li>
     *                          <li>
     *                              {@code "end"} -> timestamp for ending range of aggregations - [long]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return candles list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     * Get product candles</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/candles")
    public <T> T getProductCandles(String productId, Params queryParams, ReturnFormat format) throws Exception {
        return returnCandlesList(sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT +
                queryParams.createQueryString(), GET), format);
    }

    /**
     * Method to assemble a candles list
     *
     * @param candlesListResponse: candles list response to format
     * @param format:              return type formatter -> {@link ReturnFormat}
     * @return candles response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnCandlesList(String candlesListResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(candlesListResponse);
            case LIBRARY_OBJECT:
                ArrayList<Candle> candles = new ArrayList<>();
                JSONArray jCandles = new JSONArray(candlesListResponse);
                for (int j = 0; j < jCandles.length(); j++)
                    candles.add(new Candle(jCandles.getJSONArray(j)));
                return (T) candles;
            default:
                return (T) candlesListResponse;
        }
    }

    /**
     * Request to get product stats
     *
     * @param productId: identifier of product stats es. BTC-USD
     * @return product stats as {@link Stat} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     * Get product stats</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/stats")
    public Stat getProductStats(String productId) throws Exception {
        return getProductStats(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to get product stats
     *
     * @param productId: identifier of product stats es. BTC-USD
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return product stats as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     * Get product stats</a>
     **/
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/stats")
    public <T> T getProductStats(String productId, ReturnFormat format) throws Exception {
        String productResponse = sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_STAT_ENDPOINT,
                GET);
        switch (format) {
            case JSON:
                return (T) new JSONObject(productResponse);
            case LIBRARY_OBJECT:
                return (T) new Stat(new JSONObject(productResponse).put("productId", productId));
            default:
                return (T) productResponse;
        }
    }

    /**
     * Custom request to get all products stats list <br>
     * Any params required
     *
     * @return all products stats as {@link ArrayList} of {@link Stat}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     * Get product stats</a>
     **/
    @WrappedRequest
    public ArrayList<Stat> getAllProductsStats() throws Exception {
        return getAllProductsStats(LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all products stats list
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all products stats as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     * Get product stats</a>
     **/
    @Returner
    @WrappedRequest
    public <T> T getAllProductsStats(ReturnFormat format) throws Exception {
        JSONArray tradingPairs = getAllTradingPairs(JSON);
        JSONArray jStats = new JSONArray();
        for (int j = 0; j < tradingPairs.length(); j++) {
            try {
                jStats.put(getProductStats(tradingPairs.getJSONObject(j).getString("id")));
            } catch (IOException ignore) {
            }
        }
        switch (format) {
            case JSON:
                return (T) jStats;
            case LIBRARY_OBJECT:
                ArrayList<Stat> stats = new ArrayList<>();
                for (int j = 0; j < jStats.length(); j++)
                    stats.add(new Stat(jStats.getJSONObject(j)));
                return (T) stats;
            default:
                return (T) jStats.toString();
        }
    }

    /**
     * Request to get product ticker
     *
     * @param productId: identifier of product ticker es. BTC-USD
     * @return product stats as {@link Ticker} custom object
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
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, base asset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     * Get product ticker</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/ticker")
    public Ticker getProductTicker(String productId) throws Exception {
        return getProductTicker(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to get product ticker
     *
     * @param productId: identifier of product ticker es. BTC-USD
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return product stats as {@code "format"} defines
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
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, base asset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     * Get product ticker</a>
     **/
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/ticker")
    public <T> T getProductTicker(String productId, ReturnFormat format) throws Exception {
        JSONObject ticker = new JSONObject(sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId +
                GET_PRODUCT_TICKER_ENDPOINT, GET));
        ticker.put("productId", productId);
        String[] details = productId.split("-");
        ticker.put("baseAsset", details[0]);
        ticker.put("quoteAsset", details[1]);
        ticker.put("priceChangePercent", getPriceChangePercent(productId, ticker.getDouble("price")));
        switch (format) {
            case JSON:
                return (T) ticker;
            case LIBRARY_OBJECT:
                return (T) new Ticker(ticker);
            default:
                return (T) ticker.toString();
        }
    }

    /**
     * Method to get price change percent
     *
     * @param productId: product identifier value
     * @param price:     price value for product
     * @return price change percent as double
     **/
    private double getPriceChangePercent(String productId, double price) throws Exception {
        JSONArray candles = getProductCandles(productId, JSON);
        return getTrendPercent(new Candle(candles.getJSONArray(candles.length() - 1)).getClose(), price);
    }

    /**
     * Custom request to get all products stats list <br>
     * Any params required
     *
     * @return all products stats as {@link ArrayList} of {@link Stat}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     * Get product ticker</a>
     **/
    @WrappedRequest
    public ArrayList<Ticker> getAllTickers() throws Exception {
        return getAllTickers(LIBRARY_OBJECT);
    }

    /**
     * Custom request to get all products tickers list
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all products tickers as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     * Get product ticker</a>
     **/
    @Returner
    @WrappedRequest
    public <T> T getAllTickers(ReturnFormat format) throws Exception {
        JSONArray tradingPairs = getAllTradingPairs(JSON);
        JSONArray jTickers = new JSONArray();
        for (int j = 0; j < tradingPairs.length(); j++) {
            try {
                jTickers.put(getProductTicker(tradingPairs.getJSONObject(j).getString("id")));
            } catch (IOException ignored) {
            }
        }
        switch (format) {
            case JSON:
                return (T) jTickers;
            case LIBRARY_OBJECT:
                ArrayList<Ticker> tickers = new ArrayList<>();
                for (int j = 0; j < jTickers.length(); j++)
                    tickers.add(new Ticker(jTickers.getJSONObject(j)));
                return (T) tickers;
            default:
                return (T) jTickers.toString();
        }
    }

    /**
     * Request to get product trades
     *
     * @param productId: identifier of product trades es. BTC-USD
     * @return product trades list as {@link ArrayList} of {@link Trade}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     * Get product trades</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/trades")
    public ArrayList<Trade> getProductTrades(String productId) throws Exception {
        return getProductTrades(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to get product trades
     *
     * @param productId: identifier of product trades es. BTC-USD
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return product trades list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     * Get product trades</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/trades")
    public <T> T getProductTrades(String productId, ReturnFormat format) throws Exception {
        return returnTradesList(sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT,
                GET), format);
    }

    /**
     * Request to get product trades
     *
     * @param productId:   identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                     </ul>
     * @return product trades as {@link ArrayList} of {@link Trade}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     * Get product trades</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/trades")
    public ArrayList<Trade> getProductTrades(String productId, Params queryParams) throws Exception {
        return getProductTrades(productId, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get product trades
     *
     * @param productId:   identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return product trades as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     * Get product trades</a>
     **/
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/products/{product_id}/trades")
    public <T> T getProductTrades(String productId, Params queryParams, ReturnFormat format) throws Exception {
        return returnTradesList(sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT +
                queryParams.createQueryString(), GET), format);
    }

    /**
     * Method to assemble a trades list
     *
     * @param tradesResponse: trades list response to format
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @return trades response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnTradesList(String tradesResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(tradesResponse);
            case LIBRARY_OBJECT:
                ArrayList<Trade> trades = new ArrayList<>();
                JSONArray jTrades = new JSONArray(tradesResponse);
                for (int j = 0; j < jTrades.length(); j++)
                    trades.add(new Trade(jTrades.getJSONObject(j)));
                return (T) trades;
            default:
                return (T) tradesResponse;
        }
    }

    /**
     * Method to get forecast of a cryptocurrency in base of days's gap inserted
     *
     * @param productId:      productId to calculate forecast es. BTC-USD
     * @param intervalDays:   days gap for the prevision range
     * @param granularity:    interval for candles
     * @param toleranceValue: tolerance for select similar value compared to lastValue inserted
     * @param decimalDigits:  number of digits to round final forecast value
     * @return forecast value as a double es. 8 or -8
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
     **/
    @Wrapper
    public double getSymbolForecast(String productId, int intervalDays, Granularity granularity, double toleranceValue,
                                    int decimalDigits) throws Exception {
        return roundValue(getSymbolForecast(productId, intervalDays, granularity, toleranceValue), decimalDigits);
    }

    /**
     * Method to get forecast of a cryptocurrency in base of days's gap inserted
     *
     * @param productId:      productId to calculate forecast es. BTC-USD
     * @param intervalDays:   days gap for the prevision range
     * @param granularity:    interval for candles
     * @param toleranceValue: tolerance for select similar value compared to lastValue inserted
     * @return forecast value as a double es. 8 or -8
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
     **/
    public double getSymbolForecast(String productId, int intervalDays, Granularity granularity,
                                    double toleranceValue) throws Exception {
        ArrayList<Double> historicalValues = new ArrayList<>();
        Params intervalMap = new Params();
        intervalMap.addParam("granularity", granularity);
        for (Candle candle : getProductCandles(productId, intervalMap))
            historicalValues.add(candle.getHigh());
        return computeTPTOPIndex(historicalValues, getProductStats(productId).getLast(), intervalDays, toleranceValue);
    }

}
