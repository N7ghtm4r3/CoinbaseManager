package com.tecknobit.coinbasemanager.exchangepro.account;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.apimanager.interfaces.Manager;
import com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.exchangepro.account.records.Account;
import com.tecknobit.coinbasemanager.exchangepro.account.records.CoinbaseAccount;
import com.tecknobit.coinbasemanager.exchangepro.account.records.CryptoAddress;
import com.tecknobit.coinbasemanager.exchangepro.account.records.details.Hold;
import com.tecknobit.coinbasemanager.exchangepro.account.records.details.Ledger;
import com.tecknobit.coinbasemanager.exchangepro.account.records.details.Transfer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.coinbasemanager.exchangepro.account.records.details.Transfer.returnTransfersList;

/**
 * The {@code CoinbaseAccountManager} class is useful to manage all {@code "Coinbase"} account endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts">
 * Account manager</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">
 * Account manager</a>
 * </li>
 * </ul>
 * @see CoinbaseManager
 * @see Manager
 */
public class CoinbaseAccountManager extends CoinbaseManager {

    /**
     * {@code ACCOUNT_ENDPOINT} is constant for ACCOUNT_ENDPOINT's endpoint
     */
    public static final String ACCOUNT_ENDPOINT = "/accounts";

    /**
     * {@code COINBASE_ACCOUNT_ENDPOINT} is constant for COINBASE_ACCOUNT_ENDPOINT's endpoint
     */
    public static final String COINBASE_ACCOUNT_ENDPOINT = "/coinbase-accounts";

    /**
     * Constructor to init a {@link CoinbaseAccountManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     */
    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseAccountManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     */
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
     */
    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseAccountManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     */
    public CoinbaseAccountManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseAccountManager} <br>
     * No-any params required
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
     */
    public CoinbaseAccountManager() {
        super();
    }

    /**
     * Request to get all account for a profile <br>
     * No-any params required
     *
     * @return all accounts for a profile as list {@link ArrayList} of {@link Account}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts">
     * Get all accounts for a profile</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts")
    public ArrayList<Account> getAccountsForProfile() throws Exception {
        return getAccountsForProfile(ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get all account for a profile
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all accounts for a profile as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounts">
     * Get all accounts for a profile</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts")
    public <T> T getAccountsForProfile(ReturnFormat format) throws Exception {
        String accountsResponse = sendGETRequest(ACCOUNT_ENDPOINT);
        switch (format) {
            case JSON:
                return (T) new JSONArray(accountsResponse);
            case LIBRARY_OBJECT:
                JSONArray jAccounts = new JSONArray(accountsResponse);
                ArrayList<Account> accounts = new ArrayList<>();
                for (int j = 0; j < jAccounts.length(); j++)
                    accounts.add(new Account(jAccounts.getJSONObject(j)));
                return (T) accounts;
            default:
                return (T) accountsResponse;
        }
    }

    /**
     * Request to get one account from a profile
     *
     * @param accountId: account id to fetch from profile
     * @return one account from a profile as {@link Account} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount">
     * Get a single account by id</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/{account_id}")
    public Account getAccountProfile(String accountId) throws Exception {
        return getAccountProfile(accountId, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get one account from a profile
     *
     * @param accountId: account id to fetch from profile
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return one account from a profile as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccount">
     * Get a single account by id</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/{account_id}")
    public <T> T getAccountProfile(String accountId, ReturnFormat format) throws Exception {
        String accountResponse = sendGETRequest(ACCOUNT_ENDPOINT + "/" + accountId);
        switch (format) {
            case JSON:
                return (T) new JSONObject(accountResponse);
            case LIBRARY_OBJECT:
                return (T) new Account(new JSONObject(accountResponse));
            default:
                return (T) accountResponse;
        }
    }

    /**
     * Request to get hold information from one profile
     *
     * @param accountId: account id to fetch hold information
     * @return hold information from one profile as list {@link ArrayList} of {@link Hold}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds">
     * Get a single account's holds</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/{account_id}/holds")
    public ArrayList<Hold> getAccountProfileHolds(String accountId) throws Exception {
        return getAccountProfileHolds(accountId, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get hold information from one profile
     *
     * @param accountId: account id to fetch hold information
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return hold information from one profile as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds">
     * Get a single account's holds</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/{account_id}/holds")
    public <T> T getAccountProfileHolds(String accountId, ReturnFormat format) throws Exception {
        return returnHoldsList(sendGETRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/holds"),
                format);
    }

    /**
     * Request to get hold information from one profile
     *
     * @param accountId:   account id to fetch hold information
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                     </ul>
     * @return hold information from one profile as list {@link ArrayList} of {@link Hold}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds">
     * Get a single account's holds</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/{account_id}/holds")
    public ArrayList<Hold> getAccountProfileHolds(String accountId, Params queryParams) throws Exception {
        return getAccountProfileHolds(accountId, queryParams, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get hold information from one profile
     *
     * @param accountId:   account id to fetch hold information
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "before"} -> used for pagination. Sets start cursor to before date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                     </ul>
     * @return hold information from one profile as list {@link ArrayList} of {@link Hold}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountholds">
     * Get a single account's holds</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/{account_id}/holds")
    public <T> T getAccountProfileHolds(String accountId, Params queryParams, ReturnFormat format) throws Exception {
        return returnHoldsList(sendGETRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/holds" +
                queryParams.createQueryString()), format);
    }

    /**
     * Method to assemble an holds list
     *
     * @param holdsListResponse: holds list response to format
     * @param format:            return type formatter -> {@link ReturnFormat}
     * @return holds list response as {@code "format"} defines
     */
    @Returner
    private <T> T returnHoldsList(String holdsListResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(holdsListResponse);
            case LIBRARY_OBJECT:
                ArrayList<Hold> holds = new ArrayList<>();
                JSONArray jHolds = new JSONArray(holdsListResponse);
                for (int j = 0; j < jHolds.length(); j++)
                    holds.add(new Hold(jHolds.getJSONObject(j)));
                return (T) holds;
            default:
                return (T) holdsListResponse;
        }
    }

    /**
     * Request to get ledger information from one profile
     *
     * @param accountId: account id to fetch ledger information
     * @return ledger information from one profile as list {@link ArrayList} of {@link Ledger}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger">
     * Get a single account's ledger</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/ledger")
    public ArrayList<Ledger> getAccountProfileLedgers(String accountId) throws Exception {
        return getAccountProfileLedgers(accountId, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get ledger information from one profile
     *
     * @param accountId: account id to fetch ledger information
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return ledger information from one profile as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger">
     * Get a single account's ledger</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/ledger")
    public <T> T getAccountProfileLedgers(String accountId, ReturnFormat format) throws Exception {
        return returnLedgersList(sendGETRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/ledger"),
                format);
    }

    /**
     * Request to get ledger information from one profile
     *
     * @param accountId:   account id to fetch ledger information
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
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
     *                     </ul>
     * @return ledger information from one profile as list {@link ArrayList} of {@link Ledger}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger">
     * Get a single account's ledger</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/ledger")
    public ArrayList<Ledger> getAccountProfileLedgers(String accountId, Params queryParams) throws Exception {
        return getAccountProfileLedgers(accountId, queryParams, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get ledger information from one profile
     *
     * @param accountId:   account id to fetch ledger information
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> filter results by minimum posted date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> filter results by maximum posted date - [string]
     *                          </li>
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
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return ledger information from one profile as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccountledger">
     * Get a single account's ledger</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/ledger")
    public <T> T getAccountProfileLedgers(String accountId, Params queryParams, ReturnFormat format) throws Exception {
        return returnLedgersList(sendGETRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/ledger" +
                queryParams.createQueryString()), format);
    }

    /**
     * Method to assemble an ledgers list
     *
     * @param holdsLedgersResponse: ledgers list response to format
     * @param format:               return type formatter -> {@link ReturnFormat}
     * @return ledgers list response as {@code "format"} defines
     */
    @Returner
    private <T> T returnLedgersList(String holdsLedgersResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(holdsLedgersResponse);
            case LIBRARY_OBJECT:
                ArrayList<Ledger> ledgers = new ArrayList<>();
                JSONArray jLedgers = new JSONArray(holdsLedgersResponse);
                for (int j = 0; j < jLedgers.length(); j++)
                    ledgers.add(new Ledger(jLedgers.getJSONObject(j)));
                return (T) ledgers;
            default:
                return (T) holdsLedgersResponse;
        }
    }

    /**
     * Request to get transfer information from one profile
     *
     * @param accountId: account id to fetch transfer information
     * @return transfer information from one profile as list {@link ArrayList} of {@link Transfer}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers">
     * Get a single account's transfers</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/transfers")
    public ArrayList<Transfer> getAccountProfileTransfers(String accountId) throws Exception {
        return getAccountProfileTransfers(accountId, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get transfer information from one profile
     *
     * @param accountId: account id to fetch transfer information
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return transfer information from one profile as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers">
     * Get a single account's transfers</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/transfers")
    public <T> T getAccountProfileTransfers(String accountId, ReturnFormat format) throws Exception {
        return returnTransfersList(sendGETRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/transfers"),
                format);
    }

    /**
     * Request to get transfer information from one profile
     *
     * @param accountId:   account id to fetch transfer information
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "type"} -> type - [string]
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
     *                     </ul>
     * @return transfer information from one profile as list {@link ArrayList} of {@link Transfer}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers">
     * Get a single account's transfers</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/transfers")
    public ArrayList<Transfer> getAccountProfileTransfers(String accountId, Params queryParams) throws Exception {
        return getAccountProfileTransfers(accountId, queryParams, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get transfer information from one profile
     *
     * @param accountId:   account id to fetch transfer information
     * @param queryParams: extra query params, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "type"} -> type - [string]
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
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return transfer information from one profile as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaccounttransfers">
     * Get a single account's transfers</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/accounts/account_id/transfers")
    public <T> T getAccountProfileTransfers(String accountId, Params queryParams, ReturnFormat format) throws Exception {
        return returnTransfersList(sendGETRequest(ACCOUNT_ENDPOINT + "/" + accountId + "/transfers" +
                queryParams.createQueryString()), format);
    }

    /**
     * Request to get all {@code "Coinbase"}'s users wallets available
     * No-any params required
     *
     * @return all {@code "Coinbase"}'s users wallets available as list {@link ArrayList} of {@link CoinbaseAccount}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">
     * Get all Coinbase wallets</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/coinbase-accounts")
    public ArrayList<CoinbaseAccount> getCoinbaseWallets() throws Exception {
        return getCoinbaseWallets(ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get all {@code "Coinbase"}'s users wallets available
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all {@code "Coinbase"}'s users wallets available as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getcoinbaseaccounts">
     * Get all Coinbase wallets</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/coinbase-accounts")
    public <T> T getCoinbaseWallets(ReturnFormat format) throws Exception {
        String walletsResponse = sendGETRequest(COINBASE_ACCOUNT_ENDPOINT);
        switch (format) {
            case JSON:
                return (T) new JSONArray(walletsResponse);
            case LIBRARY_OBJECT:
                JSONArray jWallets = new JSONArray(walletsResponse);
                ArrayList<CoinbaseAccount> wallets = new ArrayList<>();
                for (int j = 0; j < jWallets.length(); j++)
                    wallets.add(new CoinbaseAccount(jWallets.getJSONObject(j)));
                return (T) wallets;
            default:
                return (T) walletsResponse;
        }
    }

    /**
     * Request to generate one time crypto address for a deposit
     *
     * @param accountId: account id used to create crypto address
     * @return response of generation one time crypto address for a deposit as {@link CryptoAddress} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses">
     * Generate crypto address</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/coinbase-accounts/{account_id}/addresses")
    public CryptoAddress generateCryptoAddress(String accountId) throws Exception {
        return generateCryptoAddress(accountId, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to generate one time crypto address for a deposit
     *
     * @param accountId: account id used to create crypto address
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return response of generation one time crypto address for a deposit as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses">
     * Generate crypto address</a>
     */
    @Returner
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/coinbase-accounts/{account_id}/addresses")
    public <T> T generateCryptoAddress(String accountId, ReturnFormat format) throws Exception {
        String cryptoResponse = sendGETRequest(COINBASE_ACCOUNT_ENDPOINT + "/" + accountId + "/addresses");
        switch (format) {
            case JSON:
                return (T) new JSONObject(cryptoResponse);
            case LIBRARY_OBJECT:
                return (T) new CryptoAddress(new JSONObject(cryptoResponse));
            default:
                return (T) cryptoResponse;
        }
    }

}
