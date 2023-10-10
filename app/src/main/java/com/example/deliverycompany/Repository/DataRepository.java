package com.example.deliverycompany.Repository;

import android.content.Context;

import com.example.deliverycompany.Model.Address;
import com.example.deliverycompany.Model.Dao.RouteDao;
import com.example.deliverycompany.Model.Dao.SubscriptionDao;
import com.example.deliverycompany.Model.Route;
import com.example.deliverycompany.Model.Subscription;
import com.example.deliverycompany.View.Data.AppDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataRepository {

    private final RouteDao routeDao;
    private final SubscriptionDao subscriptionDao;
    private final AppDatabase db;
    private final ExecutorService executorService;

    public DataRepository(Context context) {
        db = AppDatabase.getInstance(context);
        routeDao = db.routeDao();
        subscriptionDao = db.subscriptionDao();
        executorService = Executors.newFixedThreadPool(2);
    }

    public void getAddressesByRouteId(int routeId, DataFetchCallback<List<Address>> callback) {
        executorService.execute(() -> {
            try {
                List<Address> addresses = routeDao.getAddressesByRouteId(routeId);
                if (callback != null) callback.onDataFetched(addresses);
            } catch (Exception e) {
                if (callback != null) callback.onError(e);
            }
        });
    }

    public void insertRoute(Route route) {
        executorService.execute(() -> routeDao.insertRoute(route));
    }

    public void insertAddress(Address address) {
        executorService.execute(() -> routeDao.insertAddress(address));
    }

    public void addSubscription(Subscription subscription, DataFetchCallback<Long> callback) {
        executorService.execute(() -> {
            try {
                long rowId = subscriptionDao.insertSubscription(subscription);

                if (callback != null) callback.onDataFetched(rowId);
            } catch (Exception e) {
                if (callback != null) callback.onError(e);
            }
        });
    }

    public interface DataFetchCallback<T> {
        void onDataFetched(T data);
        void onError(Exception e);
    }
}
