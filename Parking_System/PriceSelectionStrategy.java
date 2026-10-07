package Parking_System;

public interface PriceSelectionStrategy {
    public double calculatePrice(Vehicle vehicle, int hoursParked);
}
