public class Main {
    public static void main(String[] args) {
        // trying all printers
        Printer basicPrinter = new BasicPrinter();
        Printer xmlPrinter = new XMLPrinter(basicPrinter);
        Printer encryptedPrinter = new EncryptedPrinter(xmlPrinter);
        String message = "Hello, World!";

        basicPrinter.print(message);

        xmlPrinter.print(message);

        encryptedPrinter.print(message);
    }
}
