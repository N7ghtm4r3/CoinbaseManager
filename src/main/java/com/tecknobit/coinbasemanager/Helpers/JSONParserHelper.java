package com.tecknobit.coinbasemanager.Helpers;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParserHelper {

    // TODO: 24/04/2022 INSERT IN APIMANAGER LIBRARY
    private final JSONObject jsonDetails;

    public JSONParserHelper(JSONObject jsonDetails) {
        this.jsonDetails = jsonDetails;
    }

    /** Method to get from jsonObject a string value
     * @param #key: key of string value to get from json
     * @return value as {@link String}, if it is not exist will return null value
     * **/
    public String getStringDetailValue(String key){
        try {
            return jsonDetails.getString(key);
        }catch (Exception e){
            return null;
        }
    }

    /** Method to get from jsonObject a numeric value
     * @param #key: key of numeric value to get from json
     * @return value as double, if it is not exist will return -1 value
     * **/
    public double getNumberDetailValue(String key){
        try {
            return jsonDetails.getDouble(key);
        }catch (Exception e){
            return -1;
        }
    }

    /** Method to get from jsonObject  a list of values
     * @param #key: key of list to get from json
     * @return value as {@link JSONArray}, if it is not exist will return null value
     * **/
    public JSONArray getJSONArrayList(String key){
        try {
            return jsonDetails.getJSONArray(key);
        }catch (Exception e){
            return null;
        }
    }

    /** Method to get from jsonObject a jsonObject
     * @param #key: key of list to get from json
     * @return value as {@link JSONObject}, if it is not exist will return null value
     * **/
    public JSONObject getJSONObject(String key){
        try {
            return jsonDetails.getJSONObject(key);
        }catch (Exception e){
            return null;
        }
    }

}
