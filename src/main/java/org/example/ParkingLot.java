package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dhruv
 * @project ParkingLot
 */

public class ParkingLot {
    private AirportSecurity securityStaff;
    private ParkingLotOwner parkingLotOwner;
    private ParkingAttendant parkingAttendant;
    private Set<String> parkedCars = new HashSet<>();
    public int MAX_CAPACITY = 10;
    public int count=0;

    public void setSecurityStaff(AirportSecurity staff){
        this.securityStaff=staff;
    }
    public void setParkingLotOwner(ParkingLotOwner parkingLotOwner) {
        this.parkingLotOwner = parkingLotOwner;
    }
    public void setParkingAttendant(ParkingAttendant parkingAttendant) {
        this.parkingAttendant = parkingAttendant;
    }
    public boolean parkCarForFlight(String carId) {
        if(!isLotFull()) {
            parkedCars.add(carId);
            System.out.println("Vehicle Parked ");
            count++;
            return true;
        }
        else{
            System.out.println("Parking lot is full");
            notifySecurity();
            return false;
        }
    }
    public boolean unParkCar(String carId) {
        if(count== 0 || !parkedCars.contains(carId)){
            System.out.println("Error!!! No car in the Lot");
            return false;
        }
        else {
            System.out.println("Vehicle UnParked");
            parkedCars.remove(carId);
            count--;
            this.notifyOwnerIfSpaceAvailable();
            return true;
        }
    }
    public boolean isLotFull() {
        return count == MAX_CAPACITY;
    }

    private void notifySecurity() {
        if (securityStaff != null) {
            securityStaff.notifyLotFull();
        }
    }
    private void notifyOwnerIfSpaceAvailable() {
        if (parkingLotOwner != null && !isLotFull()) {
            parkingLotOwner.notifySpaceAvailable();
        }
    }
}