package org.example;

import java.util.Date;

/**
 * @author Dhruv
 * @project ParkingLot
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingAttendant {
    private List<ParkingLot> assignedParkingLots = new ArrayList<>();
    public void assignParkingLot(ParkingLot parkingLot) {
        assignedParkingLots.add(parkingLot);
    }
    public boolean parkCarForFlight(String carId,Date timestamp) {
        ParkingLot selectedParkingLot = findParkingLotWithMinimumCars();
        if (selectedParkingLot != null) {
            return selectedParkingLot.parkCarForFlight(carId,timestamp);
        } else {
            System.out.println("No available parking lots.");
            return false;
        }
    }
    public boolean unParkCar(String carId){
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(parkingLot.unParkCar(carId))
                return true;
        }
        return false;
    }
    public Date getTimestampForParkedCar(String carId){
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(parkingLot.getTimestampForParkedCar(carId)!=null)
                return parkingLot.getTimestampForParkedCar(carId);
        }
        return null;
    }
    private ParkingLot findParkingLotWithMinimumCars() {
        if (assignedParkingLots.isEmpty()) {
            return null;
        }

        ParkingLot minCarsLot = assignedParkingLots.get(0);
        for (ParkingLot parkingLot : assignedParkingLots) {
            if (parkingLot.getNumberOfParkedCars() < minCarsLot.getNumberOfParkedCars()) {
                minCarsLot = parkingLot;
            }
        }
        return minCarsLot;
    }
    public boolean parkCarForHandicapDriver(String carNo,Date timestamp) {
        ParkingLot nearestLot = findNearestParkingLot();
        if (nearestLot != null) {
            return nearestLot.parkCarForFlight(carNo,timestamp);
        } else {
            System.out.println("No available parking lots.");
            return false;
        }
    }
    private ParkingLot findNearestParkingLot() {
        if (assignedParkingLots.isEmpty()) {
            return null;
        }

        for(ParkingLot parkingLot: assignedParkingLots){
            if(parkingLot.count < parkingLot.MAX_CAPACITY)
                return parkingLot;
        }
        return null;
    }
}