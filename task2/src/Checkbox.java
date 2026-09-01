public abstract class Checkbox extends UIElements{
    public Checkbox(String text) {
        super(text);
    }
}

class CheckboxA extends Checkbox{
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("Checkbox A: " + text);
    }
}

class CheckboxB extends Checkbox{
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("Checkbox B: " + text);
    }
}
