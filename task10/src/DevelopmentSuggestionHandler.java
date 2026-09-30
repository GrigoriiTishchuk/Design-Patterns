public class DevelopmentSuggestionHandler extends FeedbackHandler{
    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("DevelopmentSuggestionHandler: Processing development suggestion from " + message.getSenderEmail());
        System.out.println("Processing development suggestion: " + message.getContent());
    }
}
