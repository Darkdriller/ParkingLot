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
        parkingAttendant= new ParkingAttendant(parkingLot);
        parkingLot.setParkingAttendant(parkingAttendant);
        parkingLot.setSecurityStaff(securityStaff);
        parkingLot.setParkingLotOwner(parkingLotOwner);
    }
    @Test
    public void testTrackTimestamp_WhenCarIsParked() {
        boolean isParked = parkingAttendant.parkCarForFlight("Car1", new Date());
        assertTrue(isParked);     // Check if the car is parked successfully
        Date timestamp = parkingAttendant.getTimestampForParkedCar("Car1");  // Get the timestamp when the car was parked
        assertNotNull(timestamp);    // Check if the timestamp is not null
    }
}