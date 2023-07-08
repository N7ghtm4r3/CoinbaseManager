package com.tecknobit.coinbasemanager.exchangepro.addressbook;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.apimanager.interfaces.Manager;
import com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.exchangepro.addressbook.records.AddressBookAdded;
import com.tecknobit.coinbasemanager.exchangepro.addressbook.records.AddressBookItem;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.*;
import static com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code CoinbaseAddressBookManager} class is useful to manage all {@code "Coinbase"} address book endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaddressbook">
 * Address Book</a>
 * @see CoinbaseManager
 * @see Manager
 */
public class CoinbaseAddressBookManager extends CoinbaseManager {

    /**
     * {@code ADDRESS_BOOK_ENDPOINT} is constant for ADDRESS_BOOK_ENDPOINT's endpoint
     */
    public static final String ADDRESS_BOOK_ENDPOINT = "/address-book";

    /**
     * Constructor to init a {@link CoinbaseManager}
     *
     * @param apiKey              :              your {@code "Coinbase"} api key
     * @param apiSecret           :           your {@code "Coinbase"} api secret
     * @param passphrase          :          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage : custom error to show when is not a request error
     * @param timeout             :             custom timeout for request
     */
    public CoinbaseAddressBookManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage,
                                      int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseManager}
     *
     * @param apiKey     : your {@code "Coinbase"} api key
     * @param apiSecret  : your {@code "Coinbase"} api secret
     * @param passphrase : your {@code "Coinbase"} api passphrase
     * @param timeout    : custom timeout for request
     */
    public CoinbaseAddressBookManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseManager}
     *
     * @param apiKey              : your {@code "Coinbase"} api key
     * @param apiSecret           : your {@code "Coinbase"} api secret
     * @param passphrase          : your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage : custom error to show when is not a request error
     */
    public CoinbaseAddressBookManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseManager}
     *
     * @param apiKey     :     your {@code "Coinbase"} api key
     * @param apiSecret  :  your {@code "Coinbase"} api secret
     * @param passphrase : your {@code "Coinbase"} api passphrase
     */
    public CoinbaseAddressBookManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseManager} <br>
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
    public CoinbaseAddressBookManager() {
        super();
    }

    /**
     * Request to get all addresses stored in the address book <br>
     * No-any params required
     *
     * @return addresses stored in the address book as {@link ArrayList} of {@link AddressBookItem} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaddressbook">
     * Get address book</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/address-book")
    public ArrayList<AddressBookItem> getAddressBook() throws Exception {
        return getAddressBook(LIBRARY_OBJECT);
    }

    /**
     * Request to get all addresses stored in the address book
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return addresses stored in the address book as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaddressbook">
     * Get address book</a>
     */
    @Returner
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/address-book")
    public <T> T getAddressBook(ReturnFormat format) throws Exception {
        JSONArray addressBookResponse = new JSONArray(sendGETRequest(ADDRESS_BOOK_ENDPOINT));
        return switch (format) {
            case JSON -> (T) addressBookResponse;
            case LIBRARY_OBJECT -> {
                ArrayList<AddressBookItem> addressBook = new ArrayList<>();
                for (int j = 0; j < addressBookResponse.length(); j++)
                    addressBook.add(new AddressBookItem(addressBookResponse.getJSONObject(j)));
                yield (T) addressBook;
            }
            default -> (T) addressBookResponse.toString();
        };
    }

    /**
     * Request to add new addresses to address book
     *
     * @param to: address to add
     * @return new addresses as {@link AddressBookAdded} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postaddressbook">
     * Add address</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/address-book")
    public AddressBookAdded addAddress(AddressBookItem to) throws Exception {
        return addAddress(to, LIBRARY_OBJECT);
    }

    /**
     * Request to add new addresses to address book
     *
     * @param to:     address to add
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return new addresses as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postaddressbook">
     * Add address</a>
     */
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/address-book")
    public <T> T addAddress(AddressBookItem to, ReturnFormat format) throws Exception {
        return addAddress(to, null, format);
    }

    /**
     * Request to add new addresses to address book
     *
     * @param to:      address to add
     * @param payload: extra query params, keys accepted are:
     *                 <ul>
     *                      <li>
     *                          {@code "currency"} -> currency symbol - [string]
     *                      </li>
     *                      <li>
     *                          {@code "label"} -> label/nickname for address book entry - [string]
     *                      </li>
     *                 </ul>
     * @return new addresses as {@link AddressBookAdded} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postaddressbook">
     * Add address</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/address-book")
    public AddressBookAdded addAddress(AddressBookItem to, Params payload) throws Exception {
        return addAddress(to, payload, LIBRARY_OBJECT);
    }

    /**
     * Request to add new addresses to address book
     *
     * @param to:      address to add
     * @param payload: extra query params, keys accepted are:
     *                 <ul>
     *                      <li>
     *                          {@code "currency"} -> currency symbol - [string]
     *                      </li>
     *                      <li>
     *                          {@code "label"} -> label/nickname for address book entry - [string]
     *                      </li>
     *                 </ul>
     * @param format:  return type formatter -> {@link ReturnFormat}
     * @return new addresses as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postaddressbook">
     * Add address</a>
     */
    @Returner
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/address-book")
    public <T> T addAddress(AddressBookItem to, Params payload, ReturnFormat format) throws Exception {
        if (payload == null)
            payload = new Params();
        payload.addParam("to", to);
        JSONObject addressBookResponse = new JSONObject(sendPostRequest(ADDRESS_BOOK_ENDPOINT, payload));
        return switch (format) {
            case JSON -> (T) addressBookResponse;
            case LIBRARY_OBJECT -> (T) new AddressBookAdded(addressBookResponse);
            default -> (T) addressBookResponse.toString();
        };
    }

    /**
     * Request to delete address from address book
     *
     * @param address: the address to delete
     * @return result of deletion or not as boolean
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteaddressbookentry">
     * Delete address</a>
     */
    @WrappedRequest
    @RequestPath(method = DELETE, path = "https://api.exchange.coinbase.com/address-book/{id}")
    public boolean deleteAddress(AddressBookItem address) throws Exception {
        return deleteAddress(address.getId());
    }

    /**
     * Request to delete address from address book
     *
     * @param id: address book identifier
     * @return result of deletion or not as boolean
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_deleteaddressbookentry">
     * Delete address</a>
     */
    @RequestPath(method = DELETE, path = "https://api.exchange.coinbase.com/address-book/{id}")
    public boolean deleteAddress(String id) throws Exception {
        return sendDELETERequest(ADDRESS_BOOK_ENDPOINT + "/" + id).equals("{}");
    }

}
