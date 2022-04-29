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

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public String getExpiresAt() {
        return expiresAt;
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

    public String getUserId() {
        return userId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public ReportParams getReportParams() {
        return reportParams;
    }

    public String getFileCount() {
        return fileCount;
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

        public ReportUser getReportUser() {
            return reportUser;
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

            public ReportUser(String createdAt, String activeAt, String id, String name, String email, String roles,
                              boolean isBanned, String permissions, String userType, boolean fullFillsNewRequirements,
                              String flags, String details, String oauthClient, ArrayList<ReportPreference> reportPreferences,
                              boolean hasDefault) {
                this.createdAt = createdAt;
                this.activeAt = activeAt;
                this.id = id;
                this.name = name;
                this.email = email;
                this.roles = roles;
                this.isBanned = isBanned;
                this.permissions = permissions;
                this.userType = userType;
                this.fullFillsNewRequirements = fullFillsNewRequirements;
                this.flags = flags;
                this.details = details;
                this.oauthClient = oauthClient;
                this.reportPreferences = reportPreferences;
                this.hasDefault = hasDefault;
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

            public String getRoles() {
                return roles;
            }

            public boolean isBanned() {
                return isBanned;
            }

            public String getPermissions() {
                return permissions;
            }

            public String getUserType() {
                return userType;
            }

            public boolean isFullFillsNewRequirements() {
                return fullFillsNewRequirements;
            }

            public String getFlags() {
                return flags;
            }

            public String getDetails() {
                return details;
            }

            public String getOauthClient() {
                return oauthClient;
            }

            public ArrayList<ReportPreference> getReportPreferences() {
                return reportPreferences;
            }

            public boolean isHasDefault() {
                return hasDefault;
            }

            public static class ReportPreference{

                private final String preferredMarket;
                private final String marginTermsCompletedUTC;
                private final String marginTutorialCompletedUtc;

                public ReportPreference(String preferredMarket, String marginTermsCompletedUTC,
                                        String marginTutorialCompletedUtc) {
                    this.preferredMarket = preferredMarket;
                    this.marginTermsCompletedUTC = marginTermsCompletedUTC;
                    this.marginTutorialCompletedUtc = marginTutorialCompletedUtc;
                }

                public String getPreferredMarket() {
                    return preferredMarket;
                }

                public String getMarginTermsCompletedUTC() {
                    return marginTermsCompletedUTC;
                }

                public String getMarginTutorialCompletedUtc() {
                    return marginTutorialCompletedUtc;
                }

            }

        }

    }

}
