package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.*;

/**
 * The {@code CoinbaseProductsManager} class is useful to manage all Coinbase products endpoints
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducts</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseProductsManager extends CoinbaseManager {

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
        return new JSONArray(getAllTradingPairs());
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
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproduct</a>
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
        return assembleBookObject(new JSONObject(getProductBook(productId)));
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
        return assembleBookObject(new JSONObject(getProductBook(productId, level)));
    }

    /** Method to assemble a book object
     * @param jsonBook: jsonObject obtained by response request
     * @return book as {@link Book} object
     * **/
    private Book assembleBookObject(JSONObject jsonBook){
        jsonHelper = new JsonHelper(jsonBook);
        return new Book(jsonBook.getLong("sequence"),
                jsonBook.getBoolean("auction_mode"),
                jsonHelper.getString("auction"),
                jsonBook
        );
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
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
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
    public String getProductCandles(String productId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT +
                        assembleQueryParams("", queryParams), GET_METHOD);
    }

    /** Request to get candles
     * @param productId: identifier of candle es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are granularity,start,end)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductcandles</a>
     * @return candles as {@link JSONArray}
     * **/
    public JSONArray getProductCandlesJSON(String productId, HashMap<String, Object> queryParams) throws Exception {
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
    public ArrayList<Candle> getProductCandlesList(String productId, HashMap<String, Object> queryParams) throws Exception {
        return assembleCandlesList(new JSONArray(getProductCandles(productId, queryParams)));
    }

    /** Method to assemble a candle list
     * @param jsonCandles: jsonArray obtained by response request
     * @return candle list as {@link ArrayList} of {@link Candle}
     * **/
    private ArrayList<Candle> assembleCandlesList(JSONArray jsonCandles){
        ArrayList<Candle> candles = new ArrayList<>();
        for (int j=0; j < jsonCandles.length(); j++){
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
        jsonObject = new JSONObject(getProductStats(productId));
        return new Stat(jsonObject.getDouble("open"),
                jsonObject.getDouble("high"),
                jsonObject.getDouble("low"),
                jsonObject.getDouble("volume"),
                jsonObject.getDouble("last"),
                jsonObject.getDouble("volume_30day")
        );
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return product stats as {@link String}
     * **/
    public String getProductTicker(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TICKER_ENDPOINT, GET_METHOD);
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset
     * and quoteAsset and is possible only in JSON and custom Object type requests, but not in simple String return type.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return product stats as {@link JSONObject}
     * **/
    public JSONObject getProductTickerJSON(String productId) throws Exception {
        jsonObject = new JSONObject(getProductTicker(productId));
        jsonObject.put("productId", productId);
        String[] details = productId.split("-");
        jsonObject.put("baseAsset", details[0]);
        jsonObject.put("quoteAsset", details[1]);
        return jsonObject;
    }

    /** Request to get product ticker
     * @param productId: identifier of product ticker es. BTC-USD
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset
     * and quoteAsset and is possible only in JSON and custom Object type requests, but not in simple {@link String} return type.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return product stats as {@link Ticker} object
     * **/
    public Ticker getProductTickerObject(String productId) throws Exception {
        return assembleTickerObject(getProductTickerJSON(productId));
    }

    /** Custom request to get product all tickers list
     * any params required
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset
     * and quoteAsset and is possible only in JSON and custom Object type requests, and in this case also for normal {@link String} return type
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return all tickers list as {@link String}
     * **/
    public String getAllTickers() throws Exception {
        return getAllTickersJSON().toString();
    }

    /** Custom request to get product all tickers list
     * any params required
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset
     * and quoteAsset and is possible only in JSON and custom Object type requests, but not in simple {@link String} return type.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return all tickers list as {@link JSONArray}
     * **/
    public JSONArray getAllTickersJSON() throws Exception {
        jsonArray = getAllTradingPairsJSON();
        JSONArray tickersList = new JSONArray();
        for (int j = 0; j < jsonArray.length(); j++)
            tickersList.put(getProductTickerJSON(jsonArray.getJSONObject(j).getString("id")));
        return tickersList;
    }

    /** Custom request to get product all tickers list <br>
     * Any params required
     * @implNote this request add to the original json from Coinbase some custom parameters like: productId, baseAsset
     * and quoteAsset and is possible only in JSON and custom Object type requests, but not in simple {@link String} return type.
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductticker</a>
     * @return all tickers list as {@link ArrayList} of {@link Ticker}
     * **/
    public ArrayList<Ticker> getAllTickersList() throws Exception {
        ArrayList<Ticker> tickers = new ArrayList<>();
        jsonArray = getAllTickersJSON();
        for (int j = 0; j < jsonArray.length(); j++) {
            Ticker ticker = assembleTickerObject(jsonArray.getJSONObject(j));
            if(ticker != null)
                tickers.add(ticker);
        }
        return tickers;
    }

    /** Method to assemble a ticker object
     * @param jsonTicker: jsonArray obtained by response request
     * @implNote this method add to the original json from Coinbase some custom parameters like: productId, baseAsset
     * and quoteAsset and is possible only in JSON and custom Object type requests, but not in simple {@link String} return type.
     * @return ticker as {@link Ticker}
     * **/
    private Ticker assembleTickerObject(JSONObject jsonTicker){
        try {
            return new Ticker(jsonTicker.getLong("trade_id"),
                    jsonTicker.getDouble("price"),
                    jsonTicker.getDouble("size"),
                    jsonTicker.getString("time"),
                    jsonTicker.getString("productId"),
                    jsonTicker.getString("baseAsset"),
                    jsonTicker.getString("quoteAsset"),
                    jsonTicker.getDouble("bid"),
                    jsonTicker.getDouble("ask"),
                    jsonTicker.getDouble("volume")
            );
        }catch (JSONException e){
            return null;
        }
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
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     * @return product trades as {@link String}
     * **/
    public String getProductTrades(String productId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT +
                assembleQueryParams("", queryParams), GET_METHOD);
    }

    /** Request to get product trades
     * @param productId: identifier of product trades es. BTC-USD
     * @param queryParams: extra query params of request
     * @implSpec (keys accepted are limit,before,after)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     * @return product trades as {@link JSONArray}
     * **/
    public JSONArray getProductTradesJSON(String productId, HashMap<String, Object> queryParams) throws Exception {
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
    public ArrayList<Trade> getProductTradesList(String productId, HashMap<String, Object> queryParams) throws Exception {
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
    public double getSymbolForecast(String productId, int intervalDays, int granularity, int toleranceValue) throws Exception {
        ArrayList<Double> historicalValues = new ArrayList<>();
        HashMap<String, Object> intervalMap = new HashMap<>();
        intervalMap.put("granularity", granularity);
        for (Candle candle : getProductCandlesList(productId, intervalMap))
            historicalValues.add(candle.getHigh());
        return tradingTools.computeTPTOPAsset(historicalValues, getProductStatsObject(productId).getLast(),
                intervalDays,toleranceValue);
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
    public double getSymbolForecast(String productId, int intervalDays, int granularity, int toleranceValue, int decimalDigits) throws Exception {
        return tradingTools.roundValue(getSymbolForecast(productId, intervalDays, granularity, toleranceValue), decimalDigits);
    }

}
