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
    private final String name;
    private final boolean active;
    private final boolean isDefault;
    private final String createdAt;
    private final boolean hasMargin;

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

    public boolean isActive() {
        return active;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isHasMargin() {
        return hasMargin;
    }

}
