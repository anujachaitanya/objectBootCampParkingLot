package parkingLot;


import parkingLot.lot.ParkingLotRecord;

import java.util.HashMap;

public class Assistant {
    private final HashMap<Integer, ParkingLotRecord> display;

    public Assistant() {
        this.display = new HashMap<>();
    }

    public void update(int lotId, ParkingLotRecord record) {
        this.display.put(lotId, record);
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "display=" + display +
                '}';
    }
}
