package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Book} class is useful to format Book object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

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
     * Constructor to init a {@link Book} object
     * @param productId: book identifier value
     * @param sequence: sequence value
     * @param auctionMode: flag that checks if book is in auction mode
     * @param auction: auction value
     * @param jsonBook: book details in JSON format
     **/
    public Book(String productId, long sequence, boolean auctionMode, String auction, JSONObject jsonBook) {
        this.productId = productId;
        this.sequence = sequence;
        this.auctionMode = auctionMode;
        this.auction = auction;
        asks = assembleMarketList(jsonBook.getJSONArray("asks"));
        bids = assembleMarketList(jsonBook.getJSONArray("bids"));
    }

    /**
     * Constructor to init a {@link Book} object
     * @param productId: book identifier value
     * @param book: book details as {@link JSONObject}
     **/
    public Book(String productId, JSONObject book) {
        JsonHelper hBook = new JsonHelper(book);
        this.productId = productId;
        this.sequence = hBook.getLong("sequence", -1);
        this.auctionMode = hBook.getBoolean("auction_mode");
        this.auction = hBook.getString("auction");
        asks = assembleMarketList(hBook.getJSONArray("asks", new JSONArray()));
        bids = assembleMarketList(hBook.getJSONArray("bids", new JSONArray()));
    }

    /** Method to assemble a doubles list
     * @param jsonList: jsonArray obtained by response request
     * @return doubles list as {@link ArrayList} of {@link String}
     * **/
    private ArrayList<Double> assembleMarketList(JSONArray jsonList){
        ArrayList<Double> values = new ArrayList<>();
        for (int j = 0; j < jsonList.length(); j++){
            JSONArray list = jsonList.getJSONArray(j);
            for (int i = 0; i < list.length(); i++)
                values.add(list.getDouble(i));
        }
        return values;
    }

    public String getProductId() {
        return productId;
    }

    public long getSequence() {
        return sequence;
    }

    public boolean isAuctionMode() {
        return auctionMode;
    }

    public String getAuction() {
        return auction;
    }

    public ArrayList<Double> getAsks() {
        return asks;
    }

    public Double getAsk(int index){
        return asks.get(index);
    }

    public ArrayList<Double> getBids() {
        return bids;
    }

    public Double getBid(int index){
        return bids.get(index);
    }

    @Override
    public String toString() {
        return "Book{" +
                "productId='" + productId + '\'' +
                ", sequence=" + sequence +
                ", auctionMode=" + auctionMode +
                ", auction='" + auction + '\'' +
                ", asks=" + asks +
                ", bids=" + bids +
                '}';
    }

}
