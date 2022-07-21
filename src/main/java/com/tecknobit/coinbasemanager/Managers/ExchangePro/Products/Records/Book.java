package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * The {@code Book} class is useful to format Book object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductbook</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Book {

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
    private final ArrayList<String> asks;

    /**
     * {@code bids} is instance that memorizes list of bids
     * **/
    private final ArrayList<String> bids;

    /** Constructor to init a {@link Book} object
     * @param sequence: sequence value
     * @param auctionMode: flag that checks if book is in auction mode
     * @param auction: auction value
     * @param jsonBook: book details in JSON format
     * **/
    public Book(long sequence, boolean auctionMode, String auction, JSONObject jsonBook) {
        this.sequence = sequence;
        this.auctionMode = auctionMode;
        this.auction = auction;
        asks = assembleStringList(jsonBook.getJSONArray("asks"));
        bids = assembleStringList(jsonBook.getJSONArray("bids"));
    }

    /** Method to assemble a string list
     * @param jsonList: jsonArray obtained by response request
     * @return strings list as {@link ArrayList} of {@link String}
     * **/
    private ArrayList<String> assembleStringList(JSONArray jsonList){
        ArrayList<String> strings = new ArrayList<>();
        for (int j = 0; j < jsonList.length(); j++){
            JSONArray list = jsonList.getJSONArray(j);
            for (int i = 0; i < list.length(); i++) {
                try {
                    strings.add(list.getString(i));
                }catch (JSONException e){
                    strings.add(valueOf(list.getDouble(i)));
                }
            }
        }
        return strings;
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

    public ArrayList<String> getAsks() {
        return asks;
    }

    public String getAsk(int index){
        return asks.get(index);
    }

    public ArrayList<String> getBids() {
        return bids;
    }

    public String getBid(int index){
        return bids.get(index);
    }


}
