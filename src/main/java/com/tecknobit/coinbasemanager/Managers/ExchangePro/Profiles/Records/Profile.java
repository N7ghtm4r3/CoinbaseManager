package com.tecknobit.coinbasemanager.Managers.ExchangePro.Profiles.Records;

/**
 * The {@code Profile} class is useful to format Profile object
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile</a>
 * @apiNote see official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate">
 *     https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate</a>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class Profile {

    /**
     * {@code id} is instance that memorizes identifier value
     * **/
    private final String id;

    /**
     * {@code userId} is instance that memorizes user identifier value
     * **/
    private final String userId;

    /**
     * {@code name} is instance that memorizes name value
     * **/
    private String name;

    /**
     * {@code active} is flag that checks if profile is active
     * **/
    private boolean active;

    /**
     * {@code isDefault} is flag that checks if profile is default
     * **/
    private boolean isDefault;

    /**
     * {@code createdAt} is instance that memorizes profile created at value
     * **/
    private final String createdAt;

    /**
     * {@code hasMargin} is flag that checks if profile has margin
     * **/
    private boolean hasMargin;

    /** Constructor to init a {@link Profile} object
     * @param id: identifier value
     * @param userId: user identifier value
     * @param name: name value
     * @param active: flag that checks if profile is active
     * @param isDefault: flag that checks if profile is default
     * @param createdAt: created at value
     * @param hasMargin: has margin
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Profile(String id, String userId, String name, boolean active, boolean isDefault, String createdAt,
                   boolean hasMargin) {
        this.id = id;
        this.userId = userId;
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        else
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

    /** Method to set {@link #name}
     * @param name: name value
     * @throws IllegalArgumentException when name value is null or empty
     * **/
    public void setName(String name) {
        if(name == null || name.isEmpty())
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
