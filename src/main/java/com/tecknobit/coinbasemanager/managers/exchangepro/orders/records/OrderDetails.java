package com.tecknobit.coinbasemanager.managers.exchangepro.orders.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code OrderDetails} class is useful to format general OrderDetails object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
 * Get all fills</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders-1">
 * Get all orders</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders-1">
 * Cancel all orders</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders-1">
 * Create a new order</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder-1">
 * Get single order</a>
 * </li>
 * </ul>
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
     **/
    private final boolean settled;

    /**
     * {@code orderHelper} is instance that help to work with {@link OrderDetails}
     **/
    protected final JsonHelper orderHelper;

    /**
     * Constructor to init a {@link OrderDetails} custom object
     *
     * @param createdAt: created at value
     * @param productId: product identifier value
     * @param profileId: profile identifier value
     * @param price:     price value
     * @param size:      size value
     * @param side:      side value (buy or sell)
     * @param settled:   flag that checks if order is settled
     **/
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

    /** Constructor to init a {@link OrderDetails} custom object
     * @param orderDetails: orderDetails details as {@link JSONObject}
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

    /**
     * Method to get {@link #createdAt} instance <br>
     * Any params required
     *
     * @return {@link #createdAt} instance as {@link String}
     **/
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to get {@link #createdAt} timestamp <br>
     * Any params required
     *
     * @return {@link #createdAt} timestamp as long
     **/
    public long getCreatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(createdAt);
    }

    /**
     * Method to get {@link #productId} instance <br>
     * Any params required
     *
     * @return {@link #productId} instance as {@link String}
     **/
    public String getProductId() {
        return productId;
    }

    /**
     * Method to get {@link #profileId} instance <br>
     * Any params required
     *
     * @return {@link #profileId} instance as {@link String}
     **/
    public String getProfileId() {
        return profileId;
    }

    /**
     * Method to get {@link #price} instance <br>
     * Any params required
     *
     * @return {@link #price} instance as double
     **/
    public double getPrice() {
        return price;
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
     * Method to get {@link #size} instance <br>
     * Any params required
     *
     * @return {@link #size} instance as double
     **/
    public double getSize() {
        return size;
    }

    /**
     * Method to get {@link #size} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #size} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getSize(int decimals) {
        return roundValue(size, decimals);
    }

    /**
     * Method to get {@link #side} instance <br>
     * Any params required
     *
     * @return {@link #side} instance as {@link String}
     **/
    public String getSide() {
        return side;
    }

    /**
     * Method to get {@link #settled} instance <br>
     * Any params required
     *
     * @return {@link #settled} instance as boolean
     **/
    public boolean isSettled() {
        return settled;
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
