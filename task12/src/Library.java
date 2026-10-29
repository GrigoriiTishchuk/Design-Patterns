import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Document> documents = new HashMap<>();

    public void addDocument(Document document) {
        documents.put(document.getId(), document);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }

    public void addUnprotectedDocument(String id, LocalDate creationDate, String content) {
        Document realDocument = new RealDocument(id, creationDate, content);
        addDocument(realDocument);
    }

    public void addProtectedDocument(String id, LocalDate creationDate, String content) {
        RealDocument realDocument = new RealDocument(id, creationDate, content);
        ProxyDocument proxyDocument = new ProxyDocument(id, creationDate, realDocument);
        addDocument(proxyDocument);
    }
}
