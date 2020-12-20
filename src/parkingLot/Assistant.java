package parkingLot;


import java.util.ArrayList;

public class Assistant {
    private ArrayList<ParkingLot> parkingLots;

    public Assistant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ArrayList<ParkingLotRecord> monitorLots() {
        ArrayList<ParkingLotRecord> parkingLotRecords = new ArrayList<>();
        for (ParkingLot parkingLot : this.parkingLots) {
            parkingLotRecords.add(parkingLot.generateRecord());
        }
        return parkingLotRecords;
    }

}
