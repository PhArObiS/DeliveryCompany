package com.example.deliverycompany.Model.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.deliverycompany.Model.Customer;

import java.util.List;

// Annotation to indicate that this interface is a DAO
@Dao
public interface CustomerDao {

    // Method to insert a customer into the database
    // It returns a long value which is the new rowId for the inserted item
    @Insert
    long insertCustomer(Customer customer);

    // Method to update a customer in the database
    @Update
    void updateCustomer(Customer customer);

    // Method to delete a customer from the database
    @Delete
    void deleteCustomer(Customer customer);

    // Method to get a customer by ID from the database
    // The :id is a named parameter that gets replaced by the id argument at runtime
    @Query("SELECT * FROM customers WHERE id = :id")
    Customer getCustomerById(String id);

    // Method to get all customers from the database
    @Query("SELECT * FROM customers")
    LiveData<List<Customer>> getAllCustomers();


    // You can add more queries as needed based on your requirements
}
