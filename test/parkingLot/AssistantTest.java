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
        assistant.update(1, record);
        assertEquals("Assistant{display={1=ParkingLotRecord{availableSlots=1, lotStatus=AVAILABLE}}}", assistant.toString());
    }
}