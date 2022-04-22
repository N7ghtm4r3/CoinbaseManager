package com.tecknobit.coinbasemanager.Managers.Currencies;

import com.tecknobit.coinbasemanager.Constants.EndpointsList;
import com.tecknobit.coinbasemanager.Managers.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.Currencies.Records.Currency;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;

public class CoinbaseCurrenciesManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseCurrencies manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseCurrencies manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseCurrencies manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseCurrencies manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseCurrenciesManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String getAllKnownCurrencies() throws Exception {
        return sendAPIRequest(EndpointsList.CURRENCIES_ENDPOINT, GET_METHOD);
    }

    public JSONArray getJSONAllKnownCurrencies() throws Exception {
        return new JSONArray(getAllKnownCurrencies());
    }

    public ArrayList<Currency> getAllKnownCurrenciesList() throws Exception {
        ArrayList<Currency> currencies = new ArrayList<>();
        jsonArray = new JSONArray(getAllKnownCurrencies());
        for (int j = 0; j < jsonArray.length(); j++){
            JSONObject currency = jsonArray.getJSONObject(j);
            currencies.add(new Currency(currency.getString("id"),
                    currency.getString("name"),
                    currency.getString("status"),
                    currency.getDouble("min_size"),
                    currency.getDouble("max_precision"),
                    currency.getString("message"),
                    currency
            ));
        }
        return currencies;
    }

}
