package parkingLot.lot;

import parkingLot.ParkingLotListener;

public class ParkingLot {

    private final int capacity;
    private int occupiedSpaces;
    private ParkingLotListener listener;
    private ParkingLotListener manager;


    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupiedSpaces = 0;
    }

    public void assignListener(ParkingLotListener lotListener) {
        this.listener = lotListener;
    }

    public void assignManager(ParkingLotListener manager) {
        this.manager = manager;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedSpaces++;

        if(this.hasManager() && this.isEightyPercentFull()) {
            this.manager.listen(this.hashCode());
        }

        if(hasListener() && this.isFull()) {
            this.listener.listen(this.hashCode());
        }
        return true;
    }

    private boolean hasListener() {
        return this.listener != null;
    }

    private boolean hasManager() {
        return this.manager != null;
    }

    private boolean isEightyPercentFull() {
        return ((80 * this.capacity)  / 100) <= occupiedSpaces;
    }

    public boolean isFull() {
        return occupiedSpaces == this.capacity;
    }
}
