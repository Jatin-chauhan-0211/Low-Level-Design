package Parking_System;

public class ParkingSpot {
    
    private final String spotId;
    private final SpotType spotType;
    private boolean isOccupied;
    private int distanceFromEntrance;
    
    public ParkingSpot(String spotId, SpotType spotType, int distanceFromEntrance) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
        this.distanceFromEntrance = distanceFromEntrance;
    }

    public int getDistanceFromEntrance() {
        return distanceFromEntrance;
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

        return spotType.name().equals(vehicle.getVehicleType().name());
        
    }
}
