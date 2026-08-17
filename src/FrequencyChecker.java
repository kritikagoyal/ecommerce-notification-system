public class FrequencyChecker extends FraudChecker{
    @Override
    public boolean check(Order order) {
        System.out.println("[Fraud Check] FrequencyChecker: PASSED");
        return checkNext(order);
    }
}
