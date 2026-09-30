public class InsertionSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0...i-1], that are greater than key,
            // to one position ahead of their current position. Like a deck of cards,
            // we are inserting the key into the sorted portion of the array.
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
