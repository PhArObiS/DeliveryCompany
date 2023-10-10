package com.example.deliverycompany.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;  // Import ViewModelProvider

import com.example.deliverycompany.Model.Subscription;
import com.example.deliverycompany.R;
import com.example.deliverycompany.ViewModel.SubscriptionViewModel; // Import your ViewModel

public class AddSubscriptionFragment extends Fragment {

    private EditText editTextCustomerName, editTextAddress, editTextProductId, editTextQuantity;
    private Button buttonAddSubscription, buttonReturnMainMenu;
    private SubscriptionViewModel subscriptionViewModel; // Declare ViewModel

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_subcription, container, false);  // Ensure correct layout file name
        subscriptionViewModel = new ViewModelProvider(requireActivity()).get(SubscriptionViewModel.class);

        initializeViews(view);
        setOnClickListeners();

        return view;
    }

    private void initializeViews(View view) {
        editTextCustomerName = view.findViewById(R.id.edtCustomerName);
        editTextAddress = view.findViewById(R.id.edtAddress);
        editTextProductId = view.findViewById(R.id.edtProductId);
        editTextQuantity = view.findViewById(R.id.edtQuantity);

        buttonAddSubscription = view.findViewById(R.id.btnAddSubscription);
        buttonReturnMainMenu = view.findViewById(R.id.btnReturnMainMenu);
    }

    private void addSubscription() {
        String customerName = editTextCustomerName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String productId = editTextProductId.getText().toString().trim();
        String quantityString = editTextQuantity.getText().toString().trim();

        // Validation to ensure none of the fields are empty
        if (customerName.isEmpty() || address.isEmpty() || productId.isEmpty() || quantityString.isEmpty()) {
            Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Invalid quantity", Toast.LENGTH_SHORT).show();
            return;
        }

        // Creating a Subscription object with the entered data
        Subscription subscription = new Subscription(customerName, address, productId, quantity, "someCustomerId");

        // Using ViewModel to insert subscription into the database
        subscriptionViewModel.insertSubscription(subscription);

        // Providing feedback to the user about the operation
        Toast.makeText(getContext(), "Subscription Added", Toast.LENGTH_SHORT).show();
    }

    private void setOnClickListeners() {
        // Setting listener for add subscription button
        buttonAddSubscription.setOnClickListener(v -> addSubscription());

        // Setting listener for return to main menu button
        buttonReturnMainMenu.setOnClickListener(v -> {
            // Replacing the current fragment with a new one (MenuFragment)
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new MenuFragment());  // Ensure you have a MenuFragment class
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}
