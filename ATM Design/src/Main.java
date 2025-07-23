//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ATM icici = new ATM("ICICI");

        icici.AddAccounts(new Account(12345, 1432, 15000));

        System.out.println("Using bank ICICI");
        icici.performOperations();
    }
}