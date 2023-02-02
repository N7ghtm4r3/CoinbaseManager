package com.tecknobit.coinbasemanager.managers.exchangepro.currencies;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.currencies.records.Currency;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.CURRENCIES_ENDPOINT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseCurrenciesManager} class is useful to manage all {@code "Coinbase"} currencies endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies">
 * Currencies manager</a>
 **/
public class CoinbaseCurrenciesManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseCurrenciesManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseCurrenciesManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseCurrenciesManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseCurrenciesManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseCurrenciesManager} <br>
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
    public CoinbaseCurrenciesManager() {
        super();
    }

    /**
     * Request to get list of all currencies<br>
     * No-any params required
     *
     * @return list of all currencies as {@link ArrayList} of {@link Currency}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies">
     * Get all known currencies</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/currencies")
    public ArrayList<Currency> getAllKnownCurrencies() throws Exception {
        return getAllKnownCurrencies(LIBRARY_OBJECT);
    }

    /**
     * Request to get list of all currencies
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return list of all currencies as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies">
     * Get all known currencies</a>
     **/
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/currencies")
    public <T> T getAllKnownCurrencies(ReturnFormat format) throws Exception {
        String currenciesResponse = sendAPIRequest(CURRENCIES_ENDPOINT, GET);
        switch (format) {
            case JSON:
                return (T) new JSONArray(currenciesResponse);
            case LIBRARY_OBJECT:
                ArrayList<Currency> currencies = new ArrayList<>();
                JSONArray jCurrencies = new JSONArray(currenciesResponse);
                for (int j = 0; j < jCurrencies.length(); j++)
                    currencies.add(new Currency(jCurrencies.getJSONObject(j)));
                return (T) currencies;
            default:
                return (T) currenciesResponse;
        }
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency">
     *     Get a currency</a>
     * @return currency as {@link Currency} custom object
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
     * **/
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/currencies/{currency_id}")
    public Currency getCurrency(String currencyId) throws Exception {
        return getCurrency(currencyId, LIBRARY_OBJECT);
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency">
     *     Get a currency</a>
     * @return currency as {@code "format"} defines
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
     * **/
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/currencies/{currency_id}")
    public <T> T getCurrency(String currencyId, ReturnFormat format) throws Exception {
        String currencyResponse = sendAPIRequest(CURRENCIES_ENDPOINT + "/" + currencyId, GET);
        switch (format) {
            case JSON:
                return (T) new JSONObject(currencyResponse);
            case LIBRARY_OBJECT:
                return (T) new Currency(new JSONObject(currencyResponse));
            default:
                return (T) currencyResponse;
        }
    }

}
