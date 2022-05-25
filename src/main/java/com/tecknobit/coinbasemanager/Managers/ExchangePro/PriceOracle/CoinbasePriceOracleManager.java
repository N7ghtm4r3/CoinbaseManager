package com.tecknobit.coinbasemanager.Managers.ExchangePro.PriceOracle;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.PriceOracle.Records.PriceOracle;
import org.json.JSONObject;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.PRICE_ORACLE_ENDPOINT;

/**
 *  The {@code CoinbasePriceOracleManager} class is useful to manage all Coinbase price oracle endpoints
 *  @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle</a>
 *  @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbasePriceOracleManager extends CoinbaseManager {

    /** Constructor to init a CoinbasePriceOracle manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * @param defaultErrorMessage custom error to show when is not a request error
     * @param timeout custom timeout for request
     * **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbasePriceOracle manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * @param timeout custom timeout for request
     * **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbasePriceOracle manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * @param defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbasePriceOracle manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to get signed prices
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle</a>
     * @return signed prices as {@link String}
     * **/
    public String getSignedPrices() throws Exception {
        return sendAPIRequest(PRICE_ORACLE_ENDPOINT, GET_METHOD);
    }

    /** Request to get signed prices
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle</a>
     * @return signed prices as {@link JSONObject}
     * **/
    public JSONObject getSignedPricesJSON() throws Exception {
        return new JSONObject(getSignedPrices());
    }

    /** Request to get signed prices
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle</a>
     * @return signed prices as {@link PriceOracle} object
     * **/
    public PriceOracle getSignedPricesObject() throws Exception {
        jsonObject = new JSONObject(getSignedPrices());
        return new PriceOracle(jsonObject.getLong("timestamp"), jsonObject);
    }

}
