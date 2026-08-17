# LLD Patterns Cheat Sheet - 2 Minute Revision

## 1. Strategy Pattern (Interchangeable Algorithms)
**Goal:** Swap behaviors at runtime.
```java
// 1. Interface
public interface NotificationChannel { void send(String message); }
// 2. Concrete Strategies
public class EmailChannel implements NotificationChannel {
    public void send(String message) { /*...*/ }
}
// 3. Context
public class NotificationService {
    private NotificationChannel channel;
    public void setChannel(NotificationChannel c) { this.channel = c; }
    public void notifyUsers(String msg) { channel.send(msg); }
}
```
* **Pointers to Remember:**
    * Context delegates work to the strategy interface.
    * Easy to add new channels without changing existing code (Open/Closed Principle).

---

## 2. Observer Pattern (Event Pub/Sub)
**Goal:** Notify multiple objects about state changes.
```java
// 1. Listener Interface
public interface OrderListener { void onOrderPlaced(Order order); }
// 2. Subject
public class OrderService {
    private List<OrderListener> listeners = new ArrayList<>();
    public void registerListener(OrderListener l) { listeners.add(l); }
    public void placeOrder(Order order) {
        for(OrderListener l : listeners) l.onOrderPlaced(order);
    }
}
```
* **Pointers to Remember:**
    * Subject holds a `List<OrderListener>` and loops through them to broadcast.
    * Subject should only know about the Listener interface, never concrete implementations.

---

## 3. Chain of Responsibility (Processing Chain)
**Goal:** Pass requests along a chain of handlers.
```java
// 1. Abstract Handler
public abstract class FraudChecker {
    protected FraudChecker next;
    public FraudChecker setNext(FraudChecker h) { this.next = h; return h; }
    public abstract boolean check(Order o);
    protected boolean checkNext(Order o) { return next == null || next.check(o); }
}
// 2. Concrete Handlers
public class AmountChecker extends FraudChecker {
    public boolean check(Order o) {
        if (o.getAmount() > 10000) return false;
        return checkNext(o);
    }
}
```
* **Pointers to Remember:**
    * Each handler decides either to block or pass the request to `checkNext`.
    * Returning `setNext(h)` allows fluent method chaining (e.g., `h1.setNext(h2).setNext(h3)`).

---

## 4. Decorator Pattern (Dynamic Wrapping)
**Goal:** Add responsibilities to objects dynamically.
```java
// 1. Component Interface
public interface Message { String getContent(); }
// 2. Base Implementation & Base Decorator
public class SimpleMessage implements Message { public String getContent() { return "Order placed."; } }
public class MessageDecorator implements Message {
    protected Message message;
    public MessageDecorator(Message m) { this.message = m; }
    public String getContent() { return message.getContent(); }
}
// 3. Concrete Decorator
public class UrgencyDecorator extends MessageDecorator {
    public UrgencyDecorator(Message m) { super(m); }
    public String getContent() { return "[URGENT] " + super.getContent(); }
}
```
* **Pointers to Remember:**
    * The Base Decorator has a *dual identity*: it implements the Component interface *and* holds a reference to it.
    * Stack them like nesting dolls at runtime (`new UrgencyDecorator(new TimestampDecorator(new SimpleMessage()))`).