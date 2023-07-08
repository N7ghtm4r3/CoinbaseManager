package com.tecknobit.coinbasemanager.exchangepro.wrappedassets;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.apimanager.interfaces.Manager;
import com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.exchangepro.wrappedassets.records.StakeWrap;
import com.tecknobit.coinbasemanager.exchangepro.wrappedassets.records.WrappedAsset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseWrappedManager} class is useful to manage all {@code "Coinbase"} wrapped assets endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
 * Wrapped manager</a>
 * @see CoinbaseManager
 * @see Manager
 */
public class CoinbaseWrappedManager extends CoinbaseManager {

    /**
     * {@code WRAPPED_ASSETS_ENDPOINT} is constant for WRAPPED_ASSETS_ENDPOINT's endpoint
     */
    public static final String WRAPPED_ASSETS_ENDPOINT = "/wrapped-assets";

    /**
     * {@code STAKE_WRAP_ENDPOINT} is constant for STAKE_WRAP_ENDPOINT's endpoint
     */
    public static final String STAKE_WRAP_ENDPOINT = WRAPPED_ASSETS_ENDPOINT + "/stake-wrap";

    /**
     * {@code CONVERSION_RATE_ENDPOINT} is constant for CONVERSION_RATE_ENDPOINT's endpoint
     */
    public static final String CONVERSION_RATE_ENDPOINT = "/conversion-rate";

    /**
     * Constructor to init a {@link CoinbaseWrappedManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     */
    public CoinbaseWrappedManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseWrappedManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     */
    public CoinbaseWrappedManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseWrappedManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     */
    public CoinbaseWrappedManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseWrappedManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     */
    public CoinbaseWrappedManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseWrappedManager} <br>
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
    public CoinbaseWrappedManager() {
        super();
    }

    /**
     * Request to get a list of all supported wrapped assets <br>
     * No-any params required
     *
     * @return list of all supported wrapped assets as {@link ArrayList} of {@link WrappedAsset} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
     * Get all wrapped assets</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets")
    public ArrayList<WrappedAsset> getAllWrappedAssets() throws Exception {
        return getAllWrappedAssets(LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of all supported wrapped assets
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return list of all supported wrapped assets as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
     * Get all wrapped assets</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets")
    public <T> T getAllWrappedAssets(ReturnFormat format) throws Exception {
        String wrappedAssetsResponse = sendGETRequest(WRAPPED_ASSETS_ENDPOINT);
        switch (format) {
            case JSON:
                return (T) new JSONObject(wrappedAssetsResponse).getJSONArray("wrapped_assets");
            case LIBRARY_OBJECT:
                JSONArray assetsList = new JSONObject(wrappedAssetsResponse).getJSONArray("wrapped_assets");
                ArrayList<WrappedAsset> wrappedAssets = new ArrayList<>();
                for (int j = 0; j < assetsList.length(); j++)
                    wrappedAssets.add(new WrappedAsset(assetsList.getJSONObject(j)));
                return (T) wrappedAssets;
            default:
                return (T) wrappedAssetsResponse;
        }
    }

    /**
     * Request to get a list of all stake wraps <br>
     * No-any params required
     *
     * @return list of stake wraps as {@link ArrayList} of {@link StakeWrap} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getallwrappedassetstakewraps">
     * Get all stake-wraps</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap")
    public ArrayList<StakeWrap> getAllStakeWraps() throws Exception {
        return getAllStakeWraps(LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of all stake wraps
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return list of stake wraps as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getallwrappedassetstakewraps">
     * Get all stake-wraps</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap")
    public <T> T getAllStakeWraps(ReturnFormat format) throws Exception {
        return getAllStakeWraps(null, format);
    }

    /**
     * Request to get a list of all stake wraps
     *
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "from"} -> from currency - [string]
     *                          </li>
     *                          <li>
     *                              {@code "to"} -> to currency - [string]
     *                          </li>
     *                          <li>
     *                              {@code "status"} -> status of the stake wrap - [string]
     *                          </li>
     *                     </ul>
     * @return list of stake wraps as {@link ArrayList} of {@link StakeWrap} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getallwrappedassetstakewraps">
     * Get all stake-wraps</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap")
    public ArrayList<StakeWrap> getAllStakeWraps(Params queryParams) throws Exception {
        return getAllStakeWraps(queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of all stake wraps
     *
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "from"} -> from currency - [string]
     *                          </li>
     *                          <li>
     *                              {@code "to"} -> to currency - [string]
     *                          </li>
     *                          <li>
     *                              {@code "status"} -> status of the stake wrap - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return list of stake wraps as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getallwrappedassetstakewraps">
     * Get all stake-wraps</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap")
    public <T> T getAllStakeWraps(Params queryParams, ReturnFormat format) throws Exception {
        if (queryParams == null)
            queryParams = new Params();
        String wrapsResponse = sendGETRequest(STAKE_WRAP_ENDPOINT + queryParams.createQueryString());
        switch (format) {
            case JSON:
                return (T) new JSONArray(wrapsResponse);
            case LIBRARY_OBJECT:
                ArrayList<StakeWrap> stakeWraps = new ArrayList<>();
                JSONArray jStakeWraps = new JSONArray(wrapsResponse);
                for (int j = 0; j < jStakeWraps.length(); j++)
                    stakeWraps.add(new StakeWrap(jStakeWraps.getJSONObject(j)));
                return (T) stakeWraps;
            default:
                return (T) wrapsResponse;
        }
    }

    /**
     * Request to stake and wrap {@code "from_currency"} to {@code "to_currency"}. Funds are stake-wrapped in the
     * profile associated with the API key
     *
     * @param fromCurrency: from currency
     * @param toCurrency:   to currency
     * @param amount:       amount of the stake wrap
     * @return stake wrap as {@link StakeWrap} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwrappedassetstakewrap">
     * Create a new stake-wrap</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap")
    public StakeWrap createNewStakeWrap(String fromCurrency, String toCurrency, double amount) throws Exception {
        return createNewStakeWrap(fromCurrency, toCurrency, amount, LIBRARY_OBJECT);
    }

    /**
     * Request to stake and wrap {@code "from_currency"} to {@code "to_currency"}. Funds are stake-wrapped in the
     * profile associated with the API key
     *
     * @param fromCurrency: from currency
     * @param toCurrency:   to currency
     * @param amount:       amount of the stake wrap
     * @param format:       return type formatter -> {@link ReturnFormat}
     * @return stake wrap as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwrappedassetstakewrap">
     * Create a new stake-wrap</a>
     */
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap")
    public <T> T createNewStakeWrap(String fromCurrency, String toCurrency, double amount,
                                    ReturnFormat format) throws Exception {
        Params payload = new Params();
        payload.addParam("fromCurrency", fromCurrency);
        payload.addParam("toCurrency", toCurrency);
        payload.addParam("amount", amount);
        return returnStakeWrap(sendJSONPostRequestRequest(STAKE_WRAP_ENDPOINT, payload), format);
    }

    /**
     * Request to get details for a specific stake-wrap in the profile associated with the API key
     *
     * @param stakeWrapId: stake wrap identifier to fetch
     * @return stake wrap as {@link StakeWrap} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetstakewrap">
     * Get a single stake-wrap</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap/{stake_wrap_id}")
    public StakeWrap getSingleStakeWrap(String stakeWrapId) throws Exception {
        return getSingleStakeWrap(stakeWrapId, LIBRARY_OBJECT);
    }

    /**
     * Request to get details for a specific stake-wrap in the profile associated with the API key
     *
     * @param stakeWrapId: stake wrap identifier to fetch
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return stake wrap as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetstakewrap">
     * Get a single stake-wrap</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/stake-wrap/{stake_wrap_id}")
    public <T> T getSingleStakeWrap(String stakeWrapId, ReturnFormat format) throws Exception {
        return returnStakeWrap(sendGETRequest(STAKE_WRAP_ENDPOINT + "/" + stakeWrapId), format);
    }

    /**
     * Method to assemble a stake wrap object
     *
     * @param stakeWrapResponse: stake wrap response to format
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return stake wrap as {@code "format"} defines
     */
    @Returner
    private <T> T returnStakeWrap(String stakeWrapResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONObject(stakeWrapResponse);
            case LIBRARY_OBJECT:
                return (T) new StakeWrap(new JSONObject(stakeWrapResponse));
            default:
                return (T) stakeWrapResponse;
        }
    }

    /**
     * Request to get wrapped asset details
     *
     * @param wrappedAssetId: id of the wrapped asset to fetch
     * @return wrapped asset details as {@link WrappedAsset} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedasset">
     * Get wrapped asset details</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/")
    public WrappedAsset getWrappedAssetDetails(String wrappedAssetId) throws Exception {
        return getWrappedAssetDetails(wrappedAssetId, LIBRARY_OBJECT);
    }

    /**
     * Request to get wrapped asset details
     *
     * @param wrappedAssetId: id of the wrapped asset to fetch
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @return wrapped asset details as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedasset">
     * Get wrapped asset details</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/")
    public <T> T getWrappedAssetDetails(String wrappedAssetId, ReturnFormat format) throws Exception {
        String wrappedAssetResponse = sendGETRequest(WRAPPED_ASSETS_ENDPOINT + "/" + wrappedAssetId);
        switch (format) {
            case JSON:
                return (T) new JSONObject(wrappedAssetResponse);
            case LIBRARY_OBJECT:
                return (T) new WrappedAsset(new JSONObject(wrappedAssetResponse));
            default:
                return (T) wrappedAssetResponse;
        }
    }

    /**
     * Request to get the conversion rate of a wrapped asset to its corresponding staked asset
     *
     * @param wrappedAssetId: wrapped asset identifier es. CBETH
     * @return conversion rate of a wrapped asset to its corresponding staked asset as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate">
     * Get conversion rate of wrapped asset</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/conversion-rate")
    public double getWrappedConversionRate(String wrappedAssetId) throws Exception {
        return Double.parseDouble(getWrappedConversionRate(wrappedAssetId, LIBRARY_OBJECT));
    }

    /**
     * Request to get the conversion rate of a wrapped asset to its corresponding staked asset
     *
     * @param wrappedAssetId: wrapped asset identifier es. CBETH
     * @param decimals:       number of digits to round final value
     * @return conversion rate of a wrapped asset to its corresponding staked asset as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate">
     * Get conversion rate of wrapped asset</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/conversion-rate")
    public double getWrappedConversionRate(String wrappedAssetId, int decimals) throws Exception {
        return roundValue(Double.parseDouble(getWrappedConversionRate(wrappedAssetId, LIBRARY_OBJECT)), decimals);
    }

    /**
     * Request to get the conversion rate of a wrapped asset to its corresponding staked asset
     *
     * @param wrappedAssetId: wrapped asset identifier es. CBETH
     * @return conversion rate of a wrapped asset to its corresponding staked asset as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate">
     * Get conversion rate of wrapped asset</a>
     * @implNote in this case {@link ReturnFormat#LIBRARY_OBJECT} will return the {@link String} value of the conversion rate,
     * with the wrappers methods it will be parsed as double, if you directly access to this method you will need to parse as well
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/conversion-rate")
    public <T> T getWrappedConversionRate(String wrappedAssetId, ReturnFormat format) throws Exception {
        String conversionRateResponse = sendGETRequest(WRAPPED_ASSETS_ENDPOINT + "/" + wrappedAssetId + "/"
                + CONVERSION_RATE_ENDPOINT);
        switch (format) {
            case JSON:
                return (T) new JSONObject(conversionRateResponse);
            case LIBRARY_OBJECT:
                return (T) new JSONObject(conversionRateResponse).getString("amount");
            default:
                return (T) conversionRateResponse;
        }
    }

}
