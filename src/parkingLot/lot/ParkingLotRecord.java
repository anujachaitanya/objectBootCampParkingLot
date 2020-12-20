package parkingLot.lot;

import java.util.Objects;

public class ParkingLotRecord {
    private final int availableSlots;
    private final ParkingLotStatus lotStatus;

    public ParkingLotRecord(int availableSlots, ParkingLotStatus lotStatus) {
        this.availableSlots = availableSlots;
        this.lotStatus = lotStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLotRecord that = (ParkingLotRecord) o;
        return availableSlots == that.availableSlots &&
            lotStatus == that.lotStatus;
    }

    @Override
    public String toString() {
        return "ParkingLotRecord{" +
                "availableSlots=" + availableSlots +
                ", lotStatus=" + lotStatus +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableSlots, lotStatus);
    }
}
