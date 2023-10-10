package com.example.deliverycompany.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.deliverycompany.R;
import com.example.deliverycompany.Model.Subscription;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder> {

    private List<Subscription> subscriptions = new ArrayList<>();

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subscription_item, parent, false);
        return new SubscriptionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        Subscription currentSubscription = subscriptions.get(position);
        holder.textViewCustomerName.setText(currentSubscription.getCustomerName());
    }

    @Override
    public int getItemCount() {
        return subscriptions.size();
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
        notifyDataSetChanged();
    }

    static class SubscriptionViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCustomerName;
        // ... other TextViews for other fields

        public SubscriptionViewHolder(View itemView) {
            super(itemView);
            textViewCustomerName = itemView.findViewById(R.id.text_view_customer_name);
        }
    }
}
