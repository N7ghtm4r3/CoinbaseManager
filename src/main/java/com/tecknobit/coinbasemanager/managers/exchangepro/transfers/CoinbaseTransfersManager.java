package com.tecknobit.coinbasemanager.managers.exchangepro.transfers;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.CoinbaseAccount;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.CryptoAddress;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Transfer;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Transfer.TransferType;
import com.tecknobit.coinbasemanager.managers.exchangepro.currencies.records.Currency;
import com.tecknobit.coinbasemanager.managers.exchangepro.profiles.records.Profile;
import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.TransferAction;
import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods.PaymentMethod;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.apis.APIRequest.POST_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.*;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Transfer.returnTransfersList;
import static com.tecknobit.coinbasemanager.managers.exchangepro.transfers.CoinbaseTransfersManager.MethodId.*;

/**
 * The {@code CoinbaseTransfersManager} class is useful to manage all {@code "Coinbase"} transfers endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
 * Transfers manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseTransfersManager extends CoinbaseManager {

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currency:          currency used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public TransferAction depositFromCoinbaseAccount(double amount, String coinbaseAccountId,
                                                     Currency currency) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Constructor to init a {@link CoinbaseTransfersManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseTransfersManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseTransfersManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseTransfersManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseTransfersManager} <br>
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
    public CoinbaseTransfersManager() {
        super();
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currency:          currency used in deposit
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public <T> T depositFromCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                            ReturnFormat format) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), format);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId:        identifier of currency used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public TransferAction depositFromCoinbaseAccount(double amount, String coinbaseAccountId,
                                                     String currencyId) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId:        identifier of currency used in deposit
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public <T> T depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                            ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(DEPOSIT_FROM_COINBASE_ENDPOINT, POST_METHOD,
                        createTransferPayload(amount, coinbase_account_id, coinbaseAccountId, currencyId, null)),
                format);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currency:          currency used in deposit
     * @param profile:           profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public TransferAction depositFromCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                                     Profile profile) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currency:          currency used in deposit
     * @param profile:           profile used in deposit
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public <T> T depositFromCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                            Profile profile, ReturnFormat format) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profile.getId(), format);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currency:          currency used in deposit
     * @param profileId:         identifier of profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public TransferAction depositFromCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                                     String profileId) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currency:          currency used in deposit
     * @param profileId:         identifier of profile used in deposit
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public <T> T depositFromCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                            String profileId, ReturnFormat format) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profileId, format);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId:        identifier of currency used in deposit
     * @param profile:           profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public TransferAction depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                                     Profile profile) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId, profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId:        identifier of currency used in deposit
     * @param profile:           profile used in deposit
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public <T> T depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                            Profile profile, ReturnFormat format) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId, profile.getId(), format);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId:        identifier of currency used in deposit
     * @param profileId:         identifier of profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public TransferAction depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                                     String profileId) throws Exception {
        return depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId, profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit from a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId:        identifier of currency used in deposit
     * @param profileId:         identifier of profile used in deposit
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     * Deposit from Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/coinbase-account")
    public <T> T depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                            String profileId, ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(DEPOSIT_FROM_COINBASE_ENDPOINT, POST_METHOD,
                        createTransferPayload(amount, coinbase_account_id, coinbaseAccountId, currencyId, profileId)),
                format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currency:      currency used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, PaymentMethod paymentMethod,
                                                   Currency currency) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currency:      currency used in deposit
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                          ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currency:        currency used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, String paymentMethodId, Currency currency) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currency:        currency used in deposit
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                          ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currency.getId(), format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currencyId:    currency used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, PaymentMethod paymentMethod,
                                                   String currencyId) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currencyId:    currency used in deposit
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                          ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currencyId, format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId:      currency used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId:      currency used in deposit
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                          ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                        createTransferPayload(amount, payment_method_id, paymentMethodId, currencyId, null)),
                format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currency:      identifier of currency used in deposit
     * @param profileId:     identifier of profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                                   Profile profileId) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profileId.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currency:      identifier of currency used in deposit
     * @param profile:       profile used in deposit
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                          Profile profile, ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profile.getId(), format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currency:      identifier of currency used in deposit
     * @param profileId:     identifier of profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                                   String profileId) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currency:      identifier of currency used in deposit
     * @param profileId:     identifier of profile used in deposit
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                          String profileId, ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profileId, format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currency:        identifier of currency used in deposit
     * @param profile:         profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                                   Profile profile) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currency.getId(), profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currency:        identifier of currency used in deposit
     * @param profile:         profile used in deposit
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                          Profile profile, ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currency.getId(), profile.getId(), format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currency:        identifier of currency used in deposit
     * @param profileId:       identifier of profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                                   String profileId) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currency.getId(), profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currency:        identifier of currency used in deposit
     * @param profileId:       identifier of profile used in deposit
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                          String profileId, ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currency.getId(), profileId, format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currencyId:    currency used in deposit
     * @param profile:       profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                                   Profile profile) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currencyId, profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:        amount to deposit
     * @param paymentMethod: payment method used in deposit
     * @param currencyId:    currency used in deposit
     * @param profile:       profile used in deposit
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                          Profile profile, ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethod.getId(), currencyId, profile.getId(), format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId:      currency used in deposit
     * @param profile:         profile used in deposit
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                                   Profile profile) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currencyId, profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId:      currency used in deposit
     * @param profile:         profile used in deposit
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                          Profile profile, ReturnFormat format) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currencyId, profile.getId(), format);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId:      currency used in deposit
     * @param profileId:       identifier of profile used in deposit
     * @return result of deposit as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public TransferAction depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                                   String profileId) throws Exception {
        return depositFromPaymentMethod(amount, paymentMethodId, currencyId, profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to deposit using payment method
     *
     * @param amount:          amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId:      currency used in deposit
     * @param profileId:       identifier of profile used in deposit
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     * Deposit from payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/deposits/payment-method")
    public <T> T depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                          String profileId, ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                createTransferPayload(amount, payment_method_id, paymentMethodId, currencyId, profileId)), format);
    }

    /**
     * Request to get all payment methods list <br>
     * Any params required
     *
     * @return payment methods list as {@link ArrayList} of {@link PaymentMethod}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/payment-methods")
    public ArrayList<PaymentMethod> getAllPaymentMethods() throws Exception {
        return getAllPaymentMethods(LIBRARY_OBJECT);
    }

    /**
     * Request to get all payment methods
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return payment methods list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     * Get all payment methods</a>
     **/
    @Returner
    @RequestPath(path = "https://api.exchange.coinbase.com/payment-methods")
    public <T> T getAllPaymentMethods(ReturnFormat format) throws Exception {
        String paymentResponse = sendAPIRequest(PAYMENTS_METHOD_ENDPOINT, GET_METHOD);
        switch (format) {
            case JSON:
                return (T) new JSONArray(paymentResponse);
            case LIBRARY_OBJECT:
                ArrayList<PaymentMethod> payment = new ArrayList<>();
                JSONArray jPayment = new JSONArray(paymentResponse);
                for (int j = 0; j < jPayment.length(); j++)
                    payment.add(new PaymentMethod(jPayment.getJSONObject(j)));
                return (T) payment;
            default:
                return (T) paymentResponse;
        }
    }

    /**
     * Request to get all transfers list <br>
     * Any params required
     *
     * @return transfers list as {@link ArrayList} of {@link Transfer}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     * Get all transfers</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/transfers")
    public ArrayList<Transfer> getAllTransfers() throws Exception {
        return returnTransfersList(sendAPIRequest(TRANSFERS_ENDPOINT, GET_METHOD), LIBRARY_OBJECT);
    }

    /**
     * Request to get all transfers list
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return transfers list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     * Get all transfers</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/transfers")
    public <T> T getAllTransfers(ReturnFormat format) throws Exception {
        return returnTransfersList(sendAPIRequest(TRANSFERS_ENDPOINT, GET_METHOD), format);
    }

    /**
     * Request to get all transfers list
     *
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "type"} -> specify transfers 'deposit' or 'withdraw', constants available:
     *                              {@link TransferType} - [string]
     *                          </li>
     *                     </ul>
     * @return transfers list as {@link ArrayList} of {@link Transfer}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     * Get all transfers</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/transfers")
    public ArrayList<Transfer> getAllTransfers(Params queryParams) throws Exception {
        return returnTransfersList(sendAPIRequest(TRANSFERS_ENDPOINT + queryParams.createQueryString(), GET_METHOD),
                LIBRARY_OBJECT);
    }

    /**
     * Request to get all transfers list
     *
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "type"} -> specify transfers 'deposit' or 'withdraw', constants available:
     *                              {@link TransferType} - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return transfers list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     * Get all transfers</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/transfers")
    public <T> T getAllTransfers(Params queryParams, ReturnFormat format) throws Exception {
        return returnTransfersList(sendAPIRequest(TRANSFERS_ENDPOINT + queryParams.createQueryString(),
                GET_METHOD), format);
    }

    /**
     * Request to get a single transfer
     *
     * @param transferId: identifier used to fetch information
     * @return single transfer as {@link Transfer} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1">
     * Get a single transfer</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/transfers/{transfer_id}")
    public Transfer getSingleTransfer(String transferId) throws Exception {
        return getSingleTransfer(transferId, LIBRARY_OBJECT);
    }

    /**
     * Request to get a single transfer
     *
     * @param transferId: identifier used to fetch information
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return single transfer as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1">
     * Get a single transfer</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/transfers/{transfer_id}")
    public <T> T getSingleTransfer(String transferId, ReturnFormat format) throws Exception {
        return returnTransferAction(sendAPIRequest(TRANSFERS_ENDPOINT + "/" + transferId, GET_METHOD), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currency:        currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount,
                                                    Currency currency) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currency:        currency used in the withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, Currency currency,
                                           ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currency.getId(), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currency:          currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, String coinbaseAccountId,
                                                    Currency currency) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currency:          currency used in the withdraw
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                           ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount,
                                                    String currencyId) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount,
                                           String currencyId, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currencyId, format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId:        identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, String coinbaseAccountId,
                                                    String currencyId) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId:        identifier of currency used in withdraw
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, String coinbaseAccountId,
                                           String currencyId, ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(WITHDRAW_TO_COINBASE_ENDPOINT, POST_METHOD,
                createTransferPayload(amount, coinbase_account_id, coinbaseAccountId, currencyId,
                        null)), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currency:        currency used in the withdraw
     * @param profile:         profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, Currency currency,
                                                    Profile profile) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currency.getId(), profile.getId(),
                LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currency:        currency used in the withdraw
     * @param profile:         profile used in the withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, Currency currency,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currency.getId(), profile.getId(), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, String currencyId,
                                                    String profileId) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currencyId, profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, String currencyId,
                                           String profileId, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currencyId, profileId, format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currency:        currency used in the withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, Currency currency,
                                                    String profileId) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currency.getId(), profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currency:        currency used in the withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, Currency currency,
                                           String profileId, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currency.getId(), profileId, format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currency:          currency used in the withdraw
     * @param profileId:         identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                                    String profileId) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currency:          currency used in the withdraw
     * @param profileId:         identifier of profile used in withdraw
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                           String profileId, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profileId, format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profile:         profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, String currencyId,
                                                    Profile profile) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currencyId, profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:          amount to withdraw
     * @param coinbaseAccount: coinbase account in the withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profile:         profile used in the withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, CoinbaseAccount coinbaseAccount, String currencyId,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccount.getId(), currencyId, profile.getId(), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currency:          currency used in the withdraw
     * @param profile:           profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                                    Profile profile) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currency:          currency used in the withdraw
     * @param profile:           profile used in the withdraw
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, Currency currency,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currency.getId(), profile.getId(), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId:        identifier of currency used in withdraw
     * @param profile:           profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                                    Profile profile) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId, profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId:        identifier of currency used in withdraw
     * @param profile:           profile used in the withdraw
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId, profile.getId(), format);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId:        identifier of currency used in withdraw
     * @param profileId:         identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public TransferAction withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                                    String profileId) throws Exception {
        return withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId, profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to a {@code "Coinbase"}'s account
     *
     * @param amount:            amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId:        identifier of currency used in withdraw
     * @param profileId:         identifier of profile used in withdraw
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     * Withdraw to Coinbase account</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/coinbase-account")
    public <T> T withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                           String profileId, ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(WITHDRAW_TO_COINBASE_ENDPOINT, POST_METHOD,
                        createTransferPayload(amount, coinbase_account_id, coinbaseAccountId, currencyId, profileId)),
                format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:   amount to withdraw
     * @param crypto:   crypto address used in the withdraw
     * @param currency: currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, CryptoAddress crypto, Currency currency) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:   amount to withdraw
     * @param crypto:   crypto address used in the withdraw
     * @param currency: currency used in the withdraw
     * @param format:   return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, CryptoAddress crypto, Currency currency, ReturnFormat format) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currency.getId(), format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, String cryptoAddress, Currency currency) throws Exception {
        return withdrawToCrypto(amount, cryptoAddress, currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, String cryptoAddress, Currency currency, ReturnFormat format) throws Exception {
        return withdrawToCrypto(amount, cryptoAddress, currency.getId(), format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:     amount to withdraw
     * @param crypto:     crypto address used in the withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, CryptoAddress crypto, String currencyId) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:     amount to withdraw
     * @param crypto:     crypto address used in the withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, CryptoAddress crypto, String currencyId, ReturnFormat format) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currencyId, format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, String cryptoAddress, String currencyId) throws Exception {
        return withdrawToCrypto(amount, cryptoAddress, currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, String cryptoAddress, String currencyId,
                                  ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(WITHDRAW_TO_CRYPTO_ENDPOINT, POST_METHOD,
                createTransferPayload(amount, crypto_address, cryptoAddress, currencyId, null)), format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:      amount to withdraw
     * @param crypto:      crypto address used in the withdraw
     * @param currency:    currency used in the withdraw
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "destination_tag"} -> destination tag - [string]
     *                          </li>
     *                          <li>
     *                              {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                          </li>
     *                          <li>
     *                              {@code "two_factor_code"} -> two factor code - [string]
     *                          </li>
     *                          <li>
     *                              {@code "nonce"} -> nonce - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "fee"} -> fee - [string]
     *                          </li>
     *                          <li>
     *                              {@code "network"} -> network - [string]
     *                          </li>
     *                     </ul>
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, CryptoAddress crypto, Currency currency,
                                           Params extraParams) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currency.getId(), extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:      amount to withdraw
     * @param crypto:      crypto address used in the withdraw
     * @param currency:    currency used in the withdraw
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "destination_tag"} -> destination tag - [string]
     *                          </li>
     *                          <li>
     *                              {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                          </li>
     *                          <li>
     *                              {@code "two_factor_code"} -> two factor code - [string]
     *                          </li>
     *                          <li>
     *                              {@code "nonce"} -> nonce - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "fee"} -> fee - [string]
     *                          </li>
     *                          <li>
     *                              {@code "network"} -> network - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, CryptoAddress crypto, Currency currency, Params extraParams,
                                  ReturnFormat format) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currency.getId(), extraParams, format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @param extraParams:   extra params of the request, keys accepted are:
     *                       <ul>
     *                            <li>
     *                                {@code "profile_id"} -> profile identifier - [string]
     *                            </li>
     *                            <li>
     *                                {@code "destination_tag"} -> destination tag - [string]
     *                            </li>
     *                            <li>
     *                                {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                            </li>
     *                            <li>
     *                                {@code "two_factor_code"} -> two factor code - [string]
     *                            </li>
     *                            <li>
     *                                {@code "nonce"} -> nonce - [integer]
     *                            </li>
     *                            <li>
     *                                {@code "fee"} -> fee - [string]
     *                            </li>
     *                            <li>
     *                                {@code "network"} -> network - [string]
     *                            </li>
     *                       </ul>
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, String cryptoAddress, Currency currency,
                                           Params extraParams) throws Exception {
        return withdrawToCrypto(amount, cryptoAddress, currency.getId(), extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @param extraParams:   extra params of the request, keys accepted are:
     *                       <ul>
     *                            <li>
     *                                {@code "profile_id"} -> profile identifier - [string]
     *                            </li>
     *                            <li>
     *                                {@code "destination_tag"} -> destination tag - [string]
     *                            </li>
     *                            <li>
     *                                {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                            </li>
     *                            <li>
     *                                {@code "two_factor_code"} -> two factor code - [string]
     *                            </li>
     *                            <li>
     *                                {@code "nonce"} -> nonce - [integer]
     *                            </li>
     *                            <li>
     *                                {@code "fee"} -> fee - [string]
     *                            </li>
     *                            <li>
     *                                {@code "network"} -> network - [string]
     *                            </li>
     *                       </ul>
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, String cryptoAddress, Currency currency, Params extraParams,
                                  ReturnFormat format) throws Exception {
        return withdrawToCrypto(amount, cryptoAddress, currency.getId(), extraParams, format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:      amount to withdraw
     * @param crypto:      crypto address used in the withdraw
     * @param currencyId:  identifier of currency used in withdraw
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "destination_tag"} -> destination tag - [string]
     *                          </li>
     *                          <li>
     *                              {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                          </li>
     *                          <li>
     *                              {@code "two_factor_code"} -> two factor code - [string]
     *                          </li>
     *                          <li>
     *                              {@code "nonce"} -> nonce - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "fee"} -> fee - [string]
     *                          </li>
     *                          <li>
     *                              {@code "network"} -> network - [string]
     *                          </li>
     *                     </ul>
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, CryptoAddress crypto, String currencyId,
                                           Params extraParams) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currencyId, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:      amount to withdraw
     * @param crypto:      crypto address used in the withdraw
     * @param currencyId:  identifier of currency used in withdraw
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "profile_id"} -> profile identifier - [string]
     *                          </li>
     *                          <li>
     *                              {@code "destination_tag"} -> destination tag - [string]
     *                          </li>
     *                          <li>
     *                              {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                          </li>
     *                          <li>
     *                              {@code "two_factor_code"} -> two factor code - [string]
     *                          </li>
     *                          <li>
     *                              {@code "nonce"} -> nonce - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "fee"} -> fee - [string]
     *                          </li>
     *                          <li>
     *                              {@code "network"} -> network - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, CryptoAddress crypto, String currencyId,
                                  Params extraParams, ReturnFormat format) throws Exception {
        return withdrawToCrypto(amount, crypto.getAddress(), currencyId, extraParams, format);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @param extraParams:   extra params of the request, keys accepted are:
     *                       <ul>
     *                            <li>
     *                                {@code "profile_id"} -> profile identifier - [string]
     *                            </li>
     *                            <li>
     *                                {@code "destination_tag"} -> destination tag - [string]
     *                            </li>
     *                            <li>
     *                                {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                            </li>
     *                            <li>
     *                                {@code "two_factor_code"} -> two factor code - [string]
     *                            </li>
     *                            <li>
     *                                {@code "nonce"} -> nonce - [integer]
     *                            </li>
     *                            <li>
     *                                {@code "fee"} -> fee - [string]
     *                            </li>
     *                            <li>
     *                                {@code "network"} -> network - [string]
     *                            </li>
     *                       </ul>
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public TransferAction withdrawToCrypto(double amount, String cryptoAddress, String currencyId,
                                           Params extraParams) throws Exception {
        return withdrawToCrypto(amount, cryptoAddress, currencyId, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw to crypto address
     *
     * @param amount:        amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @param extraParams:   extra params of the request, keys accepted are:
     *                       <ul>
     *                            <li>
     *                                {@code "profile_id"} -> profile identifier - [string]
     *                            </li>
     *                            <li>
     *                                {@code "destination_tag"} -> destination tag - [string]
     *                            </li>
     *                            <li>
     *                                {@code "no_destination_tag"} -> no destination tag - [boolean]
     *                            </li>
     *                            <li>
     *                                {@code "two_factor_code"} -> two factor code - [string]
     *                            </li>
     *                            <li>
     *                                {@code "nonce"} -> nonce - [integer]
     *                            </li>
     *                            <li>
     *                                {@code "fee"} -> fee - [string]
     *                            </li>
     *                            <li>
     *                                {@code "network"} -> network - [string]
     *                            </li>
     *                       </ul>
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     * Withdraw to crypto address</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/crypto")
    public <T> T withdrawToCrypto(double amount, String cryptoAddress, String currencyId,
                                  Params extraParams, ReturnFormat format) throws Exception {
        Params payload = createTransferPayload(amount, crypto_address, cryptoAddress, currencyId, null);
        payload.mergeParams(extraParams);
        return returnTransferAction(sendPayloadedRequest(WITHDRAW_TO_CRYPTO_ENDPOINT, POST_METHOD, payload),
                format);
    }

    /**
     * Method to assemble a payload
     *
     * @param amount:        amount used in a transfer action
     * @param keyMethodId:   method used in the transfer
     * @param valueMethodId: value of keyMethodId
     * @param currencyId:    identifier of currency used in a transfer action
     * @param profileId:     identifier of profile used in a transfer action
     * @return a payload as {@link Params}
     **/
    private Params createTransferPayload(double amount, MethodId keyMethodId, String valueMethodId,
                                         String currencyId, String profileId) {
        Params payload = new Params();
        payload.addParam("amount", amount);
        payload.addParam(keyMethodId.name(), valueMethodId);
        payload.addParam("currency", currencyId);
        if (profileId != null)
            payload.addParam("profile_id", profileId);
        return payload;
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param crypto:   crypto address used in the withdraw
     * @param currency: identifier of currency used in withdraw
     * @param decimals: number of digits to round final value
     * @return estimate fee of withdraw as double
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(CryptoAddress crypto, Currency currency, int decimals) throws Exception {
        return roundValue(getFeeForCryptoWithdrawal(crypto.getAddress(), currency.getId()), decimals);
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param crypto:   crypto address used in the withdraw
     * @param currency: currency used in the withdraw
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(CryptoAddress crypto, Currency currency) throws Exception {
        return Double.parseDouble(getFeeForCryptoWithdrawal(crypto.getAddress(), currency.getId(), LIBRARY_OBJECT));
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param crypto:   crypto address used in the withdraw
     * @param currency: currency used in the withdraw
     * @return estimated fee as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     * @implNote in this case {@link ReturnFormat#LIBRARY_OBJECT} will return the {@link String} value of the fee,
     * with the wrappers methods it will be parsed as double, if you directly access to this method you will need to parse as well
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public <T> T getFeeForCryptoWithdrawal(CryptoAddress crypto, Currency currency, ReturnFormat format) throws Exception {
        return getFeeForCryptoWithdrawal(crypto.getAddress(), currency.getId(), format);
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      identifier of currency used in withdraw
     * @param decimals:      number of digits to round final value
     * @return estimate fee of withdraw as double
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(String cryptoAddress, Currency currency, int decimals) throws Exception {
        return roundValue(getFeeForCryptoWithdrawal(cryptoAddress, currency.getId()), decimals);
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(String cryptoAddress, Currency currency) throws Exception {
        return Double.parseDouble(getFeeForCryptoWithdrawal(cryptoAddress, currency.getId(), LIBRARY_OBJECT));
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @return estimated fee as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     * @implNote in this case {@link ReturnFormat#LIBRARY_OBJECT} will return the {@link String} value of the fee,
     * with the wrappers methods it will be parsed as double, if you directly access to this method you will need to parse as well
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public <T> T getFeeForCryptoWithdrawal(String cryptoAddress, Currency currency, ReturnFormat format) throws Exception {
        return getFeeForCryptoWithdrawal(cryptoAddress, currency.getId(), format);
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param crypto:   crypto address used in the withdraw
     * @param currency: identifier of currency used in withdraw
     * @param decimals: number of digits to round final value
     * @return estimate fee of withdraw as double
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(CryptoAddress crypto, String currency, int decimals) throws Exception {
        return roundValue(getFeeForCryptoWithdrawal(crypto.getAddress(), currency), decimals);
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param crypto:   crypto address used in the withdraw
     * @param currency: currency used in the withdraw
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(CryptoAddress crypto, String currency) throws Exception {
        return Double.parseDouble(getFeeForCryptoWithdrawal(crypto.getAddress(), currency, LIBRARY_OBJECT));
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param crypto:   crypto address used in the withdraw
     * @param currency: currency used in the withdraw
     * @return estimated fee as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     * @implNote in this case {@link ReturnFormat#LIBRARY_OBJECT} will return the {@link String} value of the fee,
     * with the wrappers methods it will be parsed as double, if you directly access to this method you will need to parse as well
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public <T> T getFeeForCryptoWithdrawal(CryptoAddress crypto, String currency, ReturnFormat format) throws Exception {
        return getFeeForCryptoWithdrawal(crypto.getAddress(), currency, format);
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      identifier of currency used in withdraw
     * @param decimals:      number of digits to round final value
     * @return estimate fee of withdraw as double
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(String cryptoAddress, String currency, int decimals) throws Exception {
        return roundValue(getFeeForCryptoWithdrawal(cryptoAddress, currency), decimals);
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @return estimated fee as double
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public double getFeeForCryptoWithdrawal(String cryptoAddress, String currency) throws Exception {
        return Double.parseDouble(getFeeForCryptoWithdrawal(cryptoAddress, currency, LIBRARY_OBJECT));
    }

    /**
     * Request to get estimated fee of withdraw to crypto address
     *
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      currency used in the withdraw
     * @return estimated fee as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * Get fee estimate for crypto withdrawal</a>
     * @implNote in this case {@link ReturnFormat#LIBRARY_OBJECT} will return the {@link String} value of the fee,
     * with the wrappers methods it will be parsed as double, if you directly access to this method you will need to parse as well
     **/
    @Returner
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/fee-estimate")
    public <T> T getFeeForCryptoWithdrawal(String cryptoAddress, String currency, ReturnFormat format) throws Exception {
        String queryParams = "?currency=" + currency + "&crypto_address=" + cryptoAddress;
        String feeResponse = sendAPIRequest(FEE_WITHDRAW_TO_CRYPTO_ENDPOINT + queryParams, GET_METHOD);
        switch (format) {
            case JSON:
                return (T) new JSONObject(feeResponse);
            case LIBRARY_OBJECT:
                return (T) new JSONObject(feeResponse).getString("fee");
            default:
                return (T) feeResponse;
        }
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currency:      currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currency:      currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                           ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currency:        currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, String paymentMethodId, Currency currency) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currency.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currency:        currency used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                           ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currency.getId(), format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod,
                                                    String currencyId) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                           ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currencyId, format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currencyId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                           ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(WITHDRAW_TO_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                createTransferPayload(amount, payment_method_id, paymentMethodId, currencyId, null)), format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currency:      currency used in the withdraw
     * @param profile:       profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                                    Profile profile) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currency:      currency used in the withdraw
     * @param profile:       profile used in the withdraw
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profile.getId(), format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @param profile:       profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                                    Profile profile) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currencyId, profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @param profile:       profile used in the withdraw
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currencyId, profile.getId(), format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @param profileId:     identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                                    String profileId) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currencyId, profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currencyId:    identifier of currency used in withdraw
     * @param profileId:     identifier of profile used in withdraw
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, String currencyId,
                                           String profileId, ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currencyId, profileId, format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currency:      currency used in the withdraw
     * @param profileId:     identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                                    String profileId) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:        amount to withdraw
     * @param paymentMethod: payment method used in the withdraw
     * @param currency:      currency used in the withdraw
     * @param profileId:     identifier of profile used in withdraw
     * @param format:        return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, PaymentMethod paymentMethod, Currency currency,
                                           String profileId, ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethod.getId(), currency.getId(), profileId, format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currency:        currency used in the withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                                    String profileId) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currency.getId(), profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currency:        currency used in the withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                           String profileId, ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currency.getId(), profileId, format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currency:        currency used in the withdraw
     * @param profile:         profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                                    Profile profile) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currency.getId(), profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currency:        currency used in the withdraw
     * @param profile:         profile used in the withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, String paymentMethodId, Currency currency,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currency.getId(), profile.getId(), format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profile:         profile used in the withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                                    Profile profile) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currencyId, profile.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profile:         profile used in the withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                           Profile profile, ReturnFormat format) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currencyId, profile.getId(), format);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @return result of withdraw as {@link TransferAction} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public TransferAction withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                                    String profileId) throws Exception {
        return withdrawFromPaymentMethod(amount, paymentMethodId, currencyId, profileId, LIBRARY_OBJECT);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @param profileId:       identifier of profile used in withdraw
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return result of withdraw as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * Withdraw to payment method</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/withdrawals/payment-method")
    public <T> T withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                           String profileId, ReturnFormat format) throws Exception {
        return returnTransferAction(sendPayloadedRequest(WITHDRAW_TO_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                createTransferPayload(amount, payment_method_id, paymentMethodId, currencyId, profileId)), format);
    }

    /**
     * MethodId to create a transfer action object
     *
     * @param transferActionResponse: transfer action to format
     * @param format:                 return type formatter -> {@link ReturnFormat}
     * @return transfer action response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnTransferAction(String transferActionResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONObject(transferActionResponse);
            case LIBRARY_OBJECT:
                return (T) new TransferAction(new JSONObject(transferActionResponse));
            default:
                return (T) transferActionResponse;
        }
    }

    /**
     * {@code MethodId} list of available methods
     **/
    public enum MethodId {

        /**
         * {@code "coinbase_account_id"} {@code "Coinbase"} account method type
         **/
        coinbase_account_id,

        /**
         * {@code "payment_method_id"} payment method type
         **/
        payment_method_id,

        /**
         * {@code "crypto_address"} crypto address method type
         **/
        crypto_address

    }

}
