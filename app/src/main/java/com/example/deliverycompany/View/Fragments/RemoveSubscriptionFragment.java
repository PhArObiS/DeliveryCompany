package com.example.deliverycompany.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.example.deliverycompany.Model.Subscription;
import com.example.deliverycompany.R;
import com.example.deliverycompany.ViewModel.SubscriptionViewModel;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveSubscriptionFragment extends Fragment {

    private ListView lstSubscriptions;
    private SubscriptionViewModel subscriptionViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscriptionViewModel = new ViewModelProvider(this).get(SubscriptionViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remove_subscription, container, false);

        lstSubscriptions = view.findViewById(R.id.lstSubscriptions);
        Button btnRemoveSubscription = view.findViewById(R.id.btnRemoveSubscription);
        Button btnReturnToMenu = view.findViewById(R.id.btnReturnMainMenu); // New Button

        subscriptionViewModel.getAllSubscriptions().observe(getViewLifecycleOwner(), subscriptions -> {
            List<String> subscriptionStrings = subscriptions.stream()
                    .map(Subscription::toString)
                    .collect(Collectors.toList());
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                    android.R.layout.simple_list_item_single_choice, subscriptionStrings);
            lstSubscriptions.setAdapter(adapter);
        });

        btnRemoveSubscription.setOnClickListener(v -> {
            int position = lstSubscriptions.getCheckedItemPosition();
            if (position != ListView.INVALID_POSITION) {
                Subscription selectedSubscription = (Subscription) lstSubscriptions.getItemAtPosition(position);
                subscriptionViewModel.deleteSubscription(selectedSubscription);
                Toast.makeText(getContext(), "Subscription Removed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Please select a subscription to remove", Toast.LENGTH_SHORT).show();
            }
        });

        btnReturnToMenu.setOnClickListener(v -> {
            // Implement navigation to return to the menu here
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new MenuFragment());
            transaction.addToBackStack(null);
            transaction.commit();

        });

        return view;
    }
}
