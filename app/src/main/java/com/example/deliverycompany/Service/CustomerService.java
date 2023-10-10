package com.example.deliverycompany.Service;

import com.example.deliverycompany.Model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    // Add a new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Retrieve a customer by ID
    public Customer getCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(String.valueOf(id))) {
                return customer;
            }
        }
        return null;
    }

}
