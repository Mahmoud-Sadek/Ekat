package com.sadek.ekatapp.model;

public class ProductModel {
    String image, title, price, kind;

    public ProductModel(String image, String title, String price, String kind) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.kind = kind;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
