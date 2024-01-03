package org.example;

/**
 * @author Dhruv
 * @project ParkingLot
 */

public class ParkingLot {
    public int MAX_CAPACITY = 10;
    public int count=0;
    public boolean parkCarForFlight() {
        if(!isLotFull()){
            System.out.println("Vehicle Parked");
            count++;
            return true;
        }
        else {
            System.out.println("Lot Full");
            return false;
        }
    }
    public boolean unParkCar() {
        if(count==0){
            System.out.println("Error!!! No car in the Lot");
            return false;
        }
        else {
            System.out.println("Vehicle UnParked");
            count--;
            return true;
        }
    }
    public boolean isLotFull() {
        return count == MAX_CAPACITY;
    }
}