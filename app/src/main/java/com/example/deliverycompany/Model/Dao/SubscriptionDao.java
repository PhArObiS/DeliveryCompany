package com.example.deliverycompany.Model.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.deliverycompany.Model.Subscription;

import java.util.List;

@Dao
public interface SubscriptionDao {

    @Insert
    long insertSubscription(Subscription subscription) throws Exception; // Add throws Exception to handle any possible exceptions

    @Delete
    void deleteSubscription(Subscription subscription) throws Exception; // Add throws Exception

    @Query("SELECT * FROM subscriptions")
    LiveData<List<Subscription>> getAllSubscriptions();
}

