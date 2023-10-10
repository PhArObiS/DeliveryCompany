package com.example.deliverycompany.Service;

import com.example.deliverycompany.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        // TODO: Add validation and business rules here
        products.add(product);
    }

    public Product getProductById(String id) {
        // TODO: Implement logic to retrieve a product by their ID
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

}