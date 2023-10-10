package com.example.deliverycompany.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.deliverycompany.R;

public class ListerFragment extends Fragment {

    public ListerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lister, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initializing buttons
        Button btnDrivers = view.findViewById(R.id.btnDrivers);
        Button btnSubscribers = view.findViewById(R.id.btnSubscribers);
        Button btnRoutes = view.findViewById(R.id.btnRoutes); // Added this line
        Button btnProducts = view.findViewById(R.id.btnProducts);

        // Setting onClick listeners for buttons
//        btnDrivers.setOnClickListener(v -> {
//            // Example of replacing the right part with a DriverInfoFragment
//            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//            transaction.replace(R.id.rightContainer, new DriverInfoFragment()); // DriverInfoFragment should be created
//            transaction.addToBackStack(null);
//            transaction.commit();
//        });

//        btnSubscribers.setOnClickListener(v -> {
//            // Example of replacing the right part with a SubscriberInfoFragment
//            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//            transaction.replace(R.id.rightContainer, new SubscriberInfoFragment()); // SubscriberInfoFragment should be created
//            transaction.addToBackStack(null);
//            transaction.commit();
//        });

        btnRoutes.setOnClickListener(v -> {
            // Replace the right part with a RoutesInfoFragment
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.rightContainer, new RoutesInfoFragment()); // RoutesInfoFragment should be created
            transaction.addToBackStack(null);
            transaction.commit();
        });

//        btnProducts.setOnClickListener(v -> {
//            // Replace the right part with a ProductsInfoFragment
//            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//            transaction.replace(R.id.rightContainer, new ProductsInfoFragment()); // ProductsInfoFragment should be created
//            transaction.addToBackStack(null);
//            transaction.commit();
//        });

        Button btnBackToMenu = view.findViewById(R.id.btnBackToMenu);
        btnBackToMenu.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new MenuFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}
