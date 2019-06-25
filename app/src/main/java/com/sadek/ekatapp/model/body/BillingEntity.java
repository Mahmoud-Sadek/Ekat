package com.sadek.ekatapp.model.body;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillingEntity {
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("country")
    private String country;
    @Expose
    @SerializedName("postcode")
    private String postcode;
    @Expose
    @SerializedName("state")
    private String state;
    @Expose
    @SerializedName("city")
    private String city;
    @Expose
    @SerializedName("address_2")
    private String address2;
    @Expose
    @SerializedName("address_1")
    private String address1;
    @Expose
    @SerializedName("company")
    private String company;
    @Expose
    @SerializedName("last_name")
    private String lastName;
    @Expose
    @SerializedName("first_name")
    private String firstName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
}
