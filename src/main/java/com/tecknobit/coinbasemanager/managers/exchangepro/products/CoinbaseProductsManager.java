package com.tecknobit.coinbasemanager.managers.exchangepro.products;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.products.records.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.trading.TradingTools.computeTPTOPIndex;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.*;

/**
 * The {@code CoinbaseProductsManager} class is useful to manage all {@code "Coinbase"} products endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
 * Products manager</a>
 **/
public class CoinbaseProductsManager extends CoinbaseManager {

    /**
     * {@code tradingPairsList} is instance that memorizes all trading pairs list
     **/
    private static JSONArray tradingPairsList = new JSONArray();

    /**
     * {@code previousLoadPairsList} is instance that memorizes previous timestamp of loading {@link #tradingPairsList}
     **/
    private long previousLoadPairsList;

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
     * Request to get all trading pairs
     * Any params required
     *
     * @return all trading pairs as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     **/
    public String getAllTradingPairs() throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT, GET_METHOD);
    }

    /**
     * Request to get all trading pairs
     * Any params required
     *
     * @return all trading pairs as {@link JSONArray}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     **/
    public JSONArray getAllTradingPairsJSON() throws Exception {
        long actualTimestamp = System.currentTimeMillis();
        if (tradingPairsList.isEmpty() || ((actualTimestamp - previousLoadPairsList) >= (3600 * 1000))) {
            previousLoadPairsList = actualTimestamp;
            return tradingPairsList = new JSONArray(getAllTradingPairs());
        }
        return tradingPairsList;
    }

    /**
     * Request to get all trading pairs
     * Any params required
     *
     * @return all trading pairs list as {@link ArrayList} of {@link TradingPair}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     **/
    public ArrayList<TradingPair> getAllTradingPairsList() throws Exception {
        return assembleTradingPairsList(new JSONArray(getAllTradingPairs()));
    }

    /** Request to get all trading pairs
     * @param type: type of trading pairs to fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     * @return all trading pairs as {@link String}
     * **/
    public String getAllTradingPairs(String type) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "?type=" + type, GET_METHOD);
    }

    /** Request to get all trading pairs
     * @param type: type of trading pairs to fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     * @return all trading pairs as {@link JSONArray}
     * **/
    public JSONArray getAllTradingPairsJSON(String type) throws Exception {
        return new JSONArray(getAllTradingPairs(type));
    }

    /** Request to get all trading pairs
     * @param type: type of trading pairs to fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts-1</a>
     * @return all trading pairs as {@link ArrayList} of {@link TradingPair}
     * **/
    public ArrayList<TradingPair> getAllTradingPairsList(String type) throws Exception {
        return assembleTradingPairsList(new JSONArray(getAllTradingPairs(type)));
    }

    /** Method to assemble a trading pairs list
     * @param jsonTradings: jsonArray obtained by response request
     * @return trading pairs list as {@link ArrayList} of {@link TradingPair}
     * **/
    private ArrayList<TradingPair> assembleTradingPairsList(JSONArray jsonTradings){
        ArrayList<TradingPair> tradingPairs = new ArrayList<>();
            for (int j = 0; j < jsonTradings.length(); j++)
                tradingPairs.add(new TradingPair(jsonTradings.getJSONObject(j)));
        return tradingPairs;
    }

    /** Request to get single trading pair
     * @param productId: identifier of trading pair es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct-1</a>
     * @return single trading pair as {@link String}
     * **/
    public String getSingleTradingPair(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId, GET_METHOD);
    }

    /** Request to get single trading pair
     * @param productId: identifier of trading pair es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangere stapi_getproduct-1</a>
     * @return single trading pair as {@link JSONObject}
     * **/
    public JSONObject getSingleTradingPairJSON(String productId) throws Exception {
        return new JSONObject(getSingleTradingPair(productId));
    }

    /** Request to get single trading pair
     * @param productId: identifier of trading pair es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct-1</a>
     * @return single trading pair as {@link TradingPair} custom object
     * **/
    public TradingPair getSingleTradingPairObject(String productId) throws Exception {
        return new TradingPair(new JSONObject(getSingleTradingPair(productId)));
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return book details as {@link String}
     * **/
    public String getProductBook(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT, GET_METHOD);
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return book details as {@link JSONObject}
     * **/
    public JSONObject getProductBookJSON(String productId) throws Exception {
        return new JSONObject(getProductBook(productId));
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return book details as {@link Book} custom object
     * **/
    public Book getProductBookObject(String productId) throws Exception {
        return new Book(new JSONObject(getProductBook(productId)).put("productId", productId));
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @param level: type of format for result
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return book details as {@link String}
     * **/
    public String getProductBook(String productId, int level) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT + "?level=" + level,
                GET_METHOD);
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @param level: type of format for result
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return book details as {@link JSONObject}
     * **/
    public JSONObject getProductBookJSON(String productId, int level) throws Exception {
        return new JSONObject(getProductBook(productId, level));
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @param level: type of format for result
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return book details as {@link Book} custom object
     * **/
    public Book getProductBookObject(String productId, int level) throws Exception {
        return new Book(new JSONObject(getProductBook(productId, level)).put("productId", productId));
    }

    /** Custom request to get all products book details <br>
     * Any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return all products book details as {@link String}
     * **/
    public String getAllProductsBook() throws Exception {
        return getAllProductsBookJSON().toString();
    }

    /** Custom request to get all products book details <br>
     * Any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return all products book details as {@link JSONArray}
     * **/
    public JSONArray getAllProductsBookJSON() throws Exception {
        JSONArray jsonPairs = getAllTradingPairsJSON();
        JSONArray books = new JSONArray();
        for (int j = 0; j < jsonPairs.length(); j++){
            String productId = jsonPairs.getJSONObject(j).getString("id");
            books.put(getProductBookJSON(productId).put("productId", productId));
        }
        return books;
    }

    /** Custom request to get all products book details <br>
     * Any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return all products book details {@link ArrayList} of {@link Book}
     * **/
    public ArrayList<Book> getAllProductsBookList() throws Exception {
        return assembleBooksList(getAllProductsBookJSON());
    }

    /** Custom request to get all products book details <br>
     * @param level: type of format for result
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return all products book details as {@link String}
     * **/
    public String getAllProductsBook(int level) throws Exception {
        return getAllProductsBookJSON(level).toString();
    }

    /** Custom request to get all products book details <br>
     * @param level: type of format for result
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return all products book details as {@link JSONArray}
     * **/
    public JSONArray getAllProductsBookJSON(int level) throws Exception {
        JSONArray jsonPairs = getAllTradingPairsJSON();
        JSONArray books = new JSONArray();
        for (int j = 0; j < jsonPairs.length(); j++){
            String productId = jsonPairs.getJSONObject(j).getString("id");
            books.put(getProductBookJSON(productId, level).put("productId", productId));
        }
        return books;
    }

    /** Custom request to get all products book details <br>
     * @param level: type of format for result
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1</a>
     * @return all products book details {@link ArrayList} of {@link Book}
     * **/
    public ArrayList<Book> getAllProductsBookList(int level) throws Exception {
        return assembleBooksList(getAllProductsBookJSON(level));
    }

    /** Method to assemble a books list
     * @param jsonBooks: jsonArray obtained by response request
     * @return books list as {@link ArrayList} of {@link Book}
     * **/
    private ArrayList<Book> assembleBooksList(JSONArray jsonBooks){
        ArrayList<Book> books = new ArrayList<>();
        for (int j = 0; j < jsonBooks.length(); j++) {
            JSONObject jsonBook = jsonBooks.getJSONObject(j);
            books.add(new Book(jsonBook));
        }
        return books;
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1</a>
     * @return candles as {@link String}
     * **/
    public String getProductCandles(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT, GET_METHOD);
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1</a>
     * @return candles as {@link JSONArray}
     * **/
    public JSONArray getProductCandlesJSON(String productId) throws Exception {
        return new JSONArray(getProductCandles(productId));
    }

    /** Request to get candles list
     * @param productId: identifier of candle es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1</a>
     * @return candles list as {@link ArrayList} of {@link Candle}
     * **/
    public ArrayList<Candle> getProductCandlesList(String productId) throws Exception {
        return assembleCandlesList(new JSONArray(getProductCandles(productId)));
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are granularity, start, end)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1</a>
     * @return candles as {@link String}
     * **/
    public String getProductCandles(String productId, Params queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT +
                        queryParams.createQueryString(), GET_METHOD);
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are granularity, start, end)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1</a>
     * @return candles as {@link JSONArray}
     * **/
    public JSONArray getProductCandlesJSON(String productId, Params queryParams) throws Exception {
        return new JSONArray(getProductCandles(productId, queryParams));
    }

    /** Request to get candles list
     * @param productId: identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are granularity, start, end)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles-1</a>
     * @return candles list as {@link ArrayList} of {@link Candle}
     * **/
    public ArrayList<Candle> getProductCandlesList(String productId, Params queryParams) throws Exception {
        return assembleCandlesList(new JSONArray(getProductCandles(productId, queryParams)));
    }

    /** Method to assemble a candle list
     * @param jsonCandles: jsonArray obtained by response request
     * @return candle list as {@link ArrayList} of {@link Candle}
     * **/
    private ArrayList<Candle> assembleCandlesList(JSONArray jsonCandles){
        ArrayList<Candle> candles = new ArrayList<>();
        for (int j = 0; j < jsonCandles.length(); j++)
            candles.add(new Candle(jsonCandles.getJSONArray(j)));
        return candles;
    }

    /** Request to get product stats
     * @param productId: identifier of product stats es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1</a>
     * @return product stats as {@link String}
     * **/
    public String getProductStats(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_STAT_ENDPOINT, GET_METHOD);
    }

    /** Request to get product stats
     * @param productId: identifier of product stats es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1</a>
     * @return product stats as {@link JSONObject}
     * **/
    public JSONObject getProductStatsJSON(String productId) throws Exception {
        return new JSONObject(getProductStats(productId));
    }

    /** Request to get product stats
     * @param productId: identifier of product stats es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1</a>
     * @return product stats as {@link Stat} custom object
     * **/
    public Stat getProductStatsObject(String productId) throws Exception {
        return new Stat(new JSONObject(getProductStats(productId)).put("productId", productId));
    }

    /** Custom request to get all products stats <br>
     * Any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1</a>
     * @return all products stats as {@link String}
     * **/
    public String getAllProductsStats() throws Exception {
        return getAllProductsStatsJSON().toString();
    }

    /** Custom request to get all products stats <br>
     * Any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1</a>
     * @return all products stats as {@link JSONObject}
     * **/
    public JSONArray getAllProductsStatsJSON() throws Exception {
        JSONArray jsonPairs = getAllTradingPairsJSON();
        JSONArray stats = new JSONArray();
        for (int j = 0; j < jsonPairs.length(); j++){
            String productId = jsonPairs.getJSONObject(j).getString("id");
            stats.put(getProductStatsJSON(productId).put("productId", productId));
        }
        return stats;
    }

    /** Custom request to get all products stats list <br>
     * Any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats-1</a>
     * @return all products stats as {@link ArrayList} of {@link Stat}
     * **/
    public ArrayList<Stat> getAllProductsStatsList() throws Exception {
        ArrayList<Stat> stats = new ArrayList<>();
        JSONArray jsonStats = getAllProductsStatsJSON();
        for (int j = 0; j < jsonStats.length(); j++){
            JSONObject jsonStat = jsonStats.getJSONObject(j);
            Stat stat = assembleStatObject(jsonStat.getString("productId"), jsonStat);
            if(stat != null)
                stats.add(stat);
        }
        return stats;
    }

    /** Method to assemble a stat object
     * @param productId: ticker identifier value
     * @param jsonStat: jsonObject obtained by response request
     * @return stat as {@link Stat} or null if not exists
     * **/
    private Stat assembleStatObject(String productId, JSONObject jsonStat) {
        try {
            return new Stat(productId,
                    jsonStat.getDouble("open"),
                    jsonStat.getDouble("high"),
                    jsonStat.getDouble("low"),
                    jsonStat.getDouble("volume"),
                    jsonStat.getDouble("last"),
                    jsonStat.getDouble("volume_30day")
            );
        } catch (JSONException e) {
            return null;
        }
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1</a>
     * @return product stats as {@link String}
     * **/
    public String getProductTicker(String productId) throws Exception {
        return getProductTickerJSON(productId).toString();
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1</a>
     * @return product stats as {@link JSONObject}
     * **/
    public JSONObject getProductTickerJSON(String productId) throws Exception {
        try {
            JSONObject ticker = new JSONObject(sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TICKER_ENDPOINT,
                    GET_METHOD));
            ticker.put("productId", productId);
            String[] details = productId.split("-");
            ticker.put("baseAsset", details[0]);
            ticker.put("quoteAsset", details[1]);
            ticker.put("priceChangePercent", getPriceChangePercent(productId, ticker.getDouble("price")));
            return ticker;
        } catch (JSONException e) {
            return null;
        }
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1</a>
     * @return product stats as {@link Ticker} custom object
     * **/
    public Ticker getProductTickerObject(String productId) throws Exception {
        return assembleTickerObject(getProductTickerJSON(productId));
    }

    /** Custom request to get product all tickers list
     * Any params required
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1</a>
     * @return all tickers list as {@link String}
     * **/
    public String getAllTickers() throws Exception {
        return getAllTickersJSON().toString();
    }

    /** Custom request to get product all tickers list
     * Any params required
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1</a>
     * @return all tickers list as {@link JSONArray}
     * **/
    public JSONArray getAllTickersJSON() throws Exception {
        JSONArray jsonPairs = getAllTradingPairsJSON();
        JSONArray tickersList = new JSONArray();
        for (int j = 0; j < jsonPairs.length(); j++) {
            JSONObject ticker = getProductTickerJSON(jsonPairs.getJSONObject(j).getString("id"));
            if(ticker != null)
                tickersList.put(ticker);
        }
        return tickersList;
    }

    /** Custom request to get product all tickers list <br>
     * Any params required
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker-1</a>
     * @return all tickers list as {@link ArrayList} of {@link Ticker}
     * **/
    public ArrayList<Ticker> getAllTickersList() throws Exception {
        ArrayList<Ticker> tickers = new ArrayList<>();
        JSONArray jsonTickers = getAllTickersJSON();
        for (int j = 0; j < jsonTickers.length(); j++) {
            Ticker ticker = assembleTickerObject(jsonTickers.getJSONObject(j));
            if(ticker != null)
                tickers.add(ticker);
        }
        return tickers;
    }

    /**
     * Method to assemble a ticker object
     *
     * @param jsonTicker: jsonArray obtained by response request
     * @return ticker as {@link Ticker}
     * @implNote this request add to the original json from {@code "Coinbase"} some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     **/
    private Ticker assembleTickerObject(JSONObject jsonTicker) {
        try {
            String productId = jsonTicker.getString("productId");
            return new Ticker(jsonTicker.put("productId", productId).put("priceChangePercent",
                    getPriceChangePercent(productId, jsonTicker.getDouble("price"))));
        } catch (Exception e) {
            return null;
        }
    }

    /** Method to get price change percent
     * @param productId: product identifier value
     * @param price: price value for product
     * @return price change percent as double
     * **/
    private double getPriceChangePercent(String productId, double price) throws Exception {
        JSONArray candles = getProductCandlesJSON(productId);
        return getTrendPercent(new Candle(candles.getJSONArray(candles.length() - 1)).getClose(), price);
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1</a>
     * @return product trades as {@link String}
     * **/
    public String getProductTrades(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT, GET_METHOD);
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1</a>
     * @return product trades as {@link JSONArray}
     * **/
    public JSONArray getProductTradesJSON(String productId) throws Exception {
        return new JSONArray(getProductTrades(productId));
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1</a>
     * @return product trades list as {@link ArrayList} of {@link Trade}
     * **/
    public ArrayList<Trade> getProductTradesList(String productId) throws Exception {
        return assembleTradesList(new JSONArray(getProductTrades(productId)));
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are limit, before, after)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1</a>
     * @return product trades as {@link String}
     * **/
    public String getProductTrades(String productId, Params queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT + 
                        queryParams.createQueryString(), GET_METHOD);
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are limit, before, after)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1</a>
     * @return product trades as {@link JSONArray}
     * **/
    public JSONArray getProductTradesJSON(String productId, Params queryParams) throws Exception {
        return new JSONArray(getProductTrades(productId, queryParams));
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are limit, before, after)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades-1</a>
     * @return product trades as {@link ArrayList} of {@link Trade}
     * **/
    public ArrayList<Trade> getProductTradesList(String productId, Params queryParams) throws Exception {
        return assembleTradesList(new JSONArray(getProductTrades(productId, queryParams)));
    }

    /** Method to assemble a trades list
     * @param jsonTrades: jsonArray obtained by response request
     * @return trades list as {@link ArrayList} of {@link Trade}
     * **/
    private ArrayList<Trade> assembleTradesList(JSONArray jsonTrades){
        ArrayList<Trade> trades = new ArrayList<>();
        for (int j = 0; j < jsonTrades.length(); j++)
            trades.add(new Trade(jsonTrades.getJSONObject(j)));
        return trades;
    }

    /** Method to get forecast of a cryptocurrency in base of days's gap inserted
     * @param productId: productId to calculate forecast es. BTC-USD
     * @param intervalDays: days gap for the prevision range
     * @param granularity: interval for candles
     * @param toleranceValue: tolerance for select similar value compared to lastValue inserted
     * @return forecast value as a double es. 8 or -8
     * @throws IllegalArgumentException if lastValue is negative or intervalDays are less or equal to 0
     * **/
    public double getSymbolForecast(String productId, int intervalDays, int granularity, double toleranceValue) throws Exception {
        ArrayList<Double> historicalValues = new ArrayList<>();
        Params intervalMap = new Params();
        intervalMap.addParam("granularity", granularity);
        for (Candle candle : getProductCandlesList(productId, intervalMap))
            historicalValues.add(candle.getHigh());
        return computeTPTOPIndex(historicalValues, getProductStatsObject(productId).getLast(), intervalDays, toleranceValue);
    }

    /** Method to get forecast of a cryptocurrency in base of days's gap inserted
     * @param productId: productId to calculate forecast es. BTC-USD
     * @param intervalDays: days gap for the prevision range
     * @param granularity: interval for candles
     * @param toleranceValue: tolerance for select similar value compared to lastValue inserted
     * @param decimalDigits: number of digits to round final forecast value
     * @return forecast value as a double es. 8 or -8
     * @throws IllegalArgumentException if lastValue is negative or intervalDays are less or equal to 0
     * **/
    public double getSymbolForecast(String productId, int intervalDays, int granularity, double toleranceValue,
                                    int decimalDigits) throws Exception {
        return roundValue(getSymbolForecast(productId, intervalDays, granularity, toleranceValue), decimalDigits);
    }

}
