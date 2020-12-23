package parkingLot;

import parkingLot.lot.ParkingLotStatus;

public interface ParkingLotListener {
    void notify(int lotId, ParkingLotStatus threshold );
}
