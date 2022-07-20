package com.tecknobit.coinbasemanager.Managers.ExchangePro.Users.Records;

import com.tecknobit.apimanager.Tools.Formatters.JsonHelper;
import com.tecknobit.coinbasemanager.Managers.ExchangePro.Reports.Records.ReportDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code ExchangeLimits} class is useful to format ExchangeLimits object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class ExchangeLimits extends ReportDetails.UserDetails {

    /**
     * {@code termsAccepted} is instance that memorizes if terms are being accepted
     * **/
    private final String termsAccepted;

    /**
     * {@code testGroupsList} is instance that memorizes list of {@link Test}
     * **/
    private ArrayList<Test> testGroupsList;

    /**
     * {@code country} is instance that memorizes country details
     * **/
    private Country country;

    /**
     * {@code stateCode} is instance that memorizes state code value
     * **/
    private String stateCode;

    /**
     * {@code accessPrivacyRights} is flag that checks access privacy policy rights
     * **/
    private boolean accessPrivacyRights;

    /**
     * {@code twoFactorMethod} is instance that memorizes two factor method value
     * **/
    private final String twoFactorMethod;

    /**
     * {@code analyticsProcessingEnabled} is flag that checks analytics processing are enabled
     * **/
    private boolean analyticsProcessingEnabled;

    /**
     * {@code analyticsProcessingEnabled} is flag that checks if is prime
     * **/
    private boolean isPrime;

    /**
     * {@code hasProWbl} is flag that checks if account has pro wbl value
     * **/
    private boolean hasProWbl;

    /**
     * {@code hasProWbl} is flag that checks if account has claw back value
     * **/
    private boolean hasClawBack;

    /**
     * {@code hasClawBackPaymentPending} is flag that checks if account has clawed back payments pending value
     * **/
    private boolean hasClawBackPaymentPending;

    /**
     * {@code hasRestrictedAssets} is flag that checks if account has restricted assets
     * **/
    private boolean hasRestrictedAssets;

    /**
     * {@code legalName} is instance that memorizes legal name value
     * **/
    private String legalName;

    /**
     * {@code whitelistingEnabled} is flag that checks if account has white listing enabled
     * **/
    private boolean whitelistingEnabled;

    /**
     * {@code regionBankingSupport} is flag that checks if account has region banking support
     * **/
    private boolean regionBankingSupport;

    /**
     * {@code legalName} is instance that memorizes default preferred market value
     * **/
    private String defaultPreferredMarket;

    /**
     * {@code marginEligible} is flag that checks if account has margin eligible
     * **/
    private boolean marginEligible;

    /**
     * {@code marginInformation} is instance that memorizes margin information value
     * **/
    private MarginInformation marginInformation;

    /**
     * {@code Address} is instance that memorizes address value
     * **/
    private Address address;

    /** Constructor to init {@link ExchangeLimits} object
     * @param createdAt: created at value
     * @param activeAt: active at value
     * @param id: identifier value
     * @param name: name value
     * @param email: email value
     * @param isBanned: flag if account is banned
     * @param userType: user type value
     * @param fullFillsNewRequirements: flag for full fills new requirements
     * @param hasDefault: flag for default check
     * @param jsonHelper: useful to help to format JSON
     * @param termsAccepted: terms are being accepted
     * @param stateCode: state code value
     * @param accessPrivacyRights: flag that checks access privacy policy rights
     * @param twoFactorMethod: two factor method value
     * @param analyticsProcessingEnabled: flag that checks analytics processing are enabled
     * @param isPrime: flag that checks if is prime
     * @param hasProWbl: flag that checks if account has pro wbl value
     * @param hasClawBack: flag that checks if account has claw back value
     * @param hasClawBackPaymentPending: flag that checks if account has clawed back payments pending value
     * @param hasRestrictedAssets: flag that checks if account has restricted assets
     * @param legalName: legal name value
     * @param whitelistingEnabled: flag that checks if account has white listing enabled
     * @param regionBankingSupport: flag that checks if account has region banking support
     * @param defaultPreferredMarket: default preferred market value
     * @param marginEligible: flag that checks if account has margin eligible
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public ExchangeLimits(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                          String userType, boolean fullFillsNewRequirements, boolean hasDefault, JsonHelper jsonHelper,
                          String termsAccepted, String stateCode, boolean accessPrivacyRights, String twoFactorMethod,
                          boolean analyticsProcessingEnabled, boolean isPrime, boolean hasProWbl, boolean hasClawBack,
                          boolean hasClawBackPaymentPending, boolean hasRestrictedAssets, String legalName,
                          boolean whitelistingEnabled, boolean regionBankingSupport, String defaultPreferredMarket,
                          boolean marginEligible) {
        super(createdAt, activeAt, id, name, email, isBanned, userType, fullFillsNewRequirements, hasDefault, jsonHelper);
        this.termsAccepted = termsAccepted;
        if(stateCode == null || stateCode.isEmpty())
            throw new IllegalArgumentException("State code value cannot be empty or null");
        else
            this.stateCode = stateCode;
        this.accessPrivacyRights = accessPrivacyRights;
        this.twoFactorMethod = twoFactorMethod;
        this.analyticsProcessingEnabled = analyticsProcessingEnabled;
        this.isPrime = isPrime;
        this.hasProWbl = hasProWbl;
        this.hasClawBack = hasClawBack;
        this.hasClawBackPaymentPending = hasClawBackPaymentPending;
        this.hasRestrictedAssets = hasRestrictedAssets;
        if(legalName == null || legalName.isEmpty())
            throw new IllegalArgumentException("Legal name value cannot be empty or null");
        else
            this.legalName = legalName;
        this.whitelistingEnabled = whitelistingEnabled;
        this.regionBankingSupport = regionBankingSupport;
        if(defaultPreferredMarket == null || defaultPreferredMarket.isEmpty())
            throw new IllegalArgumentException("Default preferred market value cannot be empty or null");
        else
            this.defaultPreferredMarket = defaultPreferredMarket;
        this.marginEligible = marginEligible;
        assembleTestList(jsonHelper.getJSONArray("test_groups"));
        country = new Country(jsonHelper.getJSONObject("country"));
        marginInformation = new MarginInformation(jsonHelper.getJSONObject("margin_information"));
        address = new Address(jsonHelper.getJSONObject("address"));
    }

    /** Method to assemble a test list
     * @param jsonTests: jsonArray obtained by response request
     * any return
     * **/
    private void assembleTestList(JSONArray jsonTests){
        testGroupsList = new ArrayList<>();
        for (int j=0; j < jsonTests.length(); j++){
            JSONObject test = jsonTests.getJSONObject(j);
            testGroupsList.add(new Test(test.getString("test"),
                    test.getString("group"),
                    test.getBoolean("forced")
            ));
        }
    }

    public String getTermsAccepted() {
        return termsAccepted;
    }

    public ArrayList<Test> getTestGroupsList() {
        return testGroupsList;
    }

    public void setTestGroupsList(ArrayList<Test> testGroupsList) {
        this.testGroupsList = testGroupsList;
    }

    public void insertTestGroup(Test testGroup){
        if(!testGroupsList.contains(testGroup))
            testGroupsList.add(testGroup);
    }

    public boolean removeTestGroup(Test testGroup){
        return testGroupsList.remove(testGroup);
    }

    public Test getGroupTest(int index){
        return testGroupsList.get(index);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStateCode() {
        return stateCode;
    }

    /** Method to set {@link #stateCode}
     * @param stateCode: state code value
     * @throws IllegalArgumentException when state code value is null or empty
     * **/
    public void setStateCode(String stateCode) {
        if(stateCode == null || stateCode.isEmpty())
            throw new IllegalArgumentException("State code value cannot be empty or null");
        this.stateCode = stateCode;
    }

    public boolean isAccessPrivacyRights() {
        return accessPrivacyRights;
    }

    public void setAccessPrivacyRights(boolean accessPrivacyRights) {
        this.accessPrivacyRights = accessPrivacyRights;
    }

    public String getTwoFactorMethod() {
        return twoFactorMethod;
    }

    public boolean isAnalyticsProcessingEnabled() {
        return analyticsProcessingEnabled;
    }

    public void setAnalyticsProcessingEnabled(boolean analyticsProcessingEnabled) {
        this.analyticsProcessingEnabled = analyticsProcessingEnabled;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public boolean isHasProWbl() {
        return hasProWbl;
    }

    public void setHasProWbl(boolean hasProWbl) {
        this.hasProWbl = hasProWbl;
    }

    public boolean isHasClawBack() {
        return hasClawBack;
    }

    public void setHasClawBack(boolean hasClawBack) {
        this.hasClawBack = hasClawBack;
    }

    public boolean isHasClawBackPaymentPending() {
        return hasClawBackPaymentPending;
    }

    public void setHasClawBackPaymentPending(boolean hasClawBackPaymentPending) {
        this.hasClawBackPaymentPending = hasClawBackPaymentPending;
    }

    public boolean isHasRestrictedAssets() {
        return hasRestrictedAssets;
    }

    public void setHasRestrictedAssets(boolean hasRestrictedAssets) {
        this.hasRestrictedAssets = hasRestrictedAssets;
    }

    public String getLegalName() {
        return legalName;
    }

    /** Method to set {@link #legalName}
     * @param legalName: legal name value
     * @throws IllegalArgumentException when legal name value is null or empty
     * **/
    public void setLegalName(String legalName) {
        if(legalName == null || legalName.isEmpty())
            throw new IllegalArgumentException("Legal name value cannot be empty or null");
        this.legalName = legalName;
    }

    public boolean isWhitelistingEnabled() {
        return whitelistingEnabled;
    }

    public void setWhitelistingEnabled(boolean whitelistingEnabled) {
        this.whitelistingEnabled = whitelistingEnabled;
    }

    public boolean isRegionBankingSupport() {
        return regionBankingSupport;
    }

    public void setRegionBankingSupport(boolean regionBankingSupport) {
        this.regionBankingSupport = regionBankingSupport;
    }

    public String getDefaultPreferredMarket() {
        return defaultPreferredMarket;
    }

    /** Method to set {@link #defaultPreferredMarket}
     * @param defaultPreferredMarket: default preferred market value
     * @throws IllegalArgumentException when default preferred market value is null or empty
     * **/
    public void setDefaultPreferredMarket(String defaultPreferredMarket) {
        if(defaultPreferredMarket == null || defaultPreferredMarket.isEmpty())
            throw new IllegalArgumentException("Default preferred market value cannot be empty or null");
        this.defaultPreferredMarket = defaultPreferredMarket;
    }

    public boolean isMarginEligible() {
        return marginEligible;
    }

    public void setMarginEligible(boolean marginEligible) {
        this.marginEligible = marginEligible;
    }

    public MarginInformation getMarginInformation() {
        return marginInformation;
    }

    public void setMarginInformation(MarginInformation marginInformation) {
        this.marginInformation = marginInformation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * The {@code Test} class is useful to obtain and format Test objects for ExchangeLimits
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
     * **/
    public static class Test{

        /**
         * {@code test} is instance that memorizes test value
         * **/
        private final String test;

        /**
         * {@code group} is instance that memorizes group value
         * **/
        private final String group;

        /**
         * {@code forced} is flag that checks if test is forced
         * **/
        private final boolean forced;

        /** Constructor to init {@link Test} object
         * @param test: test value
         * @param group: group value
         * @param forced: flag that checks if test is forced
         * **/
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
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
     * **/
    public static class Country{

        /**
         * {@code code} is instance that memorizes code value
         * **/
        private String code;

        /**
         * {@code name} is instance that memorizes name value
         * **/
        private String name;

        /**
         * {@code isInEurope} is flag that checks if account is in Europe
         * **/
        private boolean isInEurope;

        /** Constructor to init {@link Country} object
         * @param code: code value
         * @param name: name value
         * @param isInEurope: flag that checks if account is in Europe
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public Country(String code, String name, boolean isInEurope) {
            this.code = code;
            this.name = name;
            this.isInEurope = isInEurope;
        }

        /** Constructor to init {@link Country} object
         * @param jsonCountry: country details in JSON format
         * **/
        public Country(JSONObject jsonCountry){
            code = jsonCountry.getString("code");
            name = jsonCountry.getString("name");
            isInEurope = jsonCountry.getBoolean("is_in_europe");
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            if(code == null || code.isEmpty())
                throw new IllegalArgumentException("Code value cannot be empty or null");
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if(name == null || name.isEmpty())
                throw new IllegalArgumentException("Name value cannot be empty or null");
            this.name = name;
        }

        public boolean isInEurope() {
            return isInEurope;
        }

        public void setInEurope(boolean inEurope) {
            isInEurope = inEurope;
        }

    }

    /**
     * The {@code Address} class is useful to obtain and format Address object for ExchangeLimits
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
     * **/
    public static class Address{

        private String line1;
        private String city;
        private String state;
        private String postalCode;
        private String code;
        private String name;

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

        public void setLine1(String line1) {
            if(line1 == null || line1.isEmpty())
                throw new IllegalArgumentException("Line1 value cannot be empty or null");
            this.line1 = line1;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            if(city == null || city.isEmpty())
                throw new IllegalArgumentException("City value cannot be empty or null");
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            if(state == null || state.isEmpty())
                throw new IllegalArgumentException("State value cannot be empty or null");
            this.state = state;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            if(postalCode == null || postalCode.isEmpty())
                throw new IllegalArgumentException("Postal code value cannot be empty or null");
            this.postalCode = postalCode;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            if(code == null || code.isEmpty())
                throw new IllegalArgumentException("Code value cannot be empty or null");
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if(name == null || name.isEmpty())
                throw new IllegalArgumentException("Name value cannot be empty or null");
            this.name = name;
        }

    }

    /**
     * The {@code MarginInformation} class is useful to obtain and format MarginInformation object for ExchangeLimits
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits">
     *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits</a>
     * **/
    public static class MarginInformation{

        private boolean eligible;
        private boolean enabled;
        private String tier;

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

        public void setEligible(boolean eligible) {
            this.eligible = eligible;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getTier() {
            return tier;
        }

        public void setTier(String tier) {
            if(tier == null || tier.isEmpty())
                throw new IllegalArgumentException("Tier value cannot be empty or null");
            this.tier = tier;
        }

    }

}

