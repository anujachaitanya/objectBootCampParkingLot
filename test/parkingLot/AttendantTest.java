package parkingLot;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class AttendantTest {
    @Test
    public void shouldParkACarIfSpaceIsAvailable() throws SpaceNotAvailableException {
        Attendant attendant = new Attendant();
        attendant.addParkingLot(new ParkingLot(1));
        assertEquals(1, attendant.park());
    }

    @Test
    public void shouldMonitorTheParkingLotsAfterUpdation() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(1);
        attendant.addParkingLot(parkingLot);
        HashMap<ParkingLot, ParkingLotStatus> parkingLotStatus = new HashMap<>();
        parkingLotStatus.put(parkingLot, ParkingLotStatus.AVAILABLE);
        assertEquals(parkingLotStatus, attendant.monitorParkingLots());
    }
}