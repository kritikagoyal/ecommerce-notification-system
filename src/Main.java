public class Main {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Notification System ===");

        Order order = new Order("123", "Laptop", 150.00, "India", "KRITIKA");

        NotificationService notificationService = new NotificationService();
        notificationService.setChannel(new PushChannel());

        OrderService orderService = new OrderService();
        orderService.registerListener(new InventoryService());
        orderService.registerListener(new AnalyticsService());
        orderService.registerListener(notificationService);

        Message message = new SimpleMessage();
        message = new TimestampDecorator(message);
        message = new UrgencyDecorator(message);

        orderService.placeOrder(order);

        FraudChecker fraudChecker = FraudCheckFactory.buildChain();
        boolean isValid = fraudChecker.check(order);

        if (!isValid) {
            System.out.println("Process terminated: Validation failed");
            return;
        }

        notificationService.notifyUsers(message.getContent());
    }
}
