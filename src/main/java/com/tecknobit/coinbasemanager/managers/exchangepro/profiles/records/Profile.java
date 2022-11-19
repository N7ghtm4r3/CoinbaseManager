package com.tecknobit.coinbasemanager.managers.exchangepro.profiles.records;

import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONObject;

/**
 * The {@code Profile} class is useful to format Profile object
 * @apiNote see the official documentation at:
 * <ul>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofiles-1">
 * Get profiles</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofile-1">
 * Create a profile</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postprofiletransfer-1">
 * Transfer funds between profiles</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getprofile-1">
 * Get profile by id</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofile-1">
 * Rename a profile</a>
 * </li>
 * <li>
 * <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_putprofiledeactivate-1">
 * Delete a profile</a>
 * </li>
 * </ul>
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
     **/
    private final String createdAt;

    /**
     * {@code hasMargin} is flag that checks if profile has margin
     **/
    private boolean hasMargin;

    /**
     * Constructor to init a {@link Profile} custom object
     *
     * @param id:        identifier value
     * @param userId:    user identifier value
     * @param name:      name value
     * @param active:    flag that checks if profile is active
     * @param isDefault: flag that checks if profile is default
     * @param createdAt: created at value
     * @param hasMargin: has margin
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Profile(String id, String userId, String name, boolean active, boolean isDefault, String createdAt,
                   boolean hasMargin) {
        this.id = id;
        this.userId = userId;
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        else
            this.name = name;
        this.active = active;
        this.isDefault = isDefault;
        this.createdAt = createdAt;
        this.hasMargin = hasMargin;
    }

    /**
     * Constructor to init a {@link Profile} custom object
     *
     * @param profile: profile details as {@link JSONObject}
     * @throws IllegalArgumentException if parameters range is not respected
     **/
    public Profile(JSONObject profile) {
        this(profile.getString("id"), profile.getString("user_id"), profile.getString("name"),
                profile.getBoolean("active"), profile.getBoolean("is_default"),
                profile.getString("created_at"), profile.getBoolean("has_margin"));
    }

    /**
     * MethodId to get {@link #id} instance <br>
     * Any params required
     *
     * @return {@link #id} instance as {@link String}
     **/
    public String getId() {
        return id;
    }

    /**
     * MethodId to get {@link #userId} instance <br>
     * Any params required
     *
     * @return {@link #userId} instance as {@link String}
     **/
    public String getUserId() {
        return userId;
    }

    /**
     * MethodId to get {@link #name} instance <br>
     * Any params required
     *
     * @return {@link #name} instance as {@link String}
     **/
    public String getName() {
        return name;
    }

    /**
     * MethodId to set {@link #name}
     *
     * @param name: name value
     * @throws IllegalArgumentException when name value is null or empty
     **/
    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name value cannot be empty or null");
        this.name = name;
    }

    /**
     * MethodId to get {@link #active} instance <br>
     * Any params required
     *
     * @return {@link #active} instance as boolean
     **/
    public boolean isActive() {
        return active;
    }

    /**
     * MethodId to set {@link #active}
     *
     * @param active: flag that checks if profile is active
     **/
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * MethodId to get {@link #isDefault} instance <br>
     * Any params required
     *
     * @return {@link #isDefault} instance as boolean
     **/
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * MethodId to set {@link #isDefault}
     *
     * @param isDefault: flag that checks if profile is default
     **/
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * MethodId to get {@link #createdAt} instance <br>
     * Any params required
     *
     * @return {@link #createdAt} instance as {@link String}
     **/
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * MethodId to get {@link #createdAt} timestamp <br>
     * Any params required
     *
     * @return {@link #createdAt} timestamp as long
     **/
    public long getCreatedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(createdAt);
    }

    /**
     * MethodId to get {@link #hasMargin} instance <br>
     * Any params required
     *
     * @return {@link #hasMargin} instance as boolean
     **/
    public boolean isHasMargin() {
        return hasMargin;
    }

    /**
     * MethodId to set {@link #hasMargin}
     *
     * @param hasMargin: flag that checks if profile has margin
     **/
    public void setHasMargin(boolean hasMargin) {
        this.hasMargin = hasMargin;
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
