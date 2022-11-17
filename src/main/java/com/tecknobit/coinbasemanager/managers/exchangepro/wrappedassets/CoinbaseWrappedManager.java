package com.tecknobit.coinbasemanager.managers.exchangepro.wrappedassets;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.CONVERSION_RATE_ENDPOINT;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.WRAPPED_ASSETS_ENDPOINT;

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
     * @return list of all supported wrapped asset IDs as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets</a>
     **/
    public String getAllWrappedAssets() throws Exception {
        return sendAPIRequest(WRAPPED_ASSETS_ENDPOINT, GET_METHOD);
    }

    /**
     * Request to get a list of all supported wrapped asset IDs <br>
     * Any params required
     *
     * @return list of all supported wrapped asset IDs as {@link JSONObject}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets</a>
     **/
    public JSONObject getAllWrappedAssetsJSON() throws Exception {
        return new JSONObject(getAllWrappedAssets());
    }

    /**
     * Request to get a list of all supported wrapped asset IDs <br>
     * Any params required
     *
     * @return list of all supported wrapped asset IDs as {@link ArrayList} of {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassets</a>
     **/
    public ArrayList<String> getAllWrappedAssetsList() throws Exception {
        JSONArray assetsList = new JSONObject(getAllWrappedAssets()).getJSONArray("wrapped_asset_ids");
        ArrayList<String> wrappedAssets = new ArrayList<>();
        for (int j = 0; j < assetsList.length(); j++)
            wrappedAssets.add(assetsList.getString(j));
        return wrappedAssets;
    }

    /**
     * Request to get the conversion rate of a wrapped asset to its corresponding staked asset
     *
     * @param wrappedAssetId: wrapped asset identifier es. CBETH
     * @return conversion rate of a wrapped asset to its corresponding staked asset as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate</a>
     **/
    public String getWrappedConversionRate(String wrappedAssetId) throws Exception {
        return sendAPIRequest(WRAPPED_ASSETS_ENDPOINT + "/" + wrappedAssetId + "/"
                + CONVERSION_RATE_ENDPOINT, GET_METHOD);
    }

    /**
     * Request to get the conversion rate of a wrapped asset to its corresponding staked asset
     *
     * @param wrappedAssetId: wrapped asset identifier es. CBETH
     * @return conversion rate of a wrapped asset to its corresponding staked asset as {@link JSONObject}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate</a>
     **/
    public JSONObject getWrappedConversionRateJSON(String wrappedAssetId) throws Exception {
        return new JSONObject(getWrappedConversionRate(wrappedAssetId));
    }

    /**
     * Request to get the conversion rate of a wrapped asset to its corresponding staked asset
     *
     * @param wrappedAssetId: wrapped asset identifier es. CBETH
     * @return conversion rate of a wrapped asset to its corresponding staked asset as double
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate</a>
     **/
    public double getWrappedConversionRateValue(String wrappedAssetId) throws Exception {
        return new JSONObject(getWrappedConversionRate(wrappedAssetId)).getDouble("amount");
    }

    /**
     * Request to get the conversion rate of a wrapped asset to its corresponding staked asset
     *
     * @param wrappedAssetId: wrapped asset identifier es. CBETH
     * @param decimals:       number of digits to round final value
     * @return conversion rate of a wrapped asset to its corresponding staked asset as double
     * @throws IllegalArgumentException if decimalDigits is negative
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwrappedassetconversionrate</a>
     **/
    public double getWrappedConversionRateValue(String wrappedAssetId, int decimals) throws Exception {
        return roundValue(getWrappedConversionRateValue(wrappedAssetId), decimals);
    }

}
