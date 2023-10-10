package com.example.deliverycompany.Utilities;

import androidx.room.TypeConverter;

import com.example.deliverycompany.Model.Subscription;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class Converters {
    Gson gson = new Gson();

    @TypeConverter
    public String fromSubscriptionList(List<Subscription> subscriptions) {
        if (subscriptions == null || subscriptions.isEmpty()) {
            return null;
        }
        Type type = new TypeToken<List<Subscription>>() {}.getType();
        return gson.toJson(subscriptions, type);
    }

    @TypeConverter
    public List<Subscription> toSubscriptionList(String subscriptionsString) {
        if (subscriptionsString == null || subscriptionsString.isEmpty()) {
            return Collections.emptyList();
        }
        Type type = new TypeToken<List<Subscription>>() {}.getType();
        return gson.fromJson(subscriptionsString, type);
    }
}
