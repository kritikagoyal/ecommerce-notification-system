public class SimpleMessage implements Message{
    @Override
    public String getContent() {
        return "Order #123 confirmed.";
    }
}
