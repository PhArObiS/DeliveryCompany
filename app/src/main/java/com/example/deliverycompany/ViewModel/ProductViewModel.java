package com.example.deliverycompany.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.deliverycompany.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {
    private final MutableLiveData<List<Product>> products = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Product>> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        List<Product> currentProducts = products.getValue();
        currentProducts.add(product);
        products.setValue(currentProducts);
    }

    public void removeProduct(String id) {
        List<Product> currentProducts = products.getValue();
        currentProducts.removeIf(product -> product.getId().equals(id));
        products.setValue(currentProducts);
    }
}
