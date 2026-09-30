public class SortContext {
    private SortingStrategy strategy;

    public SortContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] array) {
        if (strategy == null) {
            throw new IllegalStateException("Sorting strategy not set.");
        }
        strategy.sort(array);
    }
}
