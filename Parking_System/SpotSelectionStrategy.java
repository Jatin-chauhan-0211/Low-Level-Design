package Parking_System;

public interface SpotSelectionStrategy {
    
    public ParkingSpot selectSpot(ParkingLot parkingLot, Vehicle vehicle);
}
