package parkingLot;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkCarInEmptyParkingSpace() throws SpaceNotAvailableException {
        ParkingLot parkingLot = new ParkingLot(20);
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertEquals(ParkingLotStatus.FULL, parkingLot.park());
    }

    @Test
    public void shouldValidateIfParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertTrue(parkingLot.isFull());
    }

    @Test
    public void shouldValidateIfParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertFalse(parkingLot.isFull());
    }
}