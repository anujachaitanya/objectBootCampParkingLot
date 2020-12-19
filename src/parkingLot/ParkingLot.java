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

    public int park() throws SpaceNotAvailableException {
        if (this.isFull()) {
            throw new SpaceNotAvailableException();
        }
        this.parkingSpaces[occupiedSpaces++] = Space.OCCUPIED;
        return this.occupiedSpaces;
    }

    public boolean isFull() {
        return occupiedSpaces == this.parkingSpaces.length;
    }
}
