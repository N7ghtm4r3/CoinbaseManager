package com.tecknobit.coinbasemanager.Managers.ExchangePro.Profiles.Records;

/**
 * The {@code Profile} class is useful to format Profile object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate">https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Profile {

    private final String id;
    private final String userId;
    private String name;
    private boolean active;
    private boolean isDefault;
    private final String createdAt;
    private boolean hasMargin;

    public Profile(String id, String userId, String name, boolean active, boolean isDefault, String createdAt,
                   boolean hasMargin) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.active = active;
        this.isDefault = isDefault;
        this.createdAt = createdAt;
        this.hasMargin = hasMargin;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isHasMargin() {
        return hasMargin;
    }

    public void setHasMargin(boolean hasMargin) {
        this.hasMargin = hasMargin;
    }

}
