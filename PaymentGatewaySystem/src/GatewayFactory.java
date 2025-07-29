public class GatewayFactory {
    private static GatewayFactory instance = null;

    private GatewayFactory(){}

    public static GatewayFactory getInstance(){
        if(instance == null){
            instance = new GatewayFactory();
        }
        return instance;
    }

    public PaymentGateway getGateway(GatewayType type){
        if(type == GatewayType.PAYTM){
            PaymentGateway paymentGateway = new PaytmGateway();
            return new PaymentGatewayProxy(paymentGateway, 3);
        }else{
            PaymentGateway paymentGateway = new RazorPayGateway();
            return  new PaymentGatewayProxy(paymentGateway, 1);
        }
    }
}
