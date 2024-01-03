package org.example;

/**
 * @author Dhruv
 * @project ParkingLot
 */
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.*;
public class ParkingLotTest {
    private ParkingLot parkingLot;
    private AirportSecurity securityStaff;
    private  ParkingLotOwner parkingLotOwner;
    private ParkingAttendant parkingAttendant ;
    @Before
    public void setUp() {
        parkingLot = new ParkingLot();
        securityStaff=new AirportSecurity();
        parkingLotOwner = new ParkingLotOwner();
        parkingAttendant= new ParkingAttendant();
        parkingAttendant.assignParkingLot(parkingLot);
        parkingLot.setParkingAttendant(parkingAttendant);
        parkingLot.setSecurityStaff(securityStaff);
        parkingLot.setParkingLotOwner(parkingLotOwner);
    }
    @Test
    public void testParkCarForHandicapDriver() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        parkingLot.MAX_CAPACITY=2;
        parkingLot1.MAX_CAPACITY=1;
        parkingLot2.MAX_CAPACITY=10;

        parkingAttendant.assignParkingLot(parkingLot1);
        parkingAttendant.assignParkingLot(parkingLot2);

        // Park multiple cars using the attendant
        parkingAttendant.parkCarForFlight("Driver1",  new Date());
        parkingAttendant.parkCarForFlight("Driver2",  new Date());
        parkingAttendant.parkCarForFlight("Driver3",  new Date());
        parkingAttendant.parkCarForFlight("Driver4",  new Date());

        // Park a car for a handicap driver
        boolean isParked = parkingAttendant.parkCarForHandicapDriver("Driver5", new Date());

        // Check if the car is parked in the nearest lot
        assertTrue(isParked);
        assertTrue(parkingLot2.unParkCar("Driver5"));
    }
}