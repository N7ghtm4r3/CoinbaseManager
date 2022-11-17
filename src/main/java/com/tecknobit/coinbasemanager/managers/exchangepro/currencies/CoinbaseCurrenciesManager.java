package com.tecknobit.coinbasemanager.managers.exchangepro.currencies;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.currencies.records.Currency;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.CURRENCIES_ENDPOINT;

/**
 * The {@code CoinbaseCurrenciesManager} class is useful to manage all {@code "Coinbase"} currencies endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1">
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
    public CoinbaseCurrenciesManager() {
        super();
    }

    /**
     * Request to get list of all currencies
     * Any params required
     *
     * @return list of all currencies as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1</a>
     **/
    public String getAllKnownCurrencies() throws Exception {
        return sendAPIRequest(CURRENCIES_ENDPOINT, GET_METHOD);
    }

    /**
     * Request to get list of all currencies
     * Any params required
     *
     * @return list of all currencies as {@link JSONArray}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1</a>
     **/
    public JSONArray getJSONAllKnownCurrencies() throws Exception {
        return new JSONArray(getAllKnownCurrencies());
    }

    /**
     * Request to get list of all currencies
     * Any params required
     *
     * @return list of all currencies as {@link ArrayList} of {@link Currency}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies-1</a>
     **/
    public ArrayList<Currency> getAllKnownCurrenciesList() throws Exception {
        ArrayList<Currency> currencies = new ArrayList<>();
        JSONArray jsonCurrencies = new JSONArray(getAllKnownCurrencies());
        for (int j = 0; j < jsonCurrencies.length(); j++)
            currencies.add(new Currency(jsonCurrencies.getJSONObject(j)));
        return currencies;
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1</a>
     * @return currency as {@link String}
     * **/
    public String getCurrency(String currencyId) throws Exception {
        return sendAPIRequest(CURRENCIES_ENDPOINT + "/" + currencyId, GET_METHOD);
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1</a>
     * @return currency as {@link JSONObject}
     * **/
    public JSONObject getJSONCurrency(String currencyId) throws Exception {
        return new JSONObject(getCurrency(currencyId));
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency-1</a>
     * @return currency as {@link Currency} custom object
     * **/
    public Currency getCurrencyObject(String currencyId) throws Exception {
        return new Currency(new JSONObject(getCurrency(currencyId)));
    }

}
