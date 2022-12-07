package com.tecknobit.coinbasemanager.managers.exchangepro.conversions;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.conversions.records.CurrencyConversion;
import org.json.JSONObject;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.CONVERSIONS_ENDPOINT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseConversionsManager} class is useful to manage all {@code "Coinbase"} conversion endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion-1">
 * Conversions manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseConversionsManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseConversionsManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseConversionsManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseConversionsManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseConversionsManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseConversionsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseConversionsManager} <br>
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
    public CoinbaseConversionsManager() {
        super();
    }

    /**
     * Request to convert one currency into another one
     *
     * @param from:   currency to convert
     * @param to:     final currency to convert
     * @param amount: amount value to convert
     * @return result of conversion as {@link CurrencyConversion} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion-1">
     * Convert currency</a>
     **/
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/conversions")
    public CurrencyConversion convertCurrency(String from, String to, double amount) throws Exception {
        return convertCurrency(from, to, amount, LIBRARY_OBJECT);
    }

    /**
     * Request to convert one currency into another one
     *
     * @param from:   currency to convert
     * @param to:     final currency to convert
     * @param amount: amount value to convert
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return result of conversion as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion-1">
     * Convert currency</a>
     **/
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/conversions")
    public <T> T convertCurrency(String from, String to, double amount, ReturnFormat format) throws Exception {
        return returnCurrencyConversion(sendPayloadedRequest(CONVERSIONS_ENDPOINT, POST,
                getConversionPayload(from, to, amount)), format);
    }

    /**
     * Request to convert one currency into another one
     *
     * @param from:        currency to convert
     * @param to:          final currency to convert
     * @param amount:      amount value to convert
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "nonce"} -> nonce value - [string]
     *                          </li>
     *                     </ul>
     * @return result of conversion as {@link CurrencyConversion} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion-1">
     * Convert currency</a>
     **/
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/conversions")
    public CurrencyConversion convertCurrency(String from, String to, double amount, Params extraParams) throws Exception {
        return convertCurrency(from, to, amount, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to convert one currency into another one
     *
     * @param from:        currency to convert
     * @param to:          final currency to convert
     * @param amount:      amount value to convert
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "nonce"} -> nonce value - [string]
     *                          </li>
     *                     </ul>
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of conversion as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postconversion-1">
     * Convert currency</a>
     **/
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/conversions")
    public <T> T convertCurrency(String from, String to, double amount, Params extraParams,
                                 ReturnFormat format) throws Exception {
        extraParams.mergeParams(getConversionPayload(from, to, amount));
        return returnCurrencyConversion(sendPayloadedRequest(CONVERSIONS_ENDPOINT, POST, extraParams), format);
    }

    /**
     * Method to assemble a payload
     *
     * @param from:   currency to convert
     * @param to:     final currency to convert
     * @param amount: amount value to convert
     * @return a payload as {@link Params}
     **/
    private Params getConversionPayload(String from, String to, double amount) {
        Params payload = new Params();
        payload.addParam("from", from);
        payload.addParam("to", to);
        payload.addParam("amount", amount);
        return payload;
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion-1">
     *     Get a conversion</a>
     * @return information about one conversion as {@link CurrencyConversion} custom object
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
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/conversions/{conversion_id}")
    public CurrencyConversion getCurrencyConversion(String conversionId) throws Exception {
        return getCurrencyConversion(conversionId, LIBRARY_OBJECT);
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion-1">
     *     Get a conversion</a>
     * @return information about one conversion as {@code "format"} defines
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
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/conversions/{conversion_id}")
    public <T> T getCurrencyConversion(String conversionId, ReturnFormat format) throws Exception {
        return returnCurrencyConversion(sendAPIRequest(CONVERSIONS_ENDPOINT + "/" + conversionId, GET),
                format);
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @param profileId: identifier of account to fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion-1">
     *     Get a conversion</a>
     * @return information about one conversion as {@link CurrencyConversion} custom object
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
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/conversions/{conversion_id}")
    public CurrencyConversion getCurrencyConversion(String conversionId, String profileId) throws Exception {
        return getCurrencyConversion(conversionId, profileId, LIBRARY_OBJECT);
    }

    /** Request to get information about one conversion
     * @param conversionId: identifier of conversion to fetch details
     * @param profileId: identifier of account to fetch details
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getconversion-1">
     *     Get a conversion</a>
     * @return information about one conversion as {@code "format"} defines
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
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/conversions/{conversion_id}")
    public <T> T getCurrencyConversion(String conversionId, String profileId, ReturnFormat format) throws Exception {
        return returnCurrencyConversion(sendAPIRequest(CONVERSIONS_ENDPOINT + "/" + conversionId + "?profile_id="
                + profileId, GET), format);
    }

    /**
     * Method to assemble a conversion
     *
     * @param conversionResponse: conversion response to format
     * @param format:             return type formatter -> {@link ReturnFormat}
     * @return conversion response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnCurrencyConversion(String conversionResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONObject(conversionResponse);
            case LIBRARY_OBJECT:
                return (T) new CurrencyConversion(new JSONObject(conversionResponse));
            default:
                return (T) conversionResponse;
        }
    }

}
