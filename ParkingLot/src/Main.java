import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("KA 05 S 690");
        Vehicle car1 = new Car("KA 28 EA 3421");
        Vehicle car2 = new Car("KA 17 EA 1213");
        Vehicle car3 = new Car("KA 18 EA 3424");
        Vehicle car4 = new Car("KA 20 EA 4235");
        ParkingFloors floor1 = new ParkingFloors("1");
        floor1.addSlots(1);
        floor1.addSlots(2);
//        floor1.addSlots(3);
//        floor1.addSlots(4);
        ParkingFloors floor2 = new ParkingFloors("2");
        floor2.addSlots(5);
        floor2.addSlots(6);
//        floor2.addSlots(7);
//        floor2.addSlots(8);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addFloors(floor1);
        parkingLot.addFloors(floor2);

        List<Ticket> tickets = new ArrayList<>();

        Ticket ticket = parkingLot.parkVehicle(car);
        Ticket ticket1 = parkingLot.parkVehicle(car1);
        Ticket ticket2 = parkingLot.parkVehicle(car2);
        Ticket ticket3 = parkingLot.parkVehicle(car3);
        tickets.add(ticket);
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        System.out.println("Exiting ticket with ID: " + ticket1.getTicketId());
        parkingLot.exitVehicle(ticket1.getTicketId());
        Ticket ticket4 = parkingLot.parkVehicle(car4);
        tickets.add(ticket4);

        for(Ticket tckt: tickets){
            System.out.println(tckt);
        }
    }
}