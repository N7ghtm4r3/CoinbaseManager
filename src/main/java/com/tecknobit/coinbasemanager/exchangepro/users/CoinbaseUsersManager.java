package com.tecknobit.coinbasemanager.exchangepro.users;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.exchangepro.users.records.ExchangeLimits;
import org.json.JSONObject;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseUsersManager} class is useful to manage all {@code "Coinbase"} users endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
 * Users manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseUsersManager extends CoinbaseManager {

    /**
     * {@code USERS_ENDPOINT} is constant for USERS_ENDPOINT's endpoint
     **/
    public static final String USERS_ENDPOINT = "/users";

    /**
     * {@code EXCHANGE_LIMITS_ENDPOINT} is constant for EXCHANGE_LIMITS_ENDPOINT's endpoint
     **/
    public static final String EXCHANGE_LIMITS_ENDPOINT = "/exchange-limits";

    /**
     * {@code SETTLEMENT_PREFERENCES_ENDPOINT} is constant for SETTLEMENT_PREFERENCES_ENDPOINT's endpoint
     **/
    public static final String SETTLEMENT_PREFERENCES_ENDPOINT = "/settlement-preferences";

    /**
     * {@code SettlementPreference} list of available settlement preferences
     **/
    public enum SettlementPreference {

        /**
         * {@code USD} settlement preference
         **/
        USD("USD"),

        /**
         * {@code USDC} settlement preference
         **/
        USDC("USDC"),

        /**
         * {@code OPT_OUT} settlement preference
         **/
        OPT_OUT("opt-out");

        /**
         * {@code preference} value
         **/
        private final String preference;

        /**
         * Constructor to init {@link SettlementPreference}
         *
         * @param preference: value
         */
        SettlementPreference(String preference) {
            this.preference = preference;
        }

        /**
         * Method to get {@link #preference} instance <br>
         * No-any params required
         *
         * @return {@link #preference} instance as {@link String}
         **/
        public String getPreference() {
            return preference;
        }

    }

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
     **/
    public CoinbaseUsersManager() {
        super();
    }

    /**
     * Request to get exchange user limits for a user
     *
     * @param userId: the ID of the user who owns the account
     * @return exchange user limits for a user as {@link ExchangeLimits} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     * Get user exchange limits</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/users/{user_id}/exchange-limits")
    public ExchangeLimits getUserExchangeLimits(String userId) throws Exception {
        return getUserExchangeLimits(userId, LIBRARY_OBJECT);
    }

    /**
     * Request to get exchange user limits for a user
     *
     * @param userId: the ID of the user who owns the account
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return exchange user limits for a user as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     * Get user exchange limits</a>
     **/
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/users/{user_id}/exchange-limits")
    public <T> T getUserExchangeLimits(String userId, ReturnFormat format) throws Exception {
        String exchangeLimitsResponse = sendAPIRequest(USERS_ENDPOINT + "/" + userId + EXCHANGE_LIMITS_ENDPOINT,
                GET);
        switch (format) {
            case JSON:
                return (T) new JSONObject(exchangeLimitsResponse);
            case LIBRARY_OBJECT:
                return (T) new ExchangeLimits(new JSONObject(exchangeLimitsResponse));
            default:
                return (T) exchangeLimitsResponse;
        }
    }

    /**
     * Request to update the settlement preference to hold funds in either USDC or USD
     *
     * @param userId:     the ID of the user who owns the account
     * @param preference: settlement preference
     * @return settlement preference as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postuserlevelsettlementpreferences">
     * Update settlement preference</a>
     **/
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/users/{user_id}/settlement-preferences")
    public String updateSettlementPreference(String userId, SettlementPreference preference) throws Exception {
        return updateSettlementPreference(userId, preference, LIBRARY_OBJECT);
    }

    /**
     * Request to update the settlement preference to hold funds in either USDC or USD
     *
     * @param userId:     the ID of the user who owns the account
     * @param preference: settlement preference
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return settlement preference as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postuserlevelsettlementpreferences">
     * Update settlement preference</a>
     **/
    @Returner
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/users/{user_id}/settlement-preferences")
    public <T> T updateSettlementPreference(String userId, SettlementPreference preference,
                                            ReturnFormat format) throws Exception {
        Params payload = new Params();
        payload.addParam("settlement_preference", preference.getPreference());
        String preferenceResponse = sendJSONPayloadedRequest(USERS_ENDPOINT + "/" + userId
                + SETTLEMENT_PREFERENCES_ENDPOINT, POST, payload);
        switch (format) {
            case JSON:
                return (T) new JSONObject(preferenceResponse);
            case LIBRARY_OBJECT:
                return (T) new JSONObject(preferenceResponse).getString("settlement_preference");
            default:
                return (T) preferenceResponse;
        }
    }

}
