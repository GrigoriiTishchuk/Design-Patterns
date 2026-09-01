public abstract class TextField extends UIElements{
    public TextField(String text) {
        super(text);
    }
}

class TextFieldA extends TextField{
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("TextField A: " + text);
    }
}

class TextFieldB extends TextField{
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("TextField B: " + text);
    }
}