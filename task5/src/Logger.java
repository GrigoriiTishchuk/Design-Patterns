import java.io.IOException;
import java.nio.file.*;



public class Logger {
    private static Logger instance;
    private String logFile = "log_task5.txt";

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String logFile) {
        this.logFile = logFile;
    }

    public synchronized void write(String message) {
        try {
            Files.writeString(Path.of(logFile), message + "\n",
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
