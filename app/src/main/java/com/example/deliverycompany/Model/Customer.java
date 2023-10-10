package com.example.deliverycompany.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Objects;

// Annotations to define 'customers' as the table name in your Room database
@Entity(tableName = "customers",
        indices = {@Index(value = "name", unique = false)})
public class Customer {
    @PrimaryKey
    @NonNull
    private String id;
    private String name;
    private String address;

    // Constructor to initialize the Customer object
    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Getters
    // ID of the customer
    public String getId() {
        return id;
    }

    // Name of the customer
    public String getName() {
        return name;
    }

    // Address of the customer
    public String getAddress() {
        return address;
    }

    // Setters
    // ID of the customer
    public void setId(String id) {
        this.id = id;
    }

    // Name of the customer
    public void setName(String name) {
        this.name = name;
    }

    // Address of the customer
    public void setAddress(String address) {
        this.address = address;
    }

    // String of Customer object
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Compare two Customer objects based on their attributes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(address, customer.address);
    }

    // Overridden hashCode method to return a hashcode for the Customer object based on its attributes
    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
