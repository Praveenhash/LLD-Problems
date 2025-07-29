import java.util.Random;

// Concrete class for Banking System
public class PaytmBankingSystem implements BankingSystem{

    private Random random = new Random();

    public PaytmBankingSystem(){}

    @Override
    public boolean processPayment(double amount) {
        int r = random.nextInt(100);
        return r < 20;
    }
}
