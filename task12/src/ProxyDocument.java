import java.time.LocalDate;

public class ProxyDocument implements Document{
    private String id;
    private LocalDate creationDate;
    private RealDocument realDocument;

    public ProxyDocument(String id, LocalDate creationDate, RealDocument realDocument) {
        this.id = id;
        this.creationDate = creationDate;
        this.realDocument = realDocument;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        AccessControlService accessControlService = AccessControlService.getInstance();
        if (accessControlService.checkPermission(user.getUsername(), id)) {
            System.out.println("Access granted to user: " + user.getUsername() + " for document: " + id);
            return realDocument.getContent(user);
        } else {
            System.out.println("Access denied to user: " + user.getUsername() + " for document: " + id);
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}
