package com.sadek.ekatapp.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sadek.ekatapp.model.body.BillingEntity;
import com.sadek.ekatapp.model.body.ShippingEntity;

import java.util.List;

public  class SignupResponse {


    @Expose
    @SerializedName("_links")
    private LinksEntity Links;
    @Expose
    @SerializedName("meta_data")
    private List<MetaDataEntity> metaData;
    @Expose
    @SerializedName("avatar_url")
    private String avatarUrl;
    @Expose
    @SerializedName("is_paying_customer")
    private boolean isPayingCustomer;
    @Expose
    @SerializedName("shipping")
    private ShippingEntity shipping;
    @Expose
    @SerializedName("billing")
    private BillingEntity billing;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("role")
    private String role;
    @Expose
    @SerializedName("last_name")
    private String lastName;
    @Expose
    @SerializedName("first_name")
    private String firstName;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("date_modified_gmt")
    private String dateModifiedGmt;
    @Expose
    @SerializedName("date_modified")
    private String dateModified;
    @Expose
    @SerializedName("date_created_gmt")
    private String dateCreatedGmt;
    @Expose
    @SerializedName("date_created")
    private String dateCreated;
    @Expose
    @SerializedName("id")
    private int id;

    public LinksEntity getLinks() {
        return Links;
    }

    public void setLinks(LinksEntity Links) {
        this.Links = Links;
    }

    public List<MetaDataEntity> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<MetaDataEntity> metaData) {
        this.metaData = metaData;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean getIsPayingCustomer() {
        return isPayingCustomer;
    }

    public void setIsPayingCustomer(boolean isPayingCustomer) {
        this.isPayingCustomer = isPayingCustomer;
    }

    public ShippingEntity getShipping() {
        return shipping;
    }

    public void setShipping(ShippingEntity shipping) {
        this.shipping = shipping;
    }

    public BillingEntity getBilling() {
        return billing;
    }

    public void setBilling(BillingEntity billing) {
        this.billing = billing;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }

    public void setDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    public void setDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
