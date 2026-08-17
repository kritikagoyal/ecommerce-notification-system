public abstract class FraudChecker {
    // 1. Holds the next handler in line
    protected FraudChecker next;

    // 2. Pass the baton to next
    public FraudChecker setNext(FraudChecker next) {
        this.next = next;
        return next;
    }

    // 3. Logic to be implemented by the child classes
    public abstract boolean check(Order order);

    // 4. Helper to pass the baton if the current check passes
    public boolean checkNext(Order order) {
        if (next == null) return true;
        return next.check(order);
    }
}