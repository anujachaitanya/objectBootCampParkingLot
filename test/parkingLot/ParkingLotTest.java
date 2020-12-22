package parkingLot;

import org.junit.Test;
import parkingLot.lot.ParkingLot;

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
        parkingLot.addListener(assistant,100);
        parkingLot.park();
        verify(assistant).listen(parkingLot.hashCode(),100);
    }

    @Test
    public void shouldUpdateManagerWhenLotIs80PercentFull() {
        ParkingLotListener manager = mock(ParkingLotListener.class);
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.addListener(manager, 80);
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        verify(manager).listen(parkingLot.hashCode(), 80);
    }
}