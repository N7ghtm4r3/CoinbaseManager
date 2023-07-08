package com.tecknobit.coinbasemanager.exchangepro.fees;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.apimanager.interfaces.Manager;
import com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.exchangepro.fees.records.Fee;
import org.json.JSONObject;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseFeesManager} class is useful to manage all {@code "Coinbase"} fees endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees">
 * Fees manager</a>
 * @see CoinbaseManager
 * @see Manager
 */
public class CoinbaseFeesManager extends CoinbaseManager {

    /**
     * {@code FEES_ENDPOINT} is constant for FEES_ENDPOINT's endpoint
     */
    public static final String FEES_ENDPOINT = "/fees";

    /**
     * Constructor to init a {@link CoinbaseFeesManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     */
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
     */
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
     */
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseFeesManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     */
    public CoinbaseFeesManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseFeesManager} <br>
     * No-any params required
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
     */
    public CoinbaseFeesManager() {
        super();
    }

    /**
     * Request to get fees rates and 30 days trailing volume <br>
     * No-any params required
     *
     * @return fees rates and 30 days trailing volume as {@link Fee} custom objectì
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees">
     * Get fees</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/fees")
    public Fee getFees() throws Exception {
        return getFees(LIBRARY_OBJECT);
    }

    /**
     * Request to get fees rates and 30 days trailing volume
     * No-any params required
     *
     * @return fees rates and 30 days trailing volume as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getfees">
     * Get fees</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/fees")
    public <T> T getFees(ReturnFormat format) throws Exception {
        String feeResponse = sendGETRequest(FEES_ENDPOINT);
        switch (format) {
            case JSON:
                return (T) new JSONObject(feeResponse);
            case LIBRARY_OBJECT:
                return (T) new Fee(new JSONObject(feeResponse));
            default:
                return (T) feeResponse;
        }
    }

}
