public class Account {

    private int accountNo;
    private int pin;
    private double balance;

    public Account(int accountNo, int pin, double balance){
        this.accountNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
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
        balance -= amount;
        return true;
    }
    public void deposit(double amount){
        balance += amount;
    }
}
