package com.tecknobit.coinbasemanager.managers.exchangepro.account.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code CryptoAddress} class is useful to format CryptoAddress object
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses-1">
 * Generate crypto address</a>
 **/
public class CryptoAddress {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code address} is instance that memorizes address value
     * **/
    private final String address;

    /**
     * {@code addressInfoList} is instance that memorizes list of {@link AddressInfo}
     * **/
    private ArrayList<AddressInfo> addressInfoList;

    /**
     * {@code name} is instance that memorizes name value
     * **/
    private final String name;

    /**
     * {@code createdAt} is instance that memorizes created at value
     * **/
    private final String createdAt;

    /**
     * {@code updatedAt} is instance that memorizes updated at value
     * **/
    private final String updatedAt;

    /**
     * {@code network} is instance that memorizes network value
     * **/
    private final String network;

    /**
     * {@code uriScheme} is instance that memorizes uri scheme value
     * **/
    private final String uriScheme;

    /**
     * {@code resource} is instance that memorizes resource value
     * **/
    private final String resource;

    /**
     * {@code resourcePath} is instance that memorizes resource path value
     * **/
    private final String resourcePath;

    /**
     * {@code depositUri} is instance that memorizes deposit uri value
     * **/
    private final String depositUri;

    /**
     * {@code exchangeDepositAddress} is flag that checks exchange deposit address
     **/
    private final boolean exchangeDepositAddress;

    /**
     * {@code warningsList} is instance that memorizes list of {@link Warning}
     **/
    private ArrayList<Warning> warningsList;

    /**
     * Constructor to init a {@link CryptoAddress} object
     *
     * @param id:                     identifier value
     * @param address:                address value
     * @param addressInfoList:        list of {@link AddressInfo}
     * @param name:                   name value
     * @param createdAt:              created at value
     * @param updatedAt:              updated at value
     * @param network:                network value
     * @param uriScheme:              uri scheme value
     * @param resource:               resource value
     * @param resourcePath:           resource path value
     * @param depositUri:             deposit uri value
     * @param exchangeDepositAddress: flag that checks deposit address
     * @param warningsList:           list of {@link Warning}
     **/
    public CryptoAddress(String id, String address, ArrayList<AddressInfo> addressInfoList, String name, String createdAt,
                         String updatedAt, String network, String uriScheme, String resource, String resourcePath,
                         String depositUri, boolean exchangeDepositAddress, ArrayList<Warning> warningsList) {
        this.id = id;
        this.address = address;
        this.addressInfoList = addressInfoList;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.network = network;
        this.uriScheme = uriScheme;
        this.resource = resource;
        this.resourcePath = resourcePath;
        this.depositUri = depositUri;
        this.exchangeDepositAddress = exchangeDepositAddress;
        this.warningsList = warningsList;
    }

    /**
     * Constructor to init a {@link CryptoAddress} object
     *
     * @param jAddress: crypto address details as {@link JSONObject}
     **/
    public CryptoAddress(JSONObject jAddress) {
        id = jAddress.getString("id");
        address = jAddress.getString("address");
        addressInfoList = assembleAddressInfo(jAddress.getJSONObject("address_info"));
        name = jAddress.getString("name");
        createdAt = jAddress.getString("created_at");
        updatedAt = jAddress.getString("updated_at");
        network = jAddress.getString("network");
        uriScheme = jAddress.getString("uri_scheme");
        resource = jAddress.getString("resource");
        resourcePath = jAddress.getString("resource_path");
        depositUri = jAddress.getString("deposit_uri");
        exchangeDepositAddress = jAddress.getBoolean("exchange_deposit_address");
        warningsList = assembleWarningList(jAddress.getJSONArray("warnings"));
    }

    /**
     * Method to assemble an address info list
     *
     * @param jsonAddressInfo: jsonObject obtained by response request
     * @return address info list as {@link ArrayList} of {@link AddressInfo}
     **/
    @Returner
    private ArrayList<AddressInfo> assembleAddressInfo(JSONObject jsonAddressInfo) {
        ArrayList<AddressInfo> addressInfo = new ArrayList<>();
        for (String title : jsonAddressInfo.keySet())
            addressInfo.add(new AddressInfo(title, jsonAddressInfo.getString(title)));
        return addressInfo;
    }

    /**
     * Method to assemble a warningsList list
     *
     * @param jsonWarnings: jsonObject obtained by response request
     * @return warningsList list as {@link ArrayList} of {@link Warning}
     **/
    @Returner
    private ArrayList<Warning> assembleWarningList(JSONArray jsonWarnings) {
        ArrayList<Warning> warnings = new ArrayList<>();
        if (jsonWarnings != null)
            for (int j = 0; j < jsonWarnings.length(); j++)
                warnings.add(new Warning(jsonWarnings.getJSONObject(j)));
        return warnings;
    }

    /**
     * Method to get {@link #id} instance <br>
     * Any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #address} instance <br>
     * Any params required
     *
     * @return {@link #address} instance as {@link String}
     **/
    public String getAddress() {
        return address;
    }

    /**
     * Method to get {@link #addressInfoList} instance <br>
     * Any params required
     *
     * @return {@link #addressInfoList} instance as {@link ArrayList} of {@link AddressInfo}
     **/
    public ArrayList<AddressInfo> getAddressInfoList() {
        return addressInfoList;
    }

    /**
     * Method to set {@link #addressInfoList} instance <br>
     *
     * @param addressInfoList: address info list to set
     **/
    public void setAddressInfoList(ArrayList<AddressInfo> addressInfoList) {
        this.addressInfoList = addressInfoList;
    }

    /**
     * Method to add an address info to {@link #addressInfoList}
     *
     * @param addressInfo: address info to insert
     * @apiNote the {@code "addressInfo"} will be inserted only if is not already presents in the list
     **/
    public void insertAddressInfo(AddressInfo addressInfo) {
        if (!addressInfoList.contains(addressInfo))
            addressInfoList.add(addressInfo);
    }

    /**
     * Method to remove a warning from {@link #addressInfoList}
     *
     * @param addressInfo: address info to remove
     * @return whether the {@code "addressInfo"} has been removed
     **/
    public boolean removeAddressInfo(AddressInfo addressInfo) {
        return addressInfoList.remove(addressInfo);
    }

    /**
     * Method to get an address info from {@link #addressInfoList}
     *
     * @param index: index of the address info to get
     * @return address info as {@link AddressInfo}
     **/
    public AddressInfo getAddressInfo(int index) {
        return addressInfoList.get(index);
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
     * Method to get {@link #createdAt} instance <br>
     * Any params required
     *
     * @return {@link #createdAt} instance as {@link String}
     **/
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to get {@link #createdAt} timestamp <br>
     * Any params required
     *
     * @return {@link #createdAt} timestamp as long
     **/
    public long getCreatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(createdAt);
    }

    /**
     * Method to get {@link #updatedAt} instance <br>
     * Any params required
     *
     * @return {@link #updatedAt} instance as {@link String}
     **/
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Method to get {@link #updatedAt} timestamp <br>
     * Any params required
     *
     * @return {@link #updatedAt} timestamp as long
     **/
    public long getUpdatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(updatedAt);
    }

    /**
     * Method to get {@link #network} instance <br>
     * Any params required
     *
     * @return {@link #network} instance as {@link String}
     **/
    public String getNetwork() {
        return network;
    }

    /**
     * Method to get {@link #uriScheme} instance <br>
     * Any params required
     *
     * @return {@link #uriScheme} instance as {@link String}
     **/
    public String getUriScheme() {
        return uriScheme;
    }

    /**
     * Method to get {@link #resource} instance <br>
     * Any params required
     *
     * @return {@link #resource} instance as {@link String}
     **/
    public String getResource() {
        return resource;
    }

    /**
     * Method to get {@link #resourcePath} instance <br>
     * Any params required
     *
     * @return {@link #resourcePath} instance as {@link String}
     **/
    public String getResourcePath() {
        return resourcePath;
    }

    /**
     * Method to get {@link #depositUri} instance <br>
     * Any params required
     *
     * @return {@link #depositUri} instance as {@link String}
     **/
    public String getDepositUri() {
        return depositUri;
    }

    /**
     * Method to get {@link #exchangeDepositAddress} instance <br>
     * Any params required
     *
     * @return {@link #exchangeDepositAddress} instance as boolean
     **/
    public boolean isExchangeDepositAddress() {
        return exchangeDepositAddress;
    }

    /**
     * Method to get {@link #warningsList} instance <br>
     * Any params required
     *
     * @return {@link #warningsList} instance as {@link ArrayList} of {@link Warning}
     **/
    public ArrayList<Warning> getWarningsList() {
        return warningsList;
    }

    /**
     * Method to set {@link #warningsList} instance <br>
     *
     * @param warningsList: warnings list to set
     **/
    public void setWarningsList(ArrayList<Warning> warningsList) {
        this.warningsList = warningsList;
    }

    /**
     * Method to add a warning to {@link #warningsList}
     *
     * @param warning: warning to insert
     * @apiNote the {@code "warning"} will be inserted only if is not already presents in the list
     **/
    public void insertAddressInfo(Warning warning) {
        if (!warningsList.contains(warning))
            warningsList.add(warning);
    }

    /**
     * Method to remove a warning from {@link #warningsList}
     *
     * @param warning: warning to remove
     * @return whether the {@code "warning"} has been removed
     **/
    public boolean removeAddressInfo(Warning warning) {
        return warningsList.remove(warning);
    }

    /**
     * Method to get a warning from {@link #warningsList}
     *
     * @param index: index of the warning to get
     * @return warning as {@link Warning}
     **/
    public Warning getWarning(int index) {
        return warningsList.get(index);
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

    /**
     * The {@code AddressInfo} class is useful to obtain and format AddressInfo object for CryptoAddress <br>
     * This class give info about crypto address used in the request
     * @author N7ghtm4r3 - Tecknobit
     * **/
    public static class AddressInfo {

        /**
         * {@code titleInfo} is instance that memorizes title info value
         **/
        private final String titleInfo;

        /**
         * {@code valueInfo} is instance that memorizes info value
         **/
        private final String valueInfo;

        /**
         * Constructor to init a {@link AddressInfo} object
         *
         * @param titleInfo: title info
         * @param valueInfo: info value
         **/
        public AddressInfo(String titleInfo, String valueInfo) {
            this.titleInfo = titleInfo;
            this.valueInfo = valueInfo;
        }

        /**
         * Method to get {@link #titleInfo} instance <br>
         * Any params required
         *
         * @return {@link #titleInfo} instance as {@link String}
         **/
        public String getTitleInfo() {
            return titleInfo;
        }

        /**
         * Method to get {@link #valueInfo} instance <br>
         * Any params required
         *
         * @return {@link #valueInfo} instance as {@link String}
         **/
        public String getValueInfo() {
            return valueInfo;
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
     * The {@code Warning} class is useful to obtain and format Warning object for CryptoAddress <br>
     * This class give warningsList about crypto address used in the request
     * @author N7ghtm4r3 - Tecknobit
     * **/
    public static class Warning {

        /**
         * {@code title} is instance that memorizes title value
         * **/
        private final String title;

        /**
         * {@code details} is instance that memorizes details value
         * **/
        private final String details;

        /**
         * {@code imageUrl} is instance that memorizes image url value
         * **/
        private final String imageUrl;

        /** Constructor to init a {@link Warning} object
         * @param title: title value
         * @param details: details value
         * @param imageUrl: image url value
         * **/
        public Warning(String title, String details, String imageUrl) {
            this.title = title;
            this.details = details;
            this.imageUrl = imageUrl;
        }

        /**
         * Constructor to init a {@link Warning} object
         *
         * @param warning: crypto address details as {@link JSONObject}
         **/
        public Warning(JSONObject warning) {
            this(warning.getString("title"), warning.getString("details"), warning.getString("image_url"));
        }

        /**
         * Method to get {@link #title} instance <br>
         * Any params required
         *
         * @return {@link #title} instance as {@link String}
         **/
        public String getTitle() {
            return title;
        }

        /**
         * Method to get {@link #details} instance <br>
         * Any params required
         *
         * @return {@link #details} instance as {@link String}
         **/
        public String getDetails() {
            return details;
        }

        /**
         * Method to get {@link #imageUrl} instance <br>
         * Any params required
         *
         * @return {@link #imageUrl} instance as {@link String}
         **/
        public String getImageUrl() {
            return imageUrl;
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
