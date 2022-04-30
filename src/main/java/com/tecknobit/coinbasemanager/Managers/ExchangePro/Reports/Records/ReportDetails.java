package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records;

import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportDetails {

    private final String id;
    private final String type;
    private final String status;

    public ReportDetails(String id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public static class UserDetails{

        private final String createdAt;
        private final String activeAt;
        private final String id;
        private final String name;
        private final String email;
        private final boolean isBanned;
        private final String userType;
        private final boolean fullFillsNewRequirements;
        private final boolean hasDefault;
        protected final JsonHelper jsonUser;

        public UserDetails(String createdAt, String activeAt, String id, String name, String email,
                           boolean isBanned, String userType, boolean fullFillsNewRequirements, boolean hasDefault,
                           JsonHelper jsonUser) {
            this.createdAt = createdAt;
            this.activeAt = activeAt;
            this.id = id;
            this.name = name;
            this.email = email;
            this.isBanned = isBanned;
            this.userType = userType;
            this.fullFillsNewRequirements = fullFillsNewRequirements;
            this.hasDefault = hasDefault;
            this.jsonUser = jsonUser;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getActiveAt() {
            return activeAt;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public boolean isBanned() {
            return isBanned;
        }

        public String getUserType() {
            return userType;
        }

        public boolean isFullFillsNewRequirements() {
            return fullFillsNewRequirements;
        }

        public boolean isHasDefault() {
            return hasDefault;
        }

        public String getTaxDomain(){
            return jsonUser.getString("tax_domain");
        }

        public JSONObject getPermissions() {
            return jsonUser.getJSONObject("permissions");
        }

        public JSONObject getFlags() {
            return jsonUser.getJSONObject("flags");
        }

        public JSONObject getPreferences(){
            return jsonUser.getJSONObject("preferences");
        }

        public JSONObject getCustomSnippet(String key){
            return jsonUser.getJSONObject(key);
        }

        public JSONArray getCustomList(String key){
            return jsonUser.getJSONArray(key);
        }

    }

}
