public abstract class UIElements {

    protected String text;

    public UIElements(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}
