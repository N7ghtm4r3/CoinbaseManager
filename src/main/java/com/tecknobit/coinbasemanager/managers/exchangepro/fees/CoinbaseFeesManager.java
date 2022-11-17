package com.tecknobit.coinbasemanager.managers.exchangepro.fees;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.fees.records.Fee;
import org.json.JSONObject;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.FEES_ENDPOINT;

/**
 * The {@code CoinbaseFeesManager} class is useful to manage all {@code "Coinbase"} fees endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1">
 * Fees manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseFeesManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseFeesManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseFeesManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseFeesManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseFeesManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseFeesManager} <br>
     * Any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link CoinbaseManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        CoinbaseManager firstManager = new CoinbaseManager("apiKey", "apiSecret", "passphrase");
     *        //You don't need to insert all credentials to make manager work
     *        CoinbaseManager secondManager = new CoinbaseManager(); //same credentials used
     *     }
     * </pre>
     **/
    public CoinbaseFeesManager() {
        super();
    }

    /**
     * Request to get fees rates and 30 days trailing volume
     * Any params required
     *
     * @return fees rates and 30 days trailing volume as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1</a>
     **/
    public String getFees() throws Exception {
        return sendAPIRequest(FEES_ENDPOINT, GET_METHOD);
    }

    /**
     * Request to get fees rates and 30 days trailing volume
     * Any params required
     *
     * @return fees rates and 30 days trailing volume as {@link JSONObject}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1</a>
     **/
    public JSONObject getFeesJSON() throws Exception {
        return new JSONObject(getFees());
    }

    /**
     * Request to get fees rates and 30 days trailing volume
     * Any params required
     *
     * @return fees rates and 30 days trailing volume as {@link Fee} custom object, if some values are null in response
     * will be returned as -1 value
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees-1</a>
     **/
    public Fee getFeesObject() throws Exception {
        return new Fee(new JSONObject(getFees()));
    }

}
