//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ATM icici = new ATM("ICICI");

        icici.AddAccounts(new Account(12345, 1432, 10000));
        icici.AddAccounts(new Account(98765, 1234, 5000));
        icici.AddAccounts(new Account(12389, 1997, 8000));

        icici.PerformOperation();
    }
}