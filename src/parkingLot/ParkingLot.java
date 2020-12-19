package parkingLot;

import parkingLot.Space.Space;

public class ParkingLot {

    private final Space[][] parkingSpaces;

    public ParkingLot(int columns, int rows) {
        this.parkingSpaces = new Space[columns][rows];
    }


    public boolean park() {
        return true;
    }
}
