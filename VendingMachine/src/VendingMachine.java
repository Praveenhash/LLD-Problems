public class VendingMachine {
    private VendingState currentState;

    private int itemPrice;
    private int itemCount;
    private int insertedCoin;

    private VendingState noCoinState;
    private VendingState hasCoinState;
    private VendingState dispenseState;
    private VendingState soldOutState;

    public VendingMachine(int itemCount, int itemPrice){
        this.itemCount=itemCount;
        this.itemPrice=itemPrice;

        noCoinState = new NoCoinState();
        hasCoinState = new HasCoinState();
        dispenseState = new DispenseState();
        soldOutState = new SoldOutState();

        if(itemCount > 0){
            currentState = noCoinState;
        }else {
            currentState = soldOutState;
        }
    }
    public void insertCoin(int coin){
        currentState = currentState.insertCoin(this, coin);
    }

    public void selectItem(){
        currentState=currentState.selectItem(this);
    }

    public void dispense(){
        currentState=currentState.dispense(this);
    }

    public void returnCoin(){
        currentState=currentState.returnCoin(this);
    }

    public void refill(int quantity){
        currentState=currentState.refill(this, quantity);
    }

    public void printStatus(){
        System.out.println("\n--- Vending Machine Status ---");
        System.out.println("Items remaining: " + itemCount);
        System.out.println("Inserted coin: Rs " + insertedCoin);
        System.out.println("Current state: " + currentState.getStateName() + "\n");
    }

    public VendingState getNoCoinState() {
        return noCoinState;
    }

    public VendingState getHasCoinState() {
        return hasCoinState;
    }

    public VendingState getDispenseState() {
        return dispenseState;
    }

    public VendingState getSoldOutState() {
        return soldOutState;
    }

    public int getItemCount(){
        return itemCount;
    }

    public void decrementItemCount(){
        itemCount--;
    }

    public void incrementItemCount(int count){
        itemCount += count;
    }

    public int getInsertedCoin(){
        return insertedCoin;
    }

    public void setInsertedCoin(int coin){
        insertedCoin = coin;
    }

    public void addCoin(int coin){
        insertedCoin += coin;
    }
    public int getPrice(){
        return this.itemPrice;
    }

    public void setPrice(int itemPrice){
        this.itemPrice = itemPrice;
    }
}
