package com.example.deliverycompany.Service;

import com.example.deliverycompany.Model.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionService {
    private final List<Subscription> subscriptions = new ArrayList<>();

    public void addSubscription(Subscription subscription) {
        // TODO: Add validation and business rules here
        subscriptions.add(subscription);
    }

    public Subscription getSubscriptionById(String id) {
        for (Subscription subscription : subscriptions) {
            if (id.equals(subscription.getId())) {
            }
        }
        return null;
    }


    public void removeSubscription(String id) {
        subscriptions.removeIf(subscription -> id.equals(subscription.getId()));
    }


}
