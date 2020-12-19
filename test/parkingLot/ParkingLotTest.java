package parkingLot;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkCarInEmptyParkingSpace() {
        ParkingLot parkingLot = new ParkingLot(5,4);
        assertTrue(parkingLot.park());
    }
}