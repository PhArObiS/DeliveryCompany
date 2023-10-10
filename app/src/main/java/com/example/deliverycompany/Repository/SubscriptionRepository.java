package com.example.deliverycompany.Repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.deliverycompany.Model.Dao.SubscriptionDao;
import com.example.deliverycompany.Model.Subscription;
import com.example.deliverycompany.View.Data.AppDatabase;

import java.util.List;

public class SubscriptionRepository {

    private final SubscriptionDao subscriptionDao;

    public SubscriptionRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        subscriptionDao = db.subscriptionDao();
    }

    public LiveData<List<Subscription>> getAllSubscriptions() {
        return subscriptionDao.getAllSubscriptions();
    }

    public void insert(Subscription subscription) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            try {
                subscriptionDao.insertSubscription(subscription);
                Log.d("SubscriptionRepo", "Subscription inserted successfully");
            } catch (Exception e) {
                Log.e("SubscriptionRepo", "Error inserting subscription", e);
            }
        });
    }

    public void delete(Subscription subscription) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            try {
                subscriptionDao.deleteSubscription(subscription);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }


}
