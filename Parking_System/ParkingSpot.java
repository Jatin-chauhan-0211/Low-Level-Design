package Parking_System;

public class ParkingSpot {
    
    private final String spotId;
    private final SpotType spotType;
    private boolean isOccupied;
    
    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }  

    public void occupySpot() {
        isOccupied = true;
    }

    public void freeSpot() {
        isOccupied = false;
    }
    public boolean canFitVehicle(Vehicle vehicle) {

        switch (vehicle.getVehicleType()) {
            case CAR:
                return spotType == SpotType.CAR;
            case TRUCK:
                return spotType == SpotType.TRUCK;
            case MOTORCYCLE:
                return spotType == SpotType.MOTORCYCLE;
            default:
                return false;
        }
    }
}
