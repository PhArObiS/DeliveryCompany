package com.example.deliverycompany.Model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.deliverycompany.Model.Address;
import com.example.deliverycompany.Model.Route;

import java.util.List;

@Dao
public interface RouteDao {

    @Query("SELECT * FROM routes")
    List<Route> getAllRoutes();

    @Query("SELECT * FROM routes WHERE route_id = :routeId")
    Route getRouteById(int routeId);

    @Insert
    long insertRoute(Route route);  // This method returns the new row ID if the insertion is successful, -1 otherwise

    @Update
    void updateRoute(Route route);

    @Delete
    void deleteRoute(Route route);

    @Query("SELECT * FROM addresses WHERE routeId = :routeId")
    List<Address> getAddressesByRouteId(int routeId);

    @Insert
    long insertAddress(Address address);

    @Update
    void updateAddress(Address address);

    @Delete
    void deleteAddress(Address address);


}


