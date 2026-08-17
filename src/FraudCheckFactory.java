public class FraudCheckFactory {
    public static FraudChecker buildChain() {
        FraudChecker amountChecker = new AmountChecker();
        FraudChecker locationChecker = new LocationChecker();
        FraudChecker frequencyChecker = new FrequencyChecker();

        amountChecker.setNext(locationChecker).setNext(frequencyChecker);
        return amountChecker;
    }
}
