package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

/**
 * The {@code OrderDetails} class is useful to format general OrderDetails object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorders
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteorders
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postorders
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getorder
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class OrderDetails {

    private final String createdAt;
    private final String productId;
    private final String profileId;
    private final double price;
    private final double size;
    private final String side;
    private final boolean settled;

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
