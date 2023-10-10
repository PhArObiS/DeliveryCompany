package com.example.deliverycompany.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.deliverycompany.Model.Dao.RouteDao;
import com.example.deliverycompany.Model.Route;
import com.example.deliverycompany.R;
import com.example.deliverycompany.View.Data.AppDatabase;

public class AddRouteFragment extends Fragment {

    private TextView txtMessage;
    private RouteDao routeDao;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_route, container, false);

        // Initializing the views
        txtMessage = view.findViewById(R.id.txtMessage);
        Button btnAddRoute = view.findViewById(R.id.btnAddRoute);
        Button btnBackToMain = view.findViewById(R.id.btnBackToMain);

        // Getting the database instance and route DAO
        AppDatabase db = AppDatabase.getInstance(requireContext());
        routeDao = db.routeDao();

        // Setting the onClickListener for the Add Route button
        btnAddRoute.setOnClickListener(v -> {
            Route route = new Route();  // Create a new Route object

            AppDatabase.databaseWriteExecutor.execute(() -> {
                routeDao.insertRoute(route);

                // Update the UI on the main thread
                getActivity().runOnUiThread(() -> {
                    txtMessage.setText("New route has been added");
                    Toast.makeText(requireContext(), "Route Added Successfully", Toast.LENGTH_SHORT).show();
                });
            });
        });


        // Setting the onClickListener for the Back to Main button
        btnBackToMain.setOnClickListener(v -> {
            // Creating a FragmentTransaction to replace the current fragment with MenuFragment
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new MenuFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view; // Returning the fragment view
    }
}
