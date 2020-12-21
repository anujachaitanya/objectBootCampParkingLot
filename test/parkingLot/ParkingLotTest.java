package parkingLot;

import org.junit.Test;
import parkingLot.lot.ParkingLot;
import parkingLot.lot.ParkingLotStatus;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {
    @Test
    public void shouldParkCarInEmptyParkingSpace()  {
        ParkingLot parkingLot = new ParkingLot(20);
        assertTrue(parkingLot.park());
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertFalse(parkingLot.park());
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

    @Test
    public void shouldUpdateTheAssistantWhenParked() {
        Assistant assistant = mock(Assistant.class);
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.assignAssistant(assistant);
        parkingLot.park();
        verify(assistant).update(parkingLot.hashCode(), parkingLot.generateRecord());
    }
}