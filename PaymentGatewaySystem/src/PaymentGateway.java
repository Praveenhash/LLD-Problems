import Model.PaymentRequest;

// ----------------------------
// Abstract base class for Payment Gateway (Template Method Pattern)
// ----------------------------

public abstract class PaymentGateway {
    protected BankingSystem bankingSystem;

    public PaymentGateway(){
        this.bankingSystem = null;
    }

    public boolean processPayment(PaymentRequest request){
        if(!validatePayment(request)){
            System.out.println("[PaymentGateway] validation failed for "+
                    request.getSender()+ ".");
            return false;
        }
        if(!initiatePayment(request)){
            System.out.println("[PaymentGateway] initiation failed for "+
                    request.getSender()+ ".");
            return false;
        }
        if(!confirmPayment(request)){
            System.out.println("[PaymentGateway] confirmation failed for "+
                    request.getSender()+ ".");
            return false;
        }
        return true;
    }
    protected abstract boolean validatePayment(PaymentRequest request);
    protected abstract boolean initiatePayment(PaymentRequest request);
    protected abstract boolean confirmPayment(PaymentRequest request);
}
