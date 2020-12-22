package parkingLot;

import org.junit.Test;
import parkingLot.lot.ParkingLotRecord;
import parkingLot.lot.ParkingLotStatus;

import static org.junit.Assert.assertEquals;

public class AssistantTest {
    @Test
    public void shouldUpdateDisplayWithGivenRecords() {
        Assistant assistant = new Assistant();
        ParkingLotRecord record = new ParkingLotRecord(1, ParkingLotStatus.AVAILABLE);
        assistant.listen(1);
    }
}