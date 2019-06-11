package com.sadek.ekatapp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CartModel extends RealmObject {
//    @PrimaryKey
    private int id;
    String  image, name, quantity, price;

    public CartModel() {
    }

    public CartModel(int id, String image, String name, String quantity, String price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
