package Parking_System;

import java.util.List;

public class ParkingLot {

    private final List<ParkingFloor> ParkingFloors;

    public ParkingLot(List<ParkingFloor> parkingFloors) {
        this.ParkingFloors = parkingFloors;
    }
    public List<ParkingFloor> getParkingFloors() {
        return ParkingFloors;
    }
}
