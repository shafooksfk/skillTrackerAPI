package com.skillTracker.profile.model;

public class SearchProfile {
    public String name;
    public String associateId;

    public SearchProfile() {
    }

    public SearchProfile(String name, String associateId) {
        this.name = name;
        this.associateId = associateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}
