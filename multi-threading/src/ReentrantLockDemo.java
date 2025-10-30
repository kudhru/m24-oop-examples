package module07.multithreading;

import java.util.concurrent.locks.*;

class Display {
	ReentrantLock l=new ReentrantLock();
	public void wish(String name){
		l.lock();
		for(int i=0;i<5;i++){
			System.out.print("Good morning ");
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){}
			System.out.println(name);
		}
		l.unlock();
	}
}

class MyThread1 extends Thread {
	Display d;
	String name;
	MyThread1(Display d1 , String name1){
		d=d1;
		name=name1;
	}
	public void run(){
		d.wish(name);
	}
}

public class ReentrantLockDemo {
	public static void main(String args[]) {
		Display d=new Display();
		MyThread1 t1=new MyThread1( d,"ravi"); 
		 MyThread1 t2=new MyThread1(d,"ram"); 
		t1.start();
		t2.start();
	}

}
