package org.example;

/**
 * @author Dhruv
 * @project ParkingLot
 */
public class ParkingAttendant {
    private ParkingLot parkingLot;
    public  ParkingAttendant(ParkingLot parkingLot){
        this.parkingLot=parkingLot;
    }
    public boolean parkCarForFlight(String carId) {
        return parkingLot.parkCarForFlight(carId);
    }
    public boolean unParkCar(String carId){
        return parkingLot.unParkCar(carId);
    }
}