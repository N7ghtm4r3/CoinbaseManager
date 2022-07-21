package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code CryptoAddress} class is useful to format CryptoAddress object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

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
     * **/
    private final boolean exchangeDepositAddress;

    /**
     * {@code warningsList} is instance that memorizes list of {@link Warning}
     * **/
    private ArrayList<Warning> warningsList;

    /** Constructor to init a {@link CryptoAddress} object
     * @param id: identifier value
     * @param address: address value
     * @param jsonAddressInfo: address info details in JSON format
     * @param name: name value
     * @param createdAt: created at value
     * @param updatedAt: updated at value
     * @param network: network value
     * @param uriScheme: uri scheme value
     * @param resource: resource value
     * @param resourcePath: resource path value
     * @param depositUri: deposit uri value
     * @param exchangeDepositAddress: flag that checks deposit address
     * @param jsonWarnings: warnings info details in JSON format
     * **/
    public CryptoAddress(String id, String address, JSONObject jsonAddressInfo, String name, String createdAt,
                         String updatedAt, String network, String uriScheme, String resource, String resourcePath,
                         String depositUri, boolean exchangeDepositAddress, JSONArray jsonWarnings) {
        this.id = id;
        this.address = address;
        addressInfoList = assembleAddressInfo(jsonAddressInfo);
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.network = network;
        this.uriScheme = uriScheme;
        this.resource = resource;
        this.resourcePath = resourcePath;
        this.depositUri = depositUri;
        this.exchangeDepositAddress = exchangeDepositAddress;
        this.warningsList = assembleWarningList(jsonWarnings);
    }

    /** Method to assemble an address info list
     * @param jsonAddressInfo: jsonObject obtained by response request
     * @return address info list as {@link ArrayList} of {@link AddressInfo}
     * **/
    private ArrayList<AddressInfo> assembleAddressInfo(JSONObject jsonAddressInfo) {
        ArrayList<AddressInfo> addressInfo = new ArrayList<>();
        for (String title : jsonAddressInfo.keySet())
            addressInfo.add(new AddressInfo(title, jsonAddressInfo.getString(title)));
        return addressInfo;
    }

    /** Method to assemble a warningsList list
     * @param jsonWarnings: jsonObject obtained by response request
     * @return warningsList list as {@link ArrayList} of {@link Warning}
     * **/
    private ArrayList<Warning> assembleWarningList(JSONArray jsonWarnings){
        ArrayList<Warning> warnings = new ArrayList<>();
        if(jsonWarnings != null){
            for (int j = 0; j < jsonWarnings.length(); j++){
                JSONObject warning = jsonWarnings.getJSONObject(j);
                warnings.add(new Warning(warning.getString("title"),
                        warning.getString("details"),
                        warning.getString("image_url")
                ));
            }
        }
        return warnings;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<AddressInfo> getAddressInfoList() {
        return addressInfoList;
    }

    public void setAddressInfoList(ArrayList<AddressInfo> addressInfoList) {
        this.addressInfoList = addressInfoList;
    }

    public void insertAddressInfo(AddressInfo addressInfo){
        if(!addressInfoList.contains(addressInfo))
            addressInfoList.add(addressInfo);
    }

    public boolean removeAddressInfo(AddressInfo addressInfo){
        return addressInfoList.remove(addressInfo);
    }

    public AddressInfo getAddressInfo(int index){
        return addressInfoList.get(index);
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getNetwork() {
        return network;
    }

    public String getUriScheme() {
        return uriScheme;
    }

    public String getResource() {
        return resource;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public String getDepositUri() {
        return depositUri;
    }

    public boolean isExchangeDepositAddress() {
        return exchangeDepositAddress;
    }

    public ArrayList<Warning> getWarningsList() {
        return warningsList;
    }

    public void setWarningsList(ArrayList<Warning> warningsList) {
        this.warningsList = warningsList;
    }

    public void insertAddressInfo(Warning warning){
        if(!warningsList.contains(warning))
            warningsList.add(warning);
    }

    public boolean removeAddressInfo(Warning warning){
        return warningsList.remove(warning);
    }

    public Warning getWarning(int index){
        return warningsList.get(index);
    }

    /**
     * The {@code AddressInfo} class is useful to obtain and format AddressInfo object for CryptoAddress <br>
     * This class give info about crypto address used in the request
     * @author N7ghtm4r3 - Tecknobit
     * **/
    public static class AddressInfo {

        /**
         * {@code titleInfo} is instance that memorizes title info value
         * **/
        private final String titleInfo;

        /**
         * {@code valueInfo} is instance that memorizes info value
         * **/
        private final String valueInfo;

        /** Constructor to init a {@link AddressInfo} object
         * @param titleInfo: title info
         * @param valueInfo: info value
         * **/
        public AddressInfo(String titleInfo, String valueInfo) {
            this.titleInfo = titleInfo;
            this.valueInfo = valueInfo;
        }

        public String getTitleInfo() {
            return titleInfo;
        }

        public String getValueInfo() {
            return valueInfo;
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

        public String getTitle() {
            return title;
        }

        public String getDetails() {
            return details;
        }

        public String getImageUrl() {
            return imageUrl;
        }

    }

}
