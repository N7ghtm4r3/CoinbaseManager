package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports;

import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records.Report;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.GET_METHOD;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.REPORTS_ENDPOINT;

public class CoinbaseReportsManager extends CoinbaseManager {

    /** Constructor to init a CoinbaseReports manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a CoinbaseReports manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #timeout custom timeout for request
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a CoinbaseReports manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * @param #defaultErrorMessage custom error to show when is not a request error
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a CoinbaseReports manager
     * @param #apiKey your Coinbase api key
     * @param #apiSecret your Coinbase api secret
     * @param #passphrase your Coinbase api passphrase
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    public String getAllReports(String type) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + "?=type" + type, GET_METHOD);
    }

    public JSONArray getAllReportsJSON(String type) throws Exception {
        return new JSONArray(getAllReports(type));
    }

    public ArrayList<Report> getAllReportsList(String type) throws Exception {
        return assembleReportsList(new JSONArray(getAllReports(type)));
    }

    public String getAllReports(String type, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + assembleQueryParams("?=type" + type,queryParams), GET_METHOD);
    }

    public JSONArray getAllReportsJSON(String type, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllReports(type, queryParams));
    }

    public ArrayList<Report> getAllReportsList(String type, HashMap<String, Object> queryParams) throws Exception {
        return assembleReportsList(new JSONArray(getAllReports(type, queryParams)));
    }

    private ArrayList<Report> assembleReportsList(JSONArray jsonReports){
        ArrayList<Report> reports = new ArrayList<>();
        for (int j=0; j < jsonReports.length(); j++)
            reports.add(assembleReportObject(jsonReports.getJSONObject(j)));
        return reports;
    }

    private Report assembleReportObject(JSONObject jsonReport){
        return new Report(jsonReport.getString("created_at"),
                jsonReport.getString("completed_at"),
                jsonReport.getString("expires_at"),
                jsonReport.getString("id"),
                jsonReport.getString("type"),
                jsonReport.getString("status"),
                jsonReport.getString("user_id"),
                jsonReport.getString("file_url"),
                new JsonHelper(jsonReport.getJSONObject("params"))
        );
    }

}
