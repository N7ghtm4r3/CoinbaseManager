package com.tecknobit.coinbasemanager.Managers.ExchangePro.PriceOracle.Records;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code PriceOracle} class is useful to format PriceOracle object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PriceOracle {

    private final long timestamp;
    private final ArrayList<String> messages;
    private final ArrayList<String> signatures;
    private final ArrayList<Price> prices;

    public PriceOracle(long timestamp, JSONObject jsonPriceOracle) {
        this.timestamp = timestamp;
        messages = assembleStringList(jsonPriceOracle.getJSONArray("messages"));
        signatures = assembleStringList(jsonPriceOracle.getJSONArray("signatures"));
        prices = new ArrayList<>();
        loadPricesList(jsonPriceOracle.getJSONObject("prices"));
    }

    /** Method to assemble a string list
     * @param #jsonList: jsonObject obtained by response request
     * @return string list as {@link ArrayList} of {@link String}
     * **/
    private ArrayList<String> assembleStringList(JSONArray jsonList){
        ArrayList<String> list = new ArrayList<>();
        for (int j=0; j < jsonList.length(); j++)
            list.add(jsonList.getString(j));
        return list;
    }

    /** Method to assemble a prices list
     * @param #jsonPrices: jsonObject obtained by response request
     * any return
     * **/
    private void loadPricesList(JSONObject jsonPrices) {
        for (String key : jsonPrices.keySet())
            prices.add(new Price(key, jsonPrices.getDouble(key)));
    }

    public long getTimestamp() {
        return timestamp;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public ArrayList<String> getSignatures() {
        return signatures;
    }

    public ArrayList<Price> getPrices() {
        return prices;
    }

    /**
     * The {@code Price} class is useful to obtain and format Price object for PriceOracle
     * This class give info about each price in prices list
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses</a>
     * **/
    public static class Price{

        private final String symbol;
        private double price;

        public Price(String symbol, double price) {
            this.symbol = symbol;
            this.price = price;
        }

        public String getSymbol() {
            return symbol;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            if(price < 0)
                throw new IllegalArgumentException("Price value cannot be less than 0");
            this.price = price;
        }

    }

}
