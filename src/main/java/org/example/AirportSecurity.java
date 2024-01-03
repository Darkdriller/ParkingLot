package org.example;

/**
 * @author Dhruv
 * @project ParkingLot
 */

public class AirportSecurity {
    private boolean notified;
    public void notifyLotFull() {
        this.notified = true;
        System.out.println("Airport security has been notified: Parking lot is full.");
    }
    public boolean isNotified() {
        return this.notified;
    }
}