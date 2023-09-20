package app.pattern;

/**
 * @author dimmy
 */
public class AliPay  implements PaymentWay{
    @Override
    public boolean pay() {
        return false;
    }
}
