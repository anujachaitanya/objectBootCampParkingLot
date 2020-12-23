package parkingLot.lot;

import parkingLot.ParkingLotListener;

import java.util.HashMap;

public class ParkingLot {
    private final int id;
    private final int capacity;
    private int occupiedSpaces;
    private final HashMap<ParkingLotListener, Integer> listener;

    public ParkingLot(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.occupiedSpaces = 0;
        this.listener = new HashMap<>();
    }

    public void addListener(ParkingLotListener lotListener, int threshold) {
        this.listener.put(lotListener, threshold);
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedSpaces++;
        this.informListeners();
        return true;
    }

    private void informListeners() {
        this.listener.forEach((parkingLotListener, threshold) -> {
            if(hasPassesThreshold(threshold)){
                parkingLotListener.listen(this.id, threshold);
            }
        });
    }

    private boolean hasPassesThreshold(Integer threshold) {
        return ((threshold * this.capacity)  / 100) == occupiedSpaces;
    }

    public boolean isFull() {
        return occupiedSpaces == this.capacity;
    }

}
