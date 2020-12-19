package parkingLot;

import java.util.ArrayList;
import java.util.HashMap;

public class Assistant {
    public Assistant() {

    }

    public HashMap<ParkingLot, ParkingLotStatus> updateDisplay(ArrayList<ParkingLot> parkingLots) {
        HashMap<ParkingLot, ParkingLotStatus> parkingLotStatus = new HashMap<>();
        for (ParkingLot parkingLot : parkingLots) {
            ParkingLotStatus status = parkingLot.isFull() ? ParkingLotStatus.FULL : ParkingLotStatus.AVAILABLE;
            parkingLotStatus.put(parkingLot, status);
        }
        return parkingLotStatus;
    }
}
