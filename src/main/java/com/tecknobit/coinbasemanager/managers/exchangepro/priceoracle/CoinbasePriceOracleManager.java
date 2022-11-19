package com.tecknobit.coinbasemanager.managers.exchangepro.priceoracle;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.priceoracle.records.PriceOracle;
import org.json.JSONObject;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.PRICE_ORACLE_ENDPOINT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbasePriceOracleManager} class is useful to manage all {@code "Coinbase"} price oracle endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle-1">
 * Price oracle manager</a>
 * @see CoinbaseManager
 **/
public class CoinbasePriceOracleManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbasePriceOracleManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbasePriceOracleManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbasePriceOracleManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbasePriceOracleManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbasePriceOracleManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbasePriceOracleManager} <br>
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
    public CoinbasePriceOracleManager() {
        super();
    }

    /**
     * Request to get signed prices <br>
     * Any params required
     *
     * @return signed prices as {@link PriceOracle} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle-1">
     * Get signed prices</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/oracle")
    public PriceOracle getSignedPrices() throws Exception {
        return getSignedPrices(LIBRARY_OBJECT);
    }

    /**
     * Request to get signed prices
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return signed prices as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbasepriceoracle-1">
     * Get signed prices</a>
     **/
    @Returner
    @RequestPath(path = "https://api.exchange.coinbase.com/oracle")
    public <T> T getSignedPrices(ReturnFormat format) throws Exception {
        String signedPricesResponse = sendAPIRequest(PRICE_ORACLE_ENDPOINT, GET_METHOD);
        switch (format) {
            case JSON:
                return (T) new JSONObject(signedPricesResponse);
            case LIBRARY_OBJECT:
                return (T) new PriceOracle(new JSONObject(signedPricesResponse));
            default:
                return (T) signedPricesResponse;
        }
    }

}
