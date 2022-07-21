package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

/**
 * The {@code OrderDetails} class is useful to format general OrderDetails object
 * @apiNote see official documentation at:
 <ul>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills</a>
     </li>
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

public class OrderDetails {

    /**
     * {@code createdAt} is instance that memorizes created at value
     * **/
    private final String createdAt;

    /**
     * {@code productId} is instance that memorizes product identifier value
     * **/
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

    public double getSize() {
        return size;
    }

    public String getSide() {
        return side;
    }

    public boolean isSettled() {
        return settled;
    }

}
