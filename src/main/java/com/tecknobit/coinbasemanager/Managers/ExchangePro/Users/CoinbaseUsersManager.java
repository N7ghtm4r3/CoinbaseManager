package com.tecknobit.coinbasemanager.Managers.ExchangePro.Users;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Users.Records.ExchangeLimits;
import org.json.JSONObject;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.EXCHANGE_LIMITS_ENDPOINT;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.USERS_ENDPOINT;

/**
 *  The {@code CoinbaseUsersManager} class is useful to manage all Coinbase users endpoints
 *  @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
 *      https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
 *  @author N7ghtm4r3 - Tecknobit
 * **/

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
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
     * @return exchange user limits for a user as {@link String}
     * **/
    public String getUserExchangeLimits(String userId) throws Exception {
        return sendAPIRequest(USERS_ENDPOINT + "/" + userId + EXCHANGE_LIMITS_ENDPOINT, GET_METHOD);
    }

    /** Request to get exchange user limits for a user
     * @param userId: type of report from fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
     * @return exchange user limits for a user as {@link JSONObject}
     * **/
    public JSONObject getUserExchangeLimitsJSON(String userId) throws Exception {
        return new JSONObject(getUserExchangeLimits(userId));
    }

    /** Request to get exchange user limits for a user
     * @param userId: type of report from fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
     * @return exchange user limits for a user as {@link ExchangeLimits} object
     * **/
    public ExchangeLimits getUserExchangeLimitsObject(String userId) throws Exception {
        jsonHelper = new JsonHelper(getUserExchangeLimitsJSON(userId));
        return new ExchangeLimits(jsonHelper.getString("created_at"),
                jsonHelper.getString("active_at"),
                jsonHelper.getString("id"),
                jsonHelper.getString("name"),
                jsonHelper.getString("email"),
                jsonHelper.getBoolean("is_banned"),
                jsonHelper.getString("user_type"),
                jsonHelper.getBoolean("fulfills_new_requirements"),
                jsonHelper.getBoolean("has_default"),
                jsonHelper,
                jsonHelper.getString("terms_accepted"),
                jsonHelper.getString("state_code"),
                jsonHelper.getBoolean("access_privacy_rights"),
                jsonHelper.getString("two_factor_method"),
                jsonHelper.getBoolean("analytics_processing_enabled"),
                jsonHelper.getBoolean("is_prime"),
                jsonHelper.getBoolean("has_pro_wbl"),
                jsonHelper.getBoolean("has_clawback"),
                jsonHelper.getBoolean("has_clawback_payment_pending"),
                jsonHelper.getBoolean("has_restricted_assets"),
                jsonHelper.getString("legal_name"),
                jsonHelper.getBoolean("whitelisting_enabled"),
                jsonHelper.getBoolean("region_banking_support"),
                jsonHelper.getString("default_preferred_market"),
                jsonHelper.getBoolean("margin_eligible")
        );
    }

}
