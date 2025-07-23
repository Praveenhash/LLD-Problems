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
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccountNo() == accNo && accounts.get(i).getPin()==pin) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public void displayMenu(){
        System.out.println("Welcome to "+bankname+" ATM ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performOperations(){
        int choice;
        int accNo, pin;
        Account currentAcc = null;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter account no....!");
            accNo = scanner.nextInt();
            System.out.println("Enter the pin");
            pin = scanner.nextInt();

            currentAcc = authenticateUser(accNo, pin);

            if(currentAcc == null){
                System.out.println("Invalid credentials, Please try again...!");
            }
        } while (currentAcc == null);

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
                        System.out.println("Transaction Successful, Remaining balance: $"+currentAcc.getBalance());
                    }else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
                }
                case 2: {
                    double amount;
                    System.out.println("Enter amount to deposit");
                    amount = scanner.nextDouble();
                    currentAcc.deposit(amount);
                    System.out.println("The total available balance is $"+currentAcc.getBalance());
                    break;
                }
                case 3:{
                    System.out.println("Current Balance is : $"+currentAcc.getBalance());
                    break;
                }
                case 4:{
                    System.out.println("Thanks for choosing "+bankname+" ATM ");
                    break;
                }
                default:{
                    System.out.println("Invalid choice...Try again...!");
                    break;
                }
            }
        }while (choice != 4);
    }
}
