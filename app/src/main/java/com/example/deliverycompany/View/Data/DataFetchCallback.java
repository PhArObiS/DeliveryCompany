package com.example.deliverycompany.View.Data;

public interface DataFetchCallback<T> {
    void onDataFetched(T data);
    void onError(Exception e);
}

