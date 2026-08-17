import java.util.ArrayList;
import java.util.List;

public class OrderService {

    List<OrderListener> listeners = new ArrayList<>();

    public void registerListener(OrderListener orderListener) {
        listeners.add(orderListener);
    }

    public void placeOrder(Order order) {
        for (OrderListener listener : listeners) {
            listener.onOrderPlaced(order);
        }
    }
}
