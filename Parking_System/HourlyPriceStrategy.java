package Parking_System;

import java.util.Map;

public class HourlyPriceStrategy implements PriceSelectionStrategy {
    private Map<VehicleType, Double> hourlyRates=Map.of(VehicleType.CAR, 50.0, VehicleType.TRUCK, 100.0, VehicleType.MOTORCYCLE, 20.0);

    @Override
    public double calculatePrice(Vehicle vehicle, int hoursParked) {
        return hourlyRates.get(vehicle.getVehicleType()) * hoursParked;
    }
    
}
