public class SoldOutState implements VendingState{
    @Override
    public VendingState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Machine is sold out. Coin returned: Rs " + coin);
        return machine.getSoldOutState(); // Stay in same state
    }

    @Override
    public VendingState selectItem(VendingMachine machine) {
        System.out.println("Machine is sold out!");
        return machine.getSoldOutState(); // Stay in same state
    }

    @Override
    public VendingState dispense(VendingMachine machine) {
        System.out.println("Machine is sold out!");
        return machine.getSoldOutState(); // Stay in same state
    }

    @Override
    public VendingState returnCoin(VendingMachine machine) {
        System.out.println("Machine is sold out. No coin inserted.");
        return machine.getSoldOutState(); // Stay in same state
    }

    @Override
    public VendingState refill(VendingMachine machine, int quantity) {
        System.out.println("Items refilling");
        machine.incrementItemCount(quantity);
        return machine.getNoCoinState();
    }

    @Override
    public String getStateName() {
        return "SOLD_OUT";
    }
}
