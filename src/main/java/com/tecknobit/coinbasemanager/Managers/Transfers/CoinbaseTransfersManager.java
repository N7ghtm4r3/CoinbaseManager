package com.tecknobit.coinbasemanager.Managers.Transfers;

import com.tecknobit.coinbasemanager.Managers.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.Transfers.Records.Deposit;
import org.json.JSONObject;

import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.POST_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.COINBASE_ACCOUNT_ENDPOINT;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.PAYMENT_METHOD_ENDPOINT;

public class CoinbaseTransfersManager extends CoinbaseManager {

    public static final String COINBASE_ACCOUNT_METHOD = "coinbase_account_id";
    public static final String PAYMENT_METHOD = "payment_method_id";

    /** Constructor to init a CoinbaseTransfers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseTransfers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseTransfers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseTransfers manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseTransfersManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(COINBASE_ACCOUNT_ENDPOINT, POST_METHOD,
                assembleDepositPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, null));
    }

    public JSONObject depositFromCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId));
    }

    public Deposit depositFromCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return assembleDepositObject(new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId)));
    }

    public String depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                             String profileId) throws Exception {
        return sendBodyParamsAPIRequest(COINBASE_ACCOUNT_ENDPOINT, POST_METHOD,
                assembleDepositPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, profileId));
    }

    public JSONObject depositFromCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId,
                                                     String profileId) throws Exception {
        return new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId, profileId));
    }

    public Deposit depositFromCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId,
                                                    String profileId) throws Exception {
        return assembleDepositObject(new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId,
                profileId)));
    }

    public String depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(PAYMENT_METHOD_ENDPOINT,POST_METHOD, assembleDepositPayload(amount,PAYMENT_METHOD,
                paymentMethodId, currencyId, null));
    }

    public JSONObject depositFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId));
    }

    public Deposit depositFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId) throws Exception {
        return assembleDepositObject(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId)));
    }

    public String depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                           String profileId) throws Exception {
        return sendBodyParamsAPIRequest(PAYMENT_METHOD_ENDPOINT,POST_METHOD, assembleDepositPayload(amount,PAYMENT_METHOD,
                paymentMethodId, currencyId, profileId));
    }

    public JSONObject depositFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId,
                                                   String profileId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId, profileId));
    }

    public Deposit depositFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId,
                                                  String profileId) throws Exception {
        return assembleDepositObject(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId,
                profileId)));
    }

    private HashMap<String, Object> assembleDepositPayload(double amount, String keyMethodId, String valueMethodId,
                                                           String currencyId, String profileId){
        HashMap<String, Object> depositBodyParams = new HashMap<>();
        depositBodyParams.put("amount",amount);
        depositBodyParams.put(keyMethodId,valueMethodId);
        depositBodyParams.put("currency",currencyId);
        if(profileId != null)
            depositBodyParams.put("profile_id",profileId);
        return depositBodyParams;
    }

    private Deposit assembleDepositObject(JSONObject jsonDeposit){
        return new Deposit(jsonDeposit.getString("id"),
                jsonDeposit.getDouble("amount"),
                jsonDeposit.getString("currency"),
                jsonDeposit.getString("payout_at"),
                jsonDeposit.getDouble("fee"),
                jsonDeposit.getDouble("subtotal")
        );
    }

}
