public class CompensationHandler extends FeedbackHandler {
    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("CompensationHandler: Processing compensation claim from " + message.getSenderEmail());
        System.out.println("Processing compensation claim: " + message.getContent());
    }
}
