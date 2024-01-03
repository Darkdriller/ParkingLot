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
    public void testEvenDistributionByParkingAttendant() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        // Set up the parking lots and parking attendant
        parkingAttendant.assignParkingLot(parkingLot1);
        parkingAttendant.assignParkingLot(parkingLot2);

        // Park multiple cars using the attendant
        parkingAttendant.parkCarForFlight("Driver1",  new Date());
        parkingAttendant.parkCarForFlight("Driver2",  new Date());
        parkingAttendant.parkCarForFlight("Driver3",  new Date());
        parkingAttendant.parkCarForFlight("Driver4",  new Date());
        parkingAttendant.parkCarForFlight("Driver5",  new Date());

        assertEquals(2, parkingLot.count);
        assertEquals(2, parkingLot1.count);
        assertEquals(1, parkingLot2.count);
        assertEquals(2, parkingLot.count);

    }
}