public class HasCoinState implements VendingState{
    @Override
    public VendingState insertCoin(VendingMachine machine, int coin) {
        machine.addCoin(coin);
        System.out.println("Additional coin inserted. Current balance: Rs "+machine.getInsertedCoin());
        return machine.getHasCoinState();
    }

    @Override
    public VendingState selectItem(VendingMachine machine) {
        if(machine.getInsertedCoin() >= machine.getPrice()){
            System.out.println("Item selected, Dispensing....!");

            int change = machine.getInsertedCoin() - machine.getPrice();
            if(change > 0){
                System.out.println("Change returned: Rs "+change);
            }
            machine.setInsertedCoin(0);
            return machine.getDispenseState();
        }else{
            int needed = machine.getPrice() - machine.getInsertedCoin();
            System.out.println("Insufficient funds. Need Rs "+needed+" more..!");
            return machine.getHasCoinState();
        }
    }

    @Override
    public VendingState dispense(VendingMachine machine) {
        System.out.println("Please select an item first!");
        return machine.getHasCoinState();
    }

    @Override
    public VendingState returnCoin(VendingMachine machine) {
        System.out.println("Coin returned: Rs "+machine.getInsertedCoin());
        machine.setInsertedCoin(0);
        return machine.getHasCoinState();
    }

    @Override
    public VendingState refill(VendingMachine machine, int quantity) {
        System.out.println("Can't refill in this state");
        return machine.getHasCoinState();
    }

    @Override
    public String getStateName() {
        return "HAS_COIN";
    }
}
