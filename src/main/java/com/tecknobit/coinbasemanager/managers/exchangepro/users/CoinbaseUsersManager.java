package com.tecknobit.coinbasemanager.managers.exchangepro.users;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.users.records.ExchangeLimits;
import org.json.JSONObject;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.EXCHANGE_LIMITS_ENDPOINT;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.USERS_ENDPOINT;

/**
 * The {@code CoinbaseUsersManager} class is useful to manage all {@code "Coinbase"} users endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
 * Users manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseUsersManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseUsersManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseUsersManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseUsersManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseUsersManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseUsersManager} <br>
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
    public CoinbaseUsersManager() {
        super();
    }

    /**
     * Request to get exchange user limits for a user
     *
     * @param userId: type of report from fetch details
     * @return exchange user limits for a user as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
     **/
    public String getUserExchangeLimits(String userId) throws Exception {
        return sendAPIRequest(USERS_ENDPOINT + "/" + userId + EXCHANGE_LIMITS_ENDPOINT, GET_METHOD);
    }

    /**
     * Request to get exchange user limits for a user
     *
     * @param userId: type of report from fetch details
     * @return exchange user limits for a user as {@link JSONObject}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
     **/
    public JSONObject getUserExchangeLimitsJSON(String userId) throws Exception {
        return new JSONObject(getUserExchangeLimits(userId));
    }

    /**
     * Request to get exchange user limits for a user
     *
     * @param userId: type of report from fetch details
     * @return exchange user limits for a user as {@link ExchangeLimits} custom object
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
     **/
    public ExchangeLimits getUserExchangeLimitsObject(String userId) throws Exception {
        return new ExchangeLimits(getUserExchangeLimitsJSON(userId));
    }

}
