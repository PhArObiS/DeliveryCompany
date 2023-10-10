package com.example.deliverycompany.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.deliverycompany.Model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteViewModel extends ViewModel {
    private final MutableLiveData<List<Route>> routes = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Route>> getRoutes() {
        return routes;
    }

    public void addRoute(Route route) {
        List<Route> currentRoutes = routes.getValue();
        currentRoutes.add(route);
        routes.setValue(currentRoutes);
    }

    public void removeRoute(int id) {
        List<Route> currentRoutes = routes.getValue();
        currentRoutes.removeIf(route -> route.getId() == id);
        routes.setValue(currentRoutes);
    }
}
