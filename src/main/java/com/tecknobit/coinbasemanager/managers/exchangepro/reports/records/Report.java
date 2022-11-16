package com.tecknobit.coinbasemanager.managers.exchangepro.reports.records;

import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONObject;

/**
 * The {@code Report} class is useful to format Report object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
 * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
 **/

public class Report extends ReportDetails {

    /**
     * {@code FILLS_REPORT_TYPE} is constant for fills report type
     * **/
    public static final String FILLS_REPORT_TYPE = "fills";

    /**
     * {@code ACCOUNT_REPORT_TYPE} is constant for account report type
     * **/
    public static final String ACCOUNT_REPORT_TYPE = "account";

    /**
     * {@code OTC_FILLS_REPORT_TYPE} is constant for otc fills report type
     * **/
    public static final String OTC_FILLS_REPORT_TYPE = "otc_fills";

    /**
     * {@code REPORT_TYPE_1099K} is constant for type 1099k transaction history report type
     * **/
    public static final String REPORT_TYPE_1099K = "type_1099k_transaction_history";

    /**
     * {@code TAX_INVOICE_REPORT_TYPE} is constant for tax invoice report type
     * **/
    public static final String TAX_INVOICE_REPORT_TYPE = "tax_invoice";

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
     * **/
    private final ParamsReport paramsReport;

    /**
     * {@code jsonHelper} is instance useful to help to format JSON
     * **/
    private static JsonHelper jsonHelper;

    /** Constructor to init a {@link Report} object
     * @param createdAt: created at value
     * @param completedAt: completed at value
     * @param expiresAt: expires at value
     * @param id: identifier value
     * @param type: type value
     * @param status: status value
     * @param userId: user identifier value
     * @param fileUrl: file url value
     * @param jsonHelper: useful to help to format JSON
     * **/
    public Report(String createdAt, String completedAt, String expiresAt, String id, String type, String status,
                  String userId, String fileUrl, JsonHelper jsonHelper) {
        super(id, type, status);
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.expiresAt = expiresAt;
        this.userId = userId;
        this.fileUrl = fileUrl;
        Report.jsonHelper = jsonHelper;
        this.paramsReport = new ParamsReport(jsonHelper.getString("start_date"),
                jsonHelper.getString("end_date"),
                jsonHelper.getString("format"),
                jsonHelper.getString("product_id"),
                jsonHelper.getString("account_id"),
                jsonHelper.getString("profile_id"),
                jsonHelper.getString("email"),
                jsonHelper.getBoolean("new_york_state"),
                new JsonHelper(jsonHelper.getJSONObject("user"))
        );
    }

    /** Constructor to init a {@link Report} object
     * @param report: Report details as {@link JSONObject}
     * **/
    public Report(JSONObject report) {
        super(report);
        createdAt = report.getString("created_at");
        completedAt = report.getString("completed_at");
        expiresAt = report.getString("expires_at");
        userId = report.getString("user_id");
        fileUrl = report.getString("file_url");
        jsonHelper = new JsonHelper(report.getJSONObject("params"));
        paramsReport = new ParamsReport(report);
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public ParamsReport getParamsReport() {
        return paramsReport;
    }

    public String getFileCount() {
        return jsonHelper.getString("file_count");
    }

    @Override
    public String toString() {
        return "Report{" +
                "createdAt='" + createdAt + '\'' +
                ", completedAt='" + completedAt + '\'' +
                ", expiresAt='" + expiresAt + '\'' +
                ", userId='" + userId + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", paramsReport=" + paramsReport.toString() +
                ", jsonHelper=" + jsonHelper +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    /**
     * The {@code ParamsReport} class is useful to obtain and format ParamsReport object for Report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     * **/
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
         * **/
        private final boolean newYorkState;

        /**
         * {@code userReport} is instance that memorizes user report value
         * **/
        private final UserReport userReport;

        /** Constructor to init a {@link ParamsReport} object
         * @param startDate: start date value
         * @param endDate: end date value
         * @param format: format value
         * @param productId: product identifier value
         * @param accountId: account identifier value
         * @param profileId: profile identifier value
         * @param email: email value
         * @param newYorkState: flag that checks if is report of New York's State
         * @param jsonHelper: useful to help to format JSON
         * **/
        public ParamsReport(String startDate, String endDate, String format, String productId, String accountId,
                            String profileId, String email, boolean newYorkState, JsonHelper jsonHelper) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.format = format;
            this.productId = productId;
            this.accountId = accountId;
            this.profileId = profileId;
            this.email = email;
            this.newYorkState = newYorkState;
            this.userReport = new UserReport(jsonHelper.getString("created_at"),
                    jsonHelper.getString("active_at"),
                    jsonHelper.getString("id"),
                    jsonHelper.getString("name"),
                    jsonHelper.getString("email"),
                    jsonHelper.getBoolean("is_banned"),
                    jsonHelper.getString("user_type"),
                    jsonHelper.getBoolean("fulfills_new_requirements"),
                    jsonHelper.getString("oauth_client"),
                    jsonHelper.getBoolean("has_default"),
                    jsonHelper
            );
        }

        /** Constructor to init a {@link ParamsReport} object
         * @param paramsReport: params report details as {@link JSONObject}
         * **/
        public ParamsReport(JSONObject paramsReport) {
            jsonHelper = new JsonHelper(paramsReport);
            startDate = jsonHelper.getString("start_date");
            endDate = jsonHelper.getString("end_date");
            format = jsonHelper.getString("format");
            productId = jsonHelper.getString("product_id");
            accountId = jsonHelper.getString("account_id");
            profileId = jsonHelper.getString("profile_id");
            email = jsonHelper.getString("email");
            newYorkState = jsonHelper.getBoolean("new_york_state");
            userReport = new UserReport(paramsReport);
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public String getFormat() {
            return format;
        }

        public String getProductId() {
            return productId;
        }

        public String getAccountId() {
            return accountId;
        }

        public String getProfileId() {
            return profileId;
        }

        public String getEmail() {
            return email;
        }

        public boolean isNewYorkState() {
            return newYorkState;
        }

        public UserReport getUserReport() {
            return userReport;
        }

        public String getDefaultProfileId(){
            return jsonHelper.getString("default_profile_id");
        }

        public boolean isBrokerage(){
            return jsonHelper.getBoolean("is_brokerage");
        }

        @Override
        public String toString() {
            return "ParamsReport{" +
                    "startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", format='" + format + '\'' +
                    ", productId='" + productId + '\'' +
                    ", accountId='" + accountId + '\'' +
                    ", profileId='" + profileId + '\'' +
                    ", email='" + email + '\'' +
                    ", newYorkState=" + newYorkState +
                    ", userReport=" + userReport.toString() +
                    ", jsonHelper=" + jsonHelper +
                    '}';
        }

        /**
         * The {@code UserReport} class is useful to obtain and format UserReport object for Report
         * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
         *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
         * **/
        public static class UserReport extends UserDetails {

            /**
             * {@code oauthClient} is instance that memorizes oauth client value
             * **/
            private final String oauthClient;

            /** Constructor to init {@link UserReport} object
             * @param createdAt: created at value
             * @param activeAt: active at value
             * @param id: identifier value
             * @param name: name value
             * @param email: email value
             * @param isBanned: flag if account is banned
             * @param userType: user type value
             * @param fullFillsNewRequirements: flag for full fills new requirements
             * @param hasDefault: flag for default check
             * @param jsonUser: useful to help to format JSON
             * @param oauthClient: oauth client value
             * **/
            public UserReport(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                              String userType, boolean fullFillsNewRequirements, String oauthClient, boolean hasDefault,
                              JsonHelper jsonUser) {
                super(createdAt, activeAt, id, name, email, isBanned, userType, fullFillsNewRequirements, hasDefault,
                        jsonUser);
                this.oauthClient = oauthClient;
            }

            /** Constructor to init a {@link UserReport} object
             * @param userReport: user report report details as {@link JSONObject}
             * **/
            public UserReport(JSONObject userReport) {
                super(userReport);
                this.oauthClient = hUser.getString("oauth_client");
            }

            public JSONObject getRoles() {
                return hUser.getJSONObject("roles");
            }

            public JSONObject getDetails() {
                return hUser.getJSONObject("details");
            }

            public String getOauthClient() {
                return oauthClient;
            }

            @Override
            public String toString() {
                return "UserReport{" +
                        "oauthClient='" + oauthClient + '\'' +
                        ", createdAt='" + createdAt + '\'' +
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

}
