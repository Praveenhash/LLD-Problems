import Model.PaymentRequest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Main: Client code now goes through controller
    public static void main(String[] args) {
        PaymentRequest req1 = new PaymentRequest("Praveen", "Akash", 1000.0, "INR");

        System.out.println("Processing via Paytm");
        System.out.println("------------------------------");
        boolean res1 = PaymentController.getInstance().handlePayment(GatewayType.PAYTM, req1);
        System.out.println("Result: " + (res1 ? "SUCCESS" : "FAIL"));
        System.out.println("------------------------------\n");

        PaymentRequest req2 = new PaymentRequest("Praveen", "Akash", 500.0, "USD");

        System.out.println("Processing via Razorpay");
        System.out.println("------------------------------");
        boolean res2 = PaymentController.getInstance().handlePayment(GatewayType.RAZORPAY, req2);
        System.out.println("Result: " + (res2 ? "SUCCESS" : "FAIL"));
        System.out.println("------------------------------");
    }
}