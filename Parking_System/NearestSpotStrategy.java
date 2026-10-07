package Parking_System;

public class NearestSpotStrategy implements SpotSelectionStrategy {

    public ParkingSpot selectSpot(ParkingLot parkingLot, Vehicle vehicle) {

        ParkingSpot nearest = null;

        for (ParkingFloor floor : parkingLot.getParkingFloors()) {

            for (ParkingSpot spot : floor.getParkingSpots()) {

                if (!spot.isOccupied() && spot.canFitVehicle(vehicle)) {

                    if (nearest == null ||
                        spot.getDistanceFromEntrance()
                            < nearest.getDistanceFromEntrance()) {

                        nearest = spot;
                    }
                }
            }
        }

        return nearest;
    }
}
    

