import java.util.Random;

// Concrete class for Banking System
public class RazorPayBankingSystem implements BankingSystem{

    private Random random = new Random();

    public RazorPayBankingSystem(){}


    @Override
    public boolean processPayment(double amount) {
        int r = random.nextInt(100);
        return r > 90;
    }
}
