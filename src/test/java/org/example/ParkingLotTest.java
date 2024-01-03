package org.example;

/**
 * @author Dhruv
 * @project ParkingLot
 */
import org.junit.Test;
import static junit.framework.Assert.assertTrue;

public class ParkingLotTest {
    @Test
    public void parkCarForFlight_ShouldReturnTrue_ForEveryDriverJourney() {
        ParkingLot parkingLot = new ParkingLot();
        boolean isParked = parkingLot.parkCarForFlight();
        assertTrue(isParked);
    }
    @Test
    public void unParkCar_ShouldReturnTrue_ForEveryVehicle() {
        ParkingLot parkingLot = new ParkingLot();
        boolean unParked = parkingLot.unParkCar();
        assertTrue(unParked);
    }
}