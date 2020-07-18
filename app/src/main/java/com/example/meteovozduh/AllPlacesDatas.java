package com.example.meteovozduh;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllPlacesDatas {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<OnePlaceData> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OnePlaceData> getData() {
        return data;
    } // воздух лежит внутри OnePlaceData

    public void setData(List<OnePlaceData> data) {
        this.data = data;
    }
}
