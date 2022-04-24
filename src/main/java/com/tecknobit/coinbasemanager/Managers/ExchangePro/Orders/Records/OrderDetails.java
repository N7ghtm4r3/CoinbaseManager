package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

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
