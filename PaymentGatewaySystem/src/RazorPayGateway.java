import Model.PaymentRequest;

// ----------------------------
// Concrete Payment Gateway for Razorpay
// ----------------------------


public class RazorPayGateway extends PaymentGateway{

    public RazorPayGateway(){
        this.bankingSystem = new RazorPayBankingSystem();
    }
    @Override
    protected boolean validatePayment(PaymentRequest request) {
        System.out.println("[Razorpay] Validating payment for "+request.getSender()+".");
        if(request.getAmount() <= 0){
            return false;
        }
        return true;
    }

    @Override
    protected boolean initiatePayment(PaymentRequest request) {
        System.out.println("[Razorpay] Initiating payment for "+request.getAmount()
        +" "+request.getCurrency()+" for "+request.getSender()+".");
        return bankingSystem.processPayment(request.getAmount());

    }

    @Override
    protected boolean confirmPayment(PaymentRequest request) {
        System.out.println("[Razorpay] Confirming payment for "+request.getSender()+".");
        return true;
    }
}
