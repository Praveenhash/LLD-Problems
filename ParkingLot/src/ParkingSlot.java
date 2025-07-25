public class ParkingSlot {

    private int slotId;
    private Size slotSize;
    private Vehicle currentVehicle;

    public ParkingSlot(int slotId, Size slotSize, Vehicle currentVehicle){
        this.slotId = slotId;
        this.slotSize = slotSize;
        this.currentVehicle = null;
    }

    public boolean isParkingSlotAvailable(){
        return currentVehicle==null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return isParkingSlotAvailable() && vehicle.getVehicleSize().ordinal() <= slotSize.ordinal();
    }

    public void parkVehicle(Vehicle vehicle){
        if(canFitVehicle(vehicle)){
            this.currentVehicle = vehicle;
        }
    }

    public void removeVehicle(){
        this.currentVehicle = null;
    }

    public int getSlotId() {
        return slotId;
    }

    public Size getSlotSize() {
        return slotSize;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}
