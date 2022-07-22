package com.tecknobit.coinbasemanager.Managers.ExchangePro.Fees.Records;

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

    public double getTakerFeeRate() {
        return takerFeeRate;
    }

    public double getMakerFeeRate() {
        return makerFeeRate;
    }

    public double getUsdVolume() {
        return usdVolume;
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
