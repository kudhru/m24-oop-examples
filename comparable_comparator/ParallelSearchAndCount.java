import java.util.HashMap;
import java.util.Set;

class KeyFinder extends Thread{
    int[] baseArray;
    int start;
    int end;
    int key;
    KeyFinder(int[] baseArray, int start, int end, int key) {
        this.baseArray = baseArray;
        this.start = start;
        this.end = end;
        this.key = key;
    }
    public void run () {
        System.out.println("Inside KeyFinder");
        for (int i = start; i < end; i++) {
            if (key == baseArray[i]) {
                System.out.println(i);
            }
        }
    }
}

class FrequencyCounter extends Thread{
    int[] baseArray;
    int start;
    int end;
    int key;
    HashMap<Integer, Integer> frequencyOfElements = new HashMap<>();
    FrequencyCounter(int[] baseArray, int start, int end) {
        this.baseArray = baseArray;
        this.start = start;
        this.end = end;

    }

    public void run () {
//        HashMap<Integer, Integer> frequencyOfElements = new HashMap<>();
        System.out.println("Inside FrequencyCounter");
        for (int i = start; i < end; i++) {
            frequencyOfElements.put(
                    baseArray[i],
                    frequencyOfElements.getOrDefault(baseArray[i], 0) + 1);
        }
//        return frequencyOfElements;
    }


}

public class ParallelSearchAndCount {
    int[] baseArray = new int[16];

    void searchKey (int key) throws InterruptedException {
        int numThreads = 4;
        int elementsPerThread = baseArray.length / numThreads;
        KeyFinder[] obj = new KeyFinder[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * elementsPerThread;
            int end = start + elementsPerThread;
            obj[i] = new KeyFinder(baseArray,start,end, key);
            obj[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            obj[i].join();
        }
    }

    HashMap<Integer, Integer> countFrequencyOfElements() throws InterruptedException {
        int numThreads = 4;
        int elementsPerThread = baseArray.length / numThreads;
        FrequencyCounter[] obj = new FrequencyCounter[numThreads];
        HashMap<Integer, Integer> masterFrequencyOfElements = new HashMap<>();
        for (int i = 0; i < numThreads; i++) {
            int start = i * elementsPerThread;
            int end = start + elementsPerThread;
            obj[i] = new FrequencyCounter(baseArray,start,end);
            obj[i].start();

        }
        for (int i = 0; i < numThreads; i++) {
            obj[i].join();
            Set<Integer> keyset = obj[i].frequencyOfElements.keySet();
            for (Integer key : keyset) {
                masterFrequencyOfElements.put(
                        key,
                        masterFrequencyOfElements.getOrDefault(key, 0) + obj[i].frequencyOfElements.get(key)
                );
            }
        }

        return masterFrequencyOfElements;
    }

    public static void main(String[] args) throws InterruptedException {
        ParallelSearchAndCount obj = new ParallelSearchAndCount();
        for (int i = 0; i < obj.baseArray.length; i++) {
            obj.baseArray[i] = i+1000;
        }
        System.out.println(obj.baseArray.length);
        obj.searchKey(4);
        obj.searchKey(4000);
        obj.searchKey(5000);
        HashMap<Integer, Integer> frequencyCounts = obj.countFrequencyOfElements();
    }
}
