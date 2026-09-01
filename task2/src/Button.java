public abstract class Button extends UIElements {
    public Button(String text) {
        super(text);
    }
}

class ButtonA extends Button{
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("Button A: " + text);
    }
}

class ButtonB extends Button{
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("Button B: " + text);
    }
}
