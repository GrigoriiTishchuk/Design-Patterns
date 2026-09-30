public class ContactRequestHandler extends FeedbackHandler {
    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("ContactRequestHandler: Processing contact request from " + message.getSenderEmail());
        System.out.println("Processing contact request: " + message.getContent());
    }
}
