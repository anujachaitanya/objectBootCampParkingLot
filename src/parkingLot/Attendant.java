package parkingLot;

import java.util.ArrayList;
import java.util.HashMap;

public class Attendant {
    private final ArrayList<ParkingLot> parkingLots;
    private final Assistant assistant;

    public Attendant() {
        this.parkingLots = new ArrayList<ParkingLot>();
        this.assistant = new Assistant();
    }

    public int park() throws SpaceNotAvailableException {
        for (ParkingLot parkingLot : this.parkingLots) {
            if(!parkingLot.isFull()){
                int slotNo = parkingLot.park();
                return slotNo;
            }

        }
        return -1;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public HashMap<ParkingLot, ParkingLotStatus> monitorParkingLots() {
        return this.assistant.updateDisplay(this.parkingLots);
    }
}
