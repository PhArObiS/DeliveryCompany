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

public class MenuFragment extends Fragment {

    public MenuFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnAddRoute = view.findViewById(R.id.btnAddRoute);
        Button btnAddSubscription = view.findViewById(R.id.btnAddSubscription);
        Button btnRemoveSubscription = view.findViewById(R.id.btnRemoveSubscription);
        Button btnLister = view.findViewById(R.id.btnLister);
        Button btnAddDriver = view.findViewById(R.id.btnAddDeliveryPerson);
        Button btnQuit = view.findViewById(R.id.btnQuit);

        btnAddRoute.setOnClickListener(v -> openFragment(new AddRouteFragment()));
        btnAddSubscription.setOnClickListener(v -> openFragment(new AddSubscriptionFragment()));
        btnRemoveSubscription.setOnClickListener(v -> openFragment(new RemoveSubscriptionFragment()));
        btnLister.setOnClickListener(v -> openFragment(new ListerFragment()));
        btnAddDriver.setOnClickListener(v -> openFragment(new AddDriverFragment()));
        btnQuit.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().finish();
            }
        });
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
