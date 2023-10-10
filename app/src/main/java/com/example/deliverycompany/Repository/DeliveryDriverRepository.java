package com.example.deliverycompany.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.deliverycompany.Model.Dao.DeliveryDriverDao;
import com.example.deliverycompany.Model.DeliveryDriver;
import com.example.deliverycompany.View.Data.AppDatabase;

import java.util.List;

public class DeliveryDriverRepository {

    private final DeliveryDriverDao deliveryDriverDao;
    private final LiveData<List<DeliveryDriver>> allDrivers;

    public DeliveryDriverRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        deliveryDriverDao = db.deliveryDriverDao();
        allDrivers = deliveryDriverDao.getAllDrivers();
    }

    public LiveData<List<DeliveryDriver>> getAllDrivers() {
        return allDrivers;
    }

    public void insertDriver(DeliveryDriver driver) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            try {
                deliveryDriverDao.insertDriver(driver);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        });
    }

    public DeliveryDriver getDriverById(int driverId) {
        // Since this is a synchronous method, ensure it's not called on the main thread
        return deliveryDriverDao.getDriverById(driverId);
    }

    public void updateDriver(DeliveryDriver driver) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            try {
                deliveryDriverDao.updateDriver(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteDriver(int driverId) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            try {
                DeliveryDriver driver = deliveryDriverDao.getDriverById(driverId);
                if (driver != null) {
                    deliveryDriverDao.deleteDriver(driver);
                }
            } catch (Exception e) {
                // Log the exception or handle it as needed
                e.printStackTrace();
            }
        });
    }
}
