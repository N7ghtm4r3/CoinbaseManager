package com.tecknobit.coinbasemanager.Managers.ExchangePro.Fees;

import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Fees.Records.Fee;
import org.json.JSONObject;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.FEES_ENDPOINT;

/**
 *  The {@code CoinbaseFeesManager} class is useful to manage all Coinbase fees endpoints
 *  @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees
 *  @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseFeesManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseFees manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseFees manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseFees manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseFees manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to get fees rates and 30 days trailing volume
     * any params required
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees
     * @return fees rates and 30 days trailing volume as {@link String}
     * **/
    public String getFees() throws Exception {
        return sendAPIRequest(FEES_ENDPOINT, GET_METHOD);
    }

    /** Request to get fees rates and 30 days trailing volume
     * any params required
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees
     * @return fees rates and 30 days trailing volume as {@link JSONObject}
     * **/
    public JSONObject getFeesJSON() throws Exception {
        return new JSONObject(getFees());
    }

    /** Request to get fees rates and 30 days trailing volume
     * any params required
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees
     * @return fees rates and 30 days trailing volume as {@link Fee} object, if some values are null in response
     * will be returned as -1 value
     * **/
    public Fee getFeesObject() throws Exception {
        jsonHelper = new JsonHelper(new JSONObject(getFees()));
        return new Fee(jsonHelper.getDouble("taker_fee_rate"),
                jsonHelper.getDouble("maker_fee_rate"),
                jsonHelper.getDouble("usd_volume")
        );
    }

}
