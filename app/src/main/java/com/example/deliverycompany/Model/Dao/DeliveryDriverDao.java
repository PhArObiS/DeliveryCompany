package com.example.deliverycompany.Model.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.deliverycompany.Model.DeliveryDriver;

import java.util.List;

@Dao
public interface DeliveryDriverDao {

    @Insert
    long insertDriver(DeliveryDriver driver);

    @Update
    int updateDriver(DeliveryDriver driver);

    @Delete
    int deleteDriver(DeliveryDriver driver);

    @Query("SELECT * FROM DeliveryDriver")
    LiveData<List<DeliveryDriver>> getAllDrivers();


    @Query("SELECT * FROM DeliveryDriver WHERE id = :driverId")
    DeliveryDriver getDriverById(int driverId);

    @Query("SELECT * FROM DeliveryDriver WHERE name = :driverName")
    List<DeliveryDriver> getDriversByName(String driverName);

    // Add any other methods as needed
}

