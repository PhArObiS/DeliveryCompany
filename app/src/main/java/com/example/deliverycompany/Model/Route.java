package com.example.deliverycompany.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "routes")
public class Route {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "route_id")
    private int id;

    // Default constructor
    public Route() {
    }

    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //  String representation of Route object
    @Override
    public String toString() {
        return "Route ID: " + id;
    }
}
