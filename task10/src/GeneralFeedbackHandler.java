public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("GeneralFeedbackHandler: Processing general feedback from " + message.getSenderEmail());
        System.out.println("Processing general feedback: " + message.getContent());
    }
}
