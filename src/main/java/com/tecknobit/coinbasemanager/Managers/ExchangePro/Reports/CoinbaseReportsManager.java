package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports;

import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records.Report;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records.ReportDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.*;
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

    public String createGeneralReport(String type) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", type);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    public JSONObject createGeneralReportJSON(String type) throws Exception {
        return new JSONObject(createGeneralReport(type));
    }

    public ReportDetails createGeneralReportObject(String type) throws Exception {
        return assembleReportDetails(new JSONObject(createGeneralReport(type)));
    }

    public String createGeneralReport(String type, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", type);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    public JSONObject createGeneralReportJSON(String type, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(createGeneralReport(type, extraBodyParams));
    }

    public ReportDetails createGeneralReportObject(String type, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(createGeneralReport(type, extraBodyParams)));
    }

    public String create1099KReport(int year) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, assemble1099KPayload(year));
    }

    public JSONObject create1099KReportJSON(int year) throws Exception {
        return new JSONObject(create1099KReport(year));
    }

    public ReportDetails create1099KReportObject(int year) throws Exception {
        return assembleReportDetails(new JSONObject(create1099KReport(year)));
    }

    public String create1099KReport(int year, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assemble1099KPayload(year);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    public JSONObject create1099KReportJSON(int year, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(create1099KReport(year, extraBodyParams));
    }

    public ReportDetails create1099KReportObject(int year, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(create1099KReport(year, extraBodyParams)));
    }

    private HashMap<String, Object> assemble1099KPayload(int year){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", Report.REPORT_TYPE_1099K);
        bodyParams.put("year", year);
        return bodyParams;
    }

    public String createFillsReport(String productId) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, assembleFillsPayload(productId));
    }

    public JSONObject createFillsReportJSON(String productId) throws Exception {
        return new JSONObject(createFillsReport(productId));
    }

    public ReportDetails createFillsReportObject(String productId) throws Exception {
        return assembleReportDetails(new JSONObject(createFillsReport(productId)));
    }

    public String createFillsReport(String productId, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleFillsPayload(productId);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createFillsReportJSON(String productId, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(createFillsReport(productId, extraBodyParams));
    }

    public ReportDetails createFillsReportObject(String productId, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(createFillsReport(productId, extraBodyParams)));
    }

    private HashMap<String, Object> assembleFillsPayload(String productId){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", Report.FILLS_REPORT_TYPE);
        bodyParams.put("product_id", productId);
        return bodyParams;
    }

    public String createAccountReport(String accountId) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, assembleAccountPayload(accountId));
    }

    public JSONObject createAccountReportReportJSON(String accountId) throws Exception {
        return new JSONObject(createAccountReport(accountId));
    }

    public ReportDetails createAccountReportObject(String accountId) throws Exception {
        return assembleReportDetails(new JSONObject(createAccountReport(accountId)));
    }

    public String createAccountReport(String accountId, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleAccountPayload(accountId);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, bodyParams);
    }

    public JSONObject createAccountReportJSON(String accountId, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(createAccountReport(accountId, extraBodyParams));
    }

    public ReportDetails createAccountReportObject(String accountId, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(createAccountReport(accountId, extraBodyParams)));
    }

    private HashMap<String, Object> assembleAccountPayload(String accountId){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", Report.FILLS_REPORT_TYPE);
        bodyParams.put("account_id", accountId);
        return bodyParams;
    }

    private ReportDetails assembleReportDetails(JSONObject jsonReport){
        return new ReportDetails(jsonReport.getString("id"),
                jsonReport.getString("type"),
                jsonReport.getString("status")
        );
    }

    public String getReport(String reportId) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + "/" + reportId, GET_METHOD);
    }

    public JSONObject getReportJSON(String reportId) throws Exception {
        return new JSONObject(getReport(reportId));
    }

    public Report getReportObject(String reportId) throws Exception {
        return assembleReportObject(new JSONObject(getReport(reportId)));
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
