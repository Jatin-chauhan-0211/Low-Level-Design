package Parking_System;

import java.util.Set;
import java.util.HashSet;

public class ParkingService {
    private Set<String> parkedVehicles;
    private SpotSelectionStrategy spotStrategy;
    private PriceSelectionStrategy priceStrategy;
    private ParkingLot parkingLot;

    public ParkingService(SpotSelectionStrategy spotStrategy, PriceSelectionStrategy priceStrategy, ParkingLot parkingLot) {
        this.spotStrategy = spotStrategy;
        this.priceStrategy = priceStrategy;
        this.parkingLot = parkingLot;
        parkedVehicles = new HashSet<>();
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if (parkedVehicles.contains(vehicle.getLicensePlateNumber())) {
            System.out.println("Vehicle with license plate " + vehicle.getLicensePlateNumber() + " is already parked.");
            return null;
        }
        ParkingSpot spot = findSpot(vehicle);
        if (spot != null) {
            spot.occupySpot();
            parkedVehicles.add(vehicle.getLicensePlateNumber());
            System.out.println("Vehicle parked at spot: " + spot.getSpotId());
            ParkingTicket ticket = generateTicket(vehicle, spot);
            System.out.println("GeneratedTicket with ID: " + ticket.getTicketId());
            return ticket;
        } else {
            System.out.println("No available parking spot for the vehicle.");
            return null;
        }
        
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        return spotStrategy.selectSpot(parkingLot, vehicle);
    }

    public ParkingTicket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        return new ParkingTicket(vehicle, spot);
    }

    public double calculatePrice(ParkingTicket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        long entryTime = ticket.getEntryTime();
        long exitTime = ticket.getExitTime();
        int hoursParked =  (int)Math.ceil(((exitTime - entryTime) / (60*60*1000)));
        hoursParked=hoursParked==0?1:hoursParked;
        return priceStrategy.calculatePrice(vehicle, hoursParked);
    }

    public double unparkVehicle(ParkingTicket ticket) {
        if(ticket == null) {
            System.out.println("Invalid ticket. Cannot unpark vehicle.");
            return 0;
        }
        ParkingSpot spot = ticket.getParkingSpot();
        spot.freeSpot();
        ticket.closeTicket();
        parkedVehicles.remove(ticket.getVehicle().getLicensePlateNumber());
        System.out.println("Vehicle unparked from spot: " + spot.getSpotId());
        return calculatePrice(ticket);
    }


}
