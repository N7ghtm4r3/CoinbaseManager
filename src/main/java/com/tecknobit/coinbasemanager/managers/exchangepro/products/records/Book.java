package com.tecknobit.coinbasemanager.managers.exchangepro.products.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Book} class is useful to format Book object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook-1">
 * Get product book</a>
 **/
public class Book {

    /**
     * {@code productId} is instance that memorizes product identifier value
     * **/
    private final String productId;

    /**
     * {@code sequence} is instance that memorizes sequence value
     * **/
    private final long sequence;

    /**
     * {@code auctionMode} is flag that checks if book is in auction mode
     * **/
    private final boolean auctionMode;

    /**
     * {@code auction} is instance that memorizes auction value
     * **/
    private final String auction;

    /**
     * {@code asks} is instance that memorizes list of asks
     * **/
    private final ArrayList<Double> asks;

    /**
     * {@code bids} is instance that memorizes list of bids
     * **/
    private final ArrayList<Double> bids;

    /**
     * Constructor to init a {@link Book} custom object
     *
     * @param productId:   book identifier value
     * @param sequence:    sequence value
     * @param auctionMode: flag that checks if book is in auction mode
     * @param auction:     auction value
     * @param asks:        list of asks
     * @param bids:        list of bids
     **/
    public Book(String productId, long sequence, boolean auctionMode, String auction, ArrayList<Double> asks,
                ArrayList<Double> bids) {
        this.productId = productId;
        this.sequence = sequence;
        this.auctionMode = auctionMode;
        this.auction = auction;
        this.asks = asks;
        this.bids = bids;
    }

    /**
     * Constructor to init a {@link Book} custom object
     *
     * @param book: book details as {@link JSONObject}
     **/
    public Book(JSONObject book) {
        JsonHelper hBook = new JsonHelper(book);
        productId = hBook.getString("productId");
        sequence = hBook.getLong("sequence", -1);
        auctionMode = hBook.getBoolean("auction_mode");
        auction = hBook.getString("auction");
        asks = assembleMarketList(hBook.getJSONArray("asks", new JSONArray()));
        bids = assembleMarketList(hBook.getJSONArray("bids", new JSONArray()));
    }

    /**
     * MethodId to assemble a doubles list
     *
     * @param jsonList: jsonArray obtained by response request
     * @return doubles list as {@link ArrayList} of {@link Double}
     **/
    @Returner
    private ArrayList<Double> assembleMarketList(JSONArray jsonList) {
        ArrayList<Double> values = new ArrayList<>();
        for (int j = 0; j < jsonList.length(); j++) {
            JSONArray list = jsonList.getJSONArray(j);
            for (int i = 0; i < list.length(); i++)
                values.add(list.getDouble(i));
        }
        return values;
    }

    /**
     * MethodId to get {@link #productId} instance <br>
     * Any params required
     *
     * @return {@link #productId} instance as {@link String}
     **/
    public String getProductId() {
        return productId;
    }

    /**
     * MethodId to get {@link #sequence} instance <br>
     * Any params required
     *
     * @return {@link #sequence} instance as long
     **/
    public long getSequence() {
        return sequence;
    }

    /**
     * MethodId to get {@link #auctionMode} instance <br>
     * Any params required
     *
     * @return {@link #auctionMode} instance as boolean
     **/
    public boolean isAuctionMode() {
        return auctionMode;
    }

    /**
     * MethodId to get {@link #auction} instance <br>
     * Any params required
     *
     * @return {@link #auction} instance as {@link String}
     **/
    public String getAuction() {
        return auction;
    }

    /**
     * MethodId to get {@link #asks} instance <br>
     * Any params required
     *
     * @return {@link #asks} instance as {@link ArrayList} of {@link Double}
     **/
    public ArrayList<Double> getAsks() {
        return asks;
    }

    /**
     * MethodId to get an ask from {@link #asks}
     *
     * @param index: index of the ask to get
     * @return ask as double
     **/
    public double getAsk(int index) {
        return asks.get(index);
    }

    /**
     * MethodId to get {@link #bids} instance <br>
     * Any params required
     *
     * @return {@link #bids} instance as {@link ArrayList} of {@link Double}
     **/
    public ArrayList<Double> getBids() {
        return bids;
    }

    /**
     * MethodId to get an bid from {@link #bids}
     *
     * @param index: index of the bid to get
     * @return bid as double
     **/
    public double getBid(int index) {
        return bids.get(index);
    }

    /**
     * Returns a string representation of the object <br>
     * Any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
