package module07;

public class DataRaces3 implements Runnable {
	static int x;
	public synchronized void run() {
		for(int i = 0;i < 10;i++){
			x = x + 1;
			
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				
			}
			
			x = x - 1;
		}
	}
	
	public static void main(String[] args){
		x = 0;
		DataRaces3 d = new DataRaces3();
		Thread[] threads = new Thread[10];
		
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			
		}
			
		for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(d);
            threads[i].start();
        }

        // wait for all threads to finish
        for (int i = 0; i < 10; i++) {
            try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		System.out.println(x); // x not always 0!
	}
}
