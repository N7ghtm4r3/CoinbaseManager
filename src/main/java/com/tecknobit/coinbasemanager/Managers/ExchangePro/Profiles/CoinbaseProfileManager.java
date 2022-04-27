package com.tecknobit.coinbasemanager.Managers.ExchangePro.Profiles;

import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Profiles.Records.Profile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.*;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.*;

public class CoinbaseProfileManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseProfile manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseProfile manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseProfile manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseProfile manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseProfileManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String getProfiles() throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT, GET_METHOD);
    }

    public JSONArray getProfilesJSON() throws Exception {
        return new JSONArray(getProfiles());
    }

    public ArrayList<Profile> getProfilesList() throws Exception {
        return assembleProfilesList(new JSONArray(getProfiles()));
    }

    public String getProfiles(boolean active) throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT + "?active=" + active, GET_METHOD);
    }

    public JSONArray getProfilesJSON(boolean active) throws Exception {
        return new JSONArray(getProfiles(active));
    }

    public ArrayList<Profile> getProfilesList(boolean active) throws Exception {
        return assembleProfilesList(new JSONArray(getProfiles(active)));
    }

    private ArrayList<Profile> assembleProfilesList(JSONArray jsonProfiles){
        ArrayList<Profile> profiles = new ArrayList<>();
        for (int j=0; j < jsonProfiles.length(); j++)
            profiles.add(assembleProfileObject(jsonProfiles.getJSONObject(j)));
        return profiles;
    }

    public String createProfile(String name) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("name", name);
        return sendBodyParamsAPIRequest(PROFILES_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createProfileJSON(String name) throws Exception {
        return new JSONObject(createProfile(name));
    }

    public Profile createProfileObject(String name) throws Exception {
        return assembleProfileObject(new JSONObject(createProfile(name)));
    }

    public boolean transferFundsBetweenProfiles(String from, String to, String currency, double amount) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("from", from);
        bodyParams.put("to", to);
        bodyParams.put("currency", currency);
        bodyParams.put("amount", amount);
        return sendBodyParamsAPIRequest(TRANSFER_BETWEEN_PROFILES_ENDPOINT, POST_METHOD, bodyParams).equals("{}");
    }

    public String getProfileById(String profileId) throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT + "/" + profileId, GET_METHOD);
    }

    public JSONObject getProfileByIdJSON(String profileId) throws Exception {
        return new JSONObject(getProfileById(profileId));
    }

    public Profile getProfileByIdObject(String profileId) throws Exception {
        return assembleProfileObject(new JSONObject(getProfileById(profileId)));
    }

    public String getProfileById(String profileId, boolean active) throws Exception {
        return sendAPIRequest(PROFILES_ENDPOINT + "/" + profileId + "?active=" + active, GET_METHOD);
    }

    public JSONObject getProfileByIdJSON(String profileId, boolean active) throws Exception {
        return new JSONObject(getProfileById(profileId, active));
    }

    public Profile getProfileByIdObject(String profileId, boolean active) throws Exception {
        return assembleProfileObject(new JSONObject(getProfileById(profileId, active)));
    }

    public String renameProfile(String profileId, String name) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("profileId", profileId);
        bodyParams.put("name", name);
        return sendBodyParamsAPIRequest(PROFILES_ENDPOINT + "/" + profileId, PUT_METHOD, bodyParams);
    }

    public JSONObject renameProfileJSON(String profileId, String name) throws Exception {
        return new JSONObject(renameProfile(profileId, name));
    }

    public Profile renameProfileObject(String profileId, String name) throws Exception {
        return assembleProfileObject(new JSONObject(renameProfile(profileId, name)));
    }

    public boolean deleteProfile(String profileId, String to) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("profileId", profileId);
        bodyParams.put("to", to);
        return sendBodyParamsAPIRequest(PROFILES_ENDPOINT + "/" + profileId + DELETE_PROFILE_ENDPOINT
                , PUT_METHOD, bodyParams).equals("{}");
    }

    private Profile assembleProfileObject(JSONObject jsonProfile){
        return new Profile(jsonProfile.getString("id"),
                jsonProfile.getString("user_id"),
                jsonProfile.getString("name"),
                jsonProfile.getBoolean("active"),
                jsonProfile.getBoolean("is_default"),
                jsonProfile.getString("created_at"),
                jsonProfile.getBoolean("has_margin")
        );
    }

}
