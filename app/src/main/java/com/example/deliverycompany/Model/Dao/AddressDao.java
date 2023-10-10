package com.example.deliverycompany.Model.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.deliverycompany.Model.Address;

import java.util.List;

@Dao
public interface AddressDao {

    // Method to insert a new address into the database.
    @Insert
    long insertAddress(Address address);

    // Method to update an existing address in the database.
    @Update
    int updateAddress(Address address);

    // Method to delete an address from the database.
    @Delete
    int deleteAddress(Address address);

    // Method to fetch all addresses from the database.
    @Query("SELECT * FROM addresses")
    LiveData<List<Address>> getAllAddresses();

    // Method to fetch addresses by route ID from the database.
    @Query("SELECT * FROM addresses WHERE routeId = :routeId")
    List<Address> getAddressesByRouteId(int routeId);

    // Add other query methods as required for further development.
}
