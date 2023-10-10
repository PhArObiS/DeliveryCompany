package com.example.deliverycompany.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

// Annotation to specify the SQLite table name, indices, and foreign key constraints for the Address entity
@Entity(tableName = "addresses",
        indices = {@Index(value = "routeId")},
        foreignKeys = @ForeignKey(entity = Route.class,
                parentColumns = "route_id",
                childColumns = "routeId",
                onDelete = ForeignKey.CASCADE))
public class Address {

    // Column for storing the ID of the associated route, with a foreign key constraint to reference the Route entity
    @ColumnInfo(name = "routeId")
    private int routeId;

    // Primary key for the address entity, set to auto-generate unique IDs for each address record
    @PrimaryKey(autoGenerate = true)
    private int id;

    // Column for storing the address string, annotated to be non-null to ensure data integrity
    @NonNull
    @ColumnInfo(name = "address")
    private String address;

    // Constructor to initialize Address objects, expects a route ID and a non-null address string
    public Address(int routeId, @NonNull String address) {
        this.routeId = routeId;
        this.address = address;
        // Add validation for address if necessary, e.g., check if it's not empty, follows a pattern, etc.
    }

    // Getter method to retrieve the route ID associated with the address
    public int getRouteId() {
        return routeId;
    }

    // Setter method to assign a route ID to the address
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    // Getter method to retrieve the unique ID of the address record
    public int getId() {
        return id;
    }

    // Setter method to assign a unique ID to the address record
    public void setId(int id) {
        this.id = id;
    }

    // Getter method to retrieve the address string
    @NonNull
    public String getAddress() {
        return address;
    }

    // Setter method to assign an address string to the Address object, ensures the assigned value is not null
    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    // Overridden toString method to provide a readable string representation of the Address object,
    // useful for debugging and logging purposes
    @Override
    public String toString() {
        return "Address{" +
                "routeId=" + routeId +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

}
