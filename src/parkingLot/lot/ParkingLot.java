package parkingLot.lot;

import parkingLot.Assistant;
import parkingLot.Space.Space;

import java.util.Arrays;

public class ParkingLot {

    private final Space[] parkingSpaces;
    private int occupiedSpaces;
    private Assistant assistant;

    public ParkingLot(int capacity) {
        this.parkingSpaces = new Space[capacity];
        Arrays.fill(parkingSpaces, Space.EMPTY);
        this.occupiedSpaces = 0;
    }

    public void assignAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.parkingSpaces[occupiedSpaces++] = Space.OCCUPIED;
        if(this.assistant != null) {
            this.assistant.update(this.hashCode(), this.generateRecord());
        }
        return true;
    }

    private ParkingLotStatus getLotStatus() {
        return this.isFull() ? ParkingLotStatus.FULL : ParkingLotStatus.AVAILABLE;
    }

    public boolean isFull() {
        return occupiedSpaces == this.parkingSpaces.length;
    }

    public ParkingLotRecord generateRecord() {
        return new ParkingLotRecord(this.parkingSpaces.length-this.occupiedSpaces, this.getLotStatus());
    }
}
