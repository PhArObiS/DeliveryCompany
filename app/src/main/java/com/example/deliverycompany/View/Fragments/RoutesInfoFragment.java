package com.example.deliverycompany.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.deliverycompany.R;

public class RoutesInfoFragment extends Fragment {

    private ListView lstRoutes;
    private TextView txtDeliveryPersonName;
    private TextView txtAddresses;
    private TextView txtProducts;
    private TextView txtSubscriberNames;

    public RoutesInfoFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routes_info, container, false);

        lstRoutes = view.findViewById(R.id.lstRoutes);
        txtDeliveryPersonName = view.findViewById(R.id.txtDeliveryPersonName);
        txtAddresses = view.findViewById(R.id.txtAddresses);
        txtProducts = view.findViewById(R.id.txtProducts);
        txtSubscriberNames = view.findViewById(R.id.txtSubscriberNames);

        // Mock data, replace this with my actual data in my database
        String[] routes = {"Route 1", "Route 2", "Route 3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, routes);  // Changed to requireActivity()
        lstRoutes.setAdapter(adapter);

        lstRoutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logic to fetch and display route details
                // Replace this with actual logic to fetch data from your database
                txtDeliveryPersonName.setText("Delivery Person for " + routes[position]);

            }
        });


//        lstRoutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // ... previous code ...
//
//                List<String> addresses = DBHelper.getAddressesByRoute(selectedRoute);
//                // and similar for products and subscriber names...
//
//                txtAddresses.setText("Addresses: " + String.join(", ", addresses));
//                // similar for products and subscriber names...
//            }
//        });
        return view;
    }

}
