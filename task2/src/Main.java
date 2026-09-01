public class Main {

    public static void render(UIFactory factory) {
        Button button = factory.createButton("Click Me");
        TextField textField = factory.createTextField("Enter Text");
        Checkbox checkbox = factory.createCheckbox("Accept Terms");
        // DEFAULT DISPLAY
        button.display();
        textField.display();
        checkbox.display();

        // Custom display through setText
        button.setText("Submit");
        textField.setText("Type Here");
        checkbox.setText("I Agree");

        button.display();
        textField.display();
        checkbox.display();
    }


    public static void main(String[] args) {
        System.out.println("Rendering UI with AFactory:");
        UIFactory aFactory = new AFactory();
        render(aFactory);

        System.out.println("\nRendering UI with BFactory:");
        UIFactory bFactory = new BFactory();
        render(bFactory);
    }
}
