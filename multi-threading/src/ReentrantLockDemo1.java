package module07.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class MyThread2 extends Thread {
	static ReentrantLock l = new ReentrantLock();
	MyThread2(String name){
		super(name);
	}
	public void run(){
	   do{
		try{
			if(l.tryLock(5000,TimeUnit.MILLISECONDS)){
				System.out.println( Thread.currentThread().getName()+"--- got lock.");
				Thread.sleep(30000);
				l.unlock();
				System.out.println( Thread.currentThread().getName()+"--- releases lock.");
				break;
			}
			
			else{
				System.out.println( Thread.currentThread().getName()+" --- unable to get lock and will try again.");
			}
		}
		catch(Exception e) {}
	  }while(true);
	}
}



class ReentrantLockDemo1 {
	public static void main(String args[]){
		MyThread2 t1=new MyThread2("First Thread");
		MyThread2 t2=new MyThread2("Second Thread");
		t1.start();
		t2.start();
	}
}
