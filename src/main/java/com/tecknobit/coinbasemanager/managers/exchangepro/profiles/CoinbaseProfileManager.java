package com.tecknobit.coinbasemanager.managers.exchangepro.profiles;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.profiles.records.Profile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.*;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.*;

/**
 * The {@code CoinbaseProfileManager} class is useful to manage all {@code "Coinbase"} profiles endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
 * Profile manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseProfileManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseProfileManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
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
     **/
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
     **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseProfileManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseProfileManager} <br>
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
    public CoinbaseProfileManager() {
        super();
    }

    /**
     * Request to get profiles of a {@code "Coinbase"}'s account
     * Any params required
     *
     * @return profiles of a {@code "Coinbase"}'s account as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1</a>
     **/
    public String getProfiles() throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT, GET_METHOD);
    }

    /**
     * Request to get profiles of a {@code "Coinbase"}'s account
     * Any params required
     *
     * @return profiles of a {@code "Coinbase"}'s account as {@link JSONArray}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1</a>
     **/
    public JSONArray getProfilesJSON() throws Exception {
        return new JSONArray(getProfiles());
    }

    /**
     * Request to get profiles of a {@code "Coinbase"}'s account
     * Any params required
     *
     * @return profiles of a {@code "Coinbase"}'s account list as {@link ArrayList} of {@link Profile}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1</a>
     **/
    public ArrayList<Profile> getProfilesList() throws Exception {
        return assembleProfilesList(new JSONArray(getProfiles()));
    }

    /** Request to get profiles of a {@code "Coinbase"}'s account
     * @param active: flag if profile is active or not
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1</a>
     * @return profiles of a {@code "Coinbase"}'s account as {@link String}
     * **/
    public String getProfiles(boolean active) throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT + "?active=" + active, GET_METHOD);
    }

    /** Request to get profiles of a {@code "Coinbase"}'s account
     * @param active: flag if profile is active or not
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1</a>
     * @return profiles of a {@code "Coinbase"}'s account as {@link JSONArray}
     * **/
    public JSONArray getProfilesJSON(boolean active) throws Exception {
        return new JSONArray(getProfiles(active));
    }

    /** Request to get profiles of a {@code "Coinbase"}'s account
     * @param active: flag if profile is active or not
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1</a>
     * @return profiles of a {@code "Coinbase"}'s account list as {@link ArrayList} of {@link Profile}
     * **/
    public ArrayList<Profile> getProfilesList(boolean active) throws Exception {
        return assembleProfilesList(new JSONArray(getProfiles(active)));
    }

    /** Method to assemble a profile list
     * @param jsonProfiles: jsonArray obtained by response request
     * @return profile list as {@link ArrayList} of {@link Profile}
     * **/
    private ArrayList<Profile> assembleProfilesList(JSONArray jsonProfiles){
        ArrayList<Profile> profiles = new ArrayList<>();
        for (int j=0; j < jsonProfiles.length(); j++)
            profiles.add(new Profile(jsonProfiles.getJSONObject(j)));
        return profiles;
    }

    /** Request to create a profile
     * @param name: name of profile to create
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1">
     *     ttps://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1</a>
     * @return result of creation profile as {@link String}
     * **/
    public String createProfile(String name) throws Exception {
        Params bodyParams = new Params();
        bodyParams.addParam("name", name);
        return sendPayloadedRequest(PROFILES_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create a profile
     * @param name: name of profile to create
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1</a>
     * @return result of creation profile as {@link JSONObject}
     * **/
    public JSONObject createProfileJSON(String name) throws Exception {
        return new JSONObject(createProfile(name));
    }

    /** Request to create a profile
     * @param name: name of profile to create
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1</a>
     * @return result of creation profile as {@link Profile} custom object
     * **/
    public Profile createProfileObject(String name) throws Exception {
        return new Profile(new JSONObject(createProfile(name)));
    }

    /** Request to transfer funds between profiles
     * @param from: identifier of profile where starts funds
     * @param to: identifier of profile where arrive funds
     * @param currency: currency to be transferred
     * @param amount: amount to be transferred
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer-1</a>
     * @return result of successful transfer or not as boolean
     * **/
    public boolean transferFundsBetweenProfiles(String from, String to, String currency, double amount) throws Exception {
        Params bodyParams = new Params();
        bodyParams.addParam("from", from);
        bodyParams.addParam("to", to);
        bodyParams.addParam("currency", currency);
        bodyParams.addParam("amount", amount);
        return sendPayloadedRequest(TRANSFER_BETWEEN_PROFILES_ENDPOINT, POST_METHOD, bodyParams).equals("{}");
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1</a>
     * @return single profile as {@link String}
     * **/
    public String getProfileById(String profileId) throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT + "/" + profileId, GET_METHOD);
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1</a>
     * @return single profile as {@link JSONObject}
     * **/
    public JSONObject getProfileByIdJSON(String profileId) throws Exception {
        return new JSONObject(getProfileById(profileId));
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1</a>
     * @return single profile as {@link Profile} custom object
     * **/
    public Profile getProfileByIdObject(String profileId) throws Exception {
        return new Profile(new JSONObject(getProfileById(profileId)));
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @param active: flag if profile is active or not
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1</a>
     * @return single profile as {@link String}
     * **/
    public String getProfileById(String profileId, boolean active) throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT + "/" + profileId + "?active=" + active, GET_METHOD);
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @param active: flag if profile is active or not
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1</a>
     * @return single profile as {@link JSONObject}
     * **/
    public JSONObject getProfileByIdJSON(String profileId, boolean active) throws Exception {
        return new JSONObject(getProfileById(profileId, active));
    }

    /** Request to get a single {@code "Coinbase"}'s profile
     * @param profileId: identifier of profile from fetch details
     * @param active: flag if profile is active or not
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1</a>
     * @return single profile as {@link Profile} custom object
     * **/
    public Profile getProfileByIdObject(String profileId, boolean active) throws Exception {
        return new Profile(new JSONObject(getProfileById(profileId, active)));
    }

    /** Request to rename a profile
     * @param profileId: identifier of profile to change
     * @param name: name to assign at profile to change
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1</a>
     * @return result of renaming as {@link String}
     * **/
    public String renameProfile(String profileId, String name) throws Exception {
        Params bodyParams = new Params();
        bodyParams.addParam("profileId", profileId);
        bodyParams.addParam("name", name);
        return sendPayloadedRequest(PROFILES_ENDPOINT + "/" + profileId, PUT_METHOD, bodyParams);
    }

    /** Request to rename a profile
     * @param profileId: identifier of profile to change
     * @param name: name to assign at profile to change
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1</a>
     * @return result of renaming as {@link JSONObject}
     * **/
    public JSONObject renameProfileJSON(String profileId, String name) throws Exception {
        return new JSONObject(renameProfile(profileId, name));
    }

    /** Request to rename a profile
     * @param profileId: identifier of profile to change
     * @param name: name to assign at profile to change
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1</a>
     * @return result of renaming as {@link Profile} custom object
     * **/
    public Profile renameProfileObject(String profileId, String name) throws Exception {
        return new Profile(new JSONObject(renameProfile(profileId, name)));
    }

    /** Request to delete a profile
     * @param profileId: identifier of buck profile to delete
     * @param to: identifier of profile do delete
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate-1</a>
     * @return result of deletion or not as boolean
     * **/
    public boolean deleteProfile(String profileId, String to) throws Exception {
        Params bodyParams = new Params();
        bodyParams.addParam("profileId", profileId);
        bodyParams.addParam("to", to);
        return sendPayloadedRequest(PROFILES_ENDPOINT + "/" + profileId + DELETE_PROFILE_ENDPOINT
                , PUT_METHOD, bodyParams).equals("{}");
    }

}
