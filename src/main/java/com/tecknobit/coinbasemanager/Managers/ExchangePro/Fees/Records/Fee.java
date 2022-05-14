package com.tecknobit.coinbasemanager.Managers.ExchangePro.Fees.Records;

/**
 * The {@code Fee} class is useful to format Fee object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Fee {

    private final double takerFeeRate;
    private final double makerFeeRate;
    private final double usdVolume;

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

}
