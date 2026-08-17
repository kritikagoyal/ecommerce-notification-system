public class TimestampDecorator extends MessageDecorator{

    public TimestampDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return " [10:54 AM] " + super.getContent();
    }
}
