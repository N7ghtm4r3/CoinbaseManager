package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

/**
 * The {@code Order} class is useful to format Order object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Order extends OrderDetails{

    /**Constants used in order requests**/
    public static final String STATUS_OPEN = "open";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_REJECTED = "rejected";
    public static final String STATUS_DONE = "done";
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_RECEIVED = "received";
    public static final String STATUS_ALL = "all";
    public static final String CREATED_AT_SORTER = "created_at";
    public static final String PRICE_SORTER = "price";
    public static final String SIZE_SORTER = "size";
    public static final String ORDER_ID_SORTER = "order_id";
    public static final String SIDE_SORTER = "side";
    public static final String TYPE_SORTER = "type";
    public static final String DESC_SORTING_ORDER = "desc";
    public static final String ASC_SORTING_ORDER = "asc";
    public static final String LIMIT_TYPE = "limit";
    public static final String MARKET_TYPE = "market";
    public static final String STOP_TYPE = "stop";
    public static final String BUY_SIDE = "buy";
    public static final String SELL_SIDE = "sell";
    public static final String STP_DC = "dc";
    public static final String STP_CO = "co";
    public static final String STP_CN = "cn";
    public static final String STP_CB = "cb";
    public static final String STOP_LOSS = "loss";
    public static final String STOP_ENTRY = "entry";
    public static final String GTC_TIME_IN_FORCE = "GTC";
    public static final String GTT_TIME_IN_FORCE = "GTT";
    public static final String IOC_TIME_IN_FORCE = "IOC";
    public static final String FOK_TIME_IN_FORCE = "FOK";
    public static final String CANCEL_AFTER_MIN = "min";
    public static final String CANCEL_AFTER_HOUR = "hour";
    public static final String CANCEL_AFTER_DAY = "day";

    private final String id;
    private final String type;
    private final String timeInForce;
    private final boolean postOnly;
    private final double fillFees;
    private final double filledSize;
    private final double executedValue;
    private final String status;

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

    public double getFilledSize() {
        return filledSize;
    }

    public double getExecutedValue() {
        return executedValue;
    }

    public String getStatus() {
        return status;
    }

}
