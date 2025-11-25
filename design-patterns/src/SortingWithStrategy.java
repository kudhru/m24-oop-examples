public class SortingWithStrategy {

    // ----- Strategy interface -----
    interface SortStrategy {
        void sort(int[] data);
    }

    // ----- Concrete Strategies -----

    // 1. Bubble Sort
    static class BubbleSortStrategy implements SortStrategy {
        @Override
        public void sort(int[] data) {
            System.out.println("Sorting using Bubble Sort");
            int n = data.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (data[j] > data[j + 1]) {
                        int temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
        }
    }

    // 2. Quick Sort
    static class QuickSortStrategy implements SortStrategy {
        @Override
        public void sort(int[] data) {
            System.out.println("Sorting using Quick Sort");
            quickSort(data, 0, data.length - 1);
        }

        private void quickSort(int[] data, int low, int high) {
            if (low < high) {
                int p = partition(data, low, high);
                quickSort(data, low, p - 1);
                quickSort(data, p + 1, high);
            }
        }

        private int partition(int[] data, int low, int high) {
            int pivot = data[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (data[j] <= pivot) {
                    i++;
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
            int temp = data[i + 1];
            data[i + 1] = data[high];
            data[high] = temp;
            return i + 1;
        }
    }

    // 3. Java built-in sort
    static class BuiltInSortStrategy implements SortStrategy {
        @Override
        public void sort(int[] data) {
            System.out.println("Sorting using Java Arrays.sort()");
            java.util.Arrays.sort(data);
        }
    }

    // ----- Context -----
    static class Sorter {
        private SortStrategy strategy;

        public Sorter(SortStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(SortStrategy strategy) {
            this.strategy = strategy;
        }

        public void sort(int[] data) {
            if (strategy == null) {
                throw new IllegalStateException("SortStrategy not set");
            }
            strategy.sort(data);
        }
    }

    // ----- Demo -----
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 3};
        int[] arr2 = {8, 4, 7, 2, 6};
        int[] arr3 = {10, 9, 8, 7, 6};

        Sorter sorter = new Sorter(new BubbleSortStrategy());
        sorter.sort(arr1);
        System.out.println("Result: " + java.util.Arrays.toString(arr1));

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(arr2);
        System.out.println("Result: " + java.util.Arrays.toString(arr2));

        sorter.setStrategy(new BuiltInSortStrategy());
        sorter.sort(arr3);
        System.out.println("Result: " + java.util.Arrays.toString(arr3));
    }
}
