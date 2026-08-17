public class NotificationService implements OrderListener {

    private NotificationChannel notificationChannel;

    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("--- An order has been placed ---");
    }

    public void setChannel(NotificationChannel newChannel) {
        this.notificationChannel = newChannel;
    }

    public void notifyUsers(String message) {
        notificationChannel.send(message);
    }
}
