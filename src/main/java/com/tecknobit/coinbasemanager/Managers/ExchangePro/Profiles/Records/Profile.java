package com.tecknobit.coinbasemanager.Managers.ExchangePro.Profiles.Records;

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
