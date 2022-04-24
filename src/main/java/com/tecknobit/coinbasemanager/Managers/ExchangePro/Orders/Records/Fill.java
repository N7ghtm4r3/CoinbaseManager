package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

public class Fill {

    private final String createdAt;
    private final long tradeId;
    private final String productId;
    private final String orderId;
    private final String userId;
    private final String profileId;
    private final String liquidity;
    private final double price;
    private final double size;
    private final double fee;
    private final String side;
    private final boolean settled;
    private final double usdVolume;

    public Fill(String createdAt, long tradeId, String productId, String orderId, String userId, String profileId,
                String liquidity, double price, double size, double fee, String side, boolean settled, double usdVolume) {
        this.createdAt = createdAt;
        this.tradeId = tradeId;
        this.productId = productId;
        this.orderId = orderId;
        this.userId = userId;
        this.profileId = profileId;
        this.liquidity = liquidity;
        this.price = price;
        this.size = size;
        this.fee = fee;
        this.side = side;
        this.settled = settled;
        this.usdVolume = usdVolume;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public long getTradeId() {
        return tradeId;
    }

    public String getProductId() {
        return productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getLiquidity() {
        return liquidity;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public double getFee() {
        return fee;
    }

    public String getSide() {
        return side;
    }

    public boolean isSettled() {
        return settled;
    }

    public double getUsdVolume() {
        return usdVolume;
    }

}
