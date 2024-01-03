package org.example;

import java.util.Date;

/**
 * @author Dhruv
 * @project ParkingLot
 */
public class ParkingAttendant {
    private ParkingLot parkingLot;
    public  ParkingAttendant(ParkingLot parkingLot){
        this.parkingLot=parkingLot;
    }
    public boolean parkCarForFlight(String carId, Date timestamp) {
        return parkingLot.parkCarForFlight(carId,timestamp);
    }
    public boolean unParkCar(String carId){
        return parkingLot.unParkCar(carId);
    }
    public Date getTimestampForParkedCar(String carId){
        return parkingLot.getTimestampForParkedCar(carId);
    }
}