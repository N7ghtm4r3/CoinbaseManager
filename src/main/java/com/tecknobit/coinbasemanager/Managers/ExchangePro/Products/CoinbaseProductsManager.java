package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products;

import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.*;

public class CoinbaseProductsManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseProducts manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseProducts manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseProducts manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseProducts manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseProductsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String getAllTradingPairs() throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT, GET_METHOD);
    }

    public JSONArray getAllTradingPairsJSON() throws Exception {
        return new JSONArray(getAllTradingPairs());
    }

    public ArrayList<TradingPair> getAllTradingPairsList() throws Exception {
        return assembleTradingPairsList(new JSONArray(getAllTradingPairs()));
    }

    public String getAllTradingPairs(String type) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "?type="+type, GET_METHOD);
    }

    public JSONArray getAllTradingPairsJSON(String type) throws Exception {
        return new JSONArray(getAllTradingPairs(type));
    }

    public ArrayList<TradingPair> getAllTradingPairsList(String type) throws Exception {
        return assembleTradingPairsList(new JSONArray(getAllTradingPairs(type)));
    }

    private ArrayList<TradingPair> assembleTradingPairsList(JSONArray jsonTradings){
        ArrayList<TradingPair> tradingPairs = new ArrayList<>();
        for (int j=0; j < jsonTradings.length(); j++)
            tradingPairs.add(assembleTradingPairObject(jsonTradings.getJSONObject(j)));
        return tradingPairs;
    }

    public String getSingleTradingPair(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId, GET_METHOD);
    }

    public JSONObject getSingleTradingPairJSON(String productId) throws Exception {
        return new JSONObject(getSingleTradingPair(productId));
    }

    public TradingPair getSingleTradingPairObject(String productId) throws Exception {
        return assembleTradingPairObject(new JSONObject(getSingleTradingPair(productId)));
    }

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

    public String getProductBook(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT, GET_METHOD);
    }

    public JSONObject getProductBookJSON(String productId) throws Exception {
        return new JSONObject(getProductBook(productId));
    }

    public Book getProductBookObject(String productId) throws Exception {
        return assembleBookObject(new JSONObject(getProductBook(productId)));
    }

    public String getProductBook(String productId, int level) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_BOOK_ENDPOINT + "?level=" + level
                , GET_METHOD);
    }

    public JSONObject getProductBookJSON(String productId, int level) throws Exception {
        return new JSONObject(getProductBook(productId, level));
    }

    public Book getProductBookObject(String productId, int level) throws Exception {
        return assembleBookObject(new JSONObject(getProductBook(productId, level)));
    }

    private Book assembleBookObject(JSONObject jsonBook){
        jsonHelper = new JsonHelper(jsonBook);
        return new Book(jsonBook.getLong("sequence"),
                jsonBook.getBoolean("auction_mode"),
                jsonHelper.getString("auction"),
                jsonBook
        );
    }

    public String getProductCandles(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT, GET_METHOD);
    }

    public JSONArray getProductCandlesJSON(String productId) throws Exception {
        return new JSONArray(getProductCandles(productId));
    }

    public ArrayList<Candle> getProductCandlesList(String productId) throws Exception {
        return assembleCandlesList(new JSONArray(getProductCandles(productId)));
    }

    public String getProductCandles(String productId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_CANDLE_ENDPOINT +
                        assembleQueryParams("", queryParams), GET_METHOD);
    }

    public JSONArray getProductCandlesJSON(String productId, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getProductCandles(productId, queryParams));
    }

    public ArrayList<Candle> getProductCandlesList(String productId, HashMap<String, Object> queryParams) throws Exception {
        return assembleCandlesList(new JSONArray(getProductCandles(productId, queryParams)));
    }

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

    public String getProductStats(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_STAT_ENDPOINT, GET_METHOD);
    }

    public JSONObject getProductStatsJSON(String productId) throws Exception {
        return new JSONObject(getProductStats(productId));
    }

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

    public String getProductTicker(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TICKER_ENDPOINT, GET_METHOD);
    }

    public JSONObject getProductTickerJSON(String productId) throws Exception {
        return new JSONObject(getProductTicker(productId));
    }

    public Ticker getProductTickerObject(String productId) throws Exception {
        jsonObject = new JSONObject(getProductTicker(productId));
        return new Ticker(jsonObject.getLong("trade_id"),
                jsonObject.getDouble("price"),
                jsonObject.getDouble("size"),
                jsonObject.getString("time"),
                jsonObject.getDouble("bid"),
                jsonObject.getDouble("ask"),
                jsonObject.getDouble("volume")
        );
    }

    public String getProductTrades(String productId) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT, GET_METHOD);
    }

    public JSONArray getProductTradesJSON(String productId) throws Exception {
        return new JSONArray(getProductTrades(productId));
    }

    public ArrayList<Trade> getProductTradesList(String productId) throws Exception {
        return assembleTradesList(new JSONArray(getProductTrades(productId)));
    }

    public String getProductTrades(String productId, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(PRODUCTS_ENDPOINT + "/" + productId + GET_PRODUCT_TRADE_ENDPOINT +
                assembleQueryParams("",queryParams), GET_METHOD);
    }

    public JSONArray getProductTradesJSON(String productId, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getProductTrades(productId, queryParams));
    }

    public ArrayList<Trade> getProductTradesList(String productId, HashMap<String, Object> queryParams) throws Exception {
        return assembleTradesList(new JSONArray(getProductTrades(productId, queryParams)));
    }

    private ArrayList<Trade> assembleTradesList(JSONArray jsonCandles){
        ArrayList<Trade> trades = new ArrayList<>();
        for (int j=0; j < jsonCandles.length(); j++){
            JSONObject trade = jsonCandles.getJSONObject(j);
            trades.add(new Trade(trade.getLong("trade_id"),
                    trade.getDouble("price"),
                    trade.getDouble("size"),
                    trade.getString("time"),
                    trade.getString("side")
            ));
        }
        return trades;
    }

}
