package com.example.deliverycompany.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.deliverycompany.Model.Address;
import com.example.deliverycompany.Repository.AddressRepository;

import java.util.List;

public class AddressViewModel extends AndroidViewModel {

    private AddressRepository repository; // Instance of the AddressRepository
    private LiveData<List<Address>> allAddresses; // LiveData instance to hold all addresses

    // Constructor
    public AddressViewModel(@NonNull Application application) {
        super(application);
        repository = new AddressRepository(application);
        allAddresses = repository.getAllAddresses();
    }

    // Insert a new address
    public void insert(Address address) {
        repository.insert(address);
    }

    // Update an existing address
    public void update(Address address) {
        repository.update(address);
    }

    // Delete an address
    public void delete(Address address) {
        repository.delete(address);
    }

    // get all addresses
    public LiveData<List<Address>> getAllAddresses() {
        return allAddresses;
    }
}
