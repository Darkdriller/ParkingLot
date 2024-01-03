package org.example;

/**
 * @author Dhruv
 * @project ParkingLot
 */
import org.junit.Before;
import org.junit.Test;

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
        parkingAttendant= new ParkingAttendant(parkingLot);
        parkingLot.setParkingAttendant(parkingAttendant);
        parkingLot.setSecurityStaff(securityStaff);
        parkingLot.setParkingLotOwner(parkingLotOwner);
    }
    //UC5
    @Test
    public void testNotifyOwner_ShouldReturnTrue_WhenSpaceIsAvailableAgain() {
        for (int i = 1; i <= parkingLot.MAX_CAPACITY; i++) {
            parkingAttendant.parkCarForFlight();
        }
        parkingAttendant.unParkCar();  // Unpark one car to create available space
        assertTrue(parkingLotOwner.isNotified());  // Check if the parking lot owner is notified
    }
}