package parkingLot;

import org.junit.Test;

public class AttendantTest {
    @Test
    public void shouldParkACarIfSpaceIsAvailable() {
        ParkingLot[] parkingLots =  {new ParkingLot(1)};
        Attendant attendant = new Attendant(parkingLots);
        attendant.park();
    }
}