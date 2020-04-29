package com.geekbrains.poplibsingle.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GsonDate {
    @Expose
    @SerializedName("time_of_year")
    public String time_of_year;

    @Expose
    @SerializedName("year")
    public Integer year;
}
