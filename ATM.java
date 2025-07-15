import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {

    private String bankName;
    private List<Account> accounts;

    public ATM(String bankName){
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    public void AddAccounts(Account account){
        accounts.add(account);
    }

    public Account authenticateUser(int accountNo, int pin){
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccountNo() == accountNo && accounts.get(i).getPin() == pin){
                return accounts.get(i);
            }
        }
        return null;
    }

    public void displayMenu(){
        System.out.println("Welcome to "+bankName+" ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void PerformOperation(){
        int choice;
        int accNo, pin;
        Account currentAcc = null;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter Account No");
            accNo = scanner.nextInt();

            System.out.println("Enter pin");
            pin = scanner.nextInt();

            currentAcc = authenticateUser(accNo, pin);

        } while(currentAcc == null);

        do{
            displayMenu();
            System.out.println("Enter your choice...!");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                {   double amount;
                    System.out.println("Enter amount to withdraw...!");
                    amount = scanner.nextDouble();
                    if(currentAcc.withdraw(amount)){
                        System.out.println("Transaction is successful, remaining balance is $"+currentAcc.getBalance());
                    }else {
                        System.out.println("Insufficient of balance....!");
                    }
                    break;
                }
                case 2 :
                {
                    double amount;
                    System.out.println("Enter amount to Deposit...!");
                    amount = scanner.nextDouble();
                    currentAcc.deposit(amount);
                    System.out.println("Transaction is Successful, remaining balance is $"+currentAcc.getBalance());
                    break;
                }
                case 3 :
                {
                    System.out.println("The current balance is $"+currentAcc.getBalance());
                    break;
                }
                case 4 :
                {
                    System.out.println("Thank you for choosing "+bankName+ " ATM");
                    break;
                }
                default:
                    System.out.println("Invalid choice..!");
                    break;
            }
        } while(choice != 4);
    }
}
