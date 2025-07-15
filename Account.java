public class Account {
    private int AccountNo;
    private int pin;
    private double balance;

    public Account(int AccountNo, int pin, double balance){
        this.AccountNo = AccountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount){
        if(balance < amount){
            return false;
        }
        balance = balance - amount;
        return true;
    }

    public void deposit(double amount){
        balance += amount;
    }
}
