package com.example.deliverycompany.View.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.deliverycompany.Model.Address;
import com.example.deliverycompany.Model.Customer;
import com.example.deliverycompany.Model.DeliveryDriver;
import com.example.deliverycompany.Model.Dao.AddressDao;
import com.example.deliverycompany.Model.Dao.CustomerDao;
import com.example.deliverycompany.Model.Dao.DeliveryDriverDao;
import com.example.deliverycompany.Model.Dao.RouteDao;
import com.example.deliverycompany.Model.Dao.SubscriptionDao;
import com.example.deliverycompany.Model.Route;
import com.example.deliverycompany.Model.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Customer.class, Route.class, Address.class, Subscription.class, DeliveryDriver.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CustomerDao customerDao();
    public abstract RouteDao routeDao();
    public abstract AddressDao addressDao();
    public abstract SubscriptionDao subscriptionDao();
    public abstract DeliveryDriverDao deliveryDriverDao();


    private static volatile AppDatabase INSTANCE;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
