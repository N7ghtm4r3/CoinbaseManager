package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code Order} class is useful to format Order object
 * @apiNote see official documentation at:
 <ul>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder</a>
     </li>
 </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Order extends OrderDetails {

    /**
     * {@code STATUS_OPEN} is constant for open status
     * **/
    public static final String STATUS_OPEN = "open";

    /**
     * {@code STATUS_PENDING} is constant for pending status
     * **/
    public static final String STATUS_PENDING = "pending";

    /**
     * {@code STATUS_REJECTED} is constant for rejected status
     * **/
    public static final String STATUS_REJECTED = "rejected";

    /**
     * {@code STATUS_DONE} is constant for done status
     * **/
    public static final String STATUS_DONE = "done";

    /**
     * {@code STATUS_ACTIVE} is constant for active status
     * **/
    public static final String STATUS_ACTIVE = "active";

    /**
     * {@code STATUS_RECEIVED} is constant for received status
     * **/
    public static final String STATUS_RECEIVED = "received";

    /**
     * {@code STATUS_ALL} is constant for all status
     * **/
    public static final String STATUS_ALL = "all";

    /**
     * {@code CREATED_AT_SORTER} is constant for created at sorter
     * **/
    public static final String CREATED_AT_SORTER = "created_at";

    /**
     * {@code price} is constant for price sorter
     * **/
    public static final String PRICE_SORTER = "price";

    /**
     * {@code SIZE_SORTER} is constant for size sorter
     * **/
    public static final String SIZE_SORTER = "size";

    /**
     * {@code ORDER_ID_SORTER} is constant for order identifier sorter
     * **/
    public static final String ORDER_ID_SORTER = "order_id";

    /**
     * {@code SIDE_SORTER} is constant for side sorter
     * **/
    public static final String SIDE_SORTER = "side";

    /**
     * {@code TYPE_SORTER} is constant for type sorter
     * **/
    public static final String TYPE_SORTER = "type";

    /**
     * {@code DESC_SORTING_ORDER} is constant for desc order
     * **/
    public static final String DESC_SORTING_ORDER = "desc";

    /**
     * {@code ASC_SORTING_ORDER} is constant for asc order
     * **/
    public static final String ASC_SORTING_ORDER = "asc";

    /**
     * {@code LIMIT_TYPE} is constant for limit type
     * **/
    public static final String LIMIT_TYPE = "limit";

    /**
     * {@code MARKET_TYPE} is constant for market type
     * **/
    public static final String MARKET_TYPE = "market";

    /**
     * {@code STOP_TYPE} is constant for stop type
     * **/
    public static final String STOP_TYPE = "stop";

    /**
     * {@code BUY_SIDE} is constant for buy side
     * **/
    public static final String BUY_SIDE = "buy";

    /**
     * {@code SELL_SIDE} is constant for sell side
     * **/
    public static final String SELL_SIDE = "sell";

    /**
     * {@code STP_DC} is constant for stp dc
     * **/
    public static final String STP_DC = "dc";

    /**
     * {@code STP_CO} is constant for stp co
     * **/
    public static final String STP_CO = "co";

    /**
     * {@code STP_CN} is constant for stp cn
     * **/
    public static final String STP_CN = "cn";

    /**
     * {@code STP_CB} is constant for stp cb
     * **/
    public static final String STP_CB = "cb";

    /**
     * {@code STOP_LOSS} is constant for loss value
     * **/
    public static final String STOP_LOSS = "loss";

    /**
     * {@code STOP_ENTRY} is constant for entry value
     * **/
    public static final String STOP_ENTRY = "entry";

    /**
     * {@code GTC_TIME_IN_FORCE} is constant for GTC time in force
     * **/
    public static final String GTC_TIME_IN_FORCE = "GTC";

    /**
     * {@code GTT_TIME_IN_FORCE} is constant for GTT time in force
     * **/
    public static final String GTT_TIME_IN_FORCE = "GTT";

    /**
     * {@code IOC_TIME_IN_FORCE} is constant for IOC time in force
     * **/
    public static final String IOC_TIME_IN_FORCE = "IOC";

    /**
     * {@code FOK_TIME_IN_FORCE} is constant for FOK time in force
     * **/
    public static final String FOK_TIME_IN_FORCE = "FOK";

    /**
     * {@code CANCEL_AFTER_MINUTE} is constant to cancel after minute
     * **/
    public static final String CANCEL_AFTER_MINUTE = "min";

    /**
     * {@code CANCEL_AFTER_HOUR} is constant to cancel after hour
     * **/
    public static final String CANCEL_AFTER_HOUR = "hour";

    /**
     * {@code CANCEL_AFTER_DAY} is constant to cancel after day
     * **/
    public static final String CANCEL_AFTER_DAY = "day";

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code type} is instance that memorizes type value
     * **/
    private final String type;

    /**
     * {@code timeInForce} is instance that memorizes time in force value
     * **/
    private final String timeInForce;

    /**
     * {@code postOnly} is flag that checks if is post only
     * **/
    private final boolean postOnly;

    /**
     * {@code fillFees} is instance that memorizes fill fees value
     * **/
    private final double fillFees;

    /**
     * {@code filledSize} is instance that memorizes filled size value
     * **/
    private final double filledSize;

    /**
     * {@code executedValue} is instance that memorizes executed value
     * **/
    private final double executedValue;

    /**
     * {@code status} is instance that memorizes status value
     * **/
    private final String status;

    /** Constructor to init a {@link Order} object
     * @param createdAt: created at value
     * @param productId: product identifier value
     * @param profileId: profile identifier value
     * @param price: price value
     * @param size: size value
     * @param side: side value (buy or sell)
     * @param settled: flag that checks if order is settled
     * @param id: identifier value
     * @param type: type value
     * @param timeInForce: time in force value
     * @param postOnly: flag that checks if is post only
     * @param fillFees: fill fees value
     * @param filledSize: filled size value
     * @param executedValue: executed value
     * @param status: status value
     * **/
    public Order(String createdAt, String productId, String profileId, double price, double size, String side,
                 boolean settled, String id, String type, String timeInForce, boolean postOnly, double fillFees,
                 double filledSize, double executedValue, String status) {
        super(createdAt, productId, profileId, price, size, side, settled);
        this.id = id;
        this.type = type;
        this.timeInForce = timeInForce;
        this.postOnly = postOnly;
        this.fillFees = fillFees;
        this.filledSize = filledSize;
        this.executedValue = executedValue;
        this.status = status;
    }

    /** Constructor to init a {@link Order} object
     * @param order: order details as {@link JSONObject}
     **/
    public Order(JSONObject order) {
        super(order);
        id = orderHelper.getString("id");
        type = orderHelper.getString("type");
        timeInForce = orderHelper.getString("time_in_force");
        postOnly = orderHelper.getBoolean("post_only");
        fillFees = orderHelper.getDouble("fill_fees");
        filledSize = orderHelper.getDouble("filled_size");
        executedValue = orderHelper.getDouble("executed_value");
        status = orderHelper.getString("status");
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public double getFillFees() {
        return fillFees;
    }

    /** Method to get {@link #fillFees} instance
     * @param decimals: number of digits to round final value
     * @return {@link #fillFees} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getFillFees(int decimals) {
        return roundValue(fillFees, decimals);
    }

    public double getFilledSize() {
        return filledSize;
    }

    /** Method to get {@link #filledSize} instance
     * @param decimals: number of digits to round final value
     * @return {@link #filledSize} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getFilledSize(int decimals) {
        return roundValue(filledSize, decimals);
    }

    public double getExecutedValue() {
        return executedValue;
    }

    /** Method to get {@link #executedValue} instance
     * @param decimals: number of digits to round final value
     * @return {@link #executedValue} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getExecutedValue(int decimals) {
        return roundValue(executedValue, decimals);
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", timeInForce='" + timeInForce + '\'' +
                ", postOnly=" + postOnly +
                ", fillFees=" + fillFees +
                ", filledSize=" + filledSize +
                ", executedValue=" + executedValue +
                ", status='" + status + '\'' +
                '}';
    }

}
