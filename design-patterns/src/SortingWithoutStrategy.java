public class SortingWithoutStrategy {

    static class Sorter {

        public void sort(int[] data, String algorithm) {
            if ("bubble".equalsIgnoreCase(algorithm)) {
                bubbleSort(data);
            } else if ("quick".equalsIgnoreCase(algorithm)) {
                quickSort(data, 0, data.length - 1);
            } else if ("builtin".equalsIgnoreCase(algorithm)) {
                java.util.Arrays.sort(data);
            } else {
                System.out.println("Unknown algorithm: " + algorithm);
            }
        }

        // super simple bubble sort (not optimized)
        private void bubbleSort(int[] data) {
            System.out.println("Using Bubble Sort");
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

        // simple quick sort
        private void quickSort(int[] data, int low, int high) {
            if (low < high) {
                int p = partition(data, low, high);
                quickSort(data, low, p - 1);
                quickSort(data, p + 1, high);
            }
        }

        private int partition(int[] data, int low, int high) {
            System.out.println("Using Quick Sort");
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

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 3};
        int[] arr2 = {5, 2, 9, 1, 3};

        Sorter sorter = new Sorter();

        sorter.sort(arr1, "bubble");
        System.out.println("Bubble sorted: " + java.util.Arrays.toString(arr1));

        sorter.sort(arr2, "builtin");
        System.out.println("Built-in sorted: " + java.util.Arrays.toString(arr2));
    }
}
