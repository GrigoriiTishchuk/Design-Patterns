public class Main {
    public static void main(String[] args) {
        FeedbackHandler compensationHandler = new CompensationHandler();
        FeedbackHandler complaintHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();


        // making a chain of responsibility
        compensationHandler.setNextHandler(complaintHandler);
        complaintHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);


        Message[] messages = new Message[]{
                new Message(MessageType.COMPENSATION_CLAIM,
                        "I would like to claim compensation for my recent purchase.\n",
                        "greg@mail.com"
                ),
                new Message(MessageType.CONTACT_REQUEST,
                        "I would like to get in touch with your support team.\n",
                        "client@mail.ru"
                ),
                new Message(MessageType.DEVELOPMENT_SUGGESTION,
                        "I have a suggestion for a new feature in your product.\n",
                        "dev@gmail.com"
                ),
                new Message(MessageType.GENERAL_FEEDBACK,
                        "I just wanted to say that I really enjoy using your product!\n",
                        "fan@happy.com"
                )
        };
        System.out.println("Processing messages...\n");
        for (Message message : messages) {
            compensationHandler.handleMessage(message);
        }
    }
}


