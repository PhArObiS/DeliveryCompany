package com.example.deliverycompany.Service;

import com.example.deliverycompany.Model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteService {
    private final List<Route> routes = new ArrayList<>();

    public void addRoute(Route route) {
        // TODO: Add validation and business rules here
        routes.add(route);
    }

    public Route getRouteById(int id) {
        // TODO: Implement logic to retrieve a route by their ID
        for (Route route : routes) {
            if (route.getId() == id) {
                return route;
            }
        }
        return null;
    }

    public void removeRoute(int id) {
        routes.removeIf(route -> route.getId() == id);
    }

}
