package Parking_System;
import java.util.List;
public class Main {
    
    public static void main(String[] args) {
       //generate code to test the parking system
       SpotSelectionStrategy spotStrategy = new NearestSpotStrategy();
       PriceSelectionStrategy priceStrategy = new HourlyPriceStrategy(); 

       ParkingSpot spot1 = new ParkingSpot("S1", SpotType.CAR,5);
       ParkingSpot spot4 = new ParkingSpot("S4", SpotType.CAR,1);
       ParkingSpot spot2 = new ParkingSpot("S2", SpotType.TRUCK,10);
       ParkingSpot spot3 = new ParkingSpot("S3", SpotType.MOTORCYCLE,15);
    
       ParkingFloor floor1 = new ParkingFloor(1, List.of(spot1, spot2, spot3,spot4));
        
       ParkingLot parkingLot = new ParkingLot(List.of(floor1));

       ParkingService parkingService = new ParkingService(spotStrategy, priceStrategy,parkingLot);
// testing by sending vehicles
        Vehicle vehicle1 = new Vehicle("ABC123", VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("XYZ789", VehicleType.TRUCK);
        Vehicle vehicle3 = new Vehicle("DEF456", VehicleType.MOTORCYCLE);
        Vehicle vehicle4 = new Vehicle("GHI789", VehicleType.CAR);
        List<ParkingTicket> tickets = new java.util.ArrayList<>();
        for(Vehicle vehicle : List.of(vehicle1, vehicle2, vehicle3, vehicle4)) {
            System.out.println("Trying to park vehicle " + vehicle.getLicensePlateNumber() + " of type " + vehicle.getVehicleType());
            ParkingTicket ticket = parkingService.parkVehicle(vehicle);
            tickets.add(ticket);
        }
        

        // Simulate some time passing
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ParkingTicket ticketToUnpark = tickets.get(1); // Unpark the second vehicle (vehicle2)
        Vehicle vehicleToUnpark = ticketToUnpark.getVehicle();
        System.out.println("Unparking vehicle " + vehicleToUnpark.getLicensePlateNumber() + " of type " + vehicleToUnpark.getVehicleType());
        double amount = parkingService.unparkVehicle(ticketToUnpark);
        System.out.println("Vehicle " + vehicleToUnpark.getLicensePlateNumber() + " unparked from spot " + ticketToUnpark.getParkingSpot().getSpotId());
        System.out.println("Amount to be paid: $" + amount);

        for(Vehicle vehicle : List.of(vehicle1, vehicle2, vehicle3, vehicle4)) {
            System.out.println("Trying to park vehicle " + vehicle.getLicensePlateNumber() + " of type " + vehicle.getVehicleType());
            ParkingTicket ticket = parkingService.parkVehicle(vehicle);
            tickets.add(ticket);
        }

        
    }
}
