package module07.multithreading;

import java.util.concurrent.*;
class PrintJob implements Runnable{
	String name;
	PrintJob(String name1){
		name=name1;
	}
	public void run(){
		System.out.println(name+" ---Job started by Thread:"+Thread.currentThread().getName());
		try{
			Thread.sleep(5000);
		}
		catch(Exception e){}
		System.out.println(name+" ---Job completed by Thread:"+Thread.currentThread().getName());
	}
}


public class ExecutorDemo {
	public static void main(String args[]){
		PrintJob jobs[]={ new PrintJob("Asheesh"), 
				        new PrintJob("Rishab"),
				        new PrintJob("Rahul"),
				        new PrintJob("Sumanth"), 
				        new PrintJob("Abinash"), 
				        new PrintJob("Amar")};
		 ExecutorService service= Executors.newFixedThreadPool(3);
		for(PrintJob job:jobs){
			service.submit(job);
		}
		
		System.out.println("Somehow main is proceeding!!");
		
		service.shutdown();
	}
}
