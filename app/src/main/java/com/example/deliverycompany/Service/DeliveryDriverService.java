package com.example.deliverycompany.Service;

import android.app.Application;

import com.example.deliverycompany.Model.DeliveryDriver;
import com.example.deliverycompany.Repository.DeliveryDriverRepository;

public class DeliveryDriverService {
    private final DeliveryDriverRepository repository;

    public DeliveryDriverService(Application application) {
        repository = new DeliveryDriverRepository(application);
    }

    public void addDriver(DeliveryDriver driver) {
        repository.insertDriver(driver);
    }

    public DeliveryDriver getDriverById(int id) {
        return repository.getDriverById(id);
    }

    public void removeDriver(int id) {
        repository.deleteDriver(id);
    }

}
