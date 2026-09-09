public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        decoratedPrinter.print(encryptedMessage);
    }

    private String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + 1)); // Shift each character by 1
        }
        return encrypted.toString();
    }
}
