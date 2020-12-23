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
        ParkingLot parkingLot = new ParkingLot(1, 20);
        assertTrue(parkingLot.park());
    }

    @Test
    public void shouldNotParkCarWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1, 0);
        assertFalse(parkingLot.park());
    }

    @Test
    public void shouldValidateIfParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(0, 0);
        assertTrue(parkingLot.isFull());
    }

    @Test
    public void shouldValidateIfParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        assertFalse(parkingLot.isFull());
    }

    @Test
    public void shouldUpdateTheAssistantWhenParked() {
        Assistant assistant = mock(Assistant.class);
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.addListener(assistant, ParkingLotStatus.FULL);
        parkingLot.park();
        verify(assistant).notify(1,ParkingLotStatus.FULL);
    }

    @Test
    public void shouldUpdateManagerWhenLotIs80PercentFull() {
        ParkingLotListener manager = mock(ParkingLotListener.class);
        ParkingLot parkingLot = new ParkingLot(1, 5);
        parkingLot.addListener(manager, ParkingLotStatus.ALMOST_FULL);
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        verify(manager).notify(1, ParkingLotStatus.ALMOST_FULL);
    }
}