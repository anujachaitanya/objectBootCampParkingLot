package parkingLot.lot;

import parkingLot.Recordable;
import parkingLot.Space.Space;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLot implements Recordable {

    private final Space[] parkingSpaces;
    private int occupiedSpaces;

    public ParkingLot(int capacity) {
        this.parkingSpaces = new Space[capacity];
        Arrays.fill(parkingSpaces, Space.EMPTY);
        this.occupiedSpaces = 0;
    }

    public ParkingLotStatus park() {
        if (this.isFull()) {
            return ParkingLotStatus.FULL;
        }
        this.parkingSpaces[occupiedSpaces++] = Space.OCCUPIED;
        return this.getLotStatus();
    }

    private ParkingLotStatus getLotStatus() {
        return this.isFull() ? ParkingLotStatus.FULL : ParkingLotStatus.AVAILABLE;
    }

    public boolean isFull() {
        return occupiedSpaces == this.parkingSpaces.length;
    }

    @Override
    public ParkingLotRecord generateRecord() {
        return new ParkingLotRecord(this.parkingSpaces.length-this.occupiedSpaces, this.getLotStatus());
    }
}
