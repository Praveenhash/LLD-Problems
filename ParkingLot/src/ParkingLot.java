import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<String, ParkingFloors> floors;
    private Map<String, Ticket> activeTickets;
    private int ticketCounter;

    public ParkingLot(){
        this.floors = new HashMap<>();
        this.activeTickets = new HashMap<>();
        this.ticketCounter = 1;
    }
//    public void addFloors(String floorId){
//        ParkingFloors floor = new ParkingFloors(floorId);
//        floors.put(floorId, floor);
//    }
    public void addFloors(ParkingFloors floor) {
        floors.put(floor.getFloorId(), floor);
    }


    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingFloors floor : floors.values()){
            ParkingSlot slot = floor.findAvailableSpot(vehicle);
            if(slot != null){
                slot.parkVehicle(vehicle);
                String ticketId = "Ticket"+ticketCounter++;
                Ticket ticket = new Ticket(ticketId, vehicle.getVehicleNo(), slot.getSlotId());
                //ticket.toString();
                activeTickets.put(ticketId, ticket);
                System.out.println("Your vehicle "+vehicle.getVehicleNo()+" has been parked at floor no: "+floor.getFloorId()+" and slot no: "+slot.getSlotId()+" and your ticket id: "+ticketId);
                return ticket;
            }
        }
        return null;
    }

    public void exitVehicle(String ticketId){
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket != null) {
            int slotId = ticket.getSlotId(); // Ensure correct type
            for (ParkingFloors floor : floors.values()) {
                for (ParkingSlot slot : floor.getSlots()) {
                    if (slot.getSlotId() == slotId) {
                        slot.removeVehicle(); // ✅ only remove from matched slot
                        activeTickets.remove(ticketId); // ✅ remove the ticket
                        return; // ✅ done, exit early
                    }
                }
            }
        } else {
            System.out.println("Invalid ticket ID!");
        }
    }
}
