public class DispenseState implements VendingState{

    @Override
    public VendingState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Please wait, already dispensing item, Coin returned: Rs "+coin);
        return machine.getDispenseState();
    }

    @Override
    public VendingState selectItem(VendingMachine machine) {
        System.out.println("Already dispensing item. Please wait.");
        return machine.getDispenseState();
    }

    @Override
    public VendingState dispense(VendingMachine machine) {
        System.out.println("Item dispensed!");
        machine.decrementItemCount();

        if(machine.getItemCount() > 0){
            return machine.getNoCoinState();
        }else{
            System.out.println("Machine is now sold out");
            return machine.getSoldOutState();
        }
    }

    @Override
    public VendingState returnCoin(VendingMachine machine) {
        System.out.println("can not return while dispensing item!");
        return machine.getDispenseState();
    }

    @Override
    public VendingState refill(VendingMachine machine, int quantity) {
        System.out.println("can not refill in this state");
        return machine.getDispenseState();
    }

    @Override
    public String getStateName() {
        return "DISPENSING";
    }
}
