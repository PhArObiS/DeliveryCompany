package com.example.deliverycompany.Model;

import androidx.room.Entity;
import androidx.room.Index;

import java.util.Objects;

@Entity(indices = {@Index(value = "name")})
public class Product {
    private String id;
    private String name;
    private String description;

    // Constructor to initialize the product object
    public Product(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter and setter methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Overriding toString for better readability
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // Overriding equals to compare Product objects based on their attributes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    // Overriding hashCode to generate a unique hash based on the Product attributes
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
