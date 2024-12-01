class NormThread extends Thread{ 
	public void start(){        
        //Doesn't invoke run method
		System.out.println("start  method without Super");
	}
	public void run(){
		 System.out.println("run method");
	}
}

class ThreadSuper extends Thread{
	public void start(){            
        //Implemented super.start() to invoke run()
		System.out.println("Start method with Super");
        //calls run() method as it should have without overriding
        super.start();
	}
	public void run(){
		 System.out.println("run method");
	}
}

class OverridingStartMethod{
	public static void main(String args[]){
		NormThread  t = new NormThread();
		t.start();
		System.out.println("main method");
        ThreadSuper t2 = new ThreadSuper();
        t2.start();
	}
}
