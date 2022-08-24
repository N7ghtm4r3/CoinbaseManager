package com.tecknobit.coinbasemanager.Managers.ExchangePro.Fees.Records;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import org.json.JSONObject;

import static com.tecknobit.apimanager.Tools.Trading.TradingTools.roundValue;

/**
 * The {@code Fee} class is useful to format Fee object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Fee {

    /**
     * {@code takerFeeRate} is instance that memorizes taker fee rate value
     * **/
    private final double takerFeeRate;

    /**
     * {@code makerFeeRate} is instance that memorizes maker fee rate value
     * **/
    private final double makerFeeRate;

    /**
     * {@code usdVolume} is instance that memorizes usd volume value
     * **/
    private final double usdVolume;

    /** Constructor to init a {@link Fee} object
     * @param takerFeeRate: taker fee rate value
     * @param makerFeeRate: maker fee rate value
     * @param usdVolume: usd volume value
     * **/
    public Fee(double takerFeeRate, double makerFeeRate, double usdVolume) {
        this.takerFeeRate = takerFeeRate;
        this.makerFeeRate = makerFeeRate;
        this.usdVolume = usdVolume;
    }

    /** Constructor to init a {@link Fee} object
     * @param fee: fee details as {@link JSONObject}
     * **/
    public Fee(JSONObject fee) {
        JsonHelper hFees = new JsonHelper(fee);
        takerFeeRate = hFees.getDouble("taker_fee_rate");
        makerFeeRate = hFees.getDouble("maker_fee_rate");
        usdVolume = hFees.getDouble("usd_volume");
    }

    public double getTakerFeeRate() {
        return takerFeeRate;
    }

    /** Method to get {@link #takerFeeRate} instance
     * @param decimals: number of digits to round final value
     * @return {@link #takerFeeRate} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getTakerFeeRate(int decimals) {
        return roundValue(takerFeeRate, decimals);
    }

    public double getMakerFeeRate() {
        return makerFeeRate;
    }

    /** Method to get {@link #makerFeeRate} instance
     * @param decimals: number of digits to round final value
     * @return {@link #makerFeeRate} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     * **/
    public double getMakerFeeRate(int decimals) {
        return roundValue(makerFeeRate, decimals);
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
        return "Fee{" +
                "takerFeeRate=" + takerFeeRate +
                ", makerFeeRate=" + makerFeeRate +
                ", usdVolume=" + usdVolume +
                '}';
    }

}
