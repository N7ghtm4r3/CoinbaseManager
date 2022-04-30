package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records;

import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import org.json.JSONObject;

public class Report extends ReportDetails{

    public static final String FILLS_REPORT_TYPE = "fills";
    public static final String ACCOUNT_REPORT_TYPE = "account";
    public static final String OTC_FILLS_REPORT_TYPE = "otc_fills";
    public static final String REPORT_TYPE_1099K = "type_1099k_transaction_history";
    public static final String TAX_INVOICE_REPORT_TYPE = "tax_invoice";

    private final String createdAt;
    private final String completedAt;
    private final String expiresAt;
    private final String userId;
    private final String fileUrl;
    private final ParamsReport paramsReport;
    private final JsonHelper jsonHelper;

    public Report(String createdAt, String completedAt, String expiresAt, String id, String type, String status,
                  String userId, String fileUrl, JsonHelper jsonHelper) {
        super(id, type, status);
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.expiresAt = expiresAt;
        this.userId = userId;
        this.fileUrl = fileUrl;
        this.jsonHelper = jsonHelper;
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

    public static class ParamsReport {

        private final String startDate;
        private final String endDate;
        private final String format;
        private final String productId;
        private final String accountId;
        private final String profileId;
        private final String email;
        private final boolean newYorkState;
        private final UserReport userReport;
        private final JsonHelper jsonHelper;

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
            this.jsonHelper = jsonHelper;
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

        public static class UserReport extends UserDetails{

            private final String oauthClient;

            public UserReport(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                              String userType, boolean fullFillsNewRequirements, String oauthClient, boolean hasDefault,
                              JsonHelper jsonUser) {
                super(createdAt, activeAt, id, name, email, isBanned, userType, fullFillsNewRequirements, hasDefault,
                        jsonUser);
                this.oauthClient = oauthClient;
            }

            public JSONObject getRoles() {
                return jsonUser.getJSONObject("roles");
            }

            public JSONObject getDetails() {
                return jsonUser.getJSONObject("details");
            }

            public String getOauthClient() {
                return oauthClient;
            }

        }

    }

}
