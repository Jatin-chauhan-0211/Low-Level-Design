package Parking_System;

public enum VehicleType {

    CAR(50),
    TRUCK(100),
    MOTORCYCLE(20);

    private final double hourlyRate;
    
    VehicleType(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}