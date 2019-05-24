package com.sadek.ekatapp.model;

public class OrderModel {
    String orderName, orderNumber, orderDate, orderStatus;

    public OrderModel(String orderName, String orderNumber, String orderDate, String orderStatus) {
        this.orderName = orderName;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
