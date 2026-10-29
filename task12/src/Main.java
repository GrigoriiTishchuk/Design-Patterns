import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Init AccessControlService (Singleton)
        AccessControlService accessControlService = AccessControlService.getInstance();
        // Create library and populate it with documents
        Library library = new Library();
        // Add unprotected and protected documents
        library.addUnprotectedDocument("doc1", LocalDate.of(2026, 1, 1), "This is an unprotected document.");
        library.addProtectedDocument("doc2", LocalDate.of(2026, 1, 2), "This is an protected document 1.");
        library.addProtectedDocument("doc3", LocalDate.of(2026, 1, 3), "This is an protected document 2.");
        // Create users
        User Greg = new User("Greg");
        User guest = new User("guest");
        User Lisa = new User("Lisa");
        // Grant permissions to users for protected documents
        accessControlService.grantPermission(Greg, "doc2");
        accessControlService.grantPermission(Lisa, "doc3");
        accessControlService.grantPermission(Greg, "doc3");

        Document protectedDocument = library.getDocument("doc2");
        System.out.println("Trying to access protected document 'doc2' as Greg:"+
                "\nDocument ID: " + protectedDocument.getId() +
                "\nCreation Date: " + protectedDocument.getCreationDate() +
                "\nContent: " + protectedDocument.getContent(Greg));

        Document publicDocument = library.getDocument("doc1");
        System.out.println("Checking unprotected document 'doc1' as guest:"+
                "\nDocument ID: " + publicDocument.getId() +
                "\nCreation Date: " + publicDocument.getCreationDate() +
                "\nContent: " + publicDocument.getContent(guest));

        System.out.println("Trying to access protected document 'doc2' as Lisa:");
        try{
            System.out.println("Document ID: " + protectedDocument.getId() +
                    "\nCreation Date: " + protectedDocument.getCreationDate() +
                    "\nContent: " + protectedDocument.getContent(Lisa));
        } catch (AccessDeniedException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }
    }
}
