import java.util.Scanner;

class MyThread extends Thread{
	public void run(){
        System.out.println("no argument method");
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter an Integer:");
        int x = sc.nextInt();
        run(x);      
        sc.close();  
	}
	public void run(int x){
		 System.out.println("argument method "+x);
	}
}
class OverloadingRunMethod{
	public static void main(String args[]){
		MyThread  t=new MyThread();
		t.start();
	}
}
