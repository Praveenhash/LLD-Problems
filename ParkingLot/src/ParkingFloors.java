import java.util.ArrayList;
import java.util.List;

public class ParkingFloors {

    private String floorId;
    private List<ParkingSlot> slots;

    public ParkingFloors(String floorId){
        this.floorId = floorId;
        this.slots = new ArrayList<>();
    }

    public String getFloorId() {
        return floorId;
    }
    public void addSlots(int slotId){
        ParkingSlot slot = new ParkingSlot(slotId, Size.MEDIUM, null);
        slots.add(slot);
    }
    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public ParkingSlot findAvailableSpot(Vehicle vehicle){
        for(ParkingSlot spot : slots){
            if(spot.canFitVehicle(vehicle)){
                return spot;
            }
        }
        return null;
    }
}
