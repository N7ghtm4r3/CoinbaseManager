package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code OrderDetails} class is useful to format general OrderDetails object
 * @apiNote see the official documentation at:
<ul>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1</a>
</li>
</ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public abstract class OrderDetails {

    /**
     * {@code createdAt} is instance that memorizes created at value
     **/
    private final String createdAt;

    /**
     * {@code productId} is instance that memorizes product identifier value
     **/
    private final String productId;

    /**
     * {@code profileId} is instance that memorizes profile identifier value
     * **/
    private final String profileId;

    /**
     * {@code price} is instance that memorizes price value
     * **/
    private final double price;

    /**
     * {@code size} is instance that memorizes size value
     * **/
    private final double size;

    /**
     * {@code side} is instance that memorizes side value (buy or sell)
     * **/
    private final String side;

    /**
     * {@code settled} is flag that checks if order is settled
     * **/
    private final boolean settled;

    /**
     * {@code orderHelper} is instance that help to work with {@link OrderDetails}
     * **/
    protected final JsonHelper orderHelper;

    /** Constructor to init a {@link OrderDetails} object
     * @param createdAt: created at value
     * @param productId: product identifier value
     * @param profileId: profile identifier value
     * @param price: price value
     * @param size: size value
     * @param side: side value (buy or sell)
     * @param settled: flag that checks if order is settled
     * **/
    public OrderDetails(String createdAt, String productId, String profileId, double price, double size, String side,
                        boolean settled) {
        this.createdAt = createdAt;
        this.productId = productId;
        this.profileId = profileId;
        this.price = price;
        this.size = size;
        this.side = side;
        this.settled = settled;
        orderHelper = null;
    }

    /** Constructor to init a {@link OrderDetails} object
     * @param orderDetails: orderDetails details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public OrderDetails(JSONObject orderDetails) {
        orderHelper = new JsonHelper(orderDetails);
        createdAt = orderHelper.getString("created_at");
        productId = orderHelper.getString("product_id");
        profileId = orderHelper.getString("profile_id");
        price = orderHelper.getDouble("price");
        size = orderHelper.getDouble("size");
        side = orderHelper.getString("side");
        settled = orderHelper.getBoolean("settled");
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getProductId() {
        return productId;
    }

    public String getProfileId() {
        return profileId;
    }

    public double getPrice() {
        return price;
    }

    /** Method to get {@link #price} instance
     * @param decimals: number of digits to round final value
     * @return {@link #price} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getPrice(int decimals) {
        return roundValue(price, decimals);
    }

    public double getSize() {
        return size;
    }

    /** Method to get {@link #size} instance
     * @param decimals: number of digits to round final value
     * @return {@link #size} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getSize(int decimals) {
        return roundValue(size, decimals);
    }

    public String getSide() {
        return side;
    }

    public boolean isSettled() {
        return settled;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "createdAt='" + createdAt + '\'' +
                ", productId='" + productId + '\'' +
                ", profileId='" + profileId + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", side='" + side + '\'' +
                ", settled=" + settled +
                '}';
    }

}
