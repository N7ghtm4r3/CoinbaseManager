package com.tecknobit.coinbasemanager.exchangepro.wrappedassets.records;

import com.tecknobit.coinbasemanager.exchangepro.records.CoinbaseItem;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code WrappedAsset} class is useful to format a {@code Coinbase} wrapped asset
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
 *             Get all wrapped assets</a>
 *     </li>
 *     <li>
 *         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedasset">
 *             Get wrapped asset details</a>
 *     </li>
 * </ul>
 * @see CoinbaseItem
 */
public class WrappedAsset extends CoinbaseItem {

    /**
     * {@code id} of the wrapped asset
     */
    private final String id;

    /**
     * {@code circulatingSupply} circulating supply of the wrapped asset
     */
    private final double circulatingSupply;

    /**
     * {@code totalSupply} total supply of the wrapped asset
     */
    private final double totalSupply;

    /**
     * {@code conversionRate} conversion rate of the wrapped asset
     */
    private final double conversionRate;

    /**
     * {@code apy} APY earned by the supply of the underlying asset
     */
    private final double apy;

    /**
     * Constructor to init a {@link WrappedAsset} object
     *
     * @param id                :                id of the wrapped asset
     * @param circulatingSupply : circulating supply of the wrapped asset
     * @param totalSupply       :       total supply of the wrapped asset
     * @param conversionRate    :    conversion rate of the wrapped asset
     * @param apy:              APY earned by the supply of the underlying asset
     */
    public WrappedAsset(String id, double circulatingSupply, double totalSupply, double conversionRate, double apy) {
        super(null);
        this.id = id;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.conversionRate = conversionRate;
        this.apy = apy;
    }

    /**
     * Constructor to init a {@link WrappedAsset} object
     *
     * @param jWrappedAsset: wrapped asset details as {@link JSONObject}
     */
    public WrappedAsset(JSONObject jWrappedAsset) {
        super(jWrappedAsset);
        id = hItem.getString("id");
        circulatingSupply = hItem.getDouble("circulating_supply", 0);
        totalSupply = hItem.getDouble("total_supply", 0);
        conversionRate = hItem.getDouble("conversion_rate", 0);
        apy = hItem.getDouble("apy", 0);
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #circulatingSupply} instance <br>
     * No-any params required
     *
     * @return {@link #circulatingSupply} instance as double
     */
    public double getCirculatingSupply() {
        return circulatingSupply;
    }

    /**
     * Method to get {@link #circulatingSupply} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #circulatingSupply} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getCirculatingSupply(int decimals) {
        return roundValue(circulatingSupply, decimals);
    }

    /**
     * Method to get {@link #totalSupply} instance <br>
     * No-any params required
     *
     * @return {@link #totalSupply} instance as double
     */
    public double getTotalSupply() {
        return totalSupply;
    }

    /**
     * Method to get {@link #totalSupply} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #totalSupply} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getTotalSupply(int decimals) {
        return roundValue(totalSupply, decimals);
    }

    /**
     * Method to get {@link #conversionRate} instance <br>
     * No-any params required
     *
     * @return {@link #conversionRate} instance as double
     */
    public double getConversionRate() {
        return conversionRate;
    }

    /**
     * Method to get {@link #conversionRate} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #conversionRate} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getConversionRate(int decimals) {
        return roundValue(conversionRate, decimals);
    }

    /**
     * Method to get {@link #apy} instance <br>
     * No-any params required
     *
     * @return {@link #apy} instance as double
     */
    public double getApy() {
        return apy;
    }

    /**
     * Method to get {@link #apy} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #apy} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getApy(int decimals) {
        return roundValue(apy, decimals);
    }

}
