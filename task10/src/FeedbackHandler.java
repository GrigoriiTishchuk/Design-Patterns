public abstract class FeedbackHandler {
    private FeedbackHandler nextHandler;

    public FeedbackHandler setNextHandler(FeedbackHandler nextHandler)
    {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handleMessage(Message message) {
        if (canHandleMessage(message)) {
            processMessage(message);
        }
        else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        } else {
            System.out.println("No handler available for message type: " + message.getType());
        }
    }

    protected abstract boolean canHandleMessage(Message message);
    protected abstract void processMessage(Message message);
}
