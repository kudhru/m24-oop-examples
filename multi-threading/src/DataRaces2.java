package module07;

public class DataRaces2 extends Thread {
    static int x;
    static synchronized void incdec() {
        x = x + 1;
        try {
        	Thread.sleep(10);
        } catch(InterruptedException e) {
        	
        }
        x = x - 1;
    }
    public void run() {
        for (int i = 0; i < 10; i++)
            incdec();
    }
    public static void main(String[] args) throws InterruptedException {
        x = 0;
        DataRaces2[] threads = new DataRaces2[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new DataRaces2();
            threads[i].start();
        }
        for (DataRaces2 t : threads)
            t.join();  // wait for all threads
        System.out.println(x); // always 0 now
    }
}
