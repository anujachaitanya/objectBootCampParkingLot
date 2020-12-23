package parkingLot.lot;

import parkingLot.ParkingLotListener;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private final int id;
    private final int capacity;
    private final HashMap<ParkingLotStatus, ArrayList<ParkingLotListener>> listeners;
    private int occupiedSpaces;
//    private final HashMap<ParkingLotListener, Integer> listener;

    public ParkingLot(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.occupiedSpaces = 0;
        this.listeners = new HashMap<>();
    }

    public void addListener(ParkingLotListener lotListener, ParkingLotStatus status) {
        this.listeners.computeIfAbsent(status, k -> new ArrayList<>());
        this.listeners.get(status).add(lotListener);
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedSpaces++;
        this.informListeners(this.generateStatus());
        return true;
    }

    private void informListeners(ParkingLotStatus status) {
        ArrayList<ParkingLotListener> parkingLotListeners = this.listeners.get(status);
        if(parkingLotListeners == null){
            return;
        }
        parkingLotListeners.forEach((listener) -> {
            listener.notify(this.id, status);
        });
    }

    private ParkingLotStatus generateStatus() {
        if(isFull()){
            return ParkingLotStatus.FULL;
        }
        if(hasPassesThreshold(80)){
            return ParkingLotStatus.ALMOST_FULL;
        }
        if(isInRange(20)){
            return ParkingLotStatus.OCCUPIED_LESS_THAN_TWENTY_PERCENT;
        }
        return ParkingLotStatus.AVAILABLE;
    }

    private boolean isInRange(int limit) {
        return ((limit * this.capacity) / 100) <= occupiedSpaces;
    }


    private boolean hasPassesThreshold(Integer threshold) {
        return ((threshold * this.capacity) / 100) == occupiedSpaces;
    }

    public boolean isFull() {
        return occupiedSpaces == this.capacity;
    }

}
