public class AmountChecker extends FraudChecker{
    @Override
    public boolean check(Order order) {
        if (order.getAmount() > 10000) {
            return false;
        }
        System.out.println("[Fraud Check] AmountChecker: PASSED");
        return checkNext(order);
    }
}
