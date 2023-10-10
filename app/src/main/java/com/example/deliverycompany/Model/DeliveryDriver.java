package com.example.deliverycompany.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(indices = {@Index(value = "name")})
public class DeliveryDriver {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phoneNumber;
    private Integer routeId;

    @Ignore
    public DeliveryDriver(String name, String phoneNumber) {
        validateNameAndPhoneNumber(name, phoneNumber);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.routeId = null;
    }

    public DeliveryDriver(int id, String name, String phoneNumber, Integer routeId) {
        validateNameAndPhoneNumber(name, phoneNumber);
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.routeId = routeId;
    }

    private void validateNameAndPhoneNumber(String name, String phoneNumber) {
        if(name == null || phoneNumber == null || name.trim().isEmpty() || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Name and Phone Number cannot be null or empty");
        }
        // Add more specific validations for phone number if needed
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone Number cannot be null or empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "DeliveryDriver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", routeId=" + routeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryDriver that = (DeliveryDriver) o;
        return id == that.id &&
                routeId == that.routeId &&
                Objects.equals(name, that.name) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, routeId);
    }
}
