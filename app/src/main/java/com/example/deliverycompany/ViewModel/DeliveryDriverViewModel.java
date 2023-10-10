package com.example.deliverycompany.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.deliverycompany.Model.DeliveryDriver;
import com.example.deliverycompany.Repository.DeliveryDriverRepository;

import java.util.List;

public class DeliveryDriverViewModel extends AndroidViewModel {
    private final LiveData<List<DeliveryDriver>> drivers;
    private final DeliveryDriverRepository driverRepository;

    public DeliveryDriverViewModel(Application application) {
        super(application);
        driverRepository = new DeliveryDriverRepository(application);
        drivers = driverRepository.getAllDrivers();
    }

    public LiveData<List<DeliveryDriver>> getDrivers() {
        return drivers;
    }

    public void addDriver(DeliveryDriver driver) {
        driverRepository.insertDriver(driver);
    }

    public void removeDriver(int id) {
        driverRepository.deleteDriver(id);
    }
}
