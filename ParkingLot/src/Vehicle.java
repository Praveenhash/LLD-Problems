public class Vehicle {

    private String vehicleNo;
    private Size vehicleSize;

    public Vehicle(String vehicleNo, Size vehicleSize){
        this.vehicleNo = vehicleNo;
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public Size getVehicleSize() {
        return vehicleSize;
    }
}
