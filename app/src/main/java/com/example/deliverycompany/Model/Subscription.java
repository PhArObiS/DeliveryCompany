package com.example.deliverycompany.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "subscriptions",
        foreignKeys = @ForeignKey(entity = Customer.class,
                parentColumns = "id",
                childColumns = "customerId",
                onDelete = ForeignKey.CASCADE),
        indices = {@Index("customerId")})
public class Subscription {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String customerId;
    private String customerName;
    private String address;
    private String product;
    private int quantity;

    public Subscription(String customerName, String address, String product, int quantity, String customerId) {
        this.customerName = customerName;
        this.address = address;
        this.product = product;
        this.quantity = quantity;
        this.customerId = customerId;
    }


    // Getter and Setter for ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    // Overriding the toString method for better log readability
    @Override
    public String toString() {
        return "Customer Name: " + customerName +
                ", Address: " + address +
                ", Product: " + product +
                ", Quantity: " + quantity;
    }
}