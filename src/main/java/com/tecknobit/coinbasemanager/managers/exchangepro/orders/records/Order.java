package com.tecknobit.coinbasemanager.managers.exchangepro.orders.records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Order} class is useful to format Order object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders">
 * Get all orders</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders">
 * Cancel all orders</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders">
 * Create a new order</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder">
 * Get single order</a>
 * </li>
 * </ul>
 * @author N7ghtm4r3 - Tecknobit
 * @see OrderDetails
 * **/
public class Order extends OrderDetails {

    /**
     * {@code type} is instance that memorizes type value
     **/
    private final OrderType type;
    /**
     * {@code timeInForce} is instance that memorizes time in force value
     **/
    private final TimeInForce timeInForce;
    /**
     * {@code status} is instance that memorizes status value
     **/
    private final Status status;
    /**
     * {@code id} is instance that memorizes identifier value
     **/
    private final String id;
    /**
     * {@code postOnly} is flag that checks if is post only
     **/
    private final boolean postOnly;
    /**
     * {@code fillFees} is instance that memorizes fill fees value
     **/
    private final double fillFees;
    /**
     * {@code filledSize} is instance that memorizes filled size value
     **/
    private final double filledSize;
    /**
     * {@code executedValue} is instance that memorizes executed value
     **/
    private final double executedValue;

    /** Constructor to init a {@link Order} custom object
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
    public Order(String createdAt, String productId, String profileId, double price, double size, Side side,
                 boolean settled, String id, OrderType type, TimeInForce timeInForce, boolean postOnly, double fillFees,
                 double filledSize, double executedValue, Status status) {
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

    /**
     * Constructor to init a {@link Order} custom object
     *
     * @param order: order details as {@link JSONObject}
     **/
    public Order(JSONObject order) {
        super(order);
        id = orderHelper.getString("id");
        type = OrderType.valueOf(orderHelper.getString("type", OrderType.market.name()));
        timeInForce = TimeInForce.valueOf(orderHelper.getString("time_in_force", TimeInForce.GTC.name()));
        postOnly = orderHelper.getBoolean("post_only");
        fillFees = orderHelper.getDouble("fill_fees");
        filledSize = orderHelper.getDouble("filled_size");
        executedValue = orderHelper.getDouble("executed_value");
        status = Status.valueOf(orderHelper.getString("status", Status.all.name()));
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link String}
     **/
    public OrderType getType() {
        return type;
    }

    /**
     * Method to get {@link #timeInForce} instance <br>
     * No-any params required
     *
     * @return {@link #timeInForce} instance as {@link String}
     **/
    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    /**
     * Method to get {@link #status} instance <br>
     * No-any params required
     *
     * @return {@link #status} instance as {@link Status}
     **/
    public Status getStatus() {
        return status;
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * {@code Status} list of statuses available for an order
     **/
    public enum Status {

        /**
         * {@code "open"} status
         **/
        open,

        /**
         * {@code "pending"} status
         **/
        pending,

        /**
         * {@code "rejected"} status
         **/
        rejected,

        /**
         * {@code "done"} status
         **/
        done,

        /**
         * {@code "active"} status
         **/
        active,

        /**
         * {@code "received"} status
         **/
        received,

        /**
         * {@code "all"} status
         **/
        all

    }

    /**
     * {@code Sorter} list of sorters available for an order
     **/
    public enum Sorter {

        /**
         * {@code "created_at"} sorter
         **/
        created_at,

        /**
         * {@code "price"} sorter
         **/
        price,

        /**
         * {@code "size"} sorter
         **/
        size,

        /**
         * {@code "order_id"} sorter
         **/
        order_id,

        /**
         * {@code "side"} sorter
         **/
        side,

        /**
         * {@code "type"} sorter
         **/
        type

    }

    /**
     * {@code SortingOrder} list of sorting order available
     **/
    public enum SortingOrder {

        /**
         * {@code "desc"} sorting order
         **/
        desc,

        /**
         * {@code "asc"} sorting order
         **/
        asc

    }

    /**
     * {@code OrderType} list of order types available
     **/
    public enum OrderType {

        /**
         * {@code "limit"} order type
         **/
        limit,

        /**
         * {@code "market"} order type
         **/
        market,

        /**
         * {@code "stop"} order type
         **/
        stop

    }

    /**
     * {@code STP} list of stps types available
     **/
    public enum STP {

        /**
         * {@code "dc"} stp type
         **/
        dc,

        /**
         * {@code "co"} stp type
         **/
        co,

        /**
         * {@code "cn"} stp type
         **/
        cn,

        /**
         * {@code "cb"} stp type
         **/
        cb

    }

    /**
     * {@code StopType} list of stop types available
     **/
    public enum StopType {

        /**
         * {@code "loss"} stop type
         **/
        loss,

        /**
         * {@code "entry"} stop type
         **/
        entry

    }

    /**
     * {@code TimeInForce} list of time in force available
     **/
    public enum TimeInForce {

        /**
         * {@code "GTC"} time in force -> {@code "Good Till Canceled"}
         **/
        GTC,

        /**
         * {@code "GTT"} time in force -> {@code "Good Till Time"}
         **/
        GTT,

        /**
         * {@code "IOC"} time in force -> {@code "Immediate Or Cancel"}
         **/
        IOC,

        /**
         * {@code "FOK"} time in force -> {@code "Fill Or Kill"}
         **/
        FOK,

    }

    /**
     * Method to get {@link #postOnly} instance <br>
     * No-any params required
     *
     * @return {@link #postOnly} instance as boolean
     **/
    public boolean isPostOnly() {
        return postOnly;
    }

    /**
     * Method to get {@link #fillFees} instance <br>
     * No-any params required
     *
     * @return {@link #fillFees} instance as double
     **/
    public double getFillFees() {
        return fillFees;
    }

    /**
     * Method to get {@link #fillFees} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #fillFees} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getFillFees(int decimals) {
        return roundValue(fillFees, decimals);
    }

    /**
     * Method to get {@link #filledSize} instance <br>
     * No-any params required
     *
     * @return {@link #filledSize} instance as double
     **/
    public double getFilledSize() {
        return filledSize;
    }

    /**
     * Method to get {@link #filledSize} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #filledSize} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getFilledSize(int decimals) {
        return roundValue(filledSize, decimals);
    }

    /**
     * Method to get {@link #executedValue} instance <br>
     * No-any params required
     *
     * @return {@link #executedValue} instance as double
     **/
    public double getExecutedValue() {
        return executedValue;
    }

    /**
     * Method to get {@link #executedValue} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #executedValue} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getExecutedValue(int decimals) {
        return roundValue(executedValue, decimals);
    }

    /**
     * {@code CancelAfter} list of cancel after types available
     **/
    public enum CancelAfter {

        /**
         * {@code "min"} cancel after minute type
         **/
        min,

        /**
         * {@code "hour"} cancel after hour type
         **/
        hour,

        /**
         * {@code "day"} cancel after day type
         **/
        day

    }

}
