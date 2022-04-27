package com.tecknobit.coinbasemanager.Managers.ExchangePro.Profile;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;

public class CoinbaseProfileManager extends CoinbaseManager {
    /**
     * Constructor to init a Coinbase manager
     *
     * @param apiKey
     * @param apiSecret
     * @param passphrase
     * @param defaultErrorMessage
     * @param timeout
     **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a Coinbase manager
     *
     * @param apiKey
     * @param apiSecret
     * @param passphrase
     * @param timeout
     **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a Coinbase manager
     *
     * @param apiKey
     * @param apiSecret
     * @param passphrase
     * @param defaultErrorMessage
     **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a Coinbase manager
     *
     * @param apiKey
     * @param apiSecret
     * @param passphrase
     **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }
}
