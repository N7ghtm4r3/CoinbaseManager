package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records;

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

}
