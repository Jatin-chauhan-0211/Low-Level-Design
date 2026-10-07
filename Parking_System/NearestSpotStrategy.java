package Parking_System;

public class NearestSpotStrategy implements SpotSelectionStrategy {

    @Override
    public ParkingSpot selectSpot(ParkingLot parkingLot, Vehicle vehicle) {
        for (ParkingFloor floor : parkingLot.getParkingFloors()) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                    return spot;
                }
            }
        }
        return null; // No available spot found
    }
    
}
