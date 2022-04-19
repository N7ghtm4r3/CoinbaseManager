package com.tecknobit.coinbasemanager.Managers.Account;

import com.tecknobit.coinbasemanager.Managers.Account.Records.Account;
import com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Hold;
import com.tecknobit.coinbasemanager.Managers.Account.Records.Details.Ledger;
import com.tecknobit.coinbasemanager.Managers.CoinbaseManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.ACCOUNT_ENDPOINT;

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

    public String getSingleAccountProfile(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId, GET_METHOD);
    }

    public JSONObject getJSONSingleAccountProfile(String accountId) throws Exception {
        return new JSONObject(getSingleAccountProfile(accountId));
    }

    public Account getObjectSingleAccountProfile(String accountId) throws Exception {
        return assembleAccountProfile(new JSONObject(getSingleAccountProfile(accountId)));
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

    public String getSingleAccountProfileHold(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/holds", GET_METHOD);
    }

    public JSONArray getJSONSingleAccountProfileHold(String accountId) throws Exception {
        return new JSONArray(getSingleAccountProfileHold(accountId));
    }

    public ArrayList<Hold> getSingleAccountProfileHoldList(String accountId) throws Exception {
        jsonArray = new JSONArray(getSingleAccountProfileHold(accountId));
        ArrayList<Hold> holds = new ArrayList<>();
        for (int j=0; j < jsonArray.length(); j++){
            JSONObject hold = jsonArray.getJSONObject(j);
            holds.add(new Hold(hold.getString("created_at"),
                    hold.getString("id"),
                    hold.getDouble("amount"),
                    hold.getString("type"),
                    hold.getString("ref")
            ));
        }
        return holds;
    }

    public String getSingleAccountLedger(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/ledger", GET_METHOD);
    }

    public JSONArray getJSONSingleAccountProfileLedger(String accountId) throws Exception {
        return new JSONArray(getSingleAccountLedger(accountId));
    }

    public ArrayList<Ledger> getSingleAccountProfileLedgerList(String accountId) throws Exception {
        jsonArray = new JSONArray(getSingleAccountLedger(accountId));
        ArrayList<Ledger> ledgers = new ArrayList<>();
        for (int j=0; j < jsonArray.length(); j++){
            JSONObject ledger = jsonArray.getJSONObject(j);
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

    public String getSingleAccountTransfers(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT +"/"+accountId+"/transfers", GET_METHOD);
    }

    public JSONArray getJSONSingleAccountProfileTransfers(String accountId) throws Exception {
        return new JSONArray(getSingleAccountLedger(accountId));
    }

    public ArrayList<Ledger> getSingleAccountProfileTransfersList(String accountId) throws Exception {
        jsonArray = new JSONArray(getSingleAccountTransfers(accountId));
        ArrayList<Ledger> ledgers = new ArrayList<>();
        for (int j=0; j < jsonArray.length(); j++){
            JSONObject ledger = jsonArray.getJSONObject(j);
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

}
