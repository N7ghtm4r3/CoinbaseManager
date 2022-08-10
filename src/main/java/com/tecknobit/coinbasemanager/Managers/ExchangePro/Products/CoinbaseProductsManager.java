package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.Tools.Trading.TradingTools.computeTPTOPAsset;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.*;

/**
 * The {@code CoinbaseProductsManager} class is useful to manage all Coinbase products endpoints
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseProductsManager extends CoinbaseManager {

    /**
     * {@code tradingPairsList} is instance that memorizes all trading pairs list
     * **/
    private static JSONArray tradingPairsList = new JSONArray();

    /**
     * {@code previousLoadPairsList} is instance that memorizes previous timestamp of loading {@link #tradingPairsList}
     * **/
    private long previousLoadPairsList;

    /** Constructor to init a {@link CoinbaseProductsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a {@link CoinbaseProductsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a {@link CoinbaseProductsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a {@link CoinbaseProductsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to get all trading pairs
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
     * @return all trading pairs as {@link String}
     * **/
    public String getAllTradingPairs() throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT, GET_METHOD);
    }

    /** Request to get all trading pairs
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
     * @return all trading pairs as {@link JSONArray}
     * **/
    public JSONArray getAllTradingPairsJSON() throws Exception {
        long actualTimestamp = System.currentTimeMillis();
        if(tradingPairsList.isEmpty() || ((actualTimestamp - previousLoadPairsList) >= (3600 * 1000))){
            previousLoadPairsList = actualTimestamp;
            return tradingPairsList = new JSONArray(getAllTradingPairs());
        }
        return tradingPairsList;
    }

    /** Request to get all trading pairs
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
     * @return all trading pairs list as {@link ArrayList} of {@link TradingPair}
     * **/
    public ArrayList<TradingPair> getAllTradingPairsList() throws Exception {
        return assembleTradingPairsList(new JSONArray(getAllTradingPairs()));
    }

    /** Request to get all trading pairs
     * @param type: type of trading pairs to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
     * @return all trading pairs as {@link String}
     * **/
    public String getAllTradingPairs(String type) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "?type=" + type, GET_METHOD);
    }

    /** Request to get all trading pairs
     * @param type: type of trading pairs to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
     * @return all trading pairs as {@link JSONArray}
     * **/
    public JSONArray getAllTradingPairsJSON(String type) throws Exception {
        return new JSONArray(getAllTradingPairs(type));
    }

    /** Request to get all trading pairs
     * @param type: type of trading pairs to fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
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
                tradingPairs.add(assembleTradingPairObject(jsonTradings.getJSONObject(j)));
        return tradingPairs;
    }

    /** Request to get single trading pair
     * @param productId: identifier of trading pair es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct</a>
     * @return single trading pair as {@link String}
     * **/
    public String getSingleTradingPair(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId, GET_METHOD);
    }

    /** Request to get single trading pair
     * @param productId: identifier of trading pair es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangere stapi_getproduct</a>
     * @return single trading pair as {@link JSONObject}
     * **/
    public JSONObject getSingleTradingPairJSON(String productId) throws Exception {
        return new JSONObject(getSingleTradingPair(productId));
    }

    /** Request to get single trading pair
     * @param productId: identifier of trading pair es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct</a>
     * @return single trading pair as {@link TradingPair} object
     * **/
    public TradingPair getSingleTradingPairObject(String productId) throws Exception {
        return assembleTradingPairObject(new JSONObject(getSingleTradingPair(productId)));
    }

    /** Method to assemble a TradingPair object
     * @param jsonTrading: jsonObject obtained by response request
     * @return trading pair as {@link TradingPair} object
     * **/
    private TradingPair assembleTradingPairObject(JSONObject jsonTrading){
        return new TradingPair(jsonTrading.getString("id"),
                jsonTrading.getString("base_currency"),
                jsonTrading.getString("quote_currency"),
                jsonTrading.getDouble("base_min_size"),
                jsonTrading.getDouble("base_max_size"),
                jsonTrading.getDouble("quote_increment"),
                jsonTrading.getDouble("base_increment"),
                jsonTrading.getString("display_name"),
                jsonTrading.getDouble("min_market_funds"),
                jsonTrading.getDouble("max_market_funds"),
                jsonTrading.getBoolean("margin_enabled"),
                jsonTrading.getBoolean("post_only"),
                jsonTrading.getBoolean("limit_only"),
                jsonTrading.getBoolean("cancel_only"),
                jsonTrading.getString("status"),
                jsonTrading.getString("status_message"),
                jsonTrading.getBoolean("auction_mode")
        );
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return book details as {@link String}
     * **/
    public String getProductBook(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT, GET_METHOD);
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return book details as {@link JSONObject}
     * **/
    public JSONObject getProductBookJSON(String productId) throws Exception {
        return new JSONObject(getProductBook(productId));
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return book details as {@link Book} object
     * **/
    public Book getProductBookObject(String productId) throws Exception {
        return assembleBookObject(productId, new JSONObject(getProductBook(productId)));
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @param level: type of format for result
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return book details as {@link String}
     * **/
    public String getProductBook(String productId, int level) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT + "?level=" + level,
                GET_METHOD);
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @param level: type of format for result
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return book details as {@link JSONObject}
     * **/
    public JSONObject getProductBookJSON(String productId, int level) throws Exception {
        return new JSONObject(getProductBook(productId, level));
    }

    /** Request to get book details
     * @param productId: identifier of book es. BTC-USD
     * @param level: type of format for result
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return book details as {@link Book} object
     * **/
    public Book getProductBookObject(String productId, int level) throws Exception {
        return assembleBookObject(productId, new JSONObject(getProductBook(productId, level)));
    }

    /** Custom request to get all products book details <br>
     * Any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return all products book details as {@link String}
     * **/
    public String getAllProductsBook() throws Exception {
        return getAllProductsBookJSON().toString();
    }

    /** Custom request to get all products book details <br>
     * Any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
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
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return all products book details {@link ArrayList} of {@link Book}
     * **/
    public ArrayList<Book> getAllProductsBookList() throws Exception {
        return assembleBooksList(getAllProductsBookJSON());
    }

    /** Custom request to get all products book details <br>
     * @param level: type of format for result
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
     * @return all products book details as {@link String}
     * **/
    public String getAllProductsBook(int level) throws Exception {
        return getAllProductsBookJSON(level).toString();
    }

    /** Custom request to get all products book details <br>
     * @param level: type of format for result
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
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
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
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
            Book book = assembleBookObject(jsonBook.getString("productId"), jsonBook);
            if(book != null)
                books.add(book);
        }
        return books;
    }

    /** Method to assemble a book object
     * @param productId: ticker identifier value
     * @param jsonBook: jsonObject obtained by response request
     * @return book as {@link Book} object or null if not exists
     * **/
    private Book assembleBookObject(String productId, JSONObject jsonBook){
        try {
            return new Book(productId,
                    jsonBook.getLong("sequence"),
                    jsonBook.getBoolean("auction_mode"),
                    JsonHelper.getString(jsonBook, "auction"),
                    jsonBook
            );
        }catch (JSONException e){
            return null;
        }
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
     * @return candles as {@link String}
     * **/
    public String getProductCandles(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT, GET_METHOD);
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
     * @return candles as {@link JSONArray}
     * **/
    public JSONArray getProductCandlesJSON(String productId) throws Exception {
        return new JSONArray(getProductCandles(productId));
    }

    /** Request to get candles list
     * @param productId: identifier of candle es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
     * @return candles list as {@link ArrayList} of {@link Candle}
     * **/
    public ArrayList<Candle> getProductCandlesList(String productId) throws Exception {
        return assembleCandlesList(new JSONArray(getProductCandles(productId)));
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are granularity,start,end)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
     * @return candles as {@link String}
     * **/
    public String getProductCandles(String productId, Params queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT +
                        queryParams.createQueryString(), GET_METHOD);
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are granularity,start,end)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
     * @return candles as {@link JSONArray}
     * **/
    public JSONArray getProductCandlesJSON(String productId, Params queryParams) throws Exception {
        return new JSONArray(getProductCandles(productId, queryParams));
    }

    /** Request to get candles list
     * @param productId: identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are granularity,start,end)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
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
        for (int j = 0; j < jsonCandles.length(); j++){
            JSONArray candle = jsonCandles.getJSONArray(j);
            candles.add(new Candle(candle.getLong(3),
                    candle.getDouble(2),
                    candle.getDouble(1),
                    candle.getDouble(5),
                    candle.getLong(0),
                    candle.getDouble(4)
            ));
        }
        return candles;
    }

    /** Request to get product stats
     * @param productId: identifier of product stats es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
     * @return product stats as {@link String}
     * **/
    public String getProductStats(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_STAT_ENDPOINT, GET_METHOD);
    }

    /** Request to get product stats
     * @param productId: identifier of product stats es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
     * @return product stats as {@link JSONObject}
     * **/
    public JSONObject getProductStatsJSON(String productId) throws Exception {
        return new JSONObject(getProductStats(productId));
    }

    /** Request to get product stats
     * @param productId: identifier of product stats es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
     * @return product stats as {@link Stat} object
     * **/
    public Stat getProductStatsObject(String productId) throws Exception {
        return assembleStatObject(productId, new JSONObject(getProductStats(productId)));
    }

    /** Custom request to get all products stats <br>
     * Any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
     * @return all products stats as {@link String}
     * **/
    public String getAllProductsStats() throws Exception {
        return getAllProductsStatsJSON().toString();
    }

    /** Custom request to get all products stats <br>
     * Any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
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
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
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
    private Stat assembleStatObject(String productId, JSONObject jsonStat){
        try {
            return new Stat(productId,
                    jsonStat.getDouble("open"),
                    jsonStat.getDouble("high"),
                    jsonStat.getDouble("low"),
                    jsonStat.getDouble("volume"),
                    jsonStat.getDouble("last"),
                    jsonStat.getDouble("volume_30day")
            );
        }catch (JSONException e){
            return null;
        }
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return product stats as {@link String}
     * **/
    public String getProductTicker(String productId) throws Exception {
        return getProductTickerJSON(productId).toString();
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
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
        }catch (JSONException e){
            return null;
        }
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return product stats as {@link Ticker} object
     * **/
    public Ticker getProductTickerObject(String productId) throws Exception {
        return assembleTickerObject(getProductTickerJSON(productId));
    }

    /** Custom request to get product all tickers list
     * any params required
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return all tickers list as {@link String}
     * **/
    public String getAllTickers() throws Exception {
        return getAllTickersJSON().toString();
    }

    /** Custom request to get product all tickers list
     * any params required
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
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
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
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

    /** Method to assemble a ticker object
     * @param jsonTicker: jsonArray obtained by response request
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset,
     * quote asset and price change percent value.
     * @return ticker as {@link Ticker}
     * **/
    private Ticker assembleTickerObject(JSONObject jsonTicker){
        try {
            String productId = jsonTicker.getString("productId");
            double price = jsonTicker.getDouble("price");
            return new Ticker(jsonTicker.getLong("trade_id"),
                    price,
                    jsonTicker.getDouble("size"),
                    jsonTicker.getString("time"),
                    productId,
                    jsonTicker.getString("baseAsset"),
                    jsonTicker.getString("quoteAsset"),
                    jsonTicker.getDouble("bid"),
                    jsonTicker.getDouble("ask"),
                    jsonTicker.getDouble("volume"),
                    getPriceChangePercent(productId, price));
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
        Candle candle = Candle.assembleCandle(candles.getJSONArray(candles.length() - 1));
        return getTrendPercent(candle.getClose(), price, 2);
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     * @return product trades as {@link String}
     * **/
    public String getProductTrades(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT, GET_METHOD);
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     * @return product trades as {@link JSONArray}
     * **/
    public JSONArray getProductTradesJSON(String productId) throws Exception {
        return new JSONArray(getProductTrades(productId));
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     * @return product trades list as {@link ArrayList} of {@link Trade}
     * **/
    public ArrayList<Trade> getProductTradesList(String productId) throws Exception {
        return assembleTradesList(new JSONArray(getProductTrades(productId)));
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are limit,before,after)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     * @return product trades as {@link String}
     * **/
    public String getProductTrades(String productId, Params queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT + 
                        queryParams.createQueryString(), GET_METHOD);
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are limit,before,after)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     * @return product trades as {@link JSONArray}
     * **/
    public JSONArray getProductTradesJSON(String productId, Params queryParams) throws Exception {
        return new JSONArray(getProductTrades(productId, queryParams));
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are limit,before,after)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
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
        for (int j = 0; j < jsonTrades.length(); j++){
            JSONObject trade = jsonTrades.getJSONObject(j);
            trades.add(new Trade(trade.getLong("trade_id"),
                    trade.getDouble("price"),
                    trade.getDouble("size"),
                    trade.getString("time"),
                    trade.getString("side")
            ));
        }
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
        return computeTPTOPAsset(historicalValues, getProductStatsObject(productId).getLast(), intervalDays,toleranceValue);
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
