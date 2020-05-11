package com.geekbrains.poplibsingle.model.retrofit.date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigFile {
    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("size")
    public Integer size;

    @Expose
    @SerializedName("file")
    public List<Byte> file;
}
