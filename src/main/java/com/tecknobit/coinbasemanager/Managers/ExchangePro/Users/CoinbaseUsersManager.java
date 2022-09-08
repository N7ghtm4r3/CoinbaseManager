package com.tecknobit.coinbasemanager.Managers.ExchangePro.Users;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Users.Records.ExchangeLimits;
import org.json.JSONObject;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.EXCHANGE_LIMITS_ENDPOINT;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.USERS_ENDPOINT;

/**
 * The {@code CoinbaseUsersManager} class is useful to manage all Coinbase users endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
 **/

public class CoinbaseUsersManager extends CoinbaseManager {

    /** Constructor to init a {@link CoinbaseUsersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a {@link CoinbaseUsersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a {@link CoinbaseUsersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a {@link CoinbaseUsersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to get exchange user limits for a user
     * @param userId: type of report from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
     * @return exchange user limits for a user as {@link String}
     * **/
    public String getUserExchangeLimits(String userId) throws Exception {
        return sendAPIRequest(USERS_ENDPOINT + "/" + userId + EXCHANGE_LIMITS_ENDPOINT, GET_METHOD);
    }

    /** Request to get exchange user limits for a user
     * @param userId: type of report from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
     * @return exchange user limits for a user as {@link JSONObject}
     * **/
    public JSONObject getUserExchangeLimitsJSON(String userId) throws Exception {
        return new JSONObject(getUserExchangeLimits(userId));
    }

    /** Request to get exchange user limits for a user
     * @param userId: type of report from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
     * @return exchange user limits for a user as {@link ExchangeLimits} object
     * **/
    public ExchangeLimits getUserExchangeLimitsObject(String userId) throws Exception {
        return new ExchangeLimits(getUserExchangeLimitsJSON(userId));
    }

}
