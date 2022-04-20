package com.tecknobit.coinbasemanager.Managers.Account;

import com.tecknobit.coinbasemanager.Managers.Account.Records.Account;
import com.tecknobit.coinbasemanager.Managers.Account.Records.CoinbaseAccount;
import com.tecknobit.coinbasemanager.Managers.Account.Records.CryptoAddress;
import com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Hold;
import com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Ledger;
import com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Transfer;
import com.tecknobit.coinbasemanager.Managers.CoinbaseManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.Manager.APIRequest.POST_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.ACCOUNT_ENDPOINT;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.COINBASE_ACCOUNT_ENDPOINT;

public class CoinbaseAccountManager extends CoinbaseManager {

    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String getAccountForProfile() throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT, GET_METHOD);
    }

    public JSONArray getJSONAccountForProfile() throws Exception {
        return new JSONArray(getAccountForProfile());
    }

    public ArrayList<Account> getAccountListForProfile() throws Exception {
        jsonArray = new JSONArray(getAccountForProfile());
        ArrayList<Account> accounts = new ArrayList<>();
        for (int j=0; j < jsonArray.length(); j++)
            accounts.add(assembleAccountProfile(jsonArray.getJSONObject(j)));
        return accounts;
    }

    public String getAccountProfile(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId, GET_METHOD);
    }

    public JSONObject getJSONAccountProfile(String accountId) throws Exception {
        return new JSONObject(getAccountProfile(accountId));
    }

    public Account getObjectAccountProfile(String accountId) throws Exception {
        return assembleAccountProfile(new JSONObject(getAccountProfile(accountId)));
    }

    private Account assembleAccountProfile(JSONObject account){
        return new Account(account.getString("id"),
                account.getString("currency"),
                account.getDouble("balance"),
                account.getDouble("available"),
                account.getDouble("hold"),
                account.getString("profile_id"),
                account.getBoolean("trading_enabled"));
    }

    public String getAccountProfileHold(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/holds", GET_METHOD);
    }

    public JSONArray getJSONAccountProfileHold(String accountId) throws Exception {
        return new JSONArray(getAccountProfileHold(accountId));
    }

    public ArrayList<Hold> getAccountProfileHoldList(String accountId) throws Exception {
        return assembleHoldsList(new JSONArray(getAccountProfileHold(accountId)));
    }

    public String getAccountProfileHold(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/holds"+assembleQueryParams(extraParams), GET_METHOD);
    }

    public JSONArray getJSONAccountProfileHold(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return new JSONArray(getAccountProfileHold(accountId, extraParams));
    }

    public ArrayList<Hold> getAccountProfileHoldList(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return assembleHoldsList(new JSONArray(getAccountProfileHold(accountId, extraParams)));
    }

    private ArrayList<Hold> assembleHoldsList(JSONArray jsonHolds){
        ArrayList<Hold> holds = new ArrayList<>();
        for (int j=0; j < jsonHolds.length(); j++){
            JSONObject hold = jsonHolds.getJSONObject(j);
            holds.add(new Hold(hold.getString("created_at"),
                    hold.getString("id"),
                    hold.getDouble("amount"),
                    hold.getString("type"),
                    hold.getString("ref")
            ));
        }
        return holds;
    }

    public String getAccountLedger(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/ledger", GET_METHOD);
    }

    public JSONArray getJSONAccountProfileLedger(String accountId) throws Exception {
        return new JSONArray(getAccountLedger(accountId));
    }

    public ArrayList<Ledger> getAccountProfileLedgerList(String accountId) throws Exception {
        return assembleLedgersList(new JSONArray(getAccountLedger(accountId)));
    }

    public String getAccountLedger(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/ledger"+assembleQueryParams(extraParams), GET_METHOD);
    }

    public JSONArray getJSONAccountProfileLedger(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return new JSONArray(getAccountLedger(accountId, extraParams));
    }

    public ArrayList<Ledger> getAccountProfileLedgerList(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return assembleLedgersList(new JSONArray(getAccountLedger(accountId, extraParams)));
    }

    private ArrayList<Ledger> assembleLedgersList(JSONArray jsonLedgers){
        ArrayList<Ledger> ledgers = new ArrayList<>();
        for (int j=0; j < jsonLedgers.length(); j++){
            JSONObject ledger = jsonLedgers.getJSONObject(j);
            ledgers.add(new Ledger(ledger.getString("created_at"),
                    ledger.getString("id"),
                    ledger.getDouble("amount"),
                    ledger.getString("type"),
                    ledger.getDouble("balance"),
                    ledger
            ));
        }
        return ledgers;
    }

    public String getAccountTransfers(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/transfers", GET_METHOD);
    }

    public JSONArray getJSONAccountProfileTransfers(String accountId) throws Exception {
        return new JSONArray(getAccountLedger(accountId));
    }

    public ArrayList<Transfer> getAccountProfileTransfersList(String accountId) throws Exception {
        return assembleTransfersList(new JSONArray(getAccountTransfers(accountId)));
    }

    public String getAccountTransfers(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/transfers"+assembleQueryParams(extraParams), GET_METHOD);
    }

    public JSONArray getJSONAccountProfileTransfers(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return new JSONArray(getAccountLedger(accountId, extraParams));
    }

    public ArrayList<Transfer> getAccountProfileTransfersList(String accountId, HashMap<String, Object> extraParams) throws Exception {
        return assembleTransfersList(new JSONArray(getAccountTransfers(accountId, extraParams)));
    }

    private ArrayList<Transfer> assembleTransfersList(JSONArray jsonTransfers){
        ArrayList<Transfer> transfers = new ArrayList<>();
        for (int j=0; j < jsonTransfers.length(); j++){
            JSONObject transfer = jsonTransfers.getJSONObject(j);
            transfers.add(new Transfer(transfer.getString("created_at"),
                    transfer.getString("id"),
                    transfer.getDouble("amount"),
                    transfer.getString("type"),
                    transfer.getString("completed_at"),
                    transfer
            ));
        }
        return transfers;
    }

    public String getCoinbaseWallets() throws Exception {
        return sendAPIRequest(COINBASE_ACCOUNT_ENDPOINT,GET_METHOD);
    }

    public JSONArray getJSONCoinbaseWallets() throws Exception {
        return new JSONArray(getCoinbaseWallets());
    }

    public ArrayList<CoinbaseAccount> getCoinbaseWalletsList() throws Exception {
        jsonArray = new JSONArray(getJSONCoinbaseWallets());
        ArrayList<CoinbaseAccount> coinbaseAccounts = new ArrayList<>();
        for (int j=0; j < jsonArray.length(); j++){
            JSONObject coinbaseAccount = jsonArray.getJSONObject(j);
            try {
                jsonObject = coinbaseAccount.getJSONObject("sepa_deposit_information");
            }catch (JSONException e){
                jsonObject = null;
            }
            coinbaseAccounts.add(new CoinbaseAccount(coinbaseAccount.getDouble("balance"),
                    coinbaseAccount.getBoolean("available_on_consumer"),
                    coinbaseAccount.getString("name"),
                    coinbaseAccount.getBoolean("active"),
                    coinbaseAccount.getString("currency"),
                    coinbaseAccount.getString("id"),
                    coinbaseAccount.getString("type"),
                    coinbaseAccount.getBoolean("primary"),
                    coinbaseAccount.getDouble("hold_balance"),
                    coinbaseAccount.getString("hold_currency"),
                    jsonObject
            ));
        }
        return coinbaseAccounts;
    }

    public String generateCryptoAddress(String accountId) throws Exception {
        return sendAPIRequest(COINBASE_ACCOUNT_ENDPOINT+"/"+ accountId +"/addresses",POST_METHOD);
    }

    public JSONObject generateJSONCryptoAddress(String accountId) throws Exception {
        return new JSONObject(generateCryptoAddress(accountId));
    }

    public CryptoAddress generateObjectCryptoAddress(String accountId) throws Exception {
        jsonObject = new JSONObject(generateCryptoAddress(accountId));
        return new CryptoAddress(jsonObject.getString("id"),
                jsonObject.getString("address"),
                jsonObject.getJSONObject("address_info"),
                jsonObject.getString("name"),
                jsonObject.getString("created_at"),
                jsonObject.getString("updated_at"),
                jsonObject.getString("network"),
                jsonObject.getString("uri_scheme"),
                jsonObject.getString("resource"),
                jsonObject.getString("resource_path"),
                jsonObject.getString("deposit_uri"),
                jsonObject.getBoolean("exchange_deposit_address"),
                jsonObject.getJSONArray("warnings")
        );
    }

}
