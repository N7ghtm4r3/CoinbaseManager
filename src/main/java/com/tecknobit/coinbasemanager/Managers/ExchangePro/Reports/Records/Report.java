package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records;

import java.util.ArrayList;

public class Report {

    public static final String FILLS_REPORT_TYPE = "fills";
    public static final String ACCOUNT_REPORT_TYPE = "account";
    public static final String OTC_FILLS_REPORT_TYPE = "otc_fills";
    public static final String REPORT_TYPE_1099K = "type_1099k_transaction_history";
    public static final String TAX_INVOICE_REPORT_TYPE = "tax_invoice";

    private final String createdAt;
    private final String completedAt;
    private final String expiresAt;
    private final String id;
    private final String type;
    private final String status;
    private final String userId;
    private final String fileUrl;
    private final ReportParams reportParams;
    private final String fileCount;

    public Report(String createdAt, String completedAt, String expiresAt, String id, String type, String status,
                  String userId, String fileUrl, ReportParams reportParams, String fileCount) {
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.expiresAt = expiresAt;
        this.id = id;
        this.type = type;
        this.status = status;
        this.userId = userId;
        this.fileUrl = fileUrl;
        this.reportParams = reportParams;
        this.fileCount = fileCount;
    }

    public static class ReportParams{

        private final String startDate;
        private final String endDate;
        private final String format;
        private final String productId;
        private final String accountId;
        private final String profileId;
        private final String email;
        private final boolean newYorkState;
        private final ReportUser reportUser;

        public ReportParams(String startDate, String endDate, String format, String productId, String accountId,
                            String profileId, String email, boolean newYorkState, ReportUser reportUser) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.format = format;
            this.productId = productId;
            this.accountId = accountId;
            this.profileId = profileId;
            this.email = email;
            this.newYorkState = newYorkState;
            this.reportUser = reportUser;
        }

        public static class ReportUser{

            private final String createdAt;
            private final String activeAt;
            private final String id;
            private final String name;
            private final String email;
            private final String roles;
            private final boolean isBanned;
            private final String permissions;
            private final String userType;
            private final boolean fullFillsNewRequirements;
            private final String flags;
            private final String details;
            private final String oauthClient;
            private final ArrayList<ReportPreference> reportPreferences;
            private final boolean hasDefault;

            public static class ReportPreference{
                
            }

        }

    }

}
