package com.example.deliverycompany.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.deliverycompany.Model.Customer;
import com.example.deliverycompany.Model.Dao.CustomerDao;
import com.example.deliverycompany.View.Data.AppDatabase;

import java.util.List;

public class CustomerRepository {

    private CustomerDao customerDao;

    public CustomerRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        customerDao = db.customerDao();
    }

    public void addCustomer(Customer customer) {
        new InsertCustomerAsyncTask(customerDao).execute(customer);
    }

    public LiveData<List<Customer>> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    // Task for Inserting Customer
    private static class InsertCustomerAsyncTask extends AsyncTask<Customer, Void, Void> {
        private CustomerDao customerDao;

        private InsertCustomerAsyncTask(CustomerDao customerDao) {
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customer... customers) {
            customerDao.insertCustomer(customers[0]);
            return null;
        }
    }

    // TODO: Implement update, delete, and other operations

    // Updating Customer
    private static class UpdateCustomerAsyncTask extends AsyncTask<Customer, Void, Void> {
        private CustomerDao customerDao;

        private UpdateCustomerAsyncTask(CustomerDao customerDao) {
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customer... customers) {
            customerDao.updateCustomer(customers[0]);
            return null;
        }
    }

    // Deleting Customer
    private static class DeleteCustomerAsyncTask extends AsyncTask<Customer, Void, Void> {
        private CustomerDao customerDao;

        private DeleteCustomerAsyncTask(CustomerDao customerDao) {
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customer... customers) {
            customerDao.deleteCustomer(customers[0]);
            return null;
        }
    }
}

