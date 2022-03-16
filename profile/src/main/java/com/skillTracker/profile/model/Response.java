package com.skillTracker.profile.model;

import com.skillTracker.profile.entity.EngineerProfile;

import java.util.List;

public class Response {
    private String status="FAILED";
    private String message="Could not complete request";
    private EngineerProfile data;
    private List<EngineerProfile> listData;


    public Response(String status, String message, EngineerProfile data, List<EngineerProfile> listData) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.listData = listData;
    }



    public Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EngineerProfile getData() {
        return data;
    }

    public void setData(EngineerProfile data) {
        this.data = data;
    }

    public List<EngineerProfile> getListData() {
        return listData;
    }

    public void setListData(List<EngineerProfile> listData) {
        this.listData = listData;
    }
}
