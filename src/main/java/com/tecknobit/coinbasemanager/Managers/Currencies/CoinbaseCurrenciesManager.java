package com.tecknobit.coinbasemanager.Managers.Currencies;

import com.tecknobit.coinbasemanager.Constants.EndpointsList;
import com.tecknobit.coinbasemanager.Managers.CoinbaseManager;
import org.json.JSONArray;

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

    public String getAllKnowCurrencies() throws Exception {
        return sendAPIRequest(EndpointsList.CURRENCIES_ENDPOINT, GET_METHOD);
    }

    public JSONArray getJSONAllKnowCurrencies() throws Exception {
        return new JSONArray(getAllKnowCurrencies());
    }


}
