package com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.CoinbaseManager;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records.Report;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records.ReportDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.Manager.APIRequest.*;
import static com.tecknobit.coinbasemanager.Constants.EndpointsList.REPORTS_ENDPOINT;

/**
 * The {@code CoinbaseReportsManager} class is useful to manage all Coinbase reports endpoints
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CoinbaseReportsManager extends CoinbaseManager {

    /** Constructor to init a {@link CoinbaseReportsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /** Constructor to init a {@link CoinbaseReportsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param timeout: custom timeout for request
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /** Constructor to init a {@link CoinbaseReportsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /** Constructor to init a {@link CoinbaseReportsManager}
     * @param apiKey: your Coinbase api key
     * @param apiSecret: your Coinbase api secret
     * @param passphrase: your Coinbase api passphrase
     * **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports</a>
     * @return all reports as {@link String}
     * **/
    public String getAllReports(String type) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + "?=type" + type, GET_METHOD);
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports</a>
     * @return all reports as {@link JSONArray}
     * **/
    public JSONArray getAllReportsJSON(String type) throws Exception {
        return new JSONArray(getAllReports(type));
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports</a>
     * @return all reports list as {@link ArrayList} of {@link Report}
     * **/
    public ArrayList<Report> getAllReportsList(String type) throws Exception {
        return assembleReportsList(new JSONArray(getAllReports(type)));
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are portfolio_id,after,limit,ignore_expired)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports</a>
     * @return all reports as {@link String}
     * **/
    public String getAllReports(String type, HashMap<String, Object> queryParams) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + assembleQueryParams("?=type" + type, queryParams), GET_METHOD);
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are portfolio_id,after,limit,ignore_expired)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports</a>
     * @return all reports as {@link JSONArray}
     * **/
    public JSONArray getAllReportsJSON(String type, HashMap<String, Object> queryParams) throws Exception {
        return new JSONArray(getAllReports(type, queryParams));
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are portfolio_id,after,limit,ignore_expired)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports</a>
     * @return all reports as {@link ArrayList} of {@link Report}
     * **/
    public ArrayList<Report> getAllReportsList(String type, HashMap<String, Object> queryParams) throws Exception {
        return assembleReportsList(new JSONArray(getAllReports(type, queryParams)));
    }

    /** Method to assemble a reports list
     * @param jsonReports: jsonArray obtained by response request
     * return reports list as {@link ArrayList} of {@link Report}
     * **/
    private ArrayList<Report> assembleReportsList(JSONArray jsonReports){
        ArrayList<Report> reports = new ArrayList<>();
        for (int j=0; j < jsonReports.length(); j++)
            reports.add(assembleReportObject(jsonReports.getJSONObject(j)));
        return reports;
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of general report as {@link String}
     * **/
    public String createGeneralReport(String type) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", type);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of general report as {@link JSONObject}
     * **/
    public JSONObject createGeneralReportJSON(String type) throws Exception {
        return new JSONObject(createGeneralReport(type));
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of general report as {@link ReportDetails} object
     * **/
    public ReportDetails createGeneralReportObject(String type) throws Exception {
        return assembleReportDetails(new JSONObject(createGeneralReport(type)));
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,year,format,product_id,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of general report as {@link String}
     * **/
    public String createGeneralReport(String type, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", type);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,year,format,product_id,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of general report as {@link JSONObject}
     * **/
    public JSONObject createGeneralReportJSON(String type, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(createGeneralReport(type, extraBodyParams));
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,year,format,product_id,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of general report as {@link ReportDetails} object
     * **/
    public ReportDetails createGeneralReportObject(String type, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(createGeneralReport(type, extraBodyParams)));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link String}
     * **/
    public String create1099KReport(int year) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, assemble1099KPayload(year));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link JSONObject}
     * **/
    public JSONObject create1099KReportJSON(int year) throws Exception {
        return new JSONObject(create1099KReport(year));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link ReportDetails} object
     * **/
    public ReportDetails create1099KReportObject(int year) throws Exception {
        return assembleReportDetails(new JSONObject(create1099KReport(year)));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,product_id,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link String}
     * **/
    public String create1099KReport(int year, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assemble1099KPayload(year);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,product_id,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link JSONObject}
     * **/
    public JSONObject create1099KReportJSON(int year, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(create1099KReport(year, extraBodyParams));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,product_id,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link ReportDetails} object
     * **/
    public ReportDetails create1099KReportObject(int year, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(create1099KReport(year, extraBodyParams)));
    }

    /** Method to assemble map of body params for {@linkplain #assemble1099KPayload(int)} method
     * @param year: year to create report
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private HashMap<String, Object> assemble1099KPayload(int year){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", Report.REPORT_TYPE_1099K);
        bodyParams.put("year", year);
        return bodyParams;
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link String}
     * **/
    public String createFillsReport(String productId) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, assembleFillsPayload(productId));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createFillsReportJSON(String productId) throws Exception {
        return new JSONObject(createFillsReport(productId));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link ReportDetails} object
     * **/
    public ReportDetails createFillsReportObject(String productId) throws Exception {
        return assembleReportDetails(new JSONObject(createFillsReport(productId)));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,year,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link String}
     * **/
    public String createFillsReport(String productId, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleFillsPayload(productId);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,year,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createFillsReportJSON(String productId, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(createFillsReport(productId, extraBodyParams));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,year,account_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link ReportDetails} object
     * **/
    public ReportDetails createFillsReportObject(String productId, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(createFillsReport(productId, extraBodyParams)));
    }

    /** Method to assemble map of body params for {@linkplain #assembleFillsPayload(String)}} method
     * @param productId: product identifier to create report
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private HashMap<String, Object> assembleFillsPayload(String productId){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", Report.FILLS_REPORT_TYPE);
        bodyParams.put("product_id", productId);
        return bodyParams;
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link String}
     * **/
    public String createAccountReport(String accountId) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, assembleAccountPayload(accountId));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createAccountReportReportJSON(String accountId) throws Exception {
        return new JSONObject(createAccountReport(accountId));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link ReportDetails} object
     * **/
    public ReportDetails createAccountReportObject(String accountId) throws Exception {
        return assembleReportDetails(new JSONObject(createAccountReport(accountId)));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,year,product_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link String}
     * **/
    public String createAccountReport(String accountId, HashMap<String, Object> extraBodyParams) throws Exception {
        HashMap<String, Object> bodyParams = assembleAccountPayload(accountId);
        bodyParams.putAll(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,year,product_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createAccountReportJSON(String accountId, HashMap<String, Object> extraBodyParams) throws Exception {
        return new JSONObject(createAccountReport(accountId, extraBodyParams));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date,end_date,format,year,product_id,email,profile_id)
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link ReportDetails} object
     * **/
    public ReportDetails createAccountReportObject(String accountId, HashMap<String, Object> extraBodyParams) throws Exception {
        return assembleReportDetails(new JSONObject(createAccountReport(accountId, extraBodyParams)));
    }

    /** Method to assemble map of body params for {@linkplain #assembleAccountPayload(String)} method
     * @param accountId: account identifier to create report
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private HashMap<String, Object> assembleAccountPayload(String accountId){
        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("type", Report.FILLS_REPORT_TYPE);
        bodyParams.put("account_id", accountId);
        return bodyParams;
    }

    /** Method to assemble report details object
     * @param jsonReport: report details in JSON format
     * @return {@link ReportDetails} object
     * **/
    private ReportDetails assembleReportDetails(JSONObject jsonReport){
        return new ReportDetails(jsonReport.getString("id"),
                jsonReport.getString("type"),
                jsonReport.getString("status")
        );
    }

    /** Request to get specific report
     * @param reportId: identifier of report to fetch
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport</a>
     * @return specific report as {@link String}
     * **/
    public String getReport(String reportId) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + "/" + reportId, GET_METHOD);
    }

    /** Request to get specific report
     * @param reportId: identifier of report to fetch
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport</a>
     * @return specific report as {@link JSONObject}
     * **/
    public JSONObject getReportJSON(String reportId) throws Exception {
        return new JSONObject(getReport(reportId));
    }

    /** Request to get specific report
     * @param reportId: identifier of report to fetch
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport</a>
     * @return specific report as {@link Report} object
     * **/
    public Report getReportObject(String reportId) throws Exception {
        return assembleReportObject(new JSONObject(getReport(reportId)));
    }

    /** Method to assemble a Report object
     * @param jsonReport: jsonObject obtained by response request
     * @return report as {@link Report} object
     * **/
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
