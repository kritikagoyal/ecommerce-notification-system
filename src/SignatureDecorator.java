public class SignatureDecorator extends MessageDecorator{
    public SignatureDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return " [SIGNATURE] " + super.getContent();
    }
}
