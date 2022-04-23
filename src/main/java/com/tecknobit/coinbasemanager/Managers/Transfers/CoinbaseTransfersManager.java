package com.tecknobit.coinbasemanager.Managers.Transfers;

import com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Transfer;
import com.tecknobit.coinbasemanager.Managers.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.Transfers.Records.TransferAction;
import com.tecknobit.coinbasemanager.Managers.Transfers.Records.PaymentMethods.PaymentMethod;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.Manager.APIRequest.POST_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.*;
import static com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Transfer.assembleTransferObject;
import static com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Transfer.assembleTransfersList;

public class CoinbaseTransfersManager extends CoinbaseManager {

    public static final String COINBASE_ACCOUNT_METHOD = "coinbase_account_id";
    public static final String PAYMENT_METHOD = "payment_method_id";
    public static final String CRYPTO_ADDRESS_METHOD = "crypto_address";

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
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_COINBASE_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, null));
    }

    public JSONObject depositFromCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId));
    }

    public TransferAction depositFromCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return assembleTransferActionObject(new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId)));
    }

    public String depositFromCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                             String profileId) throws Exception {
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_COINBASE_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, profileId));
    }

    public JSONObject depositFromCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId,
                                                     String profileId) throws Exception {
        return new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId, profileId));
    }

    public TransferAction depositFromCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId,
                                                           String profileId) throws Exception {
        return assembleTransferActionObject(new JSONObject(depositFromCoinbaseAccount(amount, coinbaseAccountId, currencyId,
                profileId)));
    }

    public String depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT,POST_METHOD,
                assembleTransferActionPayload(amount,PAYMENT_METHOD, paymentMethodId, currencyId, null));
    }

    public JSONObject depositFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId));
    }

    public TransferAction depositFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId) throws Exception {
        return assembleTransferActionObject(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId)));
    }

    public String depositFromPaymentMethod(double amount, String paymentMethodId, String currencyId,
                                           String profileId) throws Exception {
        return sendBodyParamsAPIRequest(DEPOSIT_FROM_PAYMENT_METHOD_ENDPOINT,POST_METHOD,
                assembleTransferActionPayload(amount,PAYMENT_METHOD, paymentMethodId, currencyId, profileId));
    }

    public JSONObject depositFromPaymentMethodJSON(double amount, String paymentMethodId, String currencyId,
                                                   String profileId) throws Exception {
        return new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId, profileId));
    }

    public TransferAction depositFromPaymentMethodObject(double amount, String paymentMethodId, String currencyId,
                                                         String profileId) throws Exception {
        return assembleTransferActionObject(new JSONObject(depositFromPaymentMethod(amount, paymentMethodId, currencyId,
                profileId)));
    }

    public String getAllPaymentMethods() throws Exception {
        return sendAPIRequest(PAYMENTS_METHOD_ENDPOINT, GET_METHOD);
    }

    public JSONArray getJSONAllPaymentMethods() throws Exception {
        return new JSONArray(getAllPaymentMethods());
    }

    public ArrayList<PaymentMethod> getAllPaymentMethodsList() throws Exception {
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();
        jsonArray = new JSONArray(getAllPaymentMethods());
        for (int j=0; j < jsonArray.length(); j++){
            JSONObject paymentMethod = jsonArray.getJSONObject(j);
            paymentMethods.add(new PaymentMethod(paymentMethod.getString("id"),
                    paymentMethod.getString("type"),
                    paymentMethod.getString("name"),
                    paymentMethod.getString("currency"),
                    paymentMethod.getBoolean("primary_buy"),
                    paymentMethod.getBoolean("primary_sell"),
                    paymentMethod.getBoolean("instant_buy"),
                    paymentMethod.getBoolean("instant_sell"),
                    paymentMethod.getString("created_at"),
                    paymentMethod.getString("updated_at"),
                    paymentMethod.getString("resource"),
                    paymentMethod.getString("resource_path"),
                    paymentMethod.getBoolean("allow_buy"),
                    paymentMethod.getBoolean("allow_sell"),
                    paymentMethod.getBoolean("allow_deposit"),
                    paymentMethod.getBoolean("allow_withdraw"),
                    paymentMethod.getBoolean("verified"),
                    paymentMethod
            ));
        }
        return paymentMethods;
    }

    public String getAllTransfers() throws Exception {
        return sendAPIRequest(TRANSFERS_ENDPOINT, GET_METHOD);
    }

    public JSONArray getAllTransfersJSON() throws Exception {
        return new JSONArray(getAllTransfers());
    }

    public ArrayList<Transfer> getAllTransfersList() throws Exception {
        return assembleTransfersList(new JSONArray(getAllTransfers()));
    }

    public String getAllTransfers(HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(TRANSFERS_ENDPOINT+assembleQueryParams(queryParams), GET_METHOD);
    }

    public JSONArray getAllTransfersJSON(HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllTransfers(queryParams));
    }

    public ArrayList<Transfer> getAllTransfersList(HashMap<String, Object> queryParams) throws Exception {
        return assembleTransfersList(new JSONArray(getAllTransfers(queryParams)));
    }

    public String getSingleTransfer(String transferId) throws Exception {
        return sendAPIRequest(TRANSFERS_ENDPOINT+"/"+transferId, GET_METHOD);
    }

    public JSONObject getSingleTransferJSON(String transferId) throws Exception {
        return new JSONObject(getSingleTransfer(transferId));
    }

    public Transfer getSingleTransferObject(String transferId) throws Exception {
        return assembleTransferObject(new JSONObject(getSingleTransfer(transferId)));
    }

    public String withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_COINBASE_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, null));
    }

    public JSONObject withdrawToCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId));
    }

    public TransferAction withdrawToCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId) throws Exception {
        return assembleTransferActionObject(new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId)));
    }

    public String withdrawToCoinbaseAccount(double amount, String coinbaseAccountId, String currencyId,
                                            String profileId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_COINBASE_ENDPOINT, POST_METHOD, assembleTransferActionPayload(amount,
                COINBASE_ACCOUNT_METHOD, coinbaseAccountId, currencyId, profileId));
    }

    public JSONObject withdrawToCoinbaseAccountJSON(double amount, String coinbaseAccountId, String currencyId,
                                                    String profileId) throws Exception {
        return new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId, currencyId, profileId));
    }

    public TransferAction withdrawToCoinbaseAccountObject(double amount, String coinbaseAccountId, String currencyId,
                                                          String profileId) throws Exception {
        return assembleTransferActionObject(new JSONObject(withdrawToCoinbaseAccount(amount, coinbaseAccountId,
                currencyId, profileId)));
    }

    private HashMap<String, Object> assembleTransferActionPayload(double amount, String keyMethodId, String valueMethodId,
                                                                  String currencyId, String profileId){
        HashMap<String, Object> depositBodyParams = new HashMap<>();
        depositBodyParams.put("amount",amount);
        depositBodyParams.put(keyMethodId,valueMethodId);
        depositBodyParams.put("currency",currencyId);
        if(profileId != null)
            depositBodyParams.put("profile_id",profileId);
        return depositBodyParams;
    }

    private TransferAction assembleTransferActionObject(JSONObject jsonDeposit){
        return new TransferAction(jsonDeposit.getString("id"),
                jsonDeposit.getDouble("amount"),
                jsonDeposit.getString("currency"),
                jsonDeposit.getString("payout_at"),
                jsonDeposit.getDouble("fee"),
                jsonDeposit.getDouble("subtotal")
        );
    }

    public String withdrawToCrypto(double amount, String cryptoAddress, String currencyId) throws Exception {
        return sendBodyParamsAPIRequest(WITHDRAW_TO_CRYPTO_ENDPOINT, POST_METHOD,
                assembleTransferActionPayload(amount, CRYPTO_ADDRESS_METHOD, cryptoAddress, currencyId, null));
    }

    public JSONObject withdrawToCryptoJSON(double amount, String cryptoAddress, String currencyId) throws Exception {
        return new JSONObject(withdrawToCoinbaseAccount(amount, cryptoAddress, currencyId));
    }

    public TransferAction withdrawToCryptoObject(double amount, String cryptoAddress, String currencyId) throws Exception {
        return assembleTransferActionObject(new JSONObject(withdrawToCoinbaseAccount(amount, cryptoAddress, currencyId)));
    }

    public String withdrawToCrypto(double amount, String cryptoAddress, String currencyId,
                                   HashMap<String, Object> extraParams) throws Exception {
        HashMap<String, Object> mandatoryBodyParams = assembleTransferActionPayload(amount, CRYPTO_ADDRESS_METHOD,
                cryptoAddress, currencyId, null);
        mandatoryBodyParams.putAll(extraParams);
        return sendBodyParamsAPIRequest(WITHDRAW_TO_CRYPTO_ENDPOINT, POST_METHOD, mandatoryBodyParams);
    }

    public JSONObject withdrawToCryptoJSON(double amount, String cryptoAddress, String currencyId,
                                           HashMap<String, Object> extraParams) throws Exception {
        return new JSONObject(withdrawToCrypto(amount, cryptoAddress, currencyId, extraParams));
    }

    public TransferAction withdrawToCryptoObject(double amount, String cryptoAddress, String currencyId,
                                                 HashMap<String, Object> extraParams) throws Exception {
        return assembleTransferActionObject(new JSONObject(withdrawToCrypto(amount, cryptoAddress, currencyId, extraParams)));
    }

}
