package com.tecknobit.coinbasemanager.managers.exchangepro.transfers;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Transfer;
import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.TransferAction;
import com.tecknobit.coinbasemanager.managers.exchangepro.transfers.records.paymentmethods.PaymentMethod;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.apis.APIRequest.POST_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.*;

/**
 * The {@code CoinbaseTransfersManager} class is useful to manage all Coinbase transfers endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
 **/

public class CoinbaseTransfersManager extends CoinbaseManager {

    /**
     * {@code COINBASE_ACCOUNT_METHOD} is constant for coinbase account identifier method type
     * **/
    public static final String COINBASE_ACCOUNT_METHOD = "coinbase_account_id";

    /**
     * {@code PAYMENT_METHOD} is constant for payment identifier method type
     * **/
    public static final String PAYMENT_METHOD = "payment_method_id";

    /**
     * {@code CRYPTO_ADDRESS_METHOD} is constant for crypto address method type
     * **/
    public static final String CRYPTO_ADDRESS_METHOD = "crypto_address";

    /** Constructor to init a {@link CoinbaseTransfersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a {@link CoinbaseTransfersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a {@link CoinbaseTransfersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a {@link CoinbaseTransfersManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to deposit from a Coinbase's account
     * @param amount: amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId: identifier of currency used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
     * @return result of deposit as {@link String}
     * **/
    public String depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_COINBASE_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, null));
    }

    /** Request to deposit from a Coinbase's account
     * @param amount: amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId: identifier of currency used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
     * @return result of deposit as {@link JSONObject}
     * **/
    public JSONObject depositFromCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId));
    }

    /** Request to deposit from a Coinbase's account
     * @param amount: amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId: identifier of currency used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
     * @return result of deposit as {@link TransferAction} object
     * **/
    public TransferAction depositFromCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return new TransferAction(new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId)));
    }

    /** Request to deposit from a Coinbase's account
     * @param amount: amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId: identifier of currency used in deposit
     * @param profileId: identifier of profile used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
     * @return result of deposit as {@link String}
     * **/
    public String depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                             String profileId) throws Exception {
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_COINBASE_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, profileId));
    }

    /** Request to deposit from a Coinbase's account
     * @param amount: amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId: identifier of currency used in deposit
     * @param profileId: identifier of profile used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
     * @return result of deposit as {@link JSONObject}
     * **/
    public JSONObject depositFromCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId,
                                                     String profileId) throws Exception {
        return new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId, profileId));
    }

    /** Request to deposit from a Coinbase's account
     * @param amount: amount to deposit
     * @param coinbaseAccountId: identifier of coinbase account from deposit
     * @param currencyId: identifier of currency used in deposit
     * @param profileId: identifier of profile used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositcoinbaseaccount-1</a>
     * @return result of deposit as {@link TransferAction} object
     * **/
    public TransferAction depositFromCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId,
                                                           String profileId) throws Exception {
        return new TransferAction(new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId,
                profileId)));
    }

    /** Request to deposit using payment method
     * @param amount: amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId: identifier of currency used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1</a>
     * @return result of deposit as {@link String}
     * **/
    public String depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, PAYMENT_METHOD, paymentMethodId, currencyId, null));
    }

    /** Request to deposit using payment method
     * @param amount: amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId: identifier of currency used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1</a>
     * @return result of deposit as {@link JSONObject}
     * **/
    public JSONObject depositFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId));
    }

    /** Request to deposit using payment method
     * @param amount: amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId: identifier of currency used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1</a>
     * @return result of deposit as {@link TransferAction} object
     * **/
    public TransferAction depositFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId) throws Exception {
        return new TransferAction(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId)));
    }

    /** Request to deposit using payment method
     * @param amount: amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId: identifier of currency used in deposit
     * @param profileId: identifier of profile used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1</a>
     * @return result of deposit as {@link String}
     * **/
    public String depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                           String profileId) throws Exception {
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, PAYMENT_METHOD, paymentMethodId, currencyId, profileId));
    }

    /** Request to deposit using payment method
     * @param amount: amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId: identifier of currency used in deposit
     * @param profileId: identifier of profile used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1</a>
     * @return result of deposit as {@link JSONObject}
     * **/
    public JSONObject depositFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId,
                                                   String profileId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId, profileId));
    }

    /** Request to deposit using payment method
     * @param amount: amount to deposit
     * @param paymentMethodId: identifier of payment method used in deposit
     * @param currencyId: identifier of currency used in deposit
     * @param profileId: identifier of profile used in deposit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postdepositpaymentmethod-1</a>
     * @return result of deposit as {@link TransferAction} object
     * **/
    public TransferAction depositFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId,
                                                         String profileId) throws Exception {
        return new TransferAction(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId,
                profileId)));
    }

    /** Request to get all payment methods list
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
     * @return payment methods list as {@link String}
     * **/
    public String getAllPaymentMethods() throws Exception {
        return sendAPIRequest(PAYMENTS_METHOD_ENDPOINT, GET_METHOD);
    }

    /** Request to get all payment methods list
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
     * @return payment methods list as {@link JSONArray}
     * **/
    public JSONArray getJSONAllPaymentMethods() throws Exception {
        return new JSONArray(getAllPaymentMethods());
    }

    /** Request to get all payment methods list
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getpaymentmethods-1</a>
     * @return payment methods list as {@link ArrayList} of {@link PaymentMethod}
     * **/
    public ArrayList<PaymentMethod> getAllPaymentMethodsList() throws Exception {
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();
        JSONArray jsonPayments = new JSONArray(getAllPaymentMethods());
        for (int j=0; j < jsonPayments.length(); j++)
            paymentMethods.add(new PaymentMethod(jsonPayments.getJSONObject(j)));
        return paymentMethods;
    }

    /** Request to get all transfers list
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1</a>
     * @return transfers list as {@link String}
     * **/
    public String getAllTransfers() throws Exception {
        return sendAPIRequest(TRANSFERS_ENDPOINT, GET_METHOD);
    }

    /** Request to get all transfers list
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1</a>
     * @return transfers list as {@link JSONArray}
     * **/
    public JSONArray getAllTransfersJSON() throws Exception {
        return new JSONArray(getAllTransfers());
    }

    /** Request to get all transfers list
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1</a>
     * @return transfers list as {@link ArrayList} of {@link Transfer}
     * **/
    public ArrayList<Transfer> getAllTransfersList() throws Exception {
        return Transfer.assembleTransfersList(new JSONArray(getAllTransfers()));
    }

    /** Request to get all transfers list
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, limit, type)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1</a>
     * @return transfers list as {@link String}
     * **/
    public String getAllTransfers(Params queryParams) throws Exception {
        return sendAPIRequest(TRANSFERS_ENDPOINT + assembleQueryParams("?", queryParams), GET_METHOD);
    }

    /** Request to get all transfers list
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, limit, type)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1</a>
     * @return transfers list as {@link JSONArray}
     * **/
    public JSONArray getAllTransfersJSON(Params queryParams) throws Exception {
        return new JSONArray(getAllTransfers(queryParams));
    }

    /** Request to get all transfers list
     * @param queryParams: query params of request
     * @implSpec (keys accepted are profile_id, before, after, limit, type)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfers-1</a>
     * @return transfers list as {@link ArrayList} of {@link Transfer}
     * **/
    public ArrayList<Transfer> getAllTransfersList(Params queryParams) throws Exception {
        return Transfer.assembleTransfersList(new JSONArray(getAllTransfers(queryParams)));
    }

    /** Request to get a single transfer
     * @param transferId: identifier used to fetch information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1</a>
     * @return single transfer as {@link String}
     * **/
    public String getSingleTransfer(String transferId) throws Exception {
        return sendAPIRequest(TRANSFERS_ENDPOINT + "/" + transferId, GET_METHOD);
    }

    /** Request to get a single transfer
     * @param transferId: identifier used to fetch information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1</a>
     * @return single transfer as {@link JSONObject}
     * **/
    public JSONObject getSingleTransferJSON(String transferId) throws Exception {
        return new JSONObject(getSingleTransfer(transferId));
    }

    /** Request to get a single transfer
     * @param transferId: identifier used to fetch information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_gettransfer-1</a>
     * @return single transfer as {@link Transfer} object
     * **/
    public Transfer getSingleTransferObject(String transferId) throws Exception {
        return new Transfer(new JSONObject(getSingleTransfer(transferId)));
    }

    /** Request to withdraw to a Coinbase's account
     * @param amount: amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1</a>
     * @return result of withdraw as {@link String}
     * **/
    public String withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_COINBASE_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, null));
    }

    /** Request to withdraw to a Coinbase's account
     * @param amount: amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1</a>
     * @return result of withdraw as {@link JSONObject}
     * **/
    public JSONObject withdrawToCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId));
    }

    /** Request to withdraw to a Coinbase's account
     * @param amount: amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1</a>
     * @return result of withdraw as {@link TransferAction} object
     * **/
    public TransferAction withdrawToCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return new TransferAction(new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId)));
    }

    /** Request to withdraw to a Coinbase's account
     * @param amount: amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param profileId: identifier of profile used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1</a>
     * @return result of withdraw as {@link String}
     * **/
    public String withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                            String profileId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_COINBASE_ENDPOINT, POST_METHOD, assembleTransferActionPayload(amount,
                COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, profileId));
    }

    /** Request to withdraw to a Coinbase's account
     * @param amount: amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param profileId: identifier of profile used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1</a>
     * @return result of withdraw as {@link JSONObject}
     * **/
    public JSONObject withdrawToCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId,
                                                    String profileId) throws Exception {
        return new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId, profileId));
    }

    /** Request to withdraw to a Coinbase's account
     * @param amount: amount to withdraw
     * @param coinbaseAccountId: identifier of coinbase account in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param profileId: identifier of profile used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcoinbaseaccount-1</a>
     * @return result of withdraw as {@link TransferAction} object
     * **/
    public TransferAction withdrawToCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId,
                                                          String profileId) throws Exception {
        return new TransferAction(new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId,
                currencyId, profileId)));
    }

    /** Request to withdraw to crypto address
     * @param amount: amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1</a>
     * @return result of withdraw as {@link String}
     * **/
    public String withdrawToCrypto(double amount, String cryptoAddress, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_CRYPTO_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, CRYPTO_ADDRESS_METHOD, cryptoAddress, currencyId, null));
    }

    /** Request to withdraw to crypto address
     * @param amount: amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1</a>
     * @return result of withdraw as {@link JSONObject}
     * **/
    public JSONObject withdrawToCryptoJSON(double amount, String cryptoAddress, String currencyId) throws Exception {
        return new JSONObject(withdrawToCoinbaseAccount(amount, cryptoAddress, currencyId));
    }

    /** Request to withdraw to crypto address
     * @param amount: amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1</a>
     * @return result of withdraw as {@link TransferAction} object
     * **/
    public TransferAction withdrawToCryptoObject(double amount, String cryptoAddress, String currencyId) throws Exception {
        return new TransferAction(new JSONObject(withdrawToCoinbaseAccount(amount, cryptoAddress, currencyId)));
    }

    /** Request to withdraw to crypto address
     * @param amount: amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, before, after, limit, type)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1</a>
     * @return result of withdraw as {@link String}
     * **/
    public String withdrawToCrypto(double amount, String cryptoAddress, String currencyId,
                                   Params extraBodyParams) throws Exception {
        Params mandatoryBodyParams = assembleTransferActionPayload(amount, CRYPTO_ADDRESS_METHOD,
                cryptoAddress, currencyId, null);
        mandatoryBodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(WITHDRAW_TO_CRYPTO_ENDPOINT, POST_METHOD, mandatoryBodyParams);
    }

    /** Request to withdraw to crypto address
     * @param amount: amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, before, after, limit, type)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1</a>
     * @return result of withdraw as {@link JSONObject}
     * **/
    public JSONObject withdrawToCryptoJSON(double amount, String cryptoAddress, String currencyId,
                                           Params extraBodyParams) throws Exception {
        return new JSONObject(withdrawToCrypto(amount, cryptoAddress, currencyId, extraBodyParams));
    }

    /** Request to withdraw to crypto address
     * @param amount: amount to withdraw
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param extraBodyParams: extra body params of request
     * @implSpec (keys accepted are profile_id, before, after, limit, type)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawcrypto-1</a>
     * @return result of withdraw as {@link TransferAction} object
     * **/
    public TransferAction withdrawToCryptoObject(double amount, String cryptoAddress, String currencyId,
                                                 Params extraBodyParams) throws Exception {
        return new TransferAction(new JSONObject(withdrawToCrypto(amount, cryptoAddress, currencyId, extraBodyParams)));
    }

    /** Method to assemble map of body params
     * @param amount: amount used in a transfer action
     * @param keyMethodId: COINBASE_ACCOUNT_METHOD, PAYMENT_METHOD or CRYPTO_ADDRESS_METHOD
     * @param valueMethodId: value of keyMethodId
     * @param currencyId: identifier of currency used in a transfer action
     * @param profileId: identifier of profile used in a transfer action
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assembleTransferActionPayload(double amount, String keyMethodId, String valueMethodId,
                                                 String currencyId, String profileId){
        Params depositBodyParams = new Params();
        depositBodyParams.addParam("amount", amount);
        depositBodyParams.addParam(keyMethodId, valueMethodId);
        depositBodyParams.addParam("currency", currencyId);
        if(profileId != null)
            depositBodyParams.addParam("profile_id", profileId);
        return depositBodyParams;
    }

    /** Request to get estimate fee of withdraw to crypto address
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1</a>
     * @return estimate fee of withdraw as {@link String}
     * **/
    public String getFeeForCryptoWithdrawal(String cryptoAddress, String currency) throws Exception {
        String queryParams = "?currency=" + currency + "&crypto_address=" + cryptoAddress;
        return sendAPIRequest(FEE_WITHDRAW_TO_CRYPTO_ENDPOINT + queryParams, GET_METHOD);
    }

    /** Request to get estimate fee of withdraw to crypto address
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1</a>
     * @return estimate fee of withdraw as {@link JSONObject}
     * **/
    public JSONObject getFeeForCryptoWithdrawalJSON(String cryptoAddress, String currency) throws Exception {
        return new JSONObject(getFeeForCryptoWithdrawal(cryptoAddress, currency));
    }

    /** Request to get estimate fee of withdraw to crypto address
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1</a>
     * @return estimate fee of withdraw as double
     * **/
    public double getFeeForCryptoWithdrawalValue(String cryptoAddress, String currency) throws Exception {
        JSONObject jsonFee = new JSONObject(getFeeForCryptoWithdrawal(cryptoAddress, currency));
        return jsonFee.getDouble("fee");
    }

    /**
     * Request to get estimate fee of withdraw to crypto address
     *
     * @param cryptoAddress: identifier of crypto address used in withdraw
     * @param currency:      identifier of currency used in withdraw
     * @param decimals:      number of digits to round final value
     * @return estimate fee of withdraw as double
     * @throws IllegalArgumentException if decimalDigits is negative
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getwithdrawfeeestimate-1</a>
     **/
    public double getFeeForCryptoWithdrawalValue(String cryptoAddress, String currency, int decimals) throws Exception {
        return roundValue(getFeeForCryptoWithdrawalValue(cryptoAddress, currency), decimals);
    }

    /**
     * Request to withdraw using payment method
     *
     * @param amount:          amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId:      identifier of currency used in withdraw
     * @return result of withdraw as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1</a>
     **/
    public String withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, PAYMENT_METHOD, paymentMethodId, currencyId, null));
    }

    /** Request to withdraw using payment method
     * @param amount: amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1</a>
     * @return result of withdraw as {@link JSONObject}
     * **/
    public JSONObject withdrawFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId));
    }

    /** Request to withdraw using payment method
     * @param amount: amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1</a>
     * @return result of withdraw as {@link TransferAction} object
     * **/
    public TransferAction withdrawFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId) throws Exception {
        return new TransferAction(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId)));
    }

    /** Request to withdraw using payment method
     * @param amount: amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param profileId: identifier of profile used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1</a>
     * @return result of withdraw as {@link String}
     * **/
    public String withdrawFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                            String profileId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_PAYMENT_METHOD_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, PAYMENT_METHOD, paymentMethodId, currencyId, profileId));
    }

    /** Request to withdraw using payment method
     * @param amount: amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param profileId: identifier of profile used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1</a>
     * @return result of withdraw as {@link JSONObject}
     * **/
    public JSONObject withdrawFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId,
                                                    String profileId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId, profileId));
    }

    /** Request to withdraw using payment method
     * @param amount: amount to withdraw
     * @param paymentMethodId: identifier of payment method used in withdraw
     * @param currencyId: identifier of currency used in withdraw
     * @param profileId: identifier of profile used in withdraw
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postwithdrawpaymentmethod-1</a>
     * @return result of withdraw as {@link TransferAction} object
     * **/
    public TransferAction withdrawFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId,
                                                          String profileId) throws Exception {
        return new TransferAction(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId,
                currencyId, profileId)));
    }

}
