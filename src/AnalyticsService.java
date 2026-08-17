public class AnalyticsService implements OrderListener{

    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("[Analytics] Tracking Order#1001: Laptop ($999.00)");
    }
}
