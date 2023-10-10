package com.example.deliverycompany.View.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.deliverycompany.R;
import com.example.deliverycompany.View.Fragments.MenuFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // Tag for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            try {
                MenuFragment menuFragment = new MenuFragment();

                // Begin fragment transaction
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                // Replace the contents of the container with the new fragment
                ft.replace(R.id.fragment_container, menuFragment);

                // Adding transaction to back stack for back navigation
                ft.addToBackStack(null);
                ft.commit();
            } catch (Exception e) {
                Log.e(TAG, "Error while adding MenuFragment", e);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
