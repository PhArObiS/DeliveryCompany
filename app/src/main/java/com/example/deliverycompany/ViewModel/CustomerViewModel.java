package com.example.deliverycompany.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.deliverycompany.Model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerViewModel extends ViewModel {
    private final MutableLiveData<List<Customer>> customers = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Customer>> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        List<Customer> currentCustomers = customers.getValue();
        currentCustomers.add(customer);
        customers.setValue(currentCustomers);
    }

    public void removeCustomer(String id) {
        List<Customer> currentCustomers = customers.getValue();
        currentCustomers.removeIf(customer -> customer.getId().equals(id));
        customers.setValue(currentCustomers);
    }

    public LiveData<List<Customer>> getAllCustomers() {
        return customers;
    }

    public void insert(Customer newCustomer) {
        List<Customer> currentCustomers = customers.getValue();
        currentCustomers.add(newCustomer);
        customers.setValue(currentCustomers);
    }
}
