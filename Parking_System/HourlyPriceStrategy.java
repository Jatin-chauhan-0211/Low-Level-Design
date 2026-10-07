package Parking_System;

public class HourlyPriceStrategy implements PriceSelectionStrategy {


    @Override
    public double calculatePrice(Vehicle vehicle, int hoursParked) {
        return vehicle.getVehicleType().getHourlyRate() * hoursParked;
    }
    
}
