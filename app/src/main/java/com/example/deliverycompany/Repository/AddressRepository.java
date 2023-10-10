package com.example.deliverycompany.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.deliverycompany.Model.Address;
import com.example.deliverycompany.Model.Dao.AddressDao;
import com.example.deliverycompany.View.Data.AppDatabase;

import java.util.List;

public class AddressRepository {

    private AddressDao addressDao;
    private LiveData<List<Address>> allAddresses;

    // Constructor
    public AddressRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        addressDao = database.addressDao();
        allAddresses = addressDao.getAllAddresses();
    }

    // Insert Method
    public void insert(Address address) {
        new InsertAddressAsyncTask(addressDao).execute(address);
    }

    // Update Method
    public void update(Address address) {
        new UpdateAddressAsyncTask(addressDao).execute(address);
    }

    // Delete Method
    public void delete(Address address) {
        new DeleteAddressAsyncTask(addressDao).execute(address);
    }

    // Get All Addresses
    public LiveData<List<Address>> getAllAddresses() {
        return allAddresses;
    }

    // Task for Inserting Address
    private static class InsertAddressAsyncTask extends AsyncTask<Address, Void, Void> {
        private AddressDao addressDao;

        private InsertAddressAsyncTask(AddressDao addressDao) {
            this.addressDao = addressDao;
        }

        @Override
        protected Void doInBackground(Address... addresses) {
            addressDao.insertAddress(addresses[0]);
            return null;
        }
    }

    // Task for Updating Address
    private static class UpdateAddressAsyncTask extends AsyncTask<Address, Void, Void> {
        private AddressDao addressDao;

        private UpdateAddressAsyncTask(AddressDao addressDao) {
            this.addressDao = addressDao;
        }

        @Override
        protected Void doInBackground(Address... addresses) {
            addressDao.updateAddress(addresses[0]);
            return null;
        }
    }

    // Task for Deleting Address
    private static class DeleteAddressAsyncTask extends AsyncTask<Address, Void, Void> {
        private AddressDao addressDao;

        private DeleteAddressAsyncTask(AddressDao addressDao) {
            this.addressDao = addressDao;
        }

        @Override
        protected Void doInBackground(Address... addresses) {
            addressDao.deleteAddress(addresses[0]);
            return null;
        }
    }
}
