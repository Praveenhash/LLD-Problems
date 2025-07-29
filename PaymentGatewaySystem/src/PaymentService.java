import Model.PaymentRequest;

// ----------------------------
// Unified API service (Singleton)
// ----------------------------

public class PaymentService {
    private PaymentGateway paymentGateway;
    private static PaymentService instance = null;

    private PaymentService(){
        this.paymentGateway = null;
    }
    public static PaymentService getInstance(){
        if(instance == null){
            instance = new PaymentService();
        }
        return instance;
    }

    public void setPaymentGateway(PaymentGateway gateway){
        this.paymentGateway = gateway;
    }

    public boolean processPayment(PaymentRequest request){
        if(paymentGateway == null){
            System.out.println("[PaymentService] No payment gateway selected.");
            return false;
        }
        return paymentGateway.processPayment(request);
    }
}
