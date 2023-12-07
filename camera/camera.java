package com.camera;

public class camera {
    private String brand;
    private String model;
    private double rentalAmountPerDay;
    private boolean rented;

    public camera(String brand, String model, double rentalAmountPerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalAmountPerDay = rentalAmountPerDay;
        this.rented = false; // Initially, the camera is not rented
    }

    // Getters and setters for camera details
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalAmountPerDay() {
        return rentalAmountPerDay;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
