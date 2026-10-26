import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private String timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Memento created at " + timestamp);
    }

    public int[] getOptions() {
        return options.clone();
    }

    @Override
    public String toString() {
        return "State saved at " + timestamp;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
