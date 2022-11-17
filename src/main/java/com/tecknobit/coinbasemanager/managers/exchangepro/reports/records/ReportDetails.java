package com.tecknobit.coinbasemanager.managers.exchangepro.reports.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import com.tecknobit.coinbasemanager.managers.exchangepro.users.records.ExchangeLimits;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The {@code ReportDetails} class is useful to format general ReportDetails object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
 * Get all reports</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
 * Get user exchange limits</a>
 * </li>
 * </ul>
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

    /**
     * Constructor to init a {@link ReportDetails} object
     *
     * @param report: report details as {@link JSONObject}
     **/
    public ReportDetails(JSONObject report) {
        this(report.getString("id"), report.getString("type"), report.getString("status"));
    }

    /**
     * Method to get {@link #id} instance <br>
     * Any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #type} instance <br>
     * Any params required
     *
     * @return {@link #type} instance as {@link String}
     **/
    public String getType() {
        return type;
    }

    /**
     * Method to get {@link #status} instance <br>
     * Any params required
     *
     * @return {@link #status} instance as {@link String}
     **/
    public String getStatus() {
        return status;
    }

    /**
     * Returns a string representation of the object <br>
     * Any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

    /**
     * The {@code UserDetails} class is useful to obtain and format a general user details for {@link Report} and
     * {@link ExchangeLimits} object
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at:
     * <ul>
     * <li>
     * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     * Get all reports</a>
     * </li>
     * <li>
     * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * Get user exchange limits</a>
     * </li>
     * </ul>
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
         * **/
        public UserDetails(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                           String userType, boolean fullFillsNewRequirements, boolean hasDefault) {
            this.createdAt = createdAt;
            this.activeAt = activeAt;
            this.id = id;
            this.name = name;
            this.email = email;
            this.isBanned = isBanned;
            this.userType = userType;
            this.fullFillsNewRequirements = fullFillsNewRequirements;
            this.hasDefault = hasDefault;
            this.hUser = null;
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

        /**
         * Method to get {@link #createdAt} instance <br>
         * Any params required
         *
         * @return {@link #createdAt} instance as {@link String}
         **/
        public String getCreatedAt() {
            return createdAt;
        }

        /**
         * Method to get {@link #createdAt} timestamp <br>
         * Any params required
         *
         * @return {@link #createdAt} timestamp as long
         **/
        public long getCreatedAtTimestamp() {
            return TimeFormatter.getDateTimestamp(createdAt);
        }

        /**
         * Method to get {@link #activeAt} instance <br>
         * Any params required
         *
         * @return {@link #activeAt} instance as {@link String}
         **/
        public String getActiveAt() {
            return activeAt;
        }

        /**
         * Method to get {@link #activeAt} timestamp <br>
         * Any params required
         *
         * @return {@link #activeAt} timestamp as long
         **/
        public long getActiveAtTimestamp() {
            return TimeFormatter.getDateTimestamp(activeAt);
        }

        /**
         * Method to get {@link #id} instance <br>
         * Any params required
         *
         * @return {@link #id} instance as {@link String}
         **/
        public String getId() {
            return id;
        }

        /**
         * Method to get {@link #name} instance <br>
         * Any params required
         *
         * @return {@link #name} instance as {@link String}
         **/
        public String getName() {
            return name;
        }

        /**
         * Method to get {@link #email} instance <br>
         * Any params required
         *
         * @return {@link #email} instance as {@link String}
         **/
        public String getEmail() {
            return email;
        }

        /**
         * Method to get {@link #isBanned} instance <br>
         * Any params required
         *
         * @return {@link #isBanned} instance as boolean
         **/
        public boolean isBanned() {
            return isBanned;
        }

        /**
         * Method to get {@link #userType} instance <br>
         * Any params required
         *
         * @return {@link #userType} instance as {@link String}
         **/
        public String getUserType() {
            return userType;
        }

        /**
         * Method to get {@link #fullFillsNewRequirements} instance <br>
         * Any params required
         *
         * @return {@link #fullFillsNewRequirements} instance as boolean
         **/
        public boolean areFullFillsNewRequirements() {
            return fullFillsNewRequirements;
        }

        /**
         * Method to get {@link #hasDefault} instance <br>
         * Any params required
         *
         * @return {@link #hasDefault} instance as boolean
         **/
        public boolean hasDefault() {
            return hasDefault;
        }

        /**
         * Method to get tax domain <br>
         * Any params required
         *
         * @return tax domain as {@link String}
         **/
        public String getTaxDomain() {
            return hUser.getString("tax_domain");
        }

        /**
         * Method to get permissions <br>
         * Any params required
         *
         * @return permissions as {@link JSONObject}
         **/
        public JSONObject getPermissions() {
            return hUser.getJSONObject("permissions");
        }

        /**
         * Method to get permissions <br>
         * Any params required
         *
         * @return permissions as {@link String}
         * @apiNote this method is useful to format the return {@link String} with a custom {@link "JSON"} parser
         **/
        public String getPermissionsStringed() {
            return hUser.getJSONObject("permissions").toString();
        }

        /**
         * Method to get flags <br>
         * Any params required
         *
         * @return flags as {@link JSONObject}
         **/
        public JSONObject getFlags() {
            return hUser.getJSONObject("flags");
        }

        /**
         * Method to get flags <br>
         * Any params required
         *
         * @return flags as {@link String}
         * @apiNote this method is useful to format the return {@link String} with a custom {@link "JSON"} parser
         **/
        public String getFlagsStringed() {
            return hUser.getJSONObject("flags").toString();
        }

        /**
         * Method to get preferences <br>
         * Any params required
         *
         * @return preferences as {@link JSONObject}
         **/
        public JSONObject getPreferences() {
            return hUser.getJSONObject("preferences");
        }

        /**
         * Method to get preferences <br>
         * Any params required
         *
         * @return preferences as {@link String}
         * @apiNote this method is useful to format the return {@link String} with a custom {@link "JSON"} parser
         **/
        public String getPreferencesStringed() {
            return hUser.getJSONObject("preferences").toString();
        }

        /**
         * Method to get a custom snippet
         *
         * @param key: key of the {@code "JSON"} snippet to fetch
         * @return custom snippet as {@link JSONObject}
         **/
        public JSONObject getCustomSnippet(String key) {
            return hUser.getJSONObject(key);
        }

        /**
         * Method to get a custom snippet
         *
         * @param key: key of the {@code "JSON"} snippet to fetch
         * @return custom snippet as {@link String}
         * @apiNote this method is useful to format the return {@link String} with a custom {@link "JSON"} parser
         **/
        public String getCustomSnippetStringed(String key) {
            return hUser.getJSONObject(key).toString();
        }

        /**
         * Method to get a custom list
         *
         * @param key: key of the {@code "JSON"} snippet to fetch
         * @return custom list as {@link JSONArray}
         **/
        public JSONArray getCustomList(String key) {
            return hUser.getJSONArray(key);
        }

        /**
         * Method to get a custom list
         *
         * @param key: key of the {@code "JSON"} snippet to fetch
         * @return custom list as {@link String}
         * @apiNote this method is useful to format the return {@link String} with a custom {@link "JSON"} parser
         **/
        public String getCustomListStringed(String key) {
            return hUser.getJSONArray(key).toString();
        }

        /**
         * Returns a string representation of the object <br>
         * Any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

}
