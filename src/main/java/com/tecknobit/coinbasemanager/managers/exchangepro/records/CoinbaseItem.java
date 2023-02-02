package com.tecknobit.coinbasemanager.managers.exchangepro.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONObject;

/**
 * The {@code CoinbaseItem} class is useful to format a Coinbase item
 *
 * @author N7ghtm4r3 - Tecknobit
 * @since 1.1.2
 **/
public class CoinbaseItem {

    /**
     * {@code hItem} useful to manage the JSON data for an item
     **/
    protected final JsonHelper hItem;

    /**
     * Constructor to init a {@link CoinbaseItem} custom object
     *
     * @param jItem: item details as {@link JSONObject}
     **/
    public CoinbaseItem(JSONObject jItem) {
        if (jItem != null)
            hItem = new JsonHelper(jItem);
        else
            hItem = null;
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
