package com.tecknobit.coinbasemanager.managers.exchangepro.orders.records;

import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Fill} class is useful to format Fill object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfills-1</a>
 **/

public class Fill extends OrderDetails {

    /**
     * {@code tradeId} is instance that memorizes trade identifier value
     * **/
    private final long tradeId;

    /**
     * {@code orderId} is instance that memorizes order identifier value
     * **/
    private final String orderId;

    /**
     * {@code userId} is instance that memorizes user identifier value
     * **/
    private final String userId;

    /**
     * {@code liquidity} is instance that memorizes liquidity value
     * **/
    private final String liquidity;

    /**
     * {@code fee} is instance that memorizes fee value
     * **/
    private final double fee;

    /**
     * {@code usdVolume} is instance that memorizes usd volume value
     * **/
    private final double usdVolume;

    /** Constructor to init a {@link Fill} object
     * @param createdAt: created at value
     * @param productId: product identifier value
     * @param profileId: profile identifier value
     * @param price: price value
     * @param size: size value
     * @param side: side value (buy or sell)
     * @param settled: flag that checks if order is settled
     * @param tradeId: trade identifier value
     * @param orderId: order identifier value
     * @param userId: user identifier value
     * @param liquidity: liquidity value
     * @param fee: fee value
     * @param usdVolume: usd volume value
     * **/
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

    /** Constructor to init a {@link Fill} object
     * @param fill: fill details as {@link JSONObject}
     * **/
    public Fill(JSONObject fill) {
        super(fill);
        tradeId = orderHelper.getLong("trade_id");
        orderId = orderHelper.getString("order_id");
        userId = orderHelper.getString("user_id");
        liquidity = orderHelper.getString("liquidity");
        fee = orderHelper.getDouble("fee");
        usdVolume = orderHelper.getDouble("usd_volume");
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

    /** Method to get {@link #fee} instance
     * @param decimals: number of digits to round final value
     * @return {@link #fee} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getFee(int decimals) {
        return roundValue(fee, decimals);
    }

    public double getUsdVolume() {
        return usdVolume;
    }

    /** Method to get {@link #usdVolume} instance
     * @param decimals: number of digits to round final value
     * @return {@link #usdVolume} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getUsdVolume(int decimals) {
        return roundValue(usdVolume, decimals);
    }

    @Override
    public String toString() {
        return "Fill{" +
                "tradeId=" + tradeId +
                ", orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", liquidity='" + liquidity + '\'' +
                ", fee=" + fee +
                ", usdVolume=" + usdVolume +
                '}';
    }

}
