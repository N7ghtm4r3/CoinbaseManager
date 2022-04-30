package com.tecknobit.coinbasemanager.Managers.ExchangePro.Users.Records;

import com.tecknobit.apimanager.Tools.Readers.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records.ReportDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code ExchangeLimits} class is useful to format ExchangeLimits object
 * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class ExchangeLimits extends ReportDetails.UserDetails {

    private final String termsAccepted;
    private ArrayList<Test> testGroups;
    private final Country country;
    private final String stateCode;
    private final boolean accessPrivacyRights;
    private final String twoFactorMethod;
    private final boolean analyticsProcessingEnabled;
    private final boolean isPrime;
    private final boolean hasProWbl;
    private final boolean hasClawBack;
    private final boolean hasClawBackPaymentPending;
    private final boolean hasRestrictedAssets;
    private final String legalName;
    private final boolean whitelistingEnabled;
    private final boolean regionBankingSupport;
    private final String defaultPreferredMarket;
    private final boolean marginEligible;
    private final MarginInformation marginInformation;
    private final Address address;
    private final JsonHelper jsonHelper;

    public ExchangeLimits(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                          String userType, boolean fullFillsNewRequirements, boolean hasDefault, JsonHelper jsonHelper,
                          String termsAccepted, String stateCode,
                          boolean accessPrivacyRights, String twoFactorMethod, boolean analyticsProcessingEnabled,
                          boolean isPrime, boolean hasProWbl, boolean hasClawBack, boolean hasClawBackPaymentPending,
                          boolean hasRestrictedAssets, String legalName, boolean whitelistingEnabled,
                          boolean regionBankingSupport, String defaultPreferredMarket, boolean marginEligible) {
        super(createdAt, activeAt, id, name, email, isBanned, userType, fullFillsNewRequirements, hasDefault, jsonHelper);
        this.termsAccepted = termsAccepted;
        this.stateCode = stateCode;
        this.accessPrivacyRights = accessPrivacyRights;
        this.twoFactorMethod = twoFactorMethod;
        this.analyticsProcessingEnabled = analyticsProcessingEnabled;
        this.isPrime = isPrime;
        this.hasProWbl = hasProWbl;
        this.hasClawBack = hasClawBack;
        this.hasClawBackPaymentPending = hasClawBackPaymentPending;
        this.hasRestrictedAssets = hasRestrictedAssets;
        this.legalName = legalName;
        this.whitelistingEnabled = whitelistingEnabled;
        this.regionBankingSupport = regionBankingSupport;
        this.defaultPreferredMarket = defaultPreferredMarket;
        this.marginEligible = marginEligible;
        this.jsonHelper = jsonHelper;
        assembleTestList(jsonHelper.getJSONArray("test_groups"));
        country = new Country(jsonHelper.getJSONObject("country"));
        marginInformation = new MarginInformation(jsonHelper.getJSONObject("margin_information"));
        address = new Address(jsonHelper.getJSONObject("address"));
    }

    /** Method to assemble a test list
     * @param #jsonTests: jsonArray obtained by response request
     * any params required
     * **/
    private void assembleTestList(JSONArray jsonTests){
        testGroups = new ArrayList<>();
        for (int j=0; j < jsonTests.length(); j++){
            JSONObject test = jsonTests.getJSONObject(j);
            testGroups.add(new Test(test.getString("test"),
                    test.getString("group"),
                    test.getBoolean("forced")
            ));
        }
    }

    public String getTermsAccepted() {
        return termsAccepted;
    }

    public ArrayList<Test> getTestGroups() {
        return testGroups;
    }

    public Country getCountry() {
        return country;
    }

    public String getStateCode() {
        return stateCode;
    }

    public boolean isAccessPrivacyRights() {
        return accessPrivacyRights;
    }

    public String getTwoFactorMethod() {
        return twoFactorMethod;
    }

    public boolean isAnalyticsProcessingEnabled() {
        return analyticsProcessingEnabled;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public boolean isHasProWbl() {
        return hasProWbl;
    }

    public boolean isHasClawBack() {
        return hasClawBack;
    }

    public boolean isHasClawBackPaymentPending() {
        return hasClawBackPaymentPending;
    }

    public boolean isHasRestrictedAssets() {
        return hasRestrictedAssets;
    }

    public String getLegalName() {
        return legalName;
    }

    public boolean isWhitelistingEnabled() {
        return whitelistingEnabled;
    }

    public boolean isRegionBankingSupport() {
        return regionBankingSupport;
    }

    public String getDefaultPreferredMarket() {
        return defaultPreferredMarket;
    }

    public boolean isMarginEligible() {
        return marginEligible;
    }

    public MarginInformation getMarginInformation() {
        return marginInformation;
    }

    public Address getAddress() {
        return address;
    }

    public JsonHelper getJsonHelper() {
        return jsonHelper;
    }

    /**
     * The {@code Test} class is useful to obtain and format Test object for ExchangeLimits
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits
     * **/
    public static class Test{

        private final String test;
        private final String group;
        private final boolean forced;

        public Test(String test, String group, boolean forced) {
            this.test = test;
            this.group = group;
            this.forced = forced;
        }

        public String getTest() {
            return test;
        }

        public String getGroup() {
            return group;
        }

        public boolean isForced() {
            return forced;
        }

    }

    /**
     * The {@code Country} class is useful to obtain and format Country object for ExchangeLimits
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits
     * **/
    public static class Country{

        private final String code;
        private final String name;
        private final boolean isInEurope;

        public Country(String code, String name, boolean isInEurope) {
            this.code = code;
            this.name = name;
            this.isInEurope = isInEurope;
        }

        public Country(JSONObject jsonCountry){
            code = jsonCountry.getString("code");
            name = jsonCountry.getString("name");
            isInEurope = jsonCountry.getBoolean("is_in_europe");
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public boolean isInEurope() {
            return isInEurope;
        }

    }

    /**
     * The {@code Address} class is useful to obtain and format Address object for ExchangeLimits
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits
     * **/
    public static class Address{

        private final String line1;
        private final String city;
        private final String state;
        private final String postalCode;
        private final String code;
        private final String name;

        public Address(String line1, String city, String state, String postalCode, String code, String name) {
            this.line1 = line1;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
            this.code = code;
            this.name = name;
        }

        public Address(JSONObject jsonAddress){
            line1 = jsonAddress.getString("line1");
            city = jsonAddress.getString("city");
            state = jsonAddress.getString("state");
            postalCode = jsonAddress.getString("postal_code");
            JSONObject jsonCountry = jsonAddress.getJSONObject("country");
            code = jsonCountry.getString("code");
            name = jsonCountry.getString("name");
        }

        public String getLine1() {
            return line1;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * The {@code MarginInformation} class is useful to obtain and format MarginInformation object for ExchangeLimits
     * @apiNote see official documentation at: https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits
     * **/
    public static class MarginInformation{

        private final boolean eligible;
        private final boolean enabled;
        private final String tier;

        public MarginInformation(boolean eligible, boolean enabled, String tier) {
            this.eligible = eligible;
            this.enabled = enabled;
            this.tier = tier;
        }

        public MarginInformation(JSONObject jsonMargin){
            eligible = jsonMargin.getBoolean("eligible");
            enabled = jsonMargin.getBoolean("enabled");
            tier = jsonMargin.getString("tier");
        }

        public boolean isEligible() {
            return eligible;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public String getTier() {
            return tier;
        }

    }

}

