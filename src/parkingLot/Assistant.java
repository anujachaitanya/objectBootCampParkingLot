package parkingLot;


import parkingLot.lot.ParkingLotStatus;

import java.util.HashMap;

public class Assistant implements ParkingLotListener {
    private final HashMap<Integer, ParkingLotStatus> display;

    public Assistant() {
        this.display = new HashMap<>();
    }

    @Override
    public void listen(int lotId, int threshold) {
        this.display.put(lotId, ParkingLotStatus.FULL);
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "display=" + display +
                '}';
    }
}
