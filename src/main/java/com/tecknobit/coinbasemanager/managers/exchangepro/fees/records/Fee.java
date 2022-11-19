package com.tecknobit.coinbasemanager.managers.exchangepro.fees.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Fee} class is useful to format Fee object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1">
 * Get fees</a>
 **/
public class Fee {

    /**
     * {@code takerFeeRate} is instance that memorizes taker fee rate value
     * **/
    private final double takerFeeRate;

    /**
     * {@code makerFeeRate} is instance that memorizes maker fee rate value
     **/
    private final double makerFeeRate;

    /**
     * {@code usdVolume} is instance that memorizes usd volume value
     **/
    private final double usdVolume;

    /**
     * Constructor to init a {@link Fee} custom object
     *
     * @param takerFeeRate: taker fee rate value
     * @param makerFeeRate: maker fee rate value
     * @param usdVolume:    usd volume value
     **/
    public Fee(double takerFeeRate, double makerFeeRate, double usdVolume) {
        this.takerFeeRate = takerFeeRate;
        this.makerFeeRate = makerFeeRate;
        this.usdVolume = usdVolume;
    }

    /**
     * Constructor to init a {@link Fee} custom object
     *
     * @param fee: fee details as {@link JSONObject}
     **/
    public Fee(JSONObject fee) {
        JsonHelper hFees = new JsonHelper(fee);
        takerFeeRate = hFees.getDouble("taker_fee_rate", 0);
        makerFeeRate = hFees.getDouble("maker_fee_rate", 0);
        String sUsdVolume = hFees.getString("usd_volume");
        if (sUsdVolume != null)
            usdVolume = Double.parseDouble(sUsdVolume);
        else
            usdVolume = 0;
    }

    /**
     * MethodId to get {@link #takerFeeRate} instance <br>
     * Any params required
     *
     * @return {@link #takerFeeRate} instance as double
     **/
    public double getTakerFeeRate() {
        return takerFeeRate;
    }

    /**
     * MethodId to get {@link #takerFeeRate} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #takerFeeRate} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getTakerFeeRate(int decimals) {
        return roundValue(takerFeeRate, decimals);
    }

    /**
     * MethodId to get {@link #makerFeeRate} instance <br>
     * Any params required
     *
     * @return {@link #makerFeeRate} instance as double
     **/
    public double getMakerFeeRate() {
        return makerFeeRate;
    }

    /**
     * MethodId to get {@link #makerFeeRate} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #makerFeeRate} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getMakerFeeRate(int decimals) {
        return roundValue(makerFeeRate, decimals);
    }

    /**
     * MethodId to get {@link #usdVolume} instance <br>
     * Any params required
     *
     * @return {@link #usdVolume} instance as double
     **/
    public double getUsdVolume() {
        return usdVolume;
    }

    /**
     * MethodId to get {@link #usdVolume} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #usdVolume} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getUsdVolume(int decimals) {
        return roundValue(usdVolume, decimals);
    }

    /**
     * Returns a string representation of the object <br>
     * Any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
