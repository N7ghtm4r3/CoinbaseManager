package com.tecknobit.coinbasemanager.managers.exchangepro.users.records;

import com.tecknobit.coinbasemanager.managers.exchangepro.reports.records.ReportDetails.UserDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code ExchangeLimits} class is useful to format the exchange limits of {@code "{@code "Coinbase"}"}
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
 * Get user exchange limits</a>
 * @see UserDetails
 **/
public class ExchangeLimits extends UserDetails {

    /**
     * {@code termsAccepted} is instance that memorizes if terms are being accepted
     **/
    private final String termsAccepted;
    /**
     * {@code country} is instance that memorizes country details
     **/
    private final Country country;
    /**
     * {@code stateCode} is instance that memorizes state code value
     **/
    private final String stateCode;
    /**
     * {@code accessPrivacyRights} is flag that checks access privacy policy rights
     **/
    private final boolean accessPrivacyRights;
    /**
     * {@code analyticsProcessingEnabled} is flag that checks analytics processing are enabled
     **/
    private final boolean analyticsProcessingEnabled;

    /**
     * {@code twoFactorMethod} is instance that memorizes two factor method value
     **/
    private final String twoFactorMethod;
    /**
     * {@code analyticsProcessingEnabled} is flag that checks if is prime
     **/
    private final boolean isPrime;
    /**
     * {@code hasProWbl} is flag that checks if account has pro wbl value
     **/
    private final boolean hasProWbl;
    /**
     * {@code hasProWbl} is flag that checks if account has claw back value
     **/
    private final boolean hasClawBack;
    /**
     * {@code hasClawBackPaymentPending} is flag that checks if account has clawed back payments pending value
     **/
    private final boolean hasClawBackPaymentPending;
    /**
     * {@code hasRestrictedAssets} is flag that checks if account has restricted assets
     **/
    private final boolean hasRestrictedAssets;
    /**
     * {@code legalName} is instance that memorizes legal name value
     **/
    private final String legalName;
    /**
     * {@code whitelistingEnabled} is flag that checks if account has white listing enabled
     **/
    private final boolean whitelistingEnabled;
    /**
     * {@code regionBankingSupport} is flag that checks if account has region banking support
     **/
    private final boolean regionBankingSupport;
    /**
     * {@code legalName} is instance that memorizes default preferred market value
     **/
    private final String defaultPreferredMarket;
    /**
     * {@code marginEligible} is flag that checks if account has margin eligible
     **/
    private final boolean marginEligible;
    /**
     * {@code marginInformation} is instance that memorizes margin information value
     **/
    private final MarginInformation marginInformation;
    /**
     * {@code Address} is instance that memorizes address value
     **/
    private final Address address;
    /**
     * {@code testGroupsList} is instance that memorizes list of {@link Test}
     **/
    private ArrayList<Test> testGroupsList;

    /**
     * Constructor to init {@link ExchangeLimits} custom object
     *
     * @param createdAt:                  created at value
     * @param activeAt:                   active at value
     * @param id:                         identifier value
     * @param name:                       name value
     * @param email:                      email value
     * @param isBanned:                   flag if account is banned
     * @param userType:                   user type value
     * @param fullFillsNewRequirements:   flag for full fills new requirements
     * @param hasDefault:                 flag for default check
     * @param termsAccepted:              terms are being accepted
     * @param testGroupsList:
     * @param country:
     * @param stateCode:                  state code value
     * @param accessPrivacyRights:        flag that checks access privacy policy rights
     * @param twoFactorMethod:            two factor method value
     * @param analyticsProcessingEnabled: flag that checks analytics processing are enabled
     * @param isPrime:                    flag that checks if is prime
     * @param hasProWbl:                  flag that checks if account has pro wbl value
     * @param hasClawBack:                flag that checks if account has claw back value
     * @param hasClawBackPaymentPending:  flag that checks if account has clawed back payments pending value
     * @param hasRestrictedAssets:        flag that checks if account has restricted assets
     * @param legalName:                  legal name value
     * @param whitelistingEnabled:        flag that checks if account has white listing enabled
     * @param regionBankingSupport:       flag that checks if account has region banking support
     * @param defaultPreferredMarket:     default preferred market value
     * @param marginEligible:             flag that checks if account has margin eligible
     * @param marginInformation:
     * @param address:
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public ExchangeLimits(String createdAt, String activeAt, String id, String name, String email, boolean isBanned,
                          String userType, boolean fullFillsNewRequirements, boolean hasDefault, String termsAccepted,
                          ArrayList<Test> testGroupsList, Country country, String stateCode, boolean accessPrivacyRights,
                          String twoFactorMethod, boolean analyticsProcessingEnabled, boolean isPrime, boolean hasProWbl,
                          boolean hasClawBack, boolean hasClawBackPaymentPending, boolean hasRestrictedAssets,
                          String legalName, boolean whitelistingEnabled, boolean regionBankingSupport,
                          String defaultPreferredMarket, boolean marginEligible, MarginInformation marginInformation,
                          Address address) {
        super(createdAt, activeAt, id, name, email, isBanned, userType, fullFillsNewRequirements, hasDefault);
        this.termsAccepted = termsAccepted;
        if (stateCode == null || stateCode.isEmpty())
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
        if (legalName == null || legalName.isEmpty())
            throw new IllegalArgumentException("Legal name value cannot be empty or null");
        else
            this.legalName = legalName;
        this.whitelistingEnabled = whitelistingEnabled;
        this.regionBankingSupport = regionBankingSupport;
        if (defaultPreferredMarket == null || defaultPreferredMarket.isEmpty())
            throw new IllegalArgumentException("Default preferred market value cannot be empty or null");
        else
            this.defaultPreferredMarket = defaultPreferredMarket;
        this.marginEligible = marginEligible;
        this.country = country;
        this.testGroupsList = testGroupsList;
        this.marginInformation = marginInformation;
        this.address = address;
    }

    /**
     * Constructor to init a {@link ExchangeLimits} custom object
     *
     * @param exchangeLimits: exchangeLimits details as {@link JSONObject}
     **/
    public ExchangeLimits(JSONObject exchangeLimits) {
        super(exchangeLimits);
        termsAccepted = hUser.getString("terms_accepted");
        stateCode = hUser.getString("state_code");
        if (stateCode == null || stateCode.isEmpty())
            throw new IllegalArgumentException("State code value cannot be empty or null");
        accessPrivacyRights = hUser.getBoolean("access_privacy_rights");
        twoFactorMethod = hUser.getString("two_factor_method");
        analyticsProcessingEnabled = hUser.getBoolean("analytics_processing_enabled");
        isPrime = hUser.getBoolean("is_prime");
        hasProWbl = hUser.getBoolean("has_pro_wbl");
        hasClawBack = hUser.getBoolean("has_clawback");
        hasClawBackPaymentPending = hUser.getBoolean("has_clawback_payment_pending");
        hasRestrictedAssets = hUser.getBoolean("has_restricted_assets");
        legalName = hUser.getString("legal_name");
        if (legalName == null || legalName.isEmpty())
            throw new IllegalArgumentException("Legal name value cannot be empty or null");
        whitelistingEnabled = hUser.getBoolean("whitelisting_enabled");
        regionBankingSupport = hUser.getBoolean("region_banking_support");
        defaultPreferredMarket = hUser.getString("default_preferred_market");
        if (defaultPreferredMarket == null || defaultPreferredMarket.isEmpty())
            throw new IllegalArgumentException("Default preferred market value cannot be empty or null");
        marginEligible = hUser.getBoolean("margin_eligible");
        assembleTestList(hUser.getJSONArray("test_groups", new JSONArray()));
        country = new Country(hUser.getJSONObject("country"));
        marginInformation = new MarginInformation(hUser.getJSONObject("margin_information"));
        address = new Address(hUser.getJSONObject("address"));
    }

    /**
     * Method to assemble a test list
     *
     * @param jsonTests: jsonArray obtained by response request
     *                   any return
     **/
    private void assembleTestList(JSONArray jsonTests) {
        testGroupsList = new ArrayList<>();
        for (int j = 0; j < jsonTests.length(); j++)
            testGroupsList.add(new Test(jsonTests.getJSONObject(j)));
    }

    /**
     * Method to get {@link #termsAccepted} instance <br>
     * Any params required
     *
     * @return {@link #termsAccepted} instance as {@link String}
     **/
    public String getTermsAccepted() {
        return termsAccepted;
    }

    /**
     * Method to get {@link #testGroupsList} instance <br>
     * Any params required
     *
     * @return {@link #testGroupsList} instance as {@link ArrayList} of {@link Test}
     **/
    public ArrayList<Test> getTestGroupsList() {
        return testGroupsList;
    }

    /**
     * Method to set {@link #testGroupsList} instance <br>
     *
     * @param testGroupsList: test groups list to set
     **/
    public void setTestGroupsList(ArrayList<Test> testGroupsList) {
        this.testGroupsList = testGroupsList;
    }

    /**
     * Method to add a test group to {@link #testGroupsList}
     *
     * @param testGroup: test group to insert
     * @apiNote the {@code "testGroup"} will be inserted only if is not already presents in the list
     **/
    public void insertTestGroup(Test testGroup) {
        if (!testGroupsList.contains(testGroup))
            testGroupsList.add(testGroup);
    }

    /**
     * Method to remove a deposit from {@link #testGroupsList}
     *
     * @param testGroup: deposit to remove
     * @return whether the {@code "testGroup"} has been removed
     **/
    public boolean removeTestGroup(Test testGroup) {
        return testGroupsList.remove(testGroup);
    }

    /**
     * Method to get a test from {@link #testGroupsList}
     *
     * @param index: index of the test to get
     * @return test as {@link Test}
     **/
    public Test getGroupTest(int index) {
        return testGroupsList.get(index);
    }

    /**
     * Method to get {@link #country} instance <br>
     * Any params required
     *
     * @return {@link #country} instance as {@link Country}
     **/
    public Country getCountry() {
        return country;
    }

    /**
     * Method to get {@link #stateCode} instance <br>
     * Any params required
     *
     * @return {@link #stateCode} instance as {@link String}
     **/
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Method to get {@link #accessPrivacyRights} instance <br>
     * Any params required
     *
     * @return {@link #accessPrivacyRights} instance as boolean
     **/
    public boolean isAccessPrivacyRights() {
        return accessPrivacyRights;
    }

    /**
     * Method to get {@link #twoFactorMethod} instance <br>
     * Any params required
     *
     * @return {@link #twoFactorMethod} instance as {@link String}
     **/
    public String getTwoFactorMethod() {
        return twoFactorMethod;
    }

    /**
     * Method to get {@link #analyticsProcessingEnabled} instance <br>
     * Any params required
     *
     * @return {@link #analyticsProcessingEnabled} instance as boolean
     **/
    public boolean areAnalyticsProcessingEnabled() {
        return analyticsProcessingEnabled;
    }

    /**
     * Method to get {@link #isPrime} instance <br>
     * Any params required
     *
     * @return {@link #isPrime} instance as boolean
     **/
    public boolean isPrime() {
        return isPrime;
    }

    /**
     * Method to get {@link #hasProWbl} instance <br>
     * Any params required
     *
     * @return {@link #hasProWbl} instance as boolean
     **/
    public boolean hasProWbl() {
        return hasProWbl;
    }

    /**
     * Method to get {@link #hasClawBack} instance <br>
     * Any params required
     *
     * @return {@link #hasClawBack} instance as boolean
     **/
    public boolean hasClawBack() {
        return hasClawBack;
    }

    /**
     * Method to get {@link #hasClawBackPaymentPending} instance <br>
     * Any params required
     *
     * @return {@link #hasClawBackPaymentPending} instance as boolean
     **/
    public boolean hasClawBackPaymentPending() {
        return hasClawBackPaymentPending;
    }

    /**
     * Method to get {@link #hasRestrictedAssets} instance <br>
     * Any params required
     *
     * @return {@link #hasRestrictedAssets} instance as boolean
     **/
    public boolean hasRestrictedAssets() {
        return hasRestrictedAssets;
    }

    /**
     * Method to get {@link #legalName} instance <br>
     * Any params required
     *
     * @return {@link #legalName} instance as {@link String}
     **/
    public String getLegalName() {
        return legalName;
    }

    /**
     * Method to get {@link #whitelistingEnabled} instance <br>
     * Any params required
     *
     * @return {@link #whitelistingEnabled} instance as boolean
     **/
    public boolean isWhitelistingEnabled() {
        return whitelistingEnabled;
    }

    /**
     * Method to get {@link #regionBankingSupport} instance <br>
     * Any params required
     *
     * @return {@link #regionBankingSupport} instance as boolean
     **/
    public boolean isRegionBankingSupport() {
        return regionBankingSupport;
    }

    /**
     * Method to get {@link #defaultPreferredMarket} instance <br>
     * Any params required
     *
     * @return {@link #defaultPreferredMarket} instance as {@link String}
     **/
    public String getDefaultPreferredMarket() {
        return defaultPreferredMarket;
    }

    /**
     * Method to get {@link #marginEligible} instance <br>
     * Any params required
     *
     * @return {@link #marginEligible} instance as boolean
     **/
    public boolean isMarginEligible() {
        return marginEligible;
    }

    /**
     * Method to get {@link #marginInformation} instance <br>
     * Any params required
     *
     * @return {@link #marginInformation} instance as {@link MarginInformation}
     **/
    public MarginInformation getMarginInformation() {
        return marginInformation;
    }

    /**
     * Method to get {@link #address} instance <br>
     * Any params required
     *
     * @return {@link #address} instance as {@link Address}
     **/
    public Address getAddress() {
        return address;
    }

    /**
     * The {@code Test} class is useful to obtain and format a test for the {@link ExchangeLimits}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * Get user exchange limits</a>
     **/
    public static class Test {

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
         **/
        private final boolean forced;

        /**
         * Constructor to init {@link Test} custom object
         *
         * @param test:   test value
         * @param group:  group value
         * @param forced: flag that checks if test is forced
         **/
        public Test(String test, String group, boolean forced) {
            this.test = test;
            this.group = group;
            this.forced = forced;
        }

        /**
         * Constructor to init a {@link Test} custom object
         *
         * @param jTest: test details as {@link JSONObject}
         **/
        public Test(JSONObject jTest) {
            this(jTest.getString("jTest"), jTest.getString("group"), jTest.getBoolean("forced"));
        }

        /**
         * Method to get {@link #test} instance <br>
         * Any params required
         *
         * @return {@link #test} instance as {@link String}
         **/
        public String getTest() {
            return test;
        }

        /**
         * Method to get {@link #group} instance <br>
         * Any params required
         *
         * @return {@link #group} instance as {@link String}
         **/
        public String getGroup() {
            return group;
        }

        /**
         * Method to get {@link #forced} instance <br>
         * Any params required
         *
         * @return {@link #forced} instance as boolean
         **/
        public boolean isForced() {
            return forced;
        }

        /**
         * Returns a string representation of the object <br>
         * Any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

    /**
     * The {@code Country} class is useful to obtain and format the country for the {@link ExchangeLimits}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * Get user exchange limits</a>
     **/
    public static class Country {

        /**
         * {@code code} is instance that memorizes code value
         * **/
        private final String code;

        /**
         * {@code name} is instance that memorizes name value
         * **/
        private final String name;

        /**
         * {@code isInEurope} is flag that checks if account is in Europe
         * **/
        private final boolean isInEurope;

        /**
         * Constructor to init {@link Country} custom object
         *
         * @param code:       code value
         * @param name:       name value
         * @param isInEurope: flag that checks if account is in Europe
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public Country(String code, String name, boolean isInEurope) {
            if (code == null || code.isEmpty())
                throw new IllegalArgumentException("Code value cannot be empty or null");
            else
                this.code = code;
            if (name == null || name.isEmpty())
                throw new IllegalArgumentException("Name value cannot be empty or null");
            else
                this.name = name;
            this.isInEurope = isInEurope;
        }

        /**
         * Constructor to init {@link Country} custom object
         *
         * @param jCountry: country details in JSON format
         **/
        public Country(JSONObject jCountry) {
            this(jCountry.getString("code"), jCountry.getString("name"), jCountry.getBoolean("is_in_europe"));
        }

        /**
         * Method to get {@link #code} instance <br>
         * Any params required
         *
         * @return {@link #code} instance as {@link String}
         **/
        public String getCode() {
            return code;
        }

        /**
         * Method to get {@link #name} instance <br>
         * Any params required
         *
         * @return {@link #name} instance as {@link String}
         **/
        public String getName() {
            return name;
        }

        /**
         * Method to get {@link #isInEurope} instance <br>
         * Any params required
         *
         * @return {@link #isInEurope} instance as boolean
         **/
        public boolean isInEurope() {
            return isInEurope;
        }

        /**
         * Returns a string representation of the object <br>
         * Any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

    /**
     * The {@code Address} class is useful to obtain and format the address for the {@link ExchangeLimits}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * Get user exchange limits</a>
     **/
    public static class Address {

        /**
         * {@code line1} is instance that memorizes line1 value
         * **/
        private String line1;

        /**
         * {@code city} is instance that memorizes city value
         * **/
        private String city;

        /**
         * {@code state} is instance that memorizes state value
         * **/
        private String state;

        /**
         * {@code postalCode} is instance that memorizes postal code value
         * **/
        private String postalCode;

        /**
         * {@code code} is instance that memorizes code value
         * **/
        private String code;

        /**
         * {@code name} is instance that memorizes name value
         * **/
        private String name;

        /** Constructor to init {@link Address} custom object
         * @param line1: line1 value
         * @param city: city value
         * @param state: state value
         * @param postalCode: postal code value
         * @param code: code value
         * @param name: name value
         * @throws IllegalArgumentException if parameters range is not respected
         * **/
        public Address(String line1, String city, String state, String postalCode, String code, String name) {
            this.line1 = line1;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
            this.code = code;
            this.name = name;
        }

        /**
         * Constructor to init {@link Address} custom object
         *
         * @param jAddress: address details in JSON format
         **/
        public Address(JSONObject jAddress) {
            line1 = jAddress.getString("line1");
            city = jAddress.getString("city");
            state = jAddress.getString("state");
            postalCode = jAddress.getString("postal_code");
            JSONObject jCountry = jAddress.getJSONObject("country");
            code = jCountry.getString("code");
            name = jCountry.getString("name");
        }

        /**
         * Method to get {@link #line1} instance <br>
         * Any params required
         *
         * @return {@link #line1} instance as {@link String}
         **/
        public String getLine1() {
            return line1;
        }

        /**
         * Method to set {@link #line1}
         *
         * @param line1: line1 value
         * @throws IllegalArgumentException when line1 value is null or empty
         **/
        public void setLine1(String line1) {
            if (line1 == null || line1.isEmpty())
                throw new IllegalArgumentException("Line1 value cannot be empty or null");
            this.line1 = line1;
        }

        /**
         * Method to get {@link #city} instance <br>
         * Any params required
         *
         * @return {@link #city} instance as {@link String}
         **/
        public String getCity() {
            return city;
        }

        /**
         * Method to set {@link #city}
         *
         * @param city: city value
         * @throws IllegalArgumentException when city value is null or empty
         **/
        public void setCity(String city) {
            if (city == null || city.isEmpty())
                throw new IllegalArgumentException("City value cannot be empty or null");
            this.city = city;
        }

        /**
         * Method to get {@link #state} instance <br>
         * Any params required
         *
         * @return {@link #state} instance as {@link String}
         **/
        public String getState() {
            return state;
        }

        /**
         * Method to set {@link #state}
         *
         * @param state: state value
         * @throws IllegalArgumentException when state value is null or empty
         **/
        public void setState(String state) {
            if (state == null || state.isEmpty())
                throw new IllegalArgumentException("State value cannot be empty or null");
            this.state = state;
        }

        /**
         * Method to get {@link #postalCode} instance <br>
         * Any params required
         *
         * @return {@link #postalCode} instance as {@link String}
         **/
        public String getPostalCode() {
            return postalCode;
        }

        /**
         * Method to set {@link #postalCode}
         *
         * @param postalCode: postal code value
         * @throws IllegalArgumentException when postal code value is null or empty
         **/
        public void setPostalCode(String postalCode) {
            if (postalCode == null || postalCode.isEmpty())
                throw new IllegalArgumentException("Postal code value cannot be empty or null");
            this.postalCode = postalCode;
        }

        /**
         * Method to get {@link #code} instance <br>
         * Any params required
         *
         * @return {@link #code} instance as {@link String}
         **/
        public String getCode() {
            return code;
        }

        /**
         * Method to set {@link #code}
         *
         * @param code: code value
         * @throws IllegalArgumentException when code value is null or empty
         **/
        public void setCode(String code) {
            if (code == null || code.isEmpty())
                throw new IllegalArgumentException("Code value cannot be empty or null");
            this.code = code;
        }

        /**
         * Method to get {@link #name} instance <br>
         * Any params required
         *
         * @return {@link #name} instance as {@link String}
         **/
        public String getName() {
            return name;
        }

        /**
         * Method to set {@link #name}
         *
         * @param name: code value
         * @throws IllegalArgumentException when name value is null or empty
         **/
        public void setName(String name) {
            if (name == null || name.isEmpty())
                throw new IllegalArgumentException("Name value cannot be empty or null");
            this.name = name;
        }

        /**
         * Returns a string representation of the object <br>
         * Any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

    /**
     * The {@code MarginInformation} class is useful to obtain and format a margin information for the {@link ExchangeLimits}
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getuserexchangelimits-1">
     * Get user exchange limits</a>
     **/
    public static class MarginInformation {

        /**
         * {@code eligible} is flag for eligible value
         * **/
        private final boolean eligible;

        /**
         * {@code enabled} is flag for enabled value
         * **/
        private final boolean enabled;

        /**
         * {@code tier} is instance that memorizes tier value
         * **/
        private final String tier;

        /**
         * Constructor to init {@link MarginInformation} custom object
         *
         * @param eligible: flag for eligible value
         * @param enabled:  flag for enabled value
         * @param tier:     tier value
         * @throws IllegalArgumentException if parameters range is not respected
         **/
        public MarginInformation(boolean eligible, boolean enabled, String tier) {
            this.eligible = eligible;
            this.enabled = enabled;
            if (tier == null)
                throw new IllegalArgumentException("Tier value cannot be empty or null");
            else
                this.tier = tier;
        }

        /**
         * Constructor to init {@link MarginInformation} custom object
         *
         * @param jMargin: margin information details in JSON format
         **/
        public MarginInformation(JSONObject jMargin) {
            this(jMargin.getBoolean("eligible"), jMargin.getBoolean("enabled"), jMargin.getString("tier"));
        }

        /**
         * Method to get {@link #eligible} instance <br>
         * Any params required
         *
         * @return {@link #eligible} instance as boolean
         **/
        public boolean isEligible() {
            return eligible;
        }

        /**
         * Method to get {@link #enabled} instance <br>
         * Any params required
         *
         * @return {@link #enabled} instance as boolean
         **/
        public boolean isEnabled() {
            return enabled;
        }

        /**
         * Method to get {@link #tier} instance <br>
         * Any params required
         *
         * @return {@link #tier} instance as {@link String}
         **/
        public String getTier() {
            return tier;
        }

        /**
         * Returns a string representation of the object <br>
         * Any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return new JSONObject(this).toString();
        }

    }

}

