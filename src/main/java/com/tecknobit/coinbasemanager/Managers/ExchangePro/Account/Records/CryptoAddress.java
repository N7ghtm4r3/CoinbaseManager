package com.tecknobit.coinbasemanager.Managers.ExchangePro.Account.Records;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code CryptoAddress} class is useful to format CryptoAddress object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class CryptoAddress {

    private final String id;
    private final String address;
    private ArrayList<AddressInfo> addressInfoList;
    private final String name;
    private final String createdAt;
    private final String updatedAt;
    private final String network;
    private final String uriScheme;
    private final String resource;
    private final String resourcePath;
    private final String depositUri;
    private final boolean exchangeDepositAddress;
    private ArrayList<Warning> warningsList;

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
     * @param #jsonAddressInfo: jsonObject obtained by response request
     * @return address info list as {@link ArrayList} of {@link AddressInfo}
     * **/
    private ArrayList<AddressInfo> assembleAddressInfo(JSONObject jsonAddressInfo) {
        ArrayList<AddressInfo> addressInfo = new ArrayList<>();
        for (String title : jsonAddressInfo.keySet())
            addressInfo.add(new AddressInfo(title, jsonAddressInfo.getString(title)));
        return addressInfo;
    }

    /** Method to assemble a warningsList list
     * @param #jsonWarnings: jsonObject obtained by response request
     * @return warningsList list as {@link ArrayList} of {@link Warning}
     * **/
    private ArrayList<Warning> assembleWarningList(JSONArray jsonWarnings){
        ArrayList<Warning> warnings = new ArrayList<>();
        for (int j=0; j < jsonWarnings.length(); j++){
            JSONObject warning = jsonWarnings.getJSONObject(j);
            warnings.add(new Warning(warning.getString("title"),
                    warning.getString("details"),
                    warning.getString("image_url")
            ));
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

    /**
     * The {@code AddressInfo} class is useful to obtain and format AddressInfo object for CryptoAddress
     * This class give info about crypto address used in the request
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses</a>
     * **/
    public static class AddressInfo{

        private final String titleInfo;
        private final String valueInfo;

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
     * The {@code Warning} class is useful to obtain and format Warning object for CryptoAddress
     * This class give warningsList about crypto address used in the request
     * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postcoinbaseaccountaddresses</a>
     * **/
    public static class Warning{

        private final String title;
        private final String details;
        private final String imageUrl;

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
