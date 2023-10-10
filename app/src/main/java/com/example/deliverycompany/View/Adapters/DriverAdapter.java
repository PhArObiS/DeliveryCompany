package com.example.deliverycompany.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.deliverycompany.R;
import com.example.deliverycompany.Model.DeliveryDriver;
import java.util.ArrayList;
import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.DriverViewHolder> {

    private List<DeliveryDriver> drivers = new ArrayList<>();

    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driver_item, parent, false);
        return new DriverViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {
        DeliveryDriver currentDriver = drivers.get(position);
        holder.textViewDriverName.setText(currentDriver.getName());
    }

    @Override
    public int getItemCount() {
        return drivers.size();
    }

    public void setDrivers(List<DeliveryDriver> drivers) {
        this.drivers = drivers;
        notifyDataSetChanged();
    }

    static class DriverViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewDriverName;
        // ... other TextViews for other fields

        public DriverViewHolder(View itemView) {
            super(itemView);
            textViewDriverName = itemView.findViewById(R.id.text_view_driver_name);
        }
    }
}
