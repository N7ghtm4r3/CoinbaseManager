package com.tecknobit.coinbasemanager.exchangepro.profiles;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.apimanager.interfaces.Manager;
import com.tecknobit.coinbasemanager.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.exchangepro.profiles.records.Profile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.*;

/**
 * The {@code CoinbaseProfileManager} class is useful to manage all {@code "Coinbase"} profiles endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles">
 * Profile manager</a>
 * @see CoinbaseManager
 * @see Manager
 */
public class CoinbaseProfileManager extends CoinbaseManager {

    /**
     * {@code PROFILES_ENDPOINT} is constant for PROFILES_ENDPOINT's endpoint
     */
    public static final String PROFILES_ENDPOINT = "/profiles";

    /**
     * {@code TRANSFER_BETWEEN_PROFILES_ENDPOINT} is constant for TRANSFER_BETWEEN_PROFILES_ENDPOINT's endpoint
     */
    public static final String TRANSFER_BETWEEN_PROFILES_ENDPOINT = "/transfer";

    /**
     * {@code DELETE_PROFILE_ENDPOINT} is constant for DELETE_PROFILE_ENDPOINT's endpoint
     */
    public static final String DELETE_PROFILE_ENDPOINT = "/deactivate";

    /**
     * Constructor to init a {@link CoinbaseProfileManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     */
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseProfileManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     */
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseProfileManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     */
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseProfileManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     */
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseProfileManager} <br>
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
    public CoinbaseProfileManager() {
        super();
    }

    /**
     * Request to get profiles of a {@code "Coinbase"}'s account <br>
     * No-any params required
     *
     * @return profiles of a {@code "Coinbase"}'s account list as {@link ArrayList} of {@link Profile}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles">
     * Get profiles</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles")
    public ArrayList<Profile> getProfiles() throws Exception {
        return getProfiles(ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get profiles of a {@code "Coinbase"}'s account
     *
     * @param format :                 return type formatter -> {@link ReturnFormat}
     * @return profiles of a {@code "Coinbase"}'s account list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles">
     * Get profiles</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles")
    public <T> T getProfiles(ReturnFormat format) throws Exception {
        return returnProfilesList(sendGETRequest(PROFILES_ENDPOINT), format);
    }

    /**
     * Request to get profiles of a {@code "Coinbase"}'s account
     *
     * @param active: flag if profile is active or not
     * @return profiles of a {@code "Coinbase"}'s account list as {@link ArrayList} of {@link Profile}
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles">
     * Get profiles</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles")
    public ArrayList<Profile> getProfiles(boolean active) throws Exception {
        return getProfiles(active, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to get profiles of a {@code "Coinbase"}'s account
     *
     * @param active: flag if profile is active or not
     * @param format  :                 return type formatter -> {@link ReturnFormat}
     * @return profiles of a {@code "Coinbase"}'s account list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles">
     * Get profiles</a>
     */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles")
    public <T> T getProfiles(boolean active, ReturnFormat format) throws Exception {
        return returnProfilesList(sendGETRequest(PROFILES_ENDPOINT + "?active=" + active), format);
    }

    /**
     * Method to assemble a profiles list
     *
     * @param profilesResponse : profiles list response to format
     * @param format           :                 return type formatter -> {@link ReturnFormat}
     * @return profiles list response as {@code "format"} defines
     */
    @Returner
    private <T> T returnProfilesList(String profilesResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(profilesResponse);
            case LIBRARY_OBJECT:
                ArrayList<Profile> profiles = new ArrayList<>();
                JSONArray jProfiles = new JSONArray(profilesResponse);
                for (int j = 0; j < jProfiles.length(); j++)
                    profiles.add(new Profile(jProfiles.getJSONObject(j)));
                return (T) profiles;
            default:
                return (T) profilesResponse;
        }
    }

    /**
     * Request to create a profile
     *
     * @param name: name of profile to create
     * @return result of creation profile as {@link Profile} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile">
     * Create a profile</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/profiles")
    public Profile createProfile(String name) throws Exception {
        return createProfile(name, ReturnFormat.LIBRARY_OBJECT);
    }

    /** Request to create a profile
     * @param name: name of profile to create
     * @param format           :                 return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile">
     *     Create a profile</a>
     * @return result of creation profile as {@code "format"} defines
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
     * */
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/profiles")
    public <T> T createProfile(String name, ReturnFormat format) throws Exception {
        Params bodyParams = new Params();
        bodyParams.addParam("name", name);
        return returnProfile(sendPostRequest(PROFILES_ENDPOINT, bodyParams), format);
    }

    /** Request to transfer funds between profiles
     * @param from: identifier of profile where starts funds
     * @param to: identifier of profile where arrive funds
     * @param currency: currency to be transferred
     * @param amount: amount to be transferred
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer">
     *     Transfer funds between profiles</a>
     * @return result of successful transfer or not as boolean
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
     * */
    @RequestPath(method = POST, path = "https://api.exchange.coinbase.com/profiles/transfer")
    public boolean transferFundsBetweenProfiles(String from, String to, String currency, double amount) throws Exception {
        Params payload = new Params();
        payload.addParam("from", from);
        payload.addParam("to", to);
        payload.addParam("currency", currency);
        payload.addParam("amount", amount);
        return sendPostRequest(TRANSFER_BETWEEN_PROFILES_ENDPOINT, payload).equals("{}");
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile">
     *     Get profile by id</a>
     * @return single profile as {@link Profile} custom object
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
     * */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public Profile getProfileById(String profileId) throws Exception {
        return getProfileById(profileId, ReturnFormat.LIBRARY_OBJECT);
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @param format           :                 return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile">
     *     Get profile by id</a>
     * @return single profile as {@code "format"} defines
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
     * */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public <T> T getProfileById(String profileId, ReturnFormat format) throws Exception {
        return returnProfile(sendGETRequest(PROFILES_ENDPOINT + "/" + profileId), format);
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @param active: flag if profile is active or not
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile">
     *     Get profile by id</a>
     * @return single profile as {@link Profile} custom object
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
     * */
    @Wrapper
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public Profile getProfileById(String profileId, boolean active) throws Exception {
        return getProfileById(profileId, active, ReturnFormat.LIBRARY_OBJECT);
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @param active: flag if profile is active or not
     * @param format           :                 return type formatter -> {@link ReturnFormat}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile">
     *     Get profile by id</a>
     * @return single profile as {@code "format"} defines
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
     * */
    @RequestPath(method = GET, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public <T> T getProfileById(String profileId, boolean active, ReturnFormat format) throws Exception {
        return returnProfile(sendGETRequest(PROFILES_ENDPOINT + "/" + profileId + "?active=" + active),
                format);
    }

    /**
     * Request to rename a profile
     *
     * @param profile: profile to change the name
     * @param name:    name to assign at profile to change
     * @return result of renaming as {@link Profile} custom object
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile">
     * Rename a profile</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = PUT, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public Profile renameProfile(Profile profile, String name) throws Exception {
        return renameProfile(profile.getId(), name, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to rename a profile
     *
     * @param profile: profile to change the name
     * @param name:    name to assign at profile to change
     * @param format:  return type formatter -> {@link ReturnFormat}
     * @return result of renaming as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile">
     * Rename a profile</a>
     */
    @WrappedRequest
    @RequestPath(method = PUT, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public <T> T renameProfile(Profile profile, String name, ReturnFormat format) throws Exception {
        return renameProfile(profile.getId(), name, format);
    }

    /** Request to rename a profile
     * @param profileId: identifier of profile to change
     * @param name: name to assign at profile to change
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile">
     *     Rename a profile</a>
     * @return result of renaming as {@link Profile} custom object
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
     * */
    @Wrapper
    @RequestPath(method = PUT, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public Profile renameProfile(String profileId, String name) throws Exception {
        return renameProfile(profileId, name, ReturnFormat.LIBRARY_OBJECT);
    }

    /**
     * Request to rename a profile
     *
     * @param profileId: identifier of profile to change
     * @param name:      name to assign at profile to change
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return result of renaming as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile">
     * Rename a profile</a>
     */
    @RequestPath(method = PUT, path = "https://api.exchange.coinbase.com/profiles/{profile_id}")
    public <T> T renameProfile(String profileId, String name, ReturnFormat format) throws Exception {
        Params payload = new Params();
        payload.addParam("profileId", profileId);
        payload.addParam("name", name);
        return returnProfile(sendPutRequest(PROFILES_ENDPOINT + "/" + profileId, payload), format);
    }

    /**
     * Method to create a profile object
     *
     * @param profileResponse: profile to format
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return profile response as {@code "format"} defines
     */
    @Returner
    private <T> T returnProfile(String profileResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONObject(profileResponse);
            case LIBRARY_OBJECT:
                return (T) new Profile(new JSONObject(profileResponse));
            default:
                return (T) profileResponse;
        }
    }

    /**
     * Request to delete a profile
     *
     * @param profile: buck profile to delete
     * @param to:      identifier of profile do delete
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate">
     * Delete a profile</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = PUT, path = "https://api.exchange.coinbase.com/profiles/{profile_id}/deactivate")
    public boolean deleteProfile(Profile profile, String to) throws Exception {
        return deleteProfile(profile.getId(), to);
    }

    /**
     * Request to delete a profile
     *
     * @param profileId: identifier of buck profile to delete
     * @param to:        identifier of profile do delete
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
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate">
     * Delete a profile</a>
     */
    @RequestPath(method = PUT, path = "https://api.exchange.coinbase.com/profiles/{profile_id}/deactivate")
    public boolean deleteProfile(String profileId, String to) throws Exception {
        Params payload = new Params();
        payload.addParam("profileId", profileId);
        payload.addParam("to", to);
        return sendPutRequest(PROFILES_ENDPOINT + "/" + profileId + DELETE_PROFILE_ENDPOINT, payload).equals("{}");
    }

}
