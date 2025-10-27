package module07;

class SharedArrayQueue {
    private final int[] buffer;
    private int capacity;
    private int count = 0;
    private int in = 0;
    private int out = 0;

    public SharedArrayQueue(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (count == capacity) {
            System.out.println(Thread.currentThread().getName() + " waiting - buffer full");
            wait();
        }

        buffer[in] = value;
        in = (in + 1) % capacity;
        count++;

        System.out.println(Thread.currentThread().getName() + " produced " + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (count == 0) {
            System.out.println(Thread.currentThread().getName() + " waiting - buffer empty");
            wait();
        }

        int value = buffer[out];
        out = (out + 1) % capacity;
        count--;

        System.out.println(Thread.currentThread().getName() + " consumed " + value);
        notifyAll();
        return value;
    }
}

// Multiple producers
class MultiProducer extends Thread {
    private final SharedArrayQueue queue;
    private final int id;

    MultiProducer(SharedArrayQueue queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    public void run() {
        int value = id * 100;
        try {
            while (true) {
                queue.produce(value++);
                Thread.sleep(300 + (int)(Math.random() * 400)); // variable delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Multiple consumers
class MultiConsumer extends Thread {
    private final SharedArrayQueue queue;

    MultiConsumer(SharedArrayQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                queue.consume();
                Thread.sleep(400 + (int)(Math.random() * 500)); // variable delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Demo
public class MultiProducerConsumer {
    public static void main(String[] args) {
        SharedArrayQueue queue = new SharedArrayQueue(5);

        // Start multiple producers and consumers
        for (int i = 1; i <= 2; i++) {
            new MultiProducer(queue, i).start();  // 2 producers
        }

        for (int i = 1; i <= 3; i++) {
            new MultiConsumer(queue).start();     // 3 consumers
        }
    }
}
