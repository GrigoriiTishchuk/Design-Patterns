public abstract class PrinterDecorator implements Printer {
    protected Printer decoratedPrinter;

    public PrinterDecorator(Printer printer) {
        this.decoratedPrinter = printer;
    }

    @Override
    public void print(String message) {
        decoratedPrinter.print(message);
    }
}
