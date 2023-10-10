package com.example.deliverycompany.View.Data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.deliverycompany.Model.Address;
import com.example.deliverycompany.Model.Customer;
import com.example.deliverycompany.Model.Dao.CustomerDao;
import com.example.deliverycompany.Model.Dao.RouteDao;
import com.example.deliverycompany.Model.Route;

@Database(entities = {Customer.class, Route.class, Address.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB database;
    private static final String DATABASE_NAME = "myDeliveryDataDb";

    public synchronized static RoomDB getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(
                            context.getApplicationContext(),
                            RoomDB.class,
                            DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract CustomerDao customerDao();
    public abstract RouteDao routeDao();
}

