package parkingLot.lot;

import parkingLot.Assistant;
import parkingLot.Space.Space;

import java.util.Arrays;

public class ParkingLot {

    private final int capacity;
    private int occupiedSpaces;
    private Assistant assistant;


    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupiedSpaces = 0;
    }

    public void assignAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedSpaces++;
        if(this.assistant != null) {
            this.assistant.update(this.hashCode(), this.generateRecord());
        }
        return true;
    }

    private ParkingLotStatus getLotStatus() {
        return this.isFull() ? ParkingLotStatus.FULL : ParkingLotStatus.AVAILABLE;
    }

    public boolean isFull() {
        return occupiedSpaces == this.capacity;
    }

    public ParkingLotRecord generateRecord() {
        return new ParkingLotRecord(this.capacity -this.occupiedSpaces, this.getLotStatus());
    }
}
