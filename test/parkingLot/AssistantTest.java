package parkingLot;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssistantTest {
    @Test
    public void shouldMonitorParkingLots() {
        Assistant assistant = new Assistant();
        assistant.add(new ParkingLot())
        assistant.display();
    }
}