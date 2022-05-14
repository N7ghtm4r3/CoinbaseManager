package com.tecknobit.coinbasemanager.Managers.ExchangePro.Orders.Records;

/**
 * The {@code Fill} class is useful to format Fill object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Fill extends OrderDetails{

    private final long tradeId;
    private final String orderId;
    private final String userId;
    private final String liquidity;
    private final double fee;
    private final double usdVolume;

    public Fill(String createdAt, String productId, String profileId, double price, double size, String side,
                boolean settled, long tradeId, String orderId, String userId, String liquidity, double fee,
                double usdVolume) {
        super(createdAt, productId, profileId, price, size, side, settled);
        this.tradeId = tradeId;
        this.orderId = orderId;
        this.userId = userId;
        this.liquidity = liquidity;
        this.fee = fee;
        this.usdVolume = usdVolume;
    }

    public long getTradeId() {
        return tradeId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getLiquidity() {
        return liquidity;
    }

    public double getFee() {
        return fee;
    }

    public double getUsdVolume() {
        return usdVolume;
    }

}
