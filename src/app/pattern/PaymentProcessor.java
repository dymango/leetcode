package app.pattern;

/**
 * @author dimmy
 */
public class PaymentProcessor {

    public void process(PaymentWay paymentWay) {
        boolean pay = paymentWay.pay();
    }
}
