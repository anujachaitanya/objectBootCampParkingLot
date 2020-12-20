package parkingLot;


import parkingLot.lot.ParkingLot;
import parkingLot.lot.ParkingLotRecord;

import java.util.ArrayList;

public class Assistant {
    private ArrayList<Recordable> parkingLots;

    public Assistant(ArrayList<Recordable> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ArrayList<ParkingLotRecord> monitorLots() {
        ArrayList<ParkingLotRecord> parkingLotRecords = new ArrayList<>();
        for (Recordable parkingLot : this.parkingLots) {
            parkingLotRecords.add(parkingLot.generateRecord());
        }
        return parkingLotRecords;
    }
}
