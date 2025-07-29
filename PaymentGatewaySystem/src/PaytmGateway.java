import Model.PaymentRequest;

// ----------------------------
// Concrete Payment Gateway for Paytm
// ----------------------------

public class PaytmGateway extends PaymentGateway{

    public PaytmGateway(){
        this.bankingSystem = new PaytmBankingSystem();
    }
    @Override
    protected boolean validatePayment(PaymentRequest request) {
        System.out.println("[Paytm] validating payment for "+request.getSender()+".");
        if(request.getAmount() <= 0 || !"INR".equalsIgnoreCase(request.getCurrency())){
            return false;
        }
        return true;
    }

    @Override
    protected boolean initiatePayment(PaymentRequest request) {
        System.out.println("[Paytm] Initiating payment for "+request.getAmount()+" "+
                request.getCurrency()+" for "+request.getSender()+".");
        return bankingSystem.processPayment(request.getAmount());

    }

    @Override
    protected boolean confirmPayment(PaymentRequest request) {
        System.out.println("[Paytm] validating payment for "+request.getSender()+".");
        return true;
    }
}
