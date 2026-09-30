import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SortingStrategy [] strategies = {
            new BubbleSort(),
            new SelectionSort(),
            new InsertionSort()
        };

        SortContext context = new SortContext(strategies[0]);

        System.out.println("\nTest 1: Small array (30 elems)");
        int[] smallArray = generateRandomArray(30);
        benchmark(context, strategies, smallArray);

        System.out.println("\nTest 2: Medium array (1000 elems)");
        int[] mediumArray = generateRandomArray(1000);
        benchmark(context, strategies, mediumArray);

        System.out.println("\nTest 3: Large array (10000 elems)");
        int[] largeArray = generateRandomArray(10000);
        benchmark(context, strategies, largeArray);
    }


    private static void benchmark(SortContext context, SortingStrategy[] strategies, int[] array) {
        for (SortingStrategy strategy : strategies) {
            int[] arrayCopy = array.clone(); // Clone the original array to avoid sorting an already sorted array
            context.setStrategy(strategy);
            long startTime = System.nanoTime();
            context.executeSort(arrayCopy);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println(strategy.getName() + " took " + duration + " nanoseconds.");
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Random numbers between 0 and 99
        }
        return array;
    }
}
