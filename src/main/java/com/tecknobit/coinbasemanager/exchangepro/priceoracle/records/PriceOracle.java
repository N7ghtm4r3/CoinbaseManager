package com.tecknobit.coinbasemanager.exchangepro.priceoracle.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code PriceOracle} class is useful to format PriceOracle object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle">
 * Get signed prices</a>
 **/
public class PriceOracle {

    /**
     * {@code timestamp} is instance that memorizes timestamp in <b>seconds</b> format
     **/
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

    /**
     * Constructor to init a {@link PriceOracle} custom object
     *
     * @param timestamp:  indicates when the latest datapoint was obtained in <b>seconds</b> format
     * @param messages:   list of messages as {@link ArrayList} of {@link String}
     * @param signatures: array of Ethereum-compatible ECDSA signatures for each message
     * @param prices:     contains human-readable asset prices
     **/
    public PriceOracle(long timestamp, ArrayList<String> messages, ArrayList<String> signatures, ArrayList<Price> prices) {
        this.timestamp = timestamp;
        this.messages = messages;
        this.signatures = signatures;
        this.prices = prices;
    }

    /**
     * Constructor to init a {@link PriceOracle} custom object
     *
     * @param priceOracle: price oracle details as {@link JSONObject}
     **/
    public PriceOracle(JSONObject priceOracle) {
        this.timestamp = priceOracle.getLong("timestamp");
        messages = assembleStringList(priceOracle.getJSONArray("messages"));
        signatures = assembleStringList(priceOracle.getJSONArray("signatures"));
        prices = new ArrayList<>();
        loadPricesList(priceOracle.getJSONObject("prices"));
    }

    /**
     * Method to assemble a string list
     *
     * @param jsonList: jsonObject obtained by response request
     * @return string list as {@link ArrayList} of {@link String}
     **/
    @Returner
    private ArrayList<String> assembleStringList(JSONArray jsonList) {
        ArrayList<String> list = new ArrayList<>();
        for (int j = 0; j < jsonList.length(); j++)
            list.add(jsonList.getString(j));
        return list;
    }

    /**
     * Method to assemble a prices list
     *
     * @param jsonPrices: jsonObject obtained by response request
     *                    any return
     **/
    private void loadPricesList(JSONObject jsonPrices) {
        for (String key : jsonPrices.keySet())
            prices.add(new Price(key, jsonPrices.getDouble(key)));
    }

    /**
     * Method to get {@link #timestamp} <b>seconds</b> format <br>
     * No-any params required
     *
     * @return {@link #timestamp} instance as long
     **/
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Method to get {@link #timestamp} instance <br>
     * No-any params required
     *
     * @return {@link #timestamp} instance as {@link Date} with {@link #timestamp} in <b>milliseconds</b> format
     **/
    public Date getDate() {
        return TimeFormatter.getDate(timestamp * 1000);
    }

    /**
     * Method to get {@link #messages} instance <br>
     * No-any params required
     *
     * @return {@link #messages} instance as {@link ArrayList} of {@link String}
     **/
    public ArrayList<String> getMessages() {
        return messages;
    }

    /**
     * Method to get {@link #signatures} instance <br>
     * No-any params required
     *
     * @return {@link #signatures} instance as {@link ArrayList} of {@link String}
     **/
    public ArrayList<String> getSignatures() {
        return signatures;
    }

    /**
     * Method to get {@link #prices} instance <br>
     * No-any params required
     *
     * @return {@link #prices} instance as {@link ArrayList} of {@link Price}
     **/
    public ArrayList<Price> getPrices() {
        return prices;
    }

    /**
     * Returns a string representation of the object <br>
     * No-any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

    /**
     * The {@code Price} class is useful to obtain and format Price objects for PriceOracle
     * This class give info about each price in prices list
     *
     * @author N7ghtm4r3 - Tecknobit
     **/
    public static class Price{

        /**
         * {@code symbol} is instance that memorizes symbol value
         * **/
        private final String symbol;

        /**
         * {@code price} is instance that memorizes price value
         * **/
        private double price;

        /** Constructor to init a {@link Price} custom object
         * @param symbol: symbol value
         * @param price: price value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public Price(String symbol, double price) {
            this.symbol = symbol;
            if (price < 0)
                throw new IllegalArgumentException("Price value cannot be less than 0");
            else
                this.price = price;
        }

        /**
         * Method to get {@link #symbol} instance <br>
         * No-any params required
         *
         * @return {@link #symbol} instance as {@link String}
         **/
        public String getSymbol() {
            return symbol;
        }

        /**
         * Method to get {@link #price} instance <br>
         * No-any params required
         *
         * @return {@link #price} instance as double
         **/
        public double getPrice() {
            return price;
        }

        /**
         * Method to set {@link #price}
         *
         * @param price: price value
         * @throws IllegalArgumentException when price value is less than 0
         **/
        public void setPrice(double price) {
            if (price < 0)
                throw new IllegalArgumentException("Price value cannot be less than 0");
            this.price = price;
        }

        /**
         * Method to get {@link #price} instance
         *
         * @param decimals: number of digits to round final value
         * @return {@link #price} instance rounded with decimal digits inserted
         * @throws IllegalArgumentException if decimalDigits is negative
         **/
        public double getPrice(int decimals) {
            return roundValue(price, decimals);
        }

        /**
         * Returns a string representation of the object <br>
         * No-any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

}
