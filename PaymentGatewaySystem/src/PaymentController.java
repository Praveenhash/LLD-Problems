import Model.PaymentRequest;


// ----------------------------
// Controller class for all client requests (Singleton)
// ----------------------------

public class PaymentController {
    private static final PaymentController instance = new PaymentController();

    public static PaymentController getInstance(){
        return instance;
    }

    public boolean handlePayment(GatewayType type, PaymentRequest request){
        PaymentGateway paymentGateway = GatewayFactory.getInstance().getGateway(type);
        PaymentService.getInstance().setPaymentGateway(paymentGateway);
        return PaymentService.getInstance().processPayment(request);
    }
}
