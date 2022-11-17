package com.tecknobit.coinbasemanager.managers.exchangepro.reports;

import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.Report;
import com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.ReportDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tecknobit.apimanager.apis.APIRequest.*;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.REPORTS_ENDPOINT;

/**
 * The {@code CoinbaseReportsManager} class is useful to manage all {@code "Coinbase"} reports endpoints
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
 * Reports manager</a>
 * @see CoinbaseManager
 **/
public class CoinbaseReportsManager extends CoinbaseManager {

    /**
     * Constructor to init a {@link CoinbaseReportsManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     * @param timeout:             custom timeout for request
     **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage, int timeout) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseReportsManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     * @param timeout:    custom timeout for request
     **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, int timeout) {
        super(apiKey, apiSecret, passphrase, timeout);
    }

    /**
     * Constructor to init a {@link CoinbaseReportsManager}
     *
     * @param apiKey:              your {@code "Coinbase"} api key
     * @param apiSecret:           your {@code "Coinbase"} api secret
     * @param passphrase:          your {@code "Coinbase"} api passphrase
     * @param defaultErrorMessage: custom error to show when is not a request error
     **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase, String defaultErrorMessage) {
        super(apiKey, apiSecret, passphrase, defaultErrorMessage);
    }

    /**
     * Constructor to init a {@link CoinbaseReportsManager}
     *
     * @param apiKey:     your {@code "Coinbase"} api key
     * @param apiSecret:  your {@code "Coinbase"} api secret
     * @param passphrase: your {@code "Coinbase"} api passphrase
     **/
    public CoinbaseReportsManager(String apiKey, String apiSecret, String passphrase) {
        super(apiKey, apiSecret, passphrase);
    }

    /**
     * Constructor to init a {@link CoinbaseReportsManager} <br>
     * Any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link CoinbaseManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        CoinbaseManager firstManager = new CoinbaseManager("apiKey", "apiSecret", "passphrase");
     *        //You don't need to insert all credentials to make manager work
     *        CoinbaseManager secondManager = new CoinbaseManager(); //same credentials used
     *     }
     * </pre>
     **/
    public CoinbaseReportsManager() {
        super();
    }

    /**
     * Request to get all reports
     *
     * @param type: type of report from fetch details
     * @return all reports as {@link String}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     **/
    public String getAllReports(String type) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + "?=type" + type, GET_METHOD);
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     * @return all reports as {@link JSONArray}
     * **/
    public JSONArray getAllReportsJSON(String type) throws Exception {
        return new JSONArray(getAllReports(type));
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     * @return all reports list as {@link ArrayList} of {@link Report}
     * **/
    public ArrayList<Report> getAllReportsList(String type) throws Exception {
        return assembleReportsList(new JSONArray(getAllReports(type)));
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are portfolio_id, after, limit, ignore_expired)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     * @return all reports as {@link String}
     * **/
    public String getAllReports(String type, Params queryParams) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + assembleQueryParams("?=type" + type, queryParams), GET_METHOD);
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are portfolio_id, after, limit, ignore_expired)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     * @return all reports as {@link JSONArray}
     * **/
    public JSONArray getAllReportsJSON(String type, Params queryParams) throws Exception {
        return new JSONArray(getAllReports(type, queryParams));
    }

    /** Request to get all reports
     * @param type: type of report from fetch details
     * @param queryParams: query params of request
     * @implSpec (keys accepted are portfolio_id, after, limit, ignore_expired)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1</a>
     * @return all reports as {@link ArrayList} of {@link Report}
     * **/
    public ArrayList<Report> getAllReportsList(String type, Params queryParams) throws Exception {
        return assembleReportsList(new JSONArray(getAllReports(type, queryParams)));
    }

    /** Method to assemble a reports list
     * @param jsonReports: jsonArray obtained by response request
     * return reports list as {@link ArrayList} of {@link Report}
     * **/
    private ArrayList<Report> assembleReportsList(JSONArray jsonReports){
        ArrayList<Report> reports = new ArrayList<>();
        for (int j=0; j < jsonReports.length(); j++)
            reports.add(new Report(jsonReports.getJSONObject(j)));
        return reports;
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of general report as {@link String}
     * **/
    public String createGeneralReport(String type) throws Exception {
        Params bodyParams = new Params();
        bodyParams.addParam("type", type);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    /**
     * Request to create a general report
     *
     * @param type: type of report to create
     * @return result of creation of general report as {@link JSONObject}
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     **/
    public JSONObject createGeneralReportJSON(String type) throws Exception {
        return new JSONObject(createGeneralReport(type));
    }

    /**
     * Request to create a general report
     *
     * @param type: type of report to create
     * @return result of creation of general report as {@link ReportDetails} custom object
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     **/
    public ReportDetails createGeneralReportObject(String type) throws Exception {
        return new ReportDetails(new JSONObject(createGeneralReport(type)));
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, year, format, product_id, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of general report as {@link String}
     * **/
    public String createGeneralReport(String type, Params extraBodyParams) throws Exception {
        Params bodyParams = new Params();
        bodyParams.addParam("type", type);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, year, format, product_id, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of general report as {@link JSONObject}
     * **/
    public JSONObject createGeneralReportJSON(String type, Params extraBodyParams) throws Exception {
        return new JSONObject(createGeneralReport(type, extraBodyParams));
    }

    /** Request to create a general report
     * @param type: type of report to create
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, year, format, product_id, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of general report as {@link ReportDetails} custom object
     * **/
    public ReportDetails createGeneralReportObject(String type, Params extraBodyParams) throws Exception {
        return new ReportDetails(new JSONObject(createGeneralReport(type, extraBodyParams)));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link String}
     * **/
    public String create1099KReport(int year) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, assemble1099KPayload(year));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link JSONObject}
     * **/
    public JSONObject create1099KReportJSON(int year) throws Exception {
        return new JSONObject(create1099KReport(year));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link ReportDetails} custom object
     * **/
    public ReportDetails create1099KReportObject(int year) throws Exception {
        return new ReportDetails(new JSONObject(create1099KReport(year)));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, product_id, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link String}
     * **/
    public String create1099KReport(int year, Params extraBodyParams) throws Exception {
        Params bodyParams = assemble1099KPayload(year);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, PUT_METHOD, bodyParams);
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, product_id, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link JSONObject}
     * **/
    public JSONObject create1099KReportJSON(int year, Params extraBodyParams) throws Exception {
        return new JSONObject(create1099KReport(year, extraBodyParams));
    }

    /** Request to create a {@link Report#REPORT_TYPE_1099K} report
     * @param year: year to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, product_id, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#REPORT_TYPE_1099K} report as {@link ReportDetails} custom object
     * **/
    public ReportDetails create1099KReportObject(int year, Params extraBodyParams) throws Exception {
        return new ReportDetails(new JSONObject(create1099KReport(year, extraBodyParams)));
    }

    /** Method to assemble map of body params for {@linkplain #assemble1099KPayload(int)} method
     * @param year: year to create report
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assemble1099KPayload(int year){
        Params bodyParams = new Params();
        bodyParams.addParam("type", Report.REPORT_TYPE_1099K);
        bodyParams.addParam("year", year);
        return bodyParams;
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link String}
     * **/
    public String createFillsReport(String productId) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, assembleFillsPayload(productId));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createFillsReportJSON(String productId) throws Exception {
        return new JSONObject(createFillsReport(productId));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link ReportDetails} custom object
     * **/
    public ReportDetails createFillsReportObject(String productId) throws Exception {
        return new ReportDetails(new JSONObject(createFillsReport(productId)));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, year, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link String}
     * **/
    public String createFillsReport(String productId, Params extraBodyParams) throws Exception {
        Params bodyParams = assembleFillsPayload(productId);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, year, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createFillsReportJSON(String productId, Params extraBodyParams) throws Exception {
        return new JSONObject(createFillsReport(productId, extraBodyParams));
    }

    /** Request to create a {@link Report#FILLS_REPORT_TYPE} report
     * @param productId: product identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, year, account_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#FILLS_REPORT_TYPE} report as {@link ReportDetails} custom object
     * **/
    public ReportDetails createFillsReportObject(String productId, Params extraBodyParams) throws Exception {
        return new ReportDetails(new JSONObject(createFillsReport(productId, extraBodyParams)));
    }

    /** Method to assemble map of body params for {@linkplain #assembleFillsPayload(String)}} method
     * @param productId: product identifier to create report
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assembleFillsPayload(String productId){
        Params bodyParams = new Params();
        bodyParams.addParam("type", Report.FILLS_REPORT_TYPE);
        bodyParams.addParam("product_id", productId);
        return bodyParams;
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link String}
     * **/
    public String createAccountReport(String accountId) throws Exception {
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, assembleAccountPayload(accountId));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createAccountReportReportJSON(String accountId) throws Exception {
        return new JSONObject(createAccountReport(accountId));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link ReportDetails} custom object
     * **/
    public ReportDetails createAccountReportObject(String accountId) throws Exception {
        return new ReportDetails(new JSONObject(createAccountReport(accountId)));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, year, product_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link String}
     * **/
    public String createAccountReport(String accountId, Params extraBodyParams) throws Exception {
        Params bodyParams = assembleAccountPayload(accountId);
        bodyParams.mergeParams(extraBodyParams);
        return sendBodyParamsAPIRequest(REPORTS_ENDPOINT, POST_METHOD, bodyParams);
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, year, product_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link JSONObject}
     * **/
    public JSONObject createAccountReportJSON(String accountId, Params extraBodyParams) throws Exception {
        return new JSONObject(createAccountReport(accountId, extraBodyParams));
    }

    /** Request to create a {@link Report#ACCOUNT_REPORT_TYPE} report
     * @param accountId: account identifier to create report
     * @param extraBodyParams: query params of request
     * @implSpec (keys accepted are start_date, end_date, format, year, product_id, email, profile_id)
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1</a>
     * @return result of creation of {@link Report#ACCOUNT_REPORT_TYPE} report as {@link ReportDetails} custom object
     * **/
    public ReportDetails createAccountReportObject(String accountId, Params extraBodyParams) throws Exception {
        return new ReportDetails(new JSONObject(createAccountReport(accountId, extraBodyParams)));
    }

    /** Method to assemble map of body params for {@linkplain #assembleAccountPayload(String)} method
     * @param accountId: account identifier to create report
     * @return map of body params as {@link HashMap} <{@link String} ,{@link Object}>
     * **/
    private Params assembleAccountPayload(String accountId){
        Params bodyParams = new Params();
        bodyParams.addParam("type", Report.FILLS_REPORT_TYPE);
        bodyParams.addParam("account_id", accountId);
        return bodyParams;
    }

    /** Request to get specific report
     * @param reportId: identifier of report to fetch
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1</a>
     * @return specific report as {@link String}
     * **/
    public String getReport(String reportId) throws Exception {
        return sendAPIRequest(REPORTS_ENDPOINT + "/" + reportId, GET_METHOD);
    }

    /** Request to get specific report
     * @param reportId: identifier of report to fetch
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1</a>
     * @return specific report as {@link JSONObject}
     * **/
    public JSONObject getReportJSON(String reportId) throws Exception {
        return new JSONObject(getReport(reportId));
    }

    /** Request to get specific report
     * @param reportId: identifier of report to fetch
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1</a>
     * @return specific report as {@link Report} custom object
     * **/
    public Report getReportObject(String reportId) throws Exception {
        return new Report(new JSONObject(getReport(reportId)));
    }

}
