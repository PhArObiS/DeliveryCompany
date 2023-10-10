package com.example.deliverycompany.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.deliverycompany.Model.Subscription;
import com.example.deliverycompany.Repository.SubscriptionRepository;

import java.util.List;

public class SubscriptionViewModel extends AndroidViewModel {

    private final SubscriptionRepository subscriptionRepository;
    private final LiveData<List<Subscription>> allSubscriptions;

    public SubscriptionViewModel(Application application) {
        super(application);
        subscriptionRepository = new SubscriptionRepository(application);
        allSubscriptions = subscriptionRepository.getAllSubscriptions();
    }

    public LiveData<List<Subscription>> getAllSubscriptions() {
        return allSubscriptions;
    }

    public void deleteSubscription(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }

    public void insertSubscription(Subscription subscription) {
        subscriptionRepository.insert(subscription);
    }


}

