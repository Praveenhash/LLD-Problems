import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {

    private String bankname;
    private List<Account> accounts;

    public ATM(String bankname){
        this.bankname = bankname;
        this.accounts = new ArrayList<>();
    }

    public String getBankname() {
        return bankname;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void AddAccounts(Account account){
        accounts.add(account);
    }


    public Account authenticateUser(int accNo, int pin){

        for (Account account : accounts) {
            if (account.getAccountNo() == accNo && account.getPin() == pin) {
                return account;
            }
        }
        return null;
    }

    public void displayMenu(){
        System.out.println("Welcome to "+bankname+" ATM ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Pin Change");
        System.out.println("5. Exit");
    }

    public void performOperations(){
        int choice;
        int accNo, pin;
        Account currentAcc = null;
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        // If user enters Incorrect 3 time account gets blocked
        while (count > 0) {
            System.out.println("Enter account no:");
            accNo = scanner.nextInt();
            System.out.println("Enter PIN:");
            pin = scanner.nextInt();

            currentAcc = authenticateUser(accNo, pin);

            if (currentAcc != null) {
                break; // success
            } else {
                count--;
                if (count == 0) {
                    System.out.println("You have reached the max limit. Your account has been blocked.");
                    System.exit(0);
                } else {
                    System.out.println("Invalid credentials. You have " + count + " attempts left.");
                }
            }
        }

        do{
            displayMenu();
            System.out.println("Enter your choice...!");
            choice = scanner.nextInt();
            switch(choice){
                case 1: {
                    double amount;
                    System.out.println("Enter amount to withdraw..!");
                    amount = scanner.nextDouble();
                    if(currentAcc.withdraw(amount)){
                        System.out.println("Enter your pin");
                        pin = scanner.nextInt();
                        if(currentAcc.getPin()==pin){
                            System.out.println("Transaction Successful, Remaining Balance: $"+currentAcc.getBalance());
                        }else {
                            System.out.println("Invalid Pin");
                        }
                    }else{
                        System.out.println("Insufficient Balance");
                    }
                    break;
                }
                case 2: {
                    double amount;
                    System.out.println("Enter amount to deposit");
                    amount = scanner.nextDouble();
                    System.out.println("Enter your pin number to deposit");
                    pin = scanner.nextInt();
                    if(currentAcc.getPin() == pin) {
                        currentAcc.deposit(amount);
                        System.out.println("The total available balance is $"+currentAcc.getBalance());
                    }else{
                        System.out.println("Invalid pin number....Try again...!");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Enter your pin...!");
                    pin = scanner.nextInt();
                    if(currentAcc.getPin()==pin)
                        System.out.println("Current Balance is : $"+currentAcc.getBalance());
                    else{
                        System.out.println("Incorrect pin...!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter your old pin");
                    pin = scanner.nextInt();
                    if(currentAcc.getPin()==pin){
                        System.out.println("Enter your new pin....!");
                        pin = scanner.nextInt();
                        currentAcc.setPin(pin);
                        System.out.println("Your new pin is: "+currentAcc.getPin());
                    }else{
                        System.out.println("Incorrect pin");
                    }
                    //currentAcc = authenticateUser(accNo, pin);
                    break;
                }
                case 5:{
                    System.out.println("Thanks for choosing "+bankname+" ATM ");
                    break;
                }
                default:{
                    System.out.println("Invalid choice...Try again...!");
                    break;
                }
            }
        }while (choice != 5);
    }
}
