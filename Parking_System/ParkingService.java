package Parking_System;


public class ParkingService {
    private SpotSelectionStrategy spotStrategy;
    private PriceSelectionStrategy priceStrategy;
    private ParkingLot parkingLot;

    public ParkingService(SpotSelectionStrategy spotStrategy, PriceSelectionStrategy priceStrategy, ParkingLot parkingLot) {
        this.spotStrategy = spotStrategy;
        this.priceStrategy = priceStrategy;
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findSpot(vehicle);
        if (spot != null) {
            spot.occupySpot();
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
        long exitTime = System.currentTimeMillis();
        int hoursParked = (int) ((exitTime - entryTime) / (1000));
        return priceStrategy.calculatePrice(vehicle, hoursParked);
    }

    public int unparkVehicle(ParkingTicket ticket) {
        if(ticket == null) {
            System.out.println("Invalid ticket. Cannot unpark vehicle.");
            return 0;
        }
        ParkingSpot spot = ticket.getParkingSpot();
        spot.freeSpot();
        return (int) calculatePrice(ticket);
    }


}
