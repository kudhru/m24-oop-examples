package module07.multithreading;

import java.util.concurrent.locks.*;
class MyThread3 extends Thread {
	static ReentrantLock l=new ReentrantLock();
	MyThread3(String name){
		super(name);
	}
	public void run(){
		if(l.tryLock()){
			System.out.println( Thread.currentThread().getName()+"--- got lock and performing safe operations.");
			try{
				Thread.sleep(2000);
			}
			catch(Exception e) {}
			l.unlock();
		}
		else {
			 System.out.println( Thread.currentThread().getName()+"--- unable to get lock and hence performing alternative operations.");
		}
	}
}
class ReentrantLockDemo2 {
	public static void main( String args[]) {
		MyThread3 t1=new MyThread3("First Thread");
		MyThread3 t2=new MyThread3("Second Thread");
		t1.start();
		t2.start();
	}
}

