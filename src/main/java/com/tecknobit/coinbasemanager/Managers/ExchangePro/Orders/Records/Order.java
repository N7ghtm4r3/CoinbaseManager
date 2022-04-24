package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

public class Order extends OrderDetails{

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
