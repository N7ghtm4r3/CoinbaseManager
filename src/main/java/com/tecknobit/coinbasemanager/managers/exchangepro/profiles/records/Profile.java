package com.tecknobit.coinbasemanager.managers.exchangepro.profiles.records;

import org.json.JSONObject;

/**
 * The {@code Profile} class is useful to format Profile object
 * @apiNote see the official documentation at:
<ul>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1</a>
</li>
<li>
<a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate-1">
https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate-1</a>
</li>
</ul>
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

    /** Constructor to init a {@link Profile} object
     * @param profile: profile details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     * **/
    public Profile(JSONObject profile) {
        id = profile.getString("id");
        userId = profile.getString("user_id");
        name = profile.getString("name");
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        active = profile.getBoolean("active");
        isDefault = profile.getBoolean("is_default");
        createdAt = profile.getString("created_at");
        hasMargin = profile.getBoolean("has_margin");
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

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", isDefault=" + isDefault +
                ", createdAt='" + createdAt + '\'' +
                ", hasMargin=" + hasMargin +
                '}';
    }

}
