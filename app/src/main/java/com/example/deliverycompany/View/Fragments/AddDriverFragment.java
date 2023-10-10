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
import androidx.lifecycle.ViewModelProvider;

import com.example.deliverycompany.R;
import com.example.deliverycompany.ViewModel.DeliveryDriverViewModel;
import com.example.deliverycompany.Model.DeliveryDriver;

public class AddDriverFragment extends Fragment {

    // Required empty public constructor
    public AddDriverFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_driver, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initializing UI elements
        EditText edtName = view.findViewById(R.id.edtDriverName);
        EditText edtPhone = view.findViewById(R.id.edtDriverPhone);
        Button btnSave = view.findViewById(R.id.btnSaveDriver);

        // Initializing ViewModel
        DeliveryDriverViewModel viewModel = new ViewModelProvider(requireActivity()).get(DeliveryDriverViewModel.class);

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();

            if (!name.isEmpty() && !phone.isEmpty()) {
                // Creating a new DeliveryDriver object with the provided name and phone number
                DeliveryDriver newDriver = new DeliveryDriver(name, phone);

                // Using the ViewModel to add the new driver to the database
                viewModel.addDriver(newDriver);

                // Providing user feedback that the driver has been added
                Toast.makeText(getActivity(), "Driver added", Toast.LENGTH_SHORT).show();

                // Clearing the input fields after successful addition
                edtName.setText("");
                edtPhone.setText("");
            } else {
                // Providing user feedback in case of incomplete inputs
                Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
