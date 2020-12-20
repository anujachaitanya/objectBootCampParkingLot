package parkingLot;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AssistantTest {
    @Test
    public void shouldMonitorAvailableParkingLots() {
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));

        Assistant assistant = new Assistant(parkingLots);
        ArrayList<ParkingLotRecord> parkingLotRecords = new ArrayList<>();
        parkingLotRecords.add(new ParkingLotRecord(1, ParkingLotStatus.AVAILABLE));

        assertEquals(parkingLotRecords, assistant.monitorLots());
    }

    @Test
    public void shouldMonitorFullParkingLots() {
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(0));

        Assistant assistant = new Assistant(parkingLots);
        ArrayList<ParkingLotRecord> parkingLotRecords = new ArrayList<>();
        parkingLotRecords.add(new ParkingLotRecord(0, ParkingLotStatus.FULL));

        assertEquals(parkingLotRecords, assistant.monitorLots());
    }
}