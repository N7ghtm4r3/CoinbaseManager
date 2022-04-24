package com.tecknobit.coinbasemanager.Managers.ExchangePro.Fees.Records;

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
