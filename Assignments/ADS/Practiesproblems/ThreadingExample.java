package Practiesproblems;

public class ThreadingExample  extends Thread{

	public void run() {
		System.out.println("Thread Running");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadingExample t = new 	ThreadingExample();
		t.start();
		//t.start();
	}
	
	
}