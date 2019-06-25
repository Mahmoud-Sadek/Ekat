package com.sadek.ekatapp.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LinksEntity {
    @Expose
    @SerializedName("collection")
    private List<CollectionEntity> collection;
    @Expose
    @SerializedName("self")
    private List<SelfEntity> self;

    public List<CollectionEntity> getCollection() {
        return collection;
    }

    public void setCollection(List<CollectionEntity> collection) {
        this.collection = collection;
    }

    public List<SelfEntity> getSelf() {
        return self;
    }

    public void setSelf(List<SelfEntity> self) {
        this.self = self;
    }
}
