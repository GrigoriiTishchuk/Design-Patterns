import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class AccessControlService {
    private static AccessControlService instance;
    private Map<String, Set<String>> userPermissions;

    private AccessControlService() {
        userPermissions = new HashMap<>();
    }
    // singleton instance accessor
    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantPermission(User user, String documentId) {
        userPermissions.computeIfAbsent(user.getUsername(), k -> new HashSet<>()).add(documentId);
    }

    public boolean checkPermission(String username, String documentId) {
        Set<String> permissions = userPermissions.get(username);
        return permissions != null && permissions.contains(documentId);
    }
}
