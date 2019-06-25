package com.sadek.ekatapp.model.body;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupBody {


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
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("last_name")
    private String lastName;
    @Expose
    @SerializedName("first_name")
    private String firstName;
    @Expose
    @SerializedName("email")
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
