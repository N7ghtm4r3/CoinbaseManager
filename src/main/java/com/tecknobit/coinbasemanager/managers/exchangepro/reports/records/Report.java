package com.tecknobit.coinbasemanager.managers.exchangepro.reports.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONObject;

/**
 * The {@code Report} class is useful to format Report object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
 * Get all reports</a>
 * @see ReportDetails
 **/
public class Report extends ReportDetails {

    /**
     * {@code createdAt} is instance that memorizes created at value
     * **/
    private final String createdAt;

    /**
     * {@code completedAt} is instance that memorizes completed at value
     * **/
    private final String completedAt;

    /**
     * {@code expiresAt} is instance that memorizes expires at value
     * **/
    private final String expiresAt;

    /**
     * {@code userId} is instance that memorizes user identifier value
     * **/
    private final String userId;

    /**
     * {@code fileUrl} is instance that memorizes file url value
     * **/
    private final String fileUrl;

    /**
     * {@code paramsReport} is instance that memorizes params for report
     **/
    private final ParamsReport paramsReport;

    /**
     * {@code hReport} useful to work on {@code "JSON"} data format
     **/
    private final JsonHelper hReport;

    /**
     * Constructor to init a {@link Report} custom object
     *
     * @param id:           identifier value
     * @param type:         type value
     * @param status:       status value
     * @param createdAt:    created at value
     * @param completedAt:  completed at value
     * @param expiresAt:    expires at value
     * @param userId:       user identifier value
     * @param fileUrl:      file url value
     * @param paramsReport: params for report
     **/
    public Report(String id, ReportType type, String status, String createdAt, String completedAt, String expiresAt,
                  String userId, String fileUrl, ParamsReport paramsReport) {
        super(id, type, status);
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.expiresAt = expiresAt;
        this.userId = userId;
        this.fileUrl = fileUrl;
        this.paramsReport = paramsReport;
        hReport = null;
    }

    /**
     * Constructor to init a {@link Report} custom object
     *
     * @param report: Report details as {@link JSONObject}
     **/
    public Report(JSONObject report) {
        super(report);
        hReport = new JsonHelper(report);
        createdAt = report.getString("created_at");
        completedAt = report.getString("completed_at");
        expiresAt = report.getString("expires_at");
        userId = report.getString("user_id");
        fileUrl = report.getString("file_url");
        paramsReport = new ParamsReport(report.getJSONObject("params"));
    }

    /**
     * Method to get {@link #createdAt} instance <br>
     * No-any params required
     *
     * @return {@link #createdAt} instance as {@link String}
     **/
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to get {@link #createdAt} timestamp <br>
     * No-any params required
     *
     * @return {@link #createdAt} timestamp as long
     **/
    public long getCreatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(createdAt);
    }

    /**
     * Method to get {@link #completedAt} instance <br>
     * No-any params required
     *
     * @return {@link #completedAt} instance as {@link String}
     **/
    public String getCompletedAt() {
        return completedAt;
    }

    /**
     * Method to get {@link #completedAt} timestamp <br>
     * No-any params required
     *
     * @return {@link #completedAt} timestamp as long
     **/
    public long getCompletedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(completedAt);
    }

    /**
     * Method to get {@link #expiresAt} instance <br>
     * No-any params required
     *
     * @return {@link #expiresAt} instance as {@link String}
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * Method to get {@link #expiresAt} timestamp <br>
     * No-any params required
     *
     * @return {@link #expiresAt} timestamp as long
     **/
    public long getExpiresAtTimestamp() {
        return TimeFormatter.getDateTimestamp(expiresAt);
    }

    /**
     * Method to get {@link #userId} instance <br>
     * No-any params required
     *
     * @return {@link #userId} instance as {@link String}
     **/
    public String getUserId() {
        return userId;
    }

    /**
     * Method to get {@link #fileUrl} instance <br>
     * No-any params required
     *
     * @return {@link #fileUrl} instance as {@link String}
     **/
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * Method to get {@link #paramsReport} instance <br>
     * No-any params required
     *
     * @return {@link #paramsReport} instance as {@link ParamsReport}
     **/
    public ParamsReport getParamsReport() {
        return paramsReport;
    }

    /**
     * Method to get file count <br>
     * No-any params required
     *
     * @return file count as {@link String}
     **/
    public String getFileCount() {
        return hReport.getString("file_count");
    }

    /**
     * The {@code ParamsReport} class is useful to obtain and format the params report of a {@link Report}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
     * Get all reports</a>
     **/
    public static class ParamsReport {

        /**
         * {@code startDate} is instance that memorizes start date value
         * **/
        private final String startDate;

        /**
         * {@code endDate} is instance that memorizes end date value
         * **/
        private final String endDate;

        /**
         * {@code format} is instance that memorizes format value
         * **/
        private final String format;

        /**
         * {@code productId} is instance that memorizes product identifier value
         * **/
        private final String productId;

        /**
         * {@code accountId} is instance that memorizes account identifier value
         * **/
        private final String accountId;

        /**
         * {@code profileId} is instance that memorizes profile identifier value
         * **/
        private final String profileId;

        /**
         * {@code email} is instance that memorizes email value
         * **/
        private final String email;

        /**
         * {@code newYorkState} is flag that checks if is report of New York's State
         **/
        private final boolean newYorkState;

        /**
         * {@code userReport} is instance that memorizes user report value
         **/
        private final UserReport userReport;

        /**
         * {@code hReport} useful to work on {@code "JSON"} data format
         **/
        private final JsonHelper hParamsReport;

        /**
         * Constructor to init a {@link ParamsReport} custom object
         *
         * @param startDate:    start date value
         * @param endDate:      end date value
         * @param format:       format value
         * @param productId:    product identifier value
         * @param accountId:    account identifier value
         * @param profileId:    profile identifier value
         * @param email:        email value
         * @param newYorkState: flag that checks if is report of New York's State
         * @param userReport:   user report value
         **/
        public ParamsReport(String startDate, String endDate, String format, String productId, String accountId,
                            String profileId, String email, boolean newYorkState, UserReport userReport) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.format = format;
            this.productId = productId;
            this.accountId = accountId;
            this.profileId = profileId;
            this.email = email;
            this.newYorkState = newYorkState;
            this.userReport = userReport;
            hParamsReport = null;
        }

        /**
         * Constructor to init a {@link ParamsReport} custom object
         *
         * @param paramsReport: params report details as {@link JSONObject}
         **/
        public ParamsReport(JSONObject paramsReport) {
            hParamsReport = new JsonHelper(paramsReport);
            startDate = hParamsReport.getString("start_date");
            endDate = hParamsReport.getString("end_date");
            format = hParamsReport.getString("format");
            productId = hParamsReport.getString("product_id");
            accountId = hParamsReport.getString("account_id");
            profileId = hParamsReport.getString("profile_id");
            email = hParamsReport.getString("email");
            newYorkState = hParamsReport.getBoolean("new_york_state");
            userReport = new UserReport(hParamsReport.getJSONObject("user", new JSONObject()));
        }

        /**
         * Method to get {@link #startDate} instance <br>
         * No-any params required
         *
         * @return {@link #startDate} instance as {@link String}
         **/
        public String getStartDate() {
            return startDate;
        }

        /**
         * Method to get {@link #startDate} timestamp <br>
         * No-any params required
         *
         * @return {@link #startDate} timestamp as long
         **/
        public long getStartDateTimestamp() {
            return TimeFormatter.getDateTimestamp(startDate);
        }

        /**
         * Method to get {@link #endDate} instance <br>
         * No-any params required
         *
         * @return {@link #endDate} instance as {@link String}
         **/
        public String getEndDate() {
            return endDate;
        }

        /**
         * Method to get {@link #endDate} timestamp <br>
         * No-any params required
         *
         * @return {@link #endDate} timestamp as long
         **/
        public long getEndDateTimestamp() {
            return TimeFormatter.getDateTimestamp(endDate);
        }

        /**
         * Method to get {@link #format} instance <br>
         * No-any params required
         *
         * @return {@link #format} instance as {@link String}
         **/
        public String getFormat() {
            return format;
        }

        /**
         * Method to get {@link #productId} instance <br>
         * No-any params required
         *
         * @return {@link #productId} instance as {@link String}
         **/
        public String getProductId() {
            return productId;
        }

        /**
         * Method to get {@link #accountId} instance <br>
         * No-any params required
         *
         * @return {@link #accountId} instance as {@link String}
         **/
        public String getAccountId() {
            return accountId;
        }

        /**
         * Method to get {@link #profileId} instance <br>
         * No-any params required
         *
         * @return {@link #profileId} instance as {@link String}
         **/
        public String getProfileId() {
            return profileId;
        }

        /**
         * Method to get {@link #email} instance <br>
         * No-any params required
         *
         * @return {@link #email} instance as {@link String}
         **/
        public String getEmail() {
            return email;
        }

        /**
         * Method to get {@link #newYorkState} instance <br>
         * No-any params required
         *
         * @return {@link #newYorkState} instance as boolean
         **/
        public boolean isInNewYorkState() {
            return newYorkState;
        }

        /**
         * Method to get {@link #userReport} instance <br>
         * No-any params required
         *
         * @return {@link #userReport} instance as {@link UserReport}
         **/
        public UserReport getUserReport() {
            return userReport;
        }

        /**
         * Method to get default profile id instance <br>
         * No-any params required
         *
         * @return default profile id as {@link String}
         **/
        public String getDefaultProfileId() {
            return hParamsReport.getString("default_profile_id");
        }

        /**
         * Method to get if is brokerage <br>
         * No-any params required
         *
         * @return is brokerage as boolean
         **/
        public boolean isBrokerage() {
            return hParamsReport.getBoolean("is_brokerage");
        }

        /**
         * Returns a string representation of the object <br>
         * No-any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

        /**
         * The {@code UserReport} class is useful to obtain and format an user report for a {@link Report}
         *
         * @author N7ghtm4r3 - Tecknobit
         * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
         * Get all reports</a>
         * @see UserDetails
         **/
        public static class UserReport extends UserDetails {

            /**
             * {@code oauthClient} is instance that memorizes oauth client value
             * **/
            private final String oauthClient;

            /** Constructor to init {@link UserReport} custom object
             * @param createdAt: created at value
             * @param activeAt: active at value
             * @param id: identifier value
             * @param name: name value
             * @param email: email value
             * @param isBanned: flag if account is banned
             * @param userType: user type value
             * @param fullFillsNewRequirements: flag for full fills new requirements
             * @param hasDefault: flag for default check
             * @param oauthClient: oauth client value
             * **/
            public UserReport(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                              String userType, boolean fullFillsNewRequirements, String oauthClient, boolean hasDefault) {
                super(createdAt, activeAt, id, name, email, isBanned, userType, fullFillsNewRequirements, hasDefault);
                this.oauthClient = oauthClient;
            }

            /**
             * Constructor to init a {@link UserReport} custom object
             *
             * @param userReport: user report report details as {@link JSONObject}
             **/
            public UserReport(JSONObject userReport) {
                super(userReport);
                this.oauthClient = hUser.getString("oauth_client");
            }

            /**
             * Method to get roles <br>
             * No-any params required
             *
             * @return roles as {@link JSONObject}
             **/
            public JSONObject getRoles() {
                return hUser.getJSONObject("roles");
            }

            /**
             * Method to get roles <br>
             * No-any params required
             *
             * @return roles as {@link String}
             * @apiNote this method is useful to format the return {@link String} with a custom {@link "JSON"} parser
             **/
            public String getRolesStringed() {
                return hUser.getJSONObject("roles").toString();
            }

            /**
             * Method to get details <br>
             * No-any params required
             *
             * @return details as {@link JSONObject}
             **/
            public JSONObject getDetails() {
                return hUser.getJSONObject("details");
            }

            /**
             * Method to get details <br>
             * No-any params required
             *
             * @return details as {@link String}
             * @apiNote this method is useful to format the return {@link String} with a custom {@link "JSON"} parser
             **/
            public String getDetailsStringed() {
                return hUser.getJSONObject("details").toString();
            }

            /**
             * Method to get {@link #oauthClient} instance <br>
             * No-any params required
             *
             * @return {@link #oauthClient} instance as {@link String}
             **/
            public String getOauthClient() {
                return oauthClient;
            }

        }

    }

}
