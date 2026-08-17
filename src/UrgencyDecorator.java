public class UrgencyDecorator extends MessageDecorator{

    public UrgencyDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return " [URGENT] " + super.getContent();
    }
}
