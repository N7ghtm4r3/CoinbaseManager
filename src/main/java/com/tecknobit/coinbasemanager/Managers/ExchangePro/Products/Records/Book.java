package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Book {

    private final long sequence;
    private final boolean auctionMode;
    private final String auction;
    private final ArrayList<String> asks;
    private final ArrayList<String> bids;

    public Book(long sequence, boolean auctionMode, String auction, JSONObject jsonBook) {
        this.sequence = sequence;
        this.auctionMode = auctionMode;
        this.auction = auction;
        asks = assembleStringList(jsonBook.getJSONArray("asks"));
        bids = assembleStringList(jsonBook.getJSONArray("bids"));
    }

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

    public ArrayList<String> getBids() {
        return bids;
    }

}
