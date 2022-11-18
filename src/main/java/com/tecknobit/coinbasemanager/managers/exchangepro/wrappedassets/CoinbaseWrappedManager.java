package com.tecknobit.coinbasemanager.managers.exchangepro.wrappedassets;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.CONVERSION_RATE_ENDPOINT;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.WRAPPED_ASSETS_ENDPOINT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseWrappedManager} class is useful to manage all {@code "Coinbase"} wrapped assets endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
 * Wrapped manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseWrappedManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseWrappedManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
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
     **/
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
     **/
    public CoinbaseWrappedManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseWrappedManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseWrappedManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseWrappedManager} <br>
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
    public CoinbaseWrappedManager() {
        super();
    }

    /**
     * Request to get a list of all supported wrapped asset IDs <br>
     * Any params required
     *
     * @return list of all supported wrapped asset IDs as {@link ArrayList} of {@link String}
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
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/wrapped-assets")
    public ArrayList<String> getAllWrappedAssets() throws Exception {
        return getAllWrappedAssets(LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of all supported wrapped asset IDs
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return list of all supported wrapped asset IDs as {"format"} defines
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
     **/
    @Returner
    @RequestPath(path = "https://api.exchange.coinbase.com/wrapped-assets")
    public <T> T getAllWrappedAssets(ReturnFormat format) throws Exception {
        String wrappedAssetsResponse = sendAPIRequest(WRAPPED_ASSETS_ENDPOINT, GET_METHOD);
        switch (format) {
            case JSON:
                return (T) new JSONObject(wrappedAssetsResponse);
            case LIBRARY_OBJECT:
                JSONArray assetsList = new JSONObject(wrappedAssetsResponse).getJSONArray("wrapped_asset_ids");
                ArrayList<String> wrappedAssets = new ArrayList<>();
                for (int j = 0; j < assetsList.length(); j++)
                    wrappedAssets.add(assetsList.getString(j));
                return (T) wrappedAssets;
            default:
                return (T) wrappedAssetsResponse;
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
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/conversion-rate")
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
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/conversion-rate")
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
     **/
    @Returner
    @RequestPath(path = "https://api.exchange.coinbase.com/wrapped-assets/{wrapped_asset_id}/conversion-rate")
    public <T> T getWrappedConversionRate(String wrappedAssetId, ReturnFormat format) throws Exception {
        String conversionRateResponse = sendAPIRequest(WRAPPED_ASSETS_ENDPOINT + "/" + wrappedAssetId + "/"
                + CONVERSION_RATE_ENDPOINT, GET_METHOD);
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
