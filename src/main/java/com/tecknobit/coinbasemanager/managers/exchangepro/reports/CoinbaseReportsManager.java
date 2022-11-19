package com.tecknobit.coinbasemanager.managers.exchangepro.reports;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager;
import com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.Report;
import com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.ReportDetails;
import com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.ReportDetails.ReportType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.*;
import static com.tecknobit.coinbasemanager.constants.EndpointsList.REPORTS_ENDPOINT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.CoinbaseManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.ReportDetails.Format;
import static com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.ReportDetails.ReportType.*;

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
     * @return all reports list as {@link ArrayList} of {@link Report}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     * Get all reports</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ArrayList<Report> getAllReports(ReportType type) throws Exception {
        return getAllReports(type, LIBRARY_OBJECT);
    }

    /**
     * Request to get all reports
     *
     * @param type:   type of report from fetch details
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return all reports list as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     * Get all reports</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T getAllReports(ReportType type, ReturnFormat format) throws Exception {
        return returnReportsList(sendAPIRequest(REPORTS_ENDPOINT + "?=type" + type, GET_METHOD), format);
    }

    /**
     * Request to get all reports
     *
     * @param type:        type of report from fetch details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> filter results by a specific profile_id - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "ignore_expired"} -> ignore expired results - [boolean]
     *                          </li>
     *                     </ul>
     * @return all reports as {@link ArrayList} of {@link Report}
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     * Get all reports</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ArrayList<Report> getAllReports(ReportType type, Params queryParams) throws Exception {
        return getAllReports(type, queryParams, LIBRARY_OBJECT);
    }

    /**
     * Request to get all reports
     *
     * @param type:        type of report from fetch details
     * @param queryParams: query params of request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "limit"} -> limit on number of results to return - [integer]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> filter results by a specific profile_id - [string]
     *                          </li>
     *                          <li>
     *                              {@code "after"} -> used for pagination. Sets end cursor to after date - [string]
     *                          </li>
     *                          <li>
     *                              {@code "ignore_expired"} -> ignore expired results - [boolean]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return all reports as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreports-1">
     * Get all reports</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T getAllReports(ReportType type, Params queryParams, ReturnFormat format) throws Exception {
        queryParams.addParam("type", type);
        return returnReportsList(sendAPIRequest(REPORTS_ENDPOINT + queryParams.createQueryString(), GET_METHOD),
                format);
    }

    /**
     * MethodId to create a reports list
     *
     * @param reportsResponse: reports list response to format
     * @param format:          return type formatter -> {@link ReturnFormat}
     * @return reports response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnReportsList(String reportsResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONArray(reportsResponse);
            case LIBRARY_OBJECT:
                ArrayList<Report> reports = new ArrayList<>();
                JSONArray jReports = new JSONArray(reportsResponse);
                for (int j = 0; j < jReports.length(); j++)
                    reports.add(new Report(jReports.getJSONObject(j)));
                return (T) reports;
            default:
                return (T) reportsResponse;
        }
    }

    /**
     * Request to create a general report
     *
     * @param type: type of report to create
     * @return result of creation of the general report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createGeneralReport(ReportType type) throws Exception {
        return createGeneralReport(type, LIBRARY_OBJECT);
    }

    /**
     * Request to create a general report
     *
     * @param type:   type of report to create
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return result of creation of the general report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T createGeneralReport(ReportType type, ReturnFormat format) throws Exception {
        Params payload = new Params();
        payload.addParam("type", type);
        return returnReportDetails(sendJSONPayloadedRequest(REPORTS_ENDPOINT, PUT_METHOD, payload), format);
    }

    /**
     * Request to create a general report
     *
     * @param type:        type of report to create
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @return result of creation of the general report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createGeneralReport(ReportType type, Params extraParams) throws Exception {
        return createGeneralReport(type, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to create a general report
     *
     * @param type:        type of report to create
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return result of creation of the general report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T createGeneralReport(ReportType type, Params extraParams, ReturnFormat format) throws Exception {
        Params payload = new Params();
        payload.addParam("type", type);
        payload.mergeParams(extraParams);
        return returnReportDetails(sendJSONPayloadedRequest(REPORTS_ENDPOINT, PUT_METHOD, payload), format);
    }

    /**
     * Request to create a {@link ReportType#_1099k_transaction_history} report
     *
     * @param year: year to create report
     * @return result of creation of {@link ReportType#_1099k_transaction_history} report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails create1099KReport(int year) throws Exception {
        return create1099KReport(year, LIBRARY_OBJECT);
    }

    /**
     * Request to create a {@link ReportType#_1099k_transaction_history} report
     *
     * @param year:   year to create report
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return result of creation of {@link ReportType#_1099k_transaction_history} report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T create1099KReport(int year, ReturnFormat format) throws Exception {
        return returnReportDetails(sendJSONPayloadedRequest(REPORTS_ENDPOINT, PUT_METHOD, assemble1099KPayload(year)),
                format);
    }

    /**
     * Request to create a {@link ReportType#_1099k_transaction_history} report
     *
     * @param year:        year to create report
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @return result of creation of {@link ReportType#_1099k_transaction_history} report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails create1099KReport(int year, Params extraParams) throws Exception {
        return create1099KReport(year, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to create a {@link ReportType#_1099k_transaction_history} report
     *
     * @param year:        year to create report
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return result of creation of {@link ReportType#_1099k_transaction_history} report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T create1099KReport(int year, Params extraParams, ReturnFormat format) throws Exception {
        Params payload = assemble1099KPayload(year);
        payload.mergeParams(extraParams);
        return returnReportDetails(sendJSONPayloadedRequest(REPORTS_ENDPOINT, PUT_METHOD, payload), format);
    }

    /**
     * MethodId to create a payload for {@linkplain #assemble1099KPayload(int)} method
     *
     * @param year: year to create report
     * @return a payload as {@link Params}
     **/
    private Params assemble1099KPayload(int year) {
        Params payload = new Params();
        payload.addParam("type", _1099k_transaction_history);
        payload.addParam(_1099k_transaction_history.toString(), new JSONObject().put("year", year));
        return payload;
    }

    /**
     * Request to create a {@link ReportType#fills} report
     *
     * @param productId: product identifier to create report
     * @return result of creation of {@link ReportType#fills} report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createFillsReport(String productId) throws Exception {
        return createFillsReport(productId, LIBRARY_OBJECT);
    }

    /**
     * Request to create a {@link ReportType#fills} report
     *
     * @param productId: product identifier to create report
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return result of creation of {@link ReportType#fills} report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T createFillsReport(String productId, ReturnFormat format) throws Exception {
        return returnReportDetails(sendPayloadedRequest(REPORTS_ENDPOINT, POST_METHOD, assembleFillsPayload(productId)),
                format);
    }

    /**
     * Request to create a {@link ReportType#fills} report
     *
     * @param productId:   product identifier to create report
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @return result of creation of {@link ReportType#fills} report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createFillsReport(String productId, Params extraParams) throws Exception {
        return createFillsReport(productId, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to create a {@link ReportType#fills} report
     *
     * @param productId:   product identifier to create report
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return result of creation of {@link ReportType#fills} report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T createFillsReport(String productId, Params extraParams, ReturnFormat format) throws Exception {
        Params payload = assembleFillsPayload(productId);
        payload.mergeParams(extraParams);
        return returnReportDetails(sendPayloadedRequest(REPORTS_ENDPOINT, POST_METHOD, payload), format);
    }

    /**
     * MethodId to create a payload for {@linkplain #assembleFillsPayload(String)}} method
     *
     * @param productId: product identifier to create report
     * @return a payload as {@link Params}
     **/
    private Params assembleFillsPayload(String productId) {
        Params params = new Params();
        params.addParam("type", fills);
        params.addParam(fills.toString(), new JSONObject().put("product_id", productId));
        return params;
    }

    /**
     * Request to create a {@link ReportType#account} report
     *
     * @param accountId: account identifier to create report
     * @return result of creation of {@link ReportType#account} report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createAccountReport(String accountId) throws Exception {
        return createAccountReport(accountId, LIBRARY_OBJECT);
    }

    /**
     * Request to create a {@link ReportType#account} report
     *
     * @param accountId: account identifier to create report
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return result of creation of {@link ReportType#account} report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T createAccountReport(String accountId, ReturnFormat format) throws Exception {
        return returnReportDetails(sendPayloadedRequest(REPORTS_ENDPOINT, POST_METHOD, assembleAccountPayload(accountId)),
                format);
    }

    /**
     * Request to create a {@link ReportType#account} report
     *
     * @param accountId:   account identifier to create report
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @return result of creation of {@link ReportType#account} report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createAccountReport(String accountId, Params extraParams) throws Exception {
        return createAccountReport(accountId, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to create a {@link ReportType#account} report
     *
     * @param accountId:   account identifier to create report
     * @param extraParams: extra params of the request, keys accepted are:
     *                     <ul>
     *                          <li>
     *                              {@code "start_date"} -> start date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "end_date"} -> end date for items to be included in report - [string]
     *                          </li>
     *                          <li>
     *                              {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                          </li>
     *                          <li>
     *                              {@code "email"} -> email to send generated report notification to - [string]
     *                          </li>
     *                          <li>
     *                              {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                              is linked to the API key - [string]
     *                          </li>
     *                     </ul>
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return result of creation of {@link ReportType#account} report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @WrappedRequest
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createAccountReport(String accountId, Params extraParams, ReturnFormat format) throws Exception {
        Params params = assembleAccountPayload(accountId);
        params.mergeParams(extraParams);
        return returnReportDetails(sendJSONPayloadedRequest(REPORTS_ENDPOINT, POST_METHOD, params), format);
    }

    /**
     * Request to create a general report
     *
     * @param dateTime:       designated date and time of the balance statement. Timezone is always UTC. If this field is empty,
     *                        a report of the user’s current balance will be generated
     * @param groupByProfile: not applicable if generating report through an API key; only available through report generation
     *                        via the Exchange user interface (UI)
     * @return result of creation of the general report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createBalanceReport(String dateTime, boolean groupByProfile) throws Exception {
        return createBalanceReport(dateTime, groupByProfile, new Params(), LIBRARY_OBJECT);
    }

    /**
     * Request to create a general report
     *
     * @param dateTime:       designated date and time of the balance statement. Timezone is always UTC. If this field is empty,
     *                        a report of the user’s current balance will be generated
     * @param groupByProfile: not applicable if generating report through an API key; only available through report generation
     *                        via the Exchange user interface (UI)
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @return result of creation of the general report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T createBalanceReport(String dateTime, boolean groupByProfile, ReturnFormat format) throws Exception {
        return createBalanceReport(dateTime, groupByProfile, new Params(), format);
    }

    /**
     * Request to create a general report
     *
     * @param dateTime:       designated date and time of the balance statement. Timezone is always UTC. If this field is empty,
     *                        a report of the user’s current balance will be generated
     * @param groupByProfile: not applicable if generating report through an API key; only available through report generation
     *                        via the Exchange user interface (UI)
     * @param extraParams:    extra params of the request, keys accepted are:
     *                        <ul>
     *                             <li>
     *                                 {@code "start_date"} -> start date for items to be included in report - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "end_date"} -> end date for items to be included in report - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "email"} -> email to send generated report notification to - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                                 is linked to the API key - [string]
     *                             </li>
     *                        </ul>
     * @return result of creation of the general report as {@link ReportDetails} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public ReportDetails createBalanceReport(String dateTime, boolean groupByProfile, Params extraParams) throws Exception {
        return createBalanceReport(dateTime, groupByProfile, extraParams, LIBRARY_OBJECT);
    }

    /**
     * Request to create a general report
     *
     * @param dateTime:       designated date and time of the balance statement. Timezone is always UTC. If this field is empty,
     *                        a report of the user’s current balance will be generated
     * @param groupByProfile: not applicable if generating report through an API key; only available through report generation
     *                        via the Exchange user interface (UI)
     * @param extraParams:    extra params of the request, keys accepted are:
     *                        <ul>
     *                             <li>
     *                                 {@code "start_date"} -> start date for items to be included in report - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "end_date"} -> end date for items to be included in report - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "format"} -> format value, constants available at {@link Format} - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "email"} -> email to send generated report notification to - [string]
     *                             </li>
     *                             <li>
     *                                 {@code "profile_id"} -> if this field is specified, it must be the profile_id that
     *                                 is linked to the API key - [string]
     *                             </li>
     *                        </ul>
     * @param format:         return type formatter -> {@link ReturnFormat}
     * @return result of creation of the general report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postreports-1">
     * Create a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports")
    public <T> T createBalanceReport(String dateTime, boolean groupByProfile, Params extraParams,
                                     ReturnFormat format) throws Exception {
        extraParams.addParam(balance.toString(), new JSONObject()
                .put("datetime", dateTime)
                .put("group_by_profile", groupByProfile));
        return createGeneralReport(balance, extraParams, format);
    }

    /**
     * MethodId to create a payload for {@linkplain #assembleAccountPayload(String)} method
     *
     * @param accountId: account identifier to create report
     * @return a payload as {@link Params}
     **/
    private Params assembleAccountPayload(String accountId) {
        Params params = new Params();
        params.addParam("type", account);
        params.addParam(account.toString(), new JSONObject().put("account_id", accountId));
        return params;
    }

    /**
     * MethodId to create a report details object
     *
     * @param reportDetailsResponse: report details to format
     * @param format:                return type formatter -> {@link ReturnFormat}
     * @return report details response as {@code "format"} defines
     **/
    @Returner
    private <T> T returnReportDetails(String reportDetailsResponse, ReturnFormat format) {
        switch (format) {
            case JSON:
                return (T) new JSONObject(reportDetailsResponse);
            case LIBRARY_OBJECT:
                return (T) new ReportDetails(new JSONObject(reportDetailsResponse));
            default:
                return (T) reportDetailsResponse;
        }
    }

    /**
     * Request to get specific report
     *
     * @param reportId: identifier of report to fetch
     * @return specific report as {@link Report} custom object
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1">
     * Get a report</a>
     **/
    @RequestPath(path = "https://api.exchange.coinbase.com/reports/{report_id}")
    public Report getReport(String reportId) throws Exception {
        return getReport(reportId, LIBRARY_OBJECT);
    }

    /**
     * Request to get specific report
     *
     * @param reportId: identifier of report to fetch
     * @param format:   return type formatter -> {@link ReturnFormat}
     * @return specific report as {@code "format"} defines
     * @throws Exception when request has been go wrong -> you can use these methods to get more details about error:
     *                   <ul>
     *                       <li>
     *                           {@link #getErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #getJSONErrorResponse()}
     *                       </li>
     *                       <li>
     *                           {@link #printErrorResponse()}
     *                       </li>
     *                   </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getreport-1">
     * Get a report</a>
     **/
    @Returner
    @RequestPath(path = "https://api.exchange.coinbase.com/reports/{report_id}")
    public <T> T getReport(String reportId, ReturnFormat format) throws Exception {
        String reportResponse = sendAPIRequest(REPORTS_ENDPOINT + "/" + reportId, GET_METHOD);
        switch (format) {
            case JSON:
                return (T) new JSONObject(reportResponse);
            case LIBRARY_OBJECT:
                return (T) new Report(new JSONObject(reportResponse));
            default:
                return (T) reportResponse;
        }
    }

}
