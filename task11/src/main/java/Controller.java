import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    private Model model;
    private Gui gui;
    private ObservableList<IMemento> history;
    private List<IMemento> redoList;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = FXCollections.observableArrayList();
        this.redoList = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history (Undo)");
            // Current state goes to redo list
            IMemento currentState = model.createMemento();
            redoList.add(currentState);

            // Previous state restored from history
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Memento found in redo history (Redo)");
            // Current state goes back to undo history
            IMemento currentState = model.createMemento();
            history.add(currentState);

            // Next state removed from redo list and restored
            IMemento nextState = redoList.remove(redoList.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    public void restoreState(IMemento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoList.clear(); // Clear redo list when a new change is made to the model
    }

    public ObservableList<IMemento> getHistory() {
        return history;
    }
}