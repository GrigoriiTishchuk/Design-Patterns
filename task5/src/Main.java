public class Main {
    public static void main(String[] args){
        Logger logger = Logger.getInstance();
        logger.write("Application started.");

        // changing file itself
        logger.setFileName("new_log_task5.txt");
        logger.write("This is a log message in the new log file.");
        logger.write("Application finished.");

    }
}
