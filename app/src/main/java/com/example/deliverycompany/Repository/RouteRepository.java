package com.example.deliverycompany.Repository;

import android.content.Context;

import com.example.deliverycompany.Model.Dao.RouteDao;
import com.example.deliverycompany.Model.Route;
import com.example.deliverycompany.View.Data.AppDatabase;
import com.example.deliverycompany.View.Data.DataFetchCallback;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RouteRepository {

    private final RouteDao routeDao;
    private final ExecutorService executorService;

    public RouteRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        routeDao = db.routeDao();
        executorService = Executors.newFixedThreadPool(2);
    }

    public void getAllRoutes(DataFetchCallback<List<Route>> callback) {
        executorService.execute(() -> {
            try {
                List<Route> routes = routeDao.getAllRoutes();
                if (callback != null) callback.onDataFetched(routes);
            } catch (Exception e) {
                if (callback != null) callback.onError(e);
            }
        });
    }
}
