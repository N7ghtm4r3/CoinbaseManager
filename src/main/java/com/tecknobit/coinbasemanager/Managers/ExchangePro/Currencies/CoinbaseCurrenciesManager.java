package com.tecknobit.coinbasemanager.Managers.ExchangePro.Currencies;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Currencies.Records.Currency;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.CURRENCIES_ENDPOINT;

/**
 *  The {@code CoinbaseCurrenciesManager} class is useful to manage all Coinbase currencies endpoints
 *  @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies</a>
 *  @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseCurrenciesManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseCurrencies manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * @param defaultErrorMessage custom error to show when is not a request error
     * @param timeout custom timeout for request
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseCurrencies manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * @param timeout custom timeout for request
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseCurrencies manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * @param defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseCurrencies manager
     * @param apiKey your Coinbase api key
     * @param apiSecret your Coinbase api secret
     * @param passphrase your Coinbase api passphrase
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to get list of all currencies
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies</a>
     * @return list of all currencies as {@link String}
     * **/
    public String getAllKnownCurrencies() throws Exception {
        return sendAPIRequest(CURRENCIES_ENDPOINT, GET_METHOD);
    }

    /** Request to get list of all currencies
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies</a>
     * @return list of all currencies as {@link JSONArray}
     * **/
    public JSONArray getJSONAllKnownCurrencies() throws Exception {
        return new JSONArray(getAllKnownCurrencies());
    }

    /** Request to get list of all currencies
     * any params required
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrencies</a>
     * @return list of all currencies as {@link ArrayList} of {@link Currency}
     * **/
    public ArrayList<Currency> getAllKnownCurrenciesList() throws Exception {
        ArrayList<Currency> currencies = new ArrayList<>();
        jsonArray = new JSONArray(getAllKnownCurrencies());
        for (int j = 0; j < jsonArray.length(); j++)
            currencies.add(assembleCurrencyObject(jsonArray.getJSONObject(j)));
        return currencies;
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency</a>
     * @return currency as {@link String}
     * **/
    public String getCurrency(String currencyId) throws Exception {
        return sendAPIRequest(CURRENCIES_ENDPOINT+"/"+currencyId, GET_METHOD);
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency</a>
     * @return currency as {@link JSONObject}
     * **/
    public JSONObject getJSONCurrency(String currencyId) throws Exception {
        return new JSONObject(getCurrency(currencyId));
    }

    /** Request to get one currency
     * @param currencyId: identifier of a currency es. BTC
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcurrency</a>
     * @return currency as {@link Currency} object
     * **/
    public Currency getCurrencyObject(String currencyId) throws Exception {
        return assembleCurrencyObject(new JSONObject(getCurrency(currencyId)));
    }

    /** Method to assemble a Currency object
     * @param jsonCurrency: jsonObject obtained by response request
     * @return currency as {@link Currency} object
     * **/
    private Currency assembleCurrencyObject(JSONObject jsonCurrency){
        return new Currency(jsonCurrency.getString("id"),
                jsonCurrency.getString("name"),
                jsonCurrency.getString("status"),
                jsonCurrency.getDouble("min_size"),
                jsonCurrency.getDouble("max_precision"),
                jsonCurrency.getString("message"),
                jsonCurrency
        );
    }

}
