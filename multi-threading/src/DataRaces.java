package module07;

public class DataRaces extends Thread {
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
		x =0;
		/*
		for(int i =0;i < 10;i++)
			new DataRaces().start();
		*/
		
		DataRaces[] dr = new DataRaces[10];
		for (int i = 0; i < 10; i++) {
			dr[i] = new DataRaces();			
			dr[i].start();
        }

        // wait for all threads to finish
        for (int i = 0; i < 10; i++) {
            try {
            	dr[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		System.out.println(x); // x not always 0!
	}
}
