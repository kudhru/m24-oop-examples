package module07;

//Array-based bounded buffer (circular queue)
class ArrayQueue {
 private final int[] buffer;
 private int capacity;
 private int count = 0;   // number of items
 private int in = 0;      // next insertion index
 private int out = 0;     // next removal index

 public ArrayQueue(int capacity) {
     this.capacity = capacity;
     buffer = new int[capacity];
 }

 // Producer inserts item
 public synchronized void produce(int value) throws InterruptedException {
     while (count == capacity) {
         System.out.println(Thread.currentThread().getName() + " waiting - buffer full");
         wait();
     }

     buffer[in] = value;
     in = (in + 1) % capacity;
     count++;

     System.out.println(Thread.currentThread().getName() + " produced " + value);
     notifyAll(); // wake up consumer
 }

 // Consumer removes item
 public synchronized int consume() throws InterruptedException {
     while (count == 0) {
         System.out.println(Thread.currentThread().getName() + " waiting - buffer empty");
         wait();
     }

     int value = buffer[out];
     out = (out + 1) % capacity;
     count--;

     System.out.println(Thread.currentThread().getName() + " consumed " + value);
     notifyAll(); // wake up producer
     return value;
 }
}

//Producer thread
class Producer extends Thread {
 private final ArrayQueue queue;

 Producer(ArrayQueue queue) {
     this.queue = queue;
 }

 public void run() {
     int value = 0;
     try {
         while (true) {
             queue.produce(value++);
             Thread.sleep(500);
         }
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }
}

//Consumer thread
class Consumer extends Thread {
 private final ArrayQueue queue;

 Consumer(ArrayQueue queue) {
     this.queue = queue;
 }

 public void run() {
     try {
         while (true) {
             queue.consume();
             Thread.sleep(800);
         }
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }
}

//Demo
public class SingleProducerConsumer {
 public static void main(String[] args) {
     ArrayQueue queue = new ArrayQueue(5);
     Producer p = new Producer(queue);
     Consumer c = new Consumer(queue);

     p.start();
     c.start();
 }
}

