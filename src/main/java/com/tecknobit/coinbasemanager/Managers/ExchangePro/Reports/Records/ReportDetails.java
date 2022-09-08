package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Users.Records.ExchangeLimits;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The {@code ReportDetails} class is useful to format general ReportDetails object
 * @apiNote see the official documentation at:
<ul>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
</li>
</ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class ReportDetails {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    protected final String id;

    /**
     * {@code type} is instance that memorizes type value
     * **/
    protected final String type;

    /**
     * {@code status} is instance that memorizes status value
     * **/
    protected final String status;

    /** Constructor to init a {@link ReportDetails} object
     * @param id: identifier value
     * @param type: type value
     * @param status: status value
     * **/
    public ReportDetails(String id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    /** Constructor to init a {@link ReportDetails} object
     * @param report: report details as {@link JSONObject}
     * **/
    public ReportDetails(JSONObject report) {
        id = report.getString("id");
        type = report.getString("type");
        status = report.getString("status");
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

    @Override
    public String toString() {
        return "ReportDetails{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    /**
     * The {@code UserDetails} class is useful to obtain and format general UserDetails object for {@link Report} and {@link ExchangeLimits} object
     *
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1</a>
     **/
    public static class UserDetails {

        /**
         * {@code createdAt} is instance that memorizes created at value
         * **/
        protected final String createdAt;

        /**
         * {@code activeAt} is instance that memorizes active at value
         * **/
        protected final String activeAt;

        /**
         * {@code id} is instance that memorizes identifier value
         * **/
        protected final String id;

        /**
         * {@code name} is instance that memorizes name value
         * **/
        protected final String name;

        /**
         * {@code email} is instance that memorizes email value
         * **/
        protected final String email;

        /**
         * {@code email} is flag that checks if is banned or not
         * **/
        protected final boolean isBanned;

        /**
         * {@code userType} is instance that memorizes user type value
         * **/
        protected final String userType;

        /**
         * {@code fullFillsNewRequirements} is flag for full fills new requirements
         * **/
        protected final boolean fullFillsNewRequirements;

        /**
         * {@code fullFillsNewRequirements} is flag for default check
         * **/
        protected final boolean hasDefault;

        /**
         * {@code fullFillsNewRequirements} is useful to help to format JSON
         * **/
        protected final JsonHelper hUser;

        /** Constructor to init {@link UserDetails} object
         * @param createdAt: created at value
         * @param activeAt: active at value
         * @param id: identifier value
         * @param name: name value
         * @param email: email value
         * @param isBanned: flag if account is banned
         * @param userType: user type value
         * @param fullFillsNewRequirements: flag for full fills new requirements
         * @param hasDefault: flag for default check
         * @param hUser: useful to help to format JSON
         * **/
        public UserDetails(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                           String userType, boolean fullFillsNewRequirements, boolean hasDefault, JsonHelper hUser) {
            this.createdAt = createdAt;
            this.activeAt = activeAt;
            this.id = id;
            this.name = name;
            this.email = email;
            this.isBanned = isBanned;
            this.userType = userType;
            this.fullFillsNewRequirements = fullFillsNewRequirements;
            this.hasDefault = hasDefault;
            this.hUser = hUser;
        }

        /** Constructor to init a {@link UserDetails} object
         * @param userDetails: user details as {@link JSONObject}
         * **/
        public UserDetails(JSONObject userDetails) {
            hUser = new JsonHelper(userDetails);
            createdAt = hUser.getString("created_at");
            activeAt = hUser.getString("active_at");
            id = hUser.getString("id");
            name = hUser.getString("name");
            email = hUser.getString("email");
            isBanned = hUser.getBoolean("is_banned");
            userType = hUser.getString("user_type");
            fullFillsNewRequirements = hUser.getBoolean("fulfills_new_requirements");
            hasDefault = hUser.getBoolean("has_default");
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
            return hUser.getString("tax_domain");
        }

        public JSONObject getPermissions() {
            return hUser.getJSONObject("permissions");
        }

        public JSONObject getFlags() {
            return hUser.getJSONObject("flags");
        }

        public JSONObject getPreferences(){
            return hUser.getJSONObject("preferences");
        }

        public JSONObject getCustomSnippet(String key){
            return hUser.getJSONObject(key);
        }

        public JSONArray getCustomList(String key){
            return hUser.getJSONArray(key);
        }

        @Override
        public String toString() {
            return "UserDetails{" +
                    "createdAt='" + createdAt + '\'' +
                    ", activeAt='" + activeAt + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", isBanned=" + isBanned +
                    ", userType='" + userType + '\'' +
                    ", fullFillsNewRequirements=" + fullFillsNewRequirements +
                    ", hasDefault=" + hasDefault +
                    ", hUser=" + hUser +
                    '}';
        }

    }

}
