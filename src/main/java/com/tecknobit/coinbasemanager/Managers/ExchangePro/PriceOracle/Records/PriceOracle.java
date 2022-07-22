package com.tecknobit.coinbasemanager.Managers.ExchangePro.PriceOracle.Records;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code PriceOracle} class is useful to format PriceOracle object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class PriceOracle {

    /**
     * {@code timestamp} is instance that memorizes timestamp value
     * **/
    private final long timestamp;

    /**
     * {@code messages} is instance that memorizes list of messages
     * **/
    private final ArrayList<String> messages;

    /**
     * {@code signatures} is instance that memorizes list of signatures
     * **/
    private final ArrayList<String> signatures;

    /**
     * {@code prices} is instance that memorizes list of {@link Price}
     * **/
    private final ArrayList<Price> prices;

    /** Constructor to init a {@link PriceOracle} object
     * @param timestamp: timestamp value
     * @param jsonPriceOracle: price oracle details in JSON format
     * **/
    public PriceOracle(long timestamp, JSONObject jsonPriceOracle) {
        this.timestamp = timestamp;
        messages = assembleStringList(jsonPriceOracle.getJSONArray("messages"));
        signatures = assembleStringList(jsonPriceOracle.getJSONArray("signatures"));
        prices = new ArrayList<>();
        loadPricesList(jsonPriceOracle.getJSONObject("prices"));
    }

    /** Method to assemble a string list
     * @param jsonList: jsonObject obtained by response request
     * @return string list as {@link ArrayList} of {@link String}
     * **/
    private ArrayList<String> assembleStringList(JSONArray jsonList){
        ArrayList<String> list = new ArrayList<>();
        for (int j=0; j < jsonList.length(); j++)
            list.add(jsonList.getString(j));
        return list;
    }

    /** Method to assemble a prices list
     * @param jsonPrices: jsonObject obtained by response request
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

    @Override
    public String toString() {
        return "PriceOracle{" +
                "timestamp=" + timestamp +
                ", messages=" + messages +
                ", signatures=" + signatures +
                ", prices=" + prices +
                '}';
    }

    /**
     * The {@code Price} class is useful to obtain and format Price objects for PriceOracle
     * This class give info about each price in prices list
     * @author N7ghtm4r3 - Tecknobit
     * **/
    public static class Price{

        /**
         * {@code symbol} is instance that memorizes symbol value
         * **/
        private final String symbol;

        /**
         * {@code price} is instance that memorizes price value
         * **/
        private double price;

        /** Constructor to init a {@link Price} object
         * @param symbol: symbol value
         * @param price: price value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public Price(String symbol, double price) {
            this.symbol = symbol;
            if(price < 0)
                throw new IllegalArgumentException("Price value cannot be less than 0");
            else
                this.price = price;
        }

        public String getSymbol() {
            return symbol;
        }

        public double getPrice() {
            return price;
        }

        /** Method to set {@link #price}
         * @param price: price value
         * @throws IllegalArgumentException when price value is less than 0
         * **/
        public void setPrice(double price) {
            if(price < 0)
                throw new IllegalArgumentException("Price value cannot be less than 0");
            this.price = price;
        }

        @Override
        public String toString() {
            return "Price{" +
                    "symbol='" + symbol + '\'' +
                    ", price=" + price +
                    '}';
        }

    }

}
