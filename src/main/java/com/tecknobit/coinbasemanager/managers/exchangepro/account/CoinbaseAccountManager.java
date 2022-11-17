package com.tecknobit.coinbasemanager.managers.exchangepro.account;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.Account;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.CoinbaseAccount;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.CryptoAddress;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Hold;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Ledger;
import com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Transfer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.GET_METHOD;
import static com.tecknobit.apimanager.apis.APIRequest.POST_METHOD;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.ACCOUNT_ENDPOINT;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.COINBASE_ACCOUNT_ENDPOINT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.account.records.details.Transfer.assembleTransfersList;

/**
 * The {@code CoinbaseAccountManager} class is useful to manage all {@code "Coinbase"} account endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1">
 * Account manager</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1">
 * Account manager</a>
 * </li>
 * </ul>
 * @see CoinbaseManager
 **/
public class CoinbaseAccountManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseAccountManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a {@link CoinbaseAccountManager}
     * @param apiKey: your {@code "Coinbase"} api key
     * @param apiSecret: your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseAccountManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseAccountManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseAccountManager} <br>
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
    public CoinbaseAccountManager() {
        super();
    }

    /**
     * Request to get all account for a profile
     * any params required
     *
     * @return all account for a profile as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1</a>
     **/
    public String getAccountForProfile() throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT, GET_METHOD);
    }

    /** Request to get all account for a profile
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1</a>
     * @return all account for a profile as {@link JSONArray}
     * **/
    public JSONArray getJSONAccountForProfile() throws Exception {
        return new JSONArray(getAccountForProfile());
    }

    /** Request to get all account for a profile
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts-1</a>
     * @return all account for a profile as list {@link ArrayList} of {@link Account}
     * **/
    public ArrayList<Account> getAccountListForProfile() throws Exception {
        JSONArray jsonAccounts = new JSONArray(getAccountForProfile());
        ArrayList<Account> accounts = new ArrayList<>();
        for (int j = 0; j < jsonAccounts.length(); j++)
            accounts.add(new Account(jsonAccounts.getJSONObject(j)));
        return accounts;
    }

    /** Request to get one account from a profile
     * @param accountId: account id to fetch from profile
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount-1</a>
     * @return one account from a profile as {@link String}
     * **/
    public String getAccountProfile(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT + "/" + accountId, GET_METHOD);
    }

    /** Request to get one account from a profile
     * @param accountId: account id to fetch from profile
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount-1</a>
     * @return one account from a profile as {@link JSONObject}
     * **/
    public JSONObject getJSONAccountProfile(String accountId) throws Exception {
        return new JSONObject(getAccountProfile(accountId));
    }

    /** Request to get one account from a profile
     * @param accountId: account id to fetch from profile
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount-1</a>
     * @return one account from a profile as {@link Account} object
     * **/
    public Account getObjectAccountProfile(String accountId) throws Exception {
        return new Account(new JSONObject(getAccountProfile(accountId)));
    }

    /** Request to get hold information from one profile
     * @param accountId: account id to fetch hold information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1</a>
     * @return hold information from one profile as {@link String}
     * **/
    public String getAccountProfileHold(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/holds", GET_METHOD);
    }

    /** Request to get hold information from one profile
     * @param accountId: account id to fetch hold information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1</a>
     * @return hold information from one profile as {@link JSONArray}
     * **/
    public JSONArray getJSONAccountProfileHold(String accountId) throws Exception {
        return new JSONArray(getAccountProfileHold(accountId));
    }

    /** Request to get hold information from one profile
     * @param accountId: account id to fetch hold information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1</a>
     * @return hold information from one profile as list {@link ArrayList} of {@link Hold}
     * **/
    public ArrayList<Hold> getAccountProfileHoldList(String accountId) throws Exception {
        return assembleHoldsList(new JSONArray(getAccountProfileHold(accountId)));
    }

    /** Request to get hold information from one profile
     * @param accountId: account id to fetch hold information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1</a>
     * @return hold information from one profile as {@link String}
     * **/
    public String getAccountProfileHold(String accountId, Params queryParams) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/holds" + assembleQueryParams("?",
                queryParams), GET_METHOD);
    }

    /** Request to get hold information from one profile
     * @param accountId: account id to fetch hold information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1</a>
     * @return hold information from one profile as {@link JSONArray}
     * **/
    public JSONArray getJSONAccountProfileHold(String accountId, Params queryParams) throws Exception {
        return new JSONArray(getAccountProfileHold(accountId, queryParams));
    }

    /** Request to get hold information from one profile
     * @param accountId: account id to fetch hold information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds-1</a>
     * @return hold information from one profile as list {@link ArrayList} of {@link Hold}
     * **/
    public ArrayList<Hold> getAccountProfileHoldList(String accountId, Params queryParams) throws Exception {
        return assembleHoldsList(new JSONArray(getAccountProfileHold(accountId, queryParams)));
    }

    /** Method to assemble a holds list
     * @param jsonHolds: jsonObject obtained by response request
     * @return holds list as {@link ArrayList} of {@link Hold}
     * **/
    private ArrayList<Hold> assembleHoldsList(JSONArray jsonHolds){
        ArrayList<Hold> holds = new ArrayList<>();
        for (int j=0; j < jsonHolds.length(); j++)
            holds.add(new Hold(jsonHolds.getJSONObject(j)));
        return holds;
    }

    /** Request to get ledger information from one profile
     * @param accountId: account id to fetch ledger information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1</a>
     * @return ledger information from one profile as {@link String}
     * **/
    public String getAccountLedger(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/ledger", GET_METHOD);
    }

    /** Request to get ledger information from one profile
     * @param accountId: account id to fetch ledger information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1</a>
     * @return ledger information from one profile as {@link JSONArray}
     * **/
    public JSONArray getJSONAccountProfileLedger(String accountId) throws Exception {
        return new JSONArray(getAccountLedger(accountId));
    }

    /** Request to get ledger information from one profile
     * @param accountId: account id to fetch ledger information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1</a>
     * @return ledger information from one profile as list {@link ArrayList} of {@link Ledger}
     * **/
    public ArrayList<Ledger> getAccountProfileLedgerList(String accountId) throws Exception {
        return assembleLedgersList(new JSONArray(getAccountLedger(accountId)));
    }

    /** Request to get ledger information from one profile
     * @param accountId: account id to fetch ledger information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are start_date, end_date, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1</a>
     * @return ledger information from one profile as {@link String}
     * **/
    public String getAccountLedger(String accountId, Params queryParams) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/ledger" + assembleQueryParams("?",
                queryParams), GET_METHOD);
    }

    /** Request to get ledger information from one profile
     * @param accountId: account id to fetch ledger information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are start_date, end_date, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1</a>
     * @return ledger information from one profile as {@link JSONArray}
     * **/
    public JSONArray getJSONAccountProfileLedger(String accountId, Params queryParams) throws Exception {
        return new JSONArray(getAccountLedger(accountId, queryParams));
    }

    /** Request to get ledger information from one profile
     * @param accountId: account id to fetch ledger information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are start_date, end_date, profile_id, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger-1</a>
     * @return ledger information from one profile as list {@link ArrayList} of {@link Ledger}
     * **/
    public ArrayList<Ledger> getAccountProfileLedgerList(String accountId, Params queryParams) throws Exception {
        return assembleLedgersList(new JSONArray(getAccountLedger(accountId, queryParams)));
    }

    /** Method to assemble a ledger list
     * @param jsonLedgers: jsonObject obtained by response request
     * @return ledger list as {@link ArrayList} of {@link Ledger}
     * **/
    private ArrayList<Ledger> assembleLedgersList(JSONArray jsonLedgers){
        ArrayList<Ledger> ledgers = new ArrayList<>();
        for (int j=0; j < jsonLedgers.length(); j++)
            ledgers.add(new Ledger(jsonLedgers.getJSONObject(j)));
        return ledgers;
    }

    /** Request to get transfer information from one profile
     * @param accountId: account id to fetch transfer information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1</a>
     * @return transfer information from one profile as {@link String}
     * **/
    public String getAccountTransfers(String accountId) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/transfers", GET_METHOD);
    }

    /** Request to get transfer information from one profile
     * @param accountId: account id to fetch transfer information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1</a>
     * @return transfer information from one profile as {@link JSONArray}
     * **/
    public JSONArray getJSONAccountProfileTransfers(String accountId) throws Exception {
        return new JSONArray(getAccountLedger(accountId));
    }

    /** Request to get transfer information from one profile
     * @param accountId: account id to fetch transfer information
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1</a>
     * @return transfer information from one profile as list {@link ArrayList} of {@link Transfer}
     * **/
    public ArrayList<Transfer> getAccountProfileTransfersList(String accountId) throws Exception {
        return assembleTransfersList(new JSONArray(getAccountTransfers(accountId)));
    }

    /** Request to get transfer information from one profile
     * @param accountId: account id to fetch transfer information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are type, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1</a>
     * @return transfer information from one profile as {@link String}
     * **/
    public String getAccountTransfers(String accountId, Params queryParams) throws Exception {
        return sendAPIRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/transfers" + assembleQueryParams("?",
                queryParams), GET_METHOD);
    }

    /** Request to get transfer information from one profile
     * @param accountId: account id to fetch transfer information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are type, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1</a>
     * @return transfer information from one profile as {@link JSONArray}
     * **/
    public JSONArray getJSONAccountProfileTransfers(String accountId, Params queryParams) throws Exception {
        return new JSONArray(getAccountLedger(accountId, queryParams));
    }

    /** Request to get transfer information from one profile
     * @param accountId: account id to fetch transfer information
     * @param queryParams: queryParams of request
     * @implSpec (keys accepted are type, before, after, limit)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers-1</a>
     * @return transfer information from one profile as list {@link ArrayList} of {@link Transfer}
     * **/
    public ArrayList<Transfer> getAccountProfileTransfersList(String accountId, Params queryParams) throws Exception {
        return assembleTransfersList(new JSONArray(getAccountTransfers(accountId, queryParams)));
    }

    /** Request to get all {@code "Coinbase"}'s users wallets available
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1</a>
     * @return all {@code "Coinbase"}'s users wallets available as {@link String}
     * **/
    public String getCoinbaseWallets() throws Exception {
        return sendAPIRequest(COINBASE_ACCOUNT_ENDPOINT, GET_METHOD);
    }

    /** Request to get all {@code "Coinbase"}'s users wallets available
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1</a>
     * @return all {@code "Coinbase"}'s users wallets available as {@link JSONArray}
     * **/
    public JSONArray getJSONCoinbaseWallets() throws Exception {
        return new JSONArray(getCoinbaseWallets());
    }

    /** Request to get all {@code "Coinbase"}'s users wallets available
     * any params required
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts-1</a>
     * @return all {@code "Coinbase"}'s users wallets available as list {@link ArrayList} of {@link CoinbaseAccount}
     * **/
    public ArrayList<CoinbaseAccount> getCoinbaseWalletsList() throws Exception {
        JSONArray jsonCoinbaseAccounts = new JSONArray(getJSONCoinbaseWallets());
        ArrayList<CoinbaseAccount> coinbaseAccounts = new ArrayList<>();
        for (int j = 0; j < jsonCoinbaseAccounts.length(); j++)
            coinbaseAccounts.add(new CoinbaseAccount(jsonCoinbaseAccounts.getJSONObject(j)));
        return coinbaseAccounts;
    }

    /** Request to generate one time crypto address for a deposit
     * @param accountId: account id used to create crypto address
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses-1</a>
     * @return response of generation one time crypto address for a deposit as {@link String}
     * **/
    public String generateCryptoAddress(String accountId) throws Exception {
        return sendAPIRequest(COINBASE_ACCOUNT_ENDPOINT + "/" + accountId + "/addresses", POST_METHOD);
    }

    /** Request to generate one time crypto address for a deposit
     * @param accountId: account id used to create crypto address
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses-1</a>
     * @return response of generation one time crypto address for a deposit as {@link JSONObject}
     * **/
    public JSONObject generateJSONCryptoAddress(String accountId) throws Exception {
        return new JSONObject(generateCryptoAddress(accountId));
    }

    /** Request to generate one time crypto address for a deposit
     * @param accountId: account id used to create crypto address
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses-1</a>
     * @return response of generation one time crypto address for a deposit as {@link CryptoAddress} object
     * **/
    public CryptoAddress generateObjectCryptoAddress(String accountId) throws Exception {
        return new CryptoAddress(new JSONObject(generateCryptoAddress(accountId)));
    }

}
