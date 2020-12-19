package parkingLot;

import parkingLot.Space.Space;

import java.util.Arrays;

public class ParkingLot {

    private final Space[] parkingSpaces;
    private int occupiedSpaces;

    public ParkingLot(int capacity) {
        this.parkingSpaces = new Space[capacity];
        Arrays.fill(parkingSpaces, Space.EMPTY);
        this.occupiedSpaces = 0;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.parkingSpaces[occupiedSpaces] = Space.OCCUPIED;
        this.occupiedSpaces++;
        return true;
    }

    public boolean isFull() {
        return occupiedSpaces == this.parkingSpaces.length;
    }
}
