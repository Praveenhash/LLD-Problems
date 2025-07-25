public class Ticket {

    private String ticketId;
    private String vehicleNo;
    private int slotId;
    // private ParkingFloors floors;
    public Ticket(String ticketId, String vehicleNo, int slotId){
        this.ticketId = ticketId;
        this.vehicleNo = vehicleNo;
        this.slotId = slotId;
        // this.floors = floorId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public int getSlotId() {
        return slotId;
    }

}
