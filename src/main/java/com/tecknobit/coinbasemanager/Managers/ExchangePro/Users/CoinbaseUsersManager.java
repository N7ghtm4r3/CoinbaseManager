package com.tecknobit.coinbasemanager.Managers.ExchangePro.Users;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;

public class CoinbaseUsersManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseUsers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseUsers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseUsers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseUsers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseUsersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

}
