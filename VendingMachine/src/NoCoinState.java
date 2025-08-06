public class NoCoinState implements VendingState{
    @Override
    public VendingState insertCoin(VendingMachine machine, int coin) {
        machine.setInsertedCoin(coin);
        System.out.println("Coin inserted. Current Balance: Rs "+coin);
        return machine.getHasCoinState();
    }

    @Override
    public VendingState selectItem(VendingMachine machine) {
        System.out.println("Please insert coin first!");
        return machine.getNoCoinState(); // Stay in same state
    }

    @Override
    public VendingState dispense(VendingMachine machine) {
        System.out.println("Please insert coin and select item first!");
        return machine.getNoCoinState(); // Stay in same state
    }

    @Override
    public VendingState returnCoin(VendingMachine machine) {
        System.out.println("No coin to return!");
        return machine.getNoCoinState(); // Stay in same state
    }

    @Override
    public VendingState refill(VendingMachine machine, int quantity) {
        System.out.println("Items refilling");
        machine.incrementItemCount(quantity);
        return machine.getNoCoinState();
    }

    @Override
    public String getStateName() {
        return "NO_COIN";
    }
}
