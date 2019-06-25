package com.sadek.ekatapp.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaDataEntity {
    @Expose
    @SerializedName("value")
    private String value;
    @Expose
    @SerializedName("key")
    private String key;
    @Expose
    @SerializedName("id")
    private int id;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
